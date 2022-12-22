package com.jumio.analytics;

import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jumio.analytics.b */
/* compiled from: Payload.kt */
public final class C19938b<T> implements Serializable {

    /* renamed from: a */
    public final T f54535a;

    /* renamed from: b */
    public final MetaInfo f54536b;

    public C19938b(T t, MetaInfo metaInfo) {
        this.f54535a = t;
        this.f54536b = metaInfo;
    }

    /* renamed from: a */
    public final MetaInfo mo162352a() {
        return this.f54536b;
    }

    /* renamed from: b */
    public final T mo162353b() {
        return this.f54535a;
    }

    /* renamed from: c */
    public final JSONObject mo162354c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        T t = this.f54535a;
        if (t instanceof Map) {
            T t2 = this.f54535a;
            if (t2 != null) {
                t = new JSONObject((Map) t2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        }
        jSONObject.put("value", t);
        MetaInfo metaInfo = this.f54536b;
        if (!(metaInfo == null || metaInfo.size() == 0)) {
            jSONObject.put("metainfo", new JSONObject(metaInfo));
        }
        return jSONObject;
    }
}
