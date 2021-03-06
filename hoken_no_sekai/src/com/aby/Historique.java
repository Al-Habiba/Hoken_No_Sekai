package com.aby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

public class Historique extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel allButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				}catch (Exception e) {}	
				try {
					Historique frame = new Historique();
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
	public Historique() {
		setName("frame");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historique.class.getResource("/images/car.png")));
		setBackground(Color.WHITE);
		setTitle("Historique");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		Historique.this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				Historique.this.dispose();
			}
		});
		
		
		JButton btn_exit = new JButton("Fermer");
		btn_exit.setIcon(new ImageIcon(Historique.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btn_exit);
		
		JButton btn_nf = new JButton("Nouvelle Affaire");
		btn_nf.setIcon(new ImageIcon(Historique.class.getResource("/images/new-file-icon (1).png")));
		menuBar.add(btn_nf);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MessageFormat header= new MessageFormat("Historique: ");
				 MessageFormat footer = new MessageFormat("Page{0,number,interger} ");
				 try {
					table.print(JTable.PrintMode.NORMAL,header,footer);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erreur d'impression");
				}
			}
		});
		btnImprimer.setIcon(new ImageIcon(Historique.class.getResource("/images/print-icon.png")));
		menuBar.add(btnImprimer);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page_Accueil window =new Page_Accueil();
				window.accueil.setVisible(true);
				Historique.this.dispose();
				
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] entete = {"Attestation","Police","Assur?","Adresse","Genre",};
		table = new JTable();
		table.setToolTipText("");
		table.setEditingRow(0);
		table.setEditingColumn(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		String requeteHistorique="SELECT talon.ATTESTATION,talon.POLICE,talon.assure,client.ADRESSE,vehicule.GENRE,vehicule.MARQUE "
				+ "FROM talon INNER JOIN client INNER JOIN vehicule "
				+ "on (talon.NINEA=client.NINEA) AND (vehicule.IMMAT=talon.IMMAT) AND (client.ASSURE=talon.assure)";
		try {
			PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteHistorique);
			ResultSet rs= ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table.setBounds(48, 44, 654, 193);
		JScrollPane scPane = new JScrollPane(table);
		scPane.setBounds(new Rectangle(0, 0, 600, 510));
		scPane.setColumnHeaderView(table.getTableHeader());
		
		allButton = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
//		contentPane.add(table.getTableHeader());
		contentPane.add(scPane);
		contentPane.add(allButton);
		allButton.setLayout(null);
		
		JButton btn_renew = new JButton("Renouvellement");
		btn_renew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_renew.setBounds(21, 41, 134, 21);
		allButton.add(btn_renew);
		
		JButton btn_edit = new JButton("Modifier");
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= table.getSelectedRow();
				int n= table.getColumnCount();
				System.out.println(a);
			}
		});
		btn_edit.setBounds(21, 104, 134, 21);
		allButton.add(btn_edit);
		
		JButton btn_shareName = new JButton("Transfert Nom");
		btn_shareName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_shareName.setBounds(21, 135, 134, 21);
		allButton.add(btn_shareName);
		
		JButton btn_rm = new JButton("Supprimer");
		btn_rm.setBounds(21, 166, 134, 21);
		allButton.add(btn_rm);
		
		JLabel lblNewLabel = new JLabel("Date de d\u00E9but :");
		lblNewLabel.setBounds(21, 230, 88, 13);
		allButton.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date de fin :");
		lblNewLabel_1.setBounds(21, 261, 76, 13);
		allButton.add(lblNewLabel_1);
		
		JButton btn_filtrer = new JButton("FILTRER");
		btn_filtrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_filtrer.setBounds(21, 336, 134, 21);
		allButton.add(btn_filtrer);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 230, 70, 19);
		allButton.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(110, 260, 70, 19);
		allButton.add(dateChooser_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.inactiveCaption);
		comboBox.setBounds(35, 305, 109, 21);
		allButton.add(comboBox);
		
		JButton btn_Duplicata = new JButton("Duplicata");
		btn_Duplicata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Duplicata.setBounds(21, 73, 134, 21);
		allButton.add(btn_Duplicata);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Historique.class.getResource("/images/fond.jpg")));
		lblNewLabel_2.setBounds(-939, -54, 1143, 524);
		allButton.add(lblNewLabel_2);
		
	}
}
