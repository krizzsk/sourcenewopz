package com.didi.beatles.p099im.access.utils;

import android.text.TextUtils;

/* renamed from: com.didi.beatles.im.access.utils.IMTextUtils */
public class IMTextUtils {
    public static final String DEVIDER_TAG = "###";
    public static final String STREET_IMAGE_TAG_END = ">";
    public static final String STREET_IMAGE_TAG_START = "<";

    public static String getTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(DEVIDER_TAG);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String getContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(DEVIDER_TAG);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(indexOf + 3, str.length());
    }

    public static String getStreetImageContent(String str, int i) {
        int i2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(STREET_IMAGE_TAG_START);
        int indexOf2 = str.indexOf(STREET_IMAGE_TAG_END);
        if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= (i2 = indexOf + 1) || !TextUtils.equals(str.substring(i2, indexOf2), String.valueOf(i)) || str.length() <= (i3 = indexOf2 + 1)) {
            return null;
        }
        return str.substring(i3);
    }
}
