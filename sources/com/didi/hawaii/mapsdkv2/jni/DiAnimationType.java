package com.didi.hawaii.mapsdkv2.jni;

public final class DiAnimationType {
    public static final DiAnimationType DiAlpha = new DiAnimationType("DiAlpha");
    public static final DiAnimationType DiScale;
    private static int swigNext = 0;
    private static DiAnimationType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DiAnimationType diAnimationType = new DiAnimationType("DiScale");
        DiScale = diAnimationType;
        swigValues = new DiAnimationType[]{DiAlpha, diAnimationType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DiAnimationType swigToEnum(int i) {
        DiAnimationType[] diAnimationTypeArr = swigValues;
        if (i < diAnimationTypeArr.length && i >= 0 && diAnimationTypeArr[i].swigValue == i) {
            return diAnimationTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DiAnimationType[] diAnimationTypeArr2 = swigValues;
            if (i2 >= diAnimationTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DiAnimationType.class + " with value " + i);
            } else if (diAnimationTypeArr2[i2].swigValue == i) {
                return diAnimationTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DiAnimationType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DiAnimationType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DiAnimationType(String str, DiAnimationType diAnimationType) {
        this.swigName = str;
        int i = diAnimationType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
