package com.didi.hawaii.mapsdkv2.jni;

public final class DMapPrimitiveType {
    public static final DMapPrimitiveType DMapPrimitiveType_CircleOverPolygon;
    public static final DMapPrimitiveType DMapPrimitiveType_Line = new DMapPrimitiveType("DMapPrimitiveType_Line", MapEngineJNIBridge.DMapPrimitiveType_Line_get());
    public static final DMapPrimitiveType DMapPrimitiveType_LineLoop = new DMapPrimitiveType("DMapPrimitiveType_LineLoop", MapEngineJNIBridge.DMapPrimitiveType_LineLoop_get());
    public static final DMapPrimitiveType DMapPrimitiveType_Polygon = new DMapPrimitiveType("DMapPrimitiveType_Polygon", MapEngineJNIBridge.DMapPrimitiveType_Polygon_get());
    private static int swigNext = 0;
    private static DMapPrimitiveType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapPrimitiveType dMapPrimitiveType = new DMapPrimitiveType("DMapPrimitiveType_CircleOverPolygon", MapEngineJNIBridge.DMapPrimitiveType_CircleOverPolygon_get());
        DMapPrimitiveType_CircleOverPolygon = dMapPrimitiveType;
        swigValues = new DMapPrimitiveType[]{DMapPrimitiveType_Polygon, DMapPrimitiveType_LineLoop, DMapPrimitiveType_Line, dMapPrimitiveType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapPrimitiveType swigToEnum(int i) {
        DMapPrimitiveType[] dMapPrimitiveTypeArr = swigValues;
        if (i < dMapPrimitiveTypeArr.length && i >= 0 && dMapPrimitiveTypeArr[i].swigValue == i) {
            return dMapPrimitiveTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapPrimitiveType[] dMapPrimitiveTypeArr2 = swigValues;
            if (i2 >= dMapPrimitiveTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapPrimitiveType.class + " with value " + i);
            } else if (dMapPrimitiveTypeArr2[i2].swigValue == i) {
                return dMapPrimitiveTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapPrimitiveType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapPrimitiveType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapPrimitiveType(String str, DMapPrimitiveType dMapPrimitiveType) {
        this.swigName = str;
        int i = dMapPrimitiveType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
