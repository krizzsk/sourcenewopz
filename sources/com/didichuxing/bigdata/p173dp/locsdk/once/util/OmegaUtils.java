package com.didichuxing.bigdata.p173dp.locsdk.once.util;

import android.content.Context;
import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.util.OmegaUtils */
public class OmegaUtils {

    /* renamed from: a */
    private static final Random f46151a = new Random();

    /* renamed from: b */
    private static final int f46152b = ApolloProxy.getInstance().getResultSamplePercent();

    /* renamed from: c */
    private static final int f46153c = ApolloProxy.getInstance().getNTPLocStatPercent();

    /* renamed from: d */
    private static final int f46154d = ApolloProxy.getInstance().getLocTimeMonotonicStatPercent();

    /* renamed from: e */
    private static final int f46155e = ApolloProxy.getInstance().getLocDispatchStatPercent();

    /* renamed from: a */
    private static void m33148a(String str, long j) {
    }

    public static void trackGetSimCgi(boolean z, String str, String str2) {
    }

    public static void trackNTPCache(boolean z, Long l) {
    }

    public static void trackNTPSync(String str, boolean z, Long l, Long l2, long j, long j2, String str2, String str3, int i, boolean z2) {
    }

    static {
        DLog.m32737d("NTP_LOC_STAT_PERCENT=" + f46153c);
        DLog.m32737d("LOCTIME_MONOTONIC_STAT_PERCENT=" + f46154d);
        DLog.m32737d("LOC_DISPATCH_STAT_PERCENT=" + f46155e);
    }

    public static void trackNTPAndMobileTimeDiff(long j) {
        m33148a("mobile", j);
    }

    public static void trackNTPAndLocTimeDiff(String str, long j) {
        if (isSampledByPercent(f46153c)) {
            m33148a(str, j);
        }
    }

    public static void trackLocDispatch(String str, DIDILocation dIDILocation, long j, long j2, boolean z) {
        if (dIDILocation != null && isSampledByPercent(f46155e)) {
            HashMap hashMap = new HashMap();
            hashMap.put("impl", str);
            hashMap.put("t_loc", String.valueOf(dIDILocation.getTime()));
            hashMap.put("et_loc", String.valueOf(dIDILocation.getElapsedRealtime()));
            hashMap.put("et_loc_recv", String.valueOf(dIDILocation.getExtra().getLong(DIDILocation.EXTRA_KEY_RECV_GPS_TICK)));
            hashMap.put("et_dispatch", String.valueOf(j));
            hashMap.put("et_last_dispatch", String.valueOf(j2));
            hashMap.put("provider", dIDILocation.getProvider());
            hashMap.put("source", dIDILocation.getSource());
            hashMap.put("navi", z ? "1" : "0");
            OmegaSDKAdapter.trackEvent("locsdk_loc_dispatch", (Map<String, Object>) hashMap);
        }
    }

    public static boolean isSampledByPercent(int i) {
        if (i >= 100) {
            return true;
        }
        return i > 0 && f46151a.nextInt(100) < i;
    }

    /* renamed from: a */
    private static boolean m33149a(int i) {
        if (i >= 1000) {
            return true;
        }
        return i > 0 && f46151a.nextInt(1000) < i;
    }

    public static void trackReflectError(Throwable th, String str) {
        HashMap hashMap = new HashMap();
        if (th != null) {
            hashMap.put("cls", th.getClass().getName());
            hashMap.put("msg", th.getMessage());
            if (th.getCause() != null) {
                hashMap.put("cause_cls", th.getCause().getClass().getName());
                hashMap.put("cause_msg", th.getCause().getMessage());
            }
        }
        if (str != null) {
            hashMap.put("info", str);
        }
        OmegaSDKAdapter.trackEvent("locsdk_reflect_error", (Map<String, Object>) hashMap);
    }

    public static void trackGeneralResult(String str, int i, boolean z, int i2, float f, int i3, int i4) {
        if (isSampledByPercent(f46152b)) {
            Event event = new Event("map_locsdk_global_general_result_sw");
            event.putAttr("result", Integer.valueOf(z ? 1 : 0));
            event.putAttr("app_id", str);
            event.putAttr("new_google_api", Integer.valueOf(i3));
            event.putAttr("impl_version", Integer.valueOf(i4));
            if (!z) {
                event.putAttr("error_no", Integer.valueOf(i2));
            } else {
                event.putAttr(ServerParam.PARAM_ACCURACY, Float.valueOf(f));
                event.putAttr("provider", Integer.valueOf(i));
            }
            OmegaSDKAdapter.trackEvent(event);
        }
    }

    public static void trackLastKnowResult(String str, boolean z, boolean z2, float f) {
        Event event = new Event("map_locsdk_global_last_know_result_sw");
        event.putAttr("result", Integer.valueOf(z2 ? 1 : 0));
        event.putAttr("is_effective", Integer.valueOf(z ? 1 : 0));
        event.putAttr("app_id", str);
        if (z2) {
            event.putAttr(ServerParam.PARAM_ACCURACY, Float.valueOf(f));
        }
        OmegaSDK.trackEventSampled(event, (float) (f46152b / 100));
    }

    public static void trackWifiInfos(Context context, int i) {
        if (context != null && ApolloProxy.getInstance().pickUpPageEventTrackingSwitcher()) {
            Event event = new Event("tech_map_log_wifi_state");
            event.putAttr("wifi_permission", Integer.valueOf(Utils.isLocationPermissionGranted(context) ? 1 : 0));
            event.putAttr("wifi_connection", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent(event);
        }
    }
}
