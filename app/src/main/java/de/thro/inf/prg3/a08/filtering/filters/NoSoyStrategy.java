package de.thro.inf.prg3.a08.filtering.filters;

import de.thro.inf.prg3.a08.filtering.FilterBase;
import de.thro.inf.prg3.a08.model.Meal;

/**
 * @author Peter Kurfer
 */

public class NoSoyStrategy extends FilterBase {

    @Override
    protected boolean include(Meal m) {
        boolean containsSoy = false;

        /* check if any note contains the words 'soja' or 'Soja' */
        for(String note : m.getNotes()) {
            /* remember how OR is defined:
             * true  || false = true
             * false || true  = true
             * true  || true  = true */
            containsSoy = containsSoy || note.contains("soja") || note.contains("Soja");
        }

        return !containsSoy;
    }

}
