package communicationJoueur;

import java.rmi.RemoteException;

public class TicTacToeServer{
	
	public static void main(String[] argv) {
		try {
			
			java.rmi.registry.LocateRegistry.createRegistry(Integer.valueOf(argv[0]));
			TicTacToe joueur = new TicTacToeImpl(argv[2], argv[3], Boolean.valueOf(argv[4]));
			java.rmi.Naming.bind("rmi://"+argv[1]+":"+argv[0]+"/jeu", joueur);
			
		}catch(java.net.MalformedURLException | java.rmi.AlreadyBoundException | java.rmi.RemoteException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	
}