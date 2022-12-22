package com.dmap.navigation.jni.swig;

public class UserInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected UserInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(UserInfo userInfo) {
        if (userInfo == null) {
            return 0;
        }
        return userInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_UserInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setUserId(String str) {
        NaviBusinessJNI.UserInfo_userId_set(this.swigCPtr, this, str);
    }

    public String getUserId() {
        return NaviBusinessJNI.UserInfo_userId_get(this.swigCPtr, this);
    }

    public void setTicket(String str) {
        NaviBusinessJNI.UserInfo_ticket_set(this.swigCPtr, this, str);
    }

    public String getTicket() {
        return NaviBusinessJNI.UserInfo_ticket_get(this.swigCPtr, this);
    }

    public void setPhone(String str) {
        NaviBusinessJNI.UserInfo_phone_set(this.swigCPtr, this, str);
    }

    public String getPhone() {
        return NaviBusinessJNI.UserInfo_phone_get(this.swigCPtr, this);
    }

    public void setDidiVersion(String str) {
        NaviBusinessJNI.UserInfo_didiVersion_set(this.swigCPtr, this, str);
    }

    public String getDidiVersion() {
        return NaviBusinessJNI.UserInfo_didiVersion_get(this.swigCPtr, this);
    }

    public void setCityId(String str) {
        NaviBusinessJNI.UserInfo_cityId_set(this.swigCPtr, this, str);
    }

    public String getCityId() {
        return NaviBusinessJNI.UserInfo_cityId_get(this.swigCPtr, this);
    }

    public void setCountryId(String str) {
        NaviBusinessJNI.UserInfo_countryId_set(this.swigCPtr, this, str);
    }

    public String getCountryId() {
        return NaviBusinessJNI.UserInfo_countryId_get(this.swigCPtr, this);
    }

    public void setBizType(int i) {
        NaviBusinessJNI.UserInfo_bizType_set(this.swigCPtr, this, i);
    }

    public int getBizType() {
        return NaviBusinessJNI.UserInfo_bizType_get(this.swigCPtr, this);
    }

    public void setImei(String str) {
        NaviBusinessJNI.UserInfo_imei_set(this.swigCPtr, this, str);
    }

    public String getImei() {
        return NaviBusinessJNI.UserInfo_imei_get(this.swigCPtr, this);
    }

    public void setOs(String str) {
        NaviBusinessJNI.UserInfo_os_set(this.swigCPtr, this, str);
    }

    public String getOs() {
        return NaviBusinessJNI.UserInfo_os_get(this.swigCPtr, this);
    }

    public void setPlateNumber(String str) {
        NaviBusinessJNI.UserInfo_plateNumber_set(this.swigCPtr, this, str);
    }

    public String getPlateNumber() {
        return NaviBusinessJNI.UserInfo_plateNumber_get(this.swigCPtr, this);
    }

    public void setDeviceId(String str) {
        NaviBusinessJNI.UserInfo_deviceId_set(this.swigCPtr, this, str);
    }

    public String getDeviceId() {
        return NaviBusinessJNI.UserInfo_deviceId_get(this.swigCPtr, this);
    }

    public UserInfo() {
        this(NaviBusinessJNI.new_UserInfo(), true);
    }
}
