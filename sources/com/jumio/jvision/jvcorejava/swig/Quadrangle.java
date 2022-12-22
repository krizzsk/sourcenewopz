package com.jumio.jvision.jvcorejava.swig;

public class Quadrangle {

    /* renamed from: a */
    public transient long f55067a;
    public transient boolean swigCMemOwn;

    public Quadrangle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55067a = j;
    }

    public static long getCPtr(Quadrangle quadrangle) {
        if (quadrangle == null) {
            return 0;
        }
        return quadrangle.f55067a;
    }

    public synchronized void delete() {
        long j = this.f55067a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Quadrangle(j);
            }
            this.f55067a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public Point2f getBottomLeft() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getBottomLeft(this.f55067a, this), true);
    }

    public Point2f getBottomRight() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getBottomRight(this.f55067a, this), true);
    }

    public Point2f getTopLeft() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getTopLeft(this.f55067a, this), true);
    }

    public Point2f getTopRight() {
        return new Point2f(JVCoreJavaJNI.Quadrangle_getTopRight(this.f55067a, this), true);
    }

    public void setBottomLeft(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setBottomLeft(this.f55067a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setBottomRight(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setBottomRight(this.f55067a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setTopLeft(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setTopLeft(this.f55067a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setTopRight(Point2f point2f) {
        JVCoreJavaJNI.Quadrangle_setTopRight(this.f55067a, this, Point2f.getCPtr(point2f), point2f);
    }

    public Quadrangle() {
        this(JVCoreJavaJNI.new_Quadrangle__SWIG_0(), true);
    }

    public Quadrangle(Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4) {
        this(JVCoreJavaJNI.new_Quadrangle__SWIG_1(Point2f.getCPtr(point2f), point2f, Point2f.getCPtr(point2f2), point2f2, Point2f.getCPtr(point2f3), point2f3, Point2f.getCPtr(point2f4), point2f4), true);
    }
}
