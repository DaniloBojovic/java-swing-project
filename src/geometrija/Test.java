package geometrija;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		/*Tacka t1 = new Tacka();
		System.out.println("X t1: "+t1.getX());
		System.out.println("Y t1: "+t1.getY());
		//postaviti x t1 na vrednost 10
		t1.setX(10);
		System.out.println("X t1: "+t1.getX());
		t1.pomeriZa(5, 10);
		System.out.println("X t1: "+t1.getX());
		Linija l1 = new Linija();
		l1.settPocetna(t1);
		System.out.println("X pocetne tacke l1: "+l1.gettPocetna().getX());
		l1.gettPocetna().setX(33);
		System.out.println("X pocetne tacke l1: "+l1.gettPocetna().getX());
		Tacka t2 = new Tacka();
		t2.setY(50);
		l1.settKrajnja(t2);
		//postaviti x koordinatu pocetne tacke linije l1 na vrednost
		//y koordinate krajnje tacke linije l1
		l1.gettPocetna().setX(l1.gettKrajnja().getY());
		System.out.println("X pocetne tacke l1: "+l1.gettPocetna().getX());
		System.out.println("Duzina l1: "+l1.duzina());
		Pravougaonik p1 = new Pravougaonik();
		p1.setGoreLevo(t1);
		// x koordinatu tacke gore levo p1
		System.out.println("X gore levo p1: "+p1.getGoreLevo().getX());
		Kvadrat kv1 = new Kvadrat();
		kv1.setGoreLevo(t2);
		kv1.setDuzinaStranice(100);
		//y koordinata tacke gore levo p1 na vrednost 
		//zbira obima i povrsine kv1
		p1.getGoreLevo().setY(kv1.obim()+kv1.povrsina());
		System.out.println("Y gore levo p1: "+p1.getGoreLevo().getY());
		Krug kr1 = new Krug();
		kr1.setCentar(t2);
		kr1.pomeriNa(10, 15);
		kr1.getCentar().setX(10);
		kr1.getCentar().setY(15);
		System.out.println("X centra kr1: "+kr1.getCentar().getX());
		 */
		Tacka t1 = new Tacka(5,10);
		System.out.println("X t1: "+t1.getX()+"\nY t1: "+t1.getY());
		Linija l1 = new Linija(t1, new Tacka(20, 25));
		System.out.println("Duzina l1: "+l1.duzina());
		Pravougaonik p1 = new Pravougaonik(t1, 100, 50);
		System.out.println("X gore levo p1: "+p1.getGoreLevo().getX());
		p1.getGoreLevo().setX(20);
		System.out.println("X t1: "+t1.getX());
		Kvadrat kv1 = new Kvadrat(t1, 50);
		// krug kr1 sa centrom:
		// x centra = x koordinata gore levo p1
		// y centra = y koordinata krajnje tacke l1
		// poluprecnik = obim p1
		Krug kr1 = new Krug(new Tacka(p1.getGoreLevo().getX(), l1.gettKrajnja().getY()), p1.obim());
		System.out.println("Povrsina kr1: "+kr1.povrsina());
		Tacka t2 = new Tacka(10, 20, "crna");
		System.out.println("Boja t2: "+t2.getBoja());

		System.out.println(t2);
		System.out.println(l1);
		System.out.println(p1);
		System.out.println(kv1);
		System.out.println(kr1);
		//ispisati tacku gore levo p1 
		//i krajnju tacku linije l1
		//u dva reda u konzoli a jednim pozivom prinln
		System.out.println(p1.getGoreLevo()+"\n"+l1.gettKrajnja());
		Tacka t3=new Tacka(10, 10);
		Tacka t4=t3;
		Tacka t5= new Tacka(10, 10);

		//if(t3==t4)
		//	System.out.println("t3 i t4 su jednake");
		if(t3==t5)
			System.out.println("t3 i t5 su jednake");
		else
			System.out.println("t3 i t5 nisu jednake");
		//if(t3.equals(t4))
		//	System.out.println("t3 i t4 su jednake");
		if(t3.equals(t5))
			System.out.println("t3 i t5 su jednake");
		else
			System.out.println("t3 i t5 nisu jednake");

		Linija l3=new Linija(new Tacka(110, 100), new Tacka(50, 50));
		Linija l4=new Linija(new Tacka(100, 100), new Tacka(50, 50));

		if(l3.equals(l4))
			System.out.println("linije su jednake");
		else
			System.out.println("linije nisu jednake");

		Kvadrat kv4=new Kvadrat(new Tacka(15, 15), 50);
		Kvadrat kv5=new Kvadrat(new Tacka(15, 15), 50);

		System.out.println(kv4.equals(kv5));

		Pravougaonik p3=new Pravougaonik(new Tacka(25, 25), 30, 80);
		Pravougaonik p4=new Pravougaonik(new Tacka(25, 25), 30, 80);

		System.out.println(p3.equals(p4));

		Krug kr4=new Krug(new Tacka(25, 23), 150);
		Krug kr5=new Krug(new Tacka(25, 23), 150);

		System.out.println(kr4.equals(kr5));
		//kreirati pravougaonik p5 crvene boje
		//ispisati boju na konzolu
		Pravougaonik p5 = new Pravougaonik(t1, 100, 50,"crvena");
		System.out.println("Boja p5: "+p5.getBoja());
		System.out.println("Niz tacaka");
		Tacka t6 = new Tacka(6, 6);
		Tacka t7 = new Tacka(7, 7);
		Tacka t8 = new Tacka(8, 8);

		Tacka[] nizTacaka = {t7,t6,t8};
		for(int i=0;i<nizTacaka.length;i++)
			System.out.println(nizTacaka[i]);

		Arrays.sort(nizTacaka);

		System.out.println("sortiran niz");
		try {
			Integer.parseInt("pet");
			for(int i=0;i<100;i++)
				System.out.println(nizTacaka[i]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Niz nema toliko elemenata!");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Ne mogu da pretvorim string u int!");
		}finally {
			System.out.println("Ja se UVEK izvrsavam!");
		}

		System.out.println("Ja sam neka naredba!");
		
		ArrayList<Tacka> listaTacaka = new ArrayList<Tacka>();
		listaTacaka.add(t1);
		listaTacaka.add(t2);
		listaTacaka.add(t3);
		System.out.println("Ispis liste tacaka:");
		Iterator it = listaTacaka.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		listaTacaka.remove(1);
		listaTacaka.add(1, new Tacka(10, 10));
		System.out.println("drugi element liste: "+listaTacaka.get(1));
	}

}
