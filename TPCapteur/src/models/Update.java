package models;

import java.util.concurrent.Callable;

/**
 * 
 * Callable update for scheduler
 * @author qfdk kevin
 *
 */
public class Update implements Callable<Object>{

	private Canal canal;
	private Afficheur afficheur; //afficheur
	
	/**
	 * Constructor Update
	 * @param canal Canal
	 * @param aff Afficheur
	 */
	public Update(Canal canal, Afficheur aff){
		this.canal = canal;
		this.afficheur = aff;
	}
	
	@Override
	public Object call() throws Exception {
		this.afficheur.updateFuture(this.canal);
		return null;
	}

}
