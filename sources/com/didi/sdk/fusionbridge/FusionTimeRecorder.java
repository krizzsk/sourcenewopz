package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.net.Uri;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.util.C10393Util;
import com.didi.onehybrid.util.NetworkUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class FusionTimeRecorder {

    /* renamed from: a */
    private static final String f35950a = "tone_p_x_fusion_render_from_native";

    /* renamed from: b */
    private static final String f35951b = "page_url";

    /* renamed from: c */
    private static final String f35952c = "fusion_optimize";

    /* renamed from: d */
    private static final String f35953d = "cache_count";

    /* renamed from: e */
    private static final String f35954e = "nt_type";

    /* renamed from: f */
    private static final String f35955f = "is_debug";

    /* renamed from: g */
    private static final String f35956g = "webview_init_time";

    /* renamed from: h */
    private static final String f35957h = "first_h5_time";

    /* renamed from: i */
    private static final String f35958i = "render_time";

    /* renamed from: j */
    private static final String f35959j = "total_time";

    /* renamed from: k */
    private final String f35960k;

    /* renamed from: l */
    private final boolean f35961l;

    /* renamed from: m */
    private long f35962m = -1;

    /* renamed from: n */
    private long f35963n = -1;

    /* renamed from: o */
    private long f35964o = -1;

    /* renamed from: p */
    private long f35965p = -1;

    /* renamed from: q */
    private int f35966q = 0;

    /* renamed from: r */
    private boolean f35967r = false;

    public FusionTimeRecorder(String str, boolean z) {
        this.f35960k = str;
        this.f35961l = z;
    }

    public void activityStarted() {
        this.f35962m = System.currentTimeMillis();
    }

    public void beginLoadUrl() {
        this.f35963n = System.currentTimeMillis();
    }

    public void pageStarted() {
        this.f35964o = System.currentTimeMillis();
    }

    public void pageFinished() {
        this.f35965p = System.currentTimeMillis();
    }

    public void setFromCache(Uri uri, boolean z) {
        if (uri != null && z) {
            this.f35966q++;
        }
    }

    public void flush(Context context) {
        if (!this.f35967r && this.f35962m != -1 && this.f35964o != -1 && this.f35965p != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put(f35951b, this.f35960k);
            hashMap.put(f35952c, Integer.valueOf((!this.f35961l || (!FusionEngine.isWebViewPreInited() && this.f35966q <= 0)) ? 0 : 1));
            hashMap.put(f35953d, Integer.valueOf(this.f35966q));
            hashMap.put(f35954e, Integer.valueOf(NetworkUtil.getSimpleNetworkType(context)));
            hashMap.put(f35955f, Integer.valueOf(Utils.isDebug(context) ? 1 : 0));
            hashMap.put(f35956g, Long.valueOf(this.f35963n - this.f35962m));
            hashMap.put(f35957h, Long.valueOf(this.f35964o - this.f35963n));
            hashMap.put(f35958i, Long.valueOf(this.f35965p - this.f35964o));
            hashMap.put("total_time", Long.valueOf(this.f35965p - this.f35962m));
            if (C10393Util.isApkDebug(context)) {
                SystemUtils.log(4, "FusionTime", hashMap.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.FusionTimeRecorder", 116);
            }
            OmegaSDKAdapter.trackEvent("tone_p_x_fusion_render_from_native", (Map<String, Object>) hashMap);
            this.f35967r = true;
        }
    }
}
