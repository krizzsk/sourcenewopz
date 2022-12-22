package com.dmap.navigation.jni.swig;

public class MissionButtonInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected MissionButtonInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MissionButtonInfo missionButtonInfo) {
        if (missionButtonInfo == null) {
            return 0;
        }
        return missionButtonInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_MissionButtonInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setButtonTitle(String str) {
        NaviBusinessJNI.MissionButtonInfo_buttonTitle_set(this.swigCPtr, this, str);
    }

    public String getButtonTitle() {
        return NaviBusinessJNI.MissionButtonInfo_buttonTitle_get(this.swigCPtr, this);
    }

    public void setButtonPicUrl(String str) {
        NaviBusinessJNI.MissionButtonInfo_buttonPicUrl_set(this.swigCPtr, this, str);
    }

    public String getButtonPicUrl() {
        return NaviBusinessJNI.MissionButtonInfo_buttonPicUrl_get(this.swigCPtr, this);
    }

    public void setButtonType(int i) {
        NaviBusinessJNI.MissionButtonInfo_buttonType_set(this.swigCPtr, this, i);
    }

    public int getButtonType() {
        return NaviBusinessJNI.MissionButtonInfo_buttonType_get(this.swigCPtr, this);
    }

    public void setButtonValue(int i) {
        NaviBusinessJNI.MissionButtonInfo_buttonValue_set(this.swigCPtr, this, i);
    }

    public int getButtonValue() {
        return NaviBusinessJNI.MissionButtonInfo_buttonValue_get(this.swigCPtr, this);
    }

    public MissionButtonInfo() {
        this(NaviBusinessJNI.new_MissionButtonInfo(), true);
    }
}
