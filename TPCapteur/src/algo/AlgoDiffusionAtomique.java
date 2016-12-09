package algo;

import models.Canal;
import models.Observer;

public class AlgoDiffusionAtomique extends AlgoDiffusion{
	
	public AlgoDiffusionAtomique()
	{
		super();
	}

	@Override
	public void execute() {
		incRealValue();
		this.capteur.setValDiffused(this.capteur.getRealValue());
		
		System.out.println("[info-exe"+listCanal.size()+"] algo atomique");
		for(Observer<?> c:listCanal)
		{
			((Canal)(c)).updateFuture(capteur);
		}		
	}
	
	public void incRealValue(){
		boolean incrementer = true;
		for(Observer o : listCanal){
			if(o instanceof Canal){
				incrementer = incrementer && ((Canal) o).isAfficheurUpdated();
			}
		}
		
		if(incrementer){
			this.capteur.inc();
		}
	}
}
