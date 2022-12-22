package com.didi.payment.base.tracker;

import android.util.Log;
import com.didi.payment.base.utils.PayLogUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.Map;

public class ErrorEvent {

    /* renamed from: a */
    private String f29964a;

    /* renamed from: b */
    private String f29965b;

    /* renamed from: c */
    private String f29966c;

    /* renamed from: d */
    private Map<String, Object> f29967d = new HashMap();

    protected ErrorEvent(String str, String str2, String str3) {
        this.f29964a = str;
        this.f29965b = str2;
        this.f29966c = str3;
    }

    public ErrorEvent module(String str) {
        return attr("pmn", (Object) str);
    }

    public ErrorEvent attr(String str, Object obj) {
        if (!(str == null || obj == null)) {
            this.f29967d.put(str, obj);
        }
        return this;
    }

    public ErrorEvent attr(String str, boolean z) {
        this.f29967d.put(str, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public ErrorEvent attrs(Map<String, Object> map) {
        if (map != null) {
            this.f29967d.putAll(map);
        }
        return this;
    }

    public ErrorEvent exception(Exception exc) {
        this.f29966c = Log.getStackTraceString(exc);
        return this;
    }

    public void track() {
        if (!OmegaConfig.IS_INIT) {
            PayLogUtils.m21021w("PayBase", "PayTracker", "Omega not init.");
        }
        FinOmegaSDK.trackError("Pay", this.f29964a, this.f29965b, this.f29966c, this.f29967d);
    }
}
