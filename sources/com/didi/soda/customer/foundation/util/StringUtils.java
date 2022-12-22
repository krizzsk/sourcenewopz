package com.didi.soda.customer.foundation.util;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

    /* renamed from: a */
    private static String f41257a = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$";

    private StringUtils() {
    }

    public static String trim(String str) {
        if (str != null) {
            return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        }
        return "";
    }

    public static String build(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString();
    }

    public static String getSubStr(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && m29224b(str) <= i) {
            return str;
        }
        return "";
    }

    public static boolean isNullableStringEqual(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !str.equals(str2));
    }

    public static boolean isEmpty(String str) {
        return str == null || TextUtils.isEmpty(str.trim());
    }

    public static boolean isUrlValid(String str) {
        return Pattern.compile(f41257a).matcher(str).matches();
    }

    public static void highlightText(TextView textView, String str, String str2) {
        m29223a(textView, str, new String[]{str2}, R.color.customer_color_FC9153);
    }

    public static void highlightText(TextView textView, String str, String[] strArr) {
        m29223a(textView, str, strArr, R.color.customer_color_FC9153);
    }

    public static void difTextSize(TextView textView, String str, int i, HashMap<String, Integer> hashMap) {
        if (textView != null) {
            if (isEmpty(str) || hashMap == null || hashMap.size() == 0) {
                textView.setText(str);
                return;
            }
            SpannableString spannableString = new SpannableString(str);
            for (String next : hashMap.keySet()) {
                if (!isEmpty(next)) {
                    int indexOf = str.toLowerCase().indexOf(next.toLowerCase());
                    if (indexOf > 0) {
                        spannableString.setSpan(new AbsoluteSizeSpan(i), 0, indexOf, 33);
                        spannableString.setSpan(new AbsoluteSizeSpan(hashMap.get(next).intValue()), indexOf, str.length(), 33);
                    } else if (indexOf == 0) {
                        spannableString.setSpan(new AbsoluteSizeSpan(hashMap.get(next).intValue()), 0, next.length(), 33);
                        spannableString.setSpan(new AbsoluteSizeSpan(i), next.length(), str.length(), 33);
                    }
                }
            }
            textView.setText(spannableString);
        }
    }

    /* renamed from: a */
    private static void m29223a(TextView textView, String str, String[] strArr, int i) {
        if (textView != null) {
            if (isEmpty(str) || strArr == null || strArr.length == 0) {
                textView.setText(str);
                return;
            }
            int color = ContextCompat.getColor(textView.getContext(), i);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            for (String str2 : strArr) {
                if (!isEmpty(str2)) {
                    Matcher matcher = Pattern.compile(m29221a(str2.trim()), 2).matcher(str);
                    while (matcher.find()) {
                        if (matcher.start() > -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), matcher.start(), matcher.end(), 34);
                        }
                    }
                }
            }
            textView.setText(spannableStringBuilder);
        }
    }

    /* renamed from: a */
    private static String m29221a(String str) {
        if (!isEmpty(str)) {
            String[] strArr = {"\\", "$", "(", ")", "*", "+", ".", Const.jaLeft, Const.jaRight, "?", "^", Const.joLeft, "}", "|"};
            for (int i = 0; i < 14; i++) {
                String str2 = strArr[i];
                if (str.contains(str2)) {
                    str = str.replace(str2, "\\" + str2);
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    private static int m29224b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("GBK").length;
        } catch (Exception e) {
            LogUtil.m29102e("StringUtils", e.getMessage());
            return 0;
        }
    }

    /* renamed from: a */
    private String m29222a(String str, int i) {
        int length = str.length();
        int i2 = 1;
        int i3 = 0;
        while (i2 < length) {
            i3 += m29224b(str.substring(i2 - 1, i2));
            if (i3 >= i) {
                break;
            }
            i2++;
        }
        return str.substring(0, i2);
    }

    public static String addParam2Url(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return sb.toString();
        }
        String str4 = str2 + "=" + str3;
        if (str.endsWith("?")) {
            sb.append(str4);
        } else if (!str.contains("?")) {
            sb.append("?");
            sb.append(str4);
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            sb.append(str4);
        } else {
            sb.append(ParamKeys.SIGN_AND);
            sb.append(str4);
        }
        return sb.toString();
    }

    public static String toHex(Integer num) {
        return num == null ? "0" : Integer.toHexString(num.intValue());
    }
}
