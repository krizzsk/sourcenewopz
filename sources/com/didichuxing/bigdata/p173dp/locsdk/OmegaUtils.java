package com.didichuxing.bigdata.p173dp.locsdk;

import com.android.didi.bfflib.business.BffNetConstant;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.OmegaUtils */
public class OmegaUtils {

    /* renamed from: a */
    private static final Random f45712a = new Random();

    /* renamed from: b */
    private static final int f45713b = ApolloProxy.getInstance().getNTPStatBasePercent();

    /* renamed from: c */
    private static final int f45714c = ApolloProxy.getInstance().getNTPStatLocPercent();

    /* renamed from: d */
    private static final int f45715d = ApolloProxy.getInstance().getLocTimeMonotonicStatPercent();

    /* renamed from: e */
    private static final int f45716e = ApolloProxy.getInstance().getLocDispatchStatPercent();

    /* renamed from: a */
    private static void m32744a(String str, long j) {
    }

    public static void trackNTPCache(boolean z, Long l) {
    }

    public static void trackNTPSync(String str, boolean z, Long l, Long l2, long j, long j2, String str2, String str3, int i, boolean z2) {
    }

    static {
        DLog.m32737d("NTP_STAT_BASE_PERCENT=" + f45713b);
        DLog.m32737d("NTP_LOC_STAT_PERCENT=" + f45714c);
        DLog.m32737d("LOCTIME_MONOTONIC_STAT_PERCENT=" + f45715d);
        DLog.m32737d("LOC_DISPATCH_STAT_PERCENT=" + f45716e);
    }

    public static void trackNTPAndMobileTimeDiff(long j) {
        if (isSampledByPercent(f45713b)) {
            m32744a("mobile", j);
        }
    }

    public static boolean isSampledByPercent(int i) {
        if (i >= 100) {
            return true;
        }
        return i > 0 && f45712a.nextInt(100) < i;
    }

    /* renamed from: a */
    private static boolean m32745a(int i) {
        if (i >= 1000) {
            return true;
        }
        return i > 0 && f45712a.nextInt(1000) < i;
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

    public static void trackNLPOnceRespTime(long j, int i, String str, String str2, String str3) {
        Event event = new Event("tech_map_log_nlp_loc_resp_time");
        event.putAttr("last_time", Long.valueOf(j));
        event.putAttr("page", str2);
        event.putAttr("entrance", str3);
        event.putAttr(BffNetConstant.ERR_CODE, Integer.valueOf(i));
        event.putAttr("errmsg", str);
        OmegaSDKAdapter.trackEvent(event);
    }
}
