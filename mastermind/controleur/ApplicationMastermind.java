import java.awt.GridLayout;
import javax.swing.JFrame;

public class ApplicationMastermind {

	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame();
		
		fenetre.setLayout(new GridLayout(1,1));
		fenetre.add(new VueMastermind(6,4));
		
		fenetre.setTitle("Mastermind");
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setSize(450,700);
		fenetre.setLocationRelativeTo(null);
		 
	}

}
