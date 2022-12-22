package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCData */
public class DARCData extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCData(long j, boolean z) {
        super(AREngineJNIBridge.DARCData_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCData dARCData) {
        if (dARCData == null) {
            return 0;
        }
        return dARCData.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
        super.delete();
    }

    public static DARCData alloc() {
        long DARCData_alloc = AREngineJNIBridge.DARCData_alloc();
        if (DARCData_alloc == 0) {
            return null;
        }
        return new DARCData(DARCData_alloc, false);
    }

    public long getLength() {
        return AREngineJNIBridge.DARCData_getLength(this.swigCPtr, this);
    }

    public void setData(byte[] bArr, long j) {
        AREngineJNIBridge.DARCData_setData(this.swigCPtr, this, bArr, j);
    }

    public void setDataNoCopy(byte[] bArr, long j, boolean z) {
        AREngineJNIBridge.DARCData_setDataNoCopy(this.swigCPtr, this, bArr, j, z);
    }

    public void clear() {
        AREngineJNIBridge.DARCData_clear(this.swigCPtr, this);
    }

    public void zero() {
        AREngineJNIBridge.DARCData_zero(this.swigCPtr, this);
    }
}
