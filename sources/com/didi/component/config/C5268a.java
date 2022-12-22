package com.didi.component.config;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.component.config.a */
/* compiled from: BusinessConfig */
class C5268a {

    /* renamed from: h */
    private static final String f12619h = "pid";

    /* renamed from: i */
    private static final String f12620i = "bid";

    /* renamed from: j */
    private static final String f12621j = "parent_bid";

    /* renamed from: k */
    private static final String f12622k = "pname";

    /* renamed from: l */
    private static final String f12623l = "bdesc";

    /* renamed from: m */
    private static final String f12624m = "pver";

    /* renamed from: a */
    int f12625a;

    /* renamed from: b */
    String f12626b;

    /* renamed from: c */
    String f12627c;

    /* renamed from: d */
    String f12628d;

    /* renamed from: e */
    String f12629e;

    /* renamed from: f */
    String f12630f;

    /* renamed from: g */
    final SparseArray<PageConfig> f12631g = new SparseArray<>();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo47944a() {
        return true;
    }

    C5268a() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", ");
        sb.append("pname");
        sb.append(":");
        sb.append(this.f12627c);
        sb.append(", ");
        sb.append(f12623l);
        sb.append(":");
        sb.append(this.f12628d);
        sb.append(", ");
        sb.append(f12624m);
        sb.append(":");
        sb.append(this.f12629e);
        for (int i = 0; i < this.f12631g.size(); i++) {
            sb.append("\n\n");
            sb.append(this.f12631g.valueAt(i));
        }
        return sb.toString();
    }

    /* renamed from: a */
    static C5268a m8592a(JSONObject jSONObject) throws JSONException {
        PageConfig a;
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("pid");
        String optString = jSONObject.optString("bid");
        String optString2 = jSONObject.optString("pname");
        C5268a aVar = new C5268a();
        aVar.f12625a = optInt;
        aVar.f12626b = optString;
        aVar.f12630f = jSONObject.optString(f12621j);
        aVar.f12627c = optString2;
        aVar.f12628d = jSONObject.optString(f12623l);
        aVar.f12629e = jSONObject.optString(f12624m);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.isEmpty(next)) {
                throw new JSONException("unknown key: " + next);
            } else if (m8593a(next) && (a = PageConfig.m8588a(next, jSONObject.optJSONArray(next))) != null && a.mo47937a()) {
                aVar.f12631g.put(a.f12614a, a);
            }
        }
        if (aVar.mo47944a()) {
            return aVar;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m8593a(String str) {
        return !TextUtils.isEmpty(str) && !TextUtils.equals(str, "pid") && !TextUtils.equals(str, "bid") && !TextUtils.equals(str, "pname") && !TextUtils.equals(str, f12621j);
    }
}
