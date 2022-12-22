package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.text.Html;
import java.util.List;

public final class TextUtil {

    /* renamed from: a */
    private static final String f35587a = "<b>";

    /* renamed from: b */
    private static final String f35588b = "</b>";

    /* renamed from: c */
    private static final String f35589c = "{";

    /* renamed from: d */
    private static final String f35590d = "}";

    /* renamed from: e */
    private static final String f35591e = "</b><small><small><small>";

    /* renamed from: f */
    private static final String f35592f = "</small></small></small><b>";

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0 || "null".equals(str);
    }

    public static String getString(Context context, int i) {
        return context.getString(i);
    }

    public static String getString(Context context, int i, Object... objArr) {
        return context.getString(i, objArr);
    }

    public static boolean equals(String str, String str2) {
        if (str == str2) {
            return true;
        }
        return str != null ? str.equals(str2) : str2.equals(str);
    }

    public static String getHighlightTxt(String str) {
        return !isEmpty(str) ? str.replace("{", "<font color='#ff8903'>").replace("}", "</font>").replace("\n", "<br>") : str;
    }

    public static CharSequence getHtmlFormat(String str) {
        return Html.fromHtml(getHighlightTxt(str));
    }

    public static CharSequence getHtmlFormatForSmall(String str) {
        return Html.fromHtml(getSmallTxt(str));
    }

    public static String getSmallTxt(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return (f35587a + str + f35588b).replace("{", f35591e).replace("}", f35592f);
    }

    public static boolean isValidList(List list) {
        return (list == null || list.size() == 0) ? false : true;
    }

    private TextUtil() {
    }
}
