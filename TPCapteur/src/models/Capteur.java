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
		
		/*
		 * depend de l'algo 
		 * atomique : 1 rédacteur XOR n ecrivains : pour n canaux on doit appeler n fois capteur.getValue avant de refaire val ++
		 * seq : on transmet la valeur copiée à l'instant ou le tick() etait effectué... pendant la diffusion, on peut continuer de ticker
		 * epoque : 
		 */
		
		System.out.println("Capteur.getValue " + this.valDiffused);
		return this.valDiffused; // diffusion atomique
	}
	
	public void setValDiffused(int v){
		this.valDiffused = v;
	}
	
	public int getRealValue(){
		return this.val;
	}
	
	public void incRealValue(){
		boolean incrementer = true;
		
		for(Observer o : this.list){
			if(o instanceof Canal){
				incrementer = incrementer && ((Canal) o).isAfficheurUpdated();
			}
		}
		if(incrementer){
			this.val++;
		}
	}

	public void tick() {
		// algo execute
		algo.execute();
		// updates
	}
}
