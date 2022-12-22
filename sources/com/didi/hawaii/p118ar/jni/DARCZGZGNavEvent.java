package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGZGNavEvent */
public final class DARCZGZGNavEvent {
    public static final DARCZGZGNavEvent DARCZGZGNavEvent_GPSWeakChanged;
    public static final DARCZGZGNavEvent DARCZGZGNavEvent_None = new DARCZGZGNavEvent("DARCZGZGNavEvent_None", AREngineJNIBridge.DARCZGZGNavEvent_None_get());
    public static final DARCZGZGNavEvent DARCZGZGNavEvent_StatusChanged = new DARCZGZGNavEvent("DARCZGZGNavEvent_StatusChanged");
    private static int swigNext = 0;
    private static DARCZGZGNavEvent[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCZGZGNavEvent dARCZGZGNavEvent = new DARCZGZGNavEvent("DARCZGZGNavEvent_GPSWeakChanged");
        DARCZGZGNavEvent_GPSWeakChanged = dARCZGZGNavEvent;
        swigValues = new DARCZGZGNavEvent[]{DARCZGZGNavEvent_None, DARCZGZGNavEvent_StatusChanged, dARCZGZGNavEvent};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCZGZGNavEvent swigToEnum(int i) {
        DARCZGZGNavEvent[] dARCZGZGNavEventArr = swigValues;
        if (i < dARCZGZGNavEventArr.length && i >= 0 && dARCZGZGNavEventArr[i].swigValue == i) {
            return dARCZGZGNavEventArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCZGZGNavEvent[] dARCZGZGNavEventArr2 = swigValues;
            if (i2 >= dARCZGZGNavEventArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCZGZGNavEvent.class + " with value " + i);
            } else if (dARCZGZGNavEventArr2[i2].swigValue == i) {
                return dARCZGZGNavEventArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCZGZGNavEvent(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCZGZGNavEvent(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCZGZGNavEvent(String str, DARCZGZGNavEvent dARCZGZGNavEvent) {
        this.swigName = str;
        int i = dARCZGZGNavEvent.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
