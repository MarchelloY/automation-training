import entity.plane.ExperimentalPlane;
import entity.airoport.Airport;
import type.ClassificationLevelType;
import type.ExperimentalType;
import type.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevelType.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevelType.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean gatedTransportMilitaryPlanes = transportMilitaryPlanes.stream().anyMatch(militaryPlane -> (militaryPlane.getType() == MilitaryType.TRANSPORT));
        Assert.assertTrue(gatedTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        boolean isSorted = IntStream.range(0, planesSortedByMaxLoadCapacity.size() - 1).noneMatch(i -> planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        Assert.assertTrue(isSorted);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean hasBomber = bomberMilitaryPlanes.stream().anyMatch(militaryPlane -> (militaryPlane.getType() == MilitaryType.BOMBER));
        Assert.assertTrue(hasBomber);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasClassificationLevelHigherThanUnclassified = experimentalPlanes.stream().noneMatch(experimentalPlane -> experimentalPlane.getClassificationLevelType() == ClassificationLevelType.UNCLASSIFIED);
        Assert.assertTrue(hasClassificationLevelHigherThanUnclassified);
    }
}