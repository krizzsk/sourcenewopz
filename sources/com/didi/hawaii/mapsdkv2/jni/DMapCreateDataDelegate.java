package com.didi.hawaii.mapsdkv2.jni;

public class DMapCreateDataDelegate {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DMapCreateDataDelegate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DMapCreateDataDelegate dMapCreateDataDelegate) {
        if (dMapCreateDataDelegate == null) {
            return 0;
        }
        return dMapCreateDataDelegate.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DMapCreateDataDelegate(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setTheme(DMapTheme dMapTheme) {
        MapEngineJNIBridge.DMapCreateDataDelegate_theme_set(this.swigCPtr, this, dMapTheme.swigValue());
    }

    public DMapTheme getTheme() {
        return DMapTheme.swigToEnum(MapEngineJNIBridge.DMapCreateDataDelegate_theme_get(this.swigCPtr, this));
    }

    public void setIsVectorMap(boolean z) {
        MapEngineJNIBridge.DMapCreateDataDelegate_isVectorMap_set(this.swigCPtr, this, z);
    }

    public boolean getIsVectorMap() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_isVectorMap_get(this.swigCPtr, this);
    }

    public void setDensity(float f) {
        MapEngineJNIBridge.DMapCreateDataDelegate_density_set(this.swigCPtr, this, f);
    }

    public float getDensity() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_density_get(this.swigCPtr, this);
    }

    public void setIsRetina(boolean z) {
        MapEngineJNIBridge.DMapCreateDataDelegate_isRetina_set(this.swigCPtr, this, z);
    }

    public boolean getIsRetina() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_isRetina_get(this.swigCPtr, this);
    }

    public void setTileSize(int i) {
        MapEngineJNIBridge.DMapCreateDataDelegate_tileSize_set(this.swigCPtr, this, i);
    }

    public int getTileSize() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_tileSize_get(this.swigCPtr, this);
    }

    public void setTextScale(float f) {
        MapEngineJNIBridge.DMapCreateDataDelegate_textScale_set(this.swigCPtr, this, f);
    }

    public float getTextScale() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_textScale_get(this.swigCPtr, this);
    }

    public void setMainContext(SWIGTYPE_p_void sWIGTYPE_p_void) {
        MapEngineJNIBridge.DMapCreateDataDelegate_mainContext_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getMainContext() {
        long DMapCreateDataDelegate_mainContext_get = MapEngineJNIBridge.DMapCreateDataDelegate_mainContext_get(this.swigCPtr, this);
        if (DMapCreateDataDelegate_mainContext_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(DMapCreateDataDelegate_mainContext_get, false);
    }

    public void setBackContext(SWIGTYPE_p_void sWIGTYPE_p_void) {
        MapEngineJNIBridge.DMapCreateDataDelegate_backContext_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getBackContext() {
        long DMapCreateDataDelegate_backContext_get = MapEngineJNIBridge.DMapCreateDataDelegate_backContext_get(this.swigCPtr, this);
        if (DMapCreateDataDelegate_backContext_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(DMapCreateDataDelegate_backContext_get, false);
    }

    public void setLanguage(DMapLanguage dMapLanguage) {
        MapEngineJNIBridge.DMapCreateDataDelegate_language_set(this.swigCPtr, this, dMapLanguage.swigValue());
    }

    public DMapLanguage getLanguage() {
        return DMapLanguage.swigToEnum(MapEngineJNIBridge.DMapCreateDataDelegate_language_get(this.swigCPtr, this));
    }

    public void setMapEngineVersion(long j) {
        MapEngineJNIBridge.DMapCreateDataDelegate_mapEngineVersion_set(this.swigCPtr, this, j);
    }

    public long getMapEngineVersion() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_mapEngineVersion_get(this.swigCPtr, this);
    }

    public void setMultiSimple(int i) {
        MapEngineJNIBridge.DMapCreateDataDelegate_multiSimple_set(this.swigCPtr, this, i);
    }

    public int getMultiSimple() {
        return MapEngineJNIBridge.DMapCreateDataDelegate_multiSimple_get(this.swigCPtr, this);
    }

    public DMapCreateDataDelegate() {
        this(MapEngineJNIBridge.new_DMapCreateDataDelegate(), true);
    }
}
