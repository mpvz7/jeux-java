
/**
 * Cette classe permet de creer un couple
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 */
public class Couple {
	private int premier;
	private int second;
	
	/**
	 * creation d'un couple à partir de deux éléments
	 * @param premier premier du couple
	 * @param second second du couple
	 */
	public Couple(int premier, int second) {
		super();
		this.premier = premier;
		this.second = second;
	}
	/**
	 * @return le premier element du couple
	 */
	public int getPremier() {
		return this.premier;
	}
	
	/**
	 * @return le second element du couple
	 */
	public int getSecond() {
		return this.second;
	}	
}
