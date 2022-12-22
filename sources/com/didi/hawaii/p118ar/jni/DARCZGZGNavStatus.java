package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGZGNavStatus */
public final class DARCZGZGNavStatus {
    public static final DARCZGZGNavStatus DARCZGZGNavStatus_Init = new DARCZGZGNavStatus("DARCZGZGNavStatus_Init", AREngineJNIBridge.DARCZGZGNavStatus_Init_get());
    public static final DARCZGZGNavStatus DARCZGZGNavStatus_LocEnd = new DARCZGZGNavStatus("DARCZGZGNavStatus_LocEnd");
    public static final DARCZGZGNavStatus DARCZGZGNavStatus_LocStart = new DARCZGZGNavStatus("DARCZGZGNavStatus_LocStart");
    public static final DARCZGZGNavStatus DARCZGZGNavStatus_ReachEnd;
    public static final DARCZGZGNavStatus DARCZGZGNavStatus_Running = new DARCZGZGNavStatus("DARCZGZGNavStatus_Running");
    private static int swigNext = 0;
    private static DARCZGZGNavStatus[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCZGZGNavStatus dARCZGZGNavStatus = new DARCZGZGNavStatus("DARCZGZGNavStatus_ReachEnd");
        DARCZGZGNavStatus_ReachEnd = dARCZGZGNavStatus;
        swigValues = new DARCZGZGNavStatus[]{DARCZGZGNavStatus_Init, DARCZGZGNavStatus_LocStart, DARCZGZGNavStatus_LocEnd, DARCZGZGNavStatus_Running, dARCZGZGNavStatus};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCZGZGNavStatus swigToEnum(int i) {
        DARCZGZGNavStatus[] dARCZGZGNavStatusArr = swigValues;
        if (i < dARCZGZGNavStatusArr.length && i >= 0 && dARCZGZGNavStatusArr[i].swigValue == i) {
            return dARCZGZGNavStatusArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCZGZGNavStatus[] dARCZGZGNavStatusArr2 = swigValues;
            if (i2 >= dARCZGZGNavStatusArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCZGZGNavStatus.class + " with value " + i);
            } else if (dARCZGZGNavStatusArr2[i2].swigValue == i) {
                return dARCZGZGNavStatusArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCZGZGNavStatus(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCZGZGNavStatus(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCZGZGNavStatus(String str, DARCZGZGNavStatus dARCZGZGNavStatus) {
        this.swigName = str;
        int i = dARCZGZGNavStatus.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
