package com.didi.hawaii.mapsdkv2.jni;

public class DMapApolloData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapApolloData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapApolloData dMapApolloData) {
        if (dMapApolloData == null) {
            return 0;
        }
        return dMapApolloData.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapApolloData(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setIntValue(int i) {
        MapEngineJNIBridge.DMapApolloData_intValue_set(this.swigCPtr, this, i);
    }

    public int getIntValue() {
        return MapEngineJNIBridge.DMapApolloData_intValue_get(this.swigCPtr, this);
    }

    public void setStringLength(long j) {
        MapEngineJNIBridge.DMapApolloData_stringLength_set(this.swigCPtr, this, j);
    }

    public long getStringLength() {
        return MapEngineJNIBridge.DMapApolloData_stringLength_get(this.swigCPtr, this);
    }

    public void setBoolValue(boolean z) {
        MapEngineJNIBridge.DMapApolloData_boolValue_set(this.swigCPtr, this, z);
    }

    public boolean getBoolValue() {
        return MapEngineJNIBridge.DMapApolloData_boolValue_get(this.swigCPtr, this);
    }

    public void setStringValue(String str) {
        MapEngineJNIBridge.DMapApolloData_stringValue_set(this.swigCPtr, this, str);
    }

    public String getStringValue() {
        return MapEngineJNIBridge.DMapApolloData_stringValue_get(this.swigCPtr, this);
    }

    public DMapApolloData() {
        this(MapEngineJNIBridge.new_DMapApolloData(), true);
    }
}
