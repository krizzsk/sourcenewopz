package com.jumio.jvision.jvcardfindjava.swig;

public class IntQuadrangleVector {

    /* renamed from: a */
    public transient long f55051a;
    public transient boolean swigCMemOwn;

    public IntQuadrangleVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55051a = j;
    }

    public static long getCPtr(IntQuadrangleVector intQuadrangleVector) {
        if (intQuadrangleVector == null) {
            return 0;
        }
        return intQuadrangleVector.f55051a;
    }

    public void add(IntQuadrangle intQuadrangle) {
        JVCardFindJavaJNI.IntQuadrangleVector_add(this.f55051a, this, IntQuadrangle.getCPtr(intQuadrangle), intQuadrangle);
    }

    public long capacity() {
        return JVCardFindJavaJNI.IntQuadrangleVector_capacity(this.f55051a, this);
    }

    public void clear() {
        JVCardFindJavaJNI.IntQuadrangleVector_clear(this.f55051a, this);
    }

    public synchronized void delete() {
        long j = this.f55051a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_IntQuadrangleVector(j);
            }
            this.f55051a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public IntQuadrangle get(int i) {
        return new IntQuadrangle(JVCardFindJavaJNI.IntQuadrangleVector_get(this.f55051a, this, i), false);
    }

    public boolean isEmpty() {
        return JVCardFindJavaJNI.IntQuadrangleVector_isEmpty(this.f55051a, this);
    }

    public void reserve(long j) {
        JVCardFindJavaJNI.IntQuadrangleVector_reserve(this.f55051a, this, j);
    }

    public void set(int i, IntQuadrangle intQuadrangle) {
        JVCardFindJavaJNI.IntQuadrangleVector_set(this.f55051a, this, i, IntQuadrangle.getCPtr(intQuadrangle), intQuadrangle);
    }

    public long size() {
        return JVCardFindJavaJNI.IntQuadrangleVector_size(this.f55051a, this);
    }

    public IntQuadrangleVector() {
        this(JVCardFindJavaJNI.new_IntQuadrangleVector__SWIG_0(), true);
    }

    public IntQuadrangleVector(long j) {
        this(JVCardFindJavaJNI.new_IntQuadrangleVector__SWIG_1(j), true);
    }
}
