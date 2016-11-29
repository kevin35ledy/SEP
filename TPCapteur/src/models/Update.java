package models;

import java.util.concurrent.Callable;

public class Update implements Callable<Object>{

	private Canal canal;
	private Afficheur afficheur; //afficheur
	
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
