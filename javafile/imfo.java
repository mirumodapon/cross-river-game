import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;

class Imfo {
	Imfo(String path1,String path2) {
		img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(path1));
		//set size yet
		imgIcon = new ImageIcon(new ImageIcon(getClass().getResource(path2)).getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
		Where = true;
	}
	public void setWhere (boolean Where) {
		this.Where = Where;
	}
	public Image getImg () {
		return this.img;
	}
	public ImageIcon getImageIcon () {
		return this.imgIcon;
	}
	public boolean getWhere () {
		return this.Where;
	}
	public void setX (int _X) {
		X = _X;
	}
	public void setY(int _Y) {
		Y = _Y;
	}
	public int getX () {
		return X;
	}
	public int getY () {
		return Y;
	}
	private boolean Where;
	private Image img;
	private ImageIcon imgIcon;
	private int X = 0;
	private int Y = 0;
}