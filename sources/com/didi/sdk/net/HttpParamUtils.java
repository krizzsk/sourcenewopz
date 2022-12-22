package com.didi.sdk.net;

import com.didi.sdk.message.BasicNameValuePair;
import com.didi.sdk.util.URLEncodedUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HttpParamUtils {

    /* renamed from: a */
    private static String f36849a = "UTF-8";

    /* renamed from: b */
    private static final String f36850b = "didiwuxiankejiyouxian2013";

    /* renamed from: c */
    private static final String f36851c = "__x_";

    /* renamed from: a */
    private static List<BasicNameValuePair> m26102a(Map<String, Object> map) {
        String str;
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (!(value instanceof String)) {
                str = String.valueOf(value);
            } else {
                str = (String) value;
            }
            linkedList.add(new BasicNameValuePair((String) next.getKey(), str));
        }
        return linkedList;
    }

    /* renamed from: b */
    private static List<BasicNameValuePair> m26103b(Map<String, String> map) {
        String str;
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (!(value instanceof String)) {
                str = String.valueOf(value);
            } else {
                str = (String) value;
            }
            linkedList.add(new BasicNameValuePair((String) next.getKey(), str));
        }
        return linkedList;
    }

    public static String getParamString(Map<String, Object> map) {
        return URLEncodedUtils.format(m26102a(map), f36849a);
    }

    public static String getParamStrStr(Map<String, String> map) {
        return URLEncodedUtils.format(m26103b(map), f36849a);
    }

    public static String getSortedParamsString(Map<String, Object> map) {
        List<BasicNameValuePair> paramList = getParamList(map);
        StringBuilder sb = new StringBuilder(f36850b);
        for (BasicNameValuePair next : paramList) {
            if (!next.getName().startsWith("__x_")) {
                sb.append(next.getName());
                sb.append(next.getValue());
            }
        }
        return sb.toString();
    }

    public static String getSortedParamsTrimValue(Map<String, Object> map, String str) {
        List<BasicNameValuePair> paramList = getParamList(map);
        StringBuilder sb = new StringBuilder(str);
        for (BasicNameValuePair next : paramList) {
            sb.append(next.getName());
            sb.append(next.getValue().trim());
        }
        return sb.toString();
    }

    public static List<BasicNameValuePair> getParamList(Map<String, Object> map) {
        List<BasicNameValuePair> a = m26102a(map);
        Collections.sort(a, new KVPairComparator());
        return a;
    }

    private static class KVPairComparator implements Comparator<BasicNameValuePair> {
        private KVPairComparator() {
        }

        public int compare(BasicNameValuePair basicNameValuePair, BasicNameValuePair basicNameValuePair2) {
            return basicNameValuePair.getName().compareTo(basicNameValuePair2.getName());
        }
    }
}
