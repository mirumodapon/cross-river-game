import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
class Others extends JPanel {
	Others (int sizeMultiple,ControlPanel c) {
		this.c = c;
		c.setOthers(this);
		setBounds(0,0,16*sizeMultiple,9*sizeMultiple);
		setOpaque(false);
		setLayout(null);
		//setButton(JButton,x,y,w,h)
		setButton(Hints,1035,560,50,50);
		setButton(Reset,1105,560,50,50);
		//setIcon setPressedIcon setRolloverIcon
		Hints.setIcon(HintsIcon);
		Reset.setIcon(ResetIcon);
	}
	private void setButton(JButton b,int x,int y,int w,int h) {
		//button setBorderPainted,setLocation,setSize,setContectAreaFilled
		b.setBorderPainted(false);
		b.setLocation(x,y);
		b.setSize(w,h);
		b.setContentAreaFilled(false);
		b.addActionListener(new btnListen());
		add(b);
	}
	public class btnListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if (btn==Hints) {
				c.direction();
			} else if (btn==Reset) {
				c.reset();
			}
		}
	}
	private String HintsStr = "source file/Hint.png";
	private String ResetStr = "source file/reset.png";
	private ImageIcon HintsIcon = new ImageIcon(new ImageIcon(getClass().getResource(HintsStr)).getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	private ImageIcon ResetIcon = new ImageIcon(new ImageIcon(getClass().getResource(ResetStr)).getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	private JButton Hints = new JButton();
	private JButton Reset = new JButton();
	private ControlPanel c;
	
}

class Pane extends JPanel {
	Pane (int sizeMultiple,ControlPanel c) {
		c.setPane(this);
		setVisible(false);
		setOpaque(false);
		//setBounds
		setBounds(0,0,16*sizeMultiple,9*sizeMultiple);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Switch==0) {
		g.setColor(Color.RED);
		g.setFont(new Font("Serief",Font.BOLD,72));
		g.drawString("Game Over",450,300);
		}
		if (Switch==1) {
		g.setColor(Color.RED);
		g.setFont(new Font("Serief",Font.BOLD,72));
		g.drawString("Win",525,300);
		}
		if (Switch==2) {
		g.drawImage(img,545,25,600,400,this);
		g.drawImage(fimg,148,335,500,500,this);
		
		}
	}
	public void gameover () {
		Switch=0;
		repaint();
		setVisible(true);
	}
	public void win () {
		Switch=1;
		repaint();
		setVisible(true);
	}
	public void dir () {
		if (Switch==2&&isVisible()) {
			setVisible(false);
		} else {
		Switch=2;
		repaint();
		setVisible(true);
		}
	}
	private Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/daii.png"));
	private Image fimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/framer.png"));
	private int Switch;
}