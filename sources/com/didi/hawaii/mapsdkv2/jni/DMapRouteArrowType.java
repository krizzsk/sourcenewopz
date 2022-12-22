package com.didi.hawaii.mapsdkv2.jni;

public final class DMapRouteArrowType {
    public static final DMapRouteArrowType DMapArrowType_Circle;
    public static final DMapRouteArrowType DMapArrowType_Left = new DMapRouteArrowType("DMapArrowType_Left", MapEngineJNIBridge.DMapArrowType_Left_get());
    public static final DMapRouteArrowType DMapArrowType_Right = new DMapRouteArrowType("DMapArrowType_Right", MapEngineJNIBridge.DMapArrowType_Right_get());
    public static final DMapRouteArrowType DMapArrowType_Straight = new DMapRouteArrowType("DMapArrowType_Straight", MapEngineJNIBridge.DMapArrowType_Straight_get());
    public static final DMapRouteArrowType DMapArrowType_TurnAround = new DMapRouteArrowType("DMapArrowType_TurnAround", MapEngineJNIBridge.DMapArrowType_TurnAround_get());
    public static final DMapRouteArrowType DMapArrowType_Unknown = new DMapRouteArrowType("DMapArrowType_Unknown", MapEngineJNIBridge.DMapArrowType_Unknown_get());
    private static int swigNext = 0;
    private static DMapRouteArrowType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapRouteArrowType dMapRouteArrowType = new DMapRouteArrowType("DMapArrowType_Circle", MapEngineJNIBridge.DMapArrowType_Circle_get());
        DMapArrowType_Circle = dMapRouteArrowType;
        swigValues = new DMapRouteArrowType[]{DMapArrowType_Unknown, DMapArrowType_Straight, DMapArrowType_Left, DMapArrowType_Right, DMapArrowType_TurnAround, dMapRouteArrowType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapRouteArrowType swigToEnum(int i) {
        DMapRouteArrowType[] dMapRouteArrowTypeArr = swigValues;
        if (i < dMapRouteArrowTypeArr.length && i >= 0 && dMapRouteArrowTypeArr[i].swigValue == i) {
            return dMapRouteArrowTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapRouteArrowType[] dMapRouteArrowTypeArr2 = swigValues;
            if (i2 >= dMapRouteArrowTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapRouteArrowType.class + " with value " + i);
            } else if (dMapRouteArrowTypeArr2[i2].swigValue == i) {
                return dMapRouteArrowTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapRouteArrowType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapRouteArrowType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapRouteArrowType(String str, DMapRouteArrowType dMapRouteArrowType) {
        this.swigName = str;
        int i = dMapRouteArrowType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
