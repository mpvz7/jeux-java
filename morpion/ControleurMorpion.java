import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Cette classe permet de controler les actions excercées sur la vue du morpion
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.event.ActionEvent
 * @see java.awt.event.ActionListener
 * @see javax.swing.JButton
 */
public class ControleurMorpion implements ActionListener {

	private enum EtatControleur {
		JOUEUR1, JOUEUR2, PARTIE_FINIE 
	}
	
	private VueMorpion vue; //la vue du morpion
	private ModeleMorpion modele; //le modèle du morpion
	private EtatControleur etat; //l'état du controleur a chaque action excercé
	
	/**
	 * construction du controleur du morpion
	 * @param vue la vue que l'on veut écouter
	 */
	public ControleurMorpion(VueMorpion vue) {
		this.vue = vue;
		this.modele = new ModeleMorpion();
		this.etat = EtatControleur.JOUEUR1;
	}
	
	/**
	 * changement sur la vue généré après une action excercé sur la vue
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton)event.getSource();
		Couple c;
		int i;
		int j;
		
		if( b.getText().equals("Effacer")) {
			this.vue.initialiser();
			this.modele.initialiser();
			this.etat = EtatControleur.JOUEUR1;
		}else {
			switch(this.etat) {
			case JOUEUR1:
				b.setText("X");
				b.setEnabled(false);
				
				c = this.vue.coordonnéesBtCaseGrille(b);
				i = c.getPremier();
				j = c.getSecond();
				this.modele.setValeurCase(i, j, TypeCase.JOUEUR1);
				
				if (this.modele.casesAlignees(i, j)) {
					this.vue.afficherResultat(1);
					this.etat = EtatControleur.PARTIE_FINIE;
				}else {
					this.vue.afficherJoueurCourant(2);
					this.etat = EtatControleur.JOUEUR2;
				}
				break;
				
			case JOUEUR2:
				b.setText("O");
				b.setEnabled(false);
				
				c = this.vue.coordonnéesBtCaseGrille(b);
				i = c.getPremier();
				j = c.getSecond();
				this.modele.setValeurCase(i, j, TypeCase.JOUEUR2);
				
				if (this.modele.casesAlignees(i, j)) {
					this.vue.afficherResultat(2);
					this.etat = EtatControleur.PARTIE_FINIE;
				}else {
					this.vue.afficherJoueurCourant(1);
					this.etat = EtatControleur.JOUEUR1;
				}
				break;
			case PARTIE_FINIE:
				break;
			}
		}

	}

}
