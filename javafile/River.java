import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;

class River extends JPanel {
	River (int sizeMultiple,ControlPanel c) {
		c.setRiver(this);
		setSize(16*sizeMultiple,9*sizeMultiple);
		setOpaque(false);
	}
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(river,0,0,this.getWidth(),this.getHeight(),this);
	}

	private Image river = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/River.png"));
	
}