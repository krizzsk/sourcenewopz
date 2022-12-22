package com.jumio.jvision.jvcorejava.swig;

public class FrameProcessorException extends Exception {

    /* renamed from: a */
    public transient long f55055a;
    public transient boolean swigCMemOwn;

    public FrameProcessorException(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55055a = j;
    }

    public static long getCPtr(FrameProcessorException frameProcessorException) {
        if (frameProcessorException == null) {
            return 0;
        }
        return frameProcessorException.f55055a;
    }

    public synchronized void delete() {
        long j = this.f55055a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameProcessorException(j);
            }
            this.f55055a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public String getMessage() {
        return what();
    }

    public String what() {
        return JVCoreJavaJNI.FrameProcessorException_what(this.f55055a, this);
    }

    public FrameProcessorException(String str) {
        this(JVCoreJavaJNI.new_FrameProcessorException__SWIG_0(str), true);
    }
}
