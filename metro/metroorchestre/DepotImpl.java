package metroorchestre;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class DepotImpl extends StationImpl {
	
	private static final long serialVersionUID = 1L;
	private List<Rame> rames;
	
	public DepotImpl(String nom) throws RemoteException {
		super(nom,1);
		this.getVoie(1).allumerFeuVert();
		this.rames = new ArrayList<>();
	}
	
	@Override
	public void demarrerRame(int numeroVoie) throws RemoteException {
		if(this.getVoie(numeroVoie).getRame() == null) {
			super.setRame(1,this.rames.remove(0));
		}
		super.demarrerRame(numeroVoie);
	}
	
	@Override
	public int getNumeroVoie(Rame rame) throws RemoteException {
		int res = -1;
		if(rame.equals(this.getVoie(1).getRame())) {
			res =  1;
		}else {
			int positionRameParking = this.rames.indexOf(rame);
			if(positionRameParking != -1) {
				res = 1;
			}
		}
		return res;
	}
	
	@Override
	public void setRame(int numeroVoie, Rame rame) {
		this.rames.add(rame);
	}
	
	public boolean toutesRamesAuDepot() {
		return this.rames.size() == StationServer.NB_RAMES ;
	}
}
