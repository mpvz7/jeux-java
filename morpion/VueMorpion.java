import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Cette classe permet de creer la vue du morpion
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.BorderLayout
 * @see java.awt.GridLayout
 * @see javax.swing.JButton
 * @see javax.swing.JLabel
 * @see javax.swing.JPanel
 */
public class VueMorpion extends JPanel {

	/**
	 * sérialise la vue
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] btCaseGrille; //grille de boutton
	private JLabel lJoueur; //Nom du joueur
	private JLabel lResultat; //resulat de la partie
	
	/**
	 * construction d'une vue
	 */
	public VueMorpion() {
		
		ControleurMorpion controleur = new ControleurMorpion(this);
		
		//insertion du gestionnaire d'affichage
		this.setLayout(new BorderLayout());
		//insertion du panneau 1 au nord
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,2));
		this.add(p1, BorderLayout.NORTH);
		//insertion du panneau 2 au centre
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3,3));
		this.add(p2,BorderLayout.CENTER);
		
		//insertion du label au sud
		this.lResultat = new JLabel(" ");
		this.add(this.lResultat, BorderLayout.SOUTH);
		
		JButton effacer = new JButton("Effacer");
		p1.add(effacer);
		effacer.addActionListener(controleur);
		
		this.lJoueur = new JLabel("Joueur 1");
		p1.add(this.lJoueur);
		
		this.btCaseGrille = new JButton [9];
		for(int i=0; i<9; i++) {
			this.btCaseGrille[i] = new JButton();
			this.btCaseGrille[i].addActionListener(controleur);
			p2.add(this.btCaseGrille[i]);
		}		
	}
	
	/**
	 * renvoie les coordonnées ligne et colonne du boutton
	 * @param b boutton de la grille
	 * @return le couple de coordonnées du boutton
	 */
	public Couple coordonnéesBtCaseGrille(JButton b) {
		for(int i = 0; i<9; i++) {
			if(this.btCaseGrille[i] == b) {
				return new Couple(i/3,i%3);
			}
		}
		return null;
	}
	
	/**
	 * initialise le jeu en vidant la grille, le resultat, et laissant le joueur1 commencer
	 */
	public void initialiser() {
		for(JButton b : this.btCaseGrille) {
			b.setText("");
			b.setEnabled(true);
		}
		this.lJoueur.setText("Joueur 1");
		this.lResultat.setText(" ");
	}
	
	/**
	 * affiche le resultat du gagnant
	 * @param numeroJoueur numéro du joeur qui a gagné
	 */
	public void afficherResultat(int numeroJoueur) {
		this.lResultat.setText("Le joueur "+numeroJoueur+" a gagné !");
	}
	
	/**
	 * affiche le numéro du joueur en train de jouer
	 * @param numeroJoueur numéro du joueur en train de jouer
	 */
	public void afficherJoueurCourant(int numeroJoueur) {
		this.lJoueur.setText("Joueur "+numeroJoueur);
	}
}
