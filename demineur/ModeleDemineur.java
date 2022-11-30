/**
 * Cette classe permet de creer le modèle de jeu du démineur
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 */
public class ModeleDemineur {
	
	private int dimension; //taille d'une ligne/colonne de la grille
	private boolean[][] grille; //grille de booléens du jeu (presence ou non de mine dans la case)
	private int nbMines; //nombre de mines placées dans le jeu
	
	/**
	 * Construction du modèle du démineur
	 * @param dimension taille de la grille que l'on veut
	 * @param nbMines nombre de mines que l'on veut
	 */
	public ModeleDemineur(int dimension,int nbMines) {
		this.dimension = dimension;
		this.grille = new boolean[this.dimension][this.dimension];
		this.nbMines = nbMines;
	}
	
	/**
	 * génére les mines de la grille de booleens de façons aléatoires 
	 */
	public void genererGrille() {
		for(int i = 0; i<this.dimension; i++)
			for(int j = 0; j<this.dimension; j++)
				this.grille[i][j] = (this.nbMines >= Math.random()*100);
	}
	
	/**
	 * Compter le nombre de mines véritablement générées dans la grille 
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
	 * @return vrai s'il y a la présence d'une mine
	 */
	public boolean getMine(int i, int j) {
		return this.grille[i][j];
	}
	
	/**
	 * renvoie le nombre réelle de mines
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
	 * @return la chaine de caractère associé à la grille
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
