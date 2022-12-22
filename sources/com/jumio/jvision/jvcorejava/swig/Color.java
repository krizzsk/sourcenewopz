package com.jumio.jvision.jvcorejava.swig;

public class Color {

    /* renamed from: a */
    public transient long f55053a;
    public transient boolean swigCMemOwn;

    public Color(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55053a = j;
    }

    public static long getCPtr(Color color) {
        if (color == null) {
            return 0;
        }
        return color.f55053a;
    }

    public synchronized void delete() {
        long j = this.f55053a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Color(j);
            }
            this.f55053a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getA() {
        return JVCoreJavaJNI.Color_getA(this.f55053a, this);
    }

    public int getB() {
        return JVCoreJavaJNI.Color_getB(this.f55053a, this);
    }

    public int getG() {
        return JVCoreJavaJNI.Color_getG(this.f55053a, this);
    }

    public int getR() {
        return JVCoreJavaJNI.Color_getR(this.f55053a, this);
    }

    public void setA(int i) {
        JVCoreJavaJNI.Color_setA(this.f55053a, this, i);
    }

    public void setB(int i) {
        JVCoreJavaJNI.Color_setB(this.f55053a, this, i);
    }

    public void setG(int i) {
        JVCoreJavaJNI.Color_setG(this.f55053a, this, i);
    }

    public void setR(int i) {
        JVCoreJavaJNI.Color_setR(this.f55053a, this, i);
    }

    public Color() {
        this(JVCoreJavaJNI.new_Color__SWIG_0(), true);
    }

    public Color(int i, int i2, int i3, int i4) {
        this(JVCoreJavaJNI.new_Color__SWIG_1(i, i2, i3, i4), true);
    }
}
