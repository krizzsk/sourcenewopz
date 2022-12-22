package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCZGNavDistanceEvent */
public final class DARCZGNavDistanceEvent {
    public static final DARCZGNavDistanceEvent DARCZGNavDistanceEvent_InitialDistance = new DARCZGNavDistanceEvent("DARCZGNavDistanceEvent_InitialDistance");
    public static final DARCZGNavDistanceEvent DARCZGNavDistanceEvent_Invalid = new DARCZGNavDistanceEvent("DARCZGNavDistanceEvent_Invalid", AREngineJNIBridge.DARCZGNavDistanceEvent_Invalid_get());
    public static final DARCZGNavDistanceEvent DARCZGNavDistanceEvent_LessThan100Meter;
    public static final DARCZGNavDistanceEvent DARCZGNavDistanceEvent_LessThan200Meter = new DARCZGNavDistanceEvent("DARCZGNavDistanceEvent_LessThan200Meter");
    public static final DARCZGNavDistanceEvent DARCZGNavDistanceEvent_MoreThan200Meter = new DARCZGNavDistanceEvent("DARCZGNavDistanceEvent_MoreThan200Meter");
    private static int swigNext = 0;
    private static DARCZGNavDistanceEvent[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCZGNavDistanceEvent dARCZGNavDistanceEvent = new DARCZGNavDistanceEvent("DARCZGNavDistanceEvent_LessThan100Meter");
        DARCZGNavDistanceEvent_LessThan100Meter = dARCZGNavDistanceEvent;
        swigValues = new DARCZGNavDistanceEvent[]{DARCZGNavDistanceEvent_Invalid, DARCZGNavDistanceEvent_InitialDistance, DARCZGNavDistanceEvent_MoreThan200Meter, DARCZGNavDistanceEvent_LessThan200Meter, dARCZGNavDistanceEvent};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCZGNavDistanceEvent swigToEnum(int i) {
        DARCZGNavDistanceEvent[] dARCZGNavDistanceEventArr = swigValues;
        if (i < dARCZGNavDistanceEventArr.length && i >= 0 && dARCZGNavDistanceEventArr[i].swigValue == i) {
            return dARCZGNavDistanceEventArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCZGNavDistanceEvent[] dARCZGNavDistanceEventArr2 = swigValues;
            if (i2 >= dARCZGNavDistanceEventArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCZGNavDistanceEvent.class + " with value " + i);
            } else if (dARCZGNavDistanceEventArr2[i2].swigValue == i) {
                return dARCZGNavDistanceEventArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCZGNavDistanceEvent(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCZGNavDistanceEvent(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCZGNavDistanceEvent(String str, DARCZGNavDistanceEvent dARCZGNavDistanceEvent) {
        this.swigName = str;
        int i = dARCZGNavDistanceEvent.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
