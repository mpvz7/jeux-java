package Controleur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Interface.ModeleMastermind;
import Interface.VueMastermind;

public class ControleurMastermind implements ActionListener, Serializable{

	private static final long serialVersionUID = 0;
	
	private ModeleMastermind modele;
	private VueMastermind vue;
	private Color CouleurSauvee;
	private int nbEssaies;
	
	private enum EtatControleur {DEBUT_COMBINAISON, CHOIX_COULEUR, CHOIX_POSITION};
	private EtatControleur etat;
	
	public ControleurMastermind(VueMastermind vue) {
		this.vue = vue;
		this.modele = new ModeleMastermind(this.vue.getNbCouleurs(),this.vue.getTaille());
		this.modele.genererCombinaison();
		this.etat = EtatControleur.DEBUT_COMBINAISON;
		this.nbEssaies = 0;
		this.CouleurSauvee = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton b = (JButton)event.getSource();
		
		switch(this.etat) {
		case DEBUT_COMBINAISON :
			if(this.vue.appartientPalette(b)) {
				this.CouleurSauvee = b.getBackground();
				this.etat = EtatControleur.CHOIX_COULEUR;
			}
			break;
		case CHOIX_COULEUR :
			if(this.vue.appartientCombinaison(b,this.nbEssaies)) {
				b.setBackground(this.CouleurSauvee);
				this.etat = EtatControleur.CHOIX_POSITION;
			}
			break;
		case CHOIX_POSITION:
			
			if(this.vue.appartientPalette(b)) {
				this.CouleurSauvee = b.getBackground();
				this.etat = EtatControleur.CHOIX_COULEUR;
			}
			
			if(b.getText().equals("Valider") 
					&& this.vue.combinaisonComplete(this.nbEssaies)) {
				
				int[] combinaisonJoueur = this.vue.combinaisonEnEntiers(this.nbEssaies);
				int nbBP = this.modele.nbChiffresBienPlaces(combinaisonJoueur);
				int nbMP = this.modele.nbChiffresMalPlaces(combinaisonJoueur);
				
				if((this.nbEssaies < this.vue.NBMAX_COMBINAISONS-1) && 
						(nbBP != this.vue.getTaille())){
					this.vue.afficherBP(this.nbEssaies, nbBP );
					this.vue.afficherMP(this.nbEssaies, nbMP);
					this.vue.desactiverCombinaison(this.nbEssaies);
					this.nbEssaies++;
					this.vue.activerCombinaison(this.nbEssaies);
					
				}else {
					int[] combinaisonOrdi = this.modele.getCombinaison();
					
					this.vue.afficherBP(this.nbEssaies, nbBP );
					this.vue.afficherMP(this.nbEssaies, nbMP);
					this.vue.desactiverCombinaison(this.nbEssaies);
					this.vue.afficherCombinaisonOrdinateur(combinaisonOrdi);
					
					if(nbBP == this.vue.getTaille()) {
						JOptionPane.showMessageDialog(null, "Bravo vous avez reussi !");
					}
				}
			}
			break;
		}
	}
	
}
