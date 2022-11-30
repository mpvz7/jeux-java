import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Cette classe permet de creer la vue du jeton
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 * @see java.awt.GridLayout
 * @see javax.swing.ImageIcon
 * @see javax.swing.JButton
 * @see javax.swing.JPanel
 */
public class VueJeton extends JPanel {

	/**
	 * Serialisation de la vue
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * construction de la vue du jeton
	 */
	public VueJeton() {
		
		this.setLayout(new GridLayout(2,2));
		ControleurJeton controleur = new ControleurJeton();
				
		JButton case1 = new JButton(new ImageIcon("./image.jpg"));		
		this.add(case1);
		case1.addActionListener(controleur);
		
		JButton case2 = new JButton();
		this.add(case2);
		case2.addActionListener(controleur);
		
		JButton case3 = new JButton();
		this.add(case3);
		case3.addActionListener(controleur);
		
		
		JButton case4 = new JButton();
		this.add(case4);
		case4.addActionListener(controleur);
	}
	
	/**
	 * @param c case de la grille
	 * @return vrai si le jeton n'est pas dans la case
	 */
	public static boolean estCaseVide(JButton c) {
		return c.getIcon()==null;
	}
	
	/**
	 * @param case1 case de la grille dans laquelle est le jeton
	 * @param case2 case de la grille dans laquelle on souhaite placer le jeton
	 */
	public static void deplacerJeton(JButton case1, JButton case2) {
		case1.setIcon(null);
		case2.setIcon(new ImageIcon("./image.jpg"));
	}	
	
}
