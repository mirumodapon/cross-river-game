
class ControlPanel {
	ControlPanel() {
		
	}
	public void setBackground (Background b) {
		this.b = b;
	}
	public void setdog_chicken_rice (dog_chicken_rice dcr) {
		this.dcr = dcr;
	}
	public void setOthers (Others o) {
		this.o = o;
	}
	public void setPane (Pane d) {
		this.d = d;
	}
	public void setRiver (River r) {
		this.r = r;
	}
	public void reset () {
		dcr.reset();
		d.setVisible(false);
		
	}
	public void win () {
		d.win();
	}
	public void gameover () {
		d.gameover();
	}
	public void direction () {
		d.dir();
	}
	
	private static Background b;
	private static dog_chicken_rice dcr;
	private static Others o;
	private static Pane d;
	private static River r;
}