package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.LocationPerformer;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IAsyncToggleCallback;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.ToggleResult;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.dmap.navigation.base.ctx.INaviOptionExt;
import java.util.HashMap;

public class GuideUtil {

    /* renamed from: a */
    private static final String f37624a = "didiguide";

    /* renamed from: b */
    private static final String f37625b = "NEED_GUIDE";

    /* renamed from: c */
    private static final String f37626c = "STARTED";

    /* renamed from: d */
    private static final String f37627d = "UPGRADE_USER";
    public static boolean deubg = false;

    /* renamed from: e */
    private static final String f37628e = "first_launched";

    /* renamed from: f */
    private static final String f37629f = "first_launch_time";

    /* renamed from: g */
    private static SharedPreferences f37630g;

    /* renamed from: h */
    private static SharedPreferences.Editor f37631h;
    public static boolean isGuideShowed;

    public interface ApolloFinishListener {
        void onFinish(boolean z);
    }

    public static String getMapType(int i) {
        if (i == 0) {
            return "wgs84";
        }
        if (i == 1) {
        }
        return "soso";
    }

    /* renamed from: a */
    private static void m26699a(Context context) {
        if (f37630g == null || f37631h == null) {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), f37624a, 0);
            f37630g = sharedPreferences;
            f37631h = sharedPreferences.edit();
        }
    }

    public static void getApolloSwitch(final ApolloFinishListener apolloFinishListener) {
        Apollo.getAsyncToggle("passenger_newuser", (HashMap<String, String>) null, 700, 300, new IAsyncToggleCallback() {
            public void onSuccess(ToggleResult toggleResult) {
                if (toggleResult.getErrorNo() == 1) {
                    SystemUtils.log(6, INaviOptionExt.KEY_GUIDE, "guide apollo timeout", (Throwable) null, "com.didi.sdk.util.GuideUtil$1", 60);
                    apolloFinishListener.onFinish(false);
                    return;
                }
                IToggle toggle = toggleResult.getToggle();
                if (!(toggle == null || !toggle.allow() || toggle.getExperiment() == null || toggle.getExperiment() == null)) {
                    int intValue = ((Integer) toggle.getExperiment().getParam("type", 0)).intValue();
                    SystemUtils.log(4, INaviOptionExt.KEY_GUIDE, "guide apollo type:" + intValue, (Throwable) null, "com.didi.sdk.util.GuideUtil$1", 72);
                    if (intValue == 1) {
                        apolloFinishListener.onFinish(true);
                        return;
                    }
                }
                apolloFinishListener.onFinish(false);
            }
        });
    }

    public static void init(Context context) {
        m26699a(context);
        if (!f37630g.getBoolean(f37626c, false)) {
            f37631h.putBoolean(f37627d, SystemUtils.getSharedPreferences(context, "business_id", 0).contains("id")).apply();
            f37631h.putBoolean(f37626c, true).apply();
        }
    }

    /* renamed from: b */
    private static boolean m26700b(Context context) {
        m26699a(context);
        return f37630g.getBoolean(f37627d, false);
    }

    public static boolean needGuide(Context context) {
        m26699a(context);
        if (!m26700b(context)) {
            return f37630g.getBoolean(f37625b, true);
        }
        setNeedGuide(context, false);
        return false;
    }

    public static void setNeedGuide(Context context, boolean z) {
        m26699a(context);
        f37631h.putBoolean(f37625b, z).apply();
    }

    public static boolean isFirstLaunchedApp(Context context) {
        m26699a(context);
        return f37630g.getBoolean(f37628e, true);
    }

    public static void setAppLaunchFirstTime(Context context, long j) {
        m26699a(context);
        f37631h.putLong(f37629f, j).apply();
    }

    public static long getAppLaunchFirstTime(Context context) {
        m26699a(context);
        return f37630g.getLong(f37629f, 0);
    }

    public static void cleanFirstLaunchApp(Context context) {
        m26699a(context);
        f37631h.putBoolean(f37628e, false).apply();
    }

    public static void startLocate(Context context) {
        LocationPerformer.getInstance().start(context.getApplicationContext());
    }

    public static DIDILocation getLocation() {
        return LocationPerformer.getInstance().getLastLocation();
    }
}
