package com.aby;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MyConnection 
{
	static Connection conn;
	
	public static Connection getConnection()
	{
		// TODO Auto-generated method stub
		try {
			for (LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch (Exception e) {}	
		String baseDonnes= "bd_hoken";
		String user="Habiba";
		String mdp="Bouffe802";
		String url="jdbc:mysql://localhost:3306/"+baseDonnes;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url, user, mdp);
		 
		  
		 
		}
		catch( Exception e)
		{
			
		}
		return conn;
	}

}
