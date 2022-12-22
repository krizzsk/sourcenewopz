package com.didi.hawaii.mapsdkv2.common;

import java.util.concurrent.CountDownLatch;

public abstract class PauseableThread extends Thread {
    private volatile boolean isPause;
    private volatile boolean isRun;
    private volatile boolean isShutDown;
    private final CountDownLatch mStartSignal;

    public static class Exit extends InterruptedException {
    }

    /* access modifiers changed from: protected */
    public void onBeginRun() throws InterruptedException {
    }

    /* access modifiers changed from: protected */
    public void onEndRun() {
    }

    /* access modifiers changed from: protected */
    public abstract int onRun() throws InterruptedException;

    public PauseableThread(String str) {
        this(str, (CountDownLatch) null);
    }

    public PauseableThread(String str, CountDownLatch countDownLatch) {
        super(str);
        this.isRun = true;
        this.isPause = false;
        this.isShutDown = false;
        this.mStartSignal = countDownLatch;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void run() {
        /*
            r2 = this;
            java.util.concurrent.CountDownLatch r0 = r2.mStartSignal     // Catch:{ InterruptedException -> 0x0032 }
            if (r0 == 0) goto L_0x0009
            java.util.concurrent.CountDownLatch r0 = r2.mStartSignal     // Catch:{ InterruptedException -> 0x0032 }
            r0.await()     // Catch:{ InterruptedException -> 0x0032 }
        L_0x0009:
            r2.onBeginRun()     // Catch:{ InterruptedException -> 0x0032 }
        L_0x000c:
            boolean r0 = r2.isRun     // Catch:{ InterruptedException -> 0x0032 }
            if (r0 == 0) goto L_0x0039
            boolean r0 = r2.isPause     // Catch:{ InterruptedException -> 0x0032 }
            if (r0 != 0) goto L_0x0024
            int r0 = r2.onRun()     // Catch:{ InterruptedException -> 0x0032 }
            if (r0 <= 0) goto L_0x000c
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0032 }
            long r0 = (long) r0
            r2.wait(r0)     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            goto L_0x000c
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ InterruptedException -> 0x0032 }
        L_0x0024:
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0032 }
        L_0x0025:
            boolean r0 = r2.isPause     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            r2.wait()     // Catch:{ all -> 0x002f }
            goto L_0x0025
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            goto L_0x000c
        L_0x002f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            throw r0     // Catch:{ InterruptedException -> 0x0032 }
        L_0x0032:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0039:
            r2.onEndRun()
            monitor-enter(r2)
            r0 = 1
            r2.isShutDown = r0     // Catch:{ all -> 0x0045 }
            r2.notifyAll()     // Catch:{ all -> 0x0045 }
            monitor-exit(r2)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0045 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.common.PauseableThread.run():void");
    }

    public void shutDown() {
        this.isRun = false;
        interrupt();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|17|14|3) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0004, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutDownBlock() {
        /*
            r1 = this;
            monitor-enter(r1)
            r1.shutDown()     // Catch:{ all -> 0x0016 }
        L_0x0004:
            boolean r0 = r1.isShutDown     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0014
            r1.wait()     // Catch:{ InterruptedException -> 0x000c }
            goto L_0x0004
        L_0x000c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0016 }
            r0.interrupt()     // Catch:{ all -> 0x0016 }
            goto L_0x0004
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.common.PauseableThread.shutDownBlock():void");
    }

    public void pause() {
        this.isPause = true;
    }

    public void resumeFromPause() {
        this.isPause = false;
        synchronized (this) {
            notifyAll();
        }
    }
}
