package com.didi.sdk.global.indexbar.utils;

import com.didi.sdk.global.indexbar.data.BaseGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rui.config.RConfigConstants;

@Deprecated
public class SortUtil {
    public static <T extends BaseGroup> void sort(List<T> list) {
        Collections.sort(list, new Comparator<T>() {
            public int compare(T t, T t2) {
                if (t.getGroup().equals(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                    return 1;
                }
                if (t2.getGroup().equals(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                    return -1;
                }
                return t.getGroup().compareTo(t2.getGroup());
            }
        });
    }

    public static <T extends BaseGroup> List<String> getGroups(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T group : list) {
            arrayList.add(group.getGroup());
        }
        return arrayList;
    }
}
