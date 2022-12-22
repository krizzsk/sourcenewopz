package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCARTrackStateReason */
public final class DARCARTrackStateReason {
    public static final DARCARTrackStateReason DARCARTrackStateReason_ExcessiveMotion = new DARCARTrackStateReason("DARCARTrackStateReason_ExcessiveMotion");
    public static final DARCARTrackStateReason DARCARTrackStateReason_Initializing = new DARCARTrackStateReason("DARCARTrackStateReason_Initializing");
    public static final DARCARTrackStateReason DARCARTrackStateReason_InsufficientFeatures = new DARCARTrackStateReason("DARCARTrackStateReason_InsufficientFeatures");
    public static final DARCARTrackStateReason DARCARTrackStateReason_None = new DARCARTrackStateReason("DARCARTrackStateReason_None");
    public static final DARCARTrackStateReason DARCARTrackStateReason_Relocalizing;
    private static int swigNext = 0;
    private static DARCARTrackStateReason[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCARTrackStateReason dARCARTrackStateReason = new DARCARTrackStateReason("DARCARTrackStateReason_Relocalizing");
        DARCARTrackStateReason_Relocalizing = dARCARTrackStateReason;
        swigValues = new DARCARTrackStateReason[]{DARCARTrackStateReason_None, DARCARTrackStateReason_Initializing, DARCARTrackStateReason_ExcessiveMotion, DARCARTrackStateReason_InsufficientFeatures, dARCARTrackStateReason};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCARTrackStateReason swigToEnum(int i) {
        DARCARTrackStateReason[] dARCARTrackStateReasonArr = swigValues;
        if (i < dARCARTrackStateReasonArr.length && i >= 0 && dARCARTrackStateReasonArr[i].swigValue == i) {
            return dARCARTrackStateReasonArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCARTrackStateReason[] dARCARTrackStateReasonArr2 = swigValues;
            if (i2 >= dARCARTrackStateReasonArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCARTrackStateReason.class + " with value " + i);
            } else if (dARCARTrackStateReasonArr2[i2].swigValue == i) {
                return dARCARTrackStateReasonArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCARTrackStateReason(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCARTrackStateReason(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCARTrackStateReason(String str, DARCARTrackStateReason dARCARTrackStateReason) {
        this.swigName = str;
        int i = dARCARTrackStateReason.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
