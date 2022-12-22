package com.didi.unifylogin.utils;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.net.MalformedURLException;
import java.net.URL;

public class StringUtil {
    public static String getPath(String str) {
        try {
            return new URL(str).getPath();
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    public static String getBaseUrl(String str) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HWMapConstant.HTTP.SEPARATOR + url.getHost();
        } catch (MalformedURLException unused) {
            return str;
        }
    }
}
