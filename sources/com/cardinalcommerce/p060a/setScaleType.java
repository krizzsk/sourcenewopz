package com.cardinalcommerce.p060a;

import java.util.Collections;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setScaleType */
public final class setScaleType {
    public Set<String> getInstance = Collections.emptySet();

    public final boolean cca_continue(setMapTrackballToArrowKeys setmaptrackballtoarrowkeys) {
        if (setmaptrackballtoarrowkeys.configure == null) {
            return true;
        }
        for (String next : setmaptrackballtoarrowkeys.configure) {
            if (!Collections.singleton("b64").contains(next) && !Collections.unmodifiableSet(this.getInstance).contains(next)) {
                return false;
            }
        }
        return true;
    }
}
