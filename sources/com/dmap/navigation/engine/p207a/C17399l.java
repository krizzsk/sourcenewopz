package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.apollo.ApolloDelegate;

/* renamed from: com.dmap.navigation.engine.a.l */
/* compiled from: ApolloUtil */
public final class C17399l {

    /* renamed from: a */
    private static final ApolloDelegate f51825a = new ApolloDelegate();

    /* renamed from: b */
    public static boolean m37033b() {
        return f51825a.getToggleCache("hawaii_zhongyan_switch").allow();
    }

    /* renamed from: c */
    public static int m37034c() {
        IToggle toggleCache = f51825a.getToggleCache("hw_navi_mm_config");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("dia_version", 0)).intValue();
        }
        return 0;
    }

    public static boolean isTrafficEventOpen() {
        return f51825a.getToggleCache("hawaii_android_traffic_event").allow();
    }

    public static boolean isOpenFbRoadName() {
        return f51825a.getToggleCache("hawaii_map_fishbone_bubbles").allow();
    }

    /* renamed from: d */
    public static int m37035d() {
        IToggle toggleCache = f51825a.getToggleCache("hawaii_android_navi_mm_for_fishbone");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("fishbone", 0)).intValue();
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m37036e() {
        return f51825a.getToggleCache("hawaii_android_navi_multi_route").allow();
    }

    /* renamed from: f */
    public static boolean m37037f() {
        IToggle toggleCache = f51825a.getToggleCache("gray_map_navi_basemap_camera_v2");
        if ((toggleCache.allow() ? ((Integer) toggleCache.getExperiment().getParam("camera_v2_show", 0)).intValue() : 0) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m37038g() {
        IToggle toggleCache = f51825a.getToggleCache("map_drive_navi_pic_vector");
        if (toggleCache.allow()) {
            int intValue = ((Integer) toggleCache.getExperiment().getParam("vector", 0)).intValue();
            if (intValue == 1) {
                return true;
            }
            if (intValue == 0) {
            }
        }
        return false;
    }
}
