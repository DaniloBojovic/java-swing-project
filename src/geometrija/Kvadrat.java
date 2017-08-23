package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice) {
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice,String boja) {
		this(goreLevo, duzinaStranice);
		setBoja(boja);
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, String bojaUnutrasnjosti, String bojaIvice){
		this(goreLevo, duzinaStranice);
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
		this.bojaIvice = bojaIvice;
		
	}

	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}

	public void pomeriZa(int x, int y) {
		goreLevo.pomeriZa(x, y);
	}

	public int povrsina() {
		return duzinaStranice * duzinaStranice;
	}

	public int obim() {
		return 4 * duzinaStranice;
	}

	// Tacka gore levo=(xGoreLevo,yGoreLevo)
	// , duzina stranice=duzinaStranice
	public String toString() {
		return "Tacka gore levo = " + goreLevo + ", duzina stranice = " + duzinaStranice + ", boja ivice: "
				+ bojaIvice + ", boja unutrasnjosti: " + bojaUnutrasnjosti;
	}

	public boolean equals(Object o1) {
		if (o1 instanceof Kvadrat) {
			Kvadrat pomocni = (Kvadrat) o1;
			if (this.goreLevo.equals(pomocni.goreLevo) && (this.duzinaStranice == pomocni.duzinaStranice))
				return true;
			else
				return false;
		}
		return false;
	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX()+duzinaStranice, goreLevo.getY()+duzinaStranice));
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);

	}
	public void crtajSe(Graphics g) {
		//g.setColor(pronadjiBoju(getBoja()));
		g.setColor(getBojaIv());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g) {
		//g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.setColor(getBojaUn());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

}
