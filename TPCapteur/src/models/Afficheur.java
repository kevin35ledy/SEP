package models;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur {

	private Canal canal;
	private int val;

	public Afficheur(int id) {
		this.canal = new Canal(id);
	}

	public Afficheur(Canal canal) {
		this.canal = canal;
	}

	public Canal getListSubject() {
		return canal;
	}


	@Override
	public Future<?> updateFuture(Capteur canal) {
		// TODO Auto-generated method stub
		System.out.println("Afficheur.update -> creation FUTURE "+this);
		Future<Integer> f = ((Canal)canal).createGetValue();
		try {
			
			this.val = f.get().intValue();
			
		} catch (NumberFormatException | InterruptedException | ExecutionException e) {
			System.err.println("Afficheur. updateFuture -> formattage string to int mauvais");
		}
		return f;
	}

	@Override
	public void update(Capteur subject) {
		// TODO Auto-generated method stub
		
	}


}
