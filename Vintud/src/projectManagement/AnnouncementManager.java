package projectManagement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.User;

public class AnnouncementManager {

	static Scanner scanner = new Scanner(System.in);
	static Connection  con = ConnectionManager.getConnection();
    static ResultSet resultats = null;
    static String requete = "";
    ResultSetMetaData rsmd;
	
    private static void arret(String message) {
        System.err.println(message);
        System.exit(99);
     }
    
    private static void affiche(String message) {
        System.out.println(message);
     }
    
    public static void addUser() throws SQLException{
    	
    	Scanner Sc1 = new Scanner(System.in);
    	System.out.println("inserer votre id :");
    	int id =Sc1.nextInt();
    	
    	
    	Scanner Sc2 = new Scanner(System.in);
    	System.out.println("inserer votre Prenom :");
    	String prenom =Sc2.nextLine();
    	
    	Scanner Sc3 = new Scanner(System.in);
    	System.out.println("inserer votre Nom :");
    	String nom =Sc3.nextLine();
    	
    	Scanner Sc4 = new Scanner(System.in);
    	System.out.println("inserer votre Pseudo :");
    	String pseudo = Sc4.nextLine();
    	
    	Scanner Sc5 = new Scanner(System.in);
    	System.out.println("inserer votre mail :");
    	String mail=Sc5.nextLine();
    	
    	Scanner Sc6 = new Scanner(System.in);
    	System.out.println("inserer votre mot de passe :");
    	String password=Sc6.nextLine();
    	
    	Scanner Sc7 = new Scanner(System.in);
    	System.out.println("inserer votre numero de telephone :");
    	String numTel=Sc7.nextLine();
    	
    	Scanner Sc8 = new Scanner(System.in);
    	System.out.println("inserer votre adresse :");
    	String adresse=Sc8.nextLine();
    	
    	Scanner Sc9 = new Scanner(System.in);
    	System.out.println("inserer votre le numero de votre role :"+"\n"+"1- Client"+"\n");
    	int roleId=Sc9.nextInt();
    	
    	System.out.println(id+prenom+nom+pseudo+mail+password+numTel+adresse+roleId);
    	
    	requete= "INSERT INTO user VALUES ("+id+","+prenom+","+nom+","+pseudo+","+mail+","+password+","+numTel+","+adresse+","+roleId+ ");";
    	try {
    		Statement stmt = con.createStatement();
	        stmt.executeUpdate(requete) ;
	        
	         System.out.println("User ajouté avec succés");
	         resultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
		affiche("fin du programme");
	      System.exit(0);
    		   		  	
    }
    
    public static void seConnecter () {
    	
    	Scanner sc = new Scanner(System.in);
    	String pw =sc.nextLine();
    	requete = "SELECT * FROM user";
		try {
			
		Statement stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		boolean encore = resultats.next();
		boolean connecte = false;
		while (encore) 
		{
          if (pw .equals(resultats.getString("u_password"))) { 	   
		  System.out.println("Connexion avec succes");
          connecte = true;
          }else {
        	  encore=resultats.next();
          }
          if (connecte=false);
          throw new Exception("Mot de passe incorrete");
          }
		resultats.close();
		} catch (Exception E ){
			E.printStackTrace();
					
		}


    	
    	
    	
    }
    
    
    
    
    
}
