import java.awt.*;

public class Main {

	public static void main(String[] args) {
		//création de la fenetre
		Frame f = new Frame();
		f.setLayout(new GridLayout(1,1));
		
		//intégration du panneau
		PanneauCouleur p = new PanneauCouleur();
		f.add(p);
		
		//visibilité de la fenetre
		f.setTitle("CouleurRVB");
		f.pack(); //regrouper elements
		f.setLocationRelativeTo(null); //milieu page
		f.setSize(250,129);
		f.setVisible(true);
		
		f.addWindowListener(new ControleurFenetre());

	}

}
