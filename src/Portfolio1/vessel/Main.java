package Portfolio1.vessel;

public class Main {
    public static void main(String[] args) {

            ContainerVessel b = new ContainerVessel(100, "First Container Vessel");
            System.out.println(b. loadingCargo(96, "TEU"));
            System.out.println(b.loadFraction());
            System.out.println(b. loadingCargo(1, "TEU"));
            System.out.println(b.loadFraction());
            System.out.println(b. loadingCargo(99, "TEU")); //shouldnt add load 
            System.out.println(b.loadFraction()); // counter stays the same

            Roro a = new Roro(100, "First roro");
            System.out.println();
            System.out.println("Roro");
            System.out.println(a.loadingCargo(3, "truck"));
            System.out.println(a.loadFraction());
            System.out.println(a.loadingCargo(1, "car"));
            System.out.println(a.loadFraction());
            System.out.println(a.loadingCargo(1, "car"));
            System.out.println(a.loadFraction());

            Tanker t = new Tanker(10, "First tanker");
            System.out.println();
            System.out.println("Tanker");
            System.out.println(t.loadingCargo(10000, "10"));
            System.out.println(t.loadingCargo(1, "1")); //false;
            System.out.println(t.loadingCargo(3, "2"));
            System.out.println(t.loadingCargo(5, "1"));
            System.out.println(t.loadingCargo(10, "3"));
            System.out.println(t.loadFraction("1"));
            t.printArr();


    }
}
