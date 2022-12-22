package com.dmap.navigation.jni.swig;

public class FirstRetryStrategy extends RetryStrategy {
    private transient long swigCPtr;

    protected FirstRetryStrategy(long j, boolean z) {
        super(NaviBusinessJNI.FirstRetryStrategy_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(FirstRetryStrategy firstRetryStrategy) {
        if (firstRetryStrategy == null) {
            return 0;
        }
        return firstRetryStrategy.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_FirstRetryStrategy(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public FirstRetryStrategy() {
        this(NaviBusinessJNI.new_FirstRetryStrategy(), true);
    }
}
