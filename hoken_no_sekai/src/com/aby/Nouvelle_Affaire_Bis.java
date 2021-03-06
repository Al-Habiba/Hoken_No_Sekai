package com.aby;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import sun.jvm.hotspot.tools.SysPropsDumper;

//import sun.jvm.hotspot.oops.java_lang_Class;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;



import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Nouvelle_Affaire_Bis {

	JFrame frame;
	static int ninea;
	static 	String categorieVehicule;
	private double PB = 0;
	static double PN = 0;
	private double RC = 0;
	private double RCM = 0;
	static double TTC = 0;
	static String sommeFacture;
	static String sommeEncaisse;
	static double commissions=0;
	private JPanel allButton ;
	private JTextField AssureField;
	private JTextField professionField;
	private JTextField adresseField;
	private JTextField vehiculeField;
	private JTextField genreField;
	private JTextField marqueField;
	private JTextField typeField;
	private JTextField immatField;
	private JTextField policeField;
	private JLabel l_Police;
	private JTextField attestationField;
	private JTextField operateurField;
	private JTextField avenantField;
	private JTextField forceFiscaleField;
	private JTextField bonusField;
	private JTextField contactField;
	private JTextField telephoneField;
	private JTextField coutPoliceField;
	private JTextField numAttestField;
	private JTextField responsabiliteCivilField;
	private JTextField persTransporteField;
	private JTextField primeNetteField;
	private JTextField taxeField;
	private JTextField fgaField;
	private JTextField primeTotalField;
	private JTextField sommeFactureField;
	private JTextField sommeEncaisseField;
	private JTextField brisglaceField;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;

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
					Nouvelle_Affaire_Bis window = new Nouvelle_Affaire_Bis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Nouvelle_Affaire_Bis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Nouvelle_Affaire_Bis.class.getResource("/images/car.png")));
		frame.setBackground(Color.WHITE);
		//frame.setBounds(new Rectangle(0, 0, 2147483645, 2147483500));
		frame.setSize(new Dimension(1294, 790));
		frame.setTitle("NOUVELLE AFFAIRE");
		frame.setResizable(false);

		
		frame.getContentPane().setLayout(null);
		//frame = new JPanel();
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Page_Accueil window= new Page_Accueil();
				window.accueil.setVisible(true);
				frame.dispose();
			}
		});
		
		
		Object lists[] = {"TALON JAUNE","TALON VERT"} ;
		JComboBox comboBox = new JComboBox(lists);
		comboBox.setSelectedIndex(-1);
		comboBox.setBackground(SystemColor.inactiveCaption);
		comboBox.setBounds(166, 14, 129, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel l_assure = new JLabel("Assure");
		l_assure.setBounds(25, 76, 45, 27);
		frame.getContentPane().add(l_assure);
		
		JLabel lblNewLabel_1 = new JLabel("Profession");
		lblNewLabel_1.setBounds(25, 106, 62, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel l_Adresse = new JLabel("Adresse");
		l_Adresse.setBounds(25, 136, 76, 27);
		frame.getContentPane().add(l_Adresse);
		
		AssureField = new JTextField();
		AssureField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (operateurField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ operateur est vide");
			}
		});
		AssureField.setBounds(152, 76, 182, 27);
		frame.getContentPane().add(AssureField);
		AssureField.setColumns(10);
		
		professionField = new JTextField();
		professionField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (AssureField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ assure est vide");
			}
		});
		professionField.setBounds(152, 106, 182, 27);
		frame.getContentPane().add(professionField);
		professionField.setColumns(10);
		
		adresseField = new JTextField();
		adresseField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {		
				if (professionField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ profession est vide");
			}
		});
		adresseField.setBounds(152, 136, 182, 27);
		frame.getContentPane().add(adresseField);
		adresseField.setColumns(10);
		
		JLabel type = new JLabel("TYPE DE PRODUCTION");
		type.setForeground(Color.RED);
		type.setBounds(25, 14, 142, 27);
		frame.getContentPane().add(type);
		
		JLabel l_Vehicule = new JLabel("Vehicule");
		l_Vehicule.setBounds(25, 166, 76, 27);
		frame.getContentPane().add(l_Vehicule);
		
		JLabel l_genre = new JLabel("Genre");
		l_genre.setBounds(25, 196, 45, 27);
		frame.getContentPane().add(l_genre);
		
		JLabel l_Marque = new JLabel("Marque");
		l_Marque.setBounds(25, 226, 78, 27);
		frame.getContentPane().add(l_Marque);
		
		JLabel l_Type = new JLabel("Type");
		l_Type.setBounds(25, 256, 45, 27);
		frame.getContentPane().add(l_Type);
		
		JLabel l_Immat = new JLabel("Immat");
		l_Immat.setVerticalAlignment(SwingConstants.BOTTOM);
		l_Immat.setBounds(25, 286, 45, 27);
		frame.getContentPane().add(l_Immat);
		
		l_Police = new JLabel("Police");
		l_Police.setBounds(25, 316, 45, 27);
		frame.getContentPane().add(l_Police);
		
		JLabel l_effet = new JLabel("Effet");
		l_effet.setBounds(25, 376, 45, 27);
		frame.getContentPane().add(l_effet);
		
		JLabel l_echeance = new JLabel("Ech\u00E9ance");
		l_echeance.setBounds(25, 406, 76, 27);
		frame.getContentPane().add(l_echeance);
		
		vehiculeField = new JTextField();
		vehiculeField.setBounds(152, 166, 182, 27);
		frame.getContentPane().add(vehiculeField);
		vehiculeField.setColumns(10);
		
		genreField = new JTextField();
		genreField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					if (professionField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ adresse est vide");
			}
		});
		genreField.setBounds(152, 196, 182, 27);
		frame.getContentPane().add(genreField);
		genreField.setColumns(10);
		
		marqueField = new JTextField();
		marqueField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (genreField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ genre est vide");
			}
		});
		marqueField.setBounds(152, 226, 182, 27);
		frame.getContentPane().add(marqueField);
		marqueField.setColumns(10);
		
		typeField = new JTextField();
		typeField.setBounds(152, 256, 182, 27);
		frame.getContentPane().add(typeField);
		typeField.setColumns(10);
		
		immatField = new JTextField();
		immatField.setBounds(152, 286, 182, 27);
		frame.getContentPane().add(immatField);
		immatField.setColumns(10);
		
		policeField = new JTextField();
		policeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
	
				if (immatField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ immat est vide");
			}
		});
		policeField.setBounds(152, 316, 182, 27);
		frame.getContentPane().add(policeField);
		policeField.setColumns(10);
		
		JLabel l_Attestation = new JLabel("Attestation");
		l_Attestation.setBounds(25, 346, 76, 27);
		frame.getContentPane().add(l_Attestation);
		
		attestationField = new JTextField();
		attestationField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (policeField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ police est vide");
			}
		});
		attestationField.setBounds(152, 346, 182, 27);
		frame.getContentPane().add(attestationField);
		attestationField.setColumns(10);
		
		JLabel l_Groupe = new JLabel("GROUPE");
		l_Groupe.setForeground(Color.RED);
		l_Groupe.setBounds(353, 11, 79, 27);
		frame.getContentPane().add(l_Groupe);
		
		
		JComboBox comboBox_1 = new JComboBox();
		//String nomCompagnie;
		Statement st;
		try {
			st = MyConnection.getConnection().createStatement();
			ResultSet rs= st.executeQuery("SELECT `NOM` FROM `compagnie`");
			 while (rs.next())
				comboBox_1.addItem(rs.getString(1));
			 comboBox_1.setSelectedItem(null);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBox_1.setForeground(SystemColor.desktop);
		comboBox_1.setBackground(SystemColor.inactiveCaption);
		comboBox_1.setBounds(444, 14, 98, 21);
		frame.getContentPane().add(comboBox_1);
		
		JCheckBox chb1 = new JCheckBox("Flotte");
		chb1.setBounds(370, 106, 93, 27);
		frame.getContentPane().add(chb1);
		
		JCheckBox chb2 = new JCheckBox("Partenaire");
		chb2.setBounds(370, 166, 93, 27);
		frame.getContentPane().add(chb2);
		
		JCheckBox chb3 = new JCheckBox("Semi Remorque");
		chb3.setBounds(370, 226, 129, 27);
		frame.getContentPane().add(chb3);
		
		JLabel l_operateur = new JLabel("Operateur");
		l_operateur.setForeground(Color.RED);
		l_operateur.setBounds(872, 14, 75, 27);
		frame.getContentPane().add(l_operateur);
		
		JLabel l_avenant = new JLabel("Avenant");
		l_avenant.setBounds(872, 76, 75, 27);
		frame.getContentPane().add(l_avenant);
		
		JLabel l_Energie = new JLabel("Energie");
		l_Energie.setBounds(872, 136, 75, 27);
		frame.getContentPane().add(l_Energie);
		
		
		JLabel l_ff = new JLabel("Force Fiscale");
		l_ff.setBounds(872, 106, 77, 27);
		frame.getContentPane().add(l_ff);
		
		JLabel l_cv = new JLabel("Cat\u00E9gorie Vehicule");
		l_cv.setBounds(872, 166, 121, 27);
		frame.getContentPane().add(l_cv);
		
		JLabel l_tf = new JLabel("Tranche Fiscale");
		l_tf.setBounds(872, 196, 100, 27);
		frame.getContentPane().add(l_tf);
		
		JLabel l_np = new JLabel("Nombre Places");
		l_np.setBounds(872, 226, 100, 27);
		frame.getContentPane().add(l_np);
		
		JLabel l_tonnage = new JLabel("Tonnage");
		l_tonnage.setBounds(872, 256, 70, 27);
		frame.getContentPane().add(l_tonnage);
		
		JLabel l_cp = new JLabel("Cout de Police");
		l_cp.setBounds(872, 286, 90, 27);
		frame.getContentPane().add(l_cp);
		
		JLabel l_bonus = new JLabel("Bonus");
		l_bonus.setBounds(872, 316, 45, 27);
		frame.getContentPane().add(l_bonus);
		
		JLabel l_contact = new JLabel("Contact");
		l_contact.setBounds(872, 346, 45, 27);
		frame.getContentPane().add(l_contact);
		
		JLabel l_tel = new JLabel("Telephone");
		l_tel.setBounds(872, 376, 78, 27);
		frame.getContentPane().add(l_tel);
		
		JLabel lblNewLabel_12 = new JLabel("Visite Technique");
		lblNewLabel_12.setBounds(872, 406, 100, 27);
		frame.getContentPane().add(lblNewLabel_12);
		
		JCheckBox chb_auto = new JCheckBox("Auto Ecole");
		chb_auto.setBounds(872, 436, 93, 27);
		frame.getContentPane().add(chb_auto);
		
		operateurField = new JTextField();
		operateurField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String operateur= operateurField.getText();
				String requeteOperateur="SELECT * FROM `apporteur_affaires` WHERE `OPERATEUR`=?";
				try {
					PreparedStatement ps= MyConnection.getConnection().prepareStatement(requeteOperateur);
					ps.setString(1, operateur);
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						String getNinea=rs.getString("ninea");
					    ninea= Integer.parseInt(getNinea);
						
					}
					else
						JOptionPane.showMessageDialog(null, "L'apporteur d'affaire n'existe pas.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
			
				
		operateurField.setBounds(990, 14, 163, 27);
		frame.getContentPane().add(operateurField);
		operateurField.setColumns(10);
		
		avenantField = new JTextField();
		avenantField.setBounds(990, 76, 121, 27);
		frame.getContentPane().add(avenantField);
		avenantField.setColumns(10);
		
		JComboBox comboBox_energie = new JComboBox();
		comboBox_energie.setModel(new DefaultComboBoxModel(new String[] {"Essence", "Gasoil", "Electricit\u00E9"}));
		comboBox_energie.setBackground(SystemColor.inactiveCaption);
		//comboBox_energie.setSelectedItem(null);
		comboBox_energie.setBounds(990, 136, 106, 27);
		frame.getContentPane().add(comboBox_energie);
		
		forceFiscaleField = new JTextField();
		forceFiscaleField.setBounds(990, 106, 121, 27);
		frame.getContentPane().add(forceFiscaleField);
		forceFiscaleField.setColumns(10);
		
		JComboBox comboBoxCV = new JComboBox();
		comboBoxCV.setModel(new DefaultComboBoxModel(new String[] {"cat\u00E9gorie 1", "cat\u00E9gorie 2", "cat\u00E9gorie 3", "cat\u00E9gorie 4"}));
		//comboBoxCV.setSelectedItem(null);
		comboBoxCV.setBackground(new Color(255, 228, 196));
		comboBoxCV.setForeground(new Color(255, 255, 255));
		comboBoxCV.setBounds(990, 166, 163, 27);
		frame.getContentPane().add(comboBoxCV);
		
		JComboBox comboBox_TF = new JComboBox();
		comboBox_TF.setModel(new DefaultComboBoxModel(new String[] {"-13", "+13"}));
		comboBox_TF.setBackground(SystemColor.inactiveCaption);
		//comboBox_TF.setSelectedItem(null);
		comboBox_TF.setBounds(990, 196, 96, 27);
		frame.getContentPane().add(comboBox_TF);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "+8"}));
		//comboBox_5.setSelectedItem(null);
		comboBox_5.setBackground(SystemColor.inactiveCaption);
		comboBox_5.setBounds(990, 226, 54, 27);
		frame.getContentPane().add(comboBox_5);
		
		JComboBox comboBox_tonnage = new JComboBox();
		comboBox_tonnage.setModel(new DefaultComboBoxModel(new String[] {"segment A", "segment B", "segment C ou M1", "segment D ou M2", "segment E ou H1", "segment F ou H2", "segment S", "segment M", "segment J"}));
		comboBox_tonnage.setBackground(SystemColor.inactiveCaption);
		//comboBox_tonnage.setSelectedItem(null);
		comboBox_tonnage.setBounds(990, 256, 163, 27);
		frame.getContentPane().add(comboBox_tonnage);
		
		bonusField = new JTextField();
		bonusField.setBounds(990, 316, 70, 27);
		frame.getContentPane().add(bonusField);
		bonusField.setColumns(10);
		
		contactField = new JTextField();
		contactField.setBounds(990, 346, 163, 27);
		frame.getContentPane().add(contactField);
		contactField.setColumns(20);
		
		telephoneField = new JTextField();
		telephoneField.setBounds(990, 376, 96, 27);
		frame.getContentPane().add(telephoneField);
		telephoneField.setColumns(10);
		
		
		
		coutPoliceField = new JTextField();
		coutPoliceField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (adresseField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ cout adresse est vide");
			}
		});
		coutPoliceField.setBounds(990, 286, 70, 27);
		frame.getContentPane().add(coutPoliceField);
		coutPoliceField.setColumns(10);
		
		JButton valider = new JButton("Valider");
		valider.setBounds(1191, 15, 85, 27);
		frame.getContentPane().add(valider);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00B0 attest CDEAO");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(25, 436, 98, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Responsabilite civil");
		lblNewLabel_3.setBounds(25, 466, 115, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pers. transport\u00E9");
		lblNewLabel_4.setBounds(25, 496, 115, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prime Nette");
		lblNewLabel_5.setBounds(25, 526, 115, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Taxe");
		lblNewLabel_6.setBounds(25, 556, 45, 27);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fga");
		lblNewLabel_7.setBounds(25, 586, 45, 27);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Prime Total");
		lblNewLabel_8.setBounds(25, 616, 98, 27);
		frame.getContentPane().add(lblNewLabel_8);
		
		numAttestField = new JTextField();
		numAttestField.setBounds(152, 436, 175, 27);
		frame.getContentPane().add(numAttestField);
		numAttestField.setColumns(10);
		
		responsabiliteCivilField = new JTextField();
		responsabiliteCivilField.setBounds(152, 466, 96, 27);
		frame.getContentPane().add(responsabiliteCivilField);
		responsabiliteCivilField.setColumns(10);
		
		persTransporteField = new JTextField();
		persTransporteField.setBounds(152, 496, 96, 27);
		frame.getContentPane().add(persTransporteField);
		persTransporteField.setColumns(10);
		
		primeNetteField = new JTextField();
		primeNetteField.setBounds(152, 526, 96, 27);
		frame.getContentPane().add(primeNetteField);
		primeNetteField.setColumns(10);
		
		taxeField = new JTextField();
		taxeField.setBounds(152, 556, 96, 27);
		frame.getContentPane().add(taxeField);
		taxeField.setColumns(10);
		
		fgaField = new JTextField();
		fgaField.setBounds(152, 586, 96, 27);
		frame.getContentPane().add(fgaField);
		fgaField.setColumns(10);
		
		primeTotalField = new JTextField();
		primeTotalField.setBounds(152, 616, 96, 27);
		frame.getContentPane().add(primeTotalField);
		primeTotalField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date Rappel");
		lblNewLabel_10.setBounds(305, 466, 79, 27);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Somme Factur\u00E9");
		lblNewLabel_11.setBounds(305, 496, 98, 27);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("Somme Encaiss\u00E9");
		lblNewLabel_13.setBounds(305, 526, 106, 27);
		frame.getContentPane().add(lblNewLabel_13);
		
		JButton calculer = new JButton("calculer");
		calculer.setBounds(280, 586, 121, 27);
		frame.getContentPane().add(calculer);
		
		sommeFactureField = new JTextField();
		sommeFactureField.setBounds(423, 496, 96, 27);
		frame.getContentPane().add(sommeFactureField);
		sommeFactureField.setColumns(10);
		
		sommeEncaisseField = new JTextField();
		sommeEncaisseField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String sommmeencaissee1= sommeEncaisseField.getText();
				int sommeencaisseint= Integer.parseInt(sommmeencaissee1);
				int sommefactureint=Integer.parseInt(sommeFacture);
				if (sommeencaisseint<sommefactureint)
					JOptionPane.showMessageDialog(null, "La somme encais?e est inf?rieure ? la some factur?e");
				sommeEncaisseField.setText(null);
			}
		});
		sommeEncaisseField.setBounds(423, 526, 96, 27);
		frame.getContentPane().add(sommeEncaisseField);
		sommeEncaisseField.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Brisglace");
		lblNewLabel_14.setBounds(570, 466, 70, 27);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Marque");
		lblNewLabel_15.setBounds(570, 496, 50, 27);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Type de vitre");
		lblNewLabel_16.setBounds(570, 526, 78, 27);
		frame.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Defense et recours");
		lblNewLabel_17.setBounds(570, 586, 110, 27);
		frame.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Avance et recours");
		lblNewLabel_18.setBounds(570, 616, 100, 27);
		frame.getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Indiv cond.");
		lblNewLabel_19.setBounds(570, 646, 90, 27);
		frame.getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Cdeao");
		lblNewLabel_20.setBounds(570, 556, 45, 27);
		frame.getContentPane().add(lblNewLabel_20);
		
		brisglaceField = new JTextField();
		brisglaceField.setBounds(680, 466, 96, 27);
		frame.getContentPane().add(brisglaceField);
		brisglaceField.setColumns(10);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBackground(SystemColor.inactiveCaption);
		comboBox_7.setBounds(680, 496, 121, 27);
		frame.getContentPane().add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBackground(SystemColor.inactiveCaption);
		comboBox_8.setBounds(680, 526, 119, 27);
		frame.getContentPane().add(comboBox_8);
		
		textField_28 = new JTextField();
		textField_28.setBounds(680, 556, 96, 27);
		frame.getContentPane().add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setBounds(680, 586, 96, 27);
		frame.getContentPane().add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(680, 616, 96, 27);
		frame.getContentPane().add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setBounds(680, 646, 96, 27);
		frame.getContentPane().add(textField_31);
		textField_31.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Valeur du vehicule");
		lblNewLabel_21.setBounds(872, 526, 110, 27);
		frame.getContentPane().add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Ann\u00E9e du vehichule");
		lblNewLabel_22.setBounds(872, 556, 110, 27);
		frame.getContentPane().add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Vol");
		lblNewLabel_23.setBounds(872, 586, 67, 27);
		frame.getContentPane().add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Incendie");
		lblNewLabel_24.setBounds(872, 616, 67, 27);
		frame.getContentPane().add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Tourisme");
		lblNewLabel_25.setBounds(872, 646, 60, 27);
		frame.getContentPane().add(lblNewLabel_25);
		
		textField_32 = new JTextField();
		textField_32.setBounds(1000, 526, 114, 27);
		frame.getContentPane().add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setBounds(1000, 556, 114, 27);
		frame.getContentPane().add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setBounds(1000, 586, 96, 27);
		frame.getContentPane().add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setBounds(1000, 616, 96, 27);
		frame.getContentPane().add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setBounds(1000, 646, 96, 27);
		frame.getContentPane().add(textField_36);
		textField_36.setColumns(10);
//		allButton = new JPanel();
		frame.getContentPane();
		
		JDateChooser effetDateChooser = new JDateChooser();
		effetDateChooser.setBounds(152, 376, 143, 27);
		frame.getContentPane().add(effetDateChooser);
		
		JDateChooser echeanceDateChooser = new JDateChooser();
		echeanceDateChooser.setBounds(152, 406, 145, 27);
		frame.getContentPane().add(echeanceDateChooser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel.setBounds(94, 81, 55, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_9.setBounds(94, 198, 55, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_26 = new JLabel("");
		lblNewLabel_26.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_26.setBounds(94, 141, 55, 16);
		frame.getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_27.setBounds(94, 231, 55, 16);
		frame.getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_28.setBounds(94, 297, 55, 16);
		frame.getContentPane().add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_29.setBounds(94, 321, 55, 16);
		frame.getContentPane().add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("");
		lblNewLabel_30.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_30.setBounds(94, 351, 55, 16);
		frame.getContentPane().add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_31.setBounds(94, 381, 55, 16);
		frame.getContentPane().add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_32.setBounds(94, 411, 55, 16);
		frame.getContentPane().add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_33.setBounds(938, 141, 55, 16);
		frame.getContentPane().add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_34.setBounds(949, 111, 55, 16);
		frame.getContentPane().add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("");
		lblNewLabel_35.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_35.setBounds(978, 171, 55, 16);
		frame.getContentPane().add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("");
		lblNewLabel_36.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_36.setBounds(967, 201, 55, 16);
		frame.getContentPane().add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_37.setBounds(967, 231, 55, 16);
		frame.getContentPane().add(lblNewLabel_37);
		
		JLabel lblNewLabel_38 = new JLabel("");
		lblNewLabel_38.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_38.setBounds(967, 261, 55, 16);
		frame.getContentPane().add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("");
		lblNewLabel_39.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_39.setBounds(974, 286, 55, 27);
		frame.getContentPane().add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("");
		lblNewLabel_40.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_40.setBounds(938, 316, 55, 27);
		frame.getContentPane().add(lblNewLabel_40);
		
		JLabel lblNewLabel_41 = new JLabel("");
		lblNewLabel_41.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_41.setBounds(938, 351, 55, 16);
		frame.getContentPane().add(lblNewLabel_41);
		
		JLabel lblNewLabel_42 = new JLabel("");
		lblNewLabel_42.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/icons8-ast\u00E9risque-15.png")));
		lblNewLabel_42.setBounds(938, 381, 55, 16);
		frame.getContentPane().add(lblNewLabel_42);
		
		JDateChooser visiteTechniqueDateChooser = new JDateChooser();
		visiteTechniqueDateChooser.setBounds(990, 406, 143, 27);
		frame.getContentPane().add(visiteTechniqueDateChooser);
		
		JDateChooser DateRapelDateChooser = new JDateChooser();
		DateRapelDateChooser.setBounds(423, 466, 129, 27);
		frame.getContentPane().add(DateRapelDateChooser);
		
		JLabel labelHeure = new JLabel("Heure");
		labelHeure.setBounds(326, 376, 45, 27);
		frame.getContentPane().add(labelHeure);

		JLabel labelMois = new JLabel("Nb.mois");
		labelMois.setBounds(326, 406, 55, 27);
		frame.getContentPane().add(labelMois);

		JTextField heure = new JTextField();
		Date dateActuel= new Date();
		//JDateChooser dateActuel= new JDateChooser();
		SimpleDateFormat formater = new SimpleDateFormat("hh:mm");
		heure.setText(formater.format(dateActuel));
		heure.setBounds(387, 376, 65, 27);
		frame.getContentPane().add(heure);
		heure.setColumns(10);

		JComboBox cbnbmois = new JComboBox();
		cbnbmois.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbnbmois.setBounds(387, 406, 55, 27);
		cbnbmois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selectMonthitem = cbnbmois.getSelectedItem();
				Integer selectedMonth =Integer.parseInt((String) selectMonthitem);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(effetDateChooser.getDate());
				calendar.add(Calendar.MONTH, selectedMonth);
				echeanceDateChooser.setDate(calendar.getTime());
				echeanceDateChooser.setCalendar(calendar);
				
				calendar.add(Calendar.MONTH,12);
				echeanceDateChooser.setMaxSelectableDate(calendar.getTime());
				if (Integer.parseInt((String)cbnbmois.getSelectedItem())<4)
			          coutPoliceField.setText("2000");
			        else if (Integer.parseInt((String)cbnbmois.getSelectedItem())<7)
			            coutPoliceField.setText("4000");
			        else if (Integer.parseInt((String)cbnbmois.getSelectedItem())<10)
			          coutPoliceField.setText("5000");
			        else if (Integer.parseInt((String)cbnbmois.getSelectedItem())<12)
			          coutPoliceField.setText("6000");
			       // if (Integer.parseInt((String)cbnbmois.getSelectedItem())>=10)
			        //  bonusInt = (int)2/100;
				
				
			}
		});
		frame.getContentPane().add(cbnbmois);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/fond.jpg")));
		backgroundLabel.setBounds(0, -29, 1358, 767);
		frame.getContentPane().add(backgroundLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton fermer = new JButton("Retour");
		fermer.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/Go-back-icon (1).png")));
		menuBar.add(fermer);
		
		JButton imprimer = new JButton("Imprimer");
		imprimer.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/print-icon.png")));
		menuBar.add(imprimer);
		
		JButton quittance = new JButton("Quittance");
		menuBar.add(quittance);
		
		JButton proposition = new JButton("Proposition");
		menuBar.add(proposition);
		
		JButton blm = new JButton("Lettre Mutation");
		menuBar.add(blm);
		
		JButton cdeao = new JButton("CDEAO");
		menuBar.add(cdeao);
		fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page_Accueil window = new Page_Accueil();
				window.accueil.setVisible(true);
				frame.dispose();
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected=comboBox.getSelectedItem();
				if (selected.equals("TALON JAUNE"))
				{
					//frame.getContentPane().remove(backgroundLabel);
					backgroundLabel.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/fond jaune.jpg")));
					//frame.getContentPane().setBackground(Color.yellow);
					comboBoxCV.setModel(new DefaultComboBoxModel(new String[] {"cat\u00E9gorie 1", "cat\u00E9gorie 2", "cat\u00E9gorie 3"}));
					
					
				}
				else if (selected.equals("TALON VERT"))
				{
					//frame.getContentPane().remove(backgroundLabel);
					backgroundLabel.setIcon(new ImageIcon(Nouvelle_Affaire_Bis.class.getResource("/images/fond vert.jpg")));
					//frame.getContentPane().setBackground(Color.green);
					comboBoxCV.setModel(new DefaultComboBoxModel(new String[] {"cat\u00E9gorie 4"}));
				}
			}
		});
		
		calculer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String categorie = (String) comboBoxCV.getSelectedItem();
				if (categorie.equals("cat\\u00E9gorie 4")) {
					PB = 61000;
				} else
					PB = 51452;

				RC = (PB * 80) / 100;

				int nbrMois = Integer.parseInt(cbnbmois.getSelectedItem() + "");
				RCM = ((RC * 8.75) / 100) * nbrMois;

				PN = RCM;
				int coutPolice = Integer.parseInt(policeField.getText());
				double tax = PN + ((coutPolice * 10) / 100);
				double fg = (RCM * 2.5) / 100;
				int frais = 1000;

				TTC = PN + frais + tax + fg;
			 commissions = (PN * 18) / 100;

			
				sommeFactureField.setText(TTC+"");
				fgaField.setText(fg + "");
				primeTotalField.setText(TTC + "");
				primeNetteField.setText(PN + "");
				taxeField.setText(tax + "");
				sommeFacture=""+TTC;
				responsabiliteCivilField.setText(""+RC);
				
			}
		});
		valider.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        String assureV= AssureField.getText();
	        String professionV= professionField.getText();
	        String adresseV= adresseField.getText();
	        String vehiculeV= vehiculeField.getText();
	        String genreV= genreField.getText();
	        String marqueV= marqueField.getText();
	        String immatV= (immatField.getText());
	        String telephoneV= telephoneField.getText();
	        String contactV= contactField.getText();
	        String attestationV=attestationField.getText();
	        String categorieVehicule=(String)comboBoxCV.getSelectedItem();
	        String energieV=(String) comboBox_energie.getSelectedItem();
	        String tonnageV=(String) comboBox_tonnage.getSelectedItem();
	        SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
	        String effet= dateformat.format(effetDateChooser.getDate());
	        String visiteTechnique= dateformat.format(visiteTechniqueDateChooser.getDate());
	        String dateRappel=dateformat.format(DateRapelDateChooser.getDate());
	        String echeanceV=dateformat.format(echeanceDateChooser.getDate());
	        String nombrePlaces=(String)comboBox_5.getSelectedItem();
	        String heureV= heure.getText();
	        String nbreMoisV= (String) cbnbmois.getSelectedItem();
	        String policeV=coutPoliceField.getText();
	        String nineaV=""+ninea;
	        sommeEncaisse=sommeEncaisseField.getText();
	       // int pkclient;
	      //  String fk_client = null;
	        ResultSet rs;
	        PreparedStatement psVehicule,psTalon,psClient,psCaisse;
	       int compteurVehicule=0,compteurTalon=0,compteurClient=0,compteurCaisse=0;
	      //  int nombrePlacesV=Integer.parseInt(nombrePlaces);
	        
	        
	        String requeteVehicule="INSERT INTO vehicule( ENERGIE, MARQUE, CATEGORIE, TONNAGE, NBRPLACES, GENRE, VISITETECH, IMMAT)"
	            + " VALUES (?,?,?,?,?,?,?,?)";
	        String requeteClient="INSERT INTO client( `NINEA`, `ASSURE`, `TEL`, `CONTACT`, `DATERAPPEL`, `ADRESSE`)"
	            + " VALUES (?,?,?,?,?,?)";
	        String requeteTalon="INSERT INTO `talon`(`IMMAT`, `NINEA`, `ATTESTATION`, `POLICE`, `EFFET`, `ECHANCE`, `HEURE`, `NBRMOIS`,`assure`) "
	        		+ "VALUES (?,?,?,?,?,?,?,?,?)";
	        String requeteCaisse="INSERT INTO CAISSE (`NUMCAISEE`, `NINEA`, `SOMME FACTURE`, `SOMME ENCAISEE`, `COMMISSION`)"
                    + "VALUES (?,?,?,?)";
	      //  String updateTalon="UPDATE talon SET idclient= (select IDCLIENT from client order by IDCLIENT desc limit 1) WHERE idclient=0";
          try {
          
         
          // ajout v?hicule
         psVehicule=MyConnection.getConnection().prepareStatement(requeteVehicule);
         psVehicule.setString(1,energieV );
         psVehicule.setString(2,marqueV );
         psVehicule.setString(3,categorieVehicule );
         psVehicule.setString(4,tonnageV );
         psVehicule.setString(5,nombrePlaces );
         psVehicule.setString(6,genreV );
         psVehicule.setString(7,visiteTechnique );
         psVehicule.setString(8,immatV );
        compteurVehicule= psVehicule.executeUpdate();
         //JOptionPane.showMessageDialog(null, " compteur = "+compteur);
   
         //ajout talon
         
         psTalon=MyConnection.getConnection().prepareStatement(requeteTalon);
         psTalon.setString(1, immatV); 
         psTalon.setString(2, nineaV);
         psTalon.setString(3, attestationV); 
         psTalon.setString(4, policeV);
         psTalon.setString(5, effet);
         psTalon.setString(6, echeanceV);
         psTalon.setString(7, heureV);
         psTalon.setString(8, nbreMoisV);
         psTalon.setString(9, assureV);
       compteurTalon=psTalon.executeUpdate();
         
         
       //Ajout Caisse
           psCaisse=MyConnection.getConnection().prepareStatement(requeteCaisse);
           psCaisse.setString(1, nineaV);
           psCaisse.setString(2, sommeFacture);
           psCaisse.setString(3, sommeEncaisse);
           psCaisse.setString(4, commissions+"");
           compteurCaisse= psCaisse.executeUpdate();
         
        
             
           //ajout client
           psClient=MyConnection.getConnection().prepareStatement(requeteClient);
           psClient.setString(1, nineaV);
           psClient.setString(2, assureV);
           psClient.setString(3, telephoneV);
           psClient.setString(4, contactV);
           psClient.setString(5, dateRappel);
           psClient.setString(6, adresseV);
          compteurClient= psClient.executeUpdate();
           
          // ps=MyConnection.getConnection().prepareStatement(updateTalon);
           if (compteurVehicule >0 && compteurTalon >0  && compteurCaisse > 0 && compteurClient >0)
           {
//        	   psVehicule.executeUpdate();
//        	   psTalon.executeUpdate();
//        	   psCaisse.executeUpdate();
//        	   psClient.executeUpdate();
        	   JOptionPane.showMessageDialog(null, "Ajout Reussie");
           }
           
         else 
           JOptionPane.showMessageDialog(null, "Verifiez vos entr?es");
           
             psCaisse.close();
             psClient.close();
             psVehicule.close();
             psTalon.close();
             
           } catch (SQLException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
           }
	            
	         AssureField.setText(null);  policeField.setText(null);
	         professionField.setText(null);attestationField.setText(null);
	         adresseField.setText(null);responsabiliteCivilField.setText(null);
	         genreField.setText(null);primeNetteField.setText(null);
	         marqueField.setText(null);primeTotalField.setText(null);
	         immatField.setText(null);taxeField.setText(null);
	         fgaField.setText(null);sommeFactureField.setText(null);
	         sommeEncaisseField.setText(null);coutPoliceField.setText(null);
	         contactField.setText(null);telephoneField.setText(null);
	         echeanceDateChooser.setDate(null);//echeanceDateChooser.setCalendar(null);
	         effetDateChooser.setDate(null);effetDateChooser.setCalendar(null);
	         DateRapelDateChooser.setDate(null);
	         visiteTechniqueDateChooser.setDate(null);
	         cbnbmois.setSelectedItem(null);
	          }
	        });
		
		immatField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				
				if (marqueField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
				
				String requeteImmat= "SELECT `IMMAT` FROM `vehicule` WHERE `IMMAT`=? ";
				try {
					PreparedStatement ps= MyConnection.getConnection().prepareStatement(requeteImmat);
					ps.setString(1, immatField.getText());
					ResultSet rs=ps.executeQuery();
					if (rs.next())
						JOptionPane.showMessageDialog(null, "Cet immat existe");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	        operateurField.addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            // TODO Auto-generated method stub
	            String operateur= operateurField.getText();
	            String requeteOperateur="SELECT * FROM apporteur_affaires WHERE NOM=?";
	            try {
	              PreparedStatement ps= MyConnection.getConnection().prepareStatement(requeteOperateur);
	              ps.setString(1, operateur);
	              ResultSet rs= ps.executeQuery();
	              if(rs.next())
	              {
	                String getNinea=rs.getString("ninea");
	                  ninea= Integer.parseInt(getNinea);
	                
	              }
	              else
	                JOptionPane.showMessageDialog(null, "L'apporteur d'affaire n'existe pas.");
	            } catch (SQLException e1) {
	              // TODO Auto-generated catch block
	              e1.printStackTrace();
	            }
	            
	          }
	        });
		operateurField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String operateur= operateurField.getText();
				String requeteOperateur="SELECT * FROM `apporteur_affaires` WHERE `NOM`=?";
				try {
					PreparedStatement ps= MyConnection.getConnection().prepareStatement(requeteOperateur);
					ps.setString(1, operateur);
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						String getNinea=rs.getString("ninea");
					    ninea= Integer.parseInt(getNinea);
						
					}
					else
						JOptionPane.showMessageDialog(null, "L'apporteur d'affaire n'existe pas.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
}
