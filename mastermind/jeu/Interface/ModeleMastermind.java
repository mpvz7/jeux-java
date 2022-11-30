package Interface;

import java.io.Serializable;

public class ModeleMastermind implements Serializable{

	private static final long serialVersionUID = 0;

    /**
     * combinaison ordinateur
     */
    private int combinaison[];

    /**
     * nombre de valeurs entieres differentes pouvant etre generees
     */
    private int nbValeurs;

    /**
     * taille de la combinaison
     */
    private int taille;

    /**
     * cree une instance ModeleMastermind
     */
    public ModeleMastermind(int nbValeurs, int taille) {
    	this.nbValeurs = nbValeurs;
    	this.taille = taille;
        this.combinaison = new int[this.taille];
    }

    /**
     * genere aleatoirement une combinaison de taille taille dont les valeurs
     * sont comprises entre 0 et nbValeurs-1
     */
    public void genererCombinaison() {
        for (int i = 0; i < this.taille; i++) {
            this.combinaison[i] = (int) (this.nbValeurs * Math.random());
        }
    }

    /**
     * renvoie la combinaison de l'ordinateur
     * 
     * @return tableau representant la combinaison
     */
    public int[] getCombinaison() {
        return (this.combinaison);
    }

    /**
     * indique le nombre de chiffres bien places dans le tableau passe en
     * parametre
     * 
     * @param tableau
     *            contenant la combinaison a verifier
     * @return nombre de chiffres bien places
     */
    public int nbChiffresBienPlaces(int tabChiffres[]) {
        int v = 0;
        for (int i = 0; i < this.taille; i++) {
            if (this.combinaison[i] == tabChiffres[i]) {
                v++;
            }
        }
        return v;
    }

    /**
     * indique le nombre de chiffres mal places dans le tableau passe en
     * parametre
     * 
     * @param tableau
     *            contenant la combinaison a verifier
     * @return nombre de chiffres mal places
     */
    public int nbChiffresMalPlaces(int tabChiffres[]) {
        int v = 0;
        int combinaisonAux[] = new int[this.taille];
        int tabChiffresAux[] = new int[this.taille];
        for (int i = 0; i < this.taille; i++) {
            combinaisonAux[i] = combinaison[i];
            tabChiffresAux[i] = tabChiffres[i];
            if (tabChiffresAux[i] == combinaisonAux[i]) {
                combinaisonAux[i] = -1;
                tabChiffresAux[i] = -2;
            }
        }
        for (int i = 0; i < this.taille; i++) {
            boolean trouve = false;
            for (int j = 0; j < this.taille && !trouve; j++) {
                if (tabChiffresAux[i] == combinaisonAux[j]) {
                    v++;
                    combinaisonAux[j] = -1;
                    tabChiffresAux[i] = -2;
                    trouve = true;
                }
            }
        }
        return v;
    }

    /**
     * produit une version unicode de la combinaison
     * 
     * @return la combinaison
     */
    public String toString() {
        String c = "( ";
        for (int i = 0; i < this.taille; i++) {
            c = c + this.combinaison[i] + " ";
        }
        c = c + ")";
        return c;
    }
}
