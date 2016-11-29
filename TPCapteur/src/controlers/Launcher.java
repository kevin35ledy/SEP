package controlers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import models.Afficheur;
import models.Canal;
import models.Capteur;
import models.CapteurImpl;
import views.MaFenetre;

public class Launcher {
	//TODO
	public static final ExecutorService executer = Executors.newSingleThreadExecutor();
	public static void main(String[] args) {
		//MaFenetre f =new MaFenetre("Captor Asynchronous");
		//f.setVisible(true);
		Capteur capteur1 = new CapteurImpl(1,"Atomique");
		// to do
//		Capteur captuer2 = new CapteurImpl(2, "Seq");

		Canal canal1 = new Canal(1);
		Canal canal2 = new Canal(2);
		Canal canal3 = new Canal(3);

		capteur1.attach(canal1);
		capteur1.attach(canal2);
		capteur1.attach(canal3);
		
		Afficheur aff1 = new Afficheur(canal1);
		Afficheur aff2 = new Afficheur(canal2);
		Afficheur aff3 = new Afficheur(canal3);
		
		canal1.attach(aff1);
		canal2.attach(aff2);
		canal3.attach(aff3);
		
		capteur1.tick();
	}

}
