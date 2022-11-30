import java.awt.event.*;

public class ControleurPanneau extends FocusAdapter {
	
	private PanneauCouleur p;
	
	public ControleurPanneau(PanneauCouleur p) {
		this.p = p;
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		this.p.changerCouleur();
	}
}
