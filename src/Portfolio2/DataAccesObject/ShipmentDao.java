package Portfolio2.DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Portfolio2.VesselModel.Shipment;
import Portfolio2.VesselModel.Voyage;


public class ShipmentDao {
    
    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private static final String INSERT_SHIPMENT = "INSERT INTO SHIPMENT (voyageid, volume, customer) VALUES (?, ?, ?)";

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
            System.out.println(shipment.getId());
            ptmt.setInt(2, shipment.getVolume());
            System.out.println(shipment.getVolume());
            ptmt.setString(3, shipment.getCustomerName());
            System.out.println(shipment.getCustomerName());
            ptmt.executeUpdate();
            System.out.println("inserted");
            ptmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("couldnt insert");
            e.getStackTrace();
        }
    }

    public void insert() throws SQLException {
            conn = getConnection();
            ptmt = conn.prepareStatement(INSERT_SHIPMENT);
            ptmt.setInt(1, 25);
            ptmt.setInt(2, 3000);
            ptmt.setString(3, "Hans");
            ptmt.executeUpdate();

    }

    public static void main(String[] args) throws SQLException {
        ShipmentDao shipmentDao = new ShipmentDao();
        shipmentDao.insert();
    }




}
