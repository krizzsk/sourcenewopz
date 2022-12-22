package com.didi.hawaii.mapsdkv2.jni;

public class HWBSManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected HWBSManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(HWBSManager hWBSManager) {
        if (hWBSManager == null) {
            return 0;
        }
        return hWBSManager.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.HWBSManager_destroy(getCPtr(this), this);
            }
            this.swigCPtr = 0;
        }
    }

    public HWBSManager() {
        this(MapEngineJNIBridge.createHWBussManager(), true);
    }

    public void setPWorld(long j) {
        long j2 = this.swigCPtr;
        if (j2 != 0) {
            MapEngineJNIBridge.HWBSManager_setPWorld(j2, this, j);
        }
    }

    public void addOverlay(MapOverlay mapOverlay) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_addOverlay(j, this, MapOverlay.getCPtr(mapOverlay), mapOverlay);
        }
    }

    public boolean removeOverlay(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            return false;
        }
        MapEngineJNIBridge.HWBSManager_removeOverlay(j2, this, j);
        return true;
    }

    public void updateOverlay(MapOverlay mapOverlay) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_updateOverlay(j, this, MapOverlay.getCPtr(mapOverlay), mapOverlay);
        }
    }

    public void updateOverlayName(long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 != 0) {
            MapEngineJNIBridge.HWBSManager_updateOverlayName(j2, this, j, str);
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setPadding(j, this, i, i2, i3, i4);
        }
    }

    public void drawAnimation() {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_drawFrame(j, this);
        }
    }

    public void setMultiBubbleSelectPointEnable(boolean z) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setNewMultiBubbleCollisionEnable(j, this, z);
        }
    }

    public void setAnimateEnable(boolean z, boolean z2) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setAnimateSwitch(j, this, z, z2);
        }
    }

    public void setIsAreaBubbleEnable(boolean z) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setIsAreaBubbleEnable(j, this, z);
        }
    }

    public void setDayNight(boolean z) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setDayNight(j, this, z);
        }
    }

    public void setNavMode(int i) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_setNavMode(j, this, i);
        }
    }

    public void handleCollision() {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_handleCollision(j, this);
        }
    }

    public void initCollisionRect(int i, int i2, int i3, int i4) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_initCollisionRect(j, this, i, i2, i3, i4);
        }
    }

    public long findBubbleId(int i) {
        long j = this.swigCPtr;
        if (j != 0) {
            return MapEngineJNIBridge.HWBSManager_findBubbleId(j, this, i);
        }
        return -1;
    }

    public void getOverlayProperty(long j, int[] iArr, int[] iArr2, int[] iArr3) {
        long j2 = this.swigCPtr;
        if (j2 != 0) {
            MapEngineJNIBridge.HWBSManager_getOverlayProperty(j2, this, j, iArr, iArr2, iArr3);
        }
    }

    public void addRoute4Collision(DMapLine dMapLine) {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_addRoute4Collision(j, this, DMapLine.getCPtr(dMapLine), dMapLine);
        }
    }

    public void clearRoute4Collision() {
        long j = this.swigCPtr;
        if (j != 0) {
            MapEngineJNIBridge.HWBSManager_clearRoute4Collision(j, this);
        }
    }

    public void updateOverlayPosition(long j, double d, double d2) {
        long j2 = this.swigCPtr;
        if (j2 != 0) {
            MapEngineJNIBridge.HWBSManager_updateOverlayPosition(j2, this, j, d, d2);
        }
    }

    public void setOverlayVisible(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 != 0) {
            MapEngineJNIBridge.HWBSManager_setOverlayVisible(j2, this, j, z);
        }
    }

    public static void destroy(HWBSManager hWBSManager) {
        if (hWBSManager.swigCPtr != 0) {
            if (hWBSManager.swigCMemOwn) {
                hWBSManager.swigCMemOwn = false;
                MapEngineJNIBridge.HWBSManager_destroy(getCPtr(hWBSManager), hWBSManager);
            }
            hWBSManager.swigCPtr = 0;
        }
    }
}
