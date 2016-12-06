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
		this.capteur.incRealValue();
		this.capteur.setValDiffused(this.capteur.getRealValue());
		
		System.out.println("[info-exe"+listCanal.size()+"] algo atomique");
		for(Observer<?> c:listCanal)
		{
			((Canal)(c)).updateFuture(capteur);
		}		
	}

}
