package models;

public interface ObserverDeCapteur extends Observer<Capteur>{

	public void update(Capteur subject);
}
