package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import algo.AlgoDiffusion;
import algo.AlgoDiffusionAtomique;
import algo.AlgoDiffusionEpoque;
import algo.AlgoDiffusionSequentielle;

public abstract class Capteur implements Subject {

	protected AlgoDiffusion algo;
	protected List<Canal> list;
	protected int val;
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
		this.algo = new AlgoDiffusionAtomique();
		this.algo.configure(this, list);
	}

	public Capteur(int id, String algo) {
		this.idCapteur = id;
		this.list = new ArrayList<>();
		val = 0;
		if(algo.equals("Atomique"))
		{
			this.algo=new AlgoDiffusionAtomique();
		}
		if(algo.equals("Seq"))
		{
			this.algo=new AlgoDiffusionSequentielle();
		}
		if(algo.equals("Epoque"))
		{
			this.algo=new AlgoDiffusionEpoque();
		}
		this.algo.configure(this, list);
	}

	@Override
	public void attach(Observer<?> o) {
		this.list.add((Canal) o);
	}

	@Override
	public void detach(Observer<?> o) {
		this.list.remove((Canal) o);
	}

	public Future<?> getValue(Future<?> c) {
		return c;
	}

	public void tick() {
		this.val++;
		// algo execute
		algo.execute();
		// updates
	}
}
