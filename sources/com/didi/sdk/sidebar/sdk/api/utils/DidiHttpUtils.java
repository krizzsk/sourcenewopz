package com.didi.sdk.sidebar.sdk.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DidiHttpUtils {
    public static String getSortedUrlParamsString(Map<String, String> map) {
        List<Pair<String, String>> a = m26603a(map);
        Collections.sort(a, new KVPairComparator());
        StringBuilder sb = new StringBuilder();
        for (Pair next : a) {
            if (!((String) next.first).startsWith("__x_")) {
                String encode = TextUtil.encode((String) next.first);
                String str = (String) next.second;
                if (!TextUtils.isEmpty(str)) {
                    String encode2 = TextUtil.encode(str);
                    if (sb.length() > 0) {
                        sb.append(ParamKeys.SIGN_AND);
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static List<Pair<String, String>> m26603a(Map<String, String> map) {
        LinkedList linkedList = new LinkedList();
        if (!(map == null || map.size() == 0)) {
            for (String next : map.keySet()) {
                linkedList.add(new Pair(next, map.get(next)));
            }
        }
        return linkedList;
    }

    public static String link(String str, HashMap<String, Object> hashMap) {
        if (hashMap == null || TextUtils.isEmpty(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : hashMap.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), next.getValue() == null ? "" : next.getValue().toString());
        }
        return buildUpon.toString();
    }

    static class KVPairComparator implements Comparator<Pair<String, String>> {
        KVPairComparator() {
        }

        public int compare(Pair<String, String> pair, Pair<String, String> pair2) {
            return ((String) pair.first).compareTo((String) pair2.first);
        }
    }
}
