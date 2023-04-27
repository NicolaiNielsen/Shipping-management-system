package Portfolio2.VesselModel;

public class Voyage {

    int id;
    int arrdate;
    int depdate;
    Vessel vessel;
    Port arrport;
    Port depport;


    public Voyage() {
    }

    public Voyage(int id, int arrdate, int depdate, Vessel vessel, Port arrport, Port depport) {
        this.id = id;
        this.arrdate = arrdate;
        this.depdate = depdate;
        this.vessel = vessel;
        this.arrport = arrport;
        this.depport = depport;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrdate() {
        return this.arrdate;
    }

    public void setArrdate(int arrdate) {
        this.arrdate = arrdate;
    }

    public int getDepdate() {
        return this.depdate;
    }

    public void setDepdate(int depdate) {
        this.depdate = depdate;
    }

    public Vessel getVessel() {
        return this.vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Port getArrport() {
        return this.arrport;
    }

    public void setArrport(Port arrport) {
        this.arrport = arrport;
    }

    public Port getDepport() {
        return this.depport;
    }

    public void setDepport(Port depport) {
        this.depport = depport;
    }

    public Voyage id(int id) {
        setId(id);
        return this;
    }

    public Voyage arrdate(int arrdate) {
        setArrdate(arrdate);
        return this;
    }

    public Voyage depdate(int depdate) {
        setDepdate(depdate);
        return this;
    }

    public Voyage vessel(Vessel vessel) {
        setVessel(vessel);
        return this;
    }

    public Voyage arrport(Port arrport) {
        setArrport(arrport);
        return this;
    }

    public Voyage depport(Port depport) {
        setDepport(depport);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", arrdate='" + getArrdate() + "'" +
            ", depdate='" + getDepdate() + "'" +
            ", vessel='" + getVessel() + "'" +
            ", arrport='" + getArrport() + "'" +
            ", depport='" + getDepport() + "'" +
            "}";
    }
}

