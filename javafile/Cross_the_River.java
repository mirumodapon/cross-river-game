import javax.swing.JFrame;
import javax.swing.JLayeredPane;

class Cross_the_River {
	static JFrame frm;
	static JLayeredPane layer;
	//declare the object
	static int sizeMultiple;
	static ControlPanel control;
	static Background background;
	static River river;
	static dog_chicken_rice dcr;
	static Pane pane;
	static Others others;
	
	Cross_the_River() {
		frm = new JFrame("Cross the River");
		layer = new JLayeredPane();
		sizeMultiple = 75;
		control = new ControlPanel();
		background = new Background(sizeMultiple,control);
		river = new River(sizeMultiple,control);
		dcr = new dog_chicken_rice(sizeMultiple,control);
		pane = new Pane(sizeMultiple,control);
		others = new Others(sizeMultiple,control);
	}
	
	public static void main (String[] args) {
		new Cross_the_River();
		//set frm size
		frm.setSize(16*sizeMultiple,9*sizeMultiple);
		//layer add object
		layer.add(background,new Integer(0));
		layer.add(dcr,new Integer(5));
		layer.add(others,new Integer(20));
		layer.add(river,new Integer(10));
		layer.add(pane,new Integer(30));
		//set frm resizable false
		frm.setResizable(false);
		//set frm closing option
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
		//set frm contentpane as layer
		frm.setContentPane(layer);
		//set frm visible
		frm.setVisible(true);
	}
	
}