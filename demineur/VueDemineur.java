import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Cette classe permet de creer la vue du démineur
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.BorderLayout
 * @see java.awt.Color
 * @see java.awt.GridLayout
 * @see javax.swing.JTextField
 * @see javax.swing.JButton
 * @see javax.swing.JPanel
 */
public class VueDemineur extends JPanel {
	
	/**
	 * sérialise la vue
	 */
	private static final long serialVersionUID = 1L;
	private JButton[][] grille; //grille de bouttons du jeu
	private int dimension; //dimension de la grille du jeu
	
	/**
	 * construction d'une vue avec la grille
	 */
	public VueDemineur() {
		this.dimension = 10;
		this.setLayout(new BorderLayout());
		ControleurDemineur controleur = new ControleurDemineur(this);
		
		JPanel pNord = new JPanel();
		pNord.setLayout(new GridLayout(1,2));
		JTextField timer = new JTextField("");
		timer.setEnabled(false);
		pNord.add(timer);
		JButton drapeau = new JButton();
		drapeau.setBackground(Color.red);
		drapeau.addActionListener(controleur);
		drapeau.setText("Drapeau");
		pNord.add(drapeau);
		
		this.add(pNord, BorderLayout.NORTH);
		
		JPanel pCentre = new JPanel();
		pCentre.setLayout(new GridLayout(this.dimension, this.dimension));
		this.grille = new JButton[this.dimension][this.dimension];
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++) {
				this.grille[i][j]= new JButton();
				this.grille[i][j].addActionListener(controleur);
				pCentre.add(this.grille[i][j]);
			}
		
		this.add(pCentre, BorderLayout.CENTER);
	}
	
	/**
	 * retourne la dimension de la grille
	 * @param dimension de la grille
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
	/**
	 * revoie la ligne du boutton
	 * @param b le boutton pour lequel on veut connaitre la ligne
	 * @return la ligne du boutton mis en paramètre
	 */
	public int getLigne(JButton b) {
		int ligne = 0;
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++)
				if(b == this.grille[i][j])
					ligne = i;
		return ligne;
	}
	
	/**
	 * revoie la colonne du boutton
	 * @param b le boutton pour lequel on veut connaitre la colonne
	 * @return la colonne du boutton mis en paramètre
	 */
	public int getColonne(JButton b) {
		int colonne = 0;
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++)
				if(b == this.grille[i][j])
					colonne = j;
		return colonne;
	}
	
	/**
	 * revoie le boutton de la grille situé à la ligne et la colonne donnée
	 * @param i la ligne de la grille
	 * @param j la colonne de la grille
	 * @return le boutton situé sur la ligne et la colonne données
	 */
	public JButton getBouton(int i, int j) {
		return this.grille[i][j];
	}


}
