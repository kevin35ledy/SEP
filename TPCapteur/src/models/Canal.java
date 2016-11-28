package models;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import controlers.Launcher;

public class Canal extends Capteur implements ObserverDeCapteur {

	private ScheduledExecutorService sch=null;
	private Capteur capteur;
	private Afficheur afficheur;
	
	public Canal(int id){
		super(id);
		this.list = new ArrayList<>();
		this.sch=new ScheduledThreadPoolExecutor(20);
	}
	
	public Canal(int id,String algo){
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
		System.out.println(this+"==>updated");
	}

	@Override
	public Future<?> updateFuture(Capteur subject) {
		//creer objet Update-> callable(capteur)
		//scheduler(callable,time)
		Update methodInvoc = new Update<>(this.capteur, this);
		//submit returns a Future Object
		Future f = Launcher.executer.submit(methodInvoc);
		//TODO
		return f;
	}

	
}
