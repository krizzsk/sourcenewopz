package com.didi.map.global.flow.utils;

import android.content.Context;
import android.os.Build;
import android.os.MessageQueue;

public class LazyUtil {
    public static boolean invoke(Context context, Runnable runnable) {
        if (context != null && Build.VERSION.SDK_INT >= 23) {
            context.getApplicationContext().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler(runnable) {
                public final /* synthetic */ Runnable f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean queueIdle() {
                    return LazyUtil.m19270a(this.f$0);
                }
            });
            return true;
        } else if (runnable == null) {
            return false;
        } else {
            runnable.run();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m19270a(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        runnable.run();
        return false;
    }
}
