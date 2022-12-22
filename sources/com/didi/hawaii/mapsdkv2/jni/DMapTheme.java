package com.didi.hawaii.mapsdkv2.jni;

public final class DMapTheme {
    public static final DMapTheme DMapTheme_Bus = new DMapTheme("DMapTheme_Bus", MapEngineJNIBridge.DMapTheme_Bus_get());
    public static final DMapTheme DMapTheme_Bus_Station = new DMapTheme("DMapTheme_Bus_Station", MapEngineJNIBridge.DMapTheme_Bus_Station_get());
    public static final DMapTheme DMapTheme_Default = new DMapTheme("DMapTheme_Default", MapEngineJNIBridge.DMapTheme_Default_get());
    public static final DMapTheme DMapTheme_Self_Drive;
    private static int swigNext = 0;
    private static DMapTheme[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapTheme dMapTheme = new DMapTheme("DMapTheme_Self_Drive", MapEngineJNIBridge.DMapTheme_Self_Drive_get());
        DMapTheme_Self_Drive = dMapTheme;
        swigValues = new DMapTheme[]{DMapTheme_Default, DMapTheme_Bus, DMapTheme_Bus_Station, dMapTheme};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapTheme swigToEnum(int i) {
        DMapTheme[] dMapThemeArr = swigValues;
        if (i < dMapThemeArr.length && i >= 0 && dMapThemeArr[i].swigValue == i) {
            return dMapThemeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapTheme[] dMapThemeArr2 = swigValues;
            if (i2 >= dMapThemeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapTheme.class + " with value " + i);
            } else if (dMapThemeArr2[i2].swigValue == i) {
                return dMapThemeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapTheme(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapTheme(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapTheme(String str, DMapTheme dMapTheme) {
        this.swigName = str;
        int i = dMapTheme.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
