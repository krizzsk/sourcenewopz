package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Multimap extends LinkedHashMap<String, List<String>> implements Iterable<NameValuePair> {
    public static final StringDecoder QUERY_DECODER = new StringDecoder() {
        public String decode(String str) {
            return Uri.decode(str);
        }
    };
    public static final StringDecoder URL_DECODER = new StringDecoder() {
        public String decode(String str) {
            return URLDecoder.decode(str);
        }
    };

    public interface StringDecoder {
        String decode(String str);
    }

    public Multimap() {
    }

    /* access modifiers changed from: protected */
    public List<String> newList() {
        return new ArrayList();
    }

    public String getString(String str) {
        List list = (List) get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) list.get(0);
    }

    public String getAllString(String str, String str2) {
        List<String> list = (List) get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str3 : list) {
            if (!z) {
                sb.append(str2);
            }
            sb.append(str3);
            z = false;
        }
        return sb.toString();
    }

    public List<String> ensure(String str) {
        List<String> list = (List) get(str);
        if (list != null) {
            return list;
        }
        List<String> newList = newList();
        put(str, newList);
        return newList;
    }

    public void add(String str, String str2) {
        ensure(str).add(str2);
    }

    public void put(String str, String str2) {
        List<String> newList = newList();
        newList.add(str2);
        put(str, newList);
    }

    public Multimap(List<NameValuePair> list) {
        for (NameValuePair next : list) {
            add(next.getName(), next.getValue());
        }
    }

    public Multimap(Multimap multimap) {
        putAll(multimap);
    }

    public static Multimap parse(String str, String str2, boolean z, StringDecoder stringDecoder) {
        return parse(str, str2, "=", z, stringDecoder);
    }

    public static Multimap parse(String str, String str2, String str3, boolean z, StringDecoder stringDecoder) {
        Multimap multimap = new Multimap();
        if (str == null) {
            return multimap;
        }
        for (String split : str.split(str2)) {
            String[] split2 = split.split(str3, 2);
            String trim = split2[0].trim();
            if (!TextUtils.isEmpty(trim)) {
                String str4 = null;
                if (split2.length > 1) {
                    str4 = split2[1];
                }
                if (str4 != null && z && str4.endsWith(Const.jsQuote) && str4.startsWith(Const.jsQuote)) {
                    str4 = str4.substring(1, str4.length() - 1);
                }
                if (!(str4 == null || stringDecoder == null)) {
                    trim = stringDecoder.decode(trim);
                    str4 = stringDecoder.decode(str4);
                }
                multimap.add(trim, str4);
            }
        }
        return multimap;
    }

    public static Multimap parseSemicolonDelimited(String str) {
        return parse(str, ";", true, (StringDecoder) null);
    }

    public static Multimap parseCommaDelimited(String str) {
        return parse(str, ",", true, (StringDecoder) null);
    }

    public static Multimap parseQuery(String str) {
        return parse(str, ParamKeys.SIGN_AND, false, QUERY_DECODER);
    }

    public static Multimap parseUrlEncoded(String str) {
        return parse(str, ParamKeys.SIGN_AND, false, URL_DECODER);
    }

    public Iterator<NameValuePair> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            for (String basicNameValuePair : (List) get(str)) {
                arrayList.add(new BasicNameValuePair(str, basicNameValuePair));
            }
        }
        return arrayList.iterator();
    }

    public Map<String, String> toSingleMap() {
        HashMap hashMap = new HashMap();
        for (String str : keySet()) {
            hashMap.put(str, getString(str));
        }
        return hashMap;
    }
}
