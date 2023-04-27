package Portfolio2.VesselModel;

public class Port {
    
    String port;

    public Port(String s) {
        this.port = s;
    }

    public String getPort() {
        return this.port;
    }



    @Override
    public String toString() {
        return getPort();
    }

}
