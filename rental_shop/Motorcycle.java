package mindera.mindswap.porto.module1.intro.rental_shop;

public final class Motorcycle extends Vehicle {
    private final static int maxDistance = 80;
    private final static int gasCapacity = 10;

    public Motorcycle(String model, float gasConsumption) {
        super(model, gasConsumption, VehicleType.MOTORCYCLE, gasCapacity);
        maxSpeed = 100;
    }

    @Override
    public boolean drive(float distance, float time) {
        if (maxDistance < distance) {
            System.out.println("As a motorcycle, I can't drive for more than " + maxDistance + "km.");
            return false;
        }
        super.drive(distance, time);
        return true;
    }

}