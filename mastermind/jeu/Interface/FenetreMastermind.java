package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controleur.ControleurCouleurs;
import Controleur.ControleurQuitter;
import Controleur.ControleurRejouer;
import Controleur.ControleurRestaurer;
import Controleur.ControleurSauvegarder;
import Controleur.ControleurTaille;

public class FenetreMastermind extends JFrame  implements Serializable{

	private static final long serialVersionUID = 0;
	
	private JMenuItem itemNbCouleurs;
	private JMenuItem itemTailleCombinaison;
	private VueMastermind vueMastermind;

	public FenetreMastermind() {
		
		this.setLayout(new BorderLayout());
		
		JMenuBar BarreMenu = new JMenuBar();
		//Menu Jeu
		JMenu menu = new JMenu("Jeu");
		//Item rejouer
		JMenuItem rejouer = new JMenuItem("Rejouer");
		rejouer.addActionListener(new ControleurRejouer(this));
		menu.add(rejouer);
		//Item sauvegarder
		JMenuItem sauvegarder = new JMenuItem("Sauvegarder");
		sauvegarder.addActionListener(new ControleurSauvegarder(this));
		menu.add(sauvegarder);
		//Item restaurer
		JMenuItem restaurer = new JMenuItem("Restaurer");
		restaurer.addActionListener(new ControleurRestaurer(this));
		menu.add(restaurer);
		
		menu.addSeparator();
		//Item quitter
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ControleurQuitter(this));
		menu.add(quitter);
		
		//Menu Options
		JMenu options = new JMenu("Options");
		//Menu nombre de couleurs
		JMenu nbCouleurs = new JMenu("nombre de couleurs");
		//Items nombres
		ControleurCouleurs cCouleurs = new ControleurCouleurs(this);
		JMenuItem[] tabCouleurs = new JMenuItem[11];
		tabCouleurs[0] = new JMenuItem();
		tabCouleurs[1] = new JMenuItem();
		for(int i = 2; i<tabCouleurs.length;i++) {
			tabCouleurs[i] = new JMenuItem(Integer.toString(i));
			tabCouleurs[i].addActionListener(cCouleurs);
			nbCouleurs.add(tabCouleurs[i]);
		}
		
		//Instanciation itemNbCouleurs
		this.itemNbCouleurs = tabCouleurs[6];
		this.itemNbCouleurs.setBackground(Color.RED);
		options.add(nbCouleurs);
		
		//Menu nombre de couleurs
		JMenu taille = new JMenu("taille combinaison");
		//Item nombres
		ControleurTaille cTaille = new ControleurTaille(this);
		JMenuItem[] tabTailles = new JMenuItem[11];
		tabTailles[0] = new JMenuItem();
		tabTailles[1] = new JMenuItem();
		for(int i = 2; i<tabCouleurs.length;i++) {
			tabTailles[i] = new JMenuItem(Integer.toString(i));
			tabTailles[i].addActionListener(cTaille);
			taille.add(tabTailles[i]);
		}
		//Instanciation itemNbTailleCombinaison
		this.itemTailleCombinaison = tabTailles[4];
		this.itemTailleCombinaison.setBackground(Color.GREEN);
		options.add(taille);
		
		BarreMenu.add(menu);
		BarreMenu.add(options);
		this.setJMenuBar(BarreMenu);
		
		//Instanciation vueMastermind
		this.vueMastermind = new VueMastermind(Integer.parseInt(this.itemNbCouleurs.getText()),
				Integer.parseInt(this.itemTailleCombinaison.getText()));
		this.add(this.vueMastermind, BorderLayout.CENTER);
		
		//Interface de la fenetre
		this.setTitle("Mastermind");
		this.pack();
		this.setVisible(true);
		this.setSize(500,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	//change l'item associe au nombre de couleurs par celui passe en parametre
	public void changerItemNbCouleurs(JMenuItem item) {
		this.itemNbCouleurs.setBackground(null);
		this.itemNbCouleurs = item;
		this.itemNbCouleurs.setBackground(Color.red);
	}
	
	//change l'item associe a la taille de la combinaison par celui passe en parametre
	public void changerItemTailleCombinaison(JMenuItem item) {
		this.itemTailleCombinaison.setBackground(null);
		this.itemTailleCombinaison = item;
		this.itemTailleCombinaison.setBackground(Color.green);
	}
	
	//creer une nouvelle vue mastermind qui remplace l'ancienne
	public void creerNouvelleVueMastermind() {
		this.remove(this.vueMastermind);
		this.vueMastermind = new VueMastermind(Integer.parseInt(this.itemNbCouleurs.getText()),
				Integer.parseInt(this.itemTailleCombinaison.getText()));
		this.add(this.vueMastermind);
		this.pack();
		this.setVisible(true);
		this.setSize(500,700);
	}
	
	//sauvegarde la vue du jeu de mastermind dans un fichier
	public void sauvegarderVueMastermindFichier(String monFichier) {
		try{
			// creer le flot de sortie et l associer au fichier de nom a monFichier
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./"+monFichier));
			// ecrire l objet dans le flux de sortie
			out.writeObject(this.vueMastermind);
			// fermer le flux de sortie
			out.close();
		}catch(Exception e) {
			System.out.println("Erreur de sauvegarde"+e);
		}
	}
	
	//remplace la vue du jeu de mastermind par celle sauvegardee dans un fichier
	public void restaurerVueMastermindFichier(String monFichier) {
		try {
			// creer le flot d entree et l associer au fichier de nom a nomFichier 
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("./"+monFichier));
			// lire l objet dans le flux d entree et le transtyper dans son type
			this.remove(this.vueMastermind);
			this.vueMastermind = (VueMastermind)in.readObject();
			// fermer le flux d entree
			in.close();
		}catch(Exception e) {
			System.out.println("Erreur de restauration");
		}
		this.add(this.vueMastermind);
		this.pack();
		this.setVisible(true);
		this.setSize(500,700);
	}
	
}
