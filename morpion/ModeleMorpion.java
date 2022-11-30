/**
 * Cette classe permet de creer le modèle du morpion
 * 
 * @author Mariam Parviz
 * @version %I%, %G%
 */
public class ModeleMorpion {
	
    private TypeCase grille[][]; // grille du jeu de morpion

    /**
     * construction du modèle du jeu de morpion
     */
    public ModeleMorpion() {
        this.grille = new TypeCase[3][3];
        this.initialiser();
    }

    /**
     * renvoie le type case pour une ligne et une colonne données
     * @param l ligne de la grille
     * @param c colonne de la grille
     * @return TypeCase pour la ligne et la colonne données
     * @throws IllegalArgumentException
     */
    public TypeCase getValeurCase(int l, int c) throws IllegalArgumentException {
        if (l < 0 || l > 3 || c < 0 || c > 3) {
            throw new IllegalArgumentException("indice incorrect");
        }
        return this.grille[l][c];
    }

     /**
     * renvoie si les cases sont alignées pour une ligne et une colonne données 
     * @param l ligne de la grille
     * @param c colonne de la grille
     * @return vrai si dans la grille cases sont alignées
     * @throws IllegalArgumentException
     */
    public boolean casesAlignees(int l, int c) throws IllegalArgumentException {
        if (l < 0 || l > 3 || c < 0 || c > 3) {
            throw new IllegalArgumentException("indice incorrect");
        }
        TypeCase t = this.grille[l][c];
        if (this.grille[l][c] == TypeCase.VIDE) {
            throw new IllegalArgumentException("case inoccupée");
        }
        boolean aligne = (this.grille[0][c] == t && this.grille[1][c] == t && this.grille[2][c] == t);
        if (aligne) {
            return aligne;
        }
        aligne = (this.grille[l][0] == t && this.grille[l][1] == t && this.grille[l][2] == t);
        if (aligne) {
            return aligne;
        }
        if ((l == 0 && c == 0) || (l == 1 && c == 1) || (l == 2 && c == 2)) {
            aligne = (this.grille[0][0] == t && this.grille[1][1] == t && this.grille[2][2] == t);
        }
        if (aligne) {
            return aligne;
        }
        if ((l == 0 && c == 2) || (l == 1 && c == 1) || (l == 2 && c == 0)) {
            aligne = (this.grille[0][2] == t && this.grille[1][1] == t && this.grille[2][0] == t);
        }
        return aligne;
    }

    /**
     * initialise la grille en la vidant
     */
    public void initialiser() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grille[i][j] = TypeCase.VIDE;
            }
        }
    }

     /**
     * @param l ligne de la grille
     * @param c colonne de la grille
     * @param j le type de la case que l'on va ajouter à la ligne et colonne données
     * @throws IllegalArgumentException
     */
    public void setValeurCase(int l, int c, TypeCase j) throws IllegalArgumentException {
        if (l < 0 || l > 3 || c < 0 || c > 3) {
            throw new IllegalArgumentException("indice incorrect");
        }

        if (this.grille[l][c] != TypeCase.VIDE) {
            throw new IllegalArgumentException("case déjà occupée");
        }
        this.grille[l][c] = j;
    }
    
    /**
	 * convertit la grille en une chaine de caractères
	 * @return la chaine de caractères associée à la grille
	 */
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += this.grille[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }
}