package com.didi.hawaii.mapsdkv2.jni;

import java.math.BigInteger;

public class DGLMapTappedElement {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DGLMapTappedElement(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DGLMapTappedElement dGLMapTappedElement) {
        if (dGLMapTappedElement == null) {
            return 0;
        }
        return dGLMapTappedElement.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DGLMapTappedElement(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setType(DMapTappedElementType dMapTappedElementType) {
        MapEngineJNIBridge.DGLMapTappedElement_type_set(this.swigCPtr, this, dMapTappedElementType.swigValue());
    }

    public DMapTappedElementType getType() {
        return DMapTappedElementType.swigToEnum(MapEngineJNIBridge.DGLMapTappedElement_type_get(this.swigCPtr, this));
    }

    public void setX(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_x_set(this.swigCPtr, this, i);
    }

    public int getX() {
        return MapEngineJNIBridge.DGLMapTappedElement_x_get(this.swigCPtr, this);
    }

    public void setY(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_y_set(this.swigCPtr, this, i);
    }

    public int getY() {
        return MapEngineJNIBridge.DGLMapTappedElement_y_get(this.swigCPtr, this);
    }

    public void setItemType(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_itemType_set(this.swigCPtr, this, i);
    }

    public int getItemType() {
        return MapEngineJNIBridge.DGLMapTappedElement_itemType_get(this.swigCPtr, this);
    }

    public void setNameLen(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_nameLen_set(this.swigCPtr, this, i);
    }

    public int getNameLen() {
        return MapEngineJNIBridge.DGLMapTappedElement_nameLen_get(this.swigCPtr, this);
    }

    public void setName(int[] iArr) {
        MapEngineJNIBridge.DGLMapTappedElement_name_set(this.swigCPtr, this, iArr);
    }

    public int[] getName() {
        return MapEngineJNIBridge.DGLMapTappedElement_name_get(this.swigCPtr, this);
    }

    public void setItemId(SWIGTYPE_p_void sWIGTYPE_p_void) {
        MapEngineJNIBridge.DGLMapTappedElement_itemId_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public SWIGTYPE_p_void getItemId() {
        long DGLMapTappedElement_itemId_get = MapEngineJNIBridge.DGLMapTappedElement_itemId_get(this.swigCPtr, this);
        if (DGLMapTappedElement_itemId_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(DGLMapTappedElement_itemId_get, false);
    }

    public void setIdentity(BigInteger bigInteger) {
        MapEngineJNIBridge.DGLMapTappedElement_identity_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getIdentity() {
        return MapEngineJNIBridge.DGLMapTappedElement_identity_get(this.swigCPtr, this);
    }

    public void setSubIndex(short s) {
        MapEngineJNIBridge.DGLMapTappedElement_subIndex_set(this.swigCPtr, this, s);
    }

    public short getSubIndex() {
        return MapEngineJNIBridge.DGLMapTappedElement_subIndex_get(this.swigCPtr, this);
    }

    public void setAboardPointUrlLen(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_aboardPointUrlLen_set(this.swigCPtr, this, i);
    }

    public int getAboardPointUrlLen() {
        return MapEngineJNIBridge.DGLMapTappedElement_aboardPointUrlLen_get(this.swigCPtr, this);
    }

    public void setAboardPointUrl(short[] sArr) {
        MapEngineJNIBridge.DGLMapTappedElement_aboardPointUrl_set(this.swigCPtr, this, sArr);
    }

    public short[] getAboardPointUrl() {
        return MapEngineJNIBridge.DGLMapTappedElement_aboardPointUrl_get(this.swigCPtr, this);
    }

    public void setBusPbBuffer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        MapEngineJNIBridge.DGLMapTappedElement_busPbBuffer_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getBusPbBuffer() {
        long DGLMapTappedElement_busPbBuffer_get = MapEngineJNIBridge.DGLMapTappedElement_busPbBuffer_get(this.swigCPtr, this);
        if (DGLMapTappedElement_busPbBuffer_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(DGLMapTappedElement_busPbBuffer_get, false);
    }

    public void setBusPbBufferLen(int i) {
        MapEngineJNIBridge.DGLMapTappedElement_busPbBufferLen_set(this.swigCPtr, this, i);
    }

    public int getBusPbBufferLen() {
        return MapEngineJNIBridge.DGLMapTappedElement_busPbBufferLen_get(this.swigCPtr, this);
    }

    public void setVioParkingContent(DGLMapVioParkBizContent dGLMapVioParkBizContent) {
        MapEngineJNIBridge.DGLMapTappedElement_vioParkingContent_set(this.swigCPtr, this, DGLMapVioParkBizContent.getCPtr(dGLMapVioParkBizContent), dGLMapVioParkBizContent);
    }

    public DGLMapVioParkBizContent getVioParkingContent() {
        long DGLMapTappedElement_vioParkingContent_get = MapEngineJNIBridge.DGLMapTappedElement_vioParkingContent_get(this.swigCPtr, this);
        if (DGLMapTappedElement_vioParkingContent_get == 0) {
            return null;
        }
        return new DGLMapVioParkBizContent(DGLMapTappedElement_vioParkingContent_get, false);
    }

    public DGLMapTappedElement() {
        this(MapEngineJNIBridge.new_DGLMapTappedElement(), true);
    }
}
