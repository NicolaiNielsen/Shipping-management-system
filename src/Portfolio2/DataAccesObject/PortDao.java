package Portfolio2.DataAccesObject;

import java.util.ArrayList;
import Portfolio2.VesselModel.Port;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PortDao {

    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private static final String SELECT_ALL_PORTS = "SELECT * FROM Port";
    private static final String SELECT_PORT_BY_NAME = "SELECT name FROM PORT WHERE name = ?";

    public PortDao() {
    }

    private Connection getConnection() { // Establish connection and return connection object
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Port> getAll() {
        ArrayList<Port> ports = new ArrayList<Port>();
        try {
            // STEP 1: Establish connection and save conn object
            connection = getConnection();
            // STEP 2: Create preparedstatement using connection object
            ptmt = connection.prepareStatement(SELECT_ALL_PORTS);
            // STEP 3: Execute query and save in resultset
            rs = ptmt.executeQuery();
            // Process results set
            while (rs.next()) {
                String portname = rs.getString("name");
                ports.add(new Port(portname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ports;
    }

    public Port selectPort(String id) {
        Port port = null;

        try {
            // STEP 1: Establish connection and save conn object
            connection = getConnection();
            // STEP 2 Create statement using conn object
            ptmt = connection.prepareStatement(SELECT_PORT_BY_NAME);
            // STEP 3: Use input as argument to execute query and save in resultset
            ptmt.setString(1, id); // parameterindex == first ? in query
            rs = ptmt.executeQuery();
            // Step 4: Process Resultset object
            while (rs.next()) {
                String name = rs.getString("name");
                port = new Port(name);
            }
        } catch (SQLException e) {
            System.out.println("Could not find port");
        }

        return port;
    }

    public static void main(String[] args) {
        PortDao test = new PortDao();
        test.selectPort("Bangkok").toString();
        System.out.println(test.selectPort("Bangkok").toString());
    }
}
