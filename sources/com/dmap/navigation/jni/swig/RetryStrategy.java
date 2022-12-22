package com.dmap.navigation.jni.swig;

public class RetryStrategy {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected RetryStrategy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RetryStrategy retryStrategy) {
        if (retryStrategy == null) {
            return 0;
        }
        return retryStrategy.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_RetryStrategy(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public int getRetryCount() {
        return NaviBusinessJNI.RetryStrategy_getRetryCount(this.swigCPtr, this);
    }

    public int increaseRetryCount() {
        return NaviBusinessJNI.RetryStrategy_increaseRetryCount(this.swigCPtr, this);
    }

    public boolean shouldRetry(int i) {
        return NaviBusinessJNI.RetryStrategy_shouldRetry(this.swigCPtr, this, i);
    }

    public boolean retryTimesExceeded() {
        return NaviBusinessJNI.RetryStrategy_retryTimesExceeded(this.swigCPtr, this);
    }

    public int retryDelayTime(int i) {
        return NaviBusinessJNI.RetryStrategy_retryDelayTime(this.swigCPtr, this, i);
    }
}
