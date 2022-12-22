package com.didi.sdk.util;

import android.content.Context;
import com.taxis99.R;

public class ExitUtil {

    /* renamed from: a */
    private static long f37589a = 0;

    /* renamed from: b */
    private static final long f37590b = 3000;

    public static void doExit() {
    }

    public static boolean isValidExit(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f37589a <= 3000) {
            return true;
        }
        if (context != null) {
            ToastUtil.show(context, (int) R.string.exit_tip);
        }
        f37589a = currentTimeMillis;
        return false;
    }
}
