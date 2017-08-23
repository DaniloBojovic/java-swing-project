package crtanje;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import geometrija.Crtez;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Pravougaonik;
import geometrija.Tacka;

public class MLzaCrtez implements MouseListener{
	private Glavni gl;
	private Tacka tacka;
	private Linija linija;
	private Krug krug;
	private int klik;
	Graphics g;
	
	public MLzaCrtez(Glavni gl){
		this.gl = gl;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		g = gl.pnlCrtez.getGraphics();
		
		if(gl.rbtnTacka.isSelected()==true){
			gl.pnlCrtez.dodajOblik(new Tacka(e.getX(), e.getY()));
		}
		
		if(gl.rbtnKrug.isSelected()==true){
			DijalogKrug dk = new DijalogKrug();
			dk.setVisible(true);
			if(dk.getKrug()!=null){
			Krug krug = dk.getKrug();
			Tacka centar = new Tacka(e.getX(), e.getY());
			krug.setCentar(centar);
			krug.crtajSe(g);
			krug.popuni(g);
			gl.pnlCrtez.dodajOblik(krug);
			}		
		}
		if(gl.rbtnKvadrat.isSelected()==true){
			DijalogKvadrat1 dKv = new DijalogKvadrat1();
			dKv.setVisible(true);
			if(dKv.getKvadrat()!=null){
			Kvadrat kvad = dKv.getKvadrat();
			Tacka goreLevo = new Tacka(e.getX(), e.getY());
			kvad.setGoreLevo(goreLevo);
			kvad.crtajSe(g);
			kvad.popuni(g);
			gl.pnlCrtez.dodajOblik(kvad);
			}
		}
		if(gl.rbtnPravougaonik.isSelected()==true){
			DijalogPravougaonik dp = new DijalogPravougaonik();
			dp.setVisible(true);
			if(dp.getPravougaonik()!=null){
				Pravougaonik prav = dp.getPravougaonik();
				Tacka goreLevo = new Tacka(e.getX(), e.getY());
				prav.setGoreLevo(goreLevo);
				prav.crtajSe(g);
				prav.popuni(g);
				gl.pnlCrtez.dodajOblik(prav);
			}
		}
		if(gl.rbtnSelektuj.isSelected()==true){
			gl.pnlCrtez.selektujOblik(e.getX(), e.getY());
		}
		gl.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gl.rbtnLinija.isSelected()==true){
			if(linija==null){
			linija = new Linija(new Tacka(e.getX(), e.getY()), new Tacka(
					e.getX() + 1, e.getY() + 1));
			gl.pnlCrtez.dodajOblik(linija);
			}
		}		
		gl.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (linija != null) {
			linija.settKrajnja(new Tacka(e.getX(), e.getY()));
			linija = null;
		}
		gl.repaint();
	}
	

}
