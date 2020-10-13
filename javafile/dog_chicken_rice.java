import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;
//import java.awt.event.InterruptedException;

class dog_chicken_rice extends JPanel implements Runnable {
	dog_chicken_rice(int sizeMultiple,ControlPanel c) {
		c.setdog_chicken_rice(this);
		this.c = c;
		setBounds(0,0,16*sizeMultiple,9*sizeMultiple);
		setLayout(null);
		setOpaque(false);
		t = new Thread(this);
		reset();
		/*/ set position
		Rice.setX(15);
		Rice.setY(375);
		Chicken.setX(100);
		Chicken.setY(375);
		Dog.setX(185);
		Dog.setY(375);
		//set the label. setBounds. setImageIcon. addMouseListener
		DogSticker.setBounds(75,10,100,100);
		ChickenSticker.setBounds(75,95,100,100);
		RiceSticker.setBounds(75,180,100,100);
		NULL.setBounds(75,265,100,100);*/
		DogSticker.setIcon(Dog.getImageIcon());
		ChickenSticker.setIcon(Chicken.getImageIcon());
		RiceSticker.setIcon(Rice.getImageIcon());
		NULL.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("source file/NULL.png")).getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT)));
		DogSticker.addMouseListener(new chicks());
		ChickenSticker.addMouseListener(new chicks());
		RiceSticker.addMouseListener(new chicks());
		NULL.addMouseListener(new chicks());
		add(DogSticker);
		add(ChickenSticker);
		add(RiceSticker);
		add(NULL);		
		t.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draw the image
		g.drawImage(Rice.getImg(),Rice.getX(),Rice.getY(),100,100,this);
		g.drawImage(Chicken.getImg(),Chicken.getX(),Chicken.getY(),100,100,this);
		g.drawImage(farmerImage,posX,posY,200,200,this);
		g.drawImage(Dog.getImg(),Dog.getX(),Dog.getY(),100,100,this);
		}
	public void run () {
		//thread run for animate
		while (true) {
		if (LimitMouse&&!gameover) {
			move();
			updateImfo();
		} else if (animateSwitch) {
			move();
			animateSwitch = false;
		} try {Thread.sleep(100);} catch (InterruptedException e) {};}
	}
	private void move () {
		if (posX<500) {
				for ( ;posX<=720;posX+=7) {
					if (moving!=null)
					moving.setX(posX-8);
					super.repaint();
					try {Thread.sleep(40);} catch (InterruptedException e) {};
				}
			} else {
				for ( ;posX>=345;posX-=7) {
					if (moving!=null)
					moving.setX(posX-8);
					super.repaint();
					try {Thread.sleep(40);} catch (InterruptedException e) {};
				}
			}
	}
	private void updateImfo() {
		//update Imfo of which is chicked
		if (moving==Dog) {
			Dog.setX((!Dog.getWhere())? 185:1100);
			DogSticker.setBounds(((!Dog.getWhere())? 75:1025),10,100,100);
			
		} else if (moving==Chicken) {
			Chicken.setX((!Chicken.getWhere())? 100:1015);
			ChickenSticker.setBounds(((!Chicken.getWhere())? 75:1025),95,100,100);
			
		} else if (moving==Rice) {
			Rice.setX((!Rice.getWhere())? 15:930);
			RiceSticker.setBounds(((!Rice.getWhere())? 75:1025),180,100,100);
			
		}
		repaint();
		if (moving!=null) {
			moving.setWhere(!moving.getWhere());
			moving.setY(375);
		}
		RiceSticker.setVisible(!((posX<500)^Rice.getWhere()));
		ChickenSticker.setVisible(!((posX<500)^Chicken.getWhere()));
		DogSticker.setVisible(!((posX<500)^Dog.getWhere()));
		NULL.setBounds(((posX>500)? 1025:75),265,100,100);
		
		moving=null;
		LimitMouse = false;
		gameover = Deter();
		
	}
	private boolean Deter () {
		if (!(Dog.getWhere()^Chicken.getWhere())&&((posX<500)^Chicken.getWhere())) {
			Dog_eat_Chicken();
			return true;
		} else if (!(Rice.getWhere()^Chicken.getWhere())&&((posX<500)^Chicken.getWhere())) {
			Chicken_eat_Rice();
			return true;
		} else if ((!Rice.getWhere())&&(!Chicken.getWhere())&&(!Dog.getWhere())) {
			c.win();
			LimitMouse = true;
			return true;
		} else return false;
	}
	private void Dog_eat_Chicken () {
		for ( ;Dog.getX()>=Chicken.getX(); ) {
			Dog.setX(Dog.getX()-5);
			repaint();
			try {Thread.sleep(40);} catch (InterruptedException e) {};
		}
		Chicken.setY(700);
		c.gameover();
		LimitMouse = true;
		repaint();
	}
	private void Chicken_eat_Rice () {
		for ( ;Chicken.getX()>=Rice.getX(); ) {
			Chicken.setX(Chicken.getX()-5);
			repaint();
			try {Thread.sleep(40);} catch (InterruptedException e) {};
		}
		Rice.setY(700);
		c.gameover();
		LimitMouse = true;
		repaint();
	}
	public void reset () {
		//reset
		posX = 345;
		Rice.setX(15);
		Rice.setY(375);
		Chicken.setX(100);
		Chicken.setY(375);
		Dog.setX(185);
		Dog.setY(375);
		Dog.setWhere(true);
		Chicken.setWhere(true);
		Rice.setWhere(true);
		LimitMouse = false;
		gameover = false;
		DogSticker.setBounds(75,10,100,100);
		ChickenSticker.setBounds(75,95,100,100);
		RiceSticker.setBounds(75,180,100,100);
		DogSticker.setVisible(true);
		ChickenSticker.setVisible(true);
		RiceSticker.setVisible(true);
		NULL.setBounds(((posX>500)? 1025:75),265,100,100);
		repaint();
	}
	public class chicks extends MouseAdapter {
		public void mousePressed (MouseEvent e) {
			if (!LimitMouse) {
				JLabel i = (JLabel)e.getSource();
				//detered which label is chicked
				if (i==DogSticker) {
					Dog.setX(posX-8);
					Dog.setY(posY+40);
					moving = Dog;
				} else if (i==ChickenSticker) {
					Chicken.setX(posX-8);
					Chicken.setY(posY+40);
					moving = Chicken;
				} else if (i==RiceSticker) {
					Rice.setX(posX-8);
					Rice.setY(posY+40);
					moving = Rice;
				} else if (i==NULL) {
					
				}
				LimitMouse = true;
				repaint();
			}
		}
		
	}
	private Imfo Dog = new Imfo("source file/Dog.png","source file/DogStrick.png");
	private Imfo Chicken = new Imfo("source file/Chicken.png","source file/ChickenStrick.png");
	private Imfo Rice = new Imfo("source file/Rice.png","source file/RiceStrick.png");
	
	private JLabel DogSticker = new JLabel();
	private JLabel ChickenSticker = new JLabel();
	private JLabel RiceSticker = new JLabel();
	private JLabel NULL = new JLabel();
	
	private boolean LimitMouse = false;
	private static Imfo moving = null;
	private static boolean gameover = false;
	private static boolean animateSwitch = false;
	private Thread t;
	
	private Image farmerImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("source file/framer.png"));
	private int posX = 345;
	private final int posY = 350;
	
	private ControlPanel c;
}

