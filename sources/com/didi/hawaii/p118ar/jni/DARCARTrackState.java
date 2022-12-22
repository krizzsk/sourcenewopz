package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCARTrackState */
public final class DARCARTrackState {
    public static final DARCARTrackState DARCARTrackState_Limited = new DARCARTrackState("DARCARTrackState_Limited", AREngineJNIBridge.DARCARTrackState_Limited_get());
    public static final DARCARTrackState DARCARTrackState_Normal;
    public static final DARCARTrackState DARCARTrackState_NotAvailable = new DARCARTrackState("DARCARTrackState_NotAvailable", AREngineJNIBridge.DARCARTrackState_NotAvailable_get());
    private static int swigNext = 0;
    private static DARCARTrackState[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCARTrackState dARCARTrackState = new DARCARTrackState("DARCARTrackState_Normal", AREngineJNIBridge.DARCARTrackState_Normal_get());
        DARCARTrackState_Normal = dARCARTrackState;
        swigValues = new DARCARTrackState[]{DARCARTrackState_NotAvailable, DARCARTrackState_Limited, dARCARTrackState};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCARTrackState swigToEnum(int i) {
        DARCARTrackState[] dARCARTrackStateArr = swigValues;
        if (i < dARCARTrackStateArr.length && i >= 0 && dARCARTrackStateArr[i].swigValue == i) {
            return dARCARTrackStateArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCARTrackState[] dARCARTrackStateArr2 = swigValues;
            if (i2 >= dARCARTrackStateArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCARTrackState.class + " with value " + i);
            } else if (dARCARTrackStateArr2[i2].swigValue == i) {
                return dARCARTrackStateArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCARTrackState(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCARTrackState(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCARTrackState(String str, DARCARTrackState dARCARTrackState) {
        this.swigName = str;
        int i = dARCARTrackState.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
