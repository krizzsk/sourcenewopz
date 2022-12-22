package com.didi.hawaii.mapsdkv2.jni;

public class DGLMapVioParkBizContent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DGLMapVioParkBizContent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DGLMapVioParkBizContent dGLMapVioParkBizContent) {
        if (dGLMapVioParkBizContent == null) {
            return 0;
        }
        return dGLMapVioParkBizContent.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DGLMapVioParkBizContent(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setBizType(int i) {
        MapEngineJNIBridge.DGLMapVioParkBizContent_bizType_set(this.swigCPtr, this, i);
    }

    public int getBizType() {
        return MapEngineJNIBridge.DGLMapVioParkBizContent_bizType_get(this.swigCPtr, this);
    }

    public void setDataVersion(String str) {
        MapEngineJNIBridge.DGLMapVioParkBizContent_dataVersion_set(this.swigCPtr, this, str);
    }

    public String getDataVersion() {
        return MapEngineJNIBridge.DGLMapVioParkBizContent_dataVersion_get(this.swigCPtr, this);
    }

    public void setUniqID(String str) {
        MapEngineJNIBridge.DGLMapVioParkBizContent_uniqID_set(this.swigCPtr, this, str);
    }

    public String getUniqID() {
        return MapEngineJNIBridge.DGLMapVioParkBizContent_uniqID_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        MapEngineJNIBridge.DGLMapVioParkBizContent_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return MapEngineJNIBridge.DGLMapVioParkBizContent_name_get(this.swigCPtr, this);
    }

    public DGLMapVioParkBizContent() {
        this(MapEngineJNIBridge.new_DGLMapVioParkBizContent(), true);
    }
}
