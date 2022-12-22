package com.jumio.jvision.jvcorejava.swig;

public class Rect2i {

    /* renamed from: a */
    public transient long f55068a;
    public transient boolean swigCMemOwn;

    public Rect2i(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55068a = j;
    }

    public static long getCPtr(Rect2i rect2i) {
        if (rect2i == null) {
            return 0;
        }
        return rect2i.f55068a;
    }

    public int area() {
        return JVCoreJavaJNI.Rect2i_area(this.f55068a, this);
    }

    public synchronized void delete() {
        long j = this.f55068a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Rect2i(j);
            }
            this.f55068a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getHeight() {
        return JVCoreJavaJNI.Rect2i_getHeight(this.f55068a, this);
    }

    public int getWidth() {
        return JVCoreJavaJNI.Rect2i_getWidth(this.f55068a, this);
    }

    public int getX() {
        return JVCoreJavaJNI.Rect2i_getX(this.f55068a, this);
    }

    public int getY() {
        return JVCoreJavaJNI.Rect2i_getY(this.f55068a, this);
    }

    public void setHeight(int i) {
        JVCoreJavaJNI.Rect2i_setHeight(this.f55068a, this, i);
    }

    public void setWidth(int i) {
        JVCoreJavaJNI.Rect2i_setWidth(this.f55068a, this, i);
    }

    public void setX(int i) {
        JVCoreJavaJNI.Rect2i_setX(this.f55068a, this, i);
    }

    public void setY(int i) {
        JVCoreJavaJNI.Rect2i_setY(this.f55068a, this, i);
    }

    public Rect2i() {
        this(JVCoreJavaJNI.new_Rect2i__SWIG_0(), true);
    }

    public Rect2i(int i, int i2, int i3, int i4) {
        this(JVCoreJavaJNI.new_Rect2i__SWIG_1(i, i2, i3, i4), true);
    }
}
