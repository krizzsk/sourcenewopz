package com.jumio.core.util;

import android.os.Build;
import com.jumio.core.environment.Environment;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jumio.core.util.a */
/* compiled from: DeviceDetails */
public class C20013a {
    /* renamed from: a */
    public static JSONObject m39638a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk-platform", "Android");
        jSONObject.put("sdk-version", Environment.LEGACY_VERSION);
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("software-version", Build.VERSION.RELEASE);
        jSONObject.put("software-build-number", Build.DISPLAY);
        jSONObject.put("kernel-version", System.getProperty("os.version"));
        return jSONObject;
    }
}
