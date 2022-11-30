import java.awt.GridLayout;


import javax.swing.JFrame;
/**
 * Cette classe permet d'afficher la vue du morpion dans une fenêtre
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.GridLayout
 * @see javax.swing.JFrame
 */
public class ApplicationMorpion {

	public static void main(String[] args) {
		
		JFrame jeu = new JFrame();
		jeu.setLayout(new GridLayout(1,1));
		
		jeu.add(new VueMorpion());
		
		jeu.setVisible(true);
		
		jeu.setTitle("Jeu du morpion");
		jeu.pack();
		jeu.setSize(200,300);
		jeu.setLocationRelativeTo(null);
		
	}

}
