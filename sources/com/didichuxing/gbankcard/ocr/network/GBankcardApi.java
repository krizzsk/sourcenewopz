package com.didichuxing.gbankcard.ocr.network;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.AppUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.gbankcard.ocr.BuildConfig;
import com.didichuxing.gbankcard.ocr.network.data.GuideResp;
import java.util.Map;
import org.json.JSONObject;

public class GBankcardApi {
    public static final String KEY_CLIENT_DEVICE_INFO = "clientDeviceInfo";

    /* renamed from: c */
    private static final String f47709c = "extra";

    /* renamed from: d */
    private static final String f47710d = "https://api-sec.didiglobal.com/sec/risk-gateway/common/";

    /* renamed from: e */
    private static GBankcardApi f47711e = new GBankcardApi();

    /* renamed from: a */
    private JSONObject f47712a = new JSONObject();

    /* renamed from: b */
    private String f47713b;

    private GBankcardApi() {
    }

    public static GBankcardApi getInstance() {
        return f47711e;
    }

    public void buildClientDeviceInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pac", context.getPackageName());
            jSONObject.put("appVer", AppUtils.getVersionName(context));
            jSONObject.put("sdkVer", BuildConfig.VERSION_NAME);
            jSONObject.put("clientOS", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", SystemUtil.getModel());
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        this.f47713b = jSONObject.toString();
    }

    public void addExtraInfo(String str, Object obj) {
        try {
            this.f47712a.put(str, obj);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public String getClientDeviceInfo() {
        return this.f47713b;
    }

    public void requestGuideInfo(String str, Map<String, Object> map, AbsOkHttpCallback<GuideResp> absOkHttpCallback) {
        CheckUtils.checkAssert(!map.containsKey("extra"), "biz params should not contain 'extra' key!!!");
        map.put(KEY_CLIENT_DEVICE_INFO, this.f47713b);
        map.put("extra", this.f47712a.toString());
        DFApi.postReq(m34165a(str), map, absOkHttpCallback);
    }

    /* renamed from: a */
    private String m34165a(String str) {
        return f47710d + str;
    }

    public void reportSdkData(String str, String str2, AbsOkHttpCallback<BaseInnerResult> absOkHttpCallback) {
        DFApi.postNew(m34165a(str), str2, absOkHttpCallback);
    }
}
