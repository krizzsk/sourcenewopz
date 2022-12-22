package com.dmap.navigation.jni.swig;

public class ApolloToggle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected ApolloToggle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ApolloToggle apolloToggle) {
        if (apolloToggle == null) {
            return 0;
        }
        return apolloToggle.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_ApolloToggle(this.swigCPtr);
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
        NaviBusinessJNI.ApolloToggle_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.ApolloToggle_change_ownership(this, this.swigCPtr, true);
    }

    public ApolloExperiment getExperiment() {
        long ApolloToggle_getExperiment = getClass() == ApolloToggle.class ? NaviBusinessJNI.ApolloToggle_getExperiment(this.swigCPtr, this) : NaviBusinessJNI.ApolloToggle_getExperimentSwigExplicitApolloToggle(this.swigCPtr, this);
        if (ApolloToggle_getExperiment == 0) {
            return null;
        }
        return new ApolloExperiment(ApolloToggle_getExperiment, false);
    }

    public boolean allow() {
        return getClass() == ApolloToggle.class ? NaviBusinessJNI.ApolloToggle_allow(this.swigCPtr, this) : NaviBusinessJNI.ApolloToggle_allowSwigExplicitApolloToggle(this.swigCPtr, this);
    }

    public ApolloToggle() {
        this(NaviBusinessJNI.new_ApolloToggle(), true);
        NaviBusinessJNI.ApolloToggle_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
