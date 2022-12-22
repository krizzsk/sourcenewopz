package com.didichuxing.dfbasesdk.utils;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.diface.utils.http.BaseResult;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpParamUtils {

    /* renamed from: a */
    private static final String f46738a = "24D79B596E78937529CF7B2E37CF51684B4F2C3F";

    /* renamed from: b */
    private static final String f46739b = "4D145C6FA84E38099E49930D9D5B4B73D0C2317D";

    /* renamed from: a */
    private static String m33557a() {
        return DFAppConfig.getInstance().isDebug() ? f46739b : f46738a;
    }

    public static String getSign(TreeMap<String, Object> treeMap) {
        if (treeMap == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Object>> it = treeMap.entrySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String str = ParamKeys.SIGN_AND;
            if (hasNext) {
                Map.Entry next = it.next();
                Object value = next.getValue();
                if (value != null && !(value instanceof byte[]) && !(value instanceof File)) {
                    if (sb.length() == 0) {
                        str = "";
                    }
                    sb.append(str);
                    sb.append((String) next.getKey());
                    sb.append(value);
                }
            } else {
                sb.append(str);
                sb.append(m33557a());
                return m33558a(sb.toString()).toUpperCase();
            }
        }
    }

    /* renamed from: a */
    private static String m33558a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Map<String, Object> getQueryParam(String str) {
        HashMap hashMap = new HashMap();
        String sign = getSign(convertObj2Map(str));
        hashMap.put("apiVersion", "1.0.0");
        hashMap.put("appKey", "190001");
        hashMap.put("sign", sign);
        return hashMap;
    }

    public static Map<String, Object> getQueryParam(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", str2);
        String sign = getSign(convertObj2Map(str));
        hashMap.put("apiVersion", "1.0.0");
        hashMap.put("appKey", "190001");
        hashMap.put("sign", sign);
        return hashMap;
    }

    public static TreeMap<String, Object> convertObj2Map(String str) {
        if (str == null) {
            return null;
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.opt(next));
            }
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
        return treeMap;
    }

    public static <T extends BaseResult> void successCallbackSwitch(AbsHttpCallback<T> absHttpCallback, T t) {
        if (t == null || t.apiCode != 200) {
            absHttpCallback.onFailed(2, "server error");
        } else {
            absHttpCallback.onSuccess(t);
        }
    }

    public static <T extends BaseResult> void failedCallbackSwitch(AbsHttpCallback<T> absHttpCallback, IOException iOException) {
        absHttpCallback.onFailed(1, iOException.getMessage());
    }
}
