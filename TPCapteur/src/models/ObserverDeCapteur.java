package models;

import java.util.concurrent.Future;

public interface ObserverDeCapteur extends Observer<Capteur>{

	public void update(Capteur subject);
	public Future<?> updateFuture(Capteur subject);
}
