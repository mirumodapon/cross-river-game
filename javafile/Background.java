import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;

class Background extends JPanel {
	Background (int sizeMultiple,ControlPanel c) {
		c.setBackground(this);
		setSize(16*sizeMultiple,9*sizeMultiple);
	}
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(background1,0,0,this.getWidth(),this.getHeight(),this);
		g.drawImage(background2,0,0,this.getWidth(),this.getHeight(),this);
		g.drawImage(background3,0,0,this.getWidth(),this.getHeight(),this);
	}

	private Image background1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/Background.png"));
	private Image background2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/Sun.png"));
	private Image background3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/Could.png"));
}