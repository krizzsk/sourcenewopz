package com.didi.safetoolkit.util.statuslightning.impl;

import android.app.Activity;

public class MIUIMLightningCompatImpl extends MIUILowerMLightningCompatImpl {
    public void setLightStatusBar(Activity activity, boolean z) {
        super.setLightStatusBar(activity, z);
        new MLightningCompatImpl().setLightStatusBar(activity, z);
    }
}
