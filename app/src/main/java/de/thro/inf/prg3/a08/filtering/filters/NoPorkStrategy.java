package de.thro.inf.prg3.a08.filtering.filters;

import de.thro.inf.prg3.a08.filtering.FilterBase;
import de.thro.inf.prg3.a08.model.Meal;

/**
 * @author Peter Kurfer
 */

public class NoPorkStrategy extends FilterBase {

    @Override
    protected boolean include(Meal m) {
        boolean containsPork = false;

        /* check if any note contains the words 'schwein' or 'Schwein' */
        for(String note : m.getNotes()) {
            /* remember how OR is defined:
             * true  || false = true
             * false || true  = true
             * true  || true  = true */
            containsPork = containsPork || note.contains("schwein") || note.contains("Schwein");
        }
        return !containsPork;
    }

}
