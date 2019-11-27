package entity.airoport;

import entity.plane.ExperimentalPlane;
import type.MilitaryType;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {

        return this.planes.stream().filter(plane -> plane instanceof PassengerPlane).map(plane -> (PassengerPlane) plane).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {

        return this.planes.stream().filter(plane -> plane instanceof MilitaryPlane).map(plane -> (MilitaryPlane) plane).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);

        for (PassengerPlane passengerPlane : getPassengerPlanes()) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {

        return getMilitaryPlanes().stream().filter(militaryPlane -> militaryPlane.getType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {

        return getMilitaryPlanes().stream().filter(militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes;

        List<? extends Plane> list = this.planes;
        experimentalPlanes = list.stream().filter(plane -> plane instanceof ExperimentalPlane).map(plane -> (ExperimentalPlane) plane).collect(Collectors.toList());

        return experimentalPlanes;
    }

    @Override
    public String toString() {
        return "Planes=" + planes.toString();
    }

    public Airport sortByMaxDistance() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }
}