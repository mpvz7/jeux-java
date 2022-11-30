package metroorchestre;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import afficheurmetro.MetroSuperviseurIHM;

public class StationImpl extends UnicastRemoteObject implements Station {
	
	private static final long serialVersionUID = 1L;
	private List<Voie> voies;
	private String nom;

	public StationImpl(String nom, int nombreVoie) throws RemoteException {
		this.nom = nom;
		this.voies = new ArrayList<>();
		for(int i=0; i< nombreVoie; i++) {
			this.voies.add(new Voie(5000));
		}
	}
	
	@Override
	public String afficher() throws RemoteException {
		String station = "";
		for(Voie v : this.voies) {
			station += v.toString();
		}
		return station;
	}

	@Override
	public String getNom() throws RemoteException {
		return this.nom;
	}

	@Override
	public void ajouterStationSuivante(String machine, int port, int numeroVoieDepart, String stationSuivante,
			int voieSuivante) throws RemoteException, NotBoundException, MalformedURLException {
		this.voies.get(numeroVoieDepart-1).ajouterStationSuivante(machine, port, stationSuivante, voieSuivante);
	}

	@Override
	public boolean estFeuVert(int numeroVoie) throws RemoteException {
		return this.voies.get(numeroVoie-1).estVert();
	}

	@Override
	public void demarrerRame(int numeroVoie) throws RemoteException {
	
		try {
			int numeroRame = this.voies.get(numeroVoie-1).getRame().getNumero();
			this.voies.get(numeroVoie-1).demarrerRame();
			MetroSuperviseurIHM moniteur = (MetroSuperviseurIHM)Naming.lookup("rmi://localhost:9999/moniteur");
			moniteur.modifierAffichage(this.nom, numeroVoie, this.getNomStationSuivante(numeroVoie), 
				this.getNumeroVoieSuivante(numeroVoie), 
				"Rame "+numeroRame);
		}catch(Exception e) {
			System.out.println("Demarrage de la station non effectue : "+e);
		}	
	}

	@Override
	public String getNomStationSuivante(int numeroVoie) throws RemoteException {
		return this.voies.get(numeroVoie-1).getNomStationSuivante();
	}

	@Override
	public int getNumeroVoieSuivante(int numeroVoie) throws RemoteException {
		return this.voies.get(numeroVoie-1).getNumeroVoieSuivante();
	}

	@Override
	public void setRame(int numeroVoie, Rame rame) throws RemoteException {
		this.voies.get(numeroVoie-1).setRame(rame);
	}
	
	public Voie getVoie(int numeroVoie){
		return this.voies.get(numeroVoie-1);
	}

	@Override
	public void allumerFeuRouge(int numeroVoie) throws RemoteException {
		this.voies.get(numeroVoie-1).allumerFeuRouge();
	}

	@Override
	public int getNumeroVoie(Rame rame) throws RemoteException {
		int numeroVoie = -1;
		for(int i = 0; i< this.voies.size() && numeroVoie==-1;i++) {
			if(this.voies.get(i).estRamePresente(rame)) {
				numeroVoie = i+1;
			}
		}
		return numeroVoie;
	}

}
