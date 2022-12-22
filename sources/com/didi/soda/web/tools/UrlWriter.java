package com.didi.soda.web.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.onehybrid.util.C10393Util;
import com.didi.soda.web.WebInitializer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class UrlWriter {
    public static boolean isUrlValid(String str) {
        try {
            if (TextUtils.isEmpty(new URI(str).getHost())) {
                return false;
            }
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isInHostList(String str, List<String> list) {
        if (C10393Util.isApkDebug(WebInitializer.getInitializer().mApplication)) {
            return true;
        }
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            if (!str.startsWith("http")) {
                str = "http://" + str;
            }
            try {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    return false;
                }
                String str2 = "." + host.toLowerCase();
                for (String lowerCase : list) {
                    if (str2.endsWith("." + lowerCase.toLowerCase())) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Uri.Builder executeAppend(Uri uri, Map<String, String> map) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (map == null || map.size() <= 0 || uri.isOpaque()) {
            return buildUpon;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) next.getKey()) && uri.getQueryParameter((String) next.getKey()) == null) {
                buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return buildUpon;
    }
}
