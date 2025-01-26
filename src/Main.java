import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Protocol_Garage protocolGarage = new Protocol_Garage() {
            @Override
            public void fixed() {
                System.out.println("The vehicle have been fixed");
            }
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for Motorcycle, 2 for Car or 3 for Truck. Enter -1 if you finished");
        int input = scanner.nextInt();
        while (input != -1)
        {
            System.out.println("Enter the name of the vehicle");
            String name = scanner.next();
            switch (input)
            {
                case 1: {
                    Vehicle vehicle = new Motorcycle(name);
                    DB.addVehicle(vehicle);
                    break;
                }
                case 2: {
                    Vehicle vehicle = new Car(name);
                    DB.addVehicle(vehicle);
                    break;
                }
                case 3:{
                    Vehicle vehicle = new Truck(name);
                    DB.addVehicle(vehicle);
                    break;
                }
                default:
                    System.out.println("Invalid input. Please enter 1, 2, 3, or -1.");
            }
            System.out.println("Enter 1 for Motorcycle, 2 for Car or 3 for Truck. Enter -1 if you finished");
            input = scanner.nextInt();
        }
        Thread thread = new Thread(Garage.start(DB.getVehicles(), protocolGarage));
        thread.start();
    }
}