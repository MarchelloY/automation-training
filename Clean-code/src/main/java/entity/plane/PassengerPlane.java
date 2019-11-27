package entity.plane;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", passengersCapacity=" + passengersCapacity + '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PassengerPlane) || !super.equals(object)) return false;
        return Objects.equals(passengersCapacity, ((PassengerPlane) object).passengersCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}