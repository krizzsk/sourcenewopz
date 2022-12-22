package com.didi.unifylogin.utils.autologin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeMatcher {
    public static final String REG_LEN_4 = "[0-9]{4}";
    public static final String REG_LEN_6 = "[0-9]{6}";
    public static final String TAG = CodeMatcher.class.getSimpleName();
    public static String[] rules = {REG_LEN_6, REG_LEN_4};

    public static String getCode(String str) {
        int i = 0;
        while (true) {
            String[] strArr = rules;
            if (i >= strArr.length) {
                return null;
            }
            Matcher matcher = Pattern.compile(strArr[i]).matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            i++;
        }
    }
}
