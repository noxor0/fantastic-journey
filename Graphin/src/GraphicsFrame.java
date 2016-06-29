//Connor Cox, Last assignment
import java.awt.*;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GraphicsFrame extends JFrame {
	double xmin,xmax,ymin,ymax;
	double xp,yp = 0;
	private Graphics g;
	private JPanel contentPane;
	private int w,h;
	private boolean isSkip = false;
	Function f;
	int foo;
	
	public GraphicsFrame(Function f,int foo) {
		xmin = -10;
		ymin = -10;
		xmax = 10;
		ymax = 10;
		this.foo = foo;
		this.f = f;
		setUp();
	}
	public GraphicsFrame(Function f, double xmin, double xmax, double ymin, double ymax, int foo) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.f = f;
		this.foo = foo;
		setUp();
	}
	private void setUp(){
		setTitle("Graph");
		setBounds(100, 100, 450, 300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new GPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
		
	private class GPanel extends JPanel{ //i can make them all graph on the same, just seems like
		//stupid amount of extra work
		public void paint(Graphics gg){
			w = this.getWidth();
			h = this.getHeight();
			g = gg;
//			setup 
			double tic = 4*(xmax-xmin)/w;
			mov(xmin,0);
			drw(xmax,0, true);
			for(double x= xmin; x<=xmax; x+=1.0){
				mov(x,tic);
				drw(x,-tic,true);
			}
			mov(0,ymin);
			drw(0,ymax,true);
			for(double y= ymin; y<=ymax; y+=1.0){
				mov(tic,y);
				drw(-tic,y,true);
			}
//			expo			
			if(foo == 0){
				skip();
				for(double x = xmin;x<=xmax;x+=(xmax - xmin)/w){
					drw(x,f.expo(x),false);
				}
			}
//			sine
			if(foo == 1){
				skip();
				for(double x = xmin;x<=xmax;x+=(xmax - xmin)/w){
					drw(x,f.sine(x),false);
				}
			}
//			poly
			if(foo == 2){
				skip();
				for(double x = xmin;x<=xmax;x+=(xmax - xmin)/w){
					drw(x,f.poly(x),false);
				}
			}	
		}
	}
	public void drw(double x, double y, boolean isBlack){ // draw from current to args
		if(isBlack == true){
			g.setColor(new Color(0,0,0));
		}else{
			g.setColor(new Color(0,25,150));
		}
		if(!isSkip)g.drawLine(xs(xp), ys(yp), xs(x), ys(y));
		isSkip = false;
		xp = x;
		yp = y;
	}
	public void skip(){
		isSkip = true;
	}
	public void mov(double x, double y){
		xp = x;
		yp = y;
	}
	public int xs(double x){
		double p = (x-xmin)/(xmax-xmin);
		return (int)(p*w);
	}
	public int ys(double y){
		double p =  1.0 - (y-ymin)/(ymax-ymin);
		return (int)(p*h);
	}
}
