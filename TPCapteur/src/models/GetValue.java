package models;

import java.util.concurrent.Callable;

/**
 * GetValue callable
 * @author kevin
 *
 */
public class GetValue implements Callable<Integer>{

	private Capteur capteur;
	/**
	 * GetValue
	 * @param capteur capteur
	 */
	public GetValue(Capteur capteur){
		this.capteur = capteur;
	}
	
	@Override
	public Integer call() {
		return this.capteur.getValue();
	}

}
