package com.didichuxing.alpha.fps;

import android.view.Choreographer;
import com.didichuxing.alpha.lag.OmegaLag;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import java.util.HashMap;

public class FPSFrameCallback implements Choreographer.FrameCallback {
    private static long currentFrameTimeNanos = 0;
    private static final long deviceRefreshRateNanos = 16600000;
    private static long lastFrameTimeNanos;

    public void doFrame(long j) {
        if (!OmegaFPS.getInstance().isPause()) {
            if (lastFrameTimeNanos == 0) {
                lastFrameTimeNanos = j;
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            OmegaFPS.getInstance().addFrame();
            currentFrameTimeNanos = j;
            final long droppedCount = droppedCount(lastFrameTimeNanos, j);
            if (droppedCount > 30 && droppedCount > (OmegaConfig.LAG_TIME / 1000) * 60 && OmegaLag.getInstance().isLagChecking() && AppStateMonitor.getInstance().isInForeground() && ScreenChangeReceiver.SCREEN_STATE == ScreenChangeReceiver.ScreenState.ON) {
                Tracker.trackEvent("omg_fps_df", (String) null, new HashMap<String, Object>() {
                    {
                        put("num", Long.valueOf(droppedCount));
                    }
                });
            }
            lastFrameTimeNanos = currentFrameTimeNanos;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    private long droppedCount(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > deviceRefreshRateNanos) {
            return (j3 / deviceRefreshRateNanos) - 1;
        }
        return 0;
    }
}
