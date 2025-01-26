import java.util.ArrayList;
import java.util.Vector;

public class DB {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public static ArrayList<Vehicle> getVehicles()
    {
        return this.vehicles;
    }
}
