import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Cette classe permet de controler les actions excercées sur la vue du jeton
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.event.ActionEvent
 * @see java.awt.event.ActionListener
 * @see javax.swing.JButton
 */
public class ControleurJeton implements ActionListener {

	private enum EtatControleur {ATTENTE_CLIC_DEPART, ATTENTE_CLIC_ARRIVEE}
	private EtatControleur etat; //etat du controleur
	private JButton bDepart; //sauvegarde du bouton de départ
	
	/**
	 * construction d'un controleur en initialisant son état
	 */
	public ControleurJeton() {
		this.etat = EtatControleur.ATTENTE_CLIC_DEPART;
	}
	
	/**
	 * changement excercé sur la vue lors d'une action sur la vue
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JButton b = (JButton)event.getSource();
			
		switch(this.etat) {		
		case ATTENTE_CLIC_DEPART :			
			if(!VueJeton.estCaseVide(b)){
				this.bDepart = b;
				this.etat = EtatControleur.ATTENTE_CLIC_ARRIVEE;
			}	
			break;
		case ATTENTE_CLIC_ARRIVEE :
			VueJeton.deplacerJeton(this.bDepart,b);
			this.etat = EtatControleur.ATTENTE_CLIC_DEPART;
		}
	}

}
