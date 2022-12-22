package com.cardinalcommerce.p060a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.k */
final class C2018k {

    /* renamed from: g */
    private static int f2599g = 0;

    /* renamed from: h */
    private static int f2600h = 1;

    /* renamed from: a */
    String f2601a;

    /* renamed from: b */
    JSONArray f2602b;

    /* renamed from: c */
    private String f2603c;

    /* renamed from: d */
    private String f2604d;

    /* renamed from: e */
    private String f2605e;

    /* renamed from: f */
    private String f2606f;

    C2018k(String str, String str2, String str3) {
        this.f2603c = "CardinalMobileSdk_Android";
        this.f2604d = "2.2.7-2";
        this.f2605e = str;
        this.f2606f = str2;
        this.f2602b = new JSONArray();
        this.f2601a = str3;
    }

    public C2018k(JSONObject jSONObject) throws JSONException {
        this.f2603c = jSONObject.getString("application");
        this.f2604d = jSONObject.getString("version");
        this.f2605e = jSONObject.getString("identifier");
        this.f2606f = jSONObject.getString("mutator");
        if (jSONObject.has("data")) {
            this.f2602b = jSONObject.getJSONArray("data");
        } else {
            this.f2602b = new JSONArray();
        }
        if (jSONObject.has("sessionid")) {
            this.f2601a = jSONObject.getString("sessionid");
        }
    }

    /* renamed from: a */
    public final JSONObject mo18277a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("application", this.f2603c);
            jSONObject.put("version", this.f2604d);
            jSONObject.put("identifier", this.f2605e);
            jSONObject.put("mutator", this.f2606f);
            jSONObject.put("data", this.f2602b);
            boolean z = true;
            if ((this.f2601a != null ? (char) 26 : 8) == 26) {
                int i = f2600h;
                int i2 = i & 19;
                int i3 = (i | 19) & (~i2);
                int i4 = -(-(i2 << 1));
                int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
                f2599g = i5 % 128;
                int i6 = i5 % 2;
                jSONObject.put("sessionid", this.f2601a);
                int i7 = ((f2600h + 124) - 0) - 1;
                f2599g = i7 % 128;
                int i8 = i7 % 2;
            }
            int i9 = (f2599g + 12) - 1;
            f2600h = i9 % 128;
            int i10 = i9 % 2;
            int i11 = f2599g;
            int i12 = i11 & 59;
            int i13 = i11 | 59;
            int i14 = (i12 ^ i13) + ((i13 & i12) << 1);
            f2600h = i14 % 128;
            int i15 = i14 % 2;
            int i16 = f2599g;
            int i17 = i16 & 75;
            int i18 = -(-(i16 | 75));
            int i19 = ((i17 | i18) << 1) - (i18 ^ i17);
            f2600h = i19 % 128;
            if (i19 % 2 != 0) {
                z = false;
            }
            if (!z) {
                return jSONObject;
            }
            int i20 = 21 / 0;
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
