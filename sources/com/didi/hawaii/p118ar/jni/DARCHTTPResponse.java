package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCHTTPResponse */
public class DARCHTTPResponse extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCHTTPResponse(long j, boolean z) {
        super(AREngineJNIBridge.DARCHTTPResponse_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCHTTPResponse dARCHTTPResponse) {
        if (dARCHTTPResponse == null) {
            return 0;
        }
        return dARCHTTPResponse.swigCPtr;
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

    public static DARCHTTPResponse alloc() {
        long DARCHTTPResponse_alloc = AREngineJNIBridge.DARCHTTPResponse_alloc();
        if (DARCHTTPResponse_alloc == 0) {
            return null;
        }
        return new DARCHTTPResponse(DARCHTTPResponse_alloc, false);
    }

    public void setBody(DARCData dARCData) {
        AREngineJNIBridge.DARCHTTPResponse_setBody(this.swigCPtr, this, DARCData.getCPtr(dARCData), dARCData);
    }

    public DARCData getBody() {
        long DARCHTTPResponse_getBody = AREngineJNIBridge.DARCHTTPResponse_getBody(this.swigCPtr, this);
        if (DARCHTTPResponse_getBody == 0) {
            return null;
        }
        return new DARCData(DARCHTTPResponse_getBody, false);
    }

    public void setStatus(int i) {
        AREngineJNIBridge.DARCHTTPResponse_setStatus(this.swigCPtr, this, i);
    }

    public int getStatus() {
        return AREngineJNIBridge.DARCHTTPResponse_getStatus(this.swigCPtr, this);
    }

    public void setOriginalRequest(DARCHTTPRequest dARCHTTPRequest) {
        AREngineJNIBridge.DARCHTTPResponse_setOriginalRequest(this.swigCPtr, this, DARCHTTPRequest.getCPtr(dARCHTTPRequest), dARCHTTPRequest);
    }

    public DARCHTTPRequest getOriginalRequest() {
        long DARCHTTPResponse_getOriginalRequest = AREngineJNIBridge.DARCHTTPResponse_getOriginalRequest(this.swigCPtr, this);
        if (DARCHTTPResponse_getOriginalRequest == 0) {
            return null;
        }
        return new DARCHTTPRequest(DARCHTTPResponse_getOriginalRequest, false);
    }
}
