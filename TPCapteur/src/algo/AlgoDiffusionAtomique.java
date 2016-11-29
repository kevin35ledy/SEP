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
		System.out.println("[info-exe"+listCanal.size()+"] algo atomique");
		for(Observer<?> c:listCanal)
		{
			((Canal)(c)).updateFuture(capteur);
		}		
	}

}
