package com.turbomanage.httpclient;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParameterMap implements Map<String, String> {
    private Map<String, String> map = new HashMap();

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return this.map.entrySet();
    }

    public String get(Object obj) {
        return this.map.get(obj);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public String put(String str, String str2) {
        return this.map.put(str, str2);
    }

    public void putAll(Map<? extends String, ? extends String> map2) {
        this.map.putAll(map2);
    }

    public String remove(Object obj) {
        return this.map.remove(obj);
    }

    public int size() {
        return this.map.size();
    }

    public Collection<String> values() {
        return this.map.values();
    }

    public ParameterMap add(String str, String str2) {
        this.map.put(str, str2);
        return this;
    }

    public ParameterMap addIfNotEmpty(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.map.put(str, str2);
        }
        return this;
    }

    public String urlEncode() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.map.keySet()) {
            if (sb.length() > 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(next);
            String str = this.map.get(next);
            if (str != null) {
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public byte[] urlEncodedBytes() {
        try {
            return urlEncode().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        Set<Map.Entry<String, String>> entrySet = entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : entrySet) {
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            sb.append(";");
        }
        return sb.toString();
    }
}
