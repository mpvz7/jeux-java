package metroorchestre;

import afficheurmetro.EcouteurBoutons;
import afficheurmetro.MetroSuperviseurIHM;
import afficheurmetro.MetroSuperviseurIHMImpl;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author millan
 */
public class Superviseur implements EcouteurBoutons
{
   private enum ETAT {DEMARRAGE_METRO, EN_SERVICE, FIN_DE_SERVICE} ;
   private ETAT etatLigne;
   private DepotImpl depot;
   private MetroSuperviseurIHM superviseurIHM;
 
   public Superviseur() throws RemoteException, MalformedURLException, NotBoundException {
	   this.etatLigne = ETAT.FIN_DE_SERVICE;
	   
	   //ajouter depot
	   this.depot = (DepotImpl)Naming.lookup("rmi://localhost:9000/depot");
	   for(int i=0; i<StationServer.NB_RAMES; i++) {
		   depot.setRame(1, (Rame)Naming.lookup("rmi://localhost:9000/rame"));
	   }
	   
	   //creer premiere station hors depot
	   Station stationDepart = this.rechercherStation("localhost", 9000, Station.STATIONS[0]);
	   stationDepart.ajouterStationSuivante("localhost", 9000, 1, Station.STATIONS[1], 1);
	   
	   //station normal
	   for(int i=0; i<Station.STATIONS.length-1; i++) {
		   //voie 1
		   Station station1 = this.rechercherStation("localhost", 9000, Station.STATIONS[i]);
		   station1.ajouterStationSuivante("localhost", 9000, 1, Station.STATIONS[i+1], 1);
		   //voie 2
		   Station station2 = this.rechercherStation("localhost", 9000, Station.STATIONS[i+1]);
		   station2.ajouterStationSuivante("localhost", 9000, 2, Station.STATIONS[i], 2);
	   }
	   
	 //creer premiere station hors depot
	   Station stationFin = this.rechercherStation("localhost", 9000, Station.STATIONS[Station.STATIONS.length-1]);
	   stationFin.ajouterStationSuivante("localhost", 9000, 1, Station.STATIONS[Station.STATIONS.length-1], 2);
   }
   
   public Station rechercherStation(String adresse, int port, String nomStation) throws MalformedURLException, RemoteException, NotBoundException {
	   return (Station)Naming.lookup("rmi://"+adresse+":"+port+nomStation.replace(' ', '_'));
   }
   
   public Rame rechercherRame(String adresse, int port, int identifiantRame) throws MalformedURLException, RemoteException, NotBoundException {
	   return (Rame)Naming.lookup("rmi://"+adresse+":"+port+"Rame"+identifiantRame);
   }
   
   public boolean sontToutesLesRamesAuDepot() {
	   return this.depot.toutesRamesAuDepot();
   }
    
    /**
     * actionEcouteurDemarrer et actionEcouteurArreter. 
	 * <B>Ces méthodes sont 
     * fournies aux étudiants.</B>
     */    
    @Override
    public void actionEcouteurDemarrer()
    {
        Superviseur.this.gererLigne() ;
    }

    @Override
    public void actionEcouteurArreter()
    {
        Superviseur.this.arreterMetro() ;
    }
    
    
    
}