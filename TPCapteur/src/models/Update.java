package models;

import java.util.concurrent.Callable;

public class Update<ObserverDeCapteur> implements Callable<ObserverDeCapteur>{

	private Capteur c;
	private ObserverDeCapteur o; //afficheur
	
	public Update(Capteur capteur, ObserverDeCapteur afficheur){
		this.c = capteur;
		this.o = afficheur;
	}
	
	@Override
	public ObserverDeCapteur call() throws Exception {
		((Afficheur)(this.o)).update(this.c);
		return null;
	}

}
