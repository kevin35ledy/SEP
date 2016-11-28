package controlers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import models.Afficheur;
import models.AlgoDiffusion;
import models.AlgoDiffusionAtomique;
import models.Canal;
import models.Capteur;
import models.CapteurImpl;
import views.MaFenetre;

public class Launcher {

	public static final ExecutorService executer = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		MaFenetre f =new MaFenetre("Captor Asynchronous");
		f.setVisible(true);
		
		Capteur c1 = new CapteurImpl(1);
		Capteur c2 = new CapteurImpl(2);
		
		Canal cn1 = new Canal(1);
		Canal cn2 = new Canal(2);
		
		c1.attach(cn1);
		c2.attach(cn2);
		
		Afficheur a1 = new Afficheur(cn1);
		Afficheur a2 = new Afficheur(cn2);
		
		cn1.attach(cn1);
		cn2.attach(cn2);
		
		
		
		AlgoDiffusion algo = new AlgoDiffusionAtomique();
		List<Canal> l = new ArrayList();
		l.add(cn1);
		algo.configure(c1, l);
		
		
		
		c1.tick();
		
	}

}
