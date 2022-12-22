package com.dmap.navigation.jni.swig;

public class AnalysisLogList {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected AnalysisLogList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AnalysisLogList analysisLogList) {
        if (analysisLogList == null) {
            return 0;
        }
        return analysisLogList.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_AnalysisLogList(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public AnalysisLogList() {
        this(NaviBusinessJNI.new_AnalysisLogList__SWIG_0(), true);
    }

    public AnalysisLogList(long j) {
        this(NaviBusinessJNI.new_AnalysisLogList__SWIG_1(j), true);
    }

    public long size() {
        return NaviBusinessJNI.AnalysisLogList_size(this.swigCPtr, this);
    }

    public long capacity() {
        return NaviBusinessJNI.AnalysisLogList_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        NaviBusinessJNI.AnalysisLogList_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return NaviBusinessJNI.AnalysisLogList_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        NaviBusinessJNI.AnalysisLogList_clear(this.swigCPtr, this);
    }

    public void add(AnalysisLog analysisLog) {
        NaviBusinessJNI.AnalysisLogList_add(this.swigCPtr, this, AnalysisLog.getCPtr(analysisLog), analysisLog);
    }

    public AnalysisLog get(int i) {
        return new AnalysisLog(NaviBusinessJNI.AnalysisLogList_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, AnalysisLog analysisLog) {
        NaviBusinessJNI.AnalysisLogList_set(this.swigCPtr, this, i, AnalysisLog.getCPtr(analysisLog), analysisLog);
    }
}
