package com.didichuxing.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HttpParamUtils {

    /* renamed from: a */
    private static String f49248a = "UTF-8";

    /* renamed from: b */
    private static final String f49249b = "didiwuxiankejiyouxian2013";

    /* renamed from: c */
    private static final String f49250c = "__x_";

    /* renamed from: a */
    private static List<BasicNameValuePair> m35519a(Map<String, Object> map) {
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
    private static List<BasicNameValuePair> m35520b(Map<String, String> map) {
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
        return URLEncodedUtils.format(m35519a(map), f49248a);
    }

    public static String getParamStrStr(Map<String, String> map) {
        return URLEncodedUtils.format(m35520b(map), f49248a);
    }

    public static String getSortedParamsString(Map<String, Object> map) {
        List<BasicNameValuePair> paramList = getParamList(map);
        StringBuilder sb = new StringBuilder(f49249b);
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
        List<BasicNameValuePair> a = m35519a(map);
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
