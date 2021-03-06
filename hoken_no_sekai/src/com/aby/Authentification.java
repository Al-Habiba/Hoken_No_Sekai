package com.aby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Authentification {

	static JFrame frmHokenNoSekai;
	
	private JTextField name;
	private JPasswordField passwordField;
	static String nameV;
	static String passwordV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				}catch (Exception e) {}	
				
					Authentification window = new Authentification();
					window.frmHokenNoSekai.setVisible(true);
				

			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHokenNoSekai = new JFrame();
		frmHokenNoSekai.setBackground(Color.WHITE);
		frmHokenNoSekai.setForeground(Color.WHITE);
		frmHokenNoSekai.setIconImage(Toolkit.getDefaultToolkit().getImage(Authentification.class.getResource("/images/car.png")));
		frmHokenNoSekai.setFont(new Font("Bodoni MT", Font.PLAIN, 16));
		frmHokenNoSekai.setTitle("Hoken No Sekai");
		frmHokenNoSekai.setResizable(false);
		frmHokenNoSekai.setBounds(100, 100, 430, 318);
		frmHokenNoSekai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHokenNoSekai.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoken No Sekai");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 23));
		lblNewLabel.setBounds(98, 11, 201, 26);
		frmHokenNoSekai.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setIcon(new ImageIcon(Authentification.class.getResource("/images/Apps-preferences-desktop-user-icon.png")));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 126, 94, 26);
		frmHokenNoSekai.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setIcon(new ImageIcon(Authentification.class.getResource("/images/Apps-preferences-desktop-user-password-icon.png")));
		lblNewLabel_2.setBounds(33, 171, 109, 26);
		frmHokenNoSekai.getContentPane().add(lblNewLabel_2);
		
		JButton submit = new JButton("submit");
		
		submit.setIcon(new ImageIcon(Authentification.class.getResource("/images/ok-icon.png")));
		submit.setForeground(Color.LIGHT_GRAY);
		submit.setBackground(Color.WHITE);
		submit.setFont(new Font("Arial", Font.PLAIN, 15));
		submit.setBounds(98, 221, 109, 36);
		frmHokenNoSekai.getContentPane().add(submit);
		
		JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setIcon(new ImageIcon(Authentification.class.getResource("/images/log out.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(259, 221, 109, 36);
		frmHokenNoSekai.getContentPane().add(btnNewButton_1);
		
		name = new JTextField();
		name.setBounds(171, 125, 109, 29);
		frmHokenNoSekai.getContentPane().add(name);
		name.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(171, 170, 109, 29);
		frmHokenNoSekai.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Type utilisateur");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(34, 71, 119, 16);
		frmHokenNoSekai.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBoxUsers = new JComboBox();
		comboBoxUsers.setModel(new DefaultComboBoxModel(new String[] {"Op\u00E9rateur", "Administrateur", "Superviseur"}));
		comboBoxUsers.setSelectedItem(null);
		comboBoxUsers.setBounds(171, 66, 109, 26);
		frmHokenNoSekai.getContentPane().add(comboBoxUsers);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(Authentification.class.getResource("/images/BACKGROUND.png")));
		labelBackground.setBounds(0, 0, 443, 279);
		frmHokenNoSekai.getContentPane().add(labelBackground);
		
		name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String user= (String)comboBoxUsers.getSelectedItem();
				if (comboBoxUsers.getSelectedItem()==null)
					JOptionPane.showMessageDialog(null, "Choisissez le type d'utilisateur");
			}
		});
		
		
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 nameV= name.getText();
				 passwordV=passwordField.getText();
				try
				{
				String requeteOperteur="SELECT * FROM `apporteur_affaires` WHERE `LOGIN`=? AND `PASSWORD`=?";
				String requeteAdmin="SELECT * FROM `administrateur` WHERE `LOGIN`=? AND `PASSWORD`=?";
				String reqSuperviseur="SELECT * FROM `superviseur` WHERE `LOGIN`=? AND `PASSWORD`=?";
				String user= (String)comboBoxUsers.getSelectedItem();
				if(user.equals("Superviseur"))
				{
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(reqSuperviseur);
					ps.setString(1, nameV);
					ps.setString(2, passwordV);
					
					ResultSet rs= ps.executeQuery();
					if (rs.next())
					{
						frmHokenNoSekai.dispose();
						Page_Accueil window= new Page_Accueil();
						window.accueil.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(frmHokenNoSekai, "Il y a eu erreur lors de la connexion \n \n V?rifiez les identifiants ");
					}
				}
				else if (user.equals("Op?rateur"))
				{
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteOperteur);
					ps.setString(1, nameV);
					ps.setString(2, passwordV);
				
					String bureau="SELECT `NOM` FROM `compagnie` INNER JOIN apporteur_affaires INNER JOIN superviseur "
							+ "ON ((compagnie.IDSUP=superviseur.IDSUP) AND (superviseur.NINEA=apporteur_affaires.NINEA)) "
							+ "WHERE apporteur_affaires.LOGIN=? AND apporteur_affaires.PASSWORD=?";
					
					
					
					ResultSet rs= ps.executeQuery();
					if (rs.next())
					{	
						frmHokenNoSekai.dispose();
						Page_Accueil window= new Page_Accueil();
						window.accueil.setVisible(true);
						PreparedStatement ps1= MyConnection.getConnection().prepareStatement(bureau);
						ps1.setString(1, nameV);
						ps1.setString(2, passwordV);
						ps1.executeUpdate();
						Affaire_Nouvelle.comboBox_1.setSelectedItem(bureau);
					}
					
					else
					{
						JOptionPane.showMessageDialog(frmHokenNoSekai, "Il y a eu erreur lors de la connexion \n \n V?rifiez les identifiants ");
					}
				}
				else if(user.equals("Administrateur"))
				{
					PreparedStatement ps=MyConnection.getConnection().prepareStatement(requeteAdmin);
					ps.setString(1, nameV);
					ps.setString(2, passwordV);
					
					ResultSet rs= ps.executeQuery();
					if (rs.next())
					{
						frmHokenNoSekai.dispose();
						Page_Accueil window= new Page_Accueil();
						window.accueil.setVisible(true);
					}
					
					else
					{
						JOptionPane.showMessageDialog(frmHokenNoSekai, "Il y a eu erreur lors de la connexion \n \n V?rifiez les identifiants ");
					}
				}
				}
				catch(Exception e1){
				}
				
			
				
			}});
	}
}
