//Connor Cox, Dog Server Assignment. May 25-30, 2015
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;

public class DogClient {
	private static String DEFAULT_HOST = "localhost";
	private static int DEFAULT_PORT = 1433;
	static PrintWriter outStream;
	static BufferedReader inStream;

	public static void main(String[] args) {
		//SocketsDemoClient client = new SocketsDemoClient();
		try {
			Socket socket = new Socket(InetAddress.getByName(DEFAULT_HOST), DEFAULT_PORT);
			System.out.println("Client socket on client side: " + Integer.toHexString(socket.hashCode())); //print debug info
			outStream = new PrintWriter(socket.getOutputStream(), true);
			inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			try {
				while (true) { //START HERE
					String reply = inStream.readLine();
					while (reply == null) {
					};
					if(reply.equals("RevisedDogServer")) {
						int cont = JOptionPane.showConfirmDialog(null, "Server said: " + reply, "ClientPOV", JOptionPane.OK_OPTION);
						if(cont == 0){
							sendMsg("GetFileList");
						} else {
							socket.close();
						}
					}
					if(!reply.equals("RevisedDogServer")){
						JTextArea msg = new JTextArea(reply);
						msg.setLineWrap(true);
						msg.setWrapStyleWord(true);
						msg.setSize(400,600);
						JScrollPane scrollPane = new JScrollPane(msg);
						String toBeKilled = JOptionPane.showInputDialog(null, scrollPane, "ClientPOV", JOptionPane.INFORMATION_MESSAGE);
						sendMsg(toBeKilled);
					}
				}
			}
			catch (IOException ioex)
			{
				System.err.println("IO exception occured in the client action:");
				ioex.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	public static void sendMsg(String message){
		String notify = "Sending: "+ message;
		int ans = JOptionPane.showConfirmDialog(null, notify, "ClientPOV", JOptionPane.OK_OPTION);
		if(ans == 0){
			outStream.println(message);
			outStream.flush();
		}
	}
}
