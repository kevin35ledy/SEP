package models;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Canal extends Capteur implements ObserverDeCapteur {

	private ScheduledExecutorService sch=null;
	private Capteur capteur;
	private Afficheur afficheur;
	
	public Canal(int id){
		super(id);
		this.list = new ArrayList<>();
		this.sch=new ScheduledThreadPoolExecutor(20);
	}
	
	public Canal(int id,AlgoDiffusion algo){
		super(id,algo);
		this.list = new ArrayList<>();
		this.sch=new ScheduledThreadPoolExecutor(20);
	}
	//creation method invocation
	public void createUpdate(){
		
	}
	public void createGetValue(){
		//TODO
		//GetValue g = new GetValue();
		//schedule
	}
	
	public void schedule(GetValue g, int val, TimeUnit timeType){
		
	}

	@Override
	public void update(Capteur subject) {
		//creer objet Update-> callable(capteur)
		//scheduler(callable,time)
		
		//TODO
	}

	@Override
	public Future<?> updateFuture(Capteur subject) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
