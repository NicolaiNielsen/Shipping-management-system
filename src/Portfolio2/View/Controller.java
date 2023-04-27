package Portfolio2.View;


import Portfolio2.DataAccesObject.PortDao;
import Portfolio2.DataAccesObject.ShipmentDao;
import Portfolio2.DataAccesObject.VoyageDao;
import Portfolio2.VesselModel.Shipment;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.stage.Stage;

public class Controller extends Application {

    private BookingView view;
    private VoyageDao voyageModel;
    private PortDao portModel;
    private ShipmentDao shipmentModel;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {
        portModel = new PortDao();
        voyageModel = new VoyageDao();
        shipmentModel = new ShipmentDao();
        view = new BookingView(voyageModel, portModel);
        initalizePort();
        view.getSearchButton().setOnAction(e -> handleSearchButtonPress());
        view.getBookShippingButton().setOnAction((e -> handleBookButtonPress()));

        Scene scene = new Scene(view);
        view.setHgap(10);
        view.setVgap(10);
        view.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();

        view.getColumnConstraints().add(c1);
        view.getColumnConstraints().add(c2);
        view.getColumnConstraints().add(c3);

        c1.setPrefWidth(100);
        c2.setPrefWidth(100);
        c3.setPrefWidth(950);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shipping system");
        primaryStage.show();
    }
    
    private void handleSearchButtonPress() {
    //int depdate, fromport, toport, volume, 
    System.out.println(view.getDepdate().getText() + view.getDepartureBox().toString() + view.getArrivalBox() + view.getVolume().getText());
    int date = Integer.parseInt(view.getDepdate().getText());
    String fromPort = view.getDepartureBox();
    String toPort = view.getArrivalBox();
    int volumee = Integer.parseInt(view.getVolume().getText());
    System.out.println(date + fromPort + toPort + volumee);
    voyageModel.searchVoyages(date, fromPort, toPort, volumee);
    view.setListView(voyageModel.searchVoyages(date, fromPort, toPort, volumee));

    }

    private void handleBookButtonPress() {

        int id = view.getList().getSelectionModel().getSelectedIndex();
        if (id >= 0) {
            System.out.println("teest");
            System.out.println(id);
            System.out.println(view.getList().getItems().get(id));
            int volume = Integer.parseInt(view.getVolume().getText());
            String customer = view.getCustomer().getText();
            Shipment s = new Shipment(view.getList().getItems().get(id), volume, customer);
            shipmentModel.insertShipment(s);
            }
    }

    private void initalizePort() {
        view.setDepartureBox(portModel.getAll());
        view.setArrivalBox(portModel.getAll());
    }
}

