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
	public static void main(String[] args) throws InterruptedException {
		MaFenetre f =new MaFenetre("Captor Asynchronous");
		f.setVisible(true);


		
	}

}
