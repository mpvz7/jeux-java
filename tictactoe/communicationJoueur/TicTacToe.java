package communicationJoueur;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Inteface exportant les services distante du jeu TicTacToe
 * @author Mariam Parviz
 */

public interface TicTacToe extends Remote{
	
	/**
	 * Cette m�thode permet de propager le coup joueur vers le joueur distant
	 * @param ligne num�ro de la ligne ou le joueur � jou�
	 * @param colonne le num�ro de la coulonne ou le joueur � jouer
	 * @throws RemoteException
	 */
	
	public void propagerCoup(final int ligne, final int colonne) throws RemoteException;
	
}