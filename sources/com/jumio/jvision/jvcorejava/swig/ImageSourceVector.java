package com.jumio.jvision.jvcorejava.swig;

public class ImageSourceVector {

    /* renamed from: a */
    public transient long f55062a;
    public transient boolean swigCMemOwn;

    public ImageSourceVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55062a = j;
    }

    public static long getCPtr(ImageSourceVector imageSourceVector) {
        if (imageSourceVector == null) {
            return 0;
        }
        return imageSourceVector.f55062a;
    }

    public void add(ImageSource imageSource) {
        JVCoreJavaJNI.ImageSourceVector_add(this.f55062a, this, ImageSource.getCPtr(imageSource), imageSource);
    }

    public long capacity() {
        return JVCoreJavaJNI.ImageSourceVector_capacity(this.f55062a, this);
    }

    public void clear() {
        JVCoreJavaJNI.ImageSourceVector_clear(this.f55062a, this);
    }

    public synchronized void delete() {
        long j = this.f55062a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_ImageSourceVector(j);
            }
            this.f55062a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ImageSource get(int i) {
        return new ImageSource(JVCoreJavaJNI.ImageSourceVector_get(this.f55062a, this, i), false);
    }

    public boolean isEmpty() {
        return JVCoreJavaJNI.ImageSourceVector_isEmpty(this.f55062a, this);
    }

    public void reserve(long j) {
        JVCoreJavaJNI.ImageSourceVector_reserve(this.f55062a, this, j);
    }

    public void set(int i, ImageSource imageSource) {
        JVCoreJavaJNI.ImageSourceVector_set(this.f55062a, this, i, ImageSource.getCPtr(imageSource), imageSource);
    }

    public long size() {
        return JVCoreJavaJNI.ImageSourceVector_size(this.f55062a, this);
    }

    public ImageSourceVector() {
        this(JVCoreJavaJNI.new_ImageSourceVector__SWIG_0(), true);
    }

    public ImageSourceVector(long j) {
        this(JVCoreJavaJNI.new_ImageSourceVector__SWIG_1(j), true);
    }
}
