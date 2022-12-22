package com.didi.unifiedPay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Helper {
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";

    /* renamed from: a */
    private final String f44566a = "5.2.7";

    /* renamed from: b */
    private final String f44567b = "application/json";

    /* renamed from: a */
    private String m31671a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public Iterable<HttpHeader> getHeaders() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimpleHttpHeader(HttpHeaders.CACHE_CONTROL, "no-cache"));
        arrayList.add(new SimpleHttpHeader("Content-Type", "application/json"));
        arrayList.add(new SimpleHttpHeader(HttpHeaders.ACCEPT, AsyncHttpRequest.HEADER_ACCEPT_ALL));
        arrayList.add(new SimpleHttpHeader("DidiCashier-Version", "5.2.7"));
        return arrayList;
    }

    public HttpRpcClient getHttpClient(Context context) {
        return ((HttpRpcClient) new RpcServiceFactory(context).getRpcClient("https")).newBuilder().setHostnameVerifier(m31673a()).build();
    }

    /* renamed from: a */
    private HostnameVerifier m31673a() {
        return new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                if ("https://cashier.didiglobal.com".equals(str)) {
                    return true;
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
    }

    public String createBody(Map<String, String> map, Object obj, Context context) throws IllegalAccessException {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        m31674a(obj, hashMap);
        return m31672a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private String m31672a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String next : keySet) {
            sb.append(next);
            sb.append("=");
            sb.append(m31671a(map.get(next)));
            sb.append(ParamKeys.SIGN_AND);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* renamed from: a */
    private void m31674a(Object obj, Map<String, String> map) throws IllegalAccessException {
        Field[] declaredFields;
        Object obj2;
        if (obj != null && (declaredFields = obj.getClass().getDeclaredFields()) != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                int modifiers = field.getModifiers();
                if (!((modifiers | 16 | 8) == modifiers || (obj2 = field.get(obj)) == null || TextUtils.isEmpty(obj2.toString()))) {
                    map.put(field.getName(), obj2 + "");
                }
            }
        }
    }
}
