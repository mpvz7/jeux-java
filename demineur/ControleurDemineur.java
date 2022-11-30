import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * Cette classe permet de controler les actions excercées sur la vue du Démineur
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.Color
 * @see java.awt.event.ActionEvent
 * @see java.awt.event.ActionListener
 * @see javax.swing.JButton
 * @see javax.swing.JOptionPane
 */
public class ControleurDemineur implements ActionListener{
	
	private VueDemineur vue; //la vue du démineur
	private ModeleDemineur modele; //le modèle du démineur
	private enum EtatControleur {DEBUT, DRAPEAU, DEMINER}; //les états du controleurs
	private EtatControleur etat; //l'état du controleur à un instant t
	private int nbCasesRestantes; //nombre de cases non minés restantes
	
	/**
	 * construction du controleur du démineur
	 * @param vue la vue que l'on veut écouter
	 */
	public ControleurDemineur(VueDemineur vue) {
		this.vue = vue;
		this.modele = new ModeleDemineur(10, 10);
		this.modele.genererGrille();
		this.etat = EtatControleur.DEBUT;
		this.nbCasesRestantes = 100-this.modele.getNbMines();
	}
	
	/**
	 * changement sur la vue généré après une action excercé sur la vue
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton)event.getSource();
		
		switch(this.etat) {
		case DEBUT :
			if(b.getText().equals("Drapeau"))
				this.etat = EtatControleur.DRAPEAU;
			else
				this.etat = EtatControleur.DEMINER;
			break;
		case DRAPEAU :
			b.setBackground(Color.red);
			this.etat = EtatControleur.DEBUT;
			break;
		case DEMINER : 
			this.etat = EtatControleur.DEBUT;
			int ligne = this.vue.getLigne(b);
			int colonne = this.vue.getColonne(b);
			int nbMinesAutour = 0;
			b.setEnabled(false);
			nbCasesRestantes--;
			//le bouton est une mine, le jeu se termine toutes les mines s'affichent
			if(this.modele.getMine(ligne, colonne)) {
				for(int i =0; i<this.modele.getDimension(); i++)
					for(int j = 0; j<this.modele.getDimension(); j++) {
						this.vue.getBouton(i,j).setEnabled(false);
						if(this.modele.getMine(i, j))
							this.vue.getBouton(i,j).setBackground(Color.black);
					}
				JOptionPane.showMessageDialog(null, "Booooum ! Vous gagnerez surement la prochaine fois !");
			
			}else {
				//le bouton est situé dans l'un des quatre coin de la grille
				if( ligne == 0 && colonne == 0) {
					if(this.modele.getMine(ligne,colonne+1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne+1,colonne))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne+1,colonne+1))
						nbMinesAutour++;	
				}else if(ligne == 0 && colonne == this.modele.getDimension()-1) {
					if(this.modele.getMine(ligne,colonne-1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne+1,colonne-1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne+1,colonne))
						nbMinesAutour++;
				}else if(ligne == this.modele.getDimension()-1 && colonne == 0) {
					if(this.modele.getMine(ligne,colonne+1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne-1,colonne+1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne-1,colonne))
						nbMinesAutour++;				
				}else if(ligne == this.modele.getDimension()-1 && colonne == this.modele.getDimension()-1) {
					if(this.modele.getMine(ligne-1,colonne-1))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne-1,colonne))
						nbMinesAutour++;	
					if(this.modele.getMine(ligne,colonne-1))
						nbMinesAutour++;
				//le bouton est situé sur les bordures du la grille
				}else if (ligne == 0) {
					for(int i = 0; i<2; i++)
						for(int j = -1; j<2; j++)
							if(this.modele.getMine(ligne+i,colonne+j))
								nbMinesAutour++;	
				}else if(colonne==0) {
					for(int i = 0; i<2; i++)
						for(int j = 0; j<2; j++)
							if(this.modele.getMine(ligne+i,colonne+j))
								nbMinesAutour++;
				}else if(ligne == this.modele.getDimension()-1) {
					for(int i = 0; i<1; i++)
						for(int j = -1; j<2; j++)
							if(this.modele.getMine(ligne+i,colonne+j))
								nbMinesAutour++;	
				}else if(colonne == this.modele.getDimension()-1) {
					for(int i = -1; i<2; i++)
						for(int j = 0; j<1; j++)
							if(this.modele.getMine(ligne+i,colonne+j))
								nbMinesAutour++;
				//le bouton est situé hors des bordures
				}else {		
					for(int i = -1; i<2; i++)
						for(int j = -1; j<2; j++)
							if(this.modele.getMine(ligne+i,colonne+j))
								nbMinesAutour++;	
				}
				//Afficher le nb de mines aux alentours du bouton
				if(nbMinesAutour != 0)
					b.setText(String.valueOf(nbMinesAutour));
				
				//les boutons restants sont des mines, le jeu est terminé
				if(nbCasesRestantes == 0)
					for(int i =0; i<this.modele.getDimension(); i++)
						for(int j = 0; j<this.modele.getDimension(); j++) {
							this.vue.getBouton(i,j).setEnabled(false);
							if(this.modele.getMine(i, j))
								this.vue.getBouton(i,j).setBackground(Color.black);
						}
			}
			break;
		}

	}

}
