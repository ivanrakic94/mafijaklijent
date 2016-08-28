package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

public class PocetniProzor extends JFrame {

	public JPanel contentPane;
	public JTextField imeField;
	public boolean flag = false;
	public boolean uspesnoUlogovan = false;
	public JTextField passwordField;
	public JRadioButton rdbtnRegistrujMe;

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
		contentPane.setLayout(new MigLayout("", "[1.00px,grow][84.00px][226px][grow]",
				"[grow][25px][20px][20px][43.00px][46.00px][16.00px][10px:n,grow]"));

		JLabel lblDobrodoliUnesiteIme = new JLabel("Dobro do\u0161li!");
		lblDobrodoliUnesiteIme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblDobrodoliUnesiteIme, "cell 1 0 2 1,alignx center,growy");

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblUsername, "cell 1 2,growx,aligny center");

		imeField = new JTextField();
		contentPane.add(imeField, "cell 2 2,growx,aligny top");
		imeField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPassword, "cell 1 3,growx,aligny center");

		JButton btnOk = new JButton("Log-In");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(proveriDaLiSuPoljaValidna());
				if (proveriDaLiSuPoljaValidna()) {
					flag = true;
					imeField.setEditable(false);
					passwordField.setEditable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Polje ne sme biti prazno, niti sme sadrzati znak \";\"");
				}

			}
		});

		passwordField = new JTextField();
		passwordField.setColumns(10);
		contentPane.add(passwordField, "cell 2 3,growx,aligny top");

		rdbtnRegistrujMe = new JRadioButton("REGISTRUJ ME");
		rdbtnRegistrujMe.setBackground(SystemColor.textHighlight);
		contentPane.add(rdbtnRegistrujMe, "cell 2 4");
		contentPane.add(btnOk, "cell 1 5 2 1,grow");
	}

	public String vratiIme() {

		flag = false;
		return imeField.getText();
	}

	public String vratiPassword() {

		flag = false;
		return passwordField.getText();
	}

	public void obrisiPolja() {
		imeField.setText("");
		imeField.setEditable(true);
		passwordField.setText("");
		passwordField.setEditable(true);
	}

	public boolean proveriDaLiSuPoljaValidna() {

		String ime = imeField.getText();
		String pass = passwordField.getText();

		// provera validnosti unetih podataka
		if (ime != null && !ime.isEmpty() && ime != "" && ime != " " && !ime.contains(";") && pass != null && !pass.isEmpty() && pass != "" && pass != " "
				&& !pass.contains(";")) {
			return true;
		}
		return false;
	}

}
