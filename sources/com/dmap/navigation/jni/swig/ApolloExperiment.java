package com.dmap.navigation.jni.swig;

public class ApolloExperiment {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ApolloExperiment(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ApolloExperiment apolloExperiment) {
        if (apolloExperiment == null) {
            return 0;
        }
        return apolloExperiment.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_ApolloExperiment(this.swigCPtr);
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
        NaviBusinessJNI.ApolloExperiment_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.ApolloExperiment_change_ownership(this, this.swigCPtr, true);
    }

    public int getParam(byte[] bArr, int i) {
        return getClass() == ApolloExperiment.class ? NaviBusinessJNI.ApolloExperiment_getParam__SWIG_0(this.swigCPtr, this, bArr, i) : NaviBusinessJNI.ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_0(this.swigCPtr, this, bArr, i);
    }

    public float getParam(byte[] bArr, float f) {
        return getClass() == ApolloExperiment.class ? NaviBusinessJNI.ApolloExperiment_getParam__SWIG_1(this.swigCPtr, this, bArr, f) : NaviBusinessJNI.ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_1(this.swigCPtr, this, bArr, f);
    }

    public String getParam(byte[] bArr, String str) {
        return getClass() == ApolloExperiment.class ? NaviBusinessJNI.ApolloExperiment_getParam__SWIG_2(this.swigCPtr, this, bArr, str) : NaviBusinessJNI.ApolloExperiment_getParamSwigExplicitApolloExperiment__SWIG_2(this.swigCPtr, this, bArr, str);
    }

    public ApolloExperiment() {
        this(NaviBusinessJNI.new_ApolloExperiment(), true);
        NaviBusinessJNI.ApolloExperiment_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
