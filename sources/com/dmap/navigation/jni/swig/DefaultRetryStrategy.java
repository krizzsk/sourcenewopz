package com.dmap.navigation.jni.swig;

public class DefaultRetryStrategy extends RetryStrategy {
    private transient long swigCPtr;

    protected DefaultRetryStrategy(long j, boolean z) {
        super(NaviBusinessJNI.DefaultRetryStrategy_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DefaultRetryStrategy defaultRetryStrategy) {
        if (defaultRetryStrategy == null) {
            return 0;
        }
        return defaultRetryStrategy.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_DefaultRetryStrategy(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    public DefaultRetryStrategy() {
        this(NaviBusinessJNI.new_DefaultRetryStrategy(), true);
    }
}
