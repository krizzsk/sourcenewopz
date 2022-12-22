package com.didi.component.newbeecoupon.util;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewbeeCouponUtil {
    public static CharSequence getBoldStyleText(String str) {
        return getBoldAndSizeStyleText(str, 60);
    }

    public static CharSequence getBoldAndSizeStyleText(String str, int i) {
        int start;
        int end;
        try {
            if (!TextUtils.isEmpty(str)) {
                Matcher matcher = Pattern.compile("\\{.*\\}").matcher(str);
                if (matcher.find() && (end = matcher.end()) > (start = matcher.start())) {
                    String replace = str.replace(Const.joLeft, "").replace("}", "");
                    StyleSpan styleSpan = new StyleSpan(1);
                    AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(i, true);
                    SpannableString spannableString = new SpannableString(replace);
                    int i2 = end - 2;
                    spannableString.setSpan(styleSpan, start, i2, 17);
                    spannableString.setSpan(absoluteSizeSpan, start, i2, 17);
                    return spannableString;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
