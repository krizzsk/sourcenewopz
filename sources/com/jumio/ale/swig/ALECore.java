package com.jumio.ale.swig;

public class ALECore {

    /* renamed from: a */
    public transient long f54496a;
    public transient boolean swigCMemOwn;

    public ALECore(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f54496a = j;
    }

    public static long getCPtr(ALECore aLECore) {
        if (aLECore == null) {
            return 0;
        }
        return aLECore.f54496a;
    }

    public ALERequest createRequest() throws Exception {
        long ALECore_createRequest = aleEngineJNI.ALECore_createRequest(this.f54496a, this);
        if (ALECore_createRequest == 0) {
            return null;
        }
        return new ALERequest(ALECore_createRequest, false);
    }

    public synchronized void delete() {
        long j = this.f54496a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALECore(j);
            }
            this.f54496a = 0;
        }
    }

    public void destroyRequest(ALERequest aLERequest) {
        aleEngineJNI.ALECore_destroyRequest(this.f54496a, this, ALERequest.getCPtr(aLERequest), aLERequest);
    }

    public void finalize() {
        delete();
    }

    public ALECore(ALESettings aLESettings) {
        this(aleEngineJNI.new_ALECore(ALESettings.getCPtr(aLESettings), aLESettings), true);
    }
}
