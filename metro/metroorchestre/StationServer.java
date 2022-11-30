package metroorchestre;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class StationServer {
	
	public static final int NB_RAMES = 7;
	
	public StationServer(String adresseMachine, int portMachine) throws RemoteException, MalformedURLException, AlreadyBoundException {
		//creer le serveur
		java.rmi.registry.LocateRegistry.createRegistry(portMachine);
	
		for(String nomStation : Station.STATIONS) {
			Station station = new StationImpl(nomStation,2);
			java.rmi.Naming.bind("rmi://"+adresseMachine+":"+portMachine+"/"+nomStation.replace(' ', '_'),(Station) station);
		}
		
		Station depot = new DepotImpl("Depot");
		java.rmi.Naming.bind("rmi://"+adresseMachine+":"+portMachine+"/Depot",(Station) depot);
		
		for(int i=1; i<=NB_RAMES; i++) {
			Rame rame = new RameImpl(i);
			java.rmi.Naming.bind("rmi://"+adresseMachine+":"+portMachine+"/Rame"+i,(Rame) rame);
		}
	}
	
	public static void main(String[] arg) throws RemoteException, MalformedURLException, AlreadyBoundException{
		new StationServer("localhost",9000);
	}

	
}
