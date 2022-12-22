package com.jumio.jvision.jvcorejava.swig;

public class Point2f {

    /* renamed from: a */
    public transient long f55065a;
    public transient boolean swigCMemOwn;

    public Point2f(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55065a = j;
    }

    public static long getCPtr(Point2f point2f) {
        if (point2f == null) {
            return 0;
        }
        return point2f.f55065a;
    }

    public synchronized void delete() {
        long j = this.f55065a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Point2f(j);
            }
            this.f55065a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public float getX() {
        return JVCoreJavaJNI.Point2f_getX(this.f55065a, this);
    }

    public float getY() {
        return JVCoreJavaJNI.Point2f_getY(this.f55065a, this);
    }

    public void setX(float f) {
        JVCoreJavaJNI.Point2f_setX(this.f55065a, this, f);
    }

    public void setY(float f) {
        JVCoreJavaJNI.Point2f_setY(this.f55065a, this, f);
    }

    public Point2f() {
        this(JVCoreJavaJNI.new_Point2f__SWIG_0(), true);
    }

    public Point2f(float f, float f2) {
        this(JVCoreJavaJNI.new_Point2f__SWIG_1(f, f2), true);
    }
}
