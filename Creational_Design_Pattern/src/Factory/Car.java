package Factory;

public class Car implements Vehicle{
    @Override
    public void run() {
        System.out.println("Car is Running");
    }
}
