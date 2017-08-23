package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	protected String bojaUnutrasnjosti;
	protected String bojaIvice;
	private Color bojaUn = Color.WHITE;
	
	public abstract void popuni(Graphics g);

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	public String getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIVice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}
	public Color getBojaUn(){
		return bojaUn;
	}
	
	public void setBojaUn(Color bojaUn) {
		this.bojaUn = bojaUn;
	}
}
