package com.cardinalcommerce.p060a;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setLinksClickable */
public final class setLinksClickable {

    /* renamed from: g */
    private static int f2866g = 0;

    /* renamed from: h */
    private static int f2867h = 1;

    /* renamed from: a */
    String f2868a;

    /* renamed from: b */
    String f2869b;

    /* renamed from: c */
    String f2870c;

    /* renamed from: d */
    String f2871d;

    /* renamed from: e */
    String f2872e;

    /* renamed from: f */
    boolean f2873f;

    public final JSONObject getInstance() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        try {
            char c = 5;
            if (!this.f2873f) {
                jSONObject.put("event", this.f2871d);
                int i = f2866g;
                int i2 = ((((i ^ 43) | (i & 43)) << 1) - (~(-(((~i) & 43) | (i & -44))))) - 1;
                f2867h = i2 % 128;
                int i3 = i2 % 2;
            } else {
                int i4 = f2867h;
                int i5 = i4 ^ 59;
                int i6 = -(-((i4 & 59) << 1));
                int i7 = (i5 & i6) + (i6 | i5);
                f2866g = i7 % 128;
                if ((i7 % 2 != 0 ? '#' : 'K') != '#') {
                    jSONObject.put("error", this.f2872e);
                } else {
                    jSONObject.put("error", this.f2872e);
                    super.hashCode();
                }
                int i8 = f2866g;
                int i9 = (i8 ^ 5) + ((i8 & 5) << 1);
                f2867h = i9 % 128;
                int i10 = i9 % 2;
            }
            jSONObject.put("detail", this.f2868a);
            jSONObject.put("timestamp", this.f2870c);
            int i11 = (((f2867h + 21) - 1) - 0) - 1;
            f2866g = i11 % 128;
            int i12 = i11 % 2;
            int i13 = f2866g;
            int i14 = i13 | 29;
            int i15 = i14 << 1;
            int i16 = -((~(i13 & 29)) & i14);
            int i17 = (i15 ^ i16) + ((i16 & i15) << 1);
            f2867h = i17 % 128;
            if (i17 % 2 == 0) {
                c = 'E';
            }
            if (c == 'E') {
                super.hashCode();
            }
            return jSONObject;
        } catch (JSONException unused) {
            return jSONObject2;
        }
    }
}
