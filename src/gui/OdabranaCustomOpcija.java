package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Ova klasa pravi custom meni gdje biramo parametre koje zelimo
 * @author Rijad
 * 
 */

public class OdabranaCustomOpcija extends JPanel {
	int brojac_boja;
	JLabel redovi, kolone, bodovi, potezi, broj_odabranih;
	JTextField redovi_f, kolone_f, bodovi_f, potezi_f;
	JButton natrag, dalje;
	CustomBoje odaberiBoje = new CustomBoje();
	int maxWidth = 4;
	int maxHeight = 2;
	
	/**
	 * Metoda koja pravi meni za custom mod i spaja klasu CustomBoje sa sobom.
	 */
	
	private void build() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		TitledBorder ram = new TitledBorder("Odaberi opcije koje zelis:");
		this.setBorder(ram);
		redovi = new JLabel("Broj redova u matrici: ");
		redovi.setFont(new Font("", Font.PLAIN, 20));
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		add(redovi, c);

		redovi_f = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		add(redovi_f, c);

		kolone = new JLabel("Broj Kolona u matrici: ");
		c.gridx = 0;
		c.gridy = 1;
		kolone.setFont(new Font("", Font.PLAIN, 20));
		c.insets = new Insets(10, 10, 10, 10);
		add(kolone, c);

		kolone_f = new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10, 10, 10, 10);
		add(kolone_f, c);

		bodovi = new JLabel("Broj bodova do pobjede: ");
		bodovi.setFont(new Font("", Font.PLAIN, 20));
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 10, 10, 10);
		add(bodovi, c);

		bodovi_f = new JTextField(10);
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 1;
		c.gridy = 2;
		add(bodovi_f, c);

		potezi = new JLabel("Broj dozvoljenih poteza: ");
		potezi.setFont(new Font("", Font.PLAIN, 20));
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 10, 10, 10);
		add(potezi, c);

		potezi_f = new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10, 10, 10, 10);
		add(potezi_f, c);

		JLabel l1 = new JLabel();
		c.gridx = 0;
		c.gridy = 5;
		c.weightx = 0;
		c.weighty = 1;
		add(l1, c);

		c.weightx = 0;
		c.weighty = 0;

		broj_odabranih = new JLabel("Broj Boja Odabranih: " + 0);
		broj_odabranih.setFont(new Font("", Font.PLAIN, 20));
		c.gridx = 0;
		c.gridy = 4;
		add(broj_odabranih, c);

		natrag = new JButton("NATRAG");
		c.insets = new Insets(10, 45, 45, 10);
		natrag.setPreferredSize(new Dimension(150, 40));
		c.gridx = 0;
		c.gridy = 7;
		add(natrag, c);

		dalje = new JButton("DALJE");
		c.insets = new Insets(10, 10, 45, 45);
		dalje.setPreferredSize(new Dimension(150, 40));
		c.gridx = 7;
		c.gridy = 7;
		add(dalje, c);

		JLabel l = new JLabel();
		c.gridx = 3;
		c.gridy = 6;
		c.weightx = 1;
		c.weighty = 1;
		add(l, c);

		c.gridx = 6;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 6;
		c.gridwidth = 3;
		add(odaberiBoje, c);

		c.gridheight = 1;
		c.gridwidth = 1;

		for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j < maxHeight; j++) {
				odaberiBoje.buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						broj_odabranih.setText("Broj Boja Odabranih: " + odaberiBoje.brojac);
					}
				});
			}
		}
	}

	/**
	 * Konstuktor koji pokrece metodu build.
	 */
	public OdabranaCustomOpcija() {
		build();
	}

}
