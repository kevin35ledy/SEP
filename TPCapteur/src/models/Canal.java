package models;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Canal extends Capteur implements ObserverDeCapteur {

	private ScheduledExecutorService sch;
	private Capteur capteur;
	private Afficheur afficheur;
	private int id;
	boolean afficheurUpdated;
	
	/**
	 * Canal
	 * @param idCapteur
	 */
	public Canal(int idCapteur){
		super(idCapteur);
		this.list = new ArrayList<>();
		this.sch=new ScheduledThreadPoolExecutor(20);
		this.afficheurUpdated = true;
	}
	
	public Canal(int idCapteur,String algo){
		super(idCapteur,algo);
		this.list = new ArrayList<>();
		this.sch=new ScheduledThreadPoolExecutor(20);
		this.afficheurUpdated = true;
	}
	//creation method invocation
	public void createUpdate(){
//		GetValue getValueCallable = new GetValue(this.capteur, this);
	}
	public Future<Integer> createGetValue(){
		// getValue of capteur -> retourne un futur
		System.out.println("creation GetValue "+this);
		GetValue getValueCallable = new GetValue(this.capteur, this);
		//Future res = this.capteur.getValue(callableGetValue);
		return sch.schedule(getValueCallable, 840, TimeUnit.MILLISECONDS); //renvoie un future
	}
	
	public void schedule(GetValue getValueCallable, int val, TimeUnit timeType){
		
	}

	@Override
	public void update(Capteur subject) {
		//creer objet Update-> callable(capteur)
		//scheduler(callable,time)
		System.out.println(this+"==>updated");
	}

	@Override
	public Future<?> updateFuture(Capteur capteur) {
		
		System.out.println("creation Update :" +this);
		this.afficheurUpdated = false;
		Update methodInvoc = new Update(this, this.afficheur);
		//submit returns a Future Object
		return sch.schedule(methodInvoc, 840, TimeUnit.MILLISECONDS); //renvoie un future
		
	}

	@Override
	public void attach(Observer<?> o) {
		this.afficheur = (Afficheur)o;
	}
	public void setCapteur(Capteur capteur){
		this.capteur=capteur;
	}
	
	public boolean isAfficheurUpdated(){
		return this.afficheurUpdated;
	}
	
	public void setAfficheurUpdated(boolean b){
		this.afficheurUpdated = b;
	}

}
