package models;

public interface Capteur extends Subject{
	public int getValue();
	public void tick();
}
