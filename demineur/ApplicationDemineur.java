import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Cette classe permet d'afficher la vue du démineur dans une fenêtre
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.GridLayout
 * @see javax.swing.JFrame
 */
public class ApplicationDemineur {

	public static void main(String[] args) {
		
		/*
		ModeleDemineur demineur = new ModeleDemineur(10, 30);
		demineur.genererGrille();
		System.out.print(demineur.toString());
		*/
		
		JFrame fenetre = new JFrame();
		fenetre.setLayout(new GridLayout(1,1));
		fenetre.add(new VueDemineur());
		
		fenetre.setTitle("Demineur");
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setSize(700,700);
		fenetre.setLocationRelativeTo(null);
		
	}

}
