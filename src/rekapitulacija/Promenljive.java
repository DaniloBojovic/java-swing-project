package rekapitulacija;

public class Promenljive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prviBroj;
		prviBroj = 7;
		int drugiBroj = 2;
		int kolicnik = prviBroj / drugiBroj;
		System.out.println(kolicnik);
		double treciBroj = 7;
		double cetvrtiBroj = 2;
		System.out.println(treciBroj / cetvrtiBroj);
		System.out.println(prviBroj / cetvrtiBroj);
		String tekst = "ovo je neki promenjen tekst";
		System.out.println(tekst);
		System.out.println("ovo je neki drugi tekst");
		char karakter = ' ';
		String ime = "Petar";
		String prezime = "Petrovic";
		System.out.println(ime + karakter + prezime + " Njegos");
		boolean tacnoNetacno = prviBroj < drugiBroj;
		boolean uvekTrue = true;
		System.out.println(tacnoNetacno && uvekTrue);
		System.out.println(tacnoNetacno || uvekTrue);
		System.out.println("ovo je neki tekst \nu dva reda");
		System.out.println("\tovo je uvucen tekst");
		int godine = 2016-1800;
		System.out.println("Ja se zovem "+ime+" \nprezivam "+prezime+" \n\timam "+godine+" godina!");
	}
}
