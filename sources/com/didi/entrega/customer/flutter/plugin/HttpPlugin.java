package com.didi.entrega.customer.flutter.plugin;

import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.sdk.push.AppId;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class HttpPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/http_plugin", JSONMethodCodec.INSTANCE).setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if (((str.hashCode() == -126777433 && str.equals("http.param")) ? (char) 0 : 65535) == 0) {
            result.success(m14730b());
        }
    }

    /* renamed from: a */
    private JSONObject m14729a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Cityid", LocationUtil.getCityId());
            jSONObject.put("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
            jSONObject.put("app_timeout_ms", AppId.DRIVER);
            jSONObject.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONObject m14730b() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> commonParams = ParamsHelper.getCommonParams();
        commonParams.put("country", LocationUtil.getCountryCode());
        commonParams.put("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        commonParams.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        for (String next : commonParams.keySet()) {
            try {
                jSONObject.put(next, commonParams.get(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static HashMap<String, Object> getFlutterRequestCommonParams() {
        HashMap<String, Object> hashMap = (HashMap) ParamsHelper.getCommonParams();
        hashMap.put("country", LocationUtil.getCountryCode());
        hashMap.put("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        return hashMap;
    }
}
