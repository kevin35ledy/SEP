package models;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>{

	private Capteur capteur;
	private Canal canal; //afficheur
	
	public GetValue(Capteur capteur, Canal can){
		this.capteur = capteur;
		this.canal = can;
	}
	
	@Override
	public Integer call() {
		return this.capteur.getValue();
	}

}
