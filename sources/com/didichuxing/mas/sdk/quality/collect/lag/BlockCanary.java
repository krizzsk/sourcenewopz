package com.didichuxing.mas.sdk.quality.collect.lag;

import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class BlockCanary {

    /* renamed from: a */
    private static BlockCanary f48099a;

    /* renamed from: d */
    private static final Executor f48100d = m34305a("File-IO");

    /* renamed from: b */
    private BlockCanaryInternals f48101b;

    /* renamed from: c */
    private boolean f48102c = false;

    private BlockCanary() {
        BlockCanaryInternals.setContext(BlockCanaryContext.get());
        BlockCanaryInternals a = BlockCanaryInternals.m34310a();
        this.f48101b = a;
        a.mo118394a((C15800b) BlockCanaryContext.get());
        if (!BlockCanaryContext.get().displayNotification()) {
        }
    }

    public static BlockCanary install(Context context, BlockCanaryContext blockCanaryContext) {
        BlockCanaryContext.init(context, blockCanaryContext);
        return get();
    }

    public static BlockCanary get() {
        if (f48099a == null) {
            synchronized (BlockCanary.class) {
                if (f48099a == null) {
                    f48099a = new BlockCanary();
                }
            }
        }
        return f48099a;
    }

    public void start() {
        if (!this.f48102c) {
            this.f48102c = true;
            Looper.getMainLooper().setMessageLogging(this.f48101b.f48105a);
        }
    }

    public void stop() {
        if (this.f48102c) {
            this.f48102c = false;
            Looper.getMainLooper().setMessageLogging((Printer) null);
            this.f48101b.f48106b.mo118405b();
            this.f48101b.f48107c.mo118405b();
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
    /* renamed from: b */
    public static void m34308b(Context context, Class<?> cls, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
    }

    /* renamed from: a */
    private static void m34307a(Runnable runnable) {
        f48100d.execute(runnable);
    }

    /* renamed from: a */
    private static Executor m34305a(String str) {
        return Executors.newSingleThreadExecutor(new C15802d(str));
    }

    /* renamed from: c */
    private static void m34309c(Context context, final Class<?> cls, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        m34307a((Runnable) new Runnable() {
            public void run() {
                BlockCanary.m34308b(applicationContext, cls, z);
            }
        });
    }
}
