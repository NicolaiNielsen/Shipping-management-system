package Portfolio2.VesselModel;

public class ContainerVessel extends Vessel {

    public ContainerVessel(double capacity, String name) {
        super(capacity, name);
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    @Override
    public
    double loadingCargo(int num, String type) {
        double checkCurrentLoad = num + currentLoad; //check if new load is bigger than capacity
        if (checkCurrentLoad <= capacity) { // if true
            currentLoad = checkCurrentLoad; // update currentLoad 
            System.out.println("Succes");
        } else {
            System.out.println("Capacity too full");
        }
        return currentLoad;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" + " capacity:'" + getCapacity() + "'" +
            "}";
    }
}
