package models;
import java.util.concurrent.Future;

public interface ObserverDeCapteur extends Observer<Capteur>{

	public Future update(Capteur subject);
}
