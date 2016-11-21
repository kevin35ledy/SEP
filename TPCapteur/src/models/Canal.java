package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Canal implements Capteur, ObserverDeCapteur {

	private List<Observer> list;
	
	public Canal(){
		this.list = new ArrayList<>();
		
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
	public void attach(Observer o) {
		this.list.add(o);
	}

	@Override
	public void detach(Observer o) {
		this.list.remove(o);
	}

	@Override
	public Future<?> getValue(Future<?> c) {
		
		return c;
	}

	@Override
	public void tick() {

	}

	@Override
	public Future update(Capteur subject) {
		return null;
	}

}
