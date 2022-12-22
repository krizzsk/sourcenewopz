package com.didi.component.comp_selectseat;

import android.app.Activity;
import android.os.Build;

public class SeatSelectUtils {
    public static boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed());
    }
}
