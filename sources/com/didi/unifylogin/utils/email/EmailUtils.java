package com.didi.unifylogin.utils.email;

public class EmailUtils {
    public static boolean isEmail(String str) {
        if (str != null && !str.isEmpty()) {
            boolean contains = str.contains('@' + "");
            boolean z = str.charAt(0) != '@';
            boolean z2 = str.charAt(str.length() - 1) != '@';
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append("");
            boolean z3 = str.split(sb.toString()).length == 2;
            if (!contains || !z || !z2 || !z3) {
                return false;
            }
            return true;
        }
        return false;
    }
}
