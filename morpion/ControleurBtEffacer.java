import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Cette classe permet de controler les actions du bouton effacer sur la vue du morpion
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.event.ActionEvent
 * @see java.awt.event.ActionListener
 */
public class ControleurBtEffacer implements ActionListener{

	private ModeleMorpion modele; //modele du morpion
	private VueMorpion vue; //vue du morpion
	
	/**
	 * construction d'un controleur du boutton effacer de la vue du morpion
	 * @param vue la vue que l'on souhaite mettre sous écoute
	 */
	public ControleurBtEffacer(VueMorpion vue) {
		this.vue = vue;
		this.modele = new ModeleMorpion();
	}

	/**
	 * changement sur la vue généré après une action excercé sur le boutton effacer de la vue
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.vue.initialiser();
		this.modele.initialiser();
	}
}
