package algo;

import models.Canal;
import models.Observer;

/**
 * @author qfdk
 * AlgoDiffusionEpoque
 */
public class AlgoDiffusionEpoque extends AlgoDiffusion {

	@Override
	public void execute() {
		this.capteur.inc();
		this.capteur.setValDiffused(this.capteur.getRealValue());
		System.out.println("[info-exe"+listCanal.size()+"] algo par epoque");
		for(Observer<?> c:listCanal)
		{
			((Canal)(c)).updateFuture(capteur);
		}		
	}


}
