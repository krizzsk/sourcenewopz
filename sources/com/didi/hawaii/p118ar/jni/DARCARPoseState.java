package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCARPoseState */
public final class DARCARPoseState {
    public static final DARCARPoseState DARCARPoseState_Drift;
    public static final DARCARPoseState DARCARPoseState_Normal = new DARCARPoseState("DARCARPoseState_Normal");
    private static int swigNext = 0;
    private static DARCARPoseState[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCARPoseState dARCARPoseState = new DARCARPoseState("DARCARPoseState_Drift");
        DARCARPoseState_Drift = dARCARPoseState;
        swigValues = new DARCARPoseState[]{DARCARPoseState_Normal, dARCARPoseState};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCARPoseState swigToEnum(int i) {
        DARCARPoseState[] dARCARPoseStateArr = swigValues;
        if (i < dARCARPoseStateArr.length && i >= 0 && dARCARPoseStateArr[i].swigValue == i) {
            return dARCARPoseStateArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCARPoseState[] dARCARPoseStateArr2 = swigValues;
            if (i2 >= dARCARPoseStateArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCARPoseState.class + " with value " + i);
            } else if (dARCARPoseStateArr2[i2].swigValue == i) {
                return dARCARPoseStateArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCARPoseState(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCARPoseState(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCARPoseState(String str, DARCARPoseState dARCARPoseState) {
        this.swigName = str;
        int i = dARCARPoseState.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
