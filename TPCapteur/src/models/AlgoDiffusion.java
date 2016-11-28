package models;

import java.util.List;

public abstract class AlgoDiffusion {
	
	protected List<Canal> listCanal;
	protected Capteur capteur;
	
	protected AlgoDiffusion() {
	}
	
	public void configure(Capteur cpt,List<Canal> list) {
		setCapteur(cpt);
		setListCanal(list);
	}
	
	public abstract void execute();
	

	public List<Canal> getListCanal() {
		return listCanal;
	}

	public void setListCanal(List<Canal> listCanal) {
		this.listCanal = listCanal;
	}

	public Capteur getCapteur() {
		return capteur;
	}

	public void setCapteur(Capteur capteur) {
		this.capteur = capteur;
	}

}
