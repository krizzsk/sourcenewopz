package com.didi.sdk.p154ms.gms.common.update;

import com.didi.sdk.p154ms.common.update.IAppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateInfo;

/* renamed from: com.didi.sdk.ms.gms.common.update.GMSAppUpdateInfo */
public class GMSAppUpdateInfo implements IAppUpdateInfo {
    private final AppUpdateInfo mAppUpdateInfo;

    public GMSAppUpdateInfo(AppUpdateInfo appUpdateInfo) {
        this.mAppUpdateInfo = appUpdateInfo;
    }

    public AppUpdateInfo getInnerAppUpdateInfo() {
        return this.mAppUpdateInfo;
    }

    public String getPackageName() {
        return this.mAppUpdateInfo.packageName();
    }

    public int availableVersionCode() {
        return this.mAppUpdateInfo.availableVersionCode();
    }

    public int updateAvailability() {
        return this.mAppUpdateInfo.updateAvailability();
    }

    public boolean isUpdateAvailable() {
        return updateAvailability() == 2;
    }

    public boolean isUpdateDeveloperTriggeredInProgress() {
        return updateAvailability() == 3;
    }

    public int installStatus() {
        return this.mAppUpdateInfo.installStatus();
    }

    public boolean isUpdateTypeAllowed(int i) {
        return this.mAppUpdateInfo.isUpdateTypeAllowed(i);
    }
}
