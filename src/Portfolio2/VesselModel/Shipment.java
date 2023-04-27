package Portfolio2.VesselModel;

public class Shipment {

    String customerName;
    int volume;
    int id;
    Voyage voyage;
    

    public Shipment(Voyage voyage, int volume, String customerName) {
        this.id = voyage.getId();
        this.volume = volume;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }


    @Override
    public String toString() {
        return "{" +
            " customerName='" + getCustomerName() + "'" +
            ", volume='" + getVolume() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }

    
}
