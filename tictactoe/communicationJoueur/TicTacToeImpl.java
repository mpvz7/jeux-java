package communicationJoueur ;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import tictactoe.GestionClicCase;
import tictactoe.TicTacToeIHM;
import tictactoe.TicTacToeIHMImpl;

public class TicTacToeImpl extends java.rmi.server.UnicastRemoteObject implements TicTacToe, GestionClicCase{

	private static final long serialVersionUID = 1L;
	private String adresseDistante;
	private String portDistant;
	private TicTacToeIHM ihm;
	
	public TicTacToeImpl(String adresseDistante, String portDistant, Boolean estPremier) throws RemoteException {
		this.adresseDistante = adresseDistante;
		this.portDistant = portDistant;
		this.ihm = new TicTacToeIHMImpl(estPremier);
		this.ihm.setGestionnaireClic(this);
	}
	
	public void propagerCoup(final int ligne, final int colonne){
		this.ihm.jouerDistant(ligne, colonne);
	}
	
	public boolean traitementCaseCliquee(int lig, int col) {
		boolean resultat = false;
		if(this.ihm.getContenuCase(lig, col).isEmpty() && !this.ihm.estBloque()){
			try {
				TicTacToe joueurDistant = (TicTacToe)Naming.lookup("rmi://"+this.adresseDistante+":"+this.portDistant+"/jeu");
				joueurDistant.propagerCoup(lig, col);
				resultat = true;
			}catch(RemoteException | NotBoundException| MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return resultat;
	}
}
