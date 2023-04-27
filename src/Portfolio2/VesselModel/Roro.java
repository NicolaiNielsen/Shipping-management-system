package Portfolio2.VesselModel;

public class Roro extends Vessel {

    public Roro(int capacity, String name) {
        super(capacity, name); //call construct
    }

    public double checkType(int num, String type) {
        int shipmentLoad = 0;
        if (type.toLowerCase() == "car") { 
            shipmentLoad = 8*num; //number of cars * 30 lenght
        } if (type.toLowerCase() == "truck") {
            shipmentLoad = 30*num; //number of trucks * 30 lenght
        }

        return shipmentLoad;
    }

    @Override
    public
    double loadingCargo(int num, String type) { 
        double checkCurrentLoad = currentLoad + checkType(num, type); //check if new load is bigger than capacity
        if (checkCurrentLoad <= capacity) { // if true
            currentLoad = checkCurrentLoad; // update currentLoad 
                System.out.println("Succes");
        } else {
            System.out.println("Capacity too full");
        }
        return currentLoad;
    }
}
