package com.didi.map.common.lib;

import android.content.Context;
import com.didi.hawaii.log.HWLog;
import com.didi.map.MapOmegaUtil;
import com.didi.map.constant.StringConstant;

public class MapLibaryLoader {
    static final String[] LIB_NAMES = {"map", StringConstant.LIB_NAV, StringConstant.LIB_MAPV2};
    private static boolean isInited = false;
    private static Context mContext;

    public static void loadAllLibary(Context context) {
        for (String str : LIB_NAMES) {
            HWLog.m16759d("didi", "1:" + str);
            loadLibary(context, str);
        }
    }

    public static synchronized void init(Context context) {
        synchronized (MapLibaryLoader.class) {
            mContext = context.getApplicationContext();
        }
    }

    public static synchronized void loadLibary(String str) {
        synchronized (MapLibaryLoader.class) {
            if (mContext != null) {
                loadLibary(mContext, str);
            }
        }
    }

    public static synchronized void loadLibary(Context context, String str) {
        synchronized (MapLibaryLoader.class) {
            if (!isInited) {
                try {
                    System.loadLibrary(str);
                    isInited = true;
                    HWLog.m16759d("didi", "loadLibary name:" + str + " , true");
                    MapOmegaUtil.trackLoadSoStatusInfo(str, "MapLibaryLoader_loadLibary", "success");
                } catch (UnsatisfiedLinkError e) {
                    HWLog.m16759d("didi", "loadLibary name:" + str + " , " + e.getMessage());
                    if (MapWorkaroundLibaryLoader.m17568a(context, str)) {
                        isInited = true;
                        MapOmegaUtil.trackLoadSoStatusInfo(str, "MapLibaryLoader_tryLoadLibraryUsingWorkaround", "success");
                    } else {
                        MapOmegaUtil.trackLoadSoStatusInfo(str, "MapLibaryLoader_tryLoadLibraryUsingWorkaround", "failed");
                    }
                }
            }
        }
    }

    public static synchronized void preLoadLibrary(final Context context) {
        synchronized (MapLibaryLoader.class) {
            if (!isInited) {
                new Thread(new Runnable() {
                    public void run() {
                        MapLibaryLoader.loadLibary(context, "map");
                    }
                }).start();
            }
        }
    }
}
