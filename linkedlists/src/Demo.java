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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Demo {

	private JFrame frmLinkedLists;
	private JTextField fieldFind;
	private JTextField fieldFile;
	private JTextField fieldRemove;
	private JTextField fieldAdd;
	private JTextField fieldStatus;
	private JTextArea txtDisplay;
	private Node head;
	private File openFile;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frmLinkedLists.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Demo() {
		initialize();
	}

	private void initialize() {
		frmLinkedLists = new JFrame();
		frmLinkedLists.setTitle("Linked Lists - Connor Cox");
		frmLinkedLists.setBounds(100, 100, 428, 470);
		frmLinkedLists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLinkedLists.getContentPane().setLayout(null);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isThere(head, fieldRemove)==true){
					String target = fieldRemove.getText();
					Node runner = head;
					Node last = lastNode(head);
					if(last.person.name.equalsIgnoreCase(target)){
						last.prev.next = null;
						last.prev = last;
						fieldStatus.setText(target + " was removed.");
						System.out.println("done");
						return;
					}
					if(target.equalsIgnoreCase(head.person.name)){
						head = runner.next;
						runner.next.prev = runner.prev;
						fieldStatus.setText(target + " was removed.");
						return;
					}
					while (runner != null){
						if(runner.person.toString().equalsIgnoreCase(target)){
							runner.prev.next = runner.next;
							runner.next.prev = runner.prev;
							break;
						}
						runner = runner.next;
					}
					fieldStatus.setText(target + " has been removed.");
				}else{
					fieldStatus.setText("Person Not Found!");
				}
			}
		});
		
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
					        String line;
					        Node runner = null;
					        for(int i = 0; (line = br.readLine()) != null; i++){
					        	if(!line.trim().equals("") && line.charAt(0)!='\''){
					        		if(i == 0){
					        			head = new Node(new Person(line.trim()));
					        			runner = head;
					        		} else{
					        			Node tempNode = new Node(new Person(line));
						        		runner.next = tempNode;
						        		tempNode.prev = runner;
						        		runner = tempNode;
					        		}
					        		
					        	}
					        }
							txtDisplay.setText(printFinal(head));
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
		btnRemove.setBounds(164, 104, 98, 23);
		frmLinkedLists.getContentPane().add(btnRemove);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isThere(head, fieldFind)==true){
					String nameToSearch = fieldFind.getText();
					fieldStatus.setText(nameToSearch + " has been found");
				}else{
					fieldStatus.setText("Not found!");
				}
			}
		});
		
		fieldRemove = new JTextField();
		fieldRemove.setBounds(10, 105, 128, 20);
		frmLinkedLists.getContentPane().add(fieldRemove);
		fieldRemove.setColumns(10);
		btnFind.setBounds(164, 151, 98, 23);
		frmLinkedLists.getContentPane().add(btnFind);
		
		fieldFind = new JTextField();
		fieldFind.setBounds(10, 152, 128, 20);
		frmLinkedLists.getContentPane().add(fieldFind);
		fieldFind.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isThere(head, fieldAdd)==false){
					String targetAdd = fieldAdd.getText();
					Node newb = new Node(new Person(targetAdd));
					newb.next = null;
					Node last = lastNode(head);
					last.next = newb;
					newb.prev = last;
					fieldStatus.setText("Added " + targetAdd + " to end of list!");
				}else{
					fieldStatus.setText("Already on the list!");
				}
			}
		});
		btnAdd.setBounds(164, 53, 98, 23);
		frmLinkedLists.getContentPane().add(btnAdd);
		
		JButton btnAddAfter = new JButton("Add After");
		btnAddAfter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isThere(head, fieldFind)==true){
					String targetAdd = fieldAdd.getText();
					String targetFind = fieldFind.getText();
					Node newb = new Node(new Person(targetAdd));
					Node find = head;
					while(find!=null){
						if(find.person.name.equalsIgnoreCase(targetFind)){
							newb.prev = find;
							newb.next = find.next;
							find.next.prev = newb;
							find.next = newb;
							fieldStatus.setText(targetAdd + " has been added after "+ targetFind);
							break;
						}
						find = find.next;
					}
				}else{
					fieldStatus.setText("Name not found, did not add");
				}
			}
		});
		btnAddAfter.setToolTipText("Adds whatever name in add box after whatever name is in the find box");
		btnAddAfter.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAddAfter.setBounds(272, 151, 130, 36);
		frmLinkedLists.getContentPane().add(btnAddAfter);
		
		fieldAdd = new JTextField();
		fieldAdd.setBounds(10, 62, 128, 20);
		frmLinkedLists.getContentPane().add(fieldAdd);
		fieldAdd.setColumns(10);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printGo(head);
			}
		});
		btnPrint.setBounds(272, 54, 128, 37);
		frmLinkedLists.getContentPane().add(btnPrint);
		
		JButton btnPrintBack = new JButton("Print \r\nBackwards");
		btnPrintBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oGtnirp(head);
			}
		});
		btnPrintBack.setFont(new Font("Dialog", Font.BOLD, 10));
		btnPrintBack.setBounds(272, 107, 128, 37);
		frmLinkedLists.getContentPane().add(btnPrintBack);
		
		JButton btnSave = new JButton("Save File");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(openFile));
					bw.write(printFinal(head));
					bw.close();
					fieldStatus.setText("Saving...");
				} catch (IOException e1) {
					fieldStatus.setText("IO Error!");
				}
			}
		});
		btnSave.setBounds(10, 399, 89, 23);
		frmLinkedLists.getContentPane().add(btnSave);
		
		fieldStatus = new JTextField();
		fieldStatus.setEditable(false);
		fieldStatus.setBounds(10, 368, 307, 20);
		frmLinkedLists.getContentPane().add(fieldStatus);
		fieldStatus.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 199, 305, 157);
		frmLinkedLists.getContentPane().add(scrollPane);
		
		txtDisplay = new JTextArea();
		txtDisplay.setText("Connor Cox");
		scrollPane.setViewportView(txtDisplay);
		txtDisplay.setEditable(false);
	}
	public void printGo(Node start){
		Node r = start;
		String listOfNames = "Printed list:";
		String lineBy;
		while(r != null){
				lineBy= r.toString();
				r = r.next;
				if(lineBy != null){
					listOfNames += "\n" + lineBy;
				}
		}
		
		txtDisplay.setText(listOfNames);
		fieldStatus.setText("Printing...");
	}
	public void oGtnirp(Node start){
		Node last = lastNode(start);
		String listOfNames = "Printed list backwards:";
		String lineBy = null;
		while(last!=null){
			lineBy= last.toString();
			last = last.prev;
			if(lineBy!=null){
				listOfNames += "\n" + lineBy.trim();
			}
		}
		txtDisplay.setText(listOfNames);
		fieldStatus.setText("Printing Backwards...");
	}
	public boolean isThere(Node start, JTextField field){
		String nameToSearch = field.getText();
		Node r = start;
		while(r != null){;
			if(nameToSearch.equalsIgnoreCase(r.person.name)){
				return true;
			}
			r = r.next;
		}
		return false;
	}
	public Node lastNode(Node start){
		Node r = start;
		Node oldR = null;
		while(r != null){
			oldR = r;
			r = r.next;
		}
		r = oldR;
		return r;
	}
	public String printFinal(Node start){
		Node r = start;
		String finish = null;
		String lineBy = null;
		while(r != null){
			lineBy= r.toString();
			if(finish == null){
				finish = lineBy;
			}
			if(lineBy != null && lineBy != finish){
				finish += "\n" + lineBy;
			}
			r = r.next;
		}
		return finish;
	}
}
