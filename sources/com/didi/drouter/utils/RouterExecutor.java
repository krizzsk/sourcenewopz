package com.didi.drouter.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RouterExecutor {

    /* renamed from: a */
    private static final Handler f19270a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static final ExecutorService f19271b = Executors.newCachedThreadPool();

    public static void execute(int i, Runnable runnable) {
        if (i == 1) {
            main(runnable);
        } else if (i != 2) {
            runnable.run();
        } else {
            worker(runnable);
        }
    }

    public static void main(Runnable runnable) {
        main(runnable, 0);
    }

    public static void main(Runnable runnable, long j) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread() && j == 0) {
            runnable.run();
        } else {
            f19270a.postDelayed(runnable, j);
        }
    }

    public static void worker(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f19271b.submit(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submit(Runnable runnable) {
        f19271b.submit(runnable);
    }
}
