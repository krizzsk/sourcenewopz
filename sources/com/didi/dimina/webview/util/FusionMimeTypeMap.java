package com.didi.dimina.webview.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class FusionMimeTypeMap {

    /* renamed from: a */
    private static final Map<String, String> f18399a = new HashMap();

    static {
        m13661a("png", "image/png");
        m13661a("jpeg", "image/jpeg");
        m13661a(FileUtil.JPG, "image/jpeg");
        m13661a("jfif", "image/jpeg");
        m13661a("gif", "image/gif");
        m13661a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m13661a("js", "application/javascript");
        m13661a("html", "text/html");
        m13661a("htm", "text/html");
        m13661a("mp4", "video/mp4");
        m13661a("woff", "font/woff");
        m13661a("woff2", "font/woff2");
        m13661a("eot", "application/vnd.ms-fontobject");
        m13661a("ttf", "application/font-sfnt");
        m13661a("svg", "image/svg+xml");
        m13661a("webp", "image/webp");
        m13661a("webm", "video/webm");
    }

    public static String getMimeTypeFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (MimeTypeMap.getSingleton().hasExtension(fileExtensionFromUrl)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return f18399a.get(fileExtensionFromUrl);
    }

    public static String getContentType(String str) {
        return f18399a.get(str);
    }

    /* renamed from: a */
    private static void m13661a(String str, String str2) {
        f18399a.put(str, str2);
    }
}
