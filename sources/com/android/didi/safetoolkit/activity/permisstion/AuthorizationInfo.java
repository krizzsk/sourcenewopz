package com.android.didi.safetoolkit.activity.permisstion;

import java.io.Serializable;
import java.util.Objects;

public class AuthorizationInfo implements Serializable, Cloneable {
    private boolean isDoNotAskAgain;
    private boolean isShouldShowAlert;
    private boolean mAuthorization;
    private String mRequestPermission;
    private int mRequestTimes;

    public String getRequestPermission() {
        return this.mRequestPermission;
    }

    public void setRequestPermission(String str) {
        this.mRequestPermission = str;
    }

    public boolean isAuthorization() {
        return this.mAuthorization;
    }

    public void setAuthorization(boolean z) {
        this.mAuthorization = z;
    }

    public int getRequestTimes() {
        return this.mRequestTimes;
    }

    public boolean isShouldShowAlert() {
        return this.isShouldShowAlert;
    }

    public void setShouldShowAlert(boolean z) {
        this.isShouldShowAlert = z;
    }

    public void setRequestTimes(int i) {
        this.mRequestTimes = i;
    }

    public boolean isDoNotAskAgain() {
        return this.isDoNotAskAgain;
    }

    public void setDoNotAskAgain(boolean z) {
        this.isDoNotAskAgain = z;
    }

    public AuthorizationInfo clone() {
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();
        authorizationInfo.setAuthorization(this.mAuthorization);
        authorizationInfo.setDoNotAskAgain(this.isDoNotAskAgain);
        authorizationInfo.setRequestPermission(this.mRequestPermission);
        authorizationInfo.setRequestTimes(this.mRequestTimes);
        return authorizationInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mRequestPermission, ((AuthorizationInfo) obj).mRequestPermission);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mRequestPermission});
    }

    public String toString() {
        return "AuthorizationInfo{mRequestPermission='" + this.mRequestPermission + '\'' + ", mAuthorization=" + this.mAuthorization + ", mRequestTimes=" + this.mRequestTimes + ", isDoNotAskAgain=" + this.isDoNotAskAgain + ", isShouldShowAlert=" + this.isShouldShowAlert + '}';
    }
}
