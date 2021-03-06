package com.aby;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
public class HorsPool {

	JFrame frmHorsPool;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;

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
					HorsPool window = new HorsPool();
					window.frmHorsPool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HorsPool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHorsPool = new JFrame();
		frmHorsPool.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmHorsPool.setIconImage(Toolkit.getDefaultToolkit().getImage(HorsPool.class.getResource("/images/car.png")));
		frmHorsPool.setTitle("Horspool");
		frmHorsPool.setBounds(100, 100, 962, 553);
		frmHorsPool.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GROUPE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 25, 82, 14);
		frmHorsPool.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(70, 21, 116, 22);
		frmHorsPool.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Attestation D\u00E9but:");
		lblNewLabel_1.setBounds(10, 77, 104, 14);
		frmHorsPool.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Attestation Fin:");
		lblNewLabel_2.setBounds(10, 113, 104, 14);
		frmHorsPool.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(111, 74, 86, 20);
		frmHorsPool.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 110, 86, 20);
		frmHorsPool.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnFiltrer = new JButton("Filtrer");
		btnFiltrer.setBounds(226, 73, 89, 23);
		frmHorsPool.getContentPane().add(btnFiltrer);
		
		JButton btnGatee = new JButton("GATEE");
		btnGatee.setBounds(226, 146, 89, 23);
		frmHorsPool.getContentPane().add(btnGatee);
		
		JLabel lblNewLabel_3 = new JLabel("Date de D\u00E9but:");
		lblNewLabel_3.setBounds(441, 29, 86, 14);
		frmHorsPool.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date de Fin:");
		lblNewLabel_4.setBounds(441, 63, 86, 14);
		frmHorsPool.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(516, 109, 159, 22);
		frmHorsPool.getContentPane().add(comboBox_1);
		
		JButton btnNewButton_4 = new JButton("Trier par P\u00E9riode");
		btnNewButton_4.setBounds(516, 146, 159, 23);
		frmHorsPool.getContentPane().add(btnNewButton_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(539, 25, 137, 28);
		frmHorsPool.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(539, 60, 136, 28);
		frmHorsPool.getContentPane().add(dateChooser_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
						"Attestation", "Police", "Avenant", "Assur?", "Immat", "Effet","Ech?ance", "PrimeNette","PrimeTotale","Commission","NAR","Groupe"
				}
				));
		
		JScrollPane scrollPane = new JScrollPane(table_2);
		scrollPane.setColumnHeaderView(table_2.getTableHeader());
		scrollPane.setBounds(10, 189, 900, 200);
		frmHorsPool.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(HorsPool.class.getResource("/images/fond.jpg")));
		lblNewLabel_5.setBounds(-104, 0, 1050, 514);
		frmHorsPool.getContentPane().add(lblNewLabel_5);
		
		JMenuBar menuBar = new JMenuBar();
		frmHorsPool.setJMenuBar(menuBar);
		
		JButton btnFermer = new JButton("Retour");
		btnFermer.setIcon(new ImageIcon(HorsPool.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(btnFermer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon(HorsPool.class.getResource("/images/Actions-edit-delete-icon.png")));
		menuBar.add(btnSupprimer);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setIcon(new ImageIcon(HorsPool.class.getResource("/images/print-icon.png")));
		menuBar.add(btnImprimer);
		btnImprimer.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		         MessageFormat header= new MessageFormat("Historique: ");
		         MessageFormat footer = new MessageFormat("Page{0,number,interger} ");
		         try {
		          table_2.print(JTable.PrintMode.NORMAL,header,footer);
		        } catch (PrinterException e1) {
		          // TODO Auto-generated catch block
		          e1.printStackTrace();
		          JOptionPane.showMessageDialog(null, "Erreur d'impression");
		        }
		      }
		    });
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand()=="Retour") {
					frmHorsPool.dispose();
					Page_Accueil window = new Page_Accueil();
					window.accueil.setVisible(true);
				}
			}
		});
		
		
	
		

	}
}
