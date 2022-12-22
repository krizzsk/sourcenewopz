package org.osgi.util.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

abstract class AbstractTracked<S, T, R> {
    static final boolean DEBUG = false;
    private final List<S> adding = new ArrayList(6);
    volatile boolean closed = false;
    private final LinkedList<S> initial = new LinkedList<>();
    private final Map<S, T> tracked = new HashMap();
    private int trackingCount = 0;

    /* access modifiers changed from: package-private */
    public abstract T customizerAdding(S s, R r);

    /* access modifiers changed from: package-private */
    public abstract void customizerModified(S s, R r, T t);

    /* access modifiers changed from: package-private */
    public abstract void customizerRemoved(S s, R r, T t);

    AbstractTracked() {
    }

    /* access modifiers changed from: package-private */
    public void setInitial(S[] sArr) {
        if (sArr != null) {
            for (S s : sArr) {
                if (s != null) {
                    this.initial.add(s);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        trackAdding(r0, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackInitial() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            boolean r0 = r2.closed     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0033
            java.util.LinkedList<S> r0 = r2.initial     // Catch:{ all -> 0x0035 }
            int r0 = r0.size()     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x000e
            goto L_0x0033
        L_0x000e:
            java.util.LinkedList<S> r0 = r2.initial     // Catch:{ all -> 0x0035 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0035 }
            java.util.Map<S, T> r1 = r2.tracked     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x001e
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x0000
        L_0x001e:
            java.util.List<S> r1 = r2.adding     // Catch:{ all -> 0x0035 }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0028
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x0000
        L_0x0028:
            java.util.List<S> r1 = r2.adding     // Catch:{ all -> 0x0035 }
            r1.add(r0)     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            r1 = 0
            r2.trackAdding(r0, r1)
            goto L_0x0000
        L_0x0033:
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.AbstractTracked.trackInitial():void");
    }

    /* access modifiers changed from: package-private */
    public void close() {
        this.closed = true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r0 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        trackAdding(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        customizerModified(r3, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void track(S r3, R r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.closed     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            return
        L_0x0007:
            java.util.Map<S, T> r0 = r2.tracked     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x001f
            java.util.List<S> r1 = r2.adding     // Catch:{ all -> 0x002d }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            return
        L_0x0019:
            java.util.List<S> r1 = r2.adding     // Catch:{ all -> 0x002d }
            r1.add(r3)     // Catch:{ all -> 0x002d }
            goto L_0x0022
        L_0x001f:
            r2.modified()     // Catch:{ all -> 0x002d }
        L_0x0022:
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0029
            r2.trackAdding(r3, r4)
            goto L_0x002c
        L_0x0029:
            r2.customizerModified(r3, r4, r0)
        L_0x002c:
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.AbstractTracked.track(java.lang.Object, java.lang.Object):void");
    }

    private void trackAdding(S s, R r) {
        boolean z;
        try {
            Object customizerAdding = customizerAdding(s, r);
            synchronized (this) {
                if (!this.adding.remove(s) || this.closed) {
                    z = true;
                } else {
                    if (customizerAdding != null) {
                        this.tracked.put(s, customizerAdding);
                        modified();
                        notifyAll();
                    }
                    z = false;
                }
            }
            if (z && customizerAdding != null) {
                customizerRemoved(s, r, customizerAdding);
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this.adding.remove(s)) {
                    boolean z2 = this.closed;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void untrack(S s, R r) {
        synchronized (this) {
            if (!this.initial.remove(s)) {
                if (!this.adding.remove(s)) {
                    T remove = this.tracked.remove(s);
                    if (remove != null) {
                        modified();
                        customizerRemoved(s, r, remove);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.tracked.size();
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.tracked.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public T getCustomizedObject(S s) {
        return this.tracked.get(s);
    }

    /* access modifiers changed from: package-private */
    public S[] copyKeys(S[] sArr) {
        return this.tracked.keySet().toArray(sArr);
    }

    /* access modifiers changed from: package-private */
    public void modified() {
        this.trackingCount++;
    }

    /* access modifiers changed from: package-private */
    public int getTrackingCount() {
        return this.trackingCount;
    }

    /* access modifiers changed from: package-private */
    public <M extends Map<? super S, ? super T>> M copyEntries(M m) {
        m.putAll(this.tracked);
        return m;
    }
}
