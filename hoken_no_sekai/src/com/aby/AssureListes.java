package com.aby;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;


import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

public class AssureListes extends JFrame {

	/**
	 * 
	 */
	//JFrame frame;
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JPanel allButtonPanel;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	public static ResultSet rsOfClient = null;
	public static ResultSet rsOfTalon = null;
	public static ResultSet rsOfVehicule = null;
	int ninea = 0 ;
	int  idVehicule= 0;
	protected int idClient;
	public static String dateEf;
	public static String dateEc;
	public static String immatricule;
	public static String police;
	public static String attestation;
	public static String heure;
	public static int nbrMois;
	public static String assure;
	public static String tel;
	public static String adresse;
	public static String contact;
	public static String energie;
	public static String marque;
	public static String categorie;
	public static String Tonnage;
	public static int nbrPlaces;
	public static String genre;
	public static String visiteTech;
	public static PreparedStatement ps;

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
					AssureListes frame = new AssureListes();
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
	public AssureListes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AssureListes.class.getResource("/images/car.png")));
		setForeground(Color.WHITE);
		setTitle("Liste des Assur\u00E9s");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		AssureListes.this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				AssureListes.this.dispose();
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page_Accueil window=new Page_Accueil();
				window.accueil.setVisible(true);
				AssureListes.this.dispose();
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(AssureListes.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btnNewButton);
		
		JButton btn_nf = new JButton("Nouvelle Affaire");
		btn_nf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affaire_Nouvelle window= new Affaire_Nouvelle();
				window.frame.setVisible(true);
				AssureListes.this.dispose();
				
			}
		});
		btn_nf.setIcon(new ImageIcon(AssureListes.class.getResource("/images/new-file-icon (1).png")));
		menuBar.add(btn_nf);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(AssureListes.class.getResource("/images/print-icon.png")));
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
		
		JButton btn_edit = new JButton("Modifier");
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(btn_edit);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	//	String[] entete = {"Op?rateur","Num?ro Attestation","Num?ro Police","Assur?","Immatricule"};
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		table = new JTable();
		table.setToolTipText("");
		table.setEditingRow(0);
		table.setEditingColumn(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		String requeteListePolices= "SELECT talon.assure,apporteur_affaires.OPERATEUR,talon.IMMAT,talon.ATTESTATION,talon.POLICE "
				+ "from talon,apporteur_affaires WHERE apporteur_affaires.NINEA=talon.NINEA";
			try {
				PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteListePolices);
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
//		contentPane.add(table.getTableHeader());
		contentPane.add(scPane);
		
		
		allButtonPanel = new JPanel();
		allButtonPanel.setBackground(Color.WHITE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
//		contentPane.add(table.getTableHeader());
		contentPane.add(scPane);
		contentPane.add(allButtonPanel);
		allButtonPanel.setLayout(null);
		
		JButton btn_renew = new JButton("Renouvellement");
		btn_renew.setBounds(21, 41, 134, 21);
		allButtonPanel.add(btn_renew);
		
		JButton btn_Duplicata = new JButton("Duplicata");
		btn_Duplicata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= table.getSelectedRow();
				int n= table.getColumnCount();
			//	System.out.println(a);
				String[] tab = new String[5];
				for(int i=0; i<n; i++)
				{
				    tab[i] = (String) table.getModel().getValueAt(a,i);
				    System.out.println(tab[i]);
				}
				String nomOp=tab[0];
				String attest=tab[1];
				String pol=tab[2];
				String ass=tab[3];
				String im =tab[4];
				System.out.println(nomOp); 				System.out.println(attest);
				System.out.println(pol); 				System.out.println(ass);
				System.out.println(im);
				String r1="SELECT * FROM `talon` WHERE IMMAT= \""+im+"\" AND POLICE= \""+pol+"\" AND ATTESTATION=\""+attest+"\"";
//				String r2="SELECT * from `vehicule` WHERE IMMAT='"+im+"'";
				
				
				try {
					rsOfTalon = st.executeQuery(r1);
					if(rsOfTalon.next()) {
						ninea = rsOfTalon.getInt(3);
						idVehicule = rsOfTalon.getInt(2);
						dateEf = rsOfTalon.getString(7);
						dateEc = rsOfTalon.getString(8);
						immatricule = rsOfTalon.getString(4);
						police = rsOfTalon.getString(6);
						attestation = rsOfTalon.getString(5);
						heure = rsOfTalon.getString(9);
						nbrMois = rsOfTalon.getInt(10);
						idClient = rsOfTalon.getInt(11);
						adresse = rsOfTalon.getString(12);
						rsOfTalon.close();
						JOptionPane.showMessageDialog(AssureListes.this, "bien recuperer dans le Talon");
					}
						
						String r3 ="SELECT * from client WHERE IDCLIENT=? AND NINEA=? AND ASSURE=?";
						ps = (PreparedStatement) con.prepareStatement(r3);
						ps.setInt(1, idClient);
						ps.setInt(2, ninea);
						ps.setString(3, adresse);
						rsOfClient = ps.executeQuery();
							if (rsOfClient.next()) {
							assure =rsOfClient.getString(3);
							tel = rsOfClient.getString(4);
							adresse = rsOfClient.getString(7);
							contact = rsOfClient.getString(5);
							JOptionPane.showMessageDialog(AssureListes.this, "bien recuperer dans la client");
							rsOfClient.close();
							}
							String r2="SELECT * from vehicule WHERE IDVEHICULE=?";
							ps = (PreparedStatement) con.prepareStatement(r2);
							ps.setInt(1, idVehicule);
							rsOfVehicule = ps.executeQuery();
							if (rsOfVehicule.next()) {
								energie =rsOfVehicule.getString(2);
								marque =rsOfVehicule.getString(3);
								categorie = rsOfVehicule.getString(4) ;
								Tonnage = rsOfVehicule.getString(5);
								nbrPlaces = rsOfVehicule.getInt(6);
								genre = rsOfVehicule.getString(7);
								visiteTech = rsOfVehicule.getString(8) ;
								JOptionPane.showMessageDialog(AssureListes.this, "bien recuperer dans Vehicule");
								//NouvelleAffaire2 na = new NouvelleAffaire2();
								//na.setVisible(true);
								rsOfVehicule.close();
							}
//						REGENERATION DES FENETRES
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Duplicata.setBounds(21, 70, 134, 21);
		allButtonPanel.add(btn_Duplicata);
		
		JButton btn_shareName = new JButton("Transfert Nom");
		btn_shareName.setBounds(21, 103, 134, 21);
		allButtonPanel.add(btn_shareName);
		
		JButton btn_rm = new JButton("Supprimer");
		btn_rm.setIcon(new ImageIcon(AssureListes.class.getResource("/images/Actions-edit-delete-icon.png")));
		btn_rm.setBounds(21, 134, 134, 21);
		allButtonPanel.add(btn_rm);
		
		JLabel lblNewLabel = new JLabel("Date de d\u00E9but :");
		lblNewLabel.setBounds(21, 220, 83, 13);
		allButtonPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date de fin :");
		lblNewLabel_1.setBounds(21, 251, 83, 13);
		allButtonPanel.add(lblNewLabel_1);
		
		JButton btn_filtrer = new JButton("FILTRER");
		btn_filtrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_filtrer.setBounds(21, 310, 134, 21);
		allButtonPanel.add(btn_filtrer);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 220, 80, 19);
		allButtonPanel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(105, 245, 80, 19);
		allButtonPanel.add(dateChooser_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.inactiveCaption);
		comboBox.setBounds(32, 279, 109, 21);
		allButtonPanel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AssureListes.class.getResource("/images/fond.jpg")));
		lblNewLabel_2.setBounds(-823, -13, 1036, 493);
		allButtonPanel.add(lblNewLabel_2);
		
		
		
	}
}
