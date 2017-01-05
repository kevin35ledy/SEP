package models;

import java.util.ArrayList;
import java.util.List;
import algo.AlgoDiffusion;
import algo.AlgoDiffusionAtomique;
import algo.AlgoDiffusionEpoque;
import algo.AlgoDiffusionSequentielle;
import views.MaFenetre;

/**
 * abstract Class Capteur
 */
public abstract class Capteur implements Subject {

	protected AlgoDiffusion algo;
	protected List<Observer> list;
	protected int val; //vraie valeur du capteur
	protected int valDiffused = 0; //diffused value of captor
	protected int idCapteur;

	public int getIdCapteur() {
		return idCapteur;
	}

	/**
	 * Constructor Captuer 
	 * @param id id Capteur
	 */
	public Capteur(int id) {
		this.val = 0;
		this.idCapteur = id;
		this.list = new ArrayList<>();
		this.algo = new AlgoDiffusionAtomique();
		this.algo.configure(this, list);
	}
	
	/**
	 * Constuctor algo
	 * @param id id capteur
	 * @param algo Atomique,Seq,Epoque
	 */
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

	/**
	 * Execute an algo
	 */
	public void tick() {
		// algo execute
		algo.execute();
		// updates
	}

	/**
	 * inc the val
	 */
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
