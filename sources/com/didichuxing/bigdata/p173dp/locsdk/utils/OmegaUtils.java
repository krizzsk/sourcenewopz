package com.didichuxing.bigdata.p173dp.locsdk.utils;

import com.didi.raven.config.RavenKey;
import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.FLPDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.utils.OmegaUtils */
public class OmegaUtils {

    /* renamed from: a */
    private static final Random f46174a = new Random();

    /* renamed from: b */
    private static final int f46175b = ApolloProxy.getInstance().getResultSamplePercent();

    /* renamed from: c */
    private static final int f46176c = ApolloProxy.getInstance().getNTPStatBasePercent();

    /* renamed from: d */
    private static final int f46177d = ApolloProxy.getInstance().getNTPStatLocPercent();

    /* renamed from: e */
    private static final int f46178e = ApolloProxy.getInstance().getLocTimeMonotonicStatPercent();

    /* renamed from: f */
    private static final int f46179f = ApolloProxy.getInstance().getLocDispatchStatPercent();

    public static void trackGetSimCgi(boolean z, String str, String str2) {
    }

    public static void trackNTPCache(boolean z, Long l) {
    }

    public static void trackNTPSync(String str, boolean z, Long l, Long l2, long j, long j2, String str2, String str3, int i, boolean z2) {
    }

    static {
        DLog.m32737d("NTP_STAT_BASE_PERCENT=" + f46176c);
        DLog.m32737d("NTP_LOC_STAT_PERCENT=" + f46177d);
        DLog.m32737d("LOCTIME_MONOTONIC_STAT_PERCENT=" + f46178e);
        DLog.m32737d("LOC_DISPATCH_STAT_PERCENT=" + f46179f);
    }

    public static void trackNTPAndMobileTimeDiff(long j) {
        if (isSampledByPercent(f46176c)) {
            m33155a("mobile", j);
        }
    }

    public static void trackNTPAndLocTimeDiff(String str, long j) {
        if (isSampledByPercent(f46177d)) {
            m33155a(str, j);
        }
    }

    /* renamed from: a */
    private static void m33155a(String str, long j) {
        if (!FLPDiffInfoGetter.getInstance().getNTPTimeDiffWTFSwitch()) {
            Event event = new Event("locsdk_ntp_timediff", "");
            HashMap hashMap = new HashMap();
            hashMap.put("base", str);
            hashMap.put("diff", String.valueOf(j));
            hashMap.put("time_ntp", String.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis()));
            event.putAllAttrs(hashMap);
            event.putNetType();
            OmegaSDKAdapter.trackEvent(event);
        }
    }

    public static void trackLocDispatch(String str, DIDILocation dIDILocation, long j, long j2, boolean z) {
        if (dIDILocation != null && isSampledByPercent(f46179f)) {
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

    public static void trackSystemGpsButSdkNoGpsOrFlp(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("system_gps_time", Long.valueOf(j));
        hashMap.put("loc_sdk_gpsflp_time", Long.valueOf(j2));
        hashMap.put("use_flp", 0);
        OmegaSDKAdapter.trackEvent("system_refresh_gps_but_loc_sdk", (Map<String, Object>) hashMap);
    }

    public static void trackLocTimestampMonotonic(DIDILocation dIDILocation, DIDILocation dIDILocation2, String str) {
        String str2;
        if (isSampledByPercent(f46178e) && dIDILocation != null && dIDILocation2 != null) {
            boolean z = true;
            boolean z2 = dIDILocation.getTime() <= dIDILocation2.getTime();
            if (Math.abs(dIDILocation.getTime() - dIDILocation2.getTime()) <= 60000) {
                z = false;
            }
            boolean isNTPAvailable = TimeServiceManager.getInstance().isNTPAvailable();
            Event event = new Event("locsdk_time_monotonic", "");
            HashMap hashMap = new HashMap();
            String str3 = "1";
            hashMap.put("monotonic", z2 ? str3 : "0");
            if (isNTPAvailable) {
                str2 = str3;
            } else {
                str2 = "0";
            }
            hashMap.put("ntp", str2);
            hashMap.put("scene", str);
            if (!z2 || z) {
                if (!z) {
                    str3 = "0";
                }
                hashMap.put("jump", str3);
                hashMap.put("last_p", dIDILocation.getProvider());
                hashMap.put("last_t", String.valueOf(dIDILocation.getTime()));
                hashMap.put("curr_p", dIDILocation2.getProvider());
                hashMap.put("curr_t", String.valueOf(dIDILocation2.getTime()));
                hashMap.put("ntp_t", String.valueOf(TimeServiceManager.getInstance().getNTPCurrenTimeMillis()));
            }
            event.putAllAttrs(hashMap);
            OmegaSDKAdapter.trackEvent(event);
        }
    }

    public static void trackVDRInertial(DIDILocation dIDILocation) {
        Event event = new Event("locsdk_vdr_inertial");
        HashMap hashMap = new HashMap();
        hashMap.put("lat", String.valueOf(dIDILocation.getLatitude()));
        hashMap.put("lng", String.valueOf(dIDILocation.getLongitude()));
        hashMap.put(RavenKey.TYPE, String.valueOf(dIDILocation.getTime()));
        hashMap.put(RavenKey.VERSION, String.valueOf(dIDILocation.getSpeed()));
        hashMap.put("dir", String.valueOf(dIDILocation.getBearing()));
        event.putAllAttrs(hashMap);
        event.putNetType();
        OmegaSDKAdapter.trackEvent(event);
    }

    public static boolean isSampledByPercent(int i) {
        if (i >= 100) {
            return true;
        }
        return i > 0 && f46174a.nextInt(100) < i;
    }

    /* renamed from: a */
    private static boolean m33156a(int i) {
        if (i >= 1000) {
            return true;
        }
        return i > 0 && f46174a.nextInt(1000) < i;
    }

    public static void trackReflectError(Throwable th, String str) {
        if (m33156a(2)) {
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
    }

    public static void trackGeneralResult(String str, int i, boolean z, int i2, float f, int i3, int i4) {
        if (isSampledByPercent(f46175b)) {
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
        OmegaSDK.trackEventSampled(event, (float) (f46175b / 100));
    }
}
