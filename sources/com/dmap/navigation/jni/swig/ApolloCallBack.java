package com.dmap.navigation.jni.swig;

public class ApolloCallBack {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ApolloCallBack(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ApolloCallBack apolloCallBack) {
        if (apolloCallBack == null) {
            return 0;
        }
        return apolloCallBack.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_ApolloCallBack(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        NaviBusinessJNI.ApolloCallBack_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.ApolloCallBack_change_ownership(this, this.swigCPtr, true);
    }

    public ApolloToggle getToggle(byte[] bArr) {
        long ApolloCallBack_getToggle = getClass() == ApolloCallBack.class ? NaviBusinessJNI.ApolloCallBack_getToggle(this.swigCPtr, this, bArr) : NaviBusinessJNI.ApolloCallBack_getToggleSwigExplicitApolloCallBack(this.swigCPtr, this, bArr);
        if (ApolloCallBack_getToggle == 0) {
            return null;
        }
        return new ApolloToggle(ApolloCallBack_getToggle, false);
    }

    public ApolloCallBack() {
        this(NaviBusinessJNI.new_ApolloCallBack(), true);
        NaviBusinessJNI.ApolloCallBack_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
