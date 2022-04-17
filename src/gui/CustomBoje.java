package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Ova klasa nam pravi tabelu sa bojom koje biramo u custom modu
 * @author Rijad
 * 
 */

public class CustomBoje extends JPanel {
	int brRedova = 4;
	int brKolona = 2;
	int broj = 0;
	JButton[][] buttons = new JButton[brRedova][brKolona];
	static int brojac = 1;
	public static Color boja1, boja2, boja3, boja4;
	static boolean istina = true;

	/**
	 * Metoda koja pravi tabelu sa bojama koje biramo.
	 */
	
	private void ubaciObjekte() {

		setLayout(new GridLayout(brRedova, brKolona));

		for (int i = 0; i < brRedova; i++) {
			for (int j = 0; j < brKolona; j++) {
				broj += 1;
				buttons[i][j] = new JButton();
				add(buttons[i][j]);
				buttons[i][j].setActionCommand(String.valueOf(broj));
				buttons[i][j].addActionListener(akcija_dugmeta);
				String action = buttons[i][j].getActionCommand();

				if (action.equals("1")) {
					buttons[i][j].setBackground(Color.red);
				} else if (action.equals("2")) {
					buttons[i][j].setBackground(Color.blue);
				} else if (action.equals("3")) {
					buttons[i][j].setBackground(Color.green);
				} else if (action.equals("4")) {
					buttons[i][j].setBackground(Color.yellow);
				} else if (action.equals("5")) {
					buttons[i][j].setBackground(Color.orange);
				} else if (action.equals("6")) {
					buttons[i][j].setBackground(Color.white);
				} else if (action.equals("7")) {
					buttons[i][j].setBackground(Color.cyan);
				} else if (action.equals("8")) {
					buttons[i][j].setBackground(Color.black);
				}
			}
		}
	}

	/**
	 * Metoda pomocu koje dobijamo boje dugmadi koji su odabrani.
	 * @param dugme dugme koje je pritisnuto.
	 */
	
	private void pozicijaDugmeta(Object dugme) {
		for (int i = 0; i < brRedova; i++) {
			for (int j = 0; j < brKolona; j++) {
				if (dugme.equals(buttons[i][j])) {
					if (brojac == 1) {
						boja1 = buttons[i][j].getBackground();
						brojac += 1;
					} else if (brojac == 2) {
						boja2 = buttons[i][j].getBackground();
						brojac += 1;
					} else if (brojac == 3) {
						boja3 = buttons[i][j].getBackground();
						brojac += 1;
					} else if (brojac == 4 && istina == true) {
						boja4 = buttons[i][j].getBackground();
						istina = false;
					}
				}
			}
		}
	}

	/**
	 * ActionListener pomocu kojeg dobijamo koje smo dugme pritisnuli.
	 */
	
	ActionListener akcija_dugmeta = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			pozicijaDugmeta(e.getSource());

		}
	};

	/**
	 * Metoda koja postavlja border oko nase tabele.
	 * Takodjer poziva metodu koja pravi tabelu.
	 */
	
	private void build() {
		TitledBorder ram = new TitledBorder("Odaberi 4 boje dugmadi:");
		this.setBorder(ram);
		ubaciObjekte();
	}

	/**
	 * Konstruktor koji poziva metode.
	 */
	
	public CustomBoje() {
		build();
	}
}
