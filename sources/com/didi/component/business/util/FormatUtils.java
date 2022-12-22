package com.didi.component.business.util;

public class FormatUtils {
    public static String formatTime(long j) {
        long abs = Math.abs(j);
        StringBuilder sb = new StringBuilder();
        if (abs >= 3600) {
            long j2 = abs / 3600;
            if (j2 <= 9) {
                sb.append("0");
            }
            sb.append(j2);
            sb.append(":");
            abs %= 3600;
        }
        long j3 = abs / 60;
        if (j3 <= 9) {
            sb.append("0");
        }
        sb.append(j3);
        sb.append(":");
        long j4 = abs % 60;
        if (j4 <= 9) {
            sb.append("0");
        }
        sb.append(j4);
        return sb.toString();
    }

    public static String formatZeroWhenLessThan10(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        return "0" + i;
    }
}
