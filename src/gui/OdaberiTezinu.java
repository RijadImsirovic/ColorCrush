package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Ova klasa pravi meni gdje biramo tezinu
 * @author Rijad
 * 
 */

public class OdaberiTezinu extends JPanel {

	JLabel naslov;
	JButton dugme_normal;
	JButton dugme_custom;
	
	
	/**
	 * Metoda koja pravi meni gdje biramo mod koji zelimo igrati.
	 */
	
	private void build() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		naslov = new JLabel("ODABERI MOD KOJI ZELIS IGRATI");
		naslov.setFont(new Font("", Font.PLAIN, 40));
		c.insets = new Insets(100, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(naslov, c);
		c.weightx = 0;
		c.weighty = 0;

		dugme_normal = new JButton("NORMAL");
		dugme_normal.setPreferredSize(new Dimension(250, 55));
		c.insets = new Insets(50, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;
		add(dugme_normal, c);
		c.weightx = 0;
		c.weighty = 0;

		dugme_custom = new JButton("CUSTOM");
		dugme_custom.setPreferredSize(new Dimension(250, 55));
		c.insets = new Insets(10, 10, 150, 10);
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;
		add(dugme_custom, c);
		c.weightx = 0;
		c.weighty = 0;

		JLabel l = new JLabel();
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 0.2;
		c.weighty = 0.2;
		add(l, c);
		
		c.weightx = 0;
		c.weighty = 0;
	}

	/**
	 * Konstruktor koji poziva metodu build.
	 */
	
	public OdaberiTezinu() {
		build();
	}

}
