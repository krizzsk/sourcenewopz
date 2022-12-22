package com.didi.dimina.container.util;

import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.service.NetworkService;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class HttpUtil {

    /* renamed from: a */
    private static final NetworkService f17941a = Dimina.getConfig().getAdapterConfig().getHttpService();

    public static void downloadString(String str, final IDMCommonAction<String> iDMCommonAction) {
        if (!TextUtils.isEmpty(str)) {
            NetworkService.NetworkTaskModel.Request request = new NetworkService.NetworkTaskModel.Request();
            request.dataType = "text";
            request.url = str;
            f17941a.request(request, new NetworkService.ITaskCallback() {
                public void onFailure(Exception exc) {
                    IDMCommonAction iDMCommonAction = iDMCommonAction;
                    if (iDMCommonAction != null) {
                        iDMCommonAction.callback("");
                    }
                }

                public void onSuccess(JSONObject jSONObject) {
                    String optString = jSONObject.optString("data", "");
                    if (iDMCommonAction == null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        iDMCommonAction.callback(optString);
                    } else {
                        iDMCommonAction.callback("");
                    }
                }
            });
            return;
        }
        throw new AssertionError();
    }

    public static JSONObject parseUrlQueryJSONObject(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : m13395a(str, str2).entrySet()) {
            JSONUtil.put(jSONObject, (String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    public static Map<String, Object> parseQuery(String str) {
        HashMap hashMap = new HashMap();
        for (String split : str.split(ParamKeys.SIGN_AND)) {
            String[] split2 = split.split("=");
            hashMap.put(decode(split2[0]), decode(split2[1]));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, String> m13395a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (str2 == null) {
            return hashMap;
        }
        String trim = str2.trim();
        if (trim.equals("")) {
            return hashMap;
        }
        String[] split = trim.split("\\?");
        if (split.length == 1) {
            return hashMap;
        }
        for (String split2 : split[1].split(ParamKeys.SIGN_AND)) {
            String[] split3 = split2.split("=");
            if (split3.length > 1) {
                hashMap.put(split3[0], split3[1]);
            } else if (split3.length > 0) {
                hashMap.put(split3[0], "");
            }
        }
        return hashMap;
    }

    public static String encode(String str) {
        return URLEncoder.encode(str);
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String splitPath(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("?")) ? str : str.substring(0, str.indexOf("?"));
    }
}
