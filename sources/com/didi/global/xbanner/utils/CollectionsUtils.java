package com.didi.global.xbanner.utils;

import java.util.List;

public final class CollectionsUtils {
    public static boolean isEmptyList(List list) {
        return list == null || list.size() == 0;
    }
}
