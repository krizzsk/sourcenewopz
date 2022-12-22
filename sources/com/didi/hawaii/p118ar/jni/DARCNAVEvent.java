package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNAVEvent */
public final class DARCNAVEvent {
    public static final DARCNAVEvent DARCNAVEvent_None = new DARCNAVEvent("DARCNAVEvent_None", AREngineJNIBridge.DARCNAVEvent_None_get());
    public static final DARCNAVEvent DARCNAVEvent_ResetARSession;
    public static final DARCNAVEvent DARCNAVEvent_ShowAlert = new DARCNAVEvent("DARCNAVEvent_ShowAlert");
    public static final DARCNAVEvent DARCNAVEvent_StatusChanged = new DARCNAVEvent("DARCNAVEvent_StatusChanged");
    private static int swigNext = 0;
    private static DARCNAVEvent[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCNAVEvent dARCNAVEvent = new DARCNAVEvent("DARCNAVEvent_ResetARSession");
        DARCNAVEvent_ResetARSession = dARCNAVEvent;
        swigValues = new DARCNAVEvent[]{DARCNAVEvent_None, DARCNAVEvent_StatusChanged, DARCNAVEvent_ShowAlert, dARCNAVEvent};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCNAVEvent swigToEnum(int i) {
        DARCNAVEvent[] dARCNAVEventArr = swigValues;
        if (i < dARCNAVEventArr.length && i >= 0 && dARCNAVEventArr[i].swigValue == i) {
            return dARCNAVEventArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCNAVEvent[] dARCNAVEventArr2 = swigValues;
            if (i2 >= dARCNAVEventArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCNAVEvent.class + " with value " + i);
            } else if (dARCNAVEventArr2[i2].swigValue == i) {
                return dARCNAVEventArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCNAVEvent(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCNAVEvent(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCNAVEvent(String str, DARCNAVEvent dARCNAVEvent) {
        this.swigName = str;
        int i = dARCNAVEvent.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
