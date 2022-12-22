package com.jumio.jvision.jvcardfindjava.swig;

public class IntPoint {

    /* renamed from: a */
    public transient long f55049a;
    public transient boolean swigCMemOwn;

    public IntPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55049a = j;
    }

    public static long getCPtr(IntPoint intPoint) {
        if (intPoint == null) {
            return 0;
        }
        return intPoint.f55049a;
    }

    public synchronized void delete() {
        long j = this.f55049a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_IntPoint(j);
            }
            this.f55049a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getX() {
        return JVCardFindJavaJNI.IntPoint_getX(this.f55049a, this);
    }

    public int getY() {
        return JVCardFindJavaJNI.IntPoint_getY(this.f55049a, this);
    }

    public IntPoint(int i, int i2) {
        this(JVCardFindJavaJNI.new_IntPoint__SWIG_0(i, i2), true);
    }

    public IntPoint(int i) {
        this(JVCardFindJavaJNI.new_IntPoint__SWIG_1(i), true);
    }

    public IntPoint() {
        this(JVCardFindJavaJNI.new_IntPoint__SWIG_2(), true);
    }
}
