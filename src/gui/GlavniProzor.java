package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JTextField chatTextField;
	private JTextField ubiceTextField;
	public JList igraciList;
	public JLabel ulogaLbl;
	public JLabel ulLbl;
	public JTextArea ubiceTextArea;
	public JButton ulogaButton;
	public JRadioButton ulogaRadioButton1;
	public JRadioButton ulogaRadioButton2;
	public JRadioButton ulogaRadioButton3;
	public JRadioButton ulogaRadioButton4;
	public JRadioButton ulogaRadioButton5;
	public JRadioButton ulogaRadioButton6;
	private String[] igraci = new String[5];
	private String[] sviIgraci;
	public String ime;
	public JRadioButton izbacivanjeRadioButton1;
	public JRadioButton izbacivanjeRadioButton2;
	public JRadioButton izbacivanjeRadioButton3;
	public JRadioButton izbacivanjeRadioButton4;
	public JRadioButton izbacivanjeRadioButton5;
	public JRadioButton izbacivanjeRadioButton6;
	public JButton izbacivanjeBtn;
	public boolean ulogaFlag = false;
	public ButtonGroup r1;
	public ButtonGroup r2;
	public JLabel policajacLabel;
	public JTextArea chatTextArea;
	private JLabel ispadanjeLabel;
	public boolean izbacivanjeFlag = false;


	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setTitle("Mafija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 451);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel, "cell 0 0 2 1,grow");
		panel.setLayout(null);
		
		r1 = new ButtonGroup();
		r2 = new ButtonGroup();
		
		JLabel lblIgrai = new JLabel("Igra\u010Di");
		lblIgrai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIgrai.setBounds(10, 11, 46, 19);
		panel.add(lblIgrai);
		
		igraciList = new JList();
		igraciList.setBounds(10, 38, 142, 116);
		panel.add(igraciList);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(211, 11, 54, 19);
		panel.add(lblStatus);
		
		ulogaLbl = new JLabel("Uloga");
		ulogaLbl.setBounds(221, 39, 198, 31);
		panel.add(ulogaLbl);
		
		policajacLabel = new JLabel("");
		policajacLabel.setBounds(221, 94, 181, 14);
		panel.add(policajacLabel);
		
		ispadanjeLabel = new JLabel("");
		ispadanjeLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ispadanjeLabel.setBounds(219, 128, 183, 53);
		panel.add(ispadanjeLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 2 0,grow");
		
		chatTextArea = new JTextArea(2, 1);
		chatTextArea.setWrapStyleWord(true);
		chatTextArea.setEditable(false);
		scrollPane.setViewportView(chatTextArea);
		
		chatTextField = new JTextField();
		scrollPane.setColumnHeaderView(chatTextField);
		chatTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_1, "cell 0 1 1 2,grow");
		panel_1.setLayout(null);
		
		JLabel izbacivanjeLbl = new JLabel("Koga \u017Eelite da izbacite?");
		izbacivanjeLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		izbacivanjeLbl.setBounds(10, 11, 162, 14);
		panel_1.add(izbacivanjeLbl);
		
		izbacivanjeRadioButton1 = new JRadioButton("Igra\u010D1");
		izbacivanjeRadioButton1.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		izbacivanjeRadioButton1.setBounds(10, 32, 109, 14);
		panel_1.add(izbacivanjeRadioButton1);
		r1.add(izbacivanjeRadioButton1);
		
		izbacivanjeRadioButton2 = new JRadioButton("Igra\u010D1");
		izbacivanjeRadioButton2.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		izbacivanjeRadioButton2.setBounds(10, 49, 109, 14);
		panel_1.add(izbacivanjeRadioButton2);
		r1.add(izbacivanjeRadioButton2);
		
		izbacivanjeRadioButton3 = new JRadioButton("Igra\u010D1");
		izbacivanjeRadioButton3.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		izbacivanjeRadioButton3.setBounds(10, 66, 109, 14);
		panel_1.add(izbacivanjeRadioButton3);
		r1.add(izbacivanjeRadioButton3);
		
		izbacivanjeRadioButton4 = new JRadioButton("Igra\u010D1");
		izbacivanjeRadioButton4.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		izbacivanjeRadioButton4.setBounds(10, 83, 109, 14);
		panel_1.add(izbacivanjeRadioButton4);
		r1.add(izbacivanjeRadioButton4);
		
		izbacivanjeRadioButton5 = new JRadioButton("Igra\u010D1");
		izbacivanjeRadioButton5.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		izbacivanjeRadioButton5.setBounds(10, 100, 109, 14);
		panel_1.add(izbacivanjeRadioButton5);
		r1.add(izbacivanjeRadioButton5);
		
		izbacivanjeBtn = new JButton("OK");
		izbacivanjeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				izbacivanjeFlag = true;
			}
		});
		izbacivanjeBtn.setBounds(10, 142, 89, 23);
		panel_1.add(izbacivanjeBtn);
		
		izbacivanjeRadioButton6 = new JRadioButton("Igrac1");
		izbacivanjeRadioButton6.setBackground(SystemColor.textHighlight);
		izbacivanjeRadioButton6.setBounds(10, 113, 109, 23);
		panel_1.add(izbacivanjeRadioButton6);
		r1.add(izbacivanjeRadioButton6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		contentPane.add(panel_2, "cell 1 1 1 2,grow");
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 194, 168);
		panel_2.add(panel_3);
		
		ulLbl = new JLabel("Koga \u017Eelite da");
		ulLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ulLbl.setBounds(10, 11, 162, 14);
		panel_3.add(ulLbl);
		
		ulogaRadioButton1 = new JRadioButton("Igra\u010D1");
		ulogaRadioButton1.setBackground(SystemColor.textHighlight);
		ulogaRadioButton1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ulogaRadioButton1.setBounds(10, 32, 109, 14);
		panel_3.add(ulogaRadioButton1);
		r2.add(ulogaRadioButton1);
		
		ulogaRadioButton2 = new JRadioButton("Igra\u010D1");
		ulogaRadioButton2.setBackground(SystemColor.textHighlight);
		ulogaRadioButton2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ulogaRadioButton2.setBounds(10, 49, 109, 14);
		panel_3.add(ulogaRadioButton2);
		r2.add(ulogaRadioButton2);
		
		ulogaRadioButton3 = new JRadioButton("Igra\u010D1");
		ulogaRadioButton3.setBackground(SystemColor.textHighlight);
		ulogaRadioButton3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ulogaRadioButton3.setBounds(10, 66, 109, 14);
		panel_3.add(ulogaRadioButton3);
		r2.add(ulogaRadioButton3);
		
		ulogaRadioButton4 = new JRadioButton("Igra\u010D1");
		ulogaRadioButton4.setBackground(SystemColor.textHighlight);
		ulogaRadioButton4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ulogaRadioButton4.setBounds(10, 83, 109, 14);
		panel_3.add(ulogaRadioButton4);
		r2.add(ulogaRadioButton4);
		
		ulogaRadioButton5 = new JRadioButton("Igra\u010D1");
		ulogaRadioButton5.setBackground(SystemColor.textHighlight);
		ulogaRadioButton5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ulogaRadioButton5.setBounds(10, 100, 109, 14);
		panel_3.add(ulogaRadioButton5);
		r2.add(ulogaRadioButton5);
		
		ulogaButton = new JButton("OK");
		ulogaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ulogaFlag = true;
			}
		});
		ulogaButton.setBounds(10, 145, 89, 23);
		panel_3.add(ulogaButton);
		
		ulogaRadioButton6 = new JRadioButton("Igrac1");
		ulogaRadioButton6.setBackground(SystemColor.textHighlight);
		ulogaRadioButton6.setBounds(10, 115, 109, 23);
		panel_3.add(ulogaRadioButton6);
		r2.add(ulogaRadioButton6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 2 1 1 2,grow");
		
		ubiceTextArea = new JTextArea();
		ubiceTextArea.setEditable(false);
		scrollPane_1.setViewportView(ubiceTextArea);
		
		ubiceTextField = new JTextField();
		scrollPane_1.setColumnHeaderView(ubiceTextField);
		ubiceTextField.setColumns(10);
	}
	
	public void ispisiIgrace(String[] igraci) {
		sviIgraci = igraci;
		int p = 0;
		for (int i = 0; i < igraci.length; i++) {
			if (!igraci[i].equals(ime)) {
				this.igraci[p] = igraci[i];
				p++;
			}
		}
		igraciList.setListData(sviIgraci);
	}
	
	public void ispisiUlogu(String uloga) {
		ulogaLbl.setText("Vaša uloga je: "+uloga);
	}
	
	public void ulogaUbice() {
		ulLbl.setText("Koga zelite da ubijete?");
		izbacivanjeBtn.setEnabled(false);
		izbacivanjeRadioButton1.setText(igraci[0]);
		izbacivanjeRadioButton2.setText(igraci[1]);
		izbacivanjeRadioButton3.setText(igraci[2]);
		izbacivanjeRadioButton4.setText(igraci[3]);
		izbacivanjeRadioButton5.setText(igraci[4]);
		izbacivanjeRadioButton6.setText(ime);
		izbacivanjeRadioButton6.setEnabled(false);
		ulogaRadioButton1.setText(igraci[0]);
		ulogaRadioButton2.setText(igraci[1]);
		ulogaRadioButton3.setText(igraci[2]);
		ulogaRadioButton4.setText(igraci[3]);
		ulogaRadioButton5.setText(igraci[4]);
		ulogaRadioButton6.setText(ime);
		
	}
	
	public void ulogaLekara() {
		ulLbl.setText("Koga zelite da izlecite?");
		ubiceTextArea.setEditable(false);
		ubiceTextField.setEditable(false);
		izbacivanjeBtn.setEnabled(false);
		izbacivanjeRadioButton1.setText(igraci[0]);
		izbacivanjeRadioButton2.setText(igraci[1]);
		izbacivanjeRadioButton3.setText(igraci[2]);
		izbacivanjeRadioButton4.setText(igraci[3]);
		izbacivanjeRadioButton5.setText(igraci[4]);
		izbacivanjeRadioButton6.setText(ime);
		izbacivanjeRadioButton6.setEnabled(false);
		ulogaRadioButton1.setText(igraci[0]);
		ulogaRadioButton2.setText(igraci[1]);
		ulogaRadioButton3.setText(igraci[2]);
		ulogaRadioButton4.setText(igraci[3]);
		ulogaRadioButton5.setText(igraci[4]);
		ulogaRadioButton6.setText(ime);
		
	}
	
	public void ulogaPolicajca() {
		ulLbl.setText("Na koga sumnjate?");
		ubiceTextArea.setEditable(false);
		ubiceTextField.setEditable(false);
		izbacivanjeBtn.setEnabled(false);
		izbacivanjeRadioButton1.setText(igraci[0]);
		izbacivanjeRadioButton2.setText(igraci[1]);
		izbacivanjeRadioButton3.setText(igraci[2]);
		izbacivanjeRadioButton4.setText(igraci[3]);
		izbacivanjeRadioButton5.setText(igraci[4]);
		izbacivanjeRadioButton6.setText(ime);
		izbacivanjeRadioButton6.setEnabled(false);
		ulogaRadioButton1.setText(igraci[0]);
		ulogaRadioButton2.setText(igraci[1]);
		ulogaRadioButton3.setText(igraci[2]);
		ulogaRadioButton4.setText(igraci[3]);
		ulogaRadioButton5.setText(igraci[4]);
		ulogaRadioButton6.setText(ime);
		
	}
	
	public void ulogaGradjanina() {
		ulLbl.setText("");
		ubiceTextArea.setEditable(false);
		ubiceTextField.setEditable(false);
		ulogaButton.setEnabled(false);
		ulogaRadioButton1.setEnabled(false);
		ulogaRadioButton2.setEnabled(false);
		ulogaRadioButton3.setEnabled(false);
		ulogaRadioButton4.setEnabled(false);
		ulogaRadioButton5.setEnabled(false);
		izbacivanjeBtn.setEnabled(false);
		izbacivanjeRadioButton1.setText(igraci[0]);
		izbacivanjeRadioButton2.setText(igraci[1]);
		izbacivanjeRadioButton3.setText(igraci[2]);
		izbacivanjeRadioButton4.setText(igraci[3]);
		izbacivanjeRadioButton5.setText(igraci[4]);
		izbacivanjeRadioButton6.setText(ime);
		izbacivanjeRadioButton6.setEnabled(false);
		ulogaRadioButton1.setText(igraci[0]);
		ulogaRadioButton2.setText(igraci[1]);
		ulogaRadioButton3.setText(igraci[2]);
		ulogaRadioButton4.setText(igraci[3]);
		ulogaRadioButton5.setText(igraci[4]);
		ulogaRadioButton6.setText(ime);
		ulogaRadioButton6.setEnabled(false);
	}
	
	public String vratiIzborZaUlogu() {
		ulogaFlag = false;
		ulogaButton.setEnabled(false);
		if (ulogaRadioButton1.isSelected()) {
			return ulogaRadioButton1.getText();
		}
		
		if (ulogaRadioButton2.isSelected()) {
			return ulogaRadioButton2.getText();
		}
		
		if (ulogaRadioButton3.isSelected()) {
			return ulogaRadioButton3.getText();
		}
		
		if (ulogaRadioButton4.isSelected()) {
			return ulogaRadioButton4.getText();
		}
		
		if (ulogaRadioButton5.isSelected()) {
			return ulogaRadioButton5.getText();
		}
		if (ulogaRadioButton6.isSelected()) {
			return ulogaRadioButton6.getText();
		}
		
		return "";
	}
	
	public void odgovoriPolicajcu(String odg) {
		policajacLabel.setText(odg);
	}
	
	public void obavesti(String ub) {
		if (ub != null && !ub.equals("null") ) {
			chatTextArea.setText(chatTextArea.getText()+"\n"+ub+" je ubijen!"+"\n");
			for (int i = 0; i < sviIgraci.length; i++) {
				if (sviIgraci[i].equals(ub)) {
					sviIgraci[i] = "";
				}
			}
			igraciList.setListData(sviIgraci);
			
			if (izbacivanjeRadioButton1.getText().equals(ub)) {
				izbacivanjeRadioButton1.setVisible(false);
			}
			
			if (izbacivanjeRadioButton2.getText().equals(ub)) {
				izbacivanjeRadioButton2.setVisible(false);
			}
			
			if (izbacivanjeRadioButton3.getText().equals(ub)) {
				izbacivanjeRadioButton3.setVisible(false);
			}
			
			if (izbacivanjeRadioButton4.getText().equals(ub)) {
				izbacivanjeRadioButton4.setVisible(false);
			}
			
			if (izbacivanjeRadioButton5.getText().equals(ub)) {
				izbacivanjeRadioButton5.setVisible(false);
			}
			
			if (izbacivanjeRadioButton6.getText().equals(ub)) {
				izbacivanjeRadioButton6.setVisible(false);
			}
			
			if (ulogaRadioButton1.getText().equals(ub)) {
				ulogaRadioButton1.setVisible(false);
			}
			
			if (ulogaRadioButton2.getText().equals(ub)) {
				ulogaRadioButton2.setVisible(false);
			}
			
			if (ulogaRadioButton3.getText().equals(ub)) {
				ulogaRadioButton3.setVisible(false);
			}
			
			if (ulogaRadioButton4.getText().equals(ub)) {
				ulogaRadioButton4.setVisible(false);
			}
			
			if (ulogaRadioButton5.getText().equals(ub)) {
				ulogaRadioButton5.setVisible(false);
			}
			
			if (ulogaRadioButton6.getText().equals(ub)) {
				ulogaRadioButton6.setVisible(false);
			}
		} else {
			chatTextArea.setText(chatTextArea.getText()+"\nNiko nije ubijen!\n");
		}
		ulogaButton.setEnabled(false);
		izbacivanjeBtn.setEnabled(true);
	}
	
	public void obavestiOIspadanju() {
		ispadanjeLabel.setText("Ispali ste iz igre! Sacekajte kraj partije.");
		ulogaButton.setEnabled(false);
		izbacivanjeBtn.setEnabled(false);
		chatTextArea.setEditable(false);
	}
	
	public String vratiIzborZaIzbacivanje() {
		izbacivanjeFlag = false;
		izbacivanjeBtn.setEnabled(false);
		if (izbacivanjeRadioButton1.isSelected()) {
			return izbacivanjeRadioButton1.getText();
		}
		
		if (izbacivanjeRadioButton2.isSelected()) {
			return izbacivanjeRadioButton2.getText();
		}
		
		if (izbacivanjeRadioButton3.isSelected()) {
			return izbacivanjeRadioButton3.getText();
		}
		
		if (izbacivanjeRadioButton4.isSelected()) {
			return izbacivanjeRadioButton4.getText();
		}
		
		if (izbacivanjeRadioButton5.isSelected()) {
			return izbacivanjeRadioButton5.getText();
		}
		
		return "";
	}
	
	public void obavestiOIzglasavanju(String izb) {
		chatTextArea.setText(chatTextArea.getText()+"\n"+izb+" je izglasan.\n");
		
		for (int i = 0; i < sviIgraci.length; i++) {
			if (sviIgraci[i].equals(izb)) {
				sviIgraci[i] = "";
			}
		}
		
		igraciList.setListData(sviIgraci);
		
		if (izbacivanjeRadioButton1.getText().equals(izb)) {
			izbacivanjeRadioButton1.setVisible(false);
		}
		
		if (izbacivanjeRadioButton2.getText().equals(izb)) {
			izbacivanjeRadioButton2.setVisible(false);
		}
		
		if (izbacivanjeRadioButton3.getText().equals(izb)) {
			izbacivanjeRadioButton3.setVisible(false);
		}
		
		if (izbacivanjeRadioButton4.getText().equals(izb)) {
			izbacivanjeRadioButton4.setVisible(false);
		}
		
		if (izbacivanjeRadioButton5.getText().equals(izb)) {
			izbacivanjeRadioButton5.setVisible(false);
		}
		
		if (izbacivanjeRadioButton6.getText().equals(izb)) {
			izbacivanjeRadioButton6.setVisible(false);
		}
		
		if (ulogaRadioButton1.getText().equals(izb)) {
			ulogaRadioButton1.setVisible(false);
		}
		
		if (ulogaRadioButton2.getText().equals(izb)) {
			ulogaRadioButton2.setVisible(false);
		}
		
		if (ulogaRadioButton3.getText().equals(izb)) {
			ulogaRadioButton3.setVisible(false);
		}
		
		if (ulogaRadioButton4.getText().equals(izb)) {
			ulogaRadioButton4.setVisible(false);
		}
		
		if (ulogaRadioButton5.getText().equals(izb)) {
			ulogaRadioButton5.setVisible(false);
		}
		
		if (ulogaRadioButton6.getText().equals(izb)) {
			ulogaRadioButton6.setVisible(false);
		}
		
		izbacivanjeBtn.setEnabled(false);
		ulogaButton.setEnabled(true);
	}
	
}
