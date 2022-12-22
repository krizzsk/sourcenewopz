package com.didi.hawaii.mapsdkv2.jni;

public final class DiInterpolatorType {
    public static final DiInterpolatorType DiDecelerate = new DiInterpolatorType("DiDecelerate");
    public static final DiInterpolatorType DiFastOutSlow = new DiInterpolatorType("DiFastOutSlow");
    public static final DiInterpolatorType DiInterpolatorNum;
    public static final DiInterpolatorType DiLinear = new DiInterpolatorType("DiLinear");
    public static final DiInterpolatorType DiLinearOutSlow = new DiInterpolatorType("DiLinearOutSlow");
    private static int swigNext = 0;
    private static DiInterpolatorType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DiInterpolatorType diInterpolatorType = new DiInterpolatorType("DiInterpolatorNum");
        DiInterpolatorNum = diInterpolatorType;
        swigValues = new DiInterpolatorType[]{DiLinear, DiDecelerate, DiFastOutSlow, DiLinearOutSlow, diInterpolatorType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DiInterpolatorType swigToEnum(int i) {
        DiInterpolatorType[] diInterpolatorTypeArr = swigValues;
        if (i < diInterpolatorTypeArr.length && i >= 0 && diInterpolatorTypeArr[i].swigValue == i) {
            return diInterpolatorTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DiInterpolatorType[] diInterpolatorTypeArr2 = swigValues;
            if (i2 >= diInterpolatorTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DiInterpolatorType.class + " with value " + i);
            } else if (diInterpolatorTypeArr2[i2].swigValue == i) {
                return diInterpolatorTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DiInterpolatorType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DiInterpolatorType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DiInterpolatorType(String str, DiInterpolatorType diInterpolatorType) {
        this.swigName = str;
        int i = diInterpolatorType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
