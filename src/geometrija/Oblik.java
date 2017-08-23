package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private String boja = "crna";
	//private Color boja;
	private boolean selektovan;
	private Color bojaIv = Color.BLACK;
	//private Color bojaUn;
	
	public Oblik(){
		
	}
	public Oblik(String boja){
		this.boja = boja;
	}
	
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	
	public static Color pronadjiBoju(String boja){
		if(boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(boja.equalsIgnoreCase("roza"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	public Color getBojaIv(){
		return bojaIv;
	}
	public void setBojaIv(Color bojaIv){
		this.bojaIv = bojaIv;
	}
}
