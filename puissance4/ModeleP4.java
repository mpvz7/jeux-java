/**
 * Classe correspondant au modèle du jeu Puissance 4
 */
public class ModeleP4 {
    private CouleurP4[][] grille;
    private int etat; // 0: enCours, 1: rougeGagnant, 2 : jauneGagnant, 3 :

    // nulle

    /**
     * construit un modèle du jeu Puissance 4 et initialise toutes les cases de
     * la grille à des cases vides
     */
    public ModeleP4() {
        this.grille = new CouleurP4[6][7];
        this.initialiser();
        System.out.println(this);
    }

    /**
     * initialise toutes les cases de la grille à des cases vides
     */
    public void initialiser() {
        this.etat = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.grille[i][j] = CouleurP4.VIDE;
            }
        }
    }

    /**
     * examine si le joueur rouge a gagné
     * 
     * @return VRAI si 6 pions rouges ont été alignés verticalement
     *         horizontalement ou diagonalement
     */
    public boolean rougeGagnant() {
        return this.etat == 1;
    }

    /**
     * examine si le joueur jaune a gagné
     * 
     * @return VRAI si 6 pions rouges ont été alignés verticalement
     *         horizontalement ou diagonalement
     */
    public boolean jauneGagnant() {
        return this.etat == 2;
    }

    /**
     * examine si la partie est nulle
     * 
     * @return VRAI si toutes les cases de la grilles sont occupées par des
     *         pions sans que 4 cases consécutives n'aient été alignées par un
     *         des 2 joueurs
     */
    public boolean partieNulle() {
        return this.etat == 3;
    }

    /**
     * examine si la partie est finie
     * 
     * @return VRAI si la partie a été gagnée par les rouges ou par les jaunes
     *         ou si la partie est nulle
     */
    public boolean estPartieFinie() {
        return this.etat == 1 || this.etat == 2 || this.etat == 3;
    }

    /**
     * examine si la grille est pleine
     * 
     * @return VRAI si toutes les cases sont occupées par un pion
     */
    public boolean grillePleine() {
        for (int j = 0; j < 6; j++) {
            if (this.grille[0][j] == CouleurP4.VIDE) {
                return false;
            }
        }
        return true;
    }

    /**
     * fait tomber un pion dans une colonne de la grille et positionne la fin de
     * la partie
     * 
     * @param c
     *            couleur du pion
     * @param j
     *            colonne de la grille
     * @exception numéro
     *                de colonne inexistante
     * @exception colonne
     *                pleine
     * @exception couleur
     *                du pion autre que JAUNE et ROUGE
     * @exception partie
     *                finie
     */
    // 
    public void jouer(CouleurP4 c, int j) throws Exception {
        if (this.etat != 0) {
            throw new Exception("partie terminee");
        }
        if (j < 0 || j >= 7) {
            throw new Exception("numéro de colonne invalide");
        }
        if (c == CouleurP4.VIDE) {
            throw new Exception("couleur du pion invalide");
        }
        if (this.grille[0][j] != CouleurP4.VIDE) {
            throw new Exception("colonne pleine");
        }
        boolean place = false;
        int i;
        for (i = 5; i >= 0 && !place; i--) {
            if (this.grille[i][j] == CouleurP4.VIDE) {
                this.grille[i][j] = c;
                place = true;
            }
        }
        i++;
        int nb = 0;
        boolean fini = false;
        System.out.println(this);
        System.out.println("i = " + i + "    j = " + j);
        // tester si la partie est finie
        // test horizontal
        for (int h = 0; h < 7 && !fini; h++) {
            if (this.grille[i][h] == c) {
                nb++;
                if (nb == 4) {
                    fini = true;
                }
            } else {
                nb = 0;
            }
        }
        System.out.println("fin test horizontal");
        nb = 0;
        // test vertical
        for (int v = 0; v < 6 && !fini; v++) {
            if (this.grille[v][j] == c) {
                nb++;
                if (nb == 4) {
                    fini = true;
                }
            } else {
                nb = 0;
            }
        }
        System.out.println("fin test vertical");

        // test 1ere diagonale
        nb = 0;
        int i1 = i;
        int j1 = j;
        while (i1 > 0 && j1 > 0) {
            i1--;
            j1--;
        }
        for (int i2 = i1, j2 = j1; i2 < 6 && j2 < 7 && !fini; i2++, j2++) {
            if (this.grille[i2][j2] == c) {
                nb++;
                if (nb == 4) {
                    fini = true;
                }
            } else {
                nb = 0;
            }
        }
        System.out.println("fin test premiere diagonale");

        // test 2eme diagonale
        nb = 0;
        i1 = i;
        j1 = j;
        while (i1 > 0 && j1 < 6) {
            i1--;
            j1++;
        }
        for (int i2 = i1, j2 = j1; i2 < 6 && j2 >= 0 && !fini; i2++, j2--) {
            if (this.grille[i2][j2] == c) {
                nb++;
                if (nb == 4) {
                    fini = true;
                }
            } else {
                nb = 0;
            }
        }
        if (fini) {
            if (c == CouleurP4.ROUGE) {
                this.etat = 1;
            } else {
                this.etat = 2;
            }
        } else {
            if (this.grillePleine()) {
                this.etat = 3;
            }

        }
        System.out.println("fin test deuxieme diagonale");

    }

    /**
     * renvoie la couleur d'une case de coordonnées données
     * 
     * @param i
     *            indice de ligne
     * @param j
     *            indice de colonne
     * @exception i
     *                invalide
     * @exception j
     *                invalide
     */
    public CouleurP4 getCouleur(int i, int j) throws Exception {
        if (i < 0 || i >= 6) {
            throw new Exception("ligne invalide");
        }

        if (j < 0 || j >= 7) {
            throw new Exception("colonne invalide");
        }
        return this.grille[i][j];
    }

    /**
     * renvoie une version unicode de la grille de jeu
     * 
     * @return une chaîne de caractères représentant la grille
     */
    public String toString() {
        String r = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                r += this.grille[i][j] + "\t";
            }
            r += "\n";
        }
        return r;
    }

}
