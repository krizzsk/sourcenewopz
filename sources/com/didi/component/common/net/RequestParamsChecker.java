package com.didi.component.common.net;

import android.text.TextUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.util.GLog;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.p188io.Streams;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class RequestParamsChecker {

    /* renamed from: a */
    private static final String f11652a = "RequestParamsChecker";

    /* renamed from: b */
    private static HashMap<String, HashMap<String, CheckConfig>> f11653b = null;

    /* renamed from: c */
    private static HashMap<String, HashMap<String, CheckConfig>> f11654c = null;

    /* renamed from: d */
    private static final String f11655d = "global_passenger_request_params_check";

    /* renamed from: e */
    private static final String f11656e = "0";

    /* renamed from: f */
    private static final String f11657f = "null";

    /* renamed from: g */
    private static final String f11658g = "[]";

    /* renamed from: h */
    private static final String f11659h = "{}";

    class CheckConfig {
        @SerializedName("can_be_empty_list")
        boolean canBeEmptyList;
        @SerializedName("can_be_zero")
        boolean canBeZero;

        CheckConfig() {
        }
    }

    RequestParamsChecker() {
    }

    public void checkRequestParams(String str, HttpRpcRequest httpRpcRequest) throws IOException {
        if (m7880a() && f11653b != null && f11654c != null) {
            if (m7883c(str)) {
                m7884d(m7875a(httpRpcRequest));
                return;
            }
            String b = m7881b(str);
            if (b != null) {
                m7879a(b, m7875a(httpRpcRequest));
            }
        }
    }

    /* renamed from: a */
    private static boolean m7880a() {
        return GlobalApolloUtil.getStatus(f11655d);
    }

    /* renamed from: a */
    private static HashMap<String, HashMap<String, CheckConfig>> m7878a(String str) {
        HashMap<String, HashMap<String, CheckConfig>> hashMap = new HashMap<>();
        String str2 = (String) GlobalApolloUtil.getParam(f11655d, str, "");
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        try {
            String[] split = str2.split(";");
            for (String str3 : split) {
                HashMap hashMap2 = (HashMap) new Gson().fromJson((String) GlobalApolloUtil.getParam(f11655d, str3, ""), new TypeToken<HashMap<String, CheckConfig>>() {
                }.getType());
                if (hashMap2 != null) {
                    GLog.m7965d(f11652a, "buildParamsCheckConfigMap path:  " + str3);
                    for (String str4 : hashMap2.keySet()) {
                        GLog.m7965d(f11652a, "buildParamsCheckConfigMap params:  " + str4);
                    }
                    hashMap.put(str3, hashMap2);
                }
            }
        } catch (Exception e) {
            GLog.m7968e(f11652a, "buildParamsCheckConfigMap error" + e.getMessage());
        }
        return hashMap;
    }

    /* renamed from: a */
    private String m7876a(String str, String str2, CheckConfig checkConfig) {
        if ((checkConfig.canBeZero && "0".equals(str2)) || (checkConfig.canBeEmptyList && f11658g.equals(str2))) {
            GLog.m7965d(f11652a, "continue data:" + str);
            return null;
        } else if (!TextUtils.isEmpty(str2) && !"0".equals(str2) && !f11658g.equals(str2) && !"null".equals(str2) && !f11659h.equals(str2)) {
            return null;
        } else {
            GLog.m7965d(f11652a, "errorParams data:" + str);
            return str;
        }
    }

    /* renamed from: a */
    private void m7879a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                HashMap hashMap = f11653b.get(str);
                if (hashMap == null) {
                    return;
                }
                if (hashMap.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str3 : hashMap.keySet()) {
                        Pattern compile = Pattern.compile(ParamKeys.SIGN_AND + str3 + "=(.+?)&");
                        CheckConfig checkConfig = (CheckConfig) hashMap.get(str3);
                        Matcher matcher = compile.matcher(str2);
                        if (checkConfig != null && matcher.find() && matcher.groupCount() >= 1 && m7876a(str3, URLDecoder.decode(matcher.group(1), "UTF-8"), checkConfig) != null) {
                            sb.append(str3 + ";");
                        }
                    }
                    m7882b(str, sb.toString());
                }
            } catch (Exception e) {
                GLog.m7968e(f11652a, "error" + e.getMessage());
            }
        }
    }

    public static void initRequestCheckConfig() {
        if (m7880a()) {
            if (f11653b == null) {
                f11653b = m7878a("api_list");
            }
            if (f11654c == null) {
                f11654c = m7878a("bff_list");
            }
        }
    }

    /* renamed from: b */
    private String m7881b(String str) {
        int lastIndexOf;
        int i;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) >= 0 && (i = lastIndexOf + 1) < str.length()) {
            String substring = str.substring(i);
            if (f11653b.containsKey(substring)) {
                GLog.m7965d(f11652a, "hitApiRequestCheckPath:" + substring);
                return substring;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m7883c(String str) {
        return str.contains("/halo/") || str.contains("/ability/");
    }

    /* renamed from: d */
    private void m7884d(String str) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("abilities") && (optJSONObject = jSONObject.optJSONObject("abilities")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashMap hashMap = f11654c.get(next);
                        if (hashMap != null && hashMap.size() > 0) {
                            GLog.m7965d(f11652a, "ability:" + next);
                            m7882b(next, m7877a(optJSONObject.optJSONObject(next), (HashMap<String, CheckConfig>) hashMap));
                        }
                    }
                }
            } catch (Exception e) {
                GLog.m7969e(f11652a, "error", e);
            }
        }
    }

    /* renamed from: a */
    private String m7877a(JSONObject jSONObject, HashMap<String, CheckConfig> hashMap) {
        StringBuilder sb = new StringBuilder();
        for (String next : hashMap.keySet()) {
            CheckConfig checkConfig = hashMap.get(next);
            if (!(jSONObject == null || !jSONObject.has(next) || m7876a(next, jSONObject.optString(next), checkConfig) == null)) {
                sb.append(next + ";");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m7882b(String str, String str2) {
        GLog.m7971i(f11652a, "trackErrorParams:" + str2);
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("url_flag", str);
            hashMap.put("error_params", str2);
            hashMap.put(ParamConst.TRACE_ID, RidGetterInterceptor.threadLocal.get());
            OmegaSDKAdapter.trackEvent("tech_pax_request_params_error", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private String m7875a(HttpRpcRequest httpRpcRequest) throws IOException {
        HttpEntity entity = httpRpcRequest.getEntity();
        if (entity != null && entity.getContentLength() != 0) {
            return Streams.readFully((Reader) new InputStreamReader(entity.getContent()));
        }
        int indexOf = httpRpcRequest.getUrl().indexOf("?");
        return indexOf >= 0 ? httpRpcRequest.getUrl().substring(indexOf) : "";
    }
}
