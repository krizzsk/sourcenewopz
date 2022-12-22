package com.jumio.jvision.jvcorejava.swig;

public class KeyPoint {

    /* renamed from: a */
    public transient long f55063a;
    public transient boolean swigCMemOwn;

    public KeyPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55063a = j;
    }

    public static long getCPtr(KeyPoint keyPoint) {
        if (keyPoint == null) {
            return 0;
        }
        return keyPoint.f55063a;
    }

    public synchronized void delete() {
        long j = this.f55063a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_KeyPoint(j);
            }
            this.f55063a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public float getAngle() {
        return JVCoreJavaJNI.KeyPoint_angle_get(this.f55063a, this);
    }

    public int getClass_id() {
        return JVCoreJavaJNI.KeyPoint_class_id_get(this.f55063a, this);
    }

    public int getOctave() {
        return JVCoreJavaJNI.KeyPoint_octave_get(this.f55063a, this);
    }

    public Point2f getPt() {
        long KeyPoint_pt_get = JVCoreJavaJNI.KeyPoint_pt_get(this.f55063a, this);
        if (KeyPoint_pt_get == 0) {
            return null;
        }
        return new Point2f(KeyPoint_pt_get, false);
    }

    public float getResponse() {
        return JVCoreJavaJNI.KeyPoint_response_get(this.f55063a, this);
    }

    public float getSize() {
        return JVCoreJavaJNI.KeyPoint_size_get(this.f55063a, this);
    }

    public void setAngle(float f) {
        JVCoreJavaJNI.KeyPoint_angle_set(this.f55063a, this, f);
    }

    public void setClass_id(int i) {
        JVCoreJavaJNI.KeyPoint_class_id_set(this.f55063a, this, i);
    }

    public void setOctave(int i) {
        JVCoreJavaJNI.KeyPoint_octave_set(this.f55063a, this, i);
    }

    public void setPt(Point2f point2f) {
        JVCoreJavaJNI.KeyPoint_pt_set(this.f55063a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setResponse(float f) {
        JVCoreJavaJNI.KeyPoint_response_set(this.f55063a, this, f);
    }

    public void setSize(float f) {
        JVCoreJavaJNI.KeyPoint_size_set(this.f55063a, this, f);
    }

    public KeyPoint() {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_0(), true);
    }

    public KeyPoint(Point2f point2f, float f, float f2, float f3, int i, int i2) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_1(Point2f.getCPtr(point2f), point2f, f, f2, f3, i, i2), true);
    }

    public KeyPoint(Point2f point2f, float f, float f2, float f3, int i) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_2(Point2f.getCPtr(point2f), point2f, f, f2, f3, i), true);
    }

    public KeyPoint(Point2f point2f, float f, float f2, float f3) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_3(Point2f.getCPtr(point2f), point2f, f, f2, f3), true);
    }

    public KeyPoint(Point2f point2f, float f, float f2) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_4(Point2f.getCPtr(point2f), point2f, f, f2), true);
    }

    public KeyPoint(Point2f point2f, float f) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_5(Point2f.getCPtr(point2f), point2f, f), true);
    }

    public KeyPoint(float f, float f2, float f3, float f4, float f5, int i, int i2) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_6(f, f2, f3, f4, f5, i, i2), true);
    }

    public KeyPoint(float f, float f2, float f3, float f4, float f5, int i) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_7(f, f2, f3, f4, f5, i), true);
    }

    public KeyPoint(float f, float f2, float f3, float f4, float f5) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_8(f, f2, f3, f4, f5), true);
    }

    public KeyPoint(float f, float f2, float f3, float f4) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_9(f, f2, f3, f4), true);
    }

    public KeyPoint(float f, float f2, float f3) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_10(f, f2, f3), true);
    }
}
