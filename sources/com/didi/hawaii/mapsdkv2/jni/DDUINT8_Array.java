package com.didi.hawaii.mapsdkv2.jni;

public class DDUINT8_Array {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected DDUINT8_Array(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DDUINT8_Array dDUINT8_Array) {
        if (dDUINT8_Array == null) {
            return 0;
        }
        return dDUINT8_Array.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_DDUINT8_Array(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DDUINT8_Array(int i) {
        this(MapEngineJNIBridge.new_DDUINT8_Array(i), true);
    }

    public short getitem(int i) {
        return MapEngineJNIBridge.DDUINT8_Array_getitem(this.swigCPtr, this, i);
    }

    public void setitem(int i, short s) {
        MapEngineJNIBridge.DDUINT8_Array_setitem(this.swigCPtr, this, i, s);
    }

    public SWIGTYPE_p_unsigned_char cast() {
        long DDUINT8_Array_cast = MapEngineJNIBridge.DDUINT8_Array_cast(this.swigCPtr, this);
        if (DDUINT8_Array_cast == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(DDUINT8_Array_cast, false);
    }

    public static DDUINT8_Array frompointer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        long DDUINT8_Array_frompointer = MapEngineJNIBridge.DDUINT8_Array_frompointer(SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
        if (DDUINT8_Array_frompointer == 0) {
            return null;
        }
        return new DDUINT8_Array(DDUINT8_Array_frompointer, false);
    }
}
