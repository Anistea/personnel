package ConnexionJM;

import java.util.*;



import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.Passerelle;
import personnel.SauvegardeImpossible;


public class ConnexionJM {
	
	public static void main(String[] args) {
		// TODO code application logic here
		Connection cnx=connecterDB();
	}
	
	public static Connection connecterDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost:3306/personnel";
			String user="root";
			String password="";
			Connection cnx=DriverManager.getConnection(url,user,password);
			System.out.println("Connexion bien établie");
			return cnx;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
