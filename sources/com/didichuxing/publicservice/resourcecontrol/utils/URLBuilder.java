package com.didichuxing.publicservice.resourcecontrol.utils;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class URLBuilder {
    private String mURL;

    public URLBuilder(String str) {
        this.mURL = str;
    }

    public URLBuilder append(String str, String str2) {
        return append(str, str2, false);
    }

    public URLBuilder append(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            appendQuestionMark();
            addParamKeyValue(str, str2, z);
        }
        return this;
    }

    public String newUrl() {
        return this.mURL;
    }

    private void appendQuestionMark() {
        if (TextUtils.isEmpty(this.mURL) || this.mURL.endsWith("?") || this.mURL.endsWith(ParamKeys.SIGN_AND)) {
            return;
        }
        if (!this.mURL.contains("?")) {
            this.mURL = this.mURL.concat("?");
        } else {
            this.mURL = this.mURL.concat(ParamKeys.SIGN_AND);
        }
    }

    private void addParamKeyValue(String str, String str2, boolean z) {
        String str3;
        String concat = this.mURL.concat(str).concat("=");
        this.mURL = concat;
        if (z) {
            try {
                str3 = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str3 = URLEncoder.encode(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                str3 = str3.replaceAll("\\+", "%20");
            }
            this.mURL = this.mURL.concat(str3);
            return;
        }
        this.mURL = concat.concat(str2);
    }

    private static String TruncateUrlPage(String str) {
        String trim = str.trim();
        String[] split = trim.split("[?]");
        String str2 = null;
        if (trim.length() > 1 && split.length > 1) {
            for (int i = 1; i < split.length; i++) {
                str2 = split[i];
            }
        }
        return str2;
    }

    public static Map<String, String> urlSplit(String str) {
        HashMap hashMap = new HashMap();
        String TruncateUrlPage = TruncateUrlPage(str);
        if (TextUtil.isEmpty(TruncateUrlPage)) {
            return hashMap;
        }
        for (String split : TruncateUrlPage.split("[&]")) {
            String[] split2 = split.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            } else if (!TextUtil.isEmpty(split2[0])) {
                hashMap.put(split2[0], "");
            }
        }
        return hashMap;
    }
}
