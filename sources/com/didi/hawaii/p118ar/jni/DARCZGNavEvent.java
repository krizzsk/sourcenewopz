package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavEvent */
public final class DARCZGNavEvent {
    public static final DARCZGNavEvent DARCZGNavEvent_DistanceEventChanged = new DARCZGNavEvent("DARCZGNavEvent_DistanceEventChanged");
    public static final DARCZGNavEvent DARCZGNavEvent_FusionGPSPosUpdate;
    public static final DARCZGNavEvent DARCZGNavEvent_GPSWeakChanged = new DARCZGNavEvent("DARCZGNavEvent_GPSWeakChanged");
    public static final DARCZGNavEvent DARCZGNavEvent_None = new DARCZGNavEvent("DARCZGNavEvent_None", AREngineJNIBridge.DARCZGNavEvent_None_get());
    public static final DARCZGNavEvent DARCZGNavEvent_StatusChanged = new DARCZGNavEvent("DARCZGNavEvent_StatusChanged");
    private static int swigNext = 0;
    private static DARCZGNavEvent[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCZGNavEvent dARCZGNavEvent = new DARCZGNavEvent("DARCZGNavEvent_FusionGPSPosUpdate");
        DARCZGNavEvent_FusionGPSPosUpdate = dARCZGNavEvent;
        swigValues = new DARCZGNavEvent[]{DARCZGNavEvent_None, DARCZGNavEvent_StatusChanged, DARCZGNavEvent_GPSWeakChanged, DARCZGNavEvent_DistanceEventChanged, dARCZGNavEvent};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCZGNavEvent swigToEnum(int i) {
        DARCZGNavEvent[] dARCZGNavEventArr = swigValues;
        if (i < dARCZGNavEventArr.length && i >= 0 && dARCZGNavEventArr[i].swigValue == i) {
            return dARCZGNavEventArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCZGNavEvent[] dARCZGNavEventArr2 = swigValues;
            if (i2 >= dARCZGNavEventArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCZGNavEvent.class + " with value " + i);
            } else if (dARCZGNavEventArr2[i2].swigValue == i) {
                return dARCZGNavEventArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCZGNavEvent(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCZGNavEvent(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCZGNavEvent(String str, DARCZGNavEvent dARCZGNavEvent) {
        this.swigName = str;
        int i = dARCZGNavEvent.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
