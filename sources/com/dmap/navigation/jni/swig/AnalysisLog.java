package com.dmap.navigation.jni.swig;

public class AnalysisLog {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AnalysisLog(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AnalysisLog analysisLog) {
        if (analysisLog == null) {
            return 0;
        }
        return analysisLog.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_AnalysisLog(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setKey(String str) {
        NaviBusinessJNI.AnalysisLog_key_set(this.swigCPtr, this, str);
    }

    public String getKey() {
        return NaviBusinessJNI.AnalysisLog_key_get(this.swigCPtr, this);
    }

    public void setValue(String str) {
        NaviBusinessJNI.AnalysisLog_value_set(this.swigCPtr, this, str);
    }

    public String getValue() {
        return NaviBusinessJNI.AnalysisLog_value_get(this.swigCPtr, this);
    }

    public AnalysisLog() {
        this(NaviBusinessJNI.new_AnalysisLog(), true);
    }
}
