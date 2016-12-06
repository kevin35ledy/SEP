package models;

public class CapteurImpl extends Capteur {

	public CapteurImpl(int id) {
		super(id);
//		this.algo.configure(this, list);
	}
	
	public CapteurImpl(int id,String algo) {
		super(id,algo);
//		this.algo.configure(this, list);
	}

	// o est un canal.
	@Override
	public void attach(Observer<?> o) {
		// TODO Auto-generated method stub
		this.list.add(o);
		((Canal)o).setCapteur(this);
	}

}
