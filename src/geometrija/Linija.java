package geometrija;

import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka tPocetna;
	private Tacka tKrajnja;

	public Linija(){

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja,String boja){
		this(tPocetna,tKrajnja);
		setBoja(boja);
	}
	public void pomeriZa(int poX, int poY){
		tPocetna.setX(tPocetna.getX()+poX);
		tPocetna.setY(tPocetna.getY()+poY);
		tKrajnja.setX(tKrajnja.getX()+poX);
		tKrajnja.setY(tKrajnja.getY()+poY);
	}
	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}
	// (xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	public String toString(){
		return tPocetna+"-->"+tKrajnja;
	}

	public boolean equals(Object obj){
		if(obj instanceof Linija){
			Linija pomocna=(Linija)obj;
			if(this.tPocetna.equals(pomocna.tPocetna)&&this.tKrajnja.equals(pomocna.tKrajnja))
				return true;
			else
				return false;
		}
		return false;
	}
	public boolean sadrzi(int x, int y){
		Tacka pomocna = new Tacka(x, y);
		if(pomocna.udaljenost(tPocetna)+pomocna.udaljenost(tKrajnja)-duzina()<=0.5)
			return true;
		else
			return false;
	}
	public void selektovan(Graphics g){
		g.setColor(pronadjiBoju("plava"));
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
	}
	public void crtajSe(Graphics g) {
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getBojaIv());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}
	public int compareTo(Object o) {
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int)this.duzina()-(int)pomocna.duzina();
		}
		else 
			return 0;
	}

	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka novatPocetna){
		tPocetna = novatPocetna;
	}
	public void settKrajnja(Tacka novatKrajnja){
		tKrajnja = novatKrajnja;
	}

}
