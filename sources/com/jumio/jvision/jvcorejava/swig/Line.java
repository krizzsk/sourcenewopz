package com.jumio.jvision.jvcorejava.swig;

public class Line {

    /* renamed from: a */
    public transient long f55064a;
    public transient boolean swigCMemOwn;

    public Line(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55064a = j;
    }

    public static long getCPtr(Line line) {
        if (line == null) {
            return 0;
        }
        return line.f55064a;
    }

    public synchronized void delete() {
        long j = this.f55064a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Line(j);
            }
            this.f55064a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public Point2f getP1() {
        return new Point2f(JVCoreJavaJNI.Line_getP1(this.f55064a, this), true);
    }

    public Point2f getP2() {
        return new Point2f(JVCoreJavaJNI.Line_getP2(this.f55064a, this), true);
    }

    public void setP1(Point2f point2f) {
        JVCoreJavaJNI.Line_setP1(this.f55064a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setP2(Point2f point2f) {
        JVCoreJavaJNI.Line_setP2(this.f55064a, this, Point2f.getCPtr(point2f), point2f);
    }

    public Line() {
        this(JVCoreJavaJNI.new_Line__SWIG_0(), true);
    }

    public Line(Point2f point2f, Point2f point2f2) {
        this(JVCoreJavaJNI.new_Line__SWIG_1(Point2f.getCPtr(point2f), point2f, Point2f.getCPtr(point2f2), point2f2), true);
    }
}
