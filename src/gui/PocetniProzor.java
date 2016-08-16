package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PocetniProzor extends JFrame {

	private JPanel contentPane;
	private JTextField imeField;
	public boolean flag = false;

	/**
	 * Create the frame.
	 */
	public PocetniProzor() {
		setTitle("Mafija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDobrodoliUnesiteIme = new JLabel("Dobro do\u0161li! Unesite ime:");
		lblDobrodoliUnesiteIme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDobrodoliUnesiteIme.setBounds(102, 38, 252, 23);
		contentPane.add(lblDobrodoliUnesiteIme);
		
		imeField = new JTextField();
		imeField.setBounds(102, 89, 226, 20);
		contentPane.add(imeField);
		imeField.setColumns(10);
		
		JCheckBox chckbxPrviPutIgram = new JCheckBox("Prvi put igram");
		chckbxPrviPutIgram.setBackground(SystemColor.textHighlight);
		chckbxPrviPutIgram.setBounds(101, 116, 211, 23);
		contentPane.add(chckbxPrviPutIgram);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = true;
				imeField.setEditable(false);
			}
		});
		btnOk.setBounds(173, 159, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblSaekajteOstaleIgrae = new JLabel("Sa\u010Dekajte ostale igra\u010De...");
		lblSaekajteOstaleIgrae.setBounds(159, 204, 158, 14);
		contentPane.add(lblSaekajteOstaleIgrae);
	}
	
	public String vratiIme() {
		flag = false;
		return imeField.getText();
	}
	
}
