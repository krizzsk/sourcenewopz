package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNaviType */
public final class DARCNaviType {
    public static final DARCNaviType DARCNaviTypeAR = new DARCNaviType("DARCNaviTypeAR", AREngineJNIBridge.DARCNaviTypeAR_get());
    public static final DARCNaviType DARCNaviTypeARDirection;
    private static int swigNext = 0;
    private static DARCNaviType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCNaviType dARCNaviType = new DARCNaviType("DARCNaviTypeARDirection", AREngineJNIBridge.DARCNaviTypeARDirection_get());
        DARCNaviTypeARDirection = dARCNaviType;
        swigValues = new DARCNaviType[]{DARCNaviTypeAR, dARCNaviType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCNaviType swigToEnum(int i) {
        DARCNaviType[] dARCNaviTypeArr = swigValues;
        if (i < dARCNaviTypeArr.length && i >= 0 && dARCNaviTypeArr[i].swigValue == i) {
            return dARCNaviTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCNaviType[] dARCNaviTypeArr2 = swigValues;
            if (i2 >= dARCNaviTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCNaviType.class + " with value " + i);
            } else if (dARCNaviTypeArr2[i2].swigValue == i) {
                return dARCNaviTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCNaviType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCNaviType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCNaviType(String str, DARCNaviType dARCNaviType) {
        this.swigName = str;
        int i = dARCNaviType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
