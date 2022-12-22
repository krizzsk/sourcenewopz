package com.didi.hawaii.mapsdkv2.jni;

public final class DMapAnnotationType {
    public static final DMapAnnotationType DMapAnnotationType_TrafficLight;
    private static int swigNext = 0;
    private static DMapAnnotationType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapAnnotationType dMapAnnotationType = new DMapAnnotationType("DMapAnnotationType_TrafficLight");
        DMapAnnotationType_TrafficLight = dMapAnnotationType;
        swigValues = new DMapAnnotationType[]{dMapAnnotationType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapAnnotationType swigToEnum(int i) {
        DMapAnnotationType[] dMapAnnotationTypeArr = swigValues;
        if (i < dMapAnnotationTypeArr.length && i >= 0 && dMapAnnotationTypeArr[i].swigValue == i) {
            return dMapAnnotationTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapAnnotationType[] dMapAnnotationTypeArr2 = swigValues;
            if (i2 >= dMapAnnotationTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapAnnotationType.class + " with value " + i);
            } else if (dMapAnnotationTypeArr2[i2].swigValue == i) {
                return dMapAnnotationTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapAnnotationType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapAnnotationType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapAnnotationType(String str, DMapAnnotationType dMapAnnotationType) {
        this.swigName = str;
        int i = dMapAnnotationType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
