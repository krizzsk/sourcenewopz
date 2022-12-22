package com.didi.hawaii.mapsdkv2.jni;

public final class DMapLanguage {
    public static final DMapLanguage DMapLanguageCount;
    public static final DMapLanguage DMapLanguage_Chinese = new DMapLanguage("DMapLanguage_Chinese", MapEngineJNIBridge.DMapLanguage_Chinese_get());
    public static final DMapLanguage DMapLanguage_English = new DMapLanguage("DMapLanguage_English");
    public static final DMapLanguage DMapLanguage_Portuguese = new DMapLanguage("DMapLanguage_Portuguese");
    public static final DMapLanguage DMapLanguage_Spanish = new DMapLanguage("DMapLanguage_Spanish");
    public static final DMapLanguage DMapLanguage_TraditionalChinese = new DMapLanguage("DMapLanguage_TraditionalChinese");
    private static int swigNext = 0;
    private static DMapLanguage[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapLanguage dMapLanguage = new DMapLanguage("DMapLanguageCount");
        DMapLanguageCount = dMapLanguage;
        swigValues = new DMapLanguage[]{DMapLanguage_Chinese, DMapLanguage_English, DMapLanguage_TraditionalChinese, DMapLanguage_Portuguese, DMapLanguage_Spanish, dMapLanguage};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapLanguage swigToEnum(int i) {
        DMapLanguage[] dMapLanguageArr = swigValues;
        if (i < dMapLanguageArr.length && i >= 0 && dMapLanguageArr[i].swigValue == i) {
            return dMapLanguageArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapLanguage[] dMapLanguageArr2 = swigValues;
            if (i2 >= dMapLanguageArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapLanguage.class + " with value " + i);
            } else if (dMapLanguageArr2[i2].swigValue == i) {
                return dMapLanguageArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapLanguage(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapLanguage(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapLanguage(String str, DMapLanguage dMapLanguage) {
        this.swigName = str;
        int i = dMapLanguage.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
