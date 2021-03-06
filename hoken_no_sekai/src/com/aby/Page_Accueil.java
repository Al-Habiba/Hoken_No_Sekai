package com.aby;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page_Accueil {

	JFrame accueil;
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
					Page_Accueil window = new Page_Accueil();
					window.accueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Page_Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		accueil = new JFrame();

		accueil.setBackground(Color.WHITE);
		accueil.setSize(new Dimension(1298, 788));
		accueil.setFont(new Font("Arial Black", Font.PLAIN, 16));
		accueil.setIconImage(Toolkit.getDefaultToolkit().getImage(Page_Accueil.class.getResource("/images/car.png")));
		accueil.setTitle("Page d'Accueil");
		accueil.setResizable(false);
		//frmAssuranceAuto.setBounds(100, 100, 763, 627);
		accueil.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		accueil.getContentPane().setLayout(new BorderLayout(0, 0));
		
		accueil.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Authentification window= new Authentification();
				window.frmHokenNoSekai.setVisible(true);
				accueil.dispose();
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		accueil.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue dans l'application num\u00E9ro 1 d'offres d'assurances automobile ");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 27));
		lblNewLabel_1.setBounds(-25, 34, 1331, 49);
		panel.add(lblNewLabel_1);
		
		JButton logout = new JButton("LOG OUT");
		logout.setIcon(new ImageIcon(Page_Accueil.class.getResource("/Icons/User-Interface-Login-icon.png")));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand()=="LOG OUT") {
					int a= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment vous d?connecter","Select",JOptionPane.YES_NO_OPTION);
					if (a==0) {
					Authentification window = new Authentification();
					window.frmHokenNoSekai.setVisible(true);
					accueil.setVisible(false);
					}
				}
			}
		});
		logout.setBounds(1089, 602, 197, 49);
		panel.add(logout);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Page_Accueil.class.getResource("/images/fond.jpg")));
		lblNewLabel_2.setBounds(6, 6, 1280, 714);
		panel.add(lblNewLabel_2);
		accueil.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				final int MAX_X= 1583 ;
				final int MIN_X= 1500;
				
				Thread animation = new Thread(new Runnable () {
				public void run() {
					int x = 65;
					int y = 75;
					boolean checked= true;
					while(true) {
						if (checked) {
						lblNewLabel_1.setLocation(x,y);
						x+=40;
						}else {
							lblNewLabel_1.setLocation(x,y);
							x-=40;
						}
						if (x>MAX_X) {
							checked = false;
							x=65;
							
							
						}
						if(x<MIN_X) {
							checked = true;
						}
						try {
							Thread.sleep(200);
						}catch (Exception e) {
						}
					}
				}
				});
						animation.start();
						
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		accueil.setJMenuBar(menuBar);
		
		JMenu Assurance = new JMenu("ASSURANCE");
		menuBar.add(Assurance);
		
		JMenuItem affairenouvelle = new JMenuItem("Affaire Nouvelle");
		affairenouvelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affaire_Nouvelle window = new Affaire_Nouvelle();
				window.frame.setVisible(true);
				accueil.dispose();;
			}
		});
		Assurance.add(affairenouvelle);
		
		JMenuItem listedesassures = new JMenuItem("Liste des assur\u00E9s");
		listedesassures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssureListes window = new AssureListes();
				window.setVisible(true);
				accueil.dispose();;
			}
		});
		Assurance.add(listedesassures);
		
		JMenuItem historique = new JMenuItem("Historique");
		historique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historique window =new Historique();
				window.setVisible(true);
				accueil.dispose();;
			}
		});
		Assurance.add(historique);
		
		JMenuItem listepoliceattribuees = new JMenuItem("Liste des polices attribu\u00E9es");
		listepoliceattribuees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListesPolices as = new ListesPolices();
				as.setVisible(true);
				//accueil.hide();
				accueil.dispose();
			}
		});
		Assurance.add(listepoliceattribuees);
		
		JMenu Bordereaux = new JMenu("BORDEREAUX");
		menuBar.add(Bordereaux);
		
		JMenuItem horspool = new JMenuItem("HORSPOOL");
		Bordereaux.add(horspool);
		horspool.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			HorsPool frHorspool = new HorsPool();
			frHorspool.frmHorsPool.setVisible(true);
			accueil.dispose();
				
			}
		});
		JMenuItem tpv = new JMenuItem("TPV");
		Bordereaux.add(tpv);
		
		JMenu Expirations = new JMenu("EXPIRATIONS");
		menuBar.add(Expirations);
		
		JMenuItem expirationmensuelle = new JMenuItem("Expiration mensuelle");
		expirationmensuelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expiration_mensuelle frmExpirationMensuelle= new expiration_mensuelle();
				frmExpirationMensuelle.frmExpirationMensuelle.setVisible(true);
				accueil.dispose();
			}
		});
		Expirations.add(expirationmensuelle);
		
		JMenu Caisse = new JMenu("CAISSE");
		menuBar.add(Caisse);
		
		JMenuItem etatcaisse = new JMenuItem("Etat Caisse");
		etatcaisse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Caisse frCaisse= new Caisse();
				frCaisse.etatcaisse.setVisible(true);
				accueil.dispose();
			}
			
		});
		Caisse.add(etatcaisse);
	}
}
