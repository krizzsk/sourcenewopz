package com.didi.hawaii.mapsdkv2.jni;

public final class DMapZoomStatus {
    public static final DMapZoomStatus DMapZoomStatus_CARPLAY;
    public static final DMapZoomStatus DMapZoomStatus_HUGE = new DMapZoomStatus("DMapZoomStatus_HUGE", MapEngineJNIBridge.DMapZoomStatus_HUGE_get());
    public static final DMapZoomStatus DMapZoomStatus_INVALID = new DMapZoomStatus("DMapZoomStatus_INVALID", MapEngineJNIBridge.DMapZoomStatus_INVALID_get());
    public static final DMapZoomStatus DMapZoomStatus_LARGE = new DMapZoomStatus("DMapZoomStatus_LARGE", MapEngineJNIBridge.DMapZoomStatus_LARGE_get());
    public static final DMapZoomStatus DMapZoomStatus_NORMAL = new DMapZoomStatus("DMapZoomStatus_NORMAL", MapEngineJNIBridge.DMapZoomStatus_NORMAL_get());
    public static final DMapZoomStatus DMapZoomStatus_SMALL = new DMapZoomStatus("DMapZoomStatus_SMALL", MapEngineJNIBridge.DMapZoomStatus_SMALL_get());
    private static int swigNext = 0;
    private static DMapZoomStatus[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMapZoomStatus dMapZoomStatus = new DMapZoomStatus("DMapZoomStatus_CARPLAY", MapEngineJNIBridge.DMapZoomStatus_CARPLAY_get());
        DMapZoomStatus_CARPLAY = dMapZoomStatus;
        swigValues = new DMapZoomStatus[]{DMapZoomStatus_INVALID, DMapZoomStatus_NORMAL, DMapZoomStatus_LARGE, DMapZoomStatus_HUGE, DMapZoomStatus_SMALL, dMapZoomStatus};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMapZoomStatus swigToEnum(int i) {
        DMapZoomStatus[] dMapZoomStatusArr = swigValues;
        if (i < dMapZoomStatusArr.length && i >= 0 && dMapZoomStatusArr[i].swigValue == i) {
            return dMapZoomStatusArr[i];
        }
        int i2 = 0;
        while (true) {
            DMapZoomStatus[] dMapZoomStatusArr2 = swigValues;
            if (i2 >= dMapZoomStatusArr2.length) {
                throw new IllegalArgumentException("No enum " + DMapZoomStatus.class + " with value " + i);
            } else if (dMapZoomStatusArr2[i2].swigValue == i) {
                return dMapZoomStatusArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMapZoomStatus(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMapZoomStatus(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMapZoomStatus(String str, DMapZoomStatus dMapZoomStatus) {
        this.swigName = str;
        int i = dMapZoomStatus.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
