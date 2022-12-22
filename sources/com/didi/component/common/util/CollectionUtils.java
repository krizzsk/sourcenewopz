package com.didi.component.common.util;

import java.util.Collection;
import java.util.Map;

@Deprecated
public class CollectionUtils {
    public static boolean isEmpty(Collection collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }
}
