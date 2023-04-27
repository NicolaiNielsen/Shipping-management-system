package Portfolio2.DataAccesObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Class to seperate the business logic layer and persistent layer
//Business logic layer encodes the irl business rules of the app
//Business logic: ports, voyages, vessels travel on voyages between ports
//And carry shipments, policies include the 

//The persistence layer: seperates the BL from data access component; retrivuels, storage 


//JDBC allows java app to interact with db

public class ConnectionFactory { //beneficial to have one central place for configuring db
    String driverClassName = "org.sqlite.JDBC"; //used to check if driver is available 
    String url = "jdbc:sqlite:src/Portfolio2/Databasekode/Database.db";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
	}

    public Connection getConnection() { //Open connection
		try {
		Connection conn = null;
		conn = DriverManager.getConnection(url);
		return conn;
		} catch (SQLException e) {
			System.out.println("Cannot connect to database");
			return null;
		}
	}

	public static ConnectionFactory getInstance() { //Get instance of conn object to open conn and create statements
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

    
}
