package com.didi.component.business.accessibility;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class AccessibilityHandler extends Handler {
    public static final long DELAY_COMMON_FIRST = 1000;
    public static final long DELAY_COMMON_TIME = 60;

    public AccessibilityHandler(Looper looper) {
        super(looper);
    }

    public Runnable obtainFocusTask(View view) {
        return new C4610a(view);
    }
}
