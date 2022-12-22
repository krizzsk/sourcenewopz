package com.didichuxing.alpha.lag;

import android.os.SystemClock;
import android.util.Printer;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;

class LooperMonitor implements Printer {
    private static long DEFAULT_BLOCK_THRESHOLD_MILLIS = 3000;
    /* access modifiers changed from: private */
    public BlockListener mBlockListener = null;
    private long mBlockThresholdMillis = DEFAULT_BLOCK_THRESHOLD_MILLIS;
    private boolean mPrintingStarted = false;
    private long mStartThreadTimestamp = 0;
    private long mStartTimestamp = 0;
    private final boolean mStopWhenDebugging;

    public interface BlockListener {
        void onBlockEvent(long j, long j2, long j3, long j4);
    }

    public LooperMonitor(BlockListener blockListener, long j, boolean z) {
        if (blockListener != null) {
            this.mBlockListener = blockListener;
            this.mBlockThresholdMillis = j;
            this.mStopWhenDebugging = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public void println(String str) {
        if (!this.mPrintingStarted) {
            this.mStartTimestamp = System.currentTimeMillis();
            this.mStartThreadTimestamp = SystemClock.currentThreadTimeMillis();
            this.mPrintingStarted = true;
            startDump();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mPrintingStarted = false;
        if (isBlock(currentTimeMillis)) {
            notifyBlockEvent(currentTimeMillis);
        }
        stopDump();
    }

    private boolean isBlock(long j) {
        return j - this.mStartTimestamp > this.mBlockThresholdMillis && AppStateMonitor.getInstance().isInForeground() && ScreenChangeReceiver.SCREEN_STATE == ScreenChangeReceiver.ScreenState.ON;
    }

    private void notifyBlockEvent(long j) {
        final long j2 = this.mStartTimestamp;
        final long j3 = this.mStartThreadTimestamp;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final long j4 = j;
        HandlerThreadFactory.getWriteLogThreadHandler().post(new Runnable() {
            public void run() {
                LooperMonitor.this.mBlockListener.onBlockEvent(j2, j4, j3, currentThreadTimeMillis);
            }
        });
    }

    private void startDump() {
        if (BlockCanaryInternals.getInstance().stackSampler != null) {
            BlockCanaryInternals.getInstance().stackSampler.start();
        }
        if (BlockCanaryInternals.getInstance().cpuSampler != null) {
            BlockCanaryInternals.getInstance().cpuSampler.start();
        }
    }

    private void stopDump() {
        if (BlockCanaryInternals.getInstance().stackSampler != null) {
            BlockCanaryInternals.getInstance().stackSampler.stop();
        }
        if (BlockCanaryInternals.getInstance().cpuSampler != null) {
            BlockCanaryInternals.getInstance().cpuSampler.stop();
        }
    }
}
