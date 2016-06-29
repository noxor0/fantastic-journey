//Connor Cox - Assignment 4
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Assignment4GUI {

	private JFrame frmLinkedLists;
	private JTextField fieldFile;
	private JTextField fieldStatus;
	private JTextArea txtDisplay;
	private File openFile;
	private JTextField fieldNumb;
	private JTextField fieldName;
	private JTextField txtNumb;
	private JTextField txtName;
	private HashMap<String, String> hm = new HashMap<String, String>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment4GUI window = new Assignment4GUI();
					window.frmLinkedLists.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Assignment4GUI() {					      
		initialize();
	}

	private void initialize() {
		frmLinkedLists = new JFrame();
		frmLinkedLists.setTitle("Assignment 4 - Connor Cox");
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
						 if(hm.isEmpty() == false){
							 hm.clear();
						 }
				        for(String str; (str= br.readLine()) != null;){
				        	String[] lar = str.split(",");
				        	String name = lar[0].trim();
				        	String number = lar[1].trim();
				        	hm.put(name, number);
					        }
				        br.close();
				        display(hm);
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
		fieldFile.setText("/home/noxor/std.txt");
		fieldFile.setBounds(10, 21, 252, 20);
		frmLinkedLists.getContentPane().add(fieldFile);
		fieldFile.setColumns(10);
		
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
		
		fieldName = new JTextField();
		fieldName.setBounds(12, 69, 176, 20);
		frmLinkedLists.getContentPane().add(fieldName);
		fieldName.setColumns(10);
		
		fieldNumb = new JTextField();
		fieldNumb.setBounds(10, 111, 178, 20);
		frmLinkedLists.getContentPane().add(fieldNumb);
		fieldNumb.setColumns(10);
		
		final JButton btnAdd = new JButton("Add Name + Number");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = fieldName.getText();
				String number = fieldNumb.getText();
				if(!hm.containsKey(name)){
					if(!fieldName.getText().isEmpty()){
						hm.put(name,number);
						display(hm);
						fieldStatus.setText("Adding " + name);
					} else {
						fieldStatus.setText("Please enter a name");
					}
				} else{
					fieldStatus.setText("Duplicate found, not added");
					JOptionPane.showMessageDialog(btnAdd, "Duplicate found");
				}
			}
		});
		btnAdd.setBounds(198, 54, 163, 23);
		frmLinkedLists.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Entry by Name");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String niq = fieldName.getText();
				if(hm.containsKey(niq)){
					hm.remove(niq);
					display(hm);
				} else{
					fieldStatus.setText("Name not found!");
				}
			}
		});
		btnRemove.setBounds(198, 82, 163, 23);
		frmLinkedLists.getContentPane().add(btnRemove);
		
		JButton btnSearch = new JButton("Search By Name");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String niq = fieldName.getText();
				if(hm.containsKey(niq)){
					String niqNumb = niq + "'s number is: " + hm.get(niq);
					txtDisplay.setText(niqNumb);
					fieldStatus.setText("Searching...");
				}else{
					fieldStatus.setText("Name not found!");
				}
			}
		});
		btnSearch.setBounds(198, 110, 163, 23);
		frmLinkedLists.getContentPane().add(btnSearch);
		
		JButton btnDisplay = new JButton("Refresh and Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display(hm);
			}
		});
		btnDisplay.setBounds(198, 135, 163, 23);
		frmLinkedLists.getContentPane().add(btnDisplay);
		
		txtNumb = new JTextField();
		txtNumb.setEditable(false);
		txtNumb.setText("Number");
		txtNumb.setBounds(10, 96, 86, 20);
		frmLinkedLists.getContentPane().add(txtNumb);
		txtNumb.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setText("Name");
		txtName.setBounds(10, 55, 86, 20);
		frmLinkedLists.getContentPane().add(txtName);
		txtName.setColumns(10);
	}
	@SuppressWarnings("rawtypes")
	public void display(HashMap<String, String> hm){
		Set set = hm.entrySet();
	    Iterator i = set.iterator();
	    String tbd = "PhoneBook \n";
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         tbd += me.getKey() + ": " + me.getValue() + "\n";
	      }
	      txtDisplay.setText(tbd);
	}
}
