package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Afficheur;
import models.Canal;
import models.Capteur;
import models.CapteurImpl;

@SuppressWarnings("serial")
public class MaFenetre extends JFrame implements ActionListener {
	boolean started=false;

	private JPanel jp_top;
	private JPanel jp_canal;
	private JPanel jp_afficheur;

	private JPanel jp_centre;
	
	private static List<JLabel> listCanals;
	private static List<JLabel> listAfficheurs;
	
	private JLabel lb_algo;
	
	private JComboBox<String> cb_algo;
	private JLabel lb_tick;
	private JLabel lb_capteur;
	
	private JButton bp_start;
	private JButton bp_stop;

	public MaFenetre(String title) {
		this.setTitle(title);
		this.setSize(580, 400);
		init();
		placement();
		this.getContentPane().setLayout(new BorderLayout());
		// todo avec grilayout
		this.getContentPane().add(jp_top, BorderLayout.NORTH);
		this.getContentPane().add(jp_centre, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void placement() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		int x = (width - 580) / 2;
		int y = (height - 400) / 2;
		this.setLocation(x, y);
	}

	private void init() {
		jp_top = new JPanel(new FlowLayout());
		jp_top.setBorder(BorderFactory.createTitledBorder("Top"));
		init_algo();
		init_top();
		
		jp_canal = new JPanel(new GridLayout(2, 2));
		jp_canal.setBorder(BorderFactory.createTitledBorder("Canal"));
		init_canal();
		
		jp_afficheur = new JPanel(new GridLayout(2, 2));
		jp_afficheur.setBorder(BorderFactory.createTitledBorder("Afficheur"));
		init_afficheur();
		
		jp_centre= new JPanel(new GridLayout(2,1));
		jp_centre.add(jp_canal);
		jp_centre.add(jp_afficheur);

	}

	private void init_canal() {
		this.listCanals=new ArrayList<>();
		listCanals.add(new JLabel("Canals 1"));
		listCanals.add(new JLabel("Canals 2"));
		listCanals.add(new JLabel("Canals 3"));
		listCanals.add(new JLabel("Canals 4"));

		for(int i=0;i<listCanals.size();i++)
		{
			jp_canal.add(listCanals.get(i));
		}
	}

	private void init_afficheur() {
		listAfficheurs= new ArrayList<>();
		
		listAfficheurs.add(new JLabel("Afficheur 1"));
		listAfficheurs.add(new JLabel("Afficheur 2"));
		listAfficheurs.add(new JLabel("Afficheur 3"));
		listAfficheurs.add(new JLabel("Afficheur 4"));

		for(int i=0;i<listAfficheurs.size();i++)
		{
			jp_afficheur.add(listAfficheurs.get(i));
		}
	}

	private void init_top() {
		lb_tick = new JLabel("Time : ");
		lb_capteur = new JLabel("capteur time");
		bp_start = new JButton("Start");
		bp_stop = new JButton("Stop");
		bp_stop.setEnabled(false);
		bp_start.addActionListener(this);
		bp_stop.addActionListener(this);
		jp_top.add(lb_tick);
		jp_top.add(lb_capteur);
		jp_top.add(bp_start);
		jp_top.add(bp_stop);
	}

	private void init_algo() {
		lb_algo = new JLabel("Algo Diffusion : ");
		cb_algo = new JComboBox<>();
		cb_algo.addItem("Atomique");
		cb_algo.addItem("Seq");
		cb_algo.addItem("Epoque");
		jp_top.add(lb_algo);
		jp_top.add(cb_algo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bp_start) {
			started=true;
			System.out.println("[SET-ALGO]" + cb_algo.getSelectedItem());
			Capteur capteur1 = new CapteurImpl(1, cb_algo.getSelectedItem().toString());
			// to do
			Canal canal1 = new Canal(0);
			Canal canal2 = new Canal(1);
			Canal canal3 = new Canal(2);
			Canal canal4 = new Canal(3);

			capteur1.attach(canal1);
			capteur1.attach(canal2);
			capteur1.attach(canal3);
			capteur1.attach(canal4);

			Afficheur aff1 = new Afficheur(canal1);
			Afficheur aff2 = new Afficheur(canal2);
			Afficheur aff3 = new Afficheur(canal3);
			Afficheur aff4 = new Afficheur(canal4);

			canal1.attach(aff1);
			canal2.attach(aff2);
			canal3.attach(aff3);
			canal4.attach(aff4);
//			
			Thread t =new Thread(new Runnable() {
					public void run() {
						while(started)
						{
							try {
								Thread.sleep(1000);
								capteur1.tick();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
			t.start();

			bp_start.setEnabled(false);
			bp_stop.setEnabled(true);
		}
		if (e.getSource() == bp_stop) {
			bp_start.setEnabled(true);
			bp_stop.setEnabled(false);
			started=false;
		}
	}

	public static void setAfficheurValue(int id,String text)
	{
		listAfficheurs.get(id).setText(text);
	}
	
	public static void setCanalValue(int id,String text)
	{
		listCanals.get(id).setText(text);
	}
}
