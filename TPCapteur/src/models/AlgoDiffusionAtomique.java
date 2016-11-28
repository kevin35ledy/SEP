package models;

public class AlgoDiffusionAtomique extends AlgoDiffusion{
	
	public AlgoDiffusionAtomique()
	{
		
	}

	@Override
	public void execute() {
		for(Canal c:listCanal)
		{
			c.update(capteur);
		}		
	}

}
