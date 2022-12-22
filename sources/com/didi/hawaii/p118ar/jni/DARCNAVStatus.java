package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVStatus */
public final class DARCNAVStatus {
    public static final DARCNAVStatus DARCNAVStatus_Init = new DARCNAVStatus("DARCNAVStatus_Init", AREngineJNIBridge.DARCNAVStatus_Init_get());
    public static final DARCNAVStatus DARCNAVStatus_LocEnd = new DARCNAVStatus("DARCNAVStatus_LocEnd");
    public static final DARCNAVStatus DARCNAVStatus_LocStart = new DARCNAVStatus("DARCNAVStatus_LocStart");
    public static final DARCNAVStatus DARCNAVStatus_ReachEnd = new DARCNAVStatus("DARCNAVStatus_ReachEnd");
    public static final DARCNAVStatus DARCNAVStatus_Running = new DARCNAVStatus("DARCNAVStatus_Running");
    public static final DARCNAVStatus DARCNAVStatus_Stop;
    private static int swigNext = 0;
    private static DARCNAVStatus[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCNAVStatus dARCNAVStatus = new DARCNAVStatus("DARCNAVStatus_Stop");
        DARCNAVStatus_Stop = dARCNAVStatus;
        swigValues = new DARCNAVStatus[]{DARCNAVStatus_Init, DARCNAVStatus_LocStart, DARCNAVStatus_LocEnd, DARCNAVStatus_Running, DARCNAVStatus_ReachEnd, dARCNAVStatus};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCNAVStatus swigToEnum(int i) {
        DARCNAVStatus[] dARCNAVStatusArr = swigValues;
        if (i < dARCNAVStatusArr.length && i >= 0 && dARCNAVStatusArr[i].swigValue == i) {
            return dARCNAVStatusArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCNAVStatus[] dARCNAVStatusArr2 = swigValues;
            if (i2 >= dARCNAVStatusArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCNAVStatus.class + " with value " + i);
            } else if (dARCNAVStatusArr2[i2].swigValue == i) {
                return dARCNAVStatusArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCNAVStatus(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCNAVStatus(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCNAVStatus(String str, DARCNAVStatus dARCNAVStatus) {
        this.swigName = str;
        int i = dARCNAVStatus.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
