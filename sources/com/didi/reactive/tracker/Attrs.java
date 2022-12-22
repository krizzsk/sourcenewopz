package com.didi.reactive.tracker;

import java.util.HashMap;

public class Attrs extends HashMap {
    public Attrs attr(Object obj, Object obj2) {
        if (!(obj == null || obj2 == null)) {
            if (obj2 instanceof Boolean) {
                obj2 = Integer.valueOf(((Boolean) obj2).booleanValue() ? 1 : 0);
            }
            super.put(obj, obj2);
        }
        return this;
    }
}
