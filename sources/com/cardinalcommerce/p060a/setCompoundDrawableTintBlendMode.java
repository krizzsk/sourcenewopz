package com.cardinalcommerce.p060a;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setCompoundDrawableTintBlendMode */
public final class setCompoundDrawableTintBlendMode implements Runnable {

    /* renamed from: a */
    private static int f2743a = 0;

    /* renamed from: b */
    private static int f2744b = 1;
    public char[] getInstance;
    public char[] init;

    public setCompoundDrawableTintBlendMode(Location location) {
        this.init = setHorizontallyScrolling.getInstance(String.valueOf(location.getLatitude()));
        this.getInstance = setHorizontallyScrolling.getInstance(String.valueOf(location.getLongitude()));
    }

    public setCompoundDrawableTintBlendMode() {
    }

    public final JSONObject init() {
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            jSONObject.putOpt("Latitude", setHorizontallyScrolling.configure(this.init));
            jSONObject.putOpt("Longitude", setHorizontallyScrolling.configure(this.getInstance));
            int i = f2743a;
            int i2 = (i | 105) << 1;
            int i3 = -(i ^ 105);
            int i4 = (i2 & i3) + (i3 | i2);
            f2744b = i4 % 128;
            int i5 = i4 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), str);
        }
        boolean z = false;
        int i6 = ((f2744b + 4) - 0) - 1;
        f2743a = i6 % 128;
        if (i6 % 2 == 0) {
            z = true;
        }
        if (z) {
            return jSONObject;
        }
        super.hashCode();
        return jSONObject;
    }

    public final void run() {
        int i = f2743a;
        int i2 = ((i ^ 55) | (i & 55)) << 1;
        int i3 = -(((~i) & 55) | (i & -56));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2744b = i4 % 128;
        if (!(i4 % 2 != 0)) {
            setHorizontallyScrolling.getInstance(this.init);
            setHorizontallyScrolling.getInstance(this.getInstance);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            setHorizontallyScrolling.getInstance(this.init);
            setHorizontallyScrolling.getInstance(this.getInstance);
        }
        int i5 = f2743a;
        int i6 = (((i5 | 53) << 1) - (~(-(((~i5) & 53) | (i5 & -54))))) - 1;
        f2744b = i6 % 128;
        if (!(i6 % 2 != 0)) {
            int i7 = 88 / 0;
        }
    }
}
