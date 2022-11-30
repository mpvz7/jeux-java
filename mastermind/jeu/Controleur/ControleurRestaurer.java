package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Interface.FenetreMastermind;

public class ControleurRestaurer implements ActionListener, Serializable{

	private static final long serialVersionUID = 0;

	private FenetreMastermind f;
	
	public ControleurRestaurer(FenetreMastermind fenetre) {
		this.f = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int reponse = JOptionPane.showConfirmDialog(null,"Voulez vous vraiment restaurer la partie ?", null, JOptionPane.YES_NO_OPTION);
		
		if(reponse == JOptionPane.YES_OPTION) {
			this.f.restaurerVueMastermindFichier("JeuMastermind");
		}
	}
}
