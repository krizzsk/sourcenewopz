package com.didichuxing.alpha.lag;

import android.os.Looper;
import com.didichuxing.alpha.lag.LooperMonitor;
import com.didichuxing.alpha.lag.internal.BlockInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BlockCanaryInternals {
    private static BlockCanaryContext sContext;
    private static BlockCanaryInternals sInstance;
    CpuSampler cpuSampler = new CpuSampler(sContext.provideDumpInterval());
    /* access modifiers changed from: private */
    public List<BlockInterceptor> mInterceptorChain = new LinkedList();
    LooperMonitor monitor;
    StackSampler stackSampler = new StackSampler(Looper.getMainLooper().getThread(), sContext.provideDumpInterval());

    public BlockCanaryInternals() {
        setMonitor(new LooperMonitor(new LooperMonitor.BlockListener() {
            public void onBlockEvent(long j, long j2, long j3, long j4) {
                long j5 = j;
                long j6 = j2;
                ArrayList<String> threadStackEntries = BlockCanaryInternals.this.stackSampler.getThreadStackEntries(j5, j6);
                if (!threadStackEntries.isEmpty()) {
                    BlockInfo flushString = BlockInfo.newInstance().setMainThreadTimeCost(j, j2, j3, j4).setCpuBusyFlag(BlockCanaryInternals.this.cpuSampler.isCpuBusy(j5, j6)).setRecentCpuRate(BlockCanaryInternals.this.cpuSampler.getCpuRateInfo()).setThreadStackEntries(threadStackEntries).flushString();
                    if (BlockCanaryInternals.this.mInterceptorChain.size() != 0) {
                        for (BlockInterceptor onBlock : BlockCanaryInternals.this.mInterceptorChain) {
                            onBlock.onBlock(BlockCanaryInternals.getContext().provideContext(), flushString);
                        }
                    }
                }
            }
        }, getContext().provideBlockThreshold(), getContext().stopWhenDebugging()));
    }

    static BlockCanaryInternals getInstance() {
        if (sInstance == null) {
            synchronized (BlockCanaryInternals.class) {
                if (sInstance == null) {
                    sInstance = new BlockCanaryInternals();
                }
            }
        }
        return sInstance;
    }

    public static void setContext(BlockCanaryContext blockCanaryContext) {
        sContext = blockCanaryContext;
    }

    public static BlockCanaryContext getContext() {
        return sContext;
    }

    /* access modifiers changed from: package-private */
    public void addBlockInterceptor(BlockInterceptor blockInterceptor) {
        this.mInterceptorChain.add(blockInterceptor);
    }

    private void setMonitor(LooperMonitor looperMonitor) {
        this.monitor = looperMonitor;
    }

    /* access modifiers changed from: package-private */
    public long getSampleDelay() {
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
