package com.didi.hawaii.mapsdkv2.jni;

public class MarginTable {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MarginTable(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MarginTable marginTable) {
        if (marginTable == null) {
            return 0;
        }
        return marginTable.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_MarginTable(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setMinscale(int i) {
        MapEngineJNIBridge.MarginTable_minscale_set(this.swigCPtr, this, i);
    }

    public int getMinscale() {
        return MapEngineJNIBridge.MarginTable_minscale_get(this.swigCPtr, this);
    }

    public void setMaxscale(int i) {
        MapEngineJNIBridge.MarginTable_maxscale_set(this.swigCPtr, this, i);
    }

    public int getMaxscale() {
        return MapEngineJNIBridge.MarginTable_maxscale_get(this.swigCPtr, this);
    }

    public void setMargin1(float f) {
        MapEngineJNIBridge.MarginTable_margin1_set(this.swigCPtr, this, f);
    }

    public float getMargin1() {
        return MapEngineJNIBridge.MarginTable_margin1_get(this.swigCPtr, this);
    }

    public void setMargin2(float f) {
        MapEngineJNIBridge.MarginTable_margin2_set(this.swigCPtr, this, f);
    }

    public float getMargin2() {
        return MapEngineJNIBridge.MarginTable_margin2_get(this.swigCPtr, this);
    }

    public MarginTable() {
        this(MapEngineJNIBridge.new_MarginTable(), true);
    }
}
