package com.didi.sdk.onehotpatch.commonstatic.report;

import android.content.Context;
import com.didi.sdk.onehotpatch.BuildConfig;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HotPatchEvent {
    public static final int STATUS_BEGIN = 1;
    public static final int STATUS_FAILED = -1;
    public static final int STATUS_FINISH = 0;
    private static final String TYPE_CRASH = "crash";
    private static final String TYPE_DEXOPT = "dexopt";
    private static final String TYPE_DOWNLOAD = "download";
    private static final String TYPE_LOAD = "load";
    private static final String TYPE_MERGE = "merge";
    private static final String TYPE_OTHER = "other";
    private static final String TYPE_ROLLBACK = "rollback";

    public static class LoadResult {
        public static final int BEGIN = 1;
        public static final int FAILURE = -1;
        public static final int NOT_AVAILABLE = 30;
        public static final int NOT_MATCH = 20;
        public static final int NOT_MATCH_APP_VERSION = 21;
        public static final int NOT_MATCH_OS_VERSION = 22;
        public static final int NO_NEED = 10;
        public static final int NO_NEED_HOTPATCH = 11;
        public static final int NO_NEED_PATCH = 12;
        public static final int SUCCESS = 0;
        public static long sLaunchStartTime;
        public long costTime;
        public String errmsg;
        public String errorType;
        public String patchVersion;
        public long startTime = sLaunchStartTime;
        public int status;

        public String toString() {
            return Const.joLeft + "status=" + this.status + ", " + "costTime=" + this.costTime + ", " + "patchVersion=" + this.patchVersion + ", " + "errorType=" + this.errorType + ", " + "errmsg=" + this.errmsg + "}";
        }
    }

    static class OmegaInvoker {
        private static final String EVENT = "HotPatchEvent";

        OmegaInvoker() {
        }

        public static void trackEvent(HashMap<String, Object> hashMap) {
            Event newEvent = OmegaSDK.newEvent(EVENT);
            newEvent.putAllAttrs(hashMap);
            OmegaSDKAdapter.trackEvent(newEvent);
        }

        public static void trackError(String str, Throwable th) {
            OmegaSDK.trackError(str, th);
        }

        public static void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
            OmegaSDK.trackError(str, str2, str3, str4, map);
        }
    }

    private static void invokeOmegaTrackEvent(Context context, HashMap<String, Object> hashMap) {
        try {
            Method declaredMethod = Class.forName(OmegaInvoker.class.getName(), false, context.getClassLoader()).getDeclaredMethod("trackEvent", new Class[]{HashMap.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[]{hashMap});
        } catch (Exception e) {
            Logger.warn(e);
        }
    }

    private static void invokeOmegaTrackError(Context context, String str, Throwable th) {
        try {
            Method declaredMethod = Class.forName(OmegaInvoker.class.getName(), false, context.getClassLoader()).getDeclaredMethod("trackError", new Class[]{String.class, Throwable.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[]{str, th});
        } catch (Exception e) {
            Logger.warn(e);
        }
    }

    private static void invokeOmegaTrackError(Context context, String str, String str2, String str3, String str4, Map<String, Object> map) {
        try {
            Method declaredMethod = Class.forName(OmegaInvoker.class.getName(), false, context.getClassLoader()).getDeclaredMethod("trackError", new Class[]{String.class, String.class, String.class, String.class, Map.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((Object) null, new Object[]{str, str2, str3, str4, map});
        } catch (Exception e) {
            Logger.warn(e);
        }
    }

    private static void track(Context context, String str, String str2, int i, Throwable th) {
        if (th == null) {
            track(context, str, str2, i, "", "");
            return;
        }
        track(context, str, str2, i, th.getMessage(), UtilsHub.dumpException(th));
    }

    public static void track(Context context, String str, String str2, int i, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        hashMap.put("type", str2);
        hashMap.put("status", Integer.valueOf(i));
        hashMap.put("errorType", str3);
        hashMap.put("errmsg", str4);
        hashMap.put("delta", 0);
        hashMap.put("appVersion", UtilsHub.getVersionName(context));
        hashMap.put("sdkVersion", BuildConfig.HOTPATCH_VERSION);
        invokeOmegaTrackEvent(context, hashMap);
        if (i < 0) {
            invokeOmegaTrackError(context, "hotpatch", "hotpatch_" + str2 + "_failed", str3, str4, hashMap);
        }
    }

    public static void track(Context context, String str, String str2, int i, String str3, String str4, int i2, int i3, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", str);
        hashMap.put("type", str2);
        hashMap.put("status", Integer.valueOf(i));
        hashMap.put("errorType", str3);
        hashMap.put("errmsg", str4);
        hashMap.put("succCount", Integer.valueOf(i2));
        hashMap.put("failCount", Integer.valueOf(i3));
        hashMap.put("progressName", str5);
        hashMap.put("delta", 0);
        hashMap.put("appVersion", UtilsHub.getVersionName(context));
        hashMap.put("sdkVersion", BuildConfig.HOTPATCH_VERSION);
        invokeOmegaTrackEvent(context, hashMap);
        if (i < 0) {
            invokeOmegaTrackError(context, "hotpatch", "hotpatch_" + str2 + "_failed", str3, str4, hashMap);
        }
    }

    public static void trackDownload(Context context, String str, int i, Throwable th) {
        track(context, str, "download", i, th);
    }

    public static void trackRollback(Context context) {
        track(context, "0", TYPE_ROLLBACK, 0, (Throwable) null);
    }

    public static void trackMerge(Context context, PatchModule patchModule, int i, Throwable th) {
        track(context, patchModule.version, TYPE_MERGE, i, th);
    }

    public static void trackDexopt(Context context, PatchModule patchModule, int i, Throwable th) {
        track(context, patchModule.version, TYPE_DEXOPT, i, th);
    }

    public static void trackOther(Context context, int i, Throwable th) {
        track(context, "0", "other", i, th);
    }

    public static void trackOther(Context context, int i, String str, String str2) {
        track(context, "0", "other", i, str, str2);
    }

    public static void trackLoad(Context context, LoadResult loadResult) {
        if (loadResult != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "load");
            hashMap.put("status", Integer.valueOf(loadResult.status));
            hashMap.put("id", loadResult.patchVersion);
            hashMap.put("costTime", Long.valueOf(loadResult.costTime));
            hashMap.put("errorType", loadResult.errorType);
            hashMap.put("errmsg", loadResult.errmsg);
            hashMap.put("delta", Long.valueOf(System.currentTimeMillis() - loadResult.startTime));
            hashMap.put("appVersion", UtilsHub.getVersionName(context));
            hashMap.put("sdkVersion", BuildConfig.HOTPATCH_VERSION);
            invokeOmegaTrackEvent(context, hashMap);
            if (loadResult.status < 0) {
                invokeOmegaTrackError(context, "hotpatch", "hotpatch_load_failed", loadResult.errorType, loadResult.errmsg, hashMap);
            }
        }
    }

    public static void trackCrash(Context context, PatchModule patchModule, Throwable th) {
        track(context, patchModule.version, "crash", -1, th);
    }

    public static void trackCrash(Context context, PatchModule patchModule, String str, Throwable th) {
        track(context, patchModule.version, "crash", -1, str, UtilsHub.dumpException(th));
    }
}
