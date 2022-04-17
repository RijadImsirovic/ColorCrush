package logika;

/**
 * Ova klasa predstavlja logiku koju igra koristi
 * @author Rijad
 * 
 */

public class Logika {
	int x1, y1, x2, y2, broj,random_broj,prosli_rand_broj, score_prije;
	int score, brojac, prvi, pocetni = 0;
	
	boolean provjera, ilegalan, postoji;
	boolean pobjeda, iskoristeni_potezi = false;

	static int max_rezultat = 35;
	static int br_poteza = 7;
	static int brRedova = 5;
	static int brKolona = 5;
	
	int[][] mojaMatrica;

	
	/**
	 * Metoda koja pravi matricu sa kojom igramo.
	 * @param n1 Broj redova u matrici.
	 * @param m1 Broj kolona u matrici
	 * @return Matricu sa kojom igramo
	 */

	public void napraviMatricu(int n1, int m1) {
		mojaMatrica = new int[n1][m1];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				mojaMatrica[i][j] = 1 + (int) (Math.random() * ((4 - 1) + 1));
			}
		}
		
	}

	/**
	 * Metoda koja provjerava ima li tacnosti u matrici.
	 * @param matrica Matrica koju provjeravamo.
	 * 
	 */
	
	public void provjeriTacnosti(int[][] matrica) {

		for (int i = 0; i < matrica.length; ++i) {
			for (int j = 0; j < matrica[i].length; ++j) {
				int broj = matrica[i][j];

				// Provjerava tacnost u predzadnjem broju.

				if (matrica[i].length - 2 == j) {
					if (broj == matrica[i][j - 1] && broj == matrica[i][j] && broj == matrica[i][j + 1]
							&& broj != 0) {
						matrica[i][j - 1] = 0;
						matrica[i][j] = 0;
						matrica[i][j + 1] = 0;
						score += 5;
						postoji = true;
					}

					if (matrica.length - 2 == i) {
						if (broj == matrica[i - 1][j] && broj == matrica[i][j] && broj == matrica[i + 1][j]
								&& broj != 0) {
							matrica[i - 1][j] = 0;
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							score += 5;
							postoji = true;
						}
					} else if (matrica.length - 1 == i) {
						continue;
					} else {
						if (broj == matrica[i][j] && broj == matrica[i + 1][j] && broj == matrica[i + 2][j]
								&& broj != 0) {
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							matrica[i + 2][j] = 0;
							score += 5;
							postoji = true;
						}
					}
					// Provjerava tacnost u zadnjem broju
				} else if (matrica[i].length - 1 == j) {

					if (matrica.length - 2 == i) {
						if (broj == matrica[i - 1][j] && broj == matrica[i][j] && broj == matrica[i + 1][j]
								&& broj != 0) {
							matrica[i - 1][j] = 0;
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							score += 5;
							postoji = true;
						}
					} else if (matrica.length - 1 == i) {
						continue;
					} else {
						if (broj == matrica[i][j] && broj == matrica[i + 1][j] && broj == matrica[i + 2][j]
								&& broj != 0) {
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							matrica[i + 2][j] = 0;
							score += 5;
							postoji = true;
						}
					}
				} // Provjerava tacnost u ostalim redovima
				else {
					if (broj == matrica[i][j] && broj == matrica[i][j + 1] && broj == matrica[i][j + 2]
							&& broj != 0) {
						matrica[i][j] = 0;
						matrica[i][j + 1] = 0;
						matrica[i][j + 2] = 0;
						score += 5;
						postoji = true;
					}

					if (matrica.length - 2 == i) {
						if (broj == matrica[i - 1][j] && broj == matrica[i][j] && broj == matrica[i + 1][j]
								&& broj != 0) {
							matrica[i - 1][j] = 0;
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							score += 5;
							postoji = true;
						}
					} else if (matrica.length - 1 == i) {
						continue;
					} else {
						if (broj == matrica[i][j] && broj == matrica[i + 1][j] && broj == matrica[i + 2][j]
								&& broj != 0) {
							matrica[i][j] = 0;
							matrica[i + 1][j] = 0;
							matrica[i + 2][j] = 0;
							score += 5;
							postoji = true;
						}
					}
				}
			}
		}
		if (prvi == 0) {
			score = 0;
			prvi = 1;
		}
		
	}

	/**
	 * Metoda koja ubacuje nove vrijednosti u matricu nakon izvrsene provjere tacnih.
	 * @param matrica Matrica u kojoj ubacujemo nove vrijednosti.
	 */
	
	public void ubaciNoveVrijednosti(int[][] matrica) {
		boolean dobro = false;
		int brojac_zamjena = 0;

		while (dobro == false) {
			brojac_zamjena = 0;
			for (int i = 1; i < matrica.length; ++i) {
				for (int j = 0; j < matrica[i].length; ++j) {
					int tren_broj = matrica[i][j];

					if (matrica[i - 1][j] > 0 && tren_broj == 0) {
						matrica[i][j] = matrica[i - 1][j];
						matrica[i - 1][j] = tren_broj;
						brojac_zamjena += 1;
					}

				}

			}
			if (brojac_zamjena == 0) {
				dobro = true;
			}
		}

		// Generacija novih brojeva

		for (int i = 0; i < matrica.length; ++i) {
			for (int j = 0; j < matrica[i].length; ++j) {
				if (matrica[i][j] == 0) {
					random_broj = 1 + (int) (Math.random() * ((4 - 1) + 1));
					if (random_broj == prosli_rand_broj) {
						while (random_broj == prosli_rand_broj) {
							random_broj = 1 + (int) (Math.random() * ((4 - 1) + 1));
						}
					}
					matrica[i][j] = random_broj;
				}
			}
		}
	}

	/**
	 * Ova metoda nam zamijenjuje odabrana polja i poziva ostale funkcije za obradu.
	 * @param x1 Broj reda prvog polja
	 * @param y1 Broj kolone prvog polja
	 * @param x2 Broj reda drugog polja
	 * @param y2 Broj kolone drugog polja
	 */
	
	public void zamijeniVrijednosti(int x1, int y1, int x2, int y2) {
		int pomocna_var;
		int broj;
		
		pomocna_var = mojaMatrica[x1][y1];
		broj = mojaMatrica[x2][y2];
		
			if (x2 == x1 && (y2 == y1 - 1 || y2 == y1 + 1)) {
				mojaMatrica[x1][y1] = broj;
				mojaMatrica[x2][y2] = pomocna_var;
			
			} else if (y2 == y1 && (x2 == x1 - 1 || x2 == x1 + 1)) {
				mojaMatrica[x1][y1] = broj;
				mojaMatrica[x2][y2] = pomocna_var;
				
			}
		br_poteza -= 1;
		provjeriTacnosti(mojaMatrica);
		ubaciNoveVrijednosti(mojaMatrica);
		score_prije = score;
		nemaLaganihTacnosti();
		if (score >= max_rezultat) {
			provjera = true;
			pobjeda = true;
		} else if (br_poteza == 0) {
			provjera = true;
			iskoristeni_potezi = true;
		} else {
			provjera = false;
		}
		
	}

	/**
	 * Metoda koji osigurava da se ne generisu 3 para brojeva u matrici.
	 */
	
	public void nemaLaganihTacnosti() {
		if (postoji == true) {
			while (postoji == true) {
				postoji = false;
				provjeriTacnosti(mojaMatrica);
				ubaciNoveVrijednosti(mojaMatrica);
				if (postoji == false) {
					score = score_prije;
				}
			}
		}
	}
	
	/**
	 * Ova metoda postavlja pocetne vrijednosti i generise matricu kod custom moda.
	 * @param red Odabrani broj redova u matrici
	 * @param kolona Odabrani broj kolona u matrici 
	 * @param bod Odabrani broj bodova koji se moraju skupiti
	 * @param potez Odabrani broj poteza koje imamo na raspolaganju
	 */
	
	
	public void postaviPocetneVrijednosti(int red, int kolona,int bod, int potez ) {
		max_rezultat = bod;
		br_poteza = potez;
		brRedova = red;
		brKolona = kolona;
		napraviMatricu(brRedova, brKolona);
		prvoPokretanje();
		score = 0;
		score_prije = score;
		nemaLaganihTacnosti();
	}

	/**
	 * Metoda koja vraca matricu da bih se mogla ispisati korisniku
	 * @return Vraca matricu za prikaz korisniku
	 */
		
	public int[][] getMatrica(){
		return mojaMatrica;
	}
	
	/**
	 * Metoda koja vraca signal da li je igrac pobijedio ili ne.
	 * @return Vraca boolean vrijednost u zavisnosti da li je igrac pobijedio ili ne.
	 */
	
	public boolean vratiPob() {
		return pobjeda;
	}

	/**
	 * Ova metoda pokrece kod jednom prije pocetka igre.
	 */
	
	public void prvoPokretanje() {
		provjeriTacnosti(mojaMatrica);
		ubaciNoveVrijednosti(mojaMatrica);
	}
	
	
	/**
	 * Metoda pomocu koja nam pomaze kod vizuelnog prikaza matrice u gui-u
	 * @param x Broj reda
	 * @param y Broj kolone
	 * @return Vraca odabranu vrijednost
	 */
	
	public int vratiMatBr(int x, int y) {
		return mojaMatrica[x][y];
	}
	

	/**
	 * Metoda koja provjerava da li je kraj igre.
	 * @return Vraca vrijedost u zavisnosti je li kraj igre.
	 */
	
	public boolean provjeriKraj() {
		return provjera;
	}

	/**
	 * Metoda koja vraca broj poteza.
	 * @return Vraca broj poteza.
	 */
	
	public int vratiPoteze() {
		return br_poteza;
	}

	/**
	 * Metoda koja vraca bodove.
	 * @return Vraca broj bodova.
	 */
	
	public int vratiBodove() {
		return score;
	}

	/**
	 * Metoda koja vraca broj bodova potrebnih za pobjedu.
	 * @return Vraca broj bodova potrebnih za pobjedu.
	 */
	
	public int vratiMax() {
		return max_rezultat;
	}

	/**
	 * Metoda koja vraca duzinu matrice.
	 * @return Vraca duzinu matrice.
	 */
	
	public int vratiDuzinu() {
		return brRedova;
	}

	/**
	 * Metoda koja vraca sirinu matrice.
	 * @return Vraca sirinu matrice.
	 */
	
	public int vratiSirinu() {
		return brKolona;
	}


	/**
	 * Konstruktor koji poziva metode.
	 */

	public Logika() {
	    napraviMatricu(brRedova, brKolona);
	    prvoPokretanje();
	    
		score_prije = score;
		nemaLaganihTacnosti();
	}
	
}