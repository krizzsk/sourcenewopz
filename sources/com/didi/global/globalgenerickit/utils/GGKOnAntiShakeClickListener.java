package com.didi.global.globalgenerickit.utils;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class GGKOnAntiShakeClickListener implements View.OnClickListener {
    private static final long DELAY_TIME = 400;
    private long lastClickTime;

    public abstract void onAntiShakeClick(View view);

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!isFastDoubleClick()) {
            onAntiShakeClick(view);
        }
    }

    private boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastClickTime;
        if (0 < j && j < 400) {
            return true;
        }
        this.lastClickTime = currentTimeMillis;
        return false;
    }
}
