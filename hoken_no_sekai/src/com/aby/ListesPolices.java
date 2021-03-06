package com.aby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

//import com.toedter.calendar.JDateChooser;

public class ListesPolices extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					ListesPolices frame = new ListesPolices();
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
	public ListesPolices() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Listes des Polices");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ListesPolices.this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				ListesPolices.this.dispose();
			}
		});
		
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnFermer = new JButton("Retour");
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(expiration_mensuelle.class.getResource("/images/print-icon.png")));
		
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
			ListesPolices.this.dispose();
			}
		});
		
		btnFermer.setIcon(new ImageIcon(expiration_mensuelle.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btnFermer);
		menuBar.add(btnImprimer);
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
		String[] entete = {"Attestation","Police","Assur?","Immat","Effet","Ech?ance"};
		table = new JTable();
		table.setToolTipText("");
		table.setEditingRow(0);
		table.setEditingColumn(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
//	
		String requeteListePolices= "SELECT talon.POLICE,talon.ATTESTATION, talon.ASSURE,client.ADRESSE,vehicule.GENRE"
				+ " FROM talon INNER JOIN client INNER JOIN vehicule ON "
				+ "((talon.NINEA=client.NINEA) AND (vehicule.IMMAT= talon.IMMAT) AND (client.ASSURE = talon.ASSURE))";
		try {
			PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteListePolices);
			ResultSet rs= ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JScrollPane scPane = new JScrollPane(table);
		scPane.setBounds(new Rectangle(0, 0, 600, 510));
		scPane.setColumnHeaderView(table.getTableHeader());
		contentPane.add(scPane);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ListesPolices.class.getResource("/images/fond.jpg")));
		lblNewLabel_2.setBounds(-939, -54, 1143, 524);
		contentPane.add(lblNewLabel_2);
		}
		
}
