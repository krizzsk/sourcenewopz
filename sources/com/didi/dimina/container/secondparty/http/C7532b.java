package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.secondparty.http.b */
/* compiled from: MimeTypeMap */
class C7532b {

    /* renamed from: a */
    private static final Map<String, String> f17120a = new HashMap();

    C7532b() {
    }

    static {
        m12689a("png", "image/png");
        m12689a("jpeg", "image/jpeg");
        m12689a(FileUtil.JPG, "image/jpeg");
        m12689a("jfif", "image/jpeg");
        m12689a("gif", "image/gif");
        m12689a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m12689a("js", "application/javascript");
        m12689a("html", "text/html");
        m12689a("htm", "text/html");
        m12689a("svg", "image/svg+xml");
        m12689a("webp", "image/webp");
        m12689a("webm", "video/webm");
    }

    /* renamed from: a */
    static String m12688a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (MimeTypeMap.getSingleton().hasExtension(fileExtensionFromUrl)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return f17120a.get(fileExtensionFromUrl);
    }

    /* renamed from: b */
    static String m12690b(String str) {
        return f17120a.get(str);
    }

    /* renamed from: a */
    private static void m12689a(String str, String str2) {
        f17120a.put(str, str2);
    }
}
