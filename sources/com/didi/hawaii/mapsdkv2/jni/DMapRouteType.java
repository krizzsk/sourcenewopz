package com.didi.hawaii.mapsdkv2.jni;

public final class DMapRouteType {
    public static final DMapRouteType DMapRouteType_AnimationArrowLine = new DMapRouteType("DMapRouteType_AnimationArrowLine");
    public static final DMapRouteType DMapRouteType_AnimationColorLine = new DMapRouteType("DMapRouteType_AnimationColorLine");
    public static final DMapRouteType DMapRouteType_ClosedLine = new DMapRouteType("DMapRouteType_ClosedLine");
    public static final DMapRouteType DMapRouteType_ColorLine = new DMapRouteType("DMapRouteType_ColorLine");
    public static final DMapRouteType DMapRouteType_FootPrint = new DMapRouteType("DMapRouteType_FootPrint");
    public static final DMapRouteType DMapRouteType_Max;
    public static final DMapRouteType DMapRouteType_Repeat = new DMapRouteType("DMapRouteType_Repeat");
    private static int swigNext = 0;
    private static DMapRouteType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapRouteType dMapRouteType = new DMapRouteType("DMapRouteType_Max");
        DMapRouteType_Max = dMapRouteType;
        swigValues = new DMapRouteType[]{DMapRouteType_ColorLine, DMapRouteType_Repeat, DMapRouteType_FootPrint, DMapRouteType_ClosedLine, DMapRouteType_AnimationArrowLine, DMapRouteType_AnimationColorLine, dMapRouteType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapRouteType swigToEnum(int i) {
        DMapRouteType[] dMapRouteTypeArr = swigValues;
        if (i < dMapRouteTypeArr.length && i >= 0 && dMapRouteTypeArr[i].swigValue == i) {
            return dMapRouteTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapRouteType[] dMapRouteTypeArr2 = swigValues;
            if (i2 >= dMapRouteTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapRouteType.class + " with value " + i);
            } else if (dMapRouteTypeArr2[i2].swigValue == i) {
                return dMapRouteTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapRouteType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapRouteType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapRouteType(String str, DMapRouteType dMapRouteType) {
        this.swigName = str;
        int i = dMapRouteType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
