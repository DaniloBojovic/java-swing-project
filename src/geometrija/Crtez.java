package geometrija;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Crtez extends JPanel{
	
	private ArrayList<Oblik> oblici;
	private Oblik selektovanOblik;

	public Crtez(){
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		oblici = new ArrayList<Oblik>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame prozor = new JFrame();
		prozor.setSize(800, 600);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);

	}

	public void paint(Graphics g){
		super.paint(g);
		for(Oblik o: oblici){
			o.crtajSe(g);
			if(o instanceof PovrsinskiOblik){
				((PovrsinskiOblik) o).popuni(g);
			}
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
	}
	public void dodajOblik(Oblik ob){
		oblici.add(ob);
	}
	public void selektujOblik(int x, int y){
		if(selektovanOblik != null){
			selektovanOblik.setSelektovan(false);
		}
		for(Oblik o: oblici){
			if(o.sadrzi(x, y)){
				if(selektovanOblik!=null){
					selektovanOblik.setSelektovan(false);
				}
				selektovanOblik = o;
				o.setSelektovan(true);
			}
		}
	}
	public void obrisiOblik(Oblik o){
		oblici.remove(o);
		o.setSelektovan(false);
		repaint();
	}
	public Oblik getSelektovaniOblik(){
		return selektovanOblik;
	}
}
