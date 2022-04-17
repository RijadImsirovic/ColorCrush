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

/**
 * Ova klasa pravi glavni meni u igri
 * @author Rijad
 * 
 */

public class MainMenu extends JPanel {
	JLabel trenutni_rez;
	JLabel ukupni_rez;
	JLabel potezi;
	JLabel naslov;
	
	JButton dugme_play;
	JButton dugme_exit;
	
	/**
	 * Metoda koja pravi pocetni meni u igrici.
	 */
	
	private void build() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		naslov = new JLabel("COLOR CRUSH");
		naslov.setFont(new Font("", Font.PLAIN, 40));
		c.insets = new Insets(100, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		add(naslov,c);
		c.weightx=0;
		c.weighty=0;
		
		dugme_play = new JButton("PLAY");
		dugme_play.setPreferredSize(new Dimension(250,55));
		c.insets = new Insets(50, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;
		add(dugme_play, c);
		c.weightx=0;
		c.weighty=0;
		
		
		dugme_exit = new JButton("EXIT");
		dugme_exit.setPreferredSize(new Dimension(250,55));
		c.insets = new Insets(10, 10, 150, 10);
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 0;
		add(dugme_exit, c);
		c.weightx=0;
		c.weighty=0;
		
		dugme_exit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	System.exit(0);
	        }
	    });
		
		JLabel l = new JLabel();
		c.gridx=2;
		c.gridy=2;
		c.weightx=0.2;
		c.weighty=0.2;
		add(l,c);
		c.weightx=0;
		c.weighty=0;
	}

	/**
	 * Konstruktor koji poziva metode.
	 */
	
	public MainMenu() {
		build();
	}
}
