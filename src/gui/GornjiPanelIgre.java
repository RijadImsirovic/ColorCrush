package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Ova klasa pravi gornji panel u igri koji prikazuje bodove i poteze preostale
 * @author Rijad
 * 
 */

public class GornjiPanelIgre extends JPanel {
	static JLabel trenutni_rez;
	static JLabel ukupni_rez;
	static JLabel potezi;
	JLabel naslov;
	int score = 0;
	int max_score = 0;
	int br_poteza = 0;
	
	/**
	 * Metoda koja namjesta trenutni rezultat osvojen u igri.
	 * @param text String koji ispisuje tekst napisan ispred rezulata.
	 * @param broj Integer koji ispisuje trenutni rezultat osvojen.
	 */

	public static void namjestiText(String text, int broj) {
		trenutni_rez.setText(text + broj);
	}

	/**
	 * Metoda koja namjesta koliko bodova morate skupiti da bih pobijedili.
	 * @param text String koji ispisuje tekst napisan ispred bodova.
	 * @param broj Integer koji ispisuje broj bodova koji morate skupiti da pobijedite.
	 */
	
	static void namjestiMax(String text, int broj) {
		ukupni_rez.setText(text + broj);
	}

	/**
	 * Metoda koja namjesta koliko je poteza igracu ostalo da moze odigrati.
	 * @param text String koji ispisuje tekst napisan ispred broja poteza.
	 * @param broj Integer koji ispisuje broj poteza preostalih igracu.
	 */
	
	public static void namjestiPoteze(String text, int broj) {
		potezi.setText(text + broj);
	}

	/**
	 * Metoda koja pravi gornji panel u igri koji ispisuje bodove i poteze preostale
	 * On se spaja sa klasom OkvirIgre.
	 */
	
	private void build() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		trenutni_rez = new JLabel("Bodovi: " + score);

		trenutni_rez.setFont(new Font("", Font.PLAIN, 25));
		c.insets = new Insets(50, 10, 0, 10);
		c.gridx = 0;
		c.gridy = 0;
		add(trenutni_rez, c);

		ukupni_rez = new JLabel("Do Pobjede: " + max_score);
		ukupni_rez.setFont(new Font("", Font.PLAIN, 25));
		c.insets = new Insets(10, 50, 0, 10);
		c.gridx = 0;
		c.gridy = 1;
		add(ukupni_rez, c);

		potezi = new JLabel("Potezi: " + br_poteza);
		potezi.setFont(new Font("", Font.PLAIN, 25));
		c.insets = new Insets(50, 10, 0, 70);
		c.gridx = 3;
		c.gridy = 0;
		add(potezi, c);

		naslov = new JLabel("COLOR CRUSH");
		naslov.setFont(new Font("", Font.PLAIN, 40));
		c.insets = new Insets(10, 10, 0, 10);
		c.gridx = 2;
		c.gridy = 1;
		add(naslov, c);

		JLabel l = new JLabel();
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		add(l, c);
		
		c.weightx = 0;
		c.weighty = 0;

	}

	/**
	 * Konstruktor koji poziva metode.
	 */
	
	public GornjiPanelIgre() {
		build();

	}
}
