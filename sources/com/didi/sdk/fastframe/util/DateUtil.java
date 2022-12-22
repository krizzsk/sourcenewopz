package com.didi.sdk.fastframe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String parseDate(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            Date parse = simpleDateFormat.parse(str);
            simpleDateFormat.applyPattern(str3);
            return simpleDateFormat.format(parse);
        } catch (ParseException unused) {
            return str;
        }
    }
}
