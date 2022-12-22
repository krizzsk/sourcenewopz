package com.didi.hawaii.mapsdkv2.jni;

public final class DMapDynamicLayerType {
    public static final DMapDynamicLayerType DMapDynamicLayerTypeActivity;
    public static final DMapDynamicLayerType DMapDynamicLayerTypeCloseAll = new DMapDynamicLayerType("DMapDynamicLayerTypeCloseAll", MapEngineJNIBridge.DMapDynamicLayerTypeCloseAll_get());
    public static final DMapDynamicLayerType DMapDynamicLayerTypeRoadClosure = new DMapDynamicLayerType("DMapDynamicLayerTypeRoadClosure", MapEngineJNIBridge.DMapDynamicLayerTypeRoadClosure_get());
    public static final DMapDynamicLayerType DMapDynamicLayerTypeTrafficEvent = new DMapDynamicLayerType("DMapDynamicLayerTypeTrafficEvent", MapEngineJNIBridge.DMapDynamicLayerTypeTrafficEvent_get());
    public static final DMapDynamicLayerType DMapDynamicLayerTypeVioParking = new DMapDynamicLayerType("DMapDynamicLayerTypeVioParking", MapEngineJNIBridge.DMapDynamicLayerTypeVioParking_get());
    private static int swigNext = 0;
    private static DMapDynamicLayerType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapDynamicLayerType dMapDynamicLayerType = new DMapDynamicLayerType("DMapDynamicLayerTypeActivity", MapEngineJNIBridge.DMapDynamicLayerTypeActivity_get());
        DMapDynamicLayerTypeActivity = dMapDynamicLayerType;
        swigValues = new DMapDynamicLayerType[]{DMapDynamicLayerTypeCloseAll, DMapDynamicLayerTypeTrafficEvent, DMapDynamicLayerTypeVioParking, DMapDynamicLayerTypeRoadClosure, dMapDynamicLayerType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapDynamicLayerType swigToEnum(int i) {
        DMapDynamicLayerType[] dMapDynamicLayerTypeArr = swigValues;
        if (i < dMapDynamicLayerTypeArr.length && i >= 0 && dMapDynamicLayerTypeArr[i].swigValue == i) {
            return dMapDynamicLayerTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapDynamicLayerType[] dMapDynamicLayerTypeArr2 = swigValues;
            if (i2 >= dMapDynamicLayerTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapDynamicLayerType.class + " with value " + i);
            } else if (dMapDynamicLayerTypeArr2[i2].swigValue == i) {
                return dMapDynamicLayerTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapDynamicLayerType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapDynamicLayerType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapDynamicLayerType(String str, DMapDynamicLayerType dMapDynamicLayerType) {
        this.swigName = str;
        int i = dMapDynamicLayerType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
