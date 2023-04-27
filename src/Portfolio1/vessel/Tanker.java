package Portfolio1.vessel;
import java.util.Arrays;

public class Tanker extends Vessel{

    double compartment[] = new double[10]; //number of compartments

    //capacity er målt i cubic meter
    //name referer til hvilken compartment der fyldes. 
    public Tanker(int capacity, String name) {
        super(capacity, name);
    }

    @Override
    // num er liter, og der kan være 1000 liter pr. cubic meter
    public double loadingCargo(int num, String type) { //note the type is the compartment, num is the

            if (num < 0) {
                throw new IllegalArgumentException("Cannot be negative value"); // error handling if num is negative
            }

            try {
                //finder ud af antallet af liter en compartment kan holde
                //1 kubic meter kan rumme 1000 liter
                double litercapacity = capacity* 1000;        
                //if current compartment is empty and load/num is less than litercapacity  
                if (compartment[Integer.parseInt(type)-1] == 0 && num <= litercapacity) { //-1 since 0-indexed
                    currentLoad = num;
                    compartment[Integer.parseInt(type)-1] = currentLoad; //update
                    System.out.println("Success: You loaded " + currentLoad + " liters into compartment " + type);;
                } 
                else {
                    System.out.println("Compartment is at capacity or already in use, try another");
                }
            } catch (ArrayIndexOutOfBoundsException e) { //happens if type is < 0 or > 10
                throw new ArrayIndexOutOfBoundsException("Must be a number between 1 and 10");
            } catch (NumberFormatException e) { //happens if type consits of chars
                throw new NumberFormatException("Type must not consist of characters, must be a number between 1 and 10");
            }
            return compartment[Integer.parseInt(type)-1];

    }

    public void printArr() {
        System.out.println(Arrays.toString(compartment));
    }

    //Method overloading, da vi skal vide hvilke compartment der er tale om
    public double loadFraction(String type) {

        double fraction;

        try {
            fraction = compartment[Integer.parseInt(type)-1] / (capacity*1000);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Compartment must be between 1 and 10");
        }
        return fraction;
    } 
}

    

