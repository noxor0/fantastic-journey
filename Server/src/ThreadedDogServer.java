//Connor Cox, Dog Server Assignment. May 25-30, 2015

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class ThreadedDogServer {
	private static File dir;
	static PrintStream out;
	static BufferedReader in;
	static ServerSocket servsock;
	public static void main(String a[]) throws IOException {
		int port;
//		String rep = JOptionPane.showInputDialog("Enter Port number");
//		port = Integer.parseInt(rep);
		port = 1433;
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setDialogTitle("Choose a directory");
		int reply = jfc.showSaveDialog(null);
		dir = new File(jfc.getSelectedFile().getAbsolutePath());
		if (reply != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "User did not chose directory");
			System.exit(1);
		}
		Socket sock = null;
		servsock = new ServerSocket(port);
		JOptionPane.showMessageDialog(null,"Server started at " + now("yyyy.MM.dd 'at' hh:mm:ss z") + " on port "+ port);
		while (true) { 
			sock=servsock.accept();
			new ClientHandler(sock).start();
		}
	}

	private static class ClientHandler extends Thread {
		private Socket client = null;
		
		ClientHandler(Socket client) {
			this.client = client;	
		}

		public void run() {
			try {
				System.out.println("Client at" + client.getInetAddress());
				out = new PrintStream( client.getOutputStream() );
				in  = new BufferedReader(new InputStreamReader( client.getInputStream()));
				sendMsg("RevisedDogServer");
				while (true) { //START HERE
					String reply = in.readLine();
					if (reply.equals("quit")) break;
					String list = "File List: ";
					if (reply.equals("GetFileList")){
						for(File fileEntry : dir.listFiles()){
							list += fileEntry.getName() + " " ;
						}
						list += "<end>";
						out.println(list);
						out.flush();
					}
					if(reply != "GetFileList"){
						String tbk = reply;
						for(File fileEntry : dir.listFiles()){
							if(fileEntry.getName().equalsIgnoreCase(tbk)){
								fileEntry.delete();	
								sendMsg("RevisedDogServer");
							}
						}
					}
				}
				client.close();
			} catch(IOException e) {
				System.out.println("Missed client.");
			}
		}
		
	}
	
	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}
	
	public static void sendMsg(String message){
		String notify = "Sending: " + message;
			out.println(message);
			out.flush();
	}
}

