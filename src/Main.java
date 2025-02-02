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
        DB.innitMap();
        System.out.println("Enter 1 for Motorcycle, 2 for Car or 3 for Truck. Enter -1 if you finished");
        int input = scanner.nextInt();
        while (input != -1)
        {
            System.out.println("Enter the name of the vehicle");
            String name = scanner.next();
            switch (input)
            {
                case 1: {
                    DB.build(1, name);
                    break;
                }
                case 2: {
                    DB.build(2, name);
                    break;
                }
                case 3:{
                    DB.build(3, name);
                    break;
                }
                default:
                    System.out.println("Invalid input. Please enter 1, 2, 3, or -1.");
            }
            System.out.println("Enter 1 for Motorcycle, 2 for Car or 3 for Truck. Enter -1 if you finished");
            input = scanner.nextInt();
        }
        Thread thread = new Thread(Garage.start(DB.getVehcilesQueue(), protocolGarage));
        thread.start();
    }
}