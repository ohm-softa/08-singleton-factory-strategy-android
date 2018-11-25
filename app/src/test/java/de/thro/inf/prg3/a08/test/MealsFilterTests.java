package de.thro.inf.prg3.a08.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import de.thro.inf.prg3.a08.filtering.MealFilterFactory;
import de.thro.inf.prg3.a08.filtering.MealsFilter;
import de.thro.inf.prg3.a08.model.Meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Peter Kurfer
 */

public class MealsFilterTests {

    private List<Meal> meals;

    @BeforeEach
    public void setup() {
        meals = new LinkedList<>();
        meals.add(new Meal(1, "Pork", "", "Schweinefleisch"));
        meals.add(new Meal(2, "Soy", "", "Soja"));
        meals.add(new Meal(3, "Beef", "", "Rindergulasch"));
    }

    @Test
    public void testAllMealStrategy() {
        MealsFilter allMealsFilter = MealFilterFactory.getStrategy("All");
        List<Meal> filtered = allMealsFilter.filter(meals);

        assertNotNull(filtered);
        assertEquals(3, filtered.size());
    }

    @Test
    public void testNoPorkStrategy() {
        MealsFilter noPorkFilter = MealFilterFactory.getStrategy("No pork");
        List<Meal> filtered = noPorkFilter.filter(meals);

        assertNotNull(filtered);
        assertEquals(2, filtered.size());
    }

    @Test
    public void testNoSoyStrategy() {
        MealsFilter noSoyFilter = MealFilterFactory.getStrategy("No soy");
        List<Meal> filtered = noSoyFilter.filter(meals);

        assertNotNull(filtered);
        assertEquals(2, filtered.size());
    }

    @Test
    public void testVegetarianStrategy() {
        MealsFilter vegetarianFilter = MealFilterFactory.getStrategy("Vegetarian");
        List<Meal> filtered = vegetarianFilter.filter(meals);

        assertNotNull(filtered);
        assertEquals(1, filtered.size());
    }
}
