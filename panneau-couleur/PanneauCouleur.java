import java.awt.*;

public class PanneauCouleur extends Panel {
	
	private Canvas c;
	private TextField t1;
	private TextField t2;
	private TextField t3;
	
	public PanneauCouleur() {
		
		//intégration du gestionnaire de mise en page
		LayoutManager gestionnaire = new GridLayout(1,2,10,0);
		this.setLayout(gestionnaire);
		
		//intégration du Canvas
		this.c = new Canvas();
		this.c.setBackground(Color.BLACK);
		this.add(c);
		
		//intégration des trois champs de texte
		Panel p = new Panel();
		p.setLayout(new GridLayout(3,2,10,10));
		
		this.t1 = new TextField("0");
		this.t2 = new TextField("0");
		this.t3 = new TextField("0");
		
		//Ecouteur
		ControleurPanneau controleur = new ControleurPanneau(this);
		this.t1.addFocusListener(controleur);
		this.t2.addFocusListener(controleur);
		this.t3.addFocusListener(controleur);
		
		p.add(new Label("Rouge"));
		p.add(this.t1);
		p.add(new Label("Vert"));
		p.add(this.t2);
		p.add(new Label("Bleu"));
		p.add(this.t3);
		
		this.add(p);
	}
	
	public void changerCouleur() {
		int r = Integer.parseInt(this.t1.getText());
		int v = Integer.parseInt(this.t2.getText());
		int b = Integer.parseInt(this.t3.getText());
		this.c.setBackground(new Color(r,v,b));
	}
}
