package com.jumio.jvision.jvcorejava.swig;

public class FrameProcessor {

    /* renamed from: a */
    public transient long f55054a;
    public transient boolean swigCMemOwn;

    public FrameProcessor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55054a = j;
    }

    public static long getCPtr(FrameProcessor frameProcessor) {
        if (frameProcessor == null) {
            return 0;
        }
        return frameProcessor.f55054a;
    }

    public synchronized void delete() {
        long j = this.f55054a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameProcessor(j);
            }
            this.f55054a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public void processFrame() {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_processFrame(this.f55054a, this);
        } else {
            JVCoreJavaJNI.FrameProcessor_processFrameSwigExplicitFrameProcessor(this.f55054a, this);
        }
    }

    public void pushFrame(int i, ImageSource imageSource) {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_pushFrame(this.f55054a, this, i, ImageSource.getCPtr(imageSource), imageSource);
            return;
        }
        JVCoreJavaJNI.FrameProcessor_pushFrameSwigExplicitFrameProcessor(this.f55054a, this, i, ImageSource.getCPtr(imageSource), imageSource);
    }

    public void reset() {
        JVCoreJavaJNI.FrameProcessor_reset(this.f55054a, this);
    }

    public void resetState() {
        if (getClass() == FrameProcessor.class) {
            JVCoreJavaJNI.FrameProcessor_resetState(this.f55054a, this);
        } else {
            JVCoreJavaJNI.FrameProcessor_resetStateSwigExplicitFrameProcessor(this.f55054a, this);
        }
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        JVCoreJavaJNI.FrameProcessor_change_ownership(this, this.f55054a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        JVCoreJavaJNI.FrameProcessor_change_ownership(this, this.f55054a, true);
    }

    public FrameProcessor(int i) {
        this(JVCoreJavaJNI.new_FrameProcessor(i), true);
        JVCoreJavaJNI.FrameProcessor_director_connect(this, this.f55054a, this.swigCMemOwn, true);
    }
}
