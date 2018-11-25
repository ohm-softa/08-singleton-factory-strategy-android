package de.thro.inf.prg3.a08.filtering.filters;

import de.thro.inf.prg3.a08.filtering.FilterBase;
import de.thro.inf.prg3.a08.model.Meal;

/**
 * @author Peter Kurfer
 */

public class VegetarianStrategy extends FilterBase {

    private static final String[] meatTerms = new String[]{"fleisch", "Fleisch", "schwein", "Schwein", "rind", "Rind"};

    @Override
    protected boolean include(Meal m) {
        boolean containsMeat = false;
        /* extended vegetarian filter to check for more meat keywords */
        for(String note : m.getNotes()){
            for(String term : meatTerms) {
                /* remember how OR is defined:
                 * true  || false = true
                 * false || true  = true
                 * true  || true  = true */
                containsMeat = containsMeat || note.contains(term);
            }
        }
        return !containsMeat;
    }
}
