package com.didi.hawaii.mapsdkv2.jni;

public final class DMapTappedETTextAnnoItemType {
    public static final DMapTappedETTextAnnoItemType DMapTappedETTextAnnoITBusStation = new DMapTappedETTextAnnoItemType("DMapTappedETTextAnnoITBusStation");
    public static final DMapTappedETTextAnnoItemType DMapTappedETTextAnnoITNone = new DMapTappedETTextAnnoItemType("DMapTappedETTextAnnoITNone", MapEngineJNIBridge.DMapTappedETTextAnnoITNone_get());
    public static final DMapTappedETTextAnnoItemType DMapTappedETTextAnnoITSubwayStation;
    private static int swigNext = 0;
    private static DMapTappedETTextAnnoItemType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapTappedETTextAnnoItemType dMapTappedETTextAnnoItemType = new DMapTappedETTextAnnoItemType("DMapTappedETTextAnnoITSubwayStation");
        DMapTappedETTextAnnoITSubwayStation = dMapTappedETTextAnnoItemType;
        swigValues = new DMapTappedETTextAnnoItemType[]{DMapTappedETTextAnnoITNone, DMapTappedETTextAnnoITBusStation, dMapTappedETTextAnnoItemType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapTappedETTextAnnoItemType swigToEnum(int i) {
        DMapTappedETTextAnnoItemType[] dMapTappedETTextAnnoItemTypeArr = swigValues;
        if (i < dMapTappedETTextAnnoItemTypeArr.length && i >= 0 && dMapTappedETTextAnnoItemTypeArr[i].swigValue == i) {
            return dMapTappedETTextAnnoItemTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapTappedETTextAnnoItemType[] dMapTappedETTextAnnoItemTypeArr2 = swigValues;
            if (i2 >= dMapTappedETTextAnnoItemTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapTappedETTextAnnoItemType.class + " with value " + i);
            } else if (dMapTappedETTextAnnoItemTypeArr2[i2].swigValue == i) {
                return dMapTappedETTextAnnoItemTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapTappedETTextAnnoItemType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapTappedETTextAnnoItemType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapTappedETTextAnnoItemType(String str, DMapTappedETTextAnnoItemType dMapTappedETTextAnnoItemType) {
        this.swigName = str;
        int i = dMapTappedETTextAnnoItemType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
