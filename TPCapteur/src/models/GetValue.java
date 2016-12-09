package models;

import java.util.concurrent.Callable;

/**
 * 
 * @author kevin
 *
 */
public class GetValue implements Callable<Integer>{

	private Capteur capteur;
	public GetValue(Capteur capteur){
		this.capteur = capteur;
	}
	
	@Override
	public Integer call() {
		return this.capteur.getValue();
	}

}
