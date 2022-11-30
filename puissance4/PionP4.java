import javax.swing.JButton;

/**
 * pion graphique du jeu de Puissance4
 * 
 * @version 6.0
 */
public class PionP4 extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * numero de la colonne ou se trouve le pion
     */
    private int colonne;

    /**
     * construit un pionP4
     * 
     * @param j
     *            numero de la colonne ou se trouve le pion
     */
    public PionP4(int j) {
        this.colonne = j;
    }

    /**
     * retourne le numero de la colonne du pion
     * 
     * @return numero de la colonne
     */
    public int getColonne() {
        return (this.colonne);
    }
}
