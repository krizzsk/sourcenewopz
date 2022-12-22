package com.didi.hawaii.mapsdkv2.jni;

public final class DMapTrafficEventType {
    public static final DMapTrafficEventType DMapTrafficEventType_Accident = new DMapTrafficEventType("DMapTrafficEventType_Accident");
    public static final DMapTrafficEventType DMapTrafficEventType_Announcement = new DMapTrafficEventType("DMapTrafficEventType_Announcement");
    public static final DMapTrafficEventType DMapTrafficEventType_Closure = new DMapTrafficEventType("DMapTrafficEventType_Closure");
    public static final DMapTrafficEventType DMapTrafficEventType_Congestion = new DMapTrafficEventType("DMapTrafficEventType_Congestion");
    public static final DMapTrafficEventType DMapTrafficEventType_Congestion2;
    public static final DMapTrafficEventType DMapTrafficEventType_Construction = new DMapTrafficEventType("DMapTrafficEventType_Construction");
    public static final DMapTrafficEventType DMapTrafficEventType_Control = new DMapTrafficEventType("DMapTrafficEventType_Control");
    public static final DMapTrafficEventType DMapTrafficEventType_Police = new DMapTrafficEventType("DMapTrafficEventType_Police");
    public static final DMapTrafficEventType DMapTrafficEventType_Stagnation = new DMapTrafficEventType("DMapTrafficEventType_Stagnation");
    private static int swigNext = 0;
    private static DMapTrafficEventType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapTrafficEventType dMapTrafficEventType = new DMapTrafficEventType("DMapTrafficEventType_Congestion2");
        DMapTrafficEventType_Congestion2 = dMapTrafficEventType;
        swigValues = new DMapTrafficEventType[]{DMapTrafficEventType_Congestion, DMapTrafficEventType_Accident, DMapTrafficEventType_Construction, DMapTrafficEventType_Control, DMapTrafficEventType_Closure, DMapTrafficEventType_Stagnation, DMapTrafficEventType_Police, DMapTrafficEventType_Announcement, dMapTrafficEventType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapTrafficEventType swigToEnum(int i) {
        DMapTrafficEventType[] dMapTrafficEventTypeArr = swigValues;
        if (i < dMapTrafficEventTypeArr.length && i >= 0 && dMapTrafficEventTypeArr[i].swigValue == i) {
            return dMapTrafficEventTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapTrafficEventType[] dMapTrafficEventTypeArr2 = swigValues;
            if (i2 >= dMapTrafficEventTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapTrafficEventType.class + " with value " + i);
            } else if (dMapTrafficEventTypeArr2[i2].swigValue == i) {
                return dMapTrafficEventTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapTrafficEventType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapTrafficEventType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapTrafficEventType(String str, DMapTrafficEventType dMapTrafficEventType) {
        this.swigName = str;
        int i = dMapTrafficEventType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
