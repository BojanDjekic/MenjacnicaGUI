package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton rdbtnZaistaObrisiKurs;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JLabel label;
	private MenjacnicaGUI menjacnica;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI menjacnica) {
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTextField_4());
		contentPane.add(getTextField_5());
		contentPane.add(getRdbtnZaistaObrisiKurs());
		contentPane.add(getLabel());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		this.menjacnica = menjacnica;
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JRadioButton getRdbtnZaistaObrisiKurs() {
		if (rdbtnZaistaObrisiKurs == null) {
			rdbtnZaistaObrisiKurs = new JRadioButton("Zaista obrisi kurs");
			rdbtnZaistaObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnZaistaObrisiKurs.isSelected()) {
						btnObrisi.setEnabled(true);
					} else {
						btnObrisi.setEnabled(false);

					}
				}
			});
			rdbtnZaistaObrisiKurs.setPreferredSize(new Dimension(1000, 250));
		}
		return rdbtnZaistaObrisiKurs;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String string = textField.getText() + " " + textField_1.getText() + " " + textField_2.getText() + " " + textField_3.getText() + " "+ textField_4.getText() + " " + textField_5.getText() + "\n";
					menjacnica.aStatus.setText(menjacnica.aStatus.getText() + string);
					dispose();
				}
			});
			btnObrisi.setEnabled(false);
		}
		return btnObrisi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
		}
		return label;
	}
}
