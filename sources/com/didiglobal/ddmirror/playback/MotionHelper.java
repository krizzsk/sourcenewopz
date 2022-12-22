package com.didiglobal.ddmirror.playback;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MotionHelper {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void simulateClick(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        long uptimeMillis = SystemClock.uptimeMillis();
        float width = (float) (iArr[0] + (view.getWidth() / 2));
        float height = (float) (iArr[1] + (view.getHeight() / 2));
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, width, height, 0);
        long j = uptimeMillis + 100;
        MotionEvent obtain2 = MotionEvent.obtain(j, j, 1, width, height, 0);
        view.onTouchEvent(obtain);
        view.onTouchEvent(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    public static void simulateBack() {
        execute(new Runnable() {
            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void execute(Runnable runnable) {
        DEFAULT_EXECUTOR_SERVICE.execute(runnable);
    }
}
