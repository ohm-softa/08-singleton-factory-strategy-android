package de.thro.inf.prg3.a08.filtering;

import java.util.HashMap;
import java.util.Map;

import de.thro.inf.prg3.a08.filtering.filters.AllMealsStrategy;
import de.thro.inf.prg3.a08.filtering.filters.NoPorkStrategy;
import de.thro.inf.prg3.a08.filtering.filters.NoSoyStrategy;
import de.thro.inf.prg3.a08.filtering.filters.VegetarianStrategy;

/**
 * @author Peter Kurfer
 */

public abstract class MealFilterFactory {

    /* 'caching' all known filters */
    private static final Map<String, MealsFilter> filters = new HashMap<>();

    static {
        /* fill 'cache' in static constructor */
        filters.put("All", new AllMealsStrategy());
        filters.put("Vegetarian", new VegetarianStrategy());
        filters.put("No pork", new NoPorkStrategy());
        filters.put("No soy", new NoSoyStrategy());
    }

    /* private constructor to ensure that singleton cannot be instantiated outside of the class
     * in fact there's a possibility but it is really really dirty! */
    private MealFilterFactory() {
    }

    /**
     * Get the matching strategy to the given keyword
     * if strategy is unknown the factory will fallback to the AllMealsStrategy
     * @param key key to resolve strategy
     * @return MealsFilter instance corresponding to the given key or AllMealsStrategy as fallback
     */
    public static MealsFilter getStrategy(String key){
        if(filters.containsKey(key)){
            return filters.get(key);
        }
        return filters.get("All");
    }
}