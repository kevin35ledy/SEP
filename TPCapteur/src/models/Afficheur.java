package models;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import views.MaFenetre;

public class Afficheur implements ObserverDeCapteur {

	private Canal canal;
	private int val;

	public Afficheur(int idCapteur) {
		this.canal = new Canal(idCapteur);
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
//		System.out.println("Afficheur.update -> creation FUTURE "+this);
		Future<Integer> f = ((Canal)canal).createGetValue();
		try {
			this.val = f.get().intValue();
			MaFenetre.setAfficheurValue(this.canal.getIdCapteur(),String.valueOf(this.val));
			System.out.println("Afficheur"+this.canal.getIdCapteur()+" : "+ this.val);
		} catch (NumberFormatException | InterruptedException | ExecutionException e) {
//			System.err.println(e);
			System.err.println("Afficheur. updateFuture -> formattage string to int mauvais");
		}
		return f;
	}

	@Override
	public void update(Capteur subject) {
		// TODO Auto-generated method stub
		
	}


}
