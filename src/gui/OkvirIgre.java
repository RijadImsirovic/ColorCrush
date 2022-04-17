package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import logika.Logika;

/**
 * Ova klasa spaja i namjesta gornji i donji panel igre
 * @author Rijad
 *
 */

public class OkvirIgre extends JPanel {
	int brojac = 0;
	int rez, potezi, x, y;
	OdaberiTezinu panel3 = new OdaberiTezinu();
	OdabranaCustomOpcija panel4 = new OdabranaCustomOpcija();
	Logika logika = new Logika();
	DonjiPanelIgre dole = new DonjiPanelIgre();
	
	
	/**
	 * Metoda pomocu koje spajamo i namjestamo gornji i donji panel igre.
	 */
	private void spojiPanele() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		// panel 1:
		GornjiPanelIgre panel1 = new GornjiPanelIgre();

		c.weightx = 0.2;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 0;
		add(panel1, c);

		// panel 2
		DonjiPanelIgre panel2 = new DonjiPanelIgre();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;

		c.gridx = 0;
		c.gridy = 1;
		add(panel2, c);
		
	  
		GornjiPanelIgre.namjestiMax("Do pobjede: ", logika.vratiMax());
		GornjiPanelIgre.namjestiPoteze("Potezi: ", logika.vratiPoteze());
	}

	/**
	 * Metoda pomocu koje postavljamo prvu odabranu boju u custom opcijama.
	 * @param boja1 Boja koju smo pritisnuli.
	 */
	
	public void postaviBoju1(Color boja1) {
		DonjiPanelIgre.color1 = boja1;
	}

	/**
	 * Metoda pomocu koje postavljamo drugu odabranu boju u custom opcijama.
	 * @param boja2 Druga boja koju smo pritisnuli.
	 */
	
	public void postaviBoju2(Color boja2) {
		DonjiPanelIgre.color2 = boja2;
	}

	/**
	 * Metoda pomocu koje postavljamo trecu odabranu boju u custom opcijama.
	 * @param boja3 Treca boja koju smo pritisnuli.
	 */
	
	public void postaviBoju3(Color boja3) {
		DonjiPanelIgre.color3 = boja3;
	}

	/**
	 * Metoda pomocu koje postavljamo cetvrtu odabranu boju u custom opcijama.
	 * @param boja4 Cetvrta boja koju smo pritisnuli.
	 */
	
	public void postaviBoju4(Color boja4) {
		DonjiPanelIgre.color4 = boja4;
	}

	
	/**
	 * Metoda pomocu koje pozivamo metodu ubaciPanele i namjestamo layout.
	 */
	
	public void build() {
		setLayout(new GridBagLayout());
		spojiPanele();
	}

}
