package models;

import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur {

	private Canal canal;

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
	public void update(Capteur subject) {
		int idTmp = subject.getIdCapteur();
	}

	@Override
	public Future<?> updateFuture(Capteur subject) {
		// TODO Auto-generated method stub
		return null;
	}
}
