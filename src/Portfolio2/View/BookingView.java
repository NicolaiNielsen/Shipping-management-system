package Portfolio2.View;
import Portfolio2.DataAccesObject.PortDao;
import Portfolio2.DataAccesObject.VoyageDao;
import Portfolio2.VesselModel.Port;
import Portfolio2.VesselModel.Voyage;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;



public class BookingView extends GridPane { 

    //Interface components needed by controller
    private ListView<Voyage> foundVoyagesList;
    private Button searchButton;
    private Button bookShippingButton;
    private TextField txtCustomer;
    private TextField txtVolume;
    private TextField txtDepartureDate;
    private ComboBox<Port> departureBox;
    private ComboBox<Port> arrivalBox;

    //Public methods to allow acces to window components
    public ListView<Voyage> getList() {
        return foundVoyagesList;
    }

    public void setListView(ArrayList<Voyage> searchResultVoyage) {
        ObservableList<Voyage> content = FXCollections.observableArrayList(searchResultVoyage);
        foundVoyagesList.setItems(content);
    } 

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getBookShippingButton() {
        return bookShippingButton;
    }

    public TextField getCustomer() {
        return txtCustomer;
    }

    public TextField getVolume() {
        return txtVolume;
    }

    public TextField getDepdate() {
        return txtDepartureDate;
    }

    public String getDepartureBox() {
        return departureBox.getValue().toString();
    }

    public void setDepartureBox(ArrayList<Port> p) {
        ObservableList<Port> contents = FXCollections.observableArrayList(p);
        departureBox.setItems(contents);
    }

    public void setArrivalBox(ArrayList<Port> p) {
        ObservableList<Port> contents = FXCollections.observableArrayList(p);
        arrivalBox.setItems(contents);
    }

    public String getArrivalBox() {
        return arrivalBox.getValue().toString();
    }


    public BookingView(VoyageDao d, PortDao p) {

        GridPane grid = new GridPane();
        Label dep = new Label("From"); 
        Label arr = new Label("To");

        departureBox = new ComboBox<Port>();
        arrivalBox = new ComboBox<Port>();

        foundVoyagesList = new ListView<Voyage>();
        
        Label cus = new Label("Customer Name");
        Label volume = new Label("Shipping volume");
        Label depdate = new Label("Departure date");
        txtCustomer = new TextField();
        txtVolume = new TextField();
        txtDepartureDate = new TextField();
        searchButton = new Button("Seach");
        bookShippingButton = new Button("Book");

        grid.add(dep, 0, 0, 1, 1);
        grid.add(arr, 0, 1, 1, 1);
        grid.add(departureBox, 1, 0, 1, 1);
        grid.add(arrivalBox, 1, 1, 1, 1);
        grid.add(cus, 0, 2, 2, 1);
        grid.add(volume, 0, 3, 1, 1);
        grid.add(depdate, 0, 4, 1, 1);
        grid.add(txtCustomer, 1, 2, 1, 1);
        grid.add(txtVolume, 1, 3, 1, 1);
        grid.add(txtDepartureDate, 1, 4, 1, 1);
        grid.add(foundVoyagesList, 2, 0, 1, 8);
        grid.add(searchButton, 0, 5, 2, 1);
        grid.add(bookShippingButton, 0, 6, 2, 1);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();

        grid.getColumnConstraints().add(c1);
        grid.getColumnConstraints().add(c2);
        grid.getColumnConstraints().add(c3);

        c1.setPrefWidth(100);
        c2.setPrefWidth(100);
        c3.setPrefWidth(950);

        getChildren().addAll(dep, arr, departureBox, arrivalBox, cus, volume, depdate, txtCustomer, txtVolume, txtDepartureDate, searchButton, bookShippingButton, foundVoyagesList);

    }
}
