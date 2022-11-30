package testRame;

import metroorchestre.Rame;
import metroorchestre.RameImpl;

public class RameServer {
	public static void main(String[] argv) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(9000);
			Rame rame = new RameImpl(1);
			java.rmi.Naming.bind("rmi://localhost:9000/metro", rame);
		}catch(java.net.MalformedURLException | java.rmi.AlreadyBoundException | java.rmi.RemoteException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
