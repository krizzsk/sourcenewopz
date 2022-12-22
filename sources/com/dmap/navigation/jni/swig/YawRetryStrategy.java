package com.dmap.navigation.jni.swig;

public class YawRetryStrategy extends RetryStrategy {
    private transient long swigCPtr;

    protected YawRetryStrategy(long j, boolean z) {
        super(NaviBusinessJNI.YawRetryStrategy_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(YawRetryStrategy yawRetryStrategy) {
        if (yawRetryStrategy == null) {
            return 0;
        }
        return yawRetryStrategy.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_YawRetryStrategy(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public YawRetryStrategy() {
        this(NaviBusinessJNI.new_YawRetryStrategy(), true);
    }
}
