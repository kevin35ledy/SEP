package models;

import java.util.concurrent.Callable;

@SuppressWarnings("hiding")
public class Update<ObserverDeCapteur> implements Callable<ObserverDeCapteur>{

	private Capteur capteur;
	private ObserverDeCapteur afficheur; //afficheur
	
	public Update(Capteur capteur, ObserverDeCapteur aff){
		this.capteur = capteur;
		this.afficheur = aff;
	}
	
	@Override
	public ObserverDeCapteur call() throws Exception {
		((Afficheur)(this.afficheur)).update(this.capteur);
		return null;
	}

}
