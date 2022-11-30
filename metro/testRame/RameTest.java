package testRame;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import metroorchestre.Rame;

public class RameTest {
	public static void main(String[] argv) throws RemoteException, InterruptedException {
		try {
			Rame rame = (Rame)Naming.lookup("rmi://localhost:9000/metro");
			rame.demarrer();
			rame.fermerPorte();
			rame.actionnerMoteur(3000);
			rame.ouvrirPorte();
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
