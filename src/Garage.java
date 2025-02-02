import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Garage {

    public static Runnable start(ArrayList<Vehicle> vehicles, Protocol_Garage protocol) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (Vehicle vehicle : vehicles) {
                    try {
                        Thread.sleep(vehicle.getFixTime()* 1000L);
                        protocol.fixed();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        return runnable;
    }

    public static Runnable start(HashMap<Integer, PriorityQueue<Vehicle>> vehicles, Protocol_Garage protocol) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (PriorityQueue<Vehicle> priorityQueue  : vehicles.values()) {
                    try {
                        while (!priorityQueue.isEmpty()){
                        Thread.sleep(priorityQueue.peek().getFixTime()* 1000L);
                        priorityQueue.poll();
                        protocol.fixed();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        return runnable;
    }



}
