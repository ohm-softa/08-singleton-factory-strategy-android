package de.thro.inf.prg3.a08.test;

import org.junit.jupiter.api.Test;

import de.thro.inf.prg3.a08.filtering.MealFilterFactory;
import de.thro.inf.prg3.a08.filtering.MealsFilter;
import de.thro.inf.prg3.a08.filtering.filters.AllMealsStrategy;
import de.thro.inf.prg3.a08.filtering.filters.NoPorkStrategy;
import de.thro.inf.prg3.a08.filtering.filters.NoSoyStrategy;
import de.thro.inf.prg3.a08.filtering.filters.VegetarianStrategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 */

public class MealsFactoryTests {

    @Test
    public void testGetVegetarianStrategy() {
        MealsFilter filter = MealFilterFactory.getStrategy("Vegetarian");
        assertTrue(filter instanceof VegetarianStrategy);
    }

    @Test
    public void testGetNoSoyStrategy() {
        MealsFilter filter = MealFilterFactory.getStrategy("No soy");
        assertTrue(filter instanceof NoSoyStrategy);
    }

    @Test
    public void testGetNoPorkStrategy() {
        MealsFilter filter = MealFilterFactory.getStrategy("No pork");
        assertTrue(filter instanceof NoPorkStrategy);
    }

    @Test
    public void testGetAllStrategy() {
        MealsFilter filter = MealFilterFactory.getStrategy("All");
        assertTrue(filter instanceof AllMealsStrategy);
    }
}
