package com.didi.hawaii.mapsdkv2.jni;

public class SwigMapCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected SwigMapCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(SwigMapCallback swigMapCallback) {
        if (swigMapCallback == null) {
            return 0;
        }
        return swigMapCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_SwigMapCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        MapEngineJNIBridge.SwigMapCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapEngineJNIBridge.SwigMapCallback_change_ownership(this, this.swigCPtr, true);
    }

    /* access modifiers changed from: protected */
    public Object OnGetText(String str, float f, int i, int i2, int i3, int i4, boolean z) {
        return getClass() == SwigMapCallback.class ? MapEngineJNIBridge.SwigMapCallback_OnGetText(this.swigCPtr, this, str, f, i, i2, i3, i4, z) : MapEngineJNIBridge.SwigMapCallback_OnGetTextSwigExplicitSwigMapCallback(this.swigCPtr, this, str, f, i, i2, i3, i4, z);
    }

    /* access modifiers changed from: protected */
    public Object OnGetTextSize(String str, int i, boolean z) {
        return getClass() == SwigMapCallback.class ? MapEngineJNIBridge.SwigMapCallback_OnGetTextSize(this.swigCPtr, this, str, i, z) : MapEngineJNIBridge.SwigMapCallback_OnGetTextSizeSwigExplicitSwigMapCallback(this.swigCPtr, this, str, i, z);
    }

    /* access modifiers changed from: protected */
    public void OnDownload(String str) {
        if (getClass() == SwigMapCallback.class) {
            MapEngineJNIBridge.SwigMapCallback_OnDownload(this.swigCPtr, this, str);
        } else {
            MapEngineJNIBridge.SwigMapCallback_OnDownloadSwigExplicitSwigMapCallback(this.swigCPtr, this, str);
        }
    }

    /* access modifiers changed from: protected */
    public Object OnGetImage(int i, String str) {
        return getClass() == SwigMapCallback.class ? MapEngineJNIBridge.SwigMapCallback_OnGetImage(this.swigCPtr, this, i, str) : MapEngineJNIBridge.SwigMapCallback_OnGetImageSwigExplicitSwigMapCallback(this.swigCPtr, this, i, str);
    }

    public void OnWriteFile(String str, byte[] bArr) {
        if (getClass() == SwigMapCallback.class) {
            MapEngineJNIBridge.SwigMapCallback_OnWriteFile(this.swigCPtr, this, str, bArr);
        } else {
            MapEngineJNIBridge.SwigMapCallback_OnWriteFileSwigExplicitSwigMapCallback(this.swigCPtr, this, str, bArr);
        }
    }

    /* access modifiers changed from: protected */
    public Object OnLoadHeatTile(int i, int i2, int i3) {
        return getClass() == SwigMapCallback.class ? MapEngineJNIBridge.SwigMapCallback_OnLoadHeatTile(this.swigCPtr, this, i, i2, i3) : MapEngineJNIBridge.SwigMapCallback_OnLoadHeatTileSwigExplicitSwigMapCallback(this.swigCPtr, this, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void OnLabelOnRouteList(Object obj) {
        if (getClass() == SwigMapCallback.class) {
            MapEngineJNIBridge.SwigMapCallback_OnLabelOnRouteList(this.swigCPtr, this, obj);
        } else {
            MapEngineJNIBridge.SwigMapCallback_OnLabelOnRouteListSwigExplicitSwigMapCallback(this.swigCPtr, this, obj);
        }
    }

    public void OnMapDynamicLayerDownload(boolean z, String str, byte[] bArr, int i) {
        if (getClass() == SwigMapCallback.class) {
            MapEngineJNIBridge.SwigMapCallback_OnMapDynamicLayerDownload(this.swigCPtr, this, z, str, bArr, i);
        } else {
            MapEngineJNIBridge.m17235x371f0ab2(this.swigCPtr, this, z, str, bArr, i);
        }
    }

    public SwigMapCallback() {
        this(MapEngineJNIBridge.new_SwigMapCallback(), true);
        MapEngineJNIBridge.SwigMapCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
