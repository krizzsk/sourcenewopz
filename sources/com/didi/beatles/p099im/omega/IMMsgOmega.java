package com.didi.beatles.p099im.omega;

import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.beatles.p099im.IMContextInfoHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.omega.IMMsgOmega */
public class IMMsgOmega {

    /* renamed from: a */
    private static IMMsgOmega f9347a;

    /* renamed from: b */
    private long f9348b;

    /* renamed from: c */
    private int f9349c;

    /* renamed from: d */
    private String f9350d;

    public static IMMsgOmega getInstance() {
        if (f9347a == null) {
            f9347a = new IMMsgOmega();
        }
        return f9347a;
    }

    private IMMsgOmega() {
        if (IMContextInfoHelper.getContext() != null) {
            this.f9350d = IMContextInfoHelper.getContext().getPackageName();
        }
    }

    public void init(long j, int i) {
        this.f9348b = j;
        this.f9349c = i;
    }

    public void trackMoreBtn(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("op", str);
        track("ddim_xq_all_more_ck", hashMap);
    }

    public void track(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("uid", Long.valueOf(this.f9348b));
        map.put(InternalLogsFeature.ENV_NAME, Integer.valueOf(this.f9349c));
        map.put("app", this.f9350d);
        OmegaUtil.trackIMEvent(str, map);
    }

    public void destory() {
        this.f9350d = null;
        f9347a = null;
    }
}
