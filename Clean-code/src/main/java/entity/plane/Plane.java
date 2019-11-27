package entity.plane;

import java.util.Objects;

public abstract class Plane {

    String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" + "model='" + model + '\'' + ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance + ", maxLoadCapacity=" + maxLoadCapacity + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        return maxSpeed == ((Plane)object).maxSpeed &&
                maxFlightDistance == ((Plane)object).maxFlightDistance &&
                maxLoadCapacity == ((Plane)object).maxLoadCapacity &&
                Objects.equals(model, ((Plane)object).model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}