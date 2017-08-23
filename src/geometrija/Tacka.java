package geometrija;

import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;


	public Tacka(){

	}
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, String boja){
		this(x,y);
		setBoja(boja);
	}
	public double udaljenost(Tacka druga){
		int dx = x - druga.x;
		int dy = this.y - druga.y;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	public void pomeriNa(int novoX, int novoY){
		x = novoX;
		y = novoY;
	}
	public void pomeriZa(int poX, int poY){
		x = x + poX;
		y = y + poY;
	}


	// (x,y)
	public String toString(){
		return "("+x+", "+y+")";
	}

	public boolean equals(Object obj){
		if(obj instanceof Tacka){
			Tacka pomocna=(Tacka)obj;
			if(this.x==pomocna.getX() &&  this.y==pomocna.y)	
				return true;
			else
				return false;
		}
		return false;	
	}
	public boolean sadrzi(int x, int y){
		Tacka pomocna = new Tacka(x, y);
		if(pomocna.udaljenost(this)<=2)
			return true;
		else
			return false;	
	}
	public void selektovan(Graphics g){
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(x-3, y-3, 6, 6);
	}
	public void crtajSe(Graphics g) {
		g.setColor(pronadjiBoju(getBoja()));
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelektovan())
			selektovan(g);
	}

	public int compareTo(Object o) {
		if(o instanceof Tacka){
			Tacka nula = new Tacka(0, 0);
			Tacka druga = (Tacka) o;
			return (int) (this.udaljenost(nula) - druga.udaljenost(nula));

		}
		return 0;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int novoX){
		x = novoX;
	}
	public void setY(int novoY){
		y = novoY;
	}


}
