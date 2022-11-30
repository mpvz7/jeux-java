import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurP4 implements ActionListener {

	private enum Etat {ATTENTE_ROUGE, ATTENTE_JAUNE, PARTIE_FINIE};
	private Etat etat;
	private VueP4 vue;
	private ModeleP4 modele;
	
	public ControleurP4(VueP4 vue) {
		this.vue = vue;
		this.etat = Etat.ATTENTE_ROUGE;
		this.modele = new ModeleP4();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        // récupérer le bouton cliqué
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("rejouer")) {
            // réinitialiser la grille du modèle
            this.modele.initialiser();
            // mettre les pions rouge sur la rangée de la vue
            this.vue.setCouleurPion(CouleurP4.ROUGE);
            // rafraichir la vue de la grille à partir du modèle
           try {
			this.rafraichir();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            this.etat = Etat.ATTENTE_ROUGE;
        } else {
            PionP4 pion = (PionP4) b;
            switch (this.etat) {
            case ATTENTE_ROUGE:
                // un pion rouge a été cliqué
                // positionner un pion rouge dans la grille du
                // modèle à partir de son numéro de colonne
				try {
					this.modele.jouer(CouleurP4.ROUGE, pion.getColonne());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                // rafraichir la vue de la grille à partir du modèle
				try {
					this.rafraichir();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                // si la partie est finie
                if (this.modele.estPartieFinie()) {
                    this.etat = Etat.PARTIE_FINIE;
                    // ne mettre aucun pion sur la rangée du haut
                    this.vue.setCouleurPion(CouleurP4.VIDE);
                    // si la partie a été gagné par les rouges
                    if (this.modele.rougeGagnant()) {
                        // ajouter 1 au score des rouges
                        this.vue.incrementerRouge();
                    } else {
                        // sinon la partie est nulle
                        // ajouter 1 au nombre de parties nulles
                        this.vue.incrementerVide();
                    }
                } else {
                    // sinon la partie n'est pas finie
                    // positionner les pions jaunes sur la rangée
                    this.vue.setCouleurPion(CouleurP4.JAUNE);
                    this.etat = Etat.ATTENTE_JAUNE;
                }
                break;
            case ATTENTE_JAUNE:
                // un pion jaune a été cliqué
				try {
					this.modele.jouer(CouleurP4.JAUNE, pion.getColonne());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                if (this.modele.estPartieFinie()) {
                    this.etat = Etat.PARTIE_FINIE;
                    this.vue.setCouleurPion(CouleurP4.VIDE);
                    if (this.modele.jauneGagnant()) {
                        this.vue.incrementerJaune();
                    } else {
                        this.vue.incrementerVide();
                    }
                } else {
                    this.vue.setCouleurPion(CouleurP4.ROUGE);
                    this.etat = Etat.ATTENTE_ROUGE;
                }
                break;
            case PARTIE_FINIE:
            }
        }
    }
	
	public void rafraichir() throws Exception {
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                CouleurP4 couleurPion = this.modele.getCouleur(i - 1, j);
                this.vue.setImageCase(couleurPion, i, j);
            }
        }
	}

}
