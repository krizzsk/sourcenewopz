package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCHTTPRequest */
public class DARCHTTPRequest extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCHTTPRequest(long j, boolean z) {
        super(AREngineJNIBridge.DARCHTTPRequest_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCHTTPRequest dARCHTTPRequest) {
        if (dARCHTTPRequest == null) {
            return 0;
        }
        return dARCHTTPRequest.swigCPtr;
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

    public static DARCHTTPRequest alloc() {
        long DARCHTTPRequest_alloc = AREngineJNIBridge.DARCHTTPRequest_alloc();
        if (DARCHTTPRequest_alloc == 0) {
            return null;
        }
        return new DARCHTTPRequest(DARCHTTPRequest_alloc, false);
    }

    public void setBody(DARCData dARCData) {
        AREngineJNIBridge.DARCHTTPRequest_setBody(this.swigCPtr, this, DARCData.getCPtr(dARCData), dARCData);
    }

    public DARCData getBody() {
        long DARCHTTPRequest_getBody = AREngineJNIBridge.DARCHTTPRequest_getBody(this.swigCPtr, this);
        if (DARCHTTPRequest_getBody == 0) {
            return null;
        }
        return new DARCData(DARCHTTPRequest_getBody, false);
    }

    public void setType(int i) {
        AREngineJNIBridge.DARCHTTPRequest_type_set(this.swigCPtr, this, i);
    }

    public int getType() {
        return AREngineJNIBridge.DARCHTTPRequest_type_get(this.swigCPtr, this);
    }

    public void setRequestID(int i) {
        AREngineJNIBridge.DARCHTTPRequest_requestID_set(this.swigCPtr, this, i);
    }

    public int getRequestID() {
        return AREngineJNIBridge.DARCHTTPRequest_requestID_get(this.swigCPtr, this);
    }

    public void setURL(String str) {
        AREngineJNIBridge.DARCHTTPRequest_URL_set(this.swigCPtr, this, str);
    }

    public String getURL() {
        return AREngineJNIBridge.DARCHTTPRequest_URL_get(this.swigCPtr, this);
    }

    public void setMethod(DARCHTTPMethod dARCHTTPMethod) {
        AREngineJNIBridge.DARCHTTPRequest_method_set(this.swigCPtr, this, dARCHTTPMethod.swigValue());
    }

    public DARCHTTPMethod getMethod() {
        return DARCHTTPMethod.swigToEnum(AREngineJNIBridge.DARCHTTPRequest_method_get(this.swigCPtr, this));
    }

    public void setTimeout(int i) {
        AREngineJNIBridge.DARCHTTPRequest_timeout_set(this.swigCPtr, this, i);
    }

    public int getTimeout() {
        return AREngineJNIBridge.DARCHTTPRequest_timeout_get(this.swigCPtr, this);
    }
}
