package com.didi.dimina.container.util;

import java.util.Collection;
import java.util.Map;

public class CollectionsUtil {
    public static boolean isEmpty(Collection collection) {
        return getSize(collection) == 0;
    }

    public static boolean isEmpty(Map map) {
        return getSize(map) == 0;
    }

    public static int getSize(Map map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static int getSize(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static int getSize(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static int getSize(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }
}
