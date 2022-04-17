package konzola;

import java.util.Scanner;
import logika.Logika;

/**
 * Ova klasa predstavlja konzolnu verziju igre
 * 
 * @author Rijad
 * 
 */

public class Konzola {
	static int x1, y1, x2, y2;
	static boolean ilegalan;
	static Logika logika = new Logika();
	
	/**
	 * Sa ovom metodom dopustamo korisnika da odigra potez i taj potez saljemo logici za obradu.
	 */
	
	private static void unesiKoordinate() {
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Unesi red prvog  polja:");
		x1 = myObj1.nextInt();
		myObj1.nextLine();

		System.out.println("Unesi kolonu prvog polja:");
		y1 = myObj1.nextInt();
		myObj1.nextLine();

		System.out.println("Unesi red drugog polja:");
		x2 = myObj1.nextInt();
		myObj1.nextLine();

		System.out.println("Unesi kolonu drugog polja:");
		y2 = myObj1.nextInt();
		myObj1.nextLine();

		if (x2 == x1 && (y2 == y1 - 1 || y2 == y1 + 1)) {
			ilegalan = false;
		} else if (y2 == y1 && (x2 == x1 - 1 || x2 == x1 + 1)) {
			ilegalan = false;
		} else {
			ilegalan = true;
		}

	}

	/**
	 * Main metoda koja prikazuje polje za igranje i uzima input od korisnika koji salje logici za obradu
	 * @param args
	 */
	
	public static void main(String[] args) {

		int broj_poteza, max_broj_bodova, redovi, kolone = 0;

		System.out.println("Dobrodosli.");
		System.out.println("Izaberite koji mod zelite igrati (NORMAL ili CUSTOM): ");
		Scanner myObj = new Scanner(System.in);
		String odluka = myObj.nextLine();

		if (odluka.equals("normal")) {
			broj_poteza = 7;
			max_broj_bodova = 35;
			redovi = 5;
			kolone = 5;
			logika.postaviPocetneVrijednosti(redovi, kolone, max_broj_bodova, broj_poteza);
		} else if (odluka.equals("custom")) {
			System.out.println("Unesi koliko poteza zelite imati:");
			int br_p = myObj.nextInt();
			broj_poteza = br_p;

			System.out.println("Unesi potreban broj bodova za pobjedu:");
			int bod = myObj.nextInt();
			max_broj_bodova = bod;

			System.out.println("Unesite koliko ce redova polje imati:");
			int row = myObj.nextInt();
			redovi = row;

			System.out.println("Unesite koliko ce kolona polje imati:");
			int col = myObj.nextInt();
			kolone = col;
			logika.postaviPocetneVrijednosti(redovi, kolone, max_broj_bodova, broj_poteza);
		}

		while (true) {
			//prikaziMatricu se koristi samo za prikaz matrice iz logike korisniku.
			//Ona nema nikakvih drugih funkcija
			
			int[][] prikaziMatricu = logika.getMatrica();

			for (int i = 0; i < prikaziMatricu.length; ++i) {
				for (int j = 0; j < prikaziMatricu[i].length; ++j) {
					System.out.print(prikaziMatricu[i][j]);
					System.out.print(" ");
				}
				System.out.println(" ");
			}
						
			System.out.println("Ostalo Vam je " + logika.vratiPoteze() + " poteza.");
			unesiKoordinate();
			if (ilegalan == true) {
				while (ilegalan == true) {
					System.out.println("Ilegalan potez. Unesi ponovo!");
					unesiKoordinate();
				}
			}
			logika.zamijeniVrijednosti(x1, y1, x2, y2);
			System.out.println("Rezultat: " + logika.vratiBodove() + " bodova");
			if (logika.provjeriKraj() == true) {
				break;
			}
		}

		if (logika.vratiPob() == true) {
			System.out.println("Pobijedili ste. Cestitamo.");
		} else {
			System.out.println("Izgubili ste. Pokusajte ponovo.");
		}
	}
}
