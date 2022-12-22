package com.didi.sdk.p154ms.common.update;

/* renamed from: com.didi.sdk.ms.common.update.IAppUpdateInfo */
public interface IAppUpdateInfo {
    int availableVersionCode();

    String getPackageName();

    int installStatus();

    boolean isUpdateAvailable();

    boolean isUpdateDeveloperTriggeredInProgress();

    boolean isUpdateTypeAllowed(int i);

    int updateAvailability();
}
