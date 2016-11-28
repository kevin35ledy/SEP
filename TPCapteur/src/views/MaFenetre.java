package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Canal;
import models.Capteur;
import models.CapteurImpl;

@SuppressWarnings("serial")
public class MaFenetre extends JFrame implements ActionListener {

	private JPanel jp_top;
	private JPanel jp_centre;

	private JLabel lb_algo;
	private JComboBox<String> cb_algo;
	private JLabel lb_tick;
	private JLabel lb_tickTime;
	private JButton bp_start;
	private JButton bp_stop;

	public MaFenetre(String title) {
		this.setTitle(title);
		this.setSize(580, 400);
		init();
		placement();
		this.getContentPane().setLayout(new BorderLayout());
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
		jp_centre = new JPanel(new GridLayout(2, 2));
		jp_centre.setBorder(BorderFactory.createTitledBorder("Afficheur"));
		init_algo();
		init_timePanel();
		init_afficheur();
	}

	private void init_afficheur() {
		jp_centre.add(new JLabel("Afficheur 1"));
		jp_centre.add(new JLabel("Afficheur 2"));
		jp_centre.add(new JLabel("Afficheur 3"));
		jp_centre.add(new JLabel("Afficheur 4"));
	}

	private void init_timePanel() {
		lb_tick = new JLabel("Time : ");
		lb_tickTime = new JLabel("120ms");
		bp_start = new JButton("Start");
		bp_stop = new JButton("Stop");
		bp_stop.setEnabled(false);
		bp_start.addActionListener(this);
		bp_stop.addActionListener(this);
		jp_top.add(lb_tick);
		jp_top.add(lb_tickTime);
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
			System.out.println("[SET-ALGO]" + cb_algo.getSelectedItem());
			Capteur capteur1 = new CapteurImpl(1, cb_algo.getSelectedItem().toString());
			// to do
//			Capteur captuer2 = new CapteurImpl(2, "Seq");

			Canal canal1 = new Canal(1);
			Canal canal2 = new Canal(2);
			Canal canal3 = new Canal(3);

			capteur1.attach(canal1);
			capteur1.attach(canal2);
			capteur1.attach(canal3);
			capteur1.tick();

			bp_start.setEnabled(false);
			bp_stop.setEnabled(true);
		}
		if (e.getSource() == bp_stop) {
			bp_start.setEnabled(true);
			bp_stop.setEnabled(false);
		}
	}

}
