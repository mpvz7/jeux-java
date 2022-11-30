import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Cette classe permet de construire un <b>panneau</b> composé de trois
 * étiquettes et de trois champs de texte
 * 
 * @author Christine JULIEN
 * @version 1.1.6
 * @see java.awt.Canvas
 * @see java.awt.GridLayout
 * @see java.awt.event.FocusAdapter
 * @see java.awt.event.FocusEvent
 */

public class VueCouleur extends JPanel {
    /**
     * champ textuel associé à la valeur de la nuance rouge
     */
    private JTextField tRouge;

    /**
     * champ textuel associé à la valeur de la nuance verte
     */
    private JTextField tVert;

    /**
     * champ textuel associé à la valeur de la nuance bleue
     */
    private JTextField tBleu;

    /**
     * canevas dont la couleur de fond correspond à la combinaison des nuances
     * RVB
     */
    private JTextField cCouleur;

    /**
     * construit une vue couleur
     */
    public VueCouleur() {
        // sélectionner le gestionnaire de mise en page du PanneauCouleur :
        // grille d'1 ligne et de 2 colonnes
        this.setLayout(new GridLayout(1, 2));
        // créer un canevas de couleur de fond noire
        this.cCouleur = new JTextField();
        this.cCouleur.setEditable(false);;
        this.cCouleur.setBackground(Color.black);
        // associer le canevas au PanneauCouleur
        this.add(this.cCouleur);
        // créer un panneau puis sélectionner
        // son gestionnaire de mise en page : grille de 3 lignes et 3 colonnes
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        // ajouter le panneau à l'instance courante
        this.add(p);
        // créer et ajouter dans le panneau
        // l'étiquette de libellé "rouge" aligné à droite et un champ de texte
        // initialisé à "0"
        p.add(new JLabel("rouge", Label.RIGHT));
        this.tRouge = new JTextField("0");
        p.add(this.tRouge);
        // créer et ajouter dans le panneau
        // l'étiquette de libellé "vert" aligné à droite et un champ de texte
        // initialisé à "0"
        p.add(new JLabel("vert", Label.RIGHT));
        this.tVert = new JTextField("0");
        p.add(this.tVert);
        // créer et ajouter dans le panneau
        // l'étiquette de libellé "bleu" aligné à droite et un champ de texte
        // initialisé à "0"
        p.add(new JLabel("bleu", Label.RIGHT));
        this.tBleu = new JTextField("0");
        p.add(this.tBleu);
        // associer un controleur de focus à chaque
        // champ de texte pour être à l'écoute d'un changement de focus
        ControleurTexte controleur = new ControleurTexte(this);
        this.tRouge.addCaretListener(controleur);
        this.tVert.addCaretListener(controleur);
        this.tBleu.addCaretListener(controleur);
    }

    /**
     * change la couleur de fond du canevas
     */
    public void setCouleurCanvas(Color c) {
        this.cCouleur.setBackground(c);
    }

    /**
     * accède au champ textuel contenant la nuance rouge
     */
    public JTextField getTRouge() {
    	/*
    	if(this.tRouge == null) {
    		return new JTextField("0");
    	}else{
    	*/
    		return this.tRouge;
    	//}
    }

    /**
     * accède au champ textuel contenant la nuance verte
     */
    public JTextField getTVert() {
        return this.tVert;
    }

    /**
     * accède au champ textuel contenant la nuance bleue
     */
    public JTextField getTBleu() {
        return this.tBleu;
    }
}
