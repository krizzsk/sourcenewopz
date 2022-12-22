package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavStatus */
public final class DARCZGNavStatus {
    public static final DARCZGNavStatus DARCZGNavStatus_Init = new DARCZGNavStatus("DARCZGNavStatus_Init", AREngineJNIBridge.DARCZGNavStatus_Init_get());
    public static final DARCZGNavStatus DARCZGNavStatus_LocEnd = new DARCZGNavStatus("DARCZGNavStatus_LocEnd");
    public static final DARCZGNavStatus DARCZGNavStatus_LocStart = new DARCZGNavStatus("DARCZGNavStatus_LocStart");
    public static final DARCZGNavStatus DARCZGNavStatus_ReachEnd;
    public static final DARCZGNavStatus DARCZGNavStatus_Running = new DARCZGNavStatus("DARCZGNavStatus_Running");
    private static int swigNext = 0;
    private static DARCZGNavStatus[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCZGNavStatus dARCZGNavStatus = new DARCZGNavStatus("DARCZGNavStatus_ReachEnd");
        DARCZGNavStatus_ReachEnd = dARCZGNavStatus;
        swigValues = new DARCZGNavStatus[]{DARCZGNavStatus_Init, DARCZGNavStatus_LocStart, DARCZGNavStatus_LocEnd, DARCZGNavStatus_Running, dARCZGNavStatus};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCZGNavStatus swigToEnum(int i) {
        DARCZGNavStatus[] dARCZGNavStatusArr = swigValues;
        if (i < dARCZGNavStatusArr.length && i >= 0 && dARCZGNavStatusArr[i].swigValue == i) {
            return dARCZGNavStatusArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCZGNavStatus[] dARCZGNavStatusArr2 = swigValues;
            if (i2 >= dARCZGNavStatusArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCZGNavStatus.class + " with value " + i);
            } else if (dARCZGNavStatusArr2[i2].swigValue == i) {
                return dARCZGNavStatusArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCZGNavStatus(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCZGNavStatus(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCZGNavStatus(String str, DARCZGNavStatus dARCZGNavStatus) {
        this.swigName = str;
        int i = dARCZGNavStatus.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
