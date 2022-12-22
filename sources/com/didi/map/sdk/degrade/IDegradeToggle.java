package com.didi.map.sdk.degrade;

import android.content.Context;

public interface IDegradeToggle {
    DegradeMode getTargetDegradeMode(DegradeMode degradeMode, Context context);

    void onAppLaunched(DegradeMode degradeMode, Context context);
}
