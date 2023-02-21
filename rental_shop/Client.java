package mindera.mindswap.porto.module1.intro.rental_shop;

public class Client {


    private Vehicle vehicle;
    private String name;

    public Client(String name) {
        this.name = name;
    }


    public void rentVehicle(RentalStore store, VehicleType type) {
        if (store == null) {
            System.out.println("You're not at a rental store!");
            return;
        }
        if (vehicle != null) {
            System.out.println("You already have a vehicle rented");
            return;
        }

        this.vehicle = store.rentVehicle(type);
    }


    public void returnVehicle(RentalStore store) {
        if (store == null) {
            System.out.println("You're not at a rental store!");
        }

        if (vehicle == null) {
            System.out.println("No vehicle rented");
            return;
        }
        store.returnVehicle(vehicle);

        this.vehicle = null;
    }

    public boolean drive(float distance, float time) {
        if (vehicle == null) {
            System.out.println("No vehicle rented");
            return false;
        }
        System.out.printf("%s is Driving...%n", name);
        return vehicle.drive(distance, time);
    }

    public void refuel() {
        if (vehicle == null) {
            System.out.println("No vehicle rented");
            return;
        }
        vehicle.refuel();
        System.out.printf("%s Refueled%n", name);
    }

    public void recharge() {
        if (vehicle != null && vehicle.getVehicleType() == VehicleType.HYBRID_CAR) {
            ((HybridCar) vehicle).recharge();
            return;
        }
        System.out.println("this vehicle doesn't have a recharge function");
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
