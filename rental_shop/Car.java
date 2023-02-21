package mindera.mindswap.porto.module1.intro.rental_shop;

public abstract class Car extends Vehicle {
    public Car(String model, float gasConsumption, VehicleType vehicleType) {
        super(model, gasConsumption, vehicleType, 25);
        this.maxSpeed = 120;
    }
}