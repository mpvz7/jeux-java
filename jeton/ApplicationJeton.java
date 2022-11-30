import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Cette classe permet d'afficher la vue du jeton dans une fenêtre
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.GridLayout
 * @see javax.swing.JFrame
 */
public class ApplicationJeton {
	
	public static void main(String[] arg0) {
		
		VueJeton vue = new VueJeton();
		
		JFrame fenetre = new JFrame();
		fenetre.setLayout(new GridLayout(1,1));
		fenetre.add(vue);
		
		fenetre.setTitle("Jeton");
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setSize(250,250);
		fenetre.setLocationRelativeTo(null);
	}
}
