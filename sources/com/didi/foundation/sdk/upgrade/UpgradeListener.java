package com.didi.foundation.sdk.upgrade;

public interface UpgradeListener {
    void onFail(int i);

    void onSuccess(UpgradeEntity upgradeEntity);
}
