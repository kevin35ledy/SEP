package models;

/**
 * @author kevin
 * Capteur implementation 
 */
public class CapteurImpl extends Capteur {

	/**
	 * Constructor Capteur
	 * @param id id Capteur
	 */
	public CapteurImpl(int id) {
		super(id);
	}
	
	/**
	 * Constructor Capteur
	 * @param id id Capteur
	 * @param algo name of algo(atom,seq,epoque)
	 */
	public CapteurImpl(int id,String algo) {
		super(id,algo);
	}

	/* 
	 * attach un canal
	 * @see models.Capteur#attach(models.Observer)
	 */
	@Override
	public void attach(Observer<?> o) {
		this.list.add(o);
		((Canal)o).setCapteur(this);
	}

}
