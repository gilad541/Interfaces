public class Motorcycle extends Vehicle{

    public Motorcycle(String name) {
        super(name);
    }

    @Override
    public int getFixTime() {
        return 3;
    }

    @Override
    public void fixed() {
        System.out.println("Both wheels have been repaired");
    }
}
