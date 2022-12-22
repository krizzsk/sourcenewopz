package com.jumio.jvision.jvcorejava.swig;

public class Size2i {

    /* renamed from: a */
    public transient long f55069a;
    public transient boolean swigCMemOwn;

    public Size2i(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55069a = j;
    }

    public static long getCPtr(Size2i size2i) {
        if (size2i == null) {
            return 0;
        }
        return size2i.f55069a;
    }

    public synchronized void delete() {
        long j = this.f55069a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Size2i(j);
            }
            this.f55069a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getHeight() {
        return JVCoreJavaJNI.Size2i_getHeight(this.f55069a, this);
    }

    public int getWidth() {
        return JVCoreJavaJNI.Size2i_getWidth(this.f55069a, this);
    }

    public void setHeight(int i) {
        JVCoreJavaJNI.Size2i_setHeight(this.f55069a, this, i);
    }

    public void setWidth(int i) {
        JVCoreJavaJNI.Size2i_setWidth(this.f55069a, this, i);
    }

    public Size2i() {
        this(JVCoreJavaJNI.new_Size2i__SWIG_0(), true);
    }

    public Size2i(int i, int i2) {
        this(JVCoreJavaJNI.new_Size2i__SWIG_1(i, i2), true);
    }
}
