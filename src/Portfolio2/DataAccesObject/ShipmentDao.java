package Portfolio2.DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Portfolio2.VesselModel.Shipment;


public class ShipmentDao {
    
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private static final String INSERT_SHIPMENT = "INSERT INTO SHIPMENT (voyageid, volume, customer) VALUES(?, ?, ?)";

    public ShipmentDao () {}

    private Connection getConnection() { // Establish connection and return connection object
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void insertShipment(Shipment shipment) {
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(INSERT_SHIPMENT);
            ptmt.setInt(1, shipment.getId());
            ptmt.setInt(2, shipment.getVolume());
            ptmt.setString(3, shipment.getCustomerName());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("couldnt insert");
            e.getStackTrace();
        }
    }




}
