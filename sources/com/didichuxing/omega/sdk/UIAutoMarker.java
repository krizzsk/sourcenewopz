package com.didichuxing.omega.sdk;

import android.content.Context;
import android.view.View;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UIAutoMarker {
    private static Queue<String> blackPages = new ConcurrentLinkedQueue();
    private static WeakHashMap<Context, Map<String, Object>> paMarks = new WeakHashMap<>();
    private static WeakHashMap<View, Map<String, Object>> vaMarks = new WeakHashMap<>();
    private static WeakHashMap<Context, WeakHashMap<View, String>> vnMarks = new WeakHashMap<>();

    public static WeakHashMap<View, String> getViewNameMap(Context context) {
        WeakHashMap<View, String> weakHashMap = vnMarks.get(context);
        if (weakHashMap != null) {
            return weakHashMap;
        }
        WeakHashMap<View, String> weakHashMap2 = new WeakHashMap<>();
        vnMarks.put(context, weakHashMap2);
        return weakHashMap2;
    }

    public static Map<String, Object> getPageAttrMap(Context context) {
        return paMarks.get(context);
    }

    public static void putPageAttr(Context context, String str, Object obj) {
        Map map = paMarks.get(context);
        if (map == null) {
            map = new HashMap();
            paMarks.put(context, map);
        }
        map.put(str, obj);
    }

    public static Map<String, Object> getViewAttrMap(View view) {
        return vaMarks.get(view);
    }

    public static void putViewAttr(View view, String str, Object obj) {
        Map map = vaMarks.get(view);
        if (map == null) {
            map = new HashMap();
            vaMarks.put(view, map);
        }
        map.put(str, obj);
    }

    public static void addBlackPage(String str) {
        if (str != null && str.length() > 0) {
            blackPages.add(str);
        }
    }

    public static void addBlackPages(List<String> list) {
        if (list != null && list.size() > 0) {
            blackPages.addAll(list);
        }
    }

    public static boolean inBlackPages(String str) {
        for (String equals : OmegaConfig.blackList) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
