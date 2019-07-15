package hw7.testData;

import hw7.entities.MetalsAndColors;

import java.util.Arrays;

public class MetalsAndColorsData {
    public static MetalsAndColors DEFAULT_DATA = new MetalsAndColors().set(s -> {
        s.setSummary(Arrays.asList(3, 8));
        s.setElements(Arrays.asList("Water", "Fire"));
        s.setColor("Red");
        s.setMetal("Selen");
        s.setVegetables(Arrays.asList("Cucumber", "Tomato"));
    });
}

