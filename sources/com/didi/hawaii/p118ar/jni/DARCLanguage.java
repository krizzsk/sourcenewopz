package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCLanguage */
public final class DARCLanguage {
    public static final DARCLanguage DARCLanguage_ChineseSimplified = new DARCLanguage("DARCLanguage_ChineseSimplified", AREngineJNIBridge.DARCLanguage_ChineseSimplified_get());
    public static final DARCLanguage DARCLanguage_EnglishAustralia = new DARCLanguage("DARCLanguage_EnglishAustralia", AREngineJNIBridge.DARCLanguage_EnglishAustralia_get());
    public static final DARCLanguage DARCLanguage_EnglishUS = new DARCLanguage("DARCLanguage_EnglishUS", AREngineJNIBridge.DARCLanguage_EnglishUS_get());
    public static final DARCLanguage DARCLanguage_Japanese = new DARCLanguage("DARCLanguage_Japanese", AREngineJNIBridge.DARCLanguage_Japanese_get());
    public static final DARCLanguage DARCLanguage_Portuguese = new DARCLanguage("DARCLanguage_Portuguese", AREngineJNIBridge.DARCLanguage_Portuguese_get());
    public static final DARCLanguage DARCLanguage_SpanishChile = new DARCLanguage("DARCLanguage_SpanishChile", AREngineJNIBridge.DARCLanguage_SpanishChile_get());
    public static final DARCLanguage DARCLanguage_SpanishColombia = new DARCLanguage("DARCLanguage_SpanishColombia", AREngineJNIBridge.DARCLanguage_SpanishColombia_get());
    public static final DARCLanguage DARCLanguage_SpanishMexico = new DARCLanguage("DARCLanguage_SpanishMexico", AREngineJNIBridge.DARCLanguage_SpanishMexico_get());
    public static final DARCLanguage _DARCLanguageCount;
    private static int swigNext = 0;
    private static DARCLanguage[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCLanguage dARCLanguage = new DARCLanguage("_DARCLanguageCount");
        _DARCLanguageCount = dARCLanguage;
        swigValues = new DARCLanguage[]{DARCLanguage_ChineseSimplified, DARCLanguage_EnglishUS, DARCLanguage_EnglishAustralia, DARCLanguage_Japanese, DARCLanguage_SpanishMexico, DARCLanguage_SpanishChile, DARCLanguage_SpanishColombia, DARCLanguage_Portuguese, dARCLanguage};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCLanguage swigToEnum(int i) {
        DARCLanguage[] dARCLanguageArr = swigValues;
        if (i < dARCLanguageArr.length && i >= 0 && dARCLanguageArr[i].swigValue == i) {
            return dARCLanguageArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCLanguage[] dARCLanguageArr2 = swigValues;
            if (i2 >= dARCLanguageArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCLanguage.class + " with value " + i);
            } else if (dARCLanguageArr2[i2].swigValue == i) {
                return dARCLanguageArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCLanguage(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCLanguage(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCLanguage(String str, DARCLanguage dARCLanguage) {
        this.swigName = str;
        int i = dARCLanguage.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
