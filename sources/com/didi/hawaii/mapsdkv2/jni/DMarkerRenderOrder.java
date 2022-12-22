package com.didi.hawaii.mapsdkv2.jni;

public final class DMarkerRenderOrder {
    public static final DMarkerRenderOrder DMarkerRenderOrder_BelowRoute;
    public static final DMarkerRenderOrder DMarkerRenderOrder_Default = new DMarkerRenderOrder("DMarkerRenderOrder_Default", MapEngineJNIBridge.DMarkerRenderOrder_Default_get());
    private static int swigNext = 0;
    private static DMarkerRenderOrder[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        DMarkerRenderOrder dMarkerRenderOrder = new DMarkerRenderOrder("DMarkerRenderOrder_BelowRoute");
        DMarkerRenderOrder_BelowRoute = dMarkerRenderOrder;
        swigValues = new DMarkerRenderOrder[]{DMarkerRenderOrder_Default, dMarkerRenderOrder};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static DMarkerRenderOrder swigToEnum(int i) {
        DMarkerRenderOrder[] dMarkerRenderOrderArr = swigValues;
        if (i < dMarkerRenderOrderArr.length && i >= 0 && dMarkerRenderOrderArr[i].swigValue == i) {
            return dMarkerRenderOrderArr[i];
        }
        int i2 = 0;
        while (true) {
            DMarkerRenderOrder[] dMarkerRenderOrderArr2 = swigValues;
            if (i2 >= dMarkerRenderOrderArr2.length) {
                throw new IllegalArgumentException("No enum " + DMarkerRenderOrder.class + " with value " + i);
            } else if (dMarkerRenderOrderArr2[i2].swigValue == i) {
                return dMarkerRenderOrderArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private DMarkerRenderOrder(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private DMarkerRenderOrder(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private DMarkerRenderOrder(String str, DMarkerRenderOrder dMarkerRenderOrder) {
        this.swigName = str;
        int i = dMarkerRenderOrder.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
