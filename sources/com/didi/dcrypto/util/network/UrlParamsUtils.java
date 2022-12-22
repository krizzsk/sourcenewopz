package com.didi.dcrypto.util.network;

import android.content.Context;
import com.didi.unifylogin.store.LoginStore;
import java.util.HashMap;
import java.util.Map;

public class UrlParamsUtils {

    /* renamed from: a */
    private static final String f16520a = "&";

    /* renamed from: b */
    private static final String f16521b = "=";

    public static String getBasicUrlParams(Context context) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : m12131a(context).entrySet()) {
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            sb.append("&");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static Map<String, String> m12131a(Context context) {
        String str;
        String str2;
        Object obj = null;
        Object obj2 = CommonProxyHolder.getProxy() == null ? null : CommonProxyHolder.getProxy().getBaseParams(context).get("city_id");
        if (obj2 == null) {
            str = "null";
        } else {
            str = (String) obj2;
        }
        if (CommonProxyHolder.getProxy() != null) {
            obj = CommonProxyHolder.getProxy().getBaseParams(context).get("lang");
        }
        if (obj2 == null) {
            str2 = "zh-CN";
        } else {
            str2 = (String) obj;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", str);
        hashMap.put("dviceid", "2");
        hashMap.put("imei", "3");
        hashMap.put("lang", str2);
        hashMap.put("lat", "4");
        hashMap.put("lng", "5");
        hashMap.put("location_country", "BR");
        hashMap.put("uid", String.valueOf(LoginStore.getInstance().getUid()));
        hashMap.put("utc_offset", "8");
        hashMap.put("activity_id", "20220418");
        return hashMap;
    }
}
