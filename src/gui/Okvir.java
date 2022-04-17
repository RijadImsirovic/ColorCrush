package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logika.Logika;

/**
 * Ova klasa pravi i prikazuje prozor u koji gledamo
 * @author Rijad
 * 
 */

public class Okvir extends JFrame {
	OdaberiTezinu panel2 = new OdaberiTezinu();
	OdabranaCustomOpcija panel3 = new OdabranaCustomOpcija();
	OkvirIgre panel4 = new OkvirIgre();
	CustomBoje boje = new CustomBoje();
	GornjiPanelIgre gore = new GornjiPanelIgre();
	Logika logika = new Logika();
	DonjiPanelIgre igra = new DonjiPanelIgre();
	
	/**
	 * Metoda koja postavlja pocetni meni u igri,
	 * Takodjer se ovdje nalazi ActionListener-i,
	 * Oni mijenjaju menije kad su pritisnuti.
	 */
	
	private void ubaciPanele() {
		
		GridBagConstraints c = new GridBagConstraints();
		String[] options = { "Da", "Ne" };
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;

		// panel 1:
		MainMenu panel1 = new MainMenu();
		c.gridx = 0;
		c.gridy = 0;
		add(panel1, c);

		panel1.dugme_play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(panel2);
				invalidate();
				validate();
			}
		});

		panel2.dugme_normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel4.build();
				setContentPane(panel4);
				invalidate();
				validate();

			}
		});
		
		panel2.dugme_custom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(panel3);
				revalidate();

			}
		});

		panel3.natrag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boje.brojac = 1;
				boje.istina = true;
				panel3.broj_odabranih.setText("Broj Boja Odabranih: " + 0);
				setContentPane(panel1);
				invalidate();
				validate();
			}
		});
		
		panel3.dalje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logika.postaviPocetneVrijednosti(Integer.parseInt(panel3.redovi_f.getText()), Integer.parseInt(panel3.kolone_f.getText()), Integer.parseInt(panel3.bodovi_f.getText()), Integer.parseInt(panel3.potezi_f.getText()));
				
				igra.postaviRedove(Integer.parseInt(panel3.redovi_f.getText()));
				igra.postaviKolone(Integer.parseInt(panel3.kolone_f.getText()));
		
				panel4.postaviBoju1(boje.boja1);
				panel4.postaviBoju2(boje.boja2);
				panel4.postaviBoju3(boje.boja3);
				panel4.postaviBoju4(boje.boja4);
				
				panel4.build();
				
				int result = JOptionPane.showOptionDialog(null, "Da li ste sigurni?", "Potvrda",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.YES_OPTION) {
					setContentPane(panel4);
					revalidate();

				} 
			}
		});
	}

	/**
	 * Metoda build koja postavlja izgled okvira,
	 * Takodjer poziva ostale funkcije u ovoj klasi.
	 */
	
	private void build() {
		setLayout(new GridBagLayout());
		setTitle("COLOR CRUSH");
		setSize(950, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ubaciPanele();
	}

	/**
	 * Konstruktor koji pokrece metodu build.
	 */
	
	public Okvir() {
		build();
	}

	/**
	 * Metoda koja postavlja vidljivost prozora.
	 */
	
	public void prikaziOkvir() {
		setVisible(true);
	}

}
