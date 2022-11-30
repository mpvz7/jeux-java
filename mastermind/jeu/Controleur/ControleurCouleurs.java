package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JMenuItem;

import Interface.FenetreMastermind;

public class ControleurCouleurs implements ActionListener , Serializable{

	private static final long serialVersionUID = 0;

	private FenetreMastermind f;
	
	public ControleurCouleurs(FenetreMastermind fenetre) {
		this.f = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		this.f.changerItemNbCouleurs(item);
	}
}
