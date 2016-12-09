package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import algo.AlgoDiffusion;
import algo.AlgoDiffusionAtomique;
import algo.AlgoDiffusionEpoque;
import algo.AlgoDiffusionSequentielle;
import views.MaFenetre;

public abstract class Capteur implements Subject {

	protected AlgoDiffusion algo;
	protected List<Observer> list;
	protected int val; //vraie valeur du capteur
	protected int valDiffused = 0; //diffused value of captor
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

	
	public abstract void attach(Observer<?> o);

	@Override
	public void detach(Observer<?> o) {
		this.list.remove((Canal) o);
	}

	public int getValue() {
		System.out.println("Capteur.getValue " + this.valDiffused);
		return this.valDiffused; // diffusion
	}
	
	public void setValDiffused(int v){
		this.valDiffused = v;
	}
	
	public int getRealValue(){
		return this.val;
	}

	public void tick() {
		// algo execute
		algo.execute();
		// updates
	}

	// increment cpt
	public void inc() {
		this.val++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MaFenetre.setCapteurValue(this.val);
	}
}
