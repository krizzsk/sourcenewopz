package com.didi.sdk.push;

public class DPushUtil {
    private static boolean isReconnectedThreshold = false;

    public static String defaultBrazilPrefix() {
        return "+55";
    }

    public static boolean isReconnectedThreshold() {
        return isReconnectedThreshold;
    }

    public static void setReconnectedThreshold(boolean z) {
        isReconnectedThreshold = z;
    }

    public static boolean isChinesePrefix(String str) {
        return str != null && str.equals("+86");
    }
}
