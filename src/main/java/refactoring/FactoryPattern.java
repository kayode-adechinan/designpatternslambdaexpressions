package refactoring;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Car {

    void start();

}

class Mercedes implements Car {

    @Override
    public void start() {
        System.out.println("Inside Mercedes::start method");
    }

}

class Ferrari implements Car {

    @Override
    public void start() {
        System.out.println("Inside Ferrari::start method");
    }

}

enum CarType {
    MERCEDES, FERRARI;
}

class CarFactory {

    public Car getCar(CarType carType) {

        switch(carType) {

            case MERCEDES: return new Mercedes();

            case FERRARI:  return new Ferrari();

            default: return null;

        }
    }
}

class CarLambdaFactory {

    final static Map<CarType, Supplier<Car>> carMap = new HashMap<>();

    // Store references of different Cars
    static {
        carMap.put(CarType.MERCEDES, Mercedes::new);
        carMap.put(CarType.FERRARI, Ferrari::new);
    }

    public Car getCar(CarType carType) {

        // Fetch care from the map based on car type
        Supplier<Car> car = carMap.get(carType);

        if (car != null) {
            return car.get();
        }

        throw new IllegalArgumentException("This car is not available");
    }
}

public class FactoryPattern {

    public static void main(String [] args) {




        CarFactory carFactory = new CarFactory();

        // Get an object of type Mercedes
        Car car1 = carFactory.getCar(CarType.MERCEDES);

        // Call start method of Mercedes
        car1.start();

        // Get an object of type Ferrari
        Car car2 = carFactory.getCar(CarType.FERRARI);

        // Call start method of Ferrari
        car2.start();

    }
}
