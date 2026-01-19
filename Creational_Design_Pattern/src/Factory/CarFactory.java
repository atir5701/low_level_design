package Factory;

import Factory.Car;
import Factory.Vehicle;

public class CarFactory{
    public Vehicle createVehicle(String type) {
        if (type == "car") return new Car();
        else if (type == "bike") return new Bike();
        else {
            System.out.println("Give Valid Name");
            return null;
        }
    }
}

/*

Usage in the Main method
void main(){
    CarFactory a = new CarFactory();
    Vehicle t = a.createVehicle("car");
    t.run();
    t = a.createVehicle("bike");
}

*/