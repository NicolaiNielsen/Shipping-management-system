package Portfolio2.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import Portfolio2.VesselModel.*;

import org.junit.jupiter.api.BeforeEach;

public class TestVessels {

    //Container test

    ContainerVessel a;

    //setup creates object
    @BeforeEach
    public void setupContainer() {
        a = new ContainerVessel(100, "Container vessel");
    }

    //struktureret gennem ævkvivalenspartionering og
    //grænseværdi analyser, hvor alle valide responses testes

    @Test
    public void testContainerLoadWithZero() { //test with 0
        assertEquals(0, a.loadingCargo(0, "TEU"), 0);
    }

    @Test
    public void testContainerLoadWithMax() { //test with max
        //cap is initalized to 100
        assertEquals(100, a.loadingCargo(100, "TEU"), 0);
    }

    @Test
    public void testContainerWithMultipleLoadings() { //tests multiple loadings
        assertEquals(20, a.loadingCargo(20, "TEU"), 0);
        assertEquals(90, a.loadingCargo(70, "TEU"), 0);
    }

    @Test
    public void testContainerOverloading() { //tests overloading
        assertEquals(0, a.loadingCargo(110, "TEU"), 0);
    }

    @Test 
    public void testContainerFraction() {
        a.loadingCargo(10, "TEU");
        assertEquals(0.1, a.loadFraction(), 0);
    }

    @Test 
    public void testContainerFractionMultipleloadings() {
        a.loadingCargo(10, "TEU");
        a.loadingCargo(10, "TEU");
        assertEquals(0.2, a.loadFraction(), 0);
    }

    @Test 
    public void testContainerFractionOverCap() {
        a.loadingCargo(110, "TEU");
        assertEquals(0, a.loadFraction(), 0);
    }

    //Roro Tests

    Roro b;

    //setup creates object
    @BeforeEach
    public void setupRoro() {
        b = new Roro(80, "Roro");
    }

    //struktureret gennem ævkvivalenspartionering og
    //grænseværdi analyser hvor alle valide responses testes

    @Test
    public void testRoroLoadMin() {
        assertEquals(0, b.loadingCargo(0, "truck"), 0);
    }

    @Test
    public void testRoroLoadMax() {
        assertEquals(80, b.loadingCargo(10, "car"), 0);
    }

    @Test
    public void testRoroMultipleLoadings() {
        assertEquals(8, b.loadingCargo(1, "car"), 0);
        assertEquals(38, b.loadingCargo(1, "truck"), 0);
    }


    @Test
    public void testRoroOverloading() {
        assertEquals(8, b.loadingCargo(1, "car"), 0);
        assertEquals(8, b.loadingCargo(3, "truck"), 0);
    }

    @Test
    public void testRoroFraction() {
        b.loadingCargo(1, "car");
        assertEquals(0.1, b.loadFraction(), 0);
    }

    //tanker valid tests

    Tanker c;

    @BeforeEach
    public void setupTanker() {
        c = new Tanker(10, "First tanker");
    }

    @Test
    public void testTankerLoading() {
        assertEquals(9000, c.loadingCargo(9000, "1"), 0);
    }

    @Test
    public void multipleTankerLoadings() {
        assertEquals(500, c.loadingCargo(500, "1"), 0);
        assertEquals(500, c.loadingCargo(250, "1"), 0);
    }

    @Test
    public void testTankerLoadingDifferentCompartments() {
        assertEquals(9000, c.loadingCargo(9000, "1"), 0);
        assertEquals(7000, c.loadingCargo(7000, "2"), 0);
    }

    @Test
    public void testTankerFraction() {
        c.loadingCargo(1000, "1");
        c.loadingCargo(5000, "8");
        assertEquals(0.1, c.loadFraction("1"),0);
        assertEquals(0.5, c.loadFraction("8"),0);
        assertEquals(0, c.loadFraction("2"),0);
    }

    //how do pass a test with invalid inputs?
    //expects throws exceptions

    @Test
    public void testTankerLoadNegativeNum() {
        Exception exception = assertThrows(Exception.class, () -> c.loadingCargo(-1000, "1")); //cannot be negative -1000
        assertEquals("Cannot be negative value", exception.getMessage());
    }

    @Test
    public void testTankerInvalidType() {
        Exception exception = assertThrows(Exception.class, () -> c.loadingCargo(1000, "test")); //test is invalid type
        assertEquals("Type must not consist of characters, must be a number between 1 and 10", exception.getMessage());
    }

    @Test
    public void testTankerOutOfBoundsIndex() {
        Exception exception = assertThrows(Exception.class, () -> c.loadingCargo(1000, "-1")); //type cannot negative or > 10
        assertEquals("Must be a number between 1 and 10", exception.getMessage());
    }

    @Test
    public void testTankerOutOfBoundsFraction() {
        Exception exception = assertThrows(Exception.class, () -> c.loadFraction("0")); //type cannot be 0
        assertEquals("Compartment must be between 1 and 10", exception.getMessage());
    }


}
