package com.didi.hawaii.mapsdkv2.jni;

public final class DMapTappedElementType {
    public static final DMapTappedElementType KDGLMapTappedAboardRelationPointItem = new DMapTappedElementType("KDGLMapTappedAboardRelationPointItem");
    public static final DMapTappedElementType kDGLMapTappedClosureAnnotation = new DMapTappedElementType("kDGLMapTappedClosureAnnotation");
    public static final DMapTappedElementType kDGLMapTappedCompass = new DMapTappedElementType("kDGLMapTappedCompass");
    public static final DMapTappedElementType kDGLMapTappedExtendRenderIconItem = new DMapTappedElementType("kDGLMapTappedExtendRenderIconItem");
    public static final DMapTappedElementType kDGLMapTappedLineOverlayItem = new DMapTappedElementType("kDGLMapTappedLineOverlayItem");
    public static final DMapTappedElementType kDGLMapTappedLocator = new DMapTappedElementType("kDGLMapTappedLocator");
    public static final DMapTappedElementType kDGLMapTappedNone = new DMapTappedElementType("kDGLMapTappedNone");
    public static final DMapTappedElementType kDGLMapTappedOverlayItem = new DMapTappedElementType("kDGLMapTappedOverlayItem");
    public static final DMapTappedElementType kDGLMapTappedTextAnnotation = new DMapTappedElementType("kDGLMapTappedTextAnnotation");
    public static final DMapTappedElementType kDGLMapTappedTrafficEventIconItem = new DMapTappedElementType("kDGLMapTappedTrafficEventIconItem");
    public static final DMapTappedElementType kDGLMapTappedVioParkingIconItem = new DMapTappedElementType("kDGLMapTappedVioParkingIconItem");
    public static final DMapTappedElementType kDGLMapTappedVioParkingLineItem = new DMapTappedElementType("kDGLMapTappedVioParkingLineItem");
    public static final DMapTappedElementType kDTappedElementTypeMax;
    private static int swigNext = 0;
    private static DMapTappedElementType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapTappedElementType dMapTappedElementType = new DMapTappedElementType("kDTappedElementTypeMax");
        kDTappedElementTypeMax = dMapTappedElementType;
        swigValues = new DMapTappedElementType[]{kDGLMapTappedNone, kDGLMapTappedTextAnnotation, kDGLMapTappedClosureAnnotation, kDGLMapTappedCompass, kDGLMapTappedOverlayItem, kDGLMapTappedLineOverlayItem, kDGLMapTappedLocator, kDGLMapTappedTrafficEventIconItem, kDGLMapTappedExtendRenderIconItem, KDGLMapTappedAboardRelationPointItem, kDGLMapTappedVioParkingIconItem, kDGLMapTappedVioParkingLineItem, dMapTappedElementType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapTappedElementType swigToEnum(int i) {
        DMapTappedElementType[] dMapTappedElementTypeArr = swigValues;
        if (i < dMapTappedElementTypeArr.length && i >= 0 && dMapTappedElementTypeArr[i].swigValue == i) {
            return dMapTappedElementTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapTappedElementType[] dMapTappedElementTypeArr2 = swigValues;
            if (i2 >= dMapTappedElementTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapTappedElementType.class + " with value " + i);
            } else if (dMapTappedElementTypeArr2[i2].swigValue == i) {
                return dMapTappedElementTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapTappedElementType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapTappedElementType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapTappedElementType(String str, DMapTappedElementType dMapTappedElementType) {
        this.swigName = str;
        int i = dMapTappedElementType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
