package models;

import java.util.concurrent.Future;

/**
 * @author qfdk kevin
 *
 */
public interface ObserverDeCapteur extends Observer<Capteur>{

	/**
	 * updateFuture
	 * @param capteur
	 * @return future
	 */
	public Future<?> updateFuture(Capteur capteur);
}
