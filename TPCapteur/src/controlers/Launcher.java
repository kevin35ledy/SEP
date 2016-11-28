package controlers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import views.MaFenetre;

public class Launcher {
	//TODO
	public static final ExecutorService executer = Executors.newSingleThreadExecutor();
	public static void main(String[] args) {
		MaFenetre f =new MaFenetre("Captor Asynchronous");
		f.setVisible(true);
	}

}
