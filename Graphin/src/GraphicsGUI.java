//Connor Cox, Last assignment
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GraphicsGUI {

	private JFrame frmConnorCox;
	private JButton btnGraph;
	private JTextField txtXMin;
	private JTextField txtXMax;
	private JTextField txtYMin;
	private JTextField txtYMax;
	private JTextField txtPoly;
	private JTextField txtExpo;
	private JTextField txtDunno;
	private JLabel lblFunction;
	private JTextField txtFunc;
	private JLabel lblsi;
	private JTextField txtSinOne;
	private JLabel lblx_1;
	private JTextField txtSinPlus;
	private JLabel label;
	private JTextArea txtCoe;
	public JCheckBox chkExpo, chkSine, chkPoly; 

	double uxMax, uyMax, uxMin, uyMin;
	double uPoly; double[] coeArray = new double[10];
	double uExpo, ueTimes; 
	double utimesSin, uinSin, uPhase;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicsGUI window = new GraphicsGUI();
					window.frmConnorCox.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraphicsGUI() {
		initialize();
	}

	private void initialize() {
		frmConnorCox = new JFrame();
		frmConnorCox.setTitle("Connor Cox - Graphing");
		frmConnorCox.setResizable(true);
		frmConnorCox.setBounds(100, 100, 668, 320);
		frmConnorCox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnorCox.getContentPane().setLayout(null);
		
		chkSine = new JCheckBox("Graph this!");
		chkSine.setBounds(525, 221, 129, 23);
		frmConnorCox.getContentPane().add(chkSine);
				
		chkExpo = new JCheckBox("Graph this!");
		chkExpo.setBounds(525, 173, 129, 23);
		frmConnorCox.getContentPane().add(chkExpo);

		chkPoly = new JCheckBox("Graph this!");
		chkPoly.setBounds(525, 123, 129, 23);
		frmConnorCox.getContentPane().add(chkPoly);
	
		btnGraph = new JButton("Graph it");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				uxMax = Double.parseDouble(txtXMax.getText());
				uyMax = Double.parseDouble(txtYMax.getText());
				uxMin = Double.parseDouble(txtXMin.getText());
				uyMin = Double.parseDouble(txtYMin.getText());
				uExpo = Double.parseDouble(txtExpo.getText());
				ueTimes = Double.parseDouble(txtDunno.getText());
				utimesSin = Double.parseDouble(txtFunc.getText());
				uinSin = Double.parseDouble(txtSinOne.getText());
				uPhase = Double.parseDouble(txtSinPlus.getText());
				uPoly = Double.parseDouble(txtPoly.getText());
				if(chkPoly.isSelected() == true){
					int i = 1;
					for (String line : txtCoe.getText().split("\n")){
						if(line != null){
							double d = Double.parseDouble(line);	
							coeArray[i++] = d;
						}
					}
				}
				
				if(chkExpo.isSelected() == true){
					double[] exAr = {uExpo ,ueTimes};
					doThis(exAr, 0);
				}
				if(chkSine.isSelected() == true){
					double[] sineAr = {utimesSin, uinSin, uPhase};
					doThis(sineAr, 1);
				}
				if(chkPoly.isSelected() == true){
					coeArray[0]= Double.parseDouble(txtPoly.getText());
					doThis(coeArray, 2);
				}
				
			}
		});
		btnGraph.setBounds(464, 26, 167, 51);
		frmConnorCox.getContentPane().add(btnGraph);
				
		txtXMin = new JTextField();
		txtXMin.setText("-10");
		txtXMin.setBounds(146, 26, 101, 23);
		frmConnorCox.getContentPane().add(txtXMin);
		txtXMin.setColumns(10);
		
		txtXMax = new JTextField();
		txtXMax.setText("10");
		txtXMax.setColumns(10);
		txtXMax.setBounds(259, 26, 101, 23);
		frmConnorCox.getContentPane().add(txtXMax);
		
		txtYMin = new JTextField();
		txtYMin.setText("-10");
		txtYMin.setColumns(10);
		txtYMin.setBounds(146, 67, 101, 23);
		frmConnorCox.getContentPane().add(txtYMin);
		
		txtYMax = new JTextField();
		txtYMax.setText("10");
		txtYMax.setColumns(10);
		txtYMax.setBounds(259, 67, 101, 23);
		frmConnorCox.getContentPane().add(txtYMax);
		
		txtPoly = new JTextField();
		txtPoly.setText("0");
		txtPoly.setBounds(153, 123, 64, 23);
		frmConnorCox.getContentPane().add(txtPoly);
		txtPoly.setColumns(10);
		
		txtExpo = new JTextField();
		txtExpo.setText("2");
		txtExpo.setBounds(116, 175, 101, 18);
		frmConnorCox.getContentPane().add(txtExpo);
		txtExpo.setColumns(10);
		
		txtDunno = new JTextField();
		txtDunno.setText("1");
		txtDunno.setBounds(271, 175, 74, 20);
		frmConnorCox.getContentPane().add(txtDunno);
		txtDunno.setColumns(10);
		
		txtFunc = new JTextField();
		txtFunc.setText("2");
		txtFunc.setBounds(116, 223, 101, 20);
		frmConnorCox.getContentPane().add(txtFunc);
		txtFunc.setColumns(10);
		
		txtSinOne = new JTextField();
		txtSinOne.setText("1");
		txtSinOne.setBounds(271, 221, 55, 23);
		frmConnorCox.getContentPane().add(txtSinOne);
		txtSinOne.setColumns(10);
		
		txtSinPlus = new JTextField();
		txtSinPlus.setText("2");
		txtSinPlus.setBounds(368, 223, 124, 18);
		frmConnorCox.getContentPane().add(txtSinPlus);
		txtSinPlus.setColumns(10);
		
		txtCoe = new JTextArea();
		txtCoe.setText("1");
		txtCoe.setToolTipText("Each line indicates a new coefficent");
		txtCoe.setRows(5);
		txtCoe.setWrapStyleWord(true);
		txtCoe.setBounds(314, 99, 90, 64);
		frmConnorCox.getContentPane().add(txtCoe);
		
		//Labels------------------------------------------------------
		
		JLabel lblYminYmax = new JLabel("ymin, ymax");
		lblYminYmax.setBounds(10, 53, 118, 50);
		frmConnorCox.getContentPane().add(lblYminYmax);
		
		JLabel lblXminXmax = new JLabel("xmin, xmax");
		lblXminXmax.setBounds(10, 12, 118, 50);
		frmConnorCox.getContentPane().add(lblXminXmax);
		
		JLabel lblCoefficents = new JLabel("Coefficents");
		lblCoefficents.setBounds(217, 109, 90, 50);
		frmConnorCox.getContentPane().add(lblCoefficents);
		
		JLabel lblPolynomialDegree = new JLabel("Polynomial Degree");
		lblPolynomialDegree.setToolTipText("Probably not exactly what you want");
		lblPolynomialDegree.setBounds(10, 109, 139, 50);
		frmConnorCox.getContentPane().add(lblPolynomialDegree);
		
		JLabel lblExponents = new JLabel("Exponents");
		lblExponents.setBounds(10, 159, 101, 50);
		frmConnorCox.getContentPane().add(lblExponents);
		
		JLabel lblWhatever = new JLabel("*e^(");
		lblWhatever.setBounds(227, 159, 46, 50);
		frmConnorCox.getContentPane().add(lblWhatever);
		
		JLabel lblx = new JLabel("*x)");
		lblx.setBounds(354, 159, 64, 50);
		frmConnorCox.getContentPane().add(lblx);
		
		lblFunction = new JLabel("Sine Function:");
		lblFunction.setBounds(10, 207, 101, 50);
		frmConnorCox.getContentPane().add(lblFunction);
		
		lblsi = new JLabel("*sin(");
		lblsi.setBounds(232, 208, 41, 50);
		frmConnorCox.getContentPane().add(lblsi);
		
		lblx_1 = new JLabel("*x+ ");
		lblx_1.setBounds(333, 223, 49, 18);
		frmConnorCox.getContentPane().add(lblx_1);
		
		label = new JLabel(")");
		label.setBounds(495, 207, 16, 50);
		frmConnorCox.getContentPane().add(label);
	}
	
	public void doThis(double[] arr, int foo){
		Function f = new Function(arr);
		GraphicsFrame gf =  new GraphicsFrame(f, uxMin, uxMax, uyMin, uyMax, foo);
		gf.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent arg0) {
				Rectangle b = arg0.getComponent().getBounds();
			    arg0.getComponent().setBounds(b.x, b.y, b.width, b.width);
			}
		});
		gf.setBounds(125, 125, 600, 450);
		gf.setVisible(true);
	}
}
