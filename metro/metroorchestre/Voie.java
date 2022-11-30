package metroorchestre;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import afficheurmetro.MetroSuperviseurIHM;

public class Voie {
	
	private boolean feuVert;
	private Rame laRame;
	private int tempsDeParcours;
	private Station stationSuivante;
	private int voieSuivante;
	
	public Voie(int tempsDeParcours) {
		this.feuVert = true;
		this.tempsDeParcours = tempsDeParcours;
	}
	
	public void ajouterStationSuivante(String adresseMachine, int port, String stationSuivante, int voieSuivante) throws MalformedURLException, RemoteException, NotBoundException {
		this.stationSuivante = (Station)Naming.lookup("rmi://"+adresseMachine+":"+port+"/"+stationSuivante);
		this.voieSuivante = voieSuivante;
	}
	
	public void allumerFeuRouge() {
		this.feuVert = false;
	}
	
	public void allumerFeuVert() {
		this.feuVert = true;
	}
	
	public void demarrerRame() throws RemoteException, InterruptedException {
		this.stationSuivante.allumerFeuRouge(this.voieSuivante);
		ThreadVoie thread = new ThreadVoie();
		thread.start();
	}
	
	public boolean estRamePresente(Rame rame) {
		return rame.equals(this.laRame);
	}
	
	public boolean estVert() {
		return this.feuVert;
	}
	
	public String getNomStationSuivante() throws RemoteException {
		return this.stationSuivante.getNom();
	}
	
	public int getNumeroVoieSuivante() {
		return this.voieSuivante;
	}
	
	public Rame getRame() {
		return this.laRame;
	}
	
	public void setRame(Rame rame) {
		if(this.laRame == null) {
			this.laRame = rame;
		}else{
			System.out.println("Une rame est déjà sur la voie. Attention, risque de collision.");
            //System.exit(1);
		}
	}
	
	private class ThreadVoie extends Thread{

		@Override
		public void run() {
			try {
			Rame rame = Voie.this.laRame;
			rame.demarrer();
			rame.fermerPorte();
			Voie.this.laRame = null;
			rame.actionnerMoteur(Voie.this.tempsDeParcours);
			Voie.this.allumerFeuVert();
			Voie.this.stationSuivante.setRame(Voie.this.voieSuivante, rame);
			rame.ouvrirPorte();
			Thread.sleep(3000);
			rame.departImminent();
			}catch(Exception e) {
				System.out.println(e);
			}
		}	
	}
}

