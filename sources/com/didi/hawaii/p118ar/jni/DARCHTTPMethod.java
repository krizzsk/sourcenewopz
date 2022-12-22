package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCHTTPMethod */
public final class DARCHTTPMethod {
    public static final DARCHTTPMethod DARCHTTPMethod_Get = new DARCHTTPMethod("DARCHTTPMethod_Get");
    public static final DARCHTTPMethod DARCHTTPMethod_Post;
    private static int swigNext = 0;
    private static DARCHTTPMethod[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCHTTPMethod dARCHTTPMethod = new DARCHTTPMethod("DARCHTTPMethod_Post");
        DARCHTTPMethod_Post = dARCHTTPMethod;
        swigValues = new DARCHTTPMethod[]{DARCHTTPMethod_Get, dARCHTTPMethod};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCHTTPMethod swigToEnum(int i) {
        DARCHTTPMethod[] dARCHTTPMethodArr = swigValues;
        if (i < dARCHTTPMethodArr.length && i >= 0 && dARCHTTPMethodArr[i].swigValue == i) {
            return dARCHTTPMethodArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCHTTPMethod[] dARCHTTPMethodArr2 = swigValues;
            if (i2 >= dARCHTTPMethodArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCHTTPMethod.class + " with value " + i);
            } else if (dARCHTTPMethodArr2[i2].swigValue == i) {
                return dARCHTTPMethodArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCHTTPMethod(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCHTTPMethod(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCHTTPMethod(String str, DARCHTTPMethod dARCHTTPMethod) {
        this.swigName = str;
        int i = dARCHTTPMethod.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
