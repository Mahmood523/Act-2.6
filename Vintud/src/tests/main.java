package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import projectManagement.AnnouncementManager;
import projectManagement.ConnectionManager;

public class main {

	public static void main(String[] args) throws SQLException   {

		AnnouncementManager A1 = new AnnouncementManager();
      //A1.addUser();
	//	A1.seConnecter();
    //  A1.addAnnonce();
    //  A1.ModifUser();	
	//  A1.afficherAnnonces();
	//  A1.DeleteAnnoce();
	//  A1.ModifAnnonce();
	    A1.afficherUsers();
	}

}
