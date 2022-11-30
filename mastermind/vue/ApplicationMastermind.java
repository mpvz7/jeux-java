import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationMastermind {

	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame();
		
		VueMastermind vue = new VueMastermind();
		
		fenetre.setLayout(new GridLayout(1,1));
		fenetre.add(vue);
		
		fenetre.setTitle("Mastermind");
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setSize(450,700);
		fenetre.setLocationRelativeTo(null);
		 
	}

}
