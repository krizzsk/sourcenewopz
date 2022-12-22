package com.cardinalcommerce.p060a;

import android.os.Build;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setTextSelectHandleLeft */
public final class setTextSelectHandleLeft implements Serializable {
    private static int CardinalEnvironment = 1;
    private static char[] getWarnings = setHorizontallyScrolling.getInstance("Android");
    private static int valueOf;
    public char[] Cardinal = setHorizontallyScrolling.getInstance(Build.VERSION.RELEASE);
    public char[] CardinalError = setHorizontallyScrolling.getInstance(Build.VERSION.INCREMENTAL);
    public char[] cca_continue = ((char[]) getWarnings.clone());
    public int cleanup;
    public char[] configure = setHorizontallyScrolling.getInstance(Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName());
    public char[] getInstance = setHorizontallyScrolling.getInstance(Build.VERSION.CODENAME);
    public int getSDKVersion;
    public char[] init = setHorizontallyScrolling.getInstance(String.valueOf(Build.VERSION.SDK_INT));
    public char[] values;

    static {
        int i = CardinalEnvironment;
        int i2 = i & 31;
        int i3 = ((i ^ 31) | i2) << 1;
        int i4 = -((i | 31) & (~i2));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        valueOf = i5 % 128;
        if ((i5 % 2 != 0 ? ':' : '!') == ':') {
            Object obj = null;
            super.hashCode();
        }
    }

    setTextSelectHandleLeft() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.cleanup = Build.VERSION.PREVIEW_SDK_INT;
        }
        this.getSDKVersion = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 23) {
            this.values = setHorizontallyScrolling.getInstance(Build.VERSION.SECURITY_PATCH);
        }
    }

    public final JSONObject getInstance() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ApiVersion", setHorizontallyScrolling.configure(this.init));
            jSONObject.putOpt("CodeName", setHorizontallyScrolling.configure(this.getInstance));
            jSONObject.putOpt("Incremental", setHorizontallyScrolling.configure(this.CardinalError));
            jSONObject.putOpt("OsName", setHorizontallyScrolling.configure(this.configure));
            jSONObject.putOpt("PreviewSdkInt", Integer.valueOf(this.cleanup));
            jSONObject.putOpt("SdkInt", Integer.valueOf(this.getSDKVersion));
            jSONObject.putOpt("SecurityPatch", setHorizontallyScrolling.configure(this.values));
            jSONObject.putOpt("Type", setHorizontallyScrolling.configure(this.cca_continue));
            jSONObject.putOpt("Version", setHorizontallyScrolling.configure(this.Cardinal));
            int i = CardinalEnvironment;
            int i2 = i ^ 87;
            int i3 = -(-((i & 87) << 1));
            int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
            valueOf = i4 % 128;
            int i5 = i4 % 2;
        } catch (JSONException e) {
            setTextMetricsParams.getSDKVersion().configure("13101", e.getLocalizedMessage(), (String) null);
        }
        int i6 = CardinalEnvironment + 46;
        int i7 = ((i6 | -1) << 1) - (i6 ^ -1);
        valueOf = i7 % 128;
        int i8 = i7 % 2;
        return jSONObject;
    }
}
