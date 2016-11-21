package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MaFenetre extends JFrame implements ActionListener{
	
	private JPanel jp_top;
	private JLabel lb_algo;
	private JComboBox<String> cb_algo;
	private JLabel lb_tick;
	private JLabel lb_tickTime;
	private JButton bp_start;
	
	public MaFenetre(String title)
	{
		this.setTitle(title);
		this.setSize(500, 400);
		init();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jp_top, BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		jp_top=new JPanel(new FlowLayout());
		jp_top.setBorder(BorderFactory.createTitledBorder("Top"));
		init_algo();
		init_time();
	}

	private void init_time() {	
		lb_tick= new JLabel("Time : ");
		lb_tickTime= new JLabel("120ms");
		bp_start=new JButton("Start");
		bp_start.addActionListener(this);
		jp_top.add(lb_tick);
		jp_top.add(lb_tickTime);
		jp_top.add(bp_start);
	}

	private void init_algo() {
		lb_algo= new JLabel("Algo : ");
		cb_algo=new JComboBox<>();
		cb_algo.addItem("Atomique");
		cb_algo.addItem("Seq");
		cb_algo.addItem("Epoque");
		jp_top.add(lb_algo);
		jp_top.add(cb_algo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bp_start)
		{
			bp_start.setText("Stop");
		}
	}
	
}
