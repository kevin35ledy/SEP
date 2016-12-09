package algo;

import models.Canal;
import models.Observer;

/**
 * @author qfdk
 * AlgoDiffusionSequentielle
 */
public class AlgoDiffusionSequentielle extends AlgoDiffusion{

	@Override
	public void execute() {
		this.capteur.inc();
		incDiffused();
		System.out.println("[info-exe"+listCanal.size()+"] algo sequentiel");
		for(Observer<?> c:listCanal)
		{
			((Canal)(c)).updateFuture(capteur);
		}		
	}
	
	public void incDiffused(){
		boolean incrementer = true;
		for(Observer o : listCanal){
			if(o instanceof Canal){
				incrementer = incrementer && ((Canal) o).isAfficheurUpdated();
			}
		}
		if(incrementer)
		{
			this.capteur.setValDiffused(this.capteur.getRealValue());
		}
	}
}
