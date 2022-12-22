package com.didichuxing.alpha.lag;

import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class BlockCanary {
    private static final Executor fileIoExecutor = newSingleThreadExecutor("File-IO");
    private static BlockCanary sInstance;
    private BlockCanaryInternals mBlockCanaryCore;
    private boolean mMonitorStarted = false;

    private BlockCanary() {
        BlockCanaryInternals.setContext(BlockCanaryContext.get());
        BlockCanaryInternals instance = BlockCanaryInternals.getInstance();
        this.mBlockCanaryCore = instance;
        instance.addBlockInterceptor(BlockCanaryContext.get());
        if (!BlockCanaryContext.get().displayNotification()) {
        }
    }

    public static BlockCanary install(Context context, BlockCanaryContext blockCanaryContext) {
        BlockCanaryContext.init(context, blockCanaryContext);
        return get();
    }

    public static BlockCanary get() {
        if (sInstance == null) {
            synchronized (BlockCanary.class) {
                if (sInstance == null) {
                    sInstance = new BlockCanary();
                }
            }
        }
        return sInstance;
    }

    public void start() {
        if (!this.mMonitorStarted) {
            this.mMonitorStarted = true;
            Looper.getMainLooper().setMessageLogging(this.mBlockCanaryCore.monitor);
        }
    }

    public void stop() {
        if (this.mMonitorStarted) {
            this.mMonitorStarted = false;
            Looper.getMainLooper().setMessageLogging((Printer) null);
            this.mBlockCanaryCore.stackSampler.stop();
            this.mBlockCanaryCore.cpuSampler.stop();
        }
    }

    public void recordStartTime() {
        SystemUtils.getDefaultSharedPreferences(BlockCanaryContext.get().provideContext()).edit().putLong("BlockCanary_StartTime", System.currentTimeMillis()).commit();
    }

    public boolean isMonitorDurationEnd() {
        long j = SystemUtils.getDefaultSharedPreferences(BlockCanaryContext.get().provideContext()).getLong("BlockCanary_StartTime", 0);
        return j != 0 && System.currentTimeMillis() - j > ((long) ((BlockCanaryContext.get().provideMonitorDuration() * 3600) * 1000));
    }

    /* access modifiers changed from: private */
    public static void setEnabledBlocking(Context context, Class<?> cls, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
    }

    private static void executeOnFileIoThread(Runnable runnable) {
        fileIoExecutor.execute(runnable);
    }

    private static Executor newSingleThreadExecutor(String str) {
        return Executors.newSingleThreadExecutor(new SingleThreadFactory(str));
    }

    private static void setEnabled(Context context, final Class<?> cls, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        executeOnFileIoThread(new Runnable() {
            public void run() {
                BlockCanary.setEnabledBlocking(applicationContext, cls, z);
            }
        });
    }
}
