package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CustomList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows( IllegalArgumentException.class, () -> { cityList.add(city); });
    }

    @Test
    void testGetCities() {
        CustomList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CustomList cityList = mockCityList();
        City trueCity = new City("True", "City");
        cityList.add(trueCity);
        assertTrue(cityList.hasCity(trueCity));

        City falseCity = new City("False", "City");
        assertFalse(cityList.hasCity(falseCity));
    }

    @Test
    void testDelete() {
        CustomList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));

        cityList.delete(city);
        assertFalse(cityList.hasCity(city));

        assertThrows( IllegalArgumentException.class, () -> { cityList.delete(city); });
    }

    @Test
    void testCount() {
        CustomList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        City city1 = new City("Yellowknife", "Northwest Territories");
        City city2 = new City("City2", "Province3");
        City city3 = new City("City3", "Province3");
        City city4 = new City ("City4", "Province4");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        assertEquals(4, cityList.countCities());

        cityList.delete(city1);
        assertEquals(3, cityList.countCities());
    }
}
