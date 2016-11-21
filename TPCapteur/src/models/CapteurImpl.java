package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class CapteurImpl implements Capteur {

	private List<Observer> list;
	private int val;
	private AlgoDiffusion algo;
	public CapteurImpl()
	{
		this.list = new ArrayList<>();
		val=0;
		algo = new AlgoDiffusionAtomique();//TODO
	}
	public CapteurImpl(AlgoDiffusion algo)
	{
		this.list = new ArrayList<>();
		val=0;
		this.algo = algo;
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
		this.val++;
		//algo execute
		//updates
	}

}
