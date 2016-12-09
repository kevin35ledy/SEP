package algo;

import java.util.List;

import models.Capteur;
import models.Observer;

/**
 * 
 * @author qfdk
 * Algo diffusion
 */
public abstract class AlgoDiffusion {
	
	protected List<Observer> listCanal;
	protected Capteur capteur;
	
	protected AlgoDiffusion() {
	}
	
	/**
	 * Configure an algo
	 * @param cpt capteur
	 * @param list list of Canal
	 */
	public void configure(Capteur cpt,List<Observer> list) {
		setCapteur(cpt);
		setListCanal(list);
	}
	
	public abstract void execute();
	

	/**
	 * get Canal list
	 * @return list of Canal
	 */
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
