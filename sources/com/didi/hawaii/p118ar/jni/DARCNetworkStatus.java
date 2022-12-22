package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCNetworkStatus */
public final class DARCNetworkStatus {
    public static final DARCNetworkStatus DARCNetworkStatus_NotReachable = new DARCNetworkStatus("DARCNetworkStatus_NotReachable", AREngineJNIBridge.DARCNetworkStatus_NotReachable_get());
    public static final DARCNetworkStatus DARCNetworkStatus_ReachableViaWWAN;
    public static final DARCNetworkStatus DARCNetworkStatus_ReachableViaWiFi = new DARCNetworkStatus("DARCNetworkStatus_ReachableViaWiFi");
    private static int swigNext = 0;
    private static DARCNetworkStatus[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DARCNetworkStatus dARCNetworkStatus = new DARCNetworkStatus("DARCNetworkStatus_ReachableViaWWAN");
        DARCNetworkStatus_ReachableViaWWAN = dARCNetworkStatus;
        swigValues = new DARCNetworkStatus[]{DARCNetworkStatus_NotReachable, DARCNetworkStatus_ReachableViaWiFi, dARCNetworkStatus};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DARCNetworkStatus swigToEnum(int i) {
        DARCNetworkStatus[] dARCNetworkStatusArr = swigValues;
        if (i < dARCNetworkStatusArr.length && i >= 0 && dARCNetworkStatusArr[i].swigValue == i) {
            return dARCNetworkStatusArr[i];
        }
        int i2 = 0;
        while (true) {
            DARCNetworkStatus[] dARCNetworkStatusArr2 = swigValues;
            if (i2 >= dARCNetworkStatusArr2.length) {
                throw new IllegalArgumentException("No enum " + DARCNetworkStatus.class + " with value " + i);
            } else if (dARCNetworkStatusArr2[i2].swigValue == i) {
                return dARCNetworkStatusArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DARCNetworkStatus(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DARCNetworkStatus(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DARCNetworkStatus(String str, DARCNetworkStatus dARCNetworkStatus) {
        this.swigName = str;
        int i = dARCNetworkStatus.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
