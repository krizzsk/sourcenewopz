package com.jumio.jvision.jvcorejava.swig;

public class FrameQueue {

    /* renamed from: a */
    public transient long f55056a;
    public transient boolean swigCMemOwn;

    public FrameQueue(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55056a = j;
    }

    public static long getCPtr(FrameQueue frameQueue) {
        if (frameQueue == null) {
            return 0;
        }
        return frameQueue.f55056a;
    }

    public void clear() {
        JVCoreJavaJNI.FrameQueue_clear(this.f55056a, this);
    }

    public synchronized void delete() {
        long j = this.f55056a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameQueue(j);
            }
            this.f55056a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public void getAllFrames(ImageSourceVector imageSourceVector) {
        JVCoreJavaJNI.FrameQueue_getAllFrames(this.f55056a, this, ImageSourceVector.getCPtr(imageSourceVector), imageSourceVector);
    }

    public ImageSource getFrameByID(int i) {
        return new ImageSource(JVCoreJavaJNI.FrameQueue_getFrameByID(this.f55056a, this, i), true);
    }

    public void getFramesInRange(int i, int i2, ImageSourceVector imageSourceVector) {
        JVCoreJavaJNI.FrameQueue_getFramesInRange(this.f55056a, this, i, i2, ImageSourceVector.getCPtr(imageSourceVector), imageSourceVector);
    }

    public ImageSource lastFrame() {
        return new ImageSource(JVCoreJavaJNI.FrameQueue_lastFrame(this.f55056a, this), false);
    }

    public void pushFrame(int i, ImageSource imageSource) {
        JVCoreJavaJNI.FrameQueue_pushFrame(this.f55056a, this, i, ImageSource.getCPtr(imageSource), imageSource);
    }

    public boolean removeFrameByID(int i) {
        return JVCoreJavaJNI.FrameQueue_removeFrameByID(this.f55056a, this, i);
    }

    public long size() {
        return JVCoreJavaJNI.FrameQueue_size(this.f55056a, this);
    }

    public FrameQueue(long j) {
        this(JVCoreJavaJNI.new_FrameQueue(j), true);
    }
}
