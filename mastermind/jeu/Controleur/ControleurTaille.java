package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JMenuItem;

import Interface.FenetreMastermind;

public class ControleurTaille implements ActionListener , Serializable{

	private static final long serialVersionUID = 0;

	private FenetreMastermind f;
	
	public ControleurTaille(FenetreMastermind fenetre) {
		this.f = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		this.f.changerItemTailleCombinaison(item);
	}
}
