package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class RequestInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RequestInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RequestInfo requestInfo) {
        if (requestInfo == null) {
            return 0;
        }
        return requestInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RequestInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setCurrentTime(BigInteger bigInteger) {
        NaviBusinessJNI.RequestInfo_currentTime_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getCurrentTime() {
        return NaviBusinessJNI.RequestInfo_currentTime_get(this.swigCPtr, this);
    }

    public void setSeq(int i) {
        NaviBusinessJNI.RequestInfo_seq_set(this.swigCPtr, this, i);
    }

    public int getSeq() {
        return NaviBusinessJNI.RequestInfo_seq_get(this.swigCPtr, this);
    }

    public void setSessionId(String str) {
        NaviBusinessJNI.RequestInfo_sessionId_set(this.swigCPtr, this, str);
    }

    public String getSessionId() {
        return NaviBusinessJNI.RequestInfo_sessionId_get(this.swigCPtr, this);
    }

    public void setTraceId(String str) {
        NaviBusinessJNI.RequestInfo_traceId_set(this.swigCPtr, this, str);
    }

    public String getTraceId() {
        return NaviBusinessJNI.RequestInfo_traceId_get(this.swigCPtr, this);
    }

    public void setSpanId(String str) {
        NaviBusinessJNI.RequestInfo_spanId_set(this.swigCPtr, this, str);
    }

    public String getSpanId() {
        return NaviBusinessJNI.RequestInfo_spanId_get(this.swigCPtr, this);
    }

    public void setLogId(String str) {
        NaviBusinessJNI.RequestInfo_logId_set(this.swigCPtr, this, str);
    }

    public String getLogId() {
        return NaviBusinessJNI.RequestInfo_logId_get(this.swigCPtr, this);
    }

    public void setTripId(String str) {
        NaviBusinessJNI.RequestInfo_tripId_set(this.swigCPtr, this, str);
    }

    public String getTripId() {
        return NaviBusinessJNI.RequestInfo_tripId_get(this.swigCPtr, this);
    }

    public RequestInfo() {
        this(NaviBusinessJNI.new_RequestInfo(), true);
    }
}
