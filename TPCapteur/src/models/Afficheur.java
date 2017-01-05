package models;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import views.MaFenetre;

/**
 * Afficheur
 *
 */
/**
 * @author qfdk
 *
 */
public class Afficheur implements ObserverDeCapteur {

	private Canal canal;
	private int val;

	/**
	 * Constructor Afficheur
	 * @param idCapteur id capteur
	 */
	public Afficheur(int idCapteur) {
		this.canal = new Canal(idCapteur);
	}

	
	/**
	 * Constructor Afficheur
	 * @param canal Canal
	 */
	public Afficheur(Canal canal) {
		this.canal = canal;
	}

	public Canal getListSubject() {
		return canal;
	}


	@Override
	public Future<?> updateFuture(Capteur canal) {
		Future<Integer> f = ((Canal)canal).createGetValue();
		try {
			this.val = f.get().intValue();
			this.canal.setAfficheurUpdated(true);
			MaFenetre.setAfficheurValue(this.canal.getIdCapteur(),String.valueOf(this.val));
			System.out.println("Afficheur"+this.canal.getIdCapteur()+" : "+ this.val);
		} catch (NumberFormatException | InterruptedException | ExecutionException e) {
			System.err.println("Afficheur. updateFuture -> formattage string to int mauvais");
		}
		return f;
	}

	@Override
	public void update(Capteur subject) {
	}

}
