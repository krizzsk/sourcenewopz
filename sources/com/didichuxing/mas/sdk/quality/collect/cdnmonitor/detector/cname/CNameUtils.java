package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class CNameUtils {
    public static String getNetCName(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str3 = new URL(str).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            str3 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            return "";
        }
        Lookup lookup = new Lookup(str3, "8.8.8.8");
        lookup.Run();
        return lookup.getCname();
    }
}
