package com.didichuxing.foundation.net.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class HttpHeaders {

    /* renamed from: a */
    private static final Comparator<String> f47573a = new Comparator<String>() {
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };

    public static Map<String, List<String>> getHeaders(HttpMessage httpMessage) {
        TreeMap treeMap = new TreeMap(f47573a);
        for (HttpHeader next : httpMessage.getHeaders()) {
            String name = next.getName();
            String value = next.getValue();
            List arrayList = treeMap.containsKey(name) ? (List) treeMap.get(name) : new ArrayList();
            arrayList.add(value);
            treeMap.put(name, arrayList);
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static long getContentLength(HttpMessage httpMessage) {
        String header = httpMessage.getHeader(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
        if (header == null) {
            return -1;
        }
        try {
            return Long.parseLong(header);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static HttpHeader parse(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf >= 1 && indexOf != str.length() - 1) {
            return new SimpleHttpHeader(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
        }
        throw new IllegalArgumentException("Malformed HTTP header");
    }

    private HttpHeaders() {
    }
}
