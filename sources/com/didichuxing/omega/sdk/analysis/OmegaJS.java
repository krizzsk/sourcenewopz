package com.didichuxing.omega.sdk.analysis;

import android.webkit.JavascriptInterface;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.xiaojuchefu.prism.monitor.PrismConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OmegaJS {
    private static OmegaJS onlyone = new OmegaJS();

    public static OmegaJS getInstance() {
        return onlyone;
    }

    @JavascriptInterface
    public void trackEvent(String str, String str2, String str3) {
        safeTrackH5Event(str, str2, str3, (String) null, false, false);
    }

    @JavascriptInterface
    public void trackEvent(String str, String str2, String str3, String str4) {
        safeTrackH5Event(str, str2, str3, str4, false, false);
    }

    @JavascriptInterface
    public void trackError(String str, String str2) {
        safeTrackH5Event("OMGH5JsError", str, str2, (String) null, false, false);
    }

    @JavascriptInterface
    public void trackError(String str, String str2, String str3) {
        safeTrackH5Event("OMGH5JsError", str, str2, str3, false, false);
    }

    @JavascriptInterface
    public void trackEventWS(String str, String str2, String str3) {
        safeTrackH5Event(str, str2, str3, (String) null, true, false);
    }

    @JavascriptInterface
    public void trackEventWS(String str, String str2, String str3, String str4) {
        safeTrackH5Event(str, str2, str3, str4, true, false);
    }

    @JavascriptInterface
    public String getInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("av", PackageCollector.getVN());
            jSONObject.put("sv", OmegaConfig.SDK_VERSION);
            jSONObject.put("ot", "android");
            jSONObject.put("oid", PersistentInfoCollector.getOmegaId());
        } catch (JSONException e) {
            Tracker.trackGood("OmegaJS.getInfo fail", e);
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void setTelephone(String str) {
        OmegaConfig.phoneNumberFromH5 = str;
    }

    @JavascriptInterface
    public void setUserId(String str) {
        OmegaConfig.userIdFromH5 = str;
    }

    @JavascriptInterface
    public void setCityId(int i) {
        OmegaConfig.cityIdFromH5 = i;
    }

    @JavascriptInterface
    public void trackEventEx(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        boolean z2;
        try {
            Map<String, Object> json2Map = JsonUtil.json2Map(str5);
            boolean z3 = false;
            if (json2Map != null) {
                boolean z4 = json2Map.get("ss") != null && CommonUtil.parseInt(json2Map.get("ss")) == 1;
                if (json2Map.get("nt") != null) {
                    if (CommonUtil.parseInt(json2Map.get("nt")) == 1) {
                        z3 = true;
                    }
                }
                z2 = z4;
                z = z3;
            } else {
                z2 = false;
                z = false;
            }
            safeTrackH5Event(str, str2, str3, str4, z2, z);
        } catch (Throwable th) {
            OLog.m34769w("trackEventEx fail");
            Tracker.trackGood("trackEventEx fail", th);
        }
    }

    private void safeTrackH5Event(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        Event event = new Event(str, str2);
        event.setFrom(PrismConstants.Symbol.f56077H5);
        if (str3 != null && str3.length() > 0) {
            event.putAllAttrs(JsonUtil.json2Map(str3));
        }
        if (str4 != null && str4.length() > 0) {
            event.eventMap().putAll(JsonUtil.json2Map(str4));
        }
        if (z2) {
            event.putNetType();
        }
        Tracker.trackEvent(event);
    }
}
