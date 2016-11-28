package models;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public abstract class Capteur implements Subject{
	// canal
	protected List<Canal> list;
	protected int val;
	protected AlgoDiffusion algo;
	protected int idCapteur;

	public int getIdCapteur() {
		return idCapteur;
	}

	public void setIdCapteur(int idCapteur) {
		this.idCapteur = idCapteur;
	}

	public Capteur(int id) {
		this.idCapteur = id;
		this.list = new ArrayList<>();
		val = 0;
		algo = new AlgoDiffusionAtomique();// TODO
	}

	public Capteur(int id, AlgoDiffusion algo) {
		this.idCapteur = id;
		this.list = new ArrayList<>();
		val = 0;
		this.algo = algo;
	}

	@Override
	public void attach(Observer<?> o) {
// TODO instanceof canal
		this.list.add((Canal)o);
	}

	@Override
	public void detach(Observer<?>  o) {
		this.list.remove((Canal)o);
	}

	public Future<?> getValue(Future<?> c) {
		return c;
	}

	public void tick() {
		this.val++;
		// algo execute
		this.algo.execute();
		// updates
		
	}
}
