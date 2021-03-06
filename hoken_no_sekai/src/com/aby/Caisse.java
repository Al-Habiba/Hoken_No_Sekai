package com.aby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Caisse {

	static JFrame etatcaisse;
	private static JTable tableCaisse;
	static String requeteCaisse;
	Statement st=null;
	ResultSet rs=null;

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
					Caisse window = new Caisse();
					window.etatcaisse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Caisse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		etatcaisse = new JFrame();
		etatcaisse.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		etatcaisse.setIconImage(Toolkit.getDefaultToolkit().getImage(Caisse.class.getResource("/images/car.png")));
		etatcaisse.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		etatcaisse.setTitle("Etat de la Caisse");
		etatcaisse.setBounds(100, 100, 957, 605);
		etatcaisse.getContentPane().setLayout(null);
		etatcaisse.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				etatcaisse.dispose();
			}
		});
		
		
		JLabel datedebut = new JLabel("Date d\u00E9but:");
		datedebut.setBounds(39, 42, 66, 14);
		etatcaisse.getContentPane().add(datedebut);
		
		JLabel datefin = new JLabel("Date fin:");
		datefin.setBounds(39, 77, 46, 14);
		etatcaisse.getContentPane().add(datefin);
		
		JDateChooser dateDebutDateChooser = new JDateChooser();
		
		dateDebutDateChooser.setBounds(115, 36, 136, 20);
		etatcaisse.getContentPane().add(dateDebutDateChooser);
		
		JDateChooser dateFinDateChooser = new JDateChooser();
		dateFinDateChooser.setBounds(115, 71, 136, 20);
		etatcaisse.getContentPane().add(dateFinDateChooser);
		
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
				String effet= "'"+dateformat.format(dateDebutDateChooser.getDate())+"'";
				String echeance= "'"+dateformat.format(dateFinDateChooser.getDate())+"'";
				//JOptionPane.showMessageDialog(null, effet);
				
				String requeteFiltrerCaisse1="SELECT apporteur_affaires.OPERATEUR,superviseur.NOMSUP,superviseur.PRENOMSUP,caisse.SOMMEFACTURE, caisse.SOMMEENCAISEE, caisse.COMMISSION "
						+ "FROM apporteur_affaires INNER JOIN caisse INNER JOIN superviseur INNER JOIN talon"
						+ " ON ((apporteur_affaires.NINEA=superviseur.NINEA) AND (superviseur.NINEA= caisse.NINEA) AND (apporteur_affaires.NINEA = caisse.NINEA) AND (talon.NINEA=apporteur_affaires.NINEA) AND talon.EFFET="+effet+ "AND talon.ECHANCE="+echeance+")";
				
				try {
					
					Statement st=MyConnection.getConnection().createStatement();
				
				 if(st.execute(requeteFiltrerCaisse1))
					 try {
							
							ResultSet rs= st.executeQuery(requeteFiltrerCaisse1);
							tableCaisse.setModel(DbUtils.resultSetToTableModel(rs));
							//JOptionPane.showMessageDialog(null, "filtrage reussie");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFiltrer.setBounds(301, 73, 89, 23);
		etatcaisse.getContentPane().add(btnFiltrer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setToolTipText("");
		comboBox.setBounds(173, 121, 144, 22);
		etatcaisse.getContentPane().add(comboBox);
		
		JLabel bureauLabel = new JLabel("Bureaux");
		bureauLabel.setBounds(486, 58, 66, 14);
		etatcaisse.getContentPane().add(bureauLabel);
		
		JComboBox comboBoxBureau = new JComboBox();
		comboBoxBureau.addFocusListener(new FocusAdapter() {
		      @Override
		      public void focusLost(FocusEvent e) {
		        String groupe= (String) comboBoxBureau.getSelectedItem();
		      String requeteBureau="SELECT apporteur_affaires.OPERATEUR,superviseur.NOMSUP,superviseur.PRENOMSUP,caisse.SOMMEFACTURE,caisse.SOMMEENCAISEE,caisse.COMMISSION FROM apporteur_affaires INNER JOIN caisse INNER JOIN compagnie INNER JOIN superviseur ON ((apporteur_affaires.NINEA=caisse.NINEA) AND (apporteur_affaires.NINEA=superviseur.NINEA) AND (superviseur.IDSUP=compagnie.IDSUP)) WHERE compagnie.NOM=?";
		      try {
		        PreparedStatement ps= MyConnection.getConnection().prepareStatement(requeteBureau);
		        ps.setString(1, groupe);
		        ResultSet rs= ps.executeQuery();
		        tableCaisse.setModel(DbUtils.resultSetToTableModel(rs));
		              DefaultTableModel model = new DefaultTableModel();
		    
		      } catch (SQLException e1) {
		        // TODO Auto-generated catch block
		        e1.printStackTrace();
		      }
		      
		      
		      }
		    });
		
		try {
			st = MyConnection.getConnection().createStatement();
			ResultSet rs= st.executeQuery("SELECT `NOM` FROM `compagnie`");
			 while (rs.next())
				comboBoxBureau.addItem(rs.getString(1));
			 comboBoxBureau.setSelectedItem(null);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBoxBureau.setBounds(562, 50, 154, 22);
		etatcaisse.getContentPane().add(comboBoxBureau);
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(815, 191, 100, 23);
		etatcaisse.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(815, 225, 100, 23);
		etatcaisse.getContentPane().add(btnSupprimer);
		
		tableCaisse = new JTable();
		 requeteCaisse="SELECT apporteur_affaires.OPERATEUR,superviseur.NOMSUP,superviseur.PRENOMSUP,`SOMMEFACTURE`, `SOMMEENCAISEE`, `COMMISSION`  "
				+ "FROM apporteur_affaires INNER JOIN caisse INNER JOIN superviseur "
				+ "ON ((apporteur_affaires.NINEA=superviseur.NINEA) AND (superviseur.NINEA= caisse.NINEA) AND (apporteur_affaires.NINEA = caisse.NINEA))";
		 try {
		      PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteCaisse);
		      ResultSet rs= ps.executeQuery();
		      tableCaisse.setModel(DbUtils.resultSetToTableModel(rs));
		      DefaultTableModel model = new DefaultTableModel();
		          
		          
		    } catch (SQLException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		
		JScrollPane scrollPane = new JScrollPane(tableCaisse);
		scrollPane.setColumnHeaderView(tableCaisse.getTableHeader());
		scrollPane.setBounds(10, 211, 795, 200);
		etatcaisse.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Periode pr\u00E9difinie");
		lblNewLabel.setBounds(21, 125, 108, 14);
		etatcaisse.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Caisse.class.getResource("/images/fond.jpg")));
		lblNewLabel_1.setBounds(-147, 0, 1088, 577);
		etatcaisse.getContentPane().add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		etatcaisse.setJMenuBar(menuBar);
		
		JButton btnFermer = new JButton("Retour");
		btnFermer.setIcon(new ImageIcon(Caisse.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btnFermer);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(Caisse.class.getResource("/images/print-icon.png")));
		menuBar.add(btnImprimer);
		btnImprimer.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		         MessageFormat header= new MessageFormat("Historique: ");
		         MessageFormat footer = new MessageFormat("Page{0,number,interger} ");
		         try {
		          tableCaisse.print(JTable.PrintMode.NORMAL,header,footer);
		        } catch (PrinterException e1) {
		          // TODO Auto-generated catch block
		          e1.printStackTrace();
		          JOptionPane.showMessageDialog(null, "Erreur d'impression");
		        }
		      }
		    });
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etatcaisse.dispose();
				Page_Accueil window = new Page_Accueil();
				window.accueil.setVisible(true);
			}
		});
		
	
		

}
}