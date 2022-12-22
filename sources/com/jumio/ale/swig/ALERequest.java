package com.jumio.ale.swig;

public class ALERequest {

    /* renamed from: a */
    public transient long f54510a;
    public transient boolean swigCMemOwn;

    public ALERequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f54510a = j;
    }

    public static long getCPtr(ALERequest aLERequest) {
        if (aLERequest == null) {
            return 0;
        }
        return aLERequest.f54510a;
    }

    public int calculateRequestFinish() {
        return aleEngineJNI.ALERequest_calculateRequestFinish(this.f54510a, this);
    }

    public int calculateRequestInit(ALEHeader aLEHeader, int i) {
        return aleEngineJNI.ALERequest_calculateRequestInit(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i);
    }

    public int calculateRequestSize(ALEHeader aLEHeader, int i) {
        return aleEngineJNI.ALERequest_calculateRequestSize(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i);
    }

    public int calculateRequestUpdate(int i) {
        return aleEngineJNI.ALERequest_calculateRequestUpdate(this.f54510a, this, i);
    }

    public int calculateResponseSize(byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_calculateResponseSize(this.f54510a, this, bArr);
    }

    public synchronized void delete() {
        if (this.f54510a != 0) {
            if (!this.swigCMemOwn) {
                this.f54510a = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public int finishRequest(byte[] bArr, int i) throws Exception {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_0(this.f54510a, this, bArr, i);
    }

    public boolean finishResponse() throws Exception {
        return aleEngineJNI.ALERequest_finishResponse(this.f54510a, this);
    }

    public int getErrorCode() {
        return aleEngineJNI.ALERequest_getErrorCode(this.f54510a, this);
    }

    public int initRequest(ALEHeader aLEHeader, int i, byte[] bArr, int i2) throws Exception {
        return aleEngineJNI.ALERequest_initRequest__SWIG_0(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i, bArr, i2);
    }

    public void initResponse() {
        aleEngineJNI.ALERequest_initResponse(this.f54510a, this);
    }

    public boolean isKeyUpdate() {
        return aleEngineJNI.ALERequest_isKeyUpdate(this.f54510a, this);
    }

    public boolean isVerified() {
        return aleEngineJNI.ALERequest_isVerified(this.f54510a, this);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2, int i) throws Exception {
        return aleEngineJNI.ALERequest_request__SWIG_0(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2, i);
    }

    public int response(byte[] bArr, byte[] bArr2, int i) throws Exception {
        return aleEngineJNI.ALERequest_response__SWIG_0(this.f54510a, this, bArr, bArr2, i);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2, int i) throws Exception {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_0(this.f54510a, this, bArr, bArr2, i);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2, int i) throws Exception {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_0(this.f54510a, this, bArr, bArr2, i);
    }

    public int finishRequest(byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_1(this.f54510a, this, bArr);
    }

    public int initRequest(ALEHeader aLEHeader, int i, byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_initRequest__SWIG_1(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i, bArr);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_request__SWIG_1(this.f54510a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2);
    }

    public int response(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_response__SWIG_1(this.f54510a, this, bArr, bArr2);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_1(this.f54510a, this, bArr, bArr2);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_1(this.f54510a, this, bArr, bArr2);
    }
}
