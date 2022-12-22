package com.didi.payment.base.net.impl;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpHelper {
    public static SSLSocketFactory getSSLSocketFactory() {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            return instance.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Iterable<HttpHeader> getHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new SimpleHttpHeader((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }

    public static String getCompleteUrl(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            sb.append(ParamKeys.SIGN_AND);
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(next.getValue());
        }
        if (sb.length() <= 0) {
            return str;
        }
        if (str.contains("?")) {
            return str + sb.toString();
        }
        return str + "?" + sb.substring(1);
    }

    public static HttpBody getHttpBody(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String next : keySet) {
            sb.append(next);
            sb.append("=");
            sb.append(m20984a(map.get(next).toString()));
            sb.append(ParamKeys.SIGN_AND);
        }
        sb.deleteCharAt(sb.length() - 1);
        return HttpBody.newInstance("application/x-www-form-urlencoded", sb.toString());
    }

    /* renamed from: a */
    private static String m20984a(String str) {
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
}
