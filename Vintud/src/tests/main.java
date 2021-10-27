package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import projectManagement.AnnouncementManager;
import projectManagement.ConnectionManager;

public class main {

	public static void main(String[] args)   {

		AnnouncementManager A1 = new AnnouncementManager();
	//	AnnouncementManager.addUser();
		AnnouncementManager.seConnecter();

	}

}
