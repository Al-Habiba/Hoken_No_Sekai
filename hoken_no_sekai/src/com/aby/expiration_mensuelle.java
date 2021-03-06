package com.aby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class expiration_mensuelle {

	JFrame frmExpirationMensuelle;
	private JTable table;
	PreparedStatement ps;

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
					expiration_mensuelle window = new expiration_mensuelle();
					window.frmExpirationMensuelle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public expiration_mensuelle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpirationMensuelle = new JFrame();
		frmExpirationMensuelle.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmExpirationMensuelle.setBackground(Color.WHITE);
		frmExpirationMensuelle.setIconImage(Toolkit.getDefaultToolkit().getImage(expiration_mensuelle.class.getResource("/images/car.png")));
		frmExpirationMensuelle.setTitle("Expiration Mensuelle");
		frmExpirationMensuelle.setBounds(100, 100, 955, 550);
		frmExpirationMensuelle.getContentPane().setLayout(null);
		frmExpirationMensuelle.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				frmExpirationMensuelle.dispose();
			}
		});
			
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBounds(255, 110, 89, 23);
		frmExpirationMensuelle.getContentPane().add(btnFiltrer);
		
		JMonthChooser MoisChoisiBox = new JMonthChooser();
		MoisChoisiBox.setBounds(105, 105, 113, 28);
		frmExpirationMensuelle.getContentPane().add(MoisChoisiBox);
		
		table = new JTable();
		String requeteExpirationMensuelle="SELECT client.ASSURE,client.TEL,talon.EFFET,talon.ECHANCE,talon.POLICE,talon.IMMAT "
				+ "FROM talon INNER JOIN client INNER JOIN vehicule"
				+ " ON ((talon.NINEA=client.NINEA) AND (vehicule.IMMAT= talon.IMMAT) AND (client.ASSURE = talon.ASSURE))";
		try {
			PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteExpirationMensuelle);
			ResultSet rs= ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		scrollPane.setBounds(6, 189, 739, 200);
		frmExpirationMensuelle.getContentPane().add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(134, 67, 84, 26);
		frmExpirationMensuelle.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(expiration_mensuelle.class.getResource("/images/fond.jpg")));
		lblNewLabel.setBounds(-139, 0, 1078, 511);
		//frmExpirationMensuelle.getContentPane().add(lblNewLabel);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmExpirationMensuelle.setJMenuBar(menuBar);
		
		JButton btnFermer = new JButton("Retour");
		btnFermer.setIcon(new ImageIcon(expiration_mensuelle.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btnFermer);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(expiration_mensuelle.class.getResource("/images/print-icon.png")));
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
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				frmExpirationMensuelle.dispose();
			}
		});
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String choix= (String) comboBox.getSelectedItem();
				String requeteFiltrer="SELECT talon.IMMAT, talon.POLICE, talon.EFFET, talon.HEURE, talon.ECHANCE, talon.ASSURE, client.TEL, client.CONTACT "
						+ "FROM talon INNER JOIN client INNER JOIN vehicule "
						+ "ON ((talon.NINEA = client.NINEA)AND(vehicule.IMMAT =talon.IMMAT) AND (client.ASSURE=talon.ASSURE)) WHERE talon.ECHANCE LIKE '%-"+choix+"-%'";
				Statement st;
				try {
					//ps=MyConnection.getConnection().prepareStatement(requeteFiltrer);
					st=MyConnection.getConnection().createStatement();
					
					if(st.execute(requeteFiltrer))
					JOptionPane.showMessageDialog(null, "");
					try {
						PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteFiltrer);
						ResultSet rs= ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
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
	}
}
