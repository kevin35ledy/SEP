package algo;

import models.Canal;

public class AlgoDiffusionAtomique extends AlgoDiffusion{
	
	public AlgoDiffusionAtomique()
	{
		super();
	}

	@Override
	public void execute() {
		System.out.println("[info-exe"+listCanal.size()+"] algo atomique");
		for(Canal c:listCanal)
		{
			c.update(capteur);
		}		
	}

}
