package models;
import java.util.concurrent.Future;


public interface Capteur extends Subject{
	public Future<?> getValue(Future<?> c);
	public void tick();
}
