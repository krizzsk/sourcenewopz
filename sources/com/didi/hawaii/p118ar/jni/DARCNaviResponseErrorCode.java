package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNaviResponseErrorCode */
public final class DARCNaviResponseErrorCode {
    public static final DARCNaviResponseErrorCode DARCNaviResponseErrorGPSHorAccurateNotSatisfy;
    public static final DARCNaviResponseErrorCode DARCNaviResponseErrorNone = new DARCNaviResponseErrorCode("DARCNaviResponseErrorNone", AREngineJNIBridge.DARCNaviResponseErrorNone_get());
    private static int swigNext = 0;
    private static DARCNaviResponseErrorCode[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCNaviResponseErrorCode dARCNaviResponseErrorCode = new DARCNaviResponseErrorCode("DARCNaviResponseErrorGPSHorAccurateNotSatisfy", AREngineJNIBridge.DARCNaviResponseErrorGPSHorAccurateNotSatisfy_get());
        DARCNaviResponseErrorGPSHorAccurateNotSatisfy = dARCNaviResponseErrorCode;
        swigValues = new DARCNaviResponseErrorCode[]{DARCNaviResponseErrorNone, dARCNaviResponseErrorCode};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCNaviResponseErrorCode swigToEnum(int i) {
        DARCNaviResponseErrorCode[] dARCNaviResponseErrorCodeArr = swigValues;
        if (i < dARCNaviResponseErrorCodeArr.length && i >= 0 && dARCNaviResponseErrorCodeArr[i].swigValue == i) {
            return dARCNaviResponseErrorCodeArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCNaviResponseErrorCode[] dARCNaviResponseErrorCodeArr2 = swigValues;
            if (i2 >= dARCNaviResponseErrorCodeArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCNaviResponseErrorCode.class + " with value " + i);
            } else if (dARCNaviResponseErrorCodeArr2[i2].swigValue == i) {
                return dARCNaviResponseErrorCodeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCNaviResponseErrorCode(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCNaviResponseErrorCode(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCNaviResponseErrorCode(String str, DARCNaviResponseErrorCode dARCNaviResponseErrorCode) {
        this.swigName = str;
        int i = dARCNaviResponseErrorCode.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
