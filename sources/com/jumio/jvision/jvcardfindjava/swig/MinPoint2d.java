package com.jumio.jvision.jvcardfindjava.swig;

public class MinPoint2d {

    /* renamed from: a */
    public transient long f55052a;
    public transient boolean swigCMemOwn;

    public MinPoint2d(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55052a = j;
    }

    public static long getCPtr(MinPoint2d minPoint2d) {
        if (minPoint2d == null) {
            return 0;
        }
        return minPoint2d.f55052a;
    }

    public synchronized void delete() {
        long j = this.f55052a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_MinPoint2d(j);
            }
            this.f55052a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public MinPoint2d() {
        this(JVCardFindJavaJNI.new_MinPoint2d(), true);
    }
}
