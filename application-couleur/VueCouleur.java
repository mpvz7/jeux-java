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
 * Cette classe permet de construire un <b>panneau</b> compos� de trois
 * �tiquettes et de trois champs de texte
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
     * champ textuel associ� � la valeur de la nuance rouge
     */
    private JTextField tRouge;

    /**
     * champ textuel associ� � la valeur de la nuance verte
     */
    private JTextField tVert;

    /**
     * champ textuel associ� � la valeur de la nuance bleue
     */
    private JTextField tBleu;

    /**
     * canevas dont la couleur de fond correspond � la combinaison des nuances
     * RVB
     */
    private JTextField cCouleur;

    /**
     * construit une vue couleur
     */
    public VueCouleur() {
        // s�lectionner le gestionnaire de mise en page du PanneauCouleur :
        // grille d'1 ligne et de 2 colonnes
        this.setLayout(new GridLayout(1, 2));
        // cr�er un canevas de couleur de fond noire
        this.cCouleur = new JTextField();
        this.cCouleur.setEditable(false);;
        this.cCouleur.setBackground(Color.black);
        // associer le canevas au PanneauCouleur
        this.add(this.cCouleur);
        // cr�er un panneau puis s�lectionner
        // son gestionnaire de mise en page : grille de 3 lignes et 3 colonnes
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        // ajouter le panneau � l'instance courante
        this.add(p);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "rouge" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("rouge", Label.RIGHT));
        this.tRouge = new JTextField("0");
        p.add(this.tRouge);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "vert" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("vert", Label.RIGHT));
        this.tVert = new JTextField("0");
        p.add(this.tVert);
        // cr�er et ajouter dans le panneau
        // l'�tiquette de libell� "bleu" align� � droite et un champ de texte
        // initialis� � "0"
        p.add(new JLabel("bleu", Label.RIGHT));
        this.tBleu = new JTextField("0");
        p.add(this.tBleu);
        // associer un controleur de focus � chaque
        // champ de texte pour �tre � l'�coute d'un changement de focus
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
     * acc�de au champ textuel contenant la nuance rouge
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
     * acc�de au champ textuel contenant la nuance verte
     */
    public JTextField getTVert() {
        return this.tVert;
    }

    /**
     * acc�de au champ textuel contenant la nuance bleue
     */
    public JTextField getTBleu() {
        return this.tBleu;
    }
}
