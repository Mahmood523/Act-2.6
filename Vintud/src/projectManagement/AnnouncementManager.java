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
    	
    	
    	
    	requete= "INSERT INTO vintud.user VALUES ("+id+",'"+prenom+"','"+nom+"','"+pseudo+"','"+mail+"','"+password+"','"+numTel+"','"+adresse+"',"+roleId+" );";
    	try {
    		Statement stmt = con.createStatement();
	        stmt.executeUpdate(requete) ;
	        
	         System.out.println("User ajouté avec succés");
	         
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
		
	      System.exit(0);
    		   		  	
    }
    
    public static void seConnecter () {
    	
    //	Scanner sc = new Scanner(System.in);
   // 	System.out.println("Saisir Mot de passe :");
    	String pw ="unmotdepassedepirate";
    	String Mail="johnyPirate@Cara.com";
    	requete = "SELECT * FROM vintud.user WHERE u_password = "+ pw +" AND mail = "+Mail+ "; ";
		try {
			
		Statement stmt = con.createStatement();
		resultats = stmt.executeQuery(requete);
		boolean encore = resultats.next();
		
		while (encore) 
		{
          if (pw .equals(resultats.getString("u_password"))) { 	   
		  
          System.out.println("Connexion avec succes");
          
          }else {
        	  encore=resultats.next();
          }
          
          }
		resultats.close();
		} catch (SQLException e ){
			arret("Mot de passe incorrecte");
					
		}
    }
    
    public void ModifUser() throws SQLException {
		String requete = "UPDATE vintud.user SET firstname='Mahmooood' where id =4;";
		try {
		Statement tmt = con.createStatement();
		int resultat = tmt.executeUpdate(requete);

		if (resultat>0)
		{
		System.out.println("updated user into the table...");
		}
		con.close();
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
		}

    public void afficherUsers() throws SQLException {

    	String requete = "select * from vintud.user";

    	try {

    	Statement stmt = con.createStatement();
    	resultats = stmt.executeQuery(requete);
    	System.out.println("Affichage des users :"+ " \n");

    	while(resultats.next())
    	{
    	System.out.println("User n°"+resultats.getInt("id")+" :");
    	System.out.println( resultats.getString("firstname") + " \n" + resultats.getString("name") + "\n" + resultats.getString("pseudo") + "\n" + resultats.getString("mail")+ " \n" + resultats.getString("phone")+ " \n" + resultats.getString("address")+" \n");
    	
    	}
    	resultats.close();


    	} catch (SQLException e) {

    		arret("Anomalie lors de l'execution de la requête");
    	}
    	}
    
    public void afficherAnnonces() throws SQLException {

    	String requete = "select * from vintud.announcement";

    	try {

    	Statement tmt = con.createStatement();
    	resultats = tmt.executeQuery(requete);
    	System.out.println("Affichage des Annonces"+ " \n");

    	while(resultats.next())
    	{
    	System.out.println(resultats.getString("title")+ " \n"+ resultats.getString("description") + " \n" + resultats.getInt("category_id") + "\n" + resultats.getBoolean("is_available") + "\n" + resultats.getInt("view_number" )+ " \n");



    	}
    	resultats.close();


    	} catch (SQLException e) {

    		arret("Anomalie lors de l'execution de la requête");
    	}
    	}
    
    
    public void addAnnonce() throws SQLException{
    	requete= "INSERT INTO vintud.announcement VALUES (3,'ceinture gucci neuve','Je vends ma ceinture',1,23.46,NULL,'2021-01-25 8:32:32',true,23,'Mornaguia 1110',5 );";
    	try {
    		Statement stmt = con.createStatement();
	        stmt.executeUpdate(requete) ;
	        
	         System.out.println("Annonce ajouté avec succés");
	         
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
		
	      System.exit(0);
    	
    	
    	
    }
    
    public void DeleteAnnoce() throws SQLException {

    	String requete = "DELETE FROM vintud.announcement WHERE title='t-shirt lacuste bon état'";
    	try {
    	Statement stmt = con.createStatement();
    	stmt.executeUpdate(requete);

    	
    	
    	System.out.println(" Annonce supprime ");
    	
    	con.close();
    	}
    	catch (SQLException e)
    	{
    		arret("Anomalie lors de l'execution de la requête");
    	} }
    	
    public void ModifAnnonce() throws SQLException {
    	requete = "UPDATE vintud.announcement SET title='Jordan etat neuf' where id =2;";
    	try {
    	Statement stmt = con.createStatement();
    	stmt.executeUpdate(requete);
    	
    	System.out.println("updated Annonce into the table...");
    	
    	con.close();
    	}
    	catch (SQLException e)
    	{
    		arret("Anomalie lors de l'execution de la requête");
    	}
    	}
    
    
    
    
    
    
    
}
