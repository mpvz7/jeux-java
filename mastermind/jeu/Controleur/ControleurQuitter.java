package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import Interface.FenetreMastermind;

public class ControleurQuitter implements ActionListener, Serializable{

	private static final long serialVersionUID = 0;
	
	private FenetreMastermind f;
	
	public ControleurQuitter(FenetreMastermind fenetre) {
		this.f = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.f.dispose();
	}

}
