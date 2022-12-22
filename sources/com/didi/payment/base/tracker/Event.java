package com.didi.payment.base.tracker;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.Map;

public class Event {

    /* renamed from: a */
    private String f29968a;

    /* renamed from: b */
    private Map<String, Object> f29969b;

    protected Event(String str) {
        this.f29968a = str;
    }

    /* renamed from: a */
    private void m21000a() {
        if (this.f29969b == null) {
            this.f29969b = new HashMap();
        }
    }

    public Event module(String str) {
        return attr("pmn", (Object) str);
    }

    public Event subEvent(String str) {
        return attr("se", (Object) str);
    }

    public Event attr(String str, Object obj) {
        m21000a();
        if (!(str == null || obj == null)) {
            this.f29969b.put(str, obj);
        }
        return this;
    }

    public Event attr(String str, boolean z) {
        m21000a();
        this.f29969b.put(str, Integer.valueOf(z ? 1 : 0));
        return this;
    }

    public Event attrs(Map<String, Object> map) {
        m21000a();
        if (map != null) {
            this.f29969b.putAll(map);
        }
        return this;
    }

    public void track() {
        if (!TextUtils.isEmpty(this.f29968a)) {
            boolean z = OmegaConfig.IS_INIT;
            FinOmegaSDK.trackEvent(this.f29968a, this.f29969b);
        }
    }
}
