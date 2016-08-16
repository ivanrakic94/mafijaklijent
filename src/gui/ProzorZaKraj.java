package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProzorZaKraj extends JFrame {

	private JPanel contentPane;
	public JLabel krajLbl;
	public JButton novaPartijaBtn;
	public JButton krajIgreBtn;
	public boolean flag = false;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorZaKraj frame = new ProzorZaKraj();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ProzorZaKraj() {
		setTitle("Kraj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		krajLbl = new JLabel("Kraj");
		krajLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		krajLbl.setBounds(46, 51, 359, 73);
		contentPane.add(krajLbl);
		
		novaPartijaBtn = new JButton("Nova partija");
		novaPartijaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = true;
			}
		});
		novaPartijaBtn.setBounds(60, 176, 107, 23);
		contentPane.add(novaPartijaBtn);
		
		krajIgreBtn = new JButton("Kraj igre");
		krajIgreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		krajIgreBtn.setBounds(236, 176, 107, 23);
		contentPane.add(krajIgreBtn);
	}
	
	public void ispisi(String pob) {
		krajLbl.setText("Partija je gotova! Pobedili su: "+pob);
	}
}
