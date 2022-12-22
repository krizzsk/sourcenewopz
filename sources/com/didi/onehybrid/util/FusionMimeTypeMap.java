package com.didi.onehybrid.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.onehybrid.resource.offline.UrlTrieTree;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FusionMimeTypeMap {

    /* renamed from: a */
    private static final Map<String, String> f29711a = new HashMap();

    static {
        m20856a("png", "image/png");
        m20856a("jpeg", "image/jpeg");
        m20856a(FileUtil.JPG, "image/jpeg");
        m20856a("jfif", "image/jpeg");
        m20856a("gif", "image/gif");
        m20856a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m20856a("js", "application/javascript");
        m20856a("html", "text/html");
        m20856a("htm", "text/html");
        m20856a("mp4", "video/mp4");
        m20856a("woff", "font/woff");
        m20856a("woff2", "font/woff2");
        m20856a("eot", "application/vnd.ms-fontobject");
        m20856a("ttf", "application/font-sfnt");
        m20856a("svg", "image/svg+xml");
        m20856a("webp", "image/webp");
        m20856a("webm", "video/webm");
    }

    public static String getMimeTypeFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String pureUrl = UrlTrieTree.getPureUrl(str);
        int lastIndexOf = pureUrl.lastIndexOf(46);
        if (lastIndexOf > 0) {
            pureUrl = pureUrl.substring(lastIndexOf + 1);
        }
        String lowerCase = pureUrl.toLowerCase(Locale.getDefault());
        if (MimeTypeMap.getSingleton().hasExtension(lowerCase)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        }
        return f29711a.get(lowerCase);
    }

    public static String getContentType(String str) {
        return f29711a.get(str);
    }

    /* renamed from: a */
    private static void m20856a(String str, String str2) {
        f29711a.put(str, str2);
    }
}
