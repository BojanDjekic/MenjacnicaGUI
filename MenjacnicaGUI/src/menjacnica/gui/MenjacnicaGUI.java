package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JTextArea aStatus;
	private MenjacnicaGUI menjacnica;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser f = new JFileChooser();
				f.showOpenDialog(f);
				File file = f.getSelectedFile();
				aStatus.setText(aStatus.getText() + "Ucitan fajl: " + file + "\n");
			}
		});
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		this.menjacnica = this;
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser f = new JFileChooser();
				f.showSaveDialog(f);
				aStatus.setText(aStatus.getText() + "Sacuvan fajl: " +f+ "\n");
		}
		});
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane j = new JOptionPane();
				int opcija = j.showConfirmDialog(j,"Da li ste sigurni da zelite da izadjete?", "Izlaz",j.YES_NO_CANCEL_OPTION);
				if (opcija == j.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane j = new JOptionPane();
				JOptionPane.showMessageDialog(j, "Autor: Bojan Djekic \nFakultet: FON \nBroj indeksa: 73/16", "Podaci o autoru",j.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(130, 10));
		contentPane.add(panel, BorderLayout.EAST);
		
		JButton DodajKurs = new JButton("Dodaj kurs");
		DodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dk = new DodajKursGUI(menjacnica);
				dk.setVisible(true);
			}
		});
		DodajKurs.setPreferredSize(new Dimension(120, 23));
		panel.add(DodajKurs);
		
		JButton ObrisiKurs = new JButton("Obrisi kurs");
		ObrisiKurs.setPreferredSize(new Dimension(120, 23));
		panel.add(ObrisiKurs);
		
		JButton IzvrsiZamenu = new JButton("Izvrsi zamenu");
		IzvrsiZamenu.setPreferredSize(new Dimension(120, 23));
		panel.add(IzvrsiZamenu);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dk = new DodajKursGUI(menjacnica);
				dk.setVisible(true);
			}
		});
		popupMenu.add(mntmDodajKurs);
		
		JMenuItem mntmObrsiKurs = new JMenuItem("Obrsi kurs\r\n");
		popupMenu.add(mntmObrsiKurs);
		
		JMenuItem mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		popupMenu.add(mntmIzvrsiZamenu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);
		
		aStatus = new JTextArea();
		aStatus.setRows(3);
		aStatus.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane_1.setViewportView(aStatus);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
