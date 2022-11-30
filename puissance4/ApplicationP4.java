import java.awt.GridLayout;

import javax.swing.JFrame;

public class ApplicationP4 {

	public static void main(String[] args) {
		
		JFrame jeu = new JFrame();
		jeu.setLayout(new GridLayout(1,1));
		
		jeu.add(new VueP4());
		
		jeu.setVisible(true);
		
		jeu.setTitle("Jeu du morpion");
		jeu.pack();
		jeu.setSize(700,700);
		jeu.setLocationRelativeTo(null);
	}

}
