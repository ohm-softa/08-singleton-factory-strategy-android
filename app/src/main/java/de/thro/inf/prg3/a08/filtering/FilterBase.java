package de.thro.inf.prg3.a08.filtering;

import java.util.LinkedList;
import java.util.List;

import de.thro.inf.prg3.a08.model.Meal;

/**
 * Base class for all filter implementations
 * @author Peter Kurfer
 */

public abstract class FilterBase implements MealsFilter {

    @Override
    public List<Meal> filter(List<Meal> meals) {
        List<Meal> result = new LinkedList<>();

        /* iterate all given meals */
        for(Meal m : meals) {
            /* use `abstract` include method to determine if meal should be included */
            if(include(m)){
                result.add(m);
            }
        }

        return result;
    }

    /**
     * Determine if a given meal should be included or excluded
     * @param m meal to investigate
     * @return boolean result, true means meal will be included
     */
    protected abstract boolean include(Meal m);
}
