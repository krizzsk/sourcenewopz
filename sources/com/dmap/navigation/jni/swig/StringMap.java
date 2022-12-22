package com.dmap.navigation.jni.swig;

public class StringMap {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected StringMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(StringMap stringMap) {
        if (stringMap == null) {
            return 0;
        }
        return stringMap.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_StringMap(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public StringMap() {
        this(NaviBusinessJNI.new_StringMap__SWIG_0(), true);
    }

    public StringMap(StringMap stringMap) {
        this(NaviBusinessJNI.new_StringMap__SWIG_1(getCPtr(stringMap), stringMap), true);
    }

    public long size() {
        return NaviBusinessJNI.StringMap_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return NaviBusinessJNI.StringMap_empty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.StringMap_clear(this.swigCPtr, this);
    }

    public String get(String str) {
        return NaviBusinessJNI.StringMap_get(this.swigCPtr, this, str);
    }

    public void set(String str, String str2) {
        NaviBusinessJNI.StringMap_set(this.swigCPtr, this, str, str2);
    }

    public void del(String str) {
        NaviBusinessJNI.StringMap_del(this.swigCPtr, this, str);
    }

    public boolean has_key(String str) {
        return NaviBusinessJNI.StringMap_has_key(this.swigCPtr, this, str);
    }
}
