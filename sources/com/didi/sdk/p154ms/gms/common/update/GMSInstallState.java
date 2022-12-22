package com.didi.sdk.p154ms.gms.common.update;

import com.didi.sdk.p154ms.common.update.IInstallState;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.google.android.play.core.install.InstallState;

/* renamed from: com.didi.sdk.ms.gms.common.update.GMSInstallState */
public class GMSInstallState extends GMSType implements IInstallState {
    private final InstallState mState;

    public GMSInstallState(InstallState installState) {
        this.mState = installState;
    }

    public int installStatus() {
        return this.mState.installStatus();
    }

    public int installErrorCode() {
        return this.mState.installErrorCode();
    }

    public String packageName() {
        return this.mState.packageName();
    }
}
