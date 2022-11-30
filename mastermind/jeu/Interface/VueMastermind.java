package Interface;
import java.awt.*;
import java.io.Serializable;

import javax.swing.*;

import Controleur.ControleurMastermind;


public class VueMastermind extends JPanel implements Serializable {

	private static final long serialVersionUID = 0;

	//nombre de couleurs possible dans la combinaison a trouver
	private int nbCouleurs;
	
	//taille de la combinaison a trouver
	private int taille;
	
	//tableau des champs contenant le nombre de couleurs bien placees pour chaque combinaison.
	private JTextField[] bPIHM;
	
	//tableau des champs contenant les couleurs de la combinaison a trouver.
	private JTextField[] combinaisonOrdiIHM;
	
	//tableau des champs contenant les combinaisons de couleurs proposees par l'utilisateur.
	private JButton[][] combinaisonsJoueurIHM;
	
	//tableau des champs contenant le nombre de couleurs mal placees pour chaque combinaison.
	private JTextField[] mPIHM;
	
	//ensemble des boutons contenant les couleurs de la palette
	private JButton[] paletteIHM;
	
	public final int NBMAX_COMBINAISONS = 10; 

	public VueMastermind(int nbCouleurs, int taille) {
		
		this.nbCouleurs = nbCouleurs;
		this.taille = taille;
		this.bPIHM = new JTextField[NBMAX_COMBINAISONS];
		this.combinaisonOrdiIHM = new JTextField[this.taille];
		this.combinaisonsJoueurIHM = new JButton[NBMAX_COMBINAISONS][this.taille];
		this.mPIHM = new JTextField[NBMAX_COMBINAISONS];
		this.paletteIHM = new JButton[this.nbCouleurs];
		
		this.setLayout(new BorderLayout());
		
		ControleurMastermind controleur = new ControleurMastermind(this);
		
		//Panneau 1
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		p1.add(new JLabel("Couleurs : "));
		
		JPanel btCouleurs = new JPanel();
		btCouleurs.setLayout(new GridLayout(1,this.nbCouleurs));
		Color[] tabCouleurs = {Color.blue, Color.red, Color.green, Color.yellow, Color.white, Color.orange, 
				Color.cyan, Color.darkGray, Color.pink, Color.magenta};
		for(int i=0; i<this.paletteIHM.length;i++) {
			this.paletteIHM[i] = new JButton();
			this.paletteIHM[i].setBackground(tabCouleurs[i]);
			this.paletteIHM[i].addActionListener(controleur);
			this.paletteIHM[i].setPreferredSize(new Dimension(50,50));
			btCouleurs.add(this.paletteIHM[i]);
		}
		
		p1.add(btCouleurs);
		
		this.add(p1, BorderLayout.NORTH);

		
		//Panneau 2
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(NBMAX_COMBINAISONS,2));
				
		for(int i=0; i<NBMAX_COMBINAISONS; i++) {
		
			JPanel jeuCouleurs = new JPanel();
			jeuCouleurs.setLayout(new GridLayout(1,this.taille));
			JPanel indication = new JPanel();
			indication.setLayout(new GridLayout(2,2));
			
			for(int j = 0; j<this.combinaisonsJoueurIHM[i].length; j++) {
				this.combinaisonsJoueurIHM[i][j] = new JButton();
				this.combinaisonsJoueurIHM[i][j].addActionListener(controleur);
				this.combinaisonsJoueurIHM[i][j].setEnabled(false);
				jeuCouleurs.add(this.combinaisonsJoueurIHM[i][j]);
			}
			
			indication.add(new JLabel("BP"));
			indication.add(new JLabel("MP"));
			this.bPIHM[i] = new JTextField();
			this.bPIHM[i].setEnabled(false);
			indication.add(this.bPIHM[i]);
			this.mPIHM[i] = new JTextField();
			this.mPIHM[i].setEnabled(false);
			indication.add(this.mPIHM[i]);
			
			p2.add(jeuCouleurs);
			p2.add(indication);
		}
		
		this.add(p2, BorderLayout.CENTER);
		
		
		//Panneau 3
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,2));
		
		JPanel combinaison = new JPanel();
		combinaison.setLayout(new GridLayout(1,this.taille));
		
		for(int i=0; i<this.combinaisonOrdiIHM.length;i++) {
			this.combinaisonOrdiIHM[i] = new JTextField();
			this.combinaisonOrdiIHM[i].setEnabled(false);
			combinaison.add(this.combinaisonOrdiIHM[i]);	
		}
		
		p3.add(combinaison);
		JButton valider = new JButton("Valider");
		valider.addActionListener(controleur);
		p3.add(valider);
		
		this.add(p3, BorderLayout.SOUTH);
		this.activerCombinaison(0);
	}
	
	//rend actif les boutons de la combinaison de rang donne
	public void activerCombinaison(int i) {
		for(int j=0; j<this.combinaisonsJoueurIHM[i].length; j++ ) {
			this.combinaisonsJoueurIHM[i][j].setEnabled(true);
		}
	}
	
	//affiche pour la combinaison de rang i du joueur le nombre de couleurs bien placees
	public void afficherBP(int i, int nbBP) {
		this.bPIHM[i].setText(Integer.toString(nbBP));
	}
	
	//affiche la combinaison de l'ordinateur en bas du panneau en fonction d'un tableau d'entiers codant les couleurs
	public void afficherCombinaisonOrdinateur(int[] tableauCouleurs) {		
		for(int i = 0; i<this.combinaisonOrdiIHM.length; i++) {
			this.combinaisonOrdiIHM[i].setText(Integer.toString(tableauCouleurs[i]));
		}
	}
	
	//affiche pour la combinaison de rang i du joueur le nombre de couleurs mal placees
	public void afficherMP(int i, int nbMP) {
		this.mPIHM[i].setText(Integer.toString(nbMP));
	}
	
	//////////////////////////////////////////////////////////////////////////
	//examine si le bouton b appartient au tableau des boutons contenant la combinaison de rang donne
	public boolean appartientCombinaison(JButton b, int i) {
		for(JButton button : this.combinaisonsJoueurIHM[i]) {
			if(b.equals(button)) {
				return true;
			}
		}
		return false;
	}
	
	//examine si le bouton b appartient au tableau de la palette des couleurs possibles
	public boolean appartientPalette(JButton b) {
		for(JButton button : this.paletteIHM) {
			if(b.equals(button)) {
				return true;
			}
		}
		return false;
	}
	
	//code un entier en une couleur (par ex : 0 donne BLUE, 1 donne RED, 2 donne GREEN �)
	public Color chiffreEnCouleur(int i) {
		return this.paletteIHM[i].getBackground();
	}
	
	//teste si la combinaison de rang donne est complete (tous les boutons ont une couleur)
	public boolean combinaisonComplete(int i) {
		int[] tabCombi = this.combinaisonEnEntiers(i);
		for(int entier : tabCombi)
			if( entier<0|| entier>=this.paletteIHM.length)
				return false;		
		return true;
	}
	
	//convertit les couleurs contenues dans les boutons d'une combinaison de rand donne en un tableau d'entiers
	public int[] combinaisonEnEntiers(int i) {
		int[] tabEntiers = new int[this.combinaisonsJoueurIHM[i].length];
		for(int j = 0; j < this.combinaisonsJoueurIHM[i].length; j++) { 
				tabEntiers[j] = this.couleurEnChiffre(this.combinaisonsJoueurIHM[i][j].getBackground());
		}
		return tabEntiers;
	}
	
	//code une couleur en un entier (par ex : BLUE donne 0, RED donne 1, GREEN donne 2 �)
	public int couleurEnChiffre(Color c) {
		int entier = 99999;
		for(int k=0; k < this.paletteIHM.length; k++) {
			if(c.equals(this.paletteIHM[k].getBackground())) {
				entier = k;
			}
		}
		return entier;
	}
		
	//rend inactif les boutons de la combinaison de rang donne
	public void desactiverCombinaison(int i) {
		for(int j=0; j<this.combinaisonsJoueurIHM[i].length; j++ ) {
			this.combinaisonsJoueurIHM[i][j].setEnabled(false);
		}
	}

	//renvoie le nombre de couleurs disponibles
	public int getNbCouleurs() {
		return this.nbCouleurs;
	}

	//renvoie la taille de la combinaison
	public int getTaille() {
		return this.taille;
	}	
	
}
