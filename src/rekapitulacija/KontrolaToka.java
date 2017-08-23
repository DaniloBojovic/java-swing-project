package rekapitulacija;

public class KontrolaToka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prviBroj = 5;
		if(prviBroj > 0){
			System.out.println("Broj");
			System.out.println("je pozitivan");
		}			
		else if(prviBroj == 0)
			System.out.println("Broj je nula");
		else
			System.out.println("Broj je negativan");

		int mesec = 13;
		if (mesec == 1) 
			System.out.println("Januar");
		else if (mesec == 2) 
			System.out.println("Februar");
		else if (mesec == 3) 
			System.out.println("Mart");
		else if (mesec == 4) 
			System.out.println("April");
		else if (mesec == 5)
			System.out.println("Maj");
		else if (mesec == 6) 
			System.out.println("Jun");
		else if (mesec == 7) 
			System.out.println("Jul");
		else if (mesec == 8) 
			System.out.println("Avgust");
		else if (mesec == 9)
			System.out.println("Septembar");
		else if (mesec == 10) 
			System.out.println("Oktobar");
		else if (mesec == 11) 
			System.out.println("Novembar");
		else if (mesec == 12) 
			System.out.println("Decembar");
		else 
			System.out.println("Uneli ste nepostojeci mesec!");

		System.out.println("Pomocu while od 1 do 10");
		int i = 1;
		while(i<=10){
			System.out.println(i);
			i++;
		}
		i = 10;
		while(i>=1){
			System.out.println(i);
			i--;
		}
		System.out.println("pomocu while od 3 do 8");
		System.out.println("Pomocu while brojeve od 3 do 8");
		i = 3;
		while(i<=8){
			System.out.println(i);
			i++;
		}
		System.out.println("Suma prvih 5 brojeva pomocu while");
		int suma = 0;
		i = 0;
		while(i<=5){
			suma = suma + i;
			i++;
		}
		System.out.println("Suma prvih 5 brojeva: "+suma);
		System.out.println("i = "+i);
		System.out.println("Kvadrate prvih 5 brojeva");
		i = 1;
		int kvadrat;
		while (i <= 5){
			kvadrat = i * i;
			System.out.println("Kvadrat broja " + i + " je " + kvadrat);
			i++;
		}
		System.out.println("faktorijel broja 5 pomocu while");
		int rez = 1;
		i = 5;
		while (i >= 1){
			rez = rez * i;
			i--;
		}
		System.out.println("5! = " + rez);
		System.out.println("pomocu for od 3 do 8");
		for(i = 3;i <= 8; i++ ){
			System.out.println(i);
		}
		System.out.println("pomocu for sve parne 1-100");
		for(i=1;i<101;i++)
			if(i%2==0)
				System.out.println("Broj "+i+" je paran!");
	}

}
