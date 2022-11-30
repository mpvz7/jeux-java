package communicationJoueur;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Inteface exportant les services distante du jeu TicTacToe
 * @author Mariam Parviz
 */

public interface TicTacToe extends Remote{
	
	/**
	 * Cette méthode permet de propager le coup joueur vers le joueur distant
	 * @param ligne numéro de la ligne ou le joueur à joué
	 * @param colonne le numéro de la coulonne ou le joueur à jouer
	 * @throws RemoteException
	 */
	
	public void propagerCoup(final int ligne, final int colonne) throws RemoteException;
	
}