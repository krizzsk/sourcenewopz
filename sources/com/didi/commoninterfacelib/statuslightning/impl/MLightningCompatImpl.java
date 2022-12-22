package com.didi.commoninterfacelib.statuslightning.impl;

import android.app.Activity;
import android.view.View;
import com.didi.commoninterfacelib.statuslightning.ILightningCompat;

public class MLightningCompatImpl implements ILightningCompat {
    public void setLightStatusBar(Activity activity, boolean z) {
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
    }
}
