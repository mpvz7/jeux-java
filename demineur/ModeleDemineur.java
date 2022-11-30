/**
 * Cette classe permet de creer le mod�le de jeu du d�mineur
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 */
public class ModeleDemineur {
	
	private int dimension; //taille d'une ligne/colonne de la grille
	private boolean[][] grille; //grille de bool�ens du jeu (presence ou non de mine dans la case)
	private int nbMines; //nombre de mines plac�es dans le jeu
	
	/**
	 * Construction du mod�le du d�mineur
	 * @param dimension taille de la grille que l'on veut
	 * @param nbMines nombre de mines que l'on veut
	 */
	public ModeleDemineur(int dimension,int nbMines) {
		this.dimension = dimension;
		this.grille = new boolean[this.dimension][this.dimension];
		this.nbMines = nbMines;
	}
	
	/**
	 * g�n�re les mines de la grille de booleens de fa�ons al�atoires 
	 */
	public void genererGrille() {
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++)
				this.grille[i][j] = (this.nbMines >= Math.random()*100);
	}
	
	/**
	 * Compter le nombre de mines v�ritablement g�n�r�es dans la grille 
	 */
	public void actualiserNbMines() {
		this.nbMines = 0;
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++)
				if(this.grille[i][j])
					nbMines++;
	}
	
	/**
	 * renvoie si la case de la grille a une mine
	 * @param i la ligne de la grille
	 * @param j la colonne de la grille
	 * @return vrai s'il y a la pr�sence d'une mine
	 */
	public boolean getMine(int i, int j) {
		return this.grille[i][j];
	}
	
	/**
	 * renvoie le nombre r�elle de mines
	 * @return le nombre de mines
	 */
	public int getNbMines() {
		return this.nbMines;
	}
	
	/**
	 * renvoie la dimension de la grille
	 * @return la dimension de la grille
	 */
	public int getDimension() {
		return this.dimension;
	}
	
	
	/**
	 * convertit la grille en une grille de X pour la presence d'une mine ou O sinon
	 * @return la chaine de caract�re associ� � la grille
	 */
	public String toString() {
		String txt = new String("");
		for(int i = 0; i<this.dimension; i++) {
			for(int j = 0; j<this.dimension; j++) {
				if(this.grille[i][j])
					txt += "X ";
				else
					txt +="O ";
			}		
			txt += "\n";
		}
		return txt;
	}
	
}
