package mindera.mindswap.porto.module1.intro.rental_shop;

public final class HybridCar extends Car {
    private final static int speedForBattery = 25;
    float batteryConsumption;
    float batteryPower;

    public HybridCar(String model, float gasConsumption, float batteryConsumption) {
        super(model, gasConsumption, VehicleType.HYBRID_CAR);
        batteryPower = 40;
        this.batteryConsumption = batteryConsumption;
    }

    @Override
    public boolean drive(float distance, float time) {
        float currentSpeed = distance / time;
        if (currentSpeed < speedForBattery && hasEnoughBattery(distance)) {
            spendBattery(distance);
            return true;
        }

        return super.drive(distance, time);

    }

    private void spendBattery(float distance) {
        float spentBattery = distance / batteryConsumption;
        batteryPower -= spentBattery;
        System.out.println("*silence* I just spent " + spentBattery + "kW.");
    }

    private boolean hasEnoughBattery(float distance) {
        return (batteryPower - distance / batteryConsumption) >= 0;
    }

    public void recharge() {
        batteryPower = 40;
        System.out.println("*silence* I just recharged.");
    }
}