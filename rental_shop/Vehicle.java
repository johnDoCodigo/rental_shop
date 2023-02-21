package mindera.mindswap.porto.module1.intro.rental_shop;

public abstract class Vehicle {
    static int maxSpeed;
    private final int gasCapacity;
    String model;
    VehicleType vehicleType;
    float gasLevel;
    float gasConsumption;

    public Vehicle(String model, float gasConsumption, VehicleType vehicleType, int gasCapacity) {
        this.model = model;
        this.gasLevel = gasCapacity;
        this.gasConsumption = gasConsumption;
        this.vehicleType = vehicleType;
        this.gasCapacity = gasCapacity;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getModel() {
        return model;
    }

    public float getGasLevel() {
        return gasLevel;
    }

    public boolean drive(float distance, float time) {
        float currentSpeed = distance / time;
        if (maxSpeed < currentSpeed) {
            System.out.println("I can't go faster than " + maxSpeed + "!");
            return false;
        } else if (!hasEnoughGas(distance)) {
            System.out.println("I don't have enough gas for this trip! Please refuel.");
            return false;
        }
        spendGas(distance);
        return true;
    }

    protected boolean hasEnoughGas(float distance) {
        return (gasLevel - distance / gasConsumption) >= 0;
    }

    protected void spendGas(float distance) {
        float spentGas = distance / gasConsumption;
        gasLevel -= spentGas;
        System.out.println("*vrum vrum* I just spent " + spentGas + "l.");
    }

    protected void addFuel(int addedGas) {
        gasLevel += addedGas;
    }

    public float refuel() {
        float refuelled = gasCapacity - gasLevel;
        gasLevel = gasCapacity;
        return refuelled;
    }


}
