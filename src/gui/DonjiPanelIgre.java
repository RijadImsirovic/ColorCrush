package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logika.Logika;

/**
 * Ova klasa pravi donji panel u igri to jeste polje sa kojim igramo kao i njegove funkcije
 * @author Rijad
 * 
 */

public class DonjiPanelIgre extends JPanel {
	int  potezi, bodovi, max_rez;
	int brojac_klikova = 0;
	static int x1, y1, x2, y2;
	static int brojac = 0;
	static int brRedova;
	static int brKolona;
	boolean provjeri_kraj, ilegalan;
	Logika logika = new Logika();
	GornjiPanelIgre GornjiPanelIgre;

	public static Color color1 = Color.red;
	public static Color color2 = Color.blue;
	public static Color color3 = Color.green;
	public static Color color4 = Color.yellow;

	
	JButton[][] buttons = new JButton[brRedova][brKolona];

	/**
	 * ActionListener koji daje funkciju dugmadima kad su pritisnuti.
	 * Pomocu njega se izvrsavaju sve funkcije i metode.
	 */
	
	ActionListener akcija_dugmeta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			brojac_klikova += 1;
			pozicijaDugmeta(e.getSource());

			if (brojac_klikova == 2) {
				if (ilegalan == false) {
					logika.zamijeniVrijednosti(x1, y1, x2, y2);

					potezi = logika.vratiPoteze();
					GornjiPanelIgre.namjestiPoteze("Potezi: ", potezi);

					bodovi = logika.vratiBodove();
					GornjiPanelIgre.namjestiText("Bodovi: ", bodovi);

					max_rez = logika.vratiMax();
					osvjeziMatricu();

					provjeri_kraj = logika.provjeriKraj();
					if (provjeri_kraj == true) {
						ispisiKrajIgre();
					}

					brojac_klikova = 0;
				} else {
					brojac_klikova = 0;
					System.out.println("Unesi Ponovo.");
				}
			}
		}
	};
	
	/**
	 * Metoda koja prima pozicije dugmadi pritisnutih.
	 * @param dugme Dugme pritisnuto
	 */
	
	public void pozicijaDugmeta(Object dugme) {
		for (int i = 0; i < brRedova; i++) {
			for (int j = 0; j < brKolona; j++) {
				if (dugme.equals(buttons[i][j])) {
					if (brojac == 0) {
						x1 = i;
						y1 = j;
						brojac = 1;
						ilegalan = false;
					} else if (brojac == 1) {
						if (i == x1 && (j == y1 - 1 || j == y1 + 1)) {
							x2 = i;
							y2 = j;
							brojac = 0;
							ilegalan = false;
						} else if (j == y1 && (i == x1 - 1 || i == x1 + 1)) {
							x2 = i;
							y2 = j;
							brojac = 0;
							ilegalan = false;
						} else {
							brojac = 0;
							ilegalan = true;
						}

					}
				}
			}
		}
	}
	
	/**
	 * Metoda koja osvjezava matricu.
	 */
	
	public void osvjeziMatricu() {
		for (int i = 0; i < buttons.length; ++i) {
			for (int j = 0; j < buttons[i].length; ++j) {
				buttons[i][j].setActionCommand(String.valueOf(logika.vratiMatBr(i, j)));
				
				String action = buttons[i][j].getActionCommand();

				if (action.equals("1")) {
					buttons[i][j].setBackground(color1);
				} else if (action.equals("2")) {
					buttons[i][j].setBackground(color2);
				} else if (action.equals("3")) {
					buttons[i][j].setBackground(color3);
				} else {
					buttons[i][j].setBackground(color4);
				}
			}
		}

	}
	
	/**
	 * Metoda koja zavrsava igru u zavisnosti kako je igrac odigrao igru.
	 */
	
	public void ispisiKrajIgre() {
		if  (logika.vratiPob() == true) {
			JOptionPane.showMessageDialog(null, "Cestitamo. Pobijedili ste!", "Kraj Igre", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}

		if (logika.vratiPoteze() == 0) {
			if  (logika.vratiPob() == true) {
				JOptionPane.showMessageDialog(null, "Cestitamo. Pobijedili ste!", "Kraj Igre",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			} else {
				JOptionPane.showMessageDialog(null, "Izgubili ste. Pokusajte ponovo!", "Kraj Igre",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			System.exit(0);
		}

	}

	/**
	 * Metoda koja pravi polje sa dugmadima.
	 */
	
	public void praviPolje() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setActionCommand(String.valueOf(logika.vratiMatBr(i, j)));
				add(buttons[i][j]);
				buttons[i][j].addActionListener(akcija_dugmeta);

				String action = buttons[i][j].getActionCommand();

				if (action.equals("1")) {
					buttons[i][j].setBackground(color1);
				} else if (action.equals("2")) {
					buttons[i][j].setBackground(color2);
				} else if (action.equals("3")) {
					buttons[i][j].setBackground(color3);
				} else {
					buttons[i][j].setBackground(color4);
				}
			}
		}
	}
	
	/**
	 * Metoda koja postavlja broj redova za prikaz.
	 * @param red Broj redova odredjenih.
	 */

	public void postaviRedove(int red) {
		brRedova = red;	
	}
	
	/**
	 * Metoda koja postavlja broj kolona za prikaz.
	 * @param kol Broj kolona odredjenih.
	 */
	
	public void postaviKolone(int kol) {
		brKolona = kol;
	}
	
	/**
	 * Konstruktor koji postavlja layout i poziva metodu praviPolje
	 */
	
	public DonjiPanelIgre() {
		brRedova = logika.vratiDuzinu();
		brKolona = logika.vratiSirinu();

		setLayout(new GridLayout(brRedova, brKolona));
		praviPolje();
	}
}
