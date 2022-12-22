package com.dmap.navigation.jni.swig;

public class CharArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CharArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CharArray charArray) {
        if (charArray == null) {
            return 0;
        }
        return charArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_CharArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public CharArray(int i) {
        this(NaviBusinessJNI.new_CharArray(i), true);
    }

    public short getitem(int i) {
        return NaviBusinessJNI.CharArray_getitem(this.swigCPtr, this, i);
    }

    public void setitem(int i, short s) {
        NaviBusinessJNI.CharArray_setitem(this.swigCPtr, this, i, s);
    }

    public SWIGTYPE_p_unsigned_char cast() {
        long CharArray_cast = NaviBusinessJNI.CharArray_cast(this.swigCPtr, this);
        if (CharArray_cast == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(CharArray_cast, false);
    }

    public static CharArray frompointer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        long CharArray_frompointer = NaviBusinessJNI.CharArray_frompointer(SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
        if (CharArray_frompointer == 0) {
            return null;
        }
        return new CharArray(CharArray_frompointer, false);
    }
}
