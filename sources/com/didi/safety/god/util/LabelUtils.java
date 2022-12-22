package com.didi.safety.god.util;

public class LabelUtils {
    public static boolean isCLabel(int i) {
        return i == 8 || i == 88;
    }

    public static boolean isQualitySupportedLabel(int i) {
        return i == 1 || i == 3 || i == 6 || i == 8 || i == 2 || i == 4 || i == 7;
    }

    public static boolean isStandardLabel(int i) {
        return i >= 1 && i <= 8;
    }

    public static boolean isX1Label(int i) {
        return i == 3;
    }

    public static boolean isXLabel(int i) {
        return i == 3 || i == 5 || i == 4;
    }

    private LabelUtils() {
    }
}
