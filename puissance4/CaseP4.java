import javax.swing.JLabel;

/**
 * case graphique du jeu de Puissance4
 * 
 * @version 6.0
 */
public class CaseP4 extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * numero de la ligne ou se trouve la case
     */
    private int ligne;

    /**
     * numero de la colonne ou se trouve la case
     */
    private int colonne;

    /**
     * construit une CaseP4
     * 
     * @param i
     *            numero de la ligne ou se trouve la case
     * @param j
     *            numero de la colonne ou se trouve la case
     */
    public CaseP4(int i, int j) {
        this.ligne = i;
        this.colonne = j;
    }

    /**
     * retourne le numero de la ligne de la case
     * 
     * @return numero de la ligne
     */
    public int getLigne() {
        return (this.ligne);
    }

    /**
     * retourne le numero de la colonne de la case
     * 
     * @return numero de la colonne
     */
    public int getColonne() {
        return (this.colonne);
    }
}
