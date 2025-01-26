import java.util.ArrayList;

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


}
