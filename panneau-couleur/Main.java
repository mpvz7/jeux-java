import java.awt.*;

public class Main {

	public static void main(String[] args) {
		//cr�ation de la fenetre
		Frame f = new Frame();
		f.setLayout(new GridLayout(1,1));
		
		//int�gration du panneau
		PanneauCouleur p = new PanneauCouleur();
		f.add(p);
		
		//visibilit� de la fenetre
		f.setTitle("CouleurRVB");
		f.pack(); //regrouper elements
		f.setLocationRelativeTo(null); //milieu page
		f.setSize(250,129);
		f.setVisible(true);
		
		f.addWindowListener(new ControleurFenetre());

	}

}
