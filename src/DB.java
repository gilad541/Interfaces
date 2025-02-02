import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;

public class DB {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static HashMap<Integer, PriorityQueue<Vehicle>> vehcilesQueue = new HashMap<>();

    public static void innitMap()
    {
        vehcilesQueue.put(1, new PriorityQueue<>());
        vehcilesQueue.put(2, new PriorityQueue<>());
        vehcilesQueue.put(3, new PriorityQueue<>());
    }

    public static void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public static ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }
    public static void build(int type, String model){
        if(type == 1)
            vehcilesQueue.get(type).add(new Motorcycle(model));
        if(type == 2)
            vehcilesQueue.get(type).add(new Car(model));
        if(type == 3)
            vehcilesQueue.get(type).add(new Truck(model));
    }

    public static HashMap<Integer, PriorityQueue<Vehicle>> getVehcilesQueue() {
        return vehcilesQueue;
    }
}
