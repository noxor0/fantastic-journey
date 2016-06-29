//Connor Cox
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class UserInterface {

	private JFrame frmLinkedLists;
	private JTextField fieldFile;
	private JTextField fieldStatus;
	private JTextArea txtDisplay;
	private File openFile;
	private ArrayList<Person> prsnList = new ArrayList<Person>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmLinkedLists.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserInterface() {					      
		initialize();
	}

	private void initialize() {
		frmLinkedLists = new JFrame();
		frmLinkedLists.setTitle("Generics - Connor Cox");
		frmLinkedLists.setBounds(100, 100, 428, 470);
		frmLinkedLists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLinkedLists.getContentPane().setLayout(null);
		
		final JButton btnSelect = new JButton("...");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(btnSelect);
				fieldFile.setText(jfc.getSelectedFile().getAbsolutePath());
				fieldStatus.setText("Selected a file");
			}
		});
		btnSelect.setBounds(362, 20, 40, 23);
		frmLinkedLists.getContentPane().add(btnSelect);
		
		JButton btnOpen = new JButton("Open File");					      
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile = new File(fieldFile.getText());
				if(fieldFile != null){
					 try(BufferedReader br = new BufferedReader(new FileReader(openFile))) {
						 if(prsnList.size()	!= 0){
							 prsnList.clear();
						 }
				        for(String str; (str= br.readLine()) != null;){
				        	String[] lar = str.split(",");
				        	double scoreParse = Double.parseDouble(lar[2]);
				        	Person loopPerson = new Person(lar[0], lar[1], scoreParse);
				        	prsnList.add(loopPerson);
					        }
					        printList(prsnList);
					        br.close();
					    } catch (IOException e) {
							fieldStatus.setText("Error: No File Found");
						}
				}
				if(fieldFile.getText()!=null){
					fieldStatus.setText("Opening: " + openFile.getName());
				}else{
					fieldStatus.setText("No file selected");
				}
			}
		});
		btnOpen.setBounds(272, 20, 89, 23);
		frmLinkedLists.getContentPane().add(btnOpen);
		
		fieldFile = new JTextField();
		fieldFile.setBounds(10, 21, 252, 20);
		frmLinkedLists.getContentPane().add(fieldFile);
		fieldFile.setColumns(10);
		
		JButton btnSortPrnt = new JButton("Sort and Print");
		btnSortPrnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printList(sortMe(prsnList));
			}
		});
		btnSortPrnt.setBounds(20, 57, 166, 42);
		frmLinkedLists.getContentPane().add(btnSortPrnt);
		
		JButton btnPrintBack = new JButton("Print \r\nBackwards");
		btnPrintBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tsilTnirp(sortMe(prsnList));
			}
		});
		btnPrintBack.setFont(new Font("Dialog", Font.BOLD, 10));
		btnPrintBack.setBounds(206, 58, 166, 42);
		frmLinkedLists.getContentPane().add(btnPrintBack);
		
		fieldStatus = new JTextField();
		fieldStatus.setEditable(false);
		fieldStatus.setBounds(10, 368, 307, 20);
		frmLinkedLists.getContentPane().add(fieldStatus);
		fieldStatus.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 199, 305, 157);
		frmLinkedLists.getContentPane().add(scrollPane);
		
		txtDisplay = new JTextArea();
		scrollPane.setViewportView(txtDisplay);
		txtDisplay.setText("Connor Cox");
		txtDisplay.setEditable(false);
	}
	public void printList(ArrayList<Person> arl){
		String str = null;
		for(Person p : arl){
			if(str == null)str = p.toString() + "\n";
			else str += p.toString() + "\n";
		}
		txtDisplay.setText(str);
	}
	public void tsilTnirp(ArrayList<Person> arlSort){
		String str = null;
		for(int i = arlSort.size()-1; i>=0; i--){
			if(str == null)str = arlSort.get(i).toString() + "\n";
			else str += arlSort.get(i).toString() + "\n";
		}
		txtDisplay.setText(str);
		fieldStatus.setText("Printing Backwards");
	}
	public ArrayList<Person> sortMe(ArrayList<Person> sortMe){
		ArrayList<Person> sortedList = new ArrayList<Person>();
		fieldStatus.setText("Sorting by last name");
		Person[] sortedAr = new Person[prsnList.size()];
		for(int p = 0; p < prsnList.size(); p++){
			sortedAr[p] = prsnList.get(p);
		}
		QuickSort.qs(sortedAr, 0, prsnList.size()-1);
		for(int p = 0; p < sortedAr.length; p++){
			sortedList.add(sortedAr[p]);
		}
		return sortedList;
	}
	
}
