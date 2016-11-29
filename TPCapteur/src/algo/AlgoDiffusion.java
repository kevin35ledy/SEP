package algo;

import java.util.List;

import models.Capteur;
import models.Observer;

public abstract class AlgoDiffusion {
	
	protected List<Observer> listCanal;
	protected Capteur capteur;
	
	protected AlgoDiffusion() {
	}
	
	public void configure(Capteur cpt,List<Observer> list) {
		setCapteur(cpt);
		setListCanal(list);
	}
	
	public abstract void execute();
	

	public List<Observer> getListCanal() {
		return listCanal;
	}

	public void setListCanal(List<Observer> listCanal) {
		this.listCanal = listCanal;
	}

	public Capteur getCapteur() {
		return capteur;
	}

	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

}
