package com.jumio.ale.swig;

public class ALEHeader {

    /* renamed from: a */
    public transient long f54497a;
    public transient boolean swigCMemOwn;

    public ALEHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f54497a = j;
    }

    public static long getCPtr(ALEHeader aLEHeader) {
        if (aLEHeader == null) {
            return 0;
        }
        return aLEHeader.f54497a;
    }

    public void add(String str, String str2) {
        aleEngineJNI.ALEHeader_add__SWIG_0(this.f54497a, this, str, str2);
    }

    public void clear() {
        aleEngineJNI.ALEHeader_clear(this.f54497a, this);
    }

    public synchronized void delete() {
        long j = this.f54497a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALEHeader(j);
            }
            this.f54497a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ALEHeader() {
        this(aleEngineJNI.new_ALEHeader(), true);
    }
}
