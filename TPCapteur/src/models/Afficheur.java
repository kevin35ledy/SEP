package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur {
	
	private Canal canal;
	
	public Afficheur()
	{
		canal=new Canal(0);
	}

	public Afficheur(Canal canal)
	{
		this.canal = canal;
	}

	public Canal getListSubject() {
		return canal;
	}


	
	@Override
	public void update(Capteur subject) {
		int id=subject.getIdCapteur();
		
		
	}

	@Override
	public Future<?> updateFuture(Capteur subject) {
		// TODO Auto-generated method stub
		return null;
	}
}
