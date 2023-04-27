package Portfolio2.DataAccesObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Portfolio2.VesselModel.ContainerVessel;
import Portfolio2.VesselModel.Port;
import Portfolio2.VesselModel.Voyage;

public class VoyageDao {

    Connection conn = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    // STEP 1: define queries

    private static final String SELECT_ALL_VOYAGES = "SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel, voyage.depport, voyage.arrport, vessel.capacity, COALESCE(SUM(shipment.volume),0) as current_volume "
            +
            "FROM voyage " +
            "INNER JOIN vessel ON voyage.vessel = vessel.name " +
            "LEFT JOIN shipment ON voyage.id = shipment.voyageid " +
            "GROUP BY voyage.id";
    private static final String SELECT_VOYAGE_BY_ID = "SELECT * FROM voyage " +
            "INNER JOIN vessel on voyage.vessel = vessel.name " +
            "Where ID = ?";
    private static final String SELECT_VOYAGE_BY_SEARCHPARAMETERS = "SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel, voyage.depport, voyage.arrport, vessel.capacity, COALESCE(SUM(shipment.volume),0) as current_volume "
            +
            "FROM voyage " +
            "INNER JOIN vessel ON voyage.vessel = vessel.name " +
            "LEFT JOIN shipment ON voyage.id = shipment.voyageid " +
            "WHERE depdate >= ? AND depport = ? AND arrport = ? " +
            "GROUP BY voyage.id " +
            "HAVING current_volume + ? <= capacity";

    public VoyageDao() {

    }

    private Connection getConnection() { // Establish connection and return connection object
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Voyage> getAll() {
        ArrayList<Voyage> voyages = new ArrayList<>();

        try {
            // STEP 1: ESTABLISH CONNECTION
            conn = getConnection();
            ptmt = conn.prepareStatement(SELECT_ALL_VOYAGES);
            rs = ptmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int arrdate = rs.getInt("arrdate");
                int depdate = rs.getInt("depdate");

                String vesselName = rs.getString("vessel");
                double capacity = rs.getInt("capacity");
                ContainerVessel vessel = new ContainerVessel(capacity, vesselName);

                String depport = rs.getString("depport");
                Port departureport = new Port(depport);
                String arrport = rs.getString("arrport");
                Port arrivalport = new Port(arrport);

                Voyage voyage = new Voyage(id, arrdate, depdate, vessel, departureport, arrivalport);
                voyages.add(voyage);
            }
        } catch (SQLException e) {
            System.out.println("Couldnt get all voyages");
            e.printStackTrace();
        }

        return voyages;

    }

    public ArrayList<Voyage> searchVoyages(int depdate, String depport, String arrport, int volume) {
        ArrayList<Voyage> voyagesSearch = new ArrayList<Voyage>();

        try {
            // STEP 1: ESTABLISH CONNECTION
            conn = getConnection();
            ptmt = conn.prepareStatement(SELECT_VOYAGE_BY_SEARCHPARAMETERS);
            ptmt.setInt(1, depdate);
            ptmt.setString(2, depport);
            ptmt.setString(3, arrport);
            ptmt.setInt(4, volume);
            rs = ptmt.executeQuery();

            while (rs.next()) {
                int id1 = rs.getInt("id");
                int arrdate1 = rs.getInt("arrdate");
                int depdate2 = rs.getInt("depdate");
                String vesselName1 = rs.getString("vessel");
                double capacity1 = rs.getInt("capacity");
                ContainerVessel vessel1 = new ContainerVessel(capacity1, vesselName1);

                String depportSearch = rs.getString("depport");
                Port departureport1 = new Port(depportSearch);
                String arrportSearch = rs.getString("arrport");
                Port arrivalport2 = new Port(arrportSearch);

                Voyage voyage = new Voyage(id1, arrdate1, depdate2, vessel1, departureport1, arrivalport2);
                voyagesSearch.add(voyage);
            }
        } catch (SQLException e) {
            System.out.println("Couldnt get anything based on those search parameters");
            e.printStackTrace();
        }

        return voyagesSearch;

    }

    public Voyage getVoyage(int id) {

        Voyage voyage = null;

        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(SELECT_VOYAGE_BY_ID);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();

            while (rs.next()) {
                int idc = rs.getInt("id");
                int arrdate = rs.getInt("arrdate");
                int depdate = rs.getInt("depdate");

                String vesselName = rs.getString("vessel");
                double capacity = rs.getInt("capacity");
                ContainerVessel vessel = new ContainerVessel(capacity, vesselName);

                String depport = rs.getString("depport");
                Port departureport = new Port(depport);
                String arrport = rs.getString("arrport");
                Port arrivalport = new Port(arrport);

                voyage = new Voyage(idc, arrdate, depdate, vessel, departureport, arrivalport);
            }
        } catch (SQLException e) {
            System.out.println("Couldnt find vessel");
            e.printStackTrace();
        }
        return voyage;
    }

    public static void main(String[] args) {
        VoyageDao voyageDao = new VoyageDao();
        voyageDao.getVoyage(1);
        System.out.println(voyageDao.getVoyage(1).toString());
        System.out.println();
        voyageDao.getAll();
        System.out.println(voyageDao.getAll().toString());
        voyageDao.searchVoyages(230425, "Laem Chabang", "Bangkok", 0);
        System.out.println();
        System.out.println(voyageDao.searchVoyages(230422, "Laem Chabang", "Bangkok", 0).toString());
    }

}
