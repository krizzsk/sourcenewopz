package com.didi.common.map;

import android.content.Context;
import com.didi.common.map.listener.OnMapsSdkInitializedCallback;
import com.didi.common.map.util.DLog;
import com.didi.map.constant.StringConstant;

public class MapsSdkInitialize {

    public enum Renderer {
        LEGACY,
        LATEST
    }

    public static synchronized int initialize(Context context, MapVendor mapVendor, Renderer renderer, OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        synchronized (MapsSdkInitialize.class) {
            IMapsSdkInitializeDelegate a = m7308a(mapVendor);
            if (a == null || context == null) {
                return -1;
            }
            int initialize = a.initialize(context, renderer, onMapsSdkInitializedCallback);
            return initialize;
        }
    }

    /* renamed from: a */
    private static IMapsSdkInitializeDelegate m7308a(MapVendor mapVendor) {
        if (mapVendor == MapVendor.GOOGLE) {
            try {
                Object invoke = Class.forName("com.didi.common.map.adapter.googlemapadapter.MapsSdkInitialize").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke instanceof IMapsSdkInitializeDelegate) {
                    return (IMapsSdkInitializeDelegate) invoke;
                }
            } catch (Exception e) {
                DLog.m7384d(StringConstant.META_NAME, e.toString(), new Object[0]);
            }
        }
        return null;
    }
}
