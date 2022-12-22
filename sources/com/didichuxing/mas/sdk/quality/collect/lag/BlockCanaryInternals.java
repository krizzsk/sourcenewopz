package com.didichuxing.mas.sdk.quality.collect.lag;

import android.os.Looper;
import com.didichuxing.mas.sdk.quality.collect.lag.LooperMonitor;
import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BlockCanaryInternals {

    /* renamed from: d */
    private static BlockCanaryInternals f48103d;

    /* renamed from: e */
    private static BlockCanaryContext f48104e;

    /* renamed from: a */
    LooperMonitor f48105a;

    /* renamed from: b */
    C15803e f48106b = new C15803e(Looper.getMainLooper().getThread(), f48104e.provideDumpInterval());

    /* renamed from: c */
    C15801c f48107c = new C15801c(f48104e.provideDumpInterval());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<C15800b> f48108f = new LinkedList();

    public BlockCanaryInternals() {
        m34312a(new LooperMonitor(new LooperMonitor.BlockListener() {
            public void onBlockEvent(long j, long j2, long j3, long j4) {
                long j5 = j;
                long j6 = j2;
                ArrayList<String> a = BlockCanaryInternals.this.f48106b.mo118410a(j5, j6);
                if (!a.isEmpty()) {
                    BlockInfo flushString = BlockInfo.newInstance().setMainThreadTimeCost(j, j2, j3, j4).setCpuBusyFlag(BlockCanaryInternals.this.f48107c.mo118407a(j5, j6)).setRecentCpuRate(BlockCanaryInternals.this.f48107c.mo118408d()).setThreadStackEntries(a).flushString();
                    if (BlockCanaryInternals.this.f48108f.size() != 0) {
                        for (C15800b onBlock : BlockCanaryInternals.this.f48108f) {
                            onBlock.onBlock(BlockCanaryInternals.getContext().provideContext(), flushString);
                        }
                    }
                }
            }
        }, getContext().provideBlockThreshold(), getContext().stopWhenDebugging()));
    }

    /* renamed from: a */
    static BlockCanaryInternals m34310a() {
        if (f48103d == null) {
            synchronized (BlockCanaryInternals.class) {
                if (f48103d == null) {
                    f48103d = new BlockCanaryInternals();
                }
            }
        }
        return f48103d;
    }

    public static void setContext(BlockCanaryContext blockCanaryContext) {
        f48104e = blockCanaryContext;
    }

    public static BlockCanaryContext getContext() {
        return f48104e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo118394a(C15800b bVar) {
        this.f48108f.add(bVar);
    }

    /* renamed from: a */
    private void m34312a(LooperMonitor looperMonitor) {
        this.f48105a = looperMonitor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo118395b() {
        return (long) (((float) getContext().provideBlockThreshold()) * 0.8f);
    }

    private static class BlockLogFileFilter implements FilenameFilter {
        private String TYPE = ".log";

        BlockLogFileFilter() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(this.TYPE);
        }
    }
}
