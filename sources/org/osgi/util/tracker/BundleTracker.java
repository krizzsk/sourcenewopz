package org.osgi.util.tracker;

import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

public class BundleTracker<T> implements BundleTrackerCustomizer<T> {
    static final boolean DEBUG = false;
    protected final BundleContext context;
    final BundleTrackerCustomizer<T> customizer;
    final int mask;
    private volatile BundleTracker<T>.Tracked tracked;

    public T addingBundle(Bundle bundle, BundleEvent bundleEvent) {
        return bundle;
    }

    public void modifiedBundle(Bundle bundle, BundleEvent bundleEvent, T t) {
    }

    public void removedBundle(Bundle bundle, BundleEvent bundleEvent, T t) {
    }

    private BundleTracker<T>.Tracked tracked() {
        return this.tracked;
    }

    public BundleTracker(BundleContext bundleContext, int i, BundleTrackerCustomizer<T> bundleTrackerCustomizer) {
        this.context = bundleContext;
        this.mask = i;
        this.customizer = bundleTrackerCustomizer == null ? this : bundleTrackerCustomizer;
    }

    public void open() {
        synchronized (this) {
            if (this.tracked == null) {
                BundleTracker<T>.Tracked tracked2 = new Tracked();
                synchronized (tracked2) {
                    this.context.addBundleListener(tracked2);
                    Bundle[] bundles = this.context.getBundles();
                    if (bundles != null) {
                        int length = bundles.length;
                        for (int i = 0; i < length; i++) {
                            if ((bundles[i].getState() & this.mask) == 0) {
                                bundles[i] = null;
                            }
                        }
                        tracked2.setInitial(bundles);
                    }
                }
                this.tracked = tracked2;
                tracked2.trackInitial();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r1 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r3 < r1.length) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r0.untrack(r1[r3], null);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r5 = this;
            monitor-enter(r5)
            org.osgi.util.tracker.BundleTracker<T>$Tracked r0 = r5.tracked     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            return
        L_0x0007:
            r0.close()     // Catch:{ all -> 0x0026 }
            org.osgi.framework.Bundle[] r1 = r5.getBundles()     // Catch:{ all -> 0x0026 }
            r2 = 0
            r5.tracked = r2     // Catch:{ all -> 0x0026 }
            org.osgi.framework.BundleContext r3 = r5.context     // Catch:{ IllegalStateException -> 0x0016 }
            r3.removeBundleListener(r0)     // Catch:{ IllegalStateException -> 0x0016 }
        L_0x0016:
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0025
            r3 = 0
        L_0x001a:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0025
            r4 = r1[r3]
            r0.untrack(r4, r2)
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0025:
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.BundleTracker.close():void");
    }

    public Bundle[] getBundles() {
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return null;
        }
        synchronized (tracked2) {
            int size = tracked2.size();
            if (size == 0) {
                return null;
            }
            Bundle[] bundleArr = (Bundle[]) tracked2.copyKeys(new Bundle[size]);
            return bundleArr;
        }
    }

    public T getObject(Bundle bundle) {
        T customizedObject;
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return null;
        }
        synchronized (tracked2) {
            customizedObject = tracked2.getCustomizedObject(bundle);
        }
        return customizedObject;
    }

    public void remove(Bundle bundle) {
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 != null) {
            tracked2.untrack(bundle, null);
        }
    }

    public int size() {
        int size;
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return 0;
        }
        synchronized (tracked2) {
            size = tracked2.size();
        }
        return size;
    }

    public int getTrackingCount() {
        int trackingCount;
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return -1;
        }
        synchronized (tracked2) {
            trackingCount = tracked2.getTrackingCount();
        }
        return trackingCount;
    }

    public Map<Bundle, T> getTracked() {
        Map<Bundle, T> copyEntries;
        HashMap hashMap = new HashMap();
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return hashMap;
        }
        synchronized (tracked2) {
            copyEntries = tracked2.copyEntries(hashMap);
        }
        return copyEntries;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        BundleTracker<T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return true;
        }
        synchronized (tracked2) {
            isEmpty = tracked2.isEmpty();
        }
        return isEmpty;
    }

    private final class Tracked extends AbstractTracked<Bundle, T, BundleEvent> implements SynchronousBundleListener {
        Tracked() {
        }

        public void bundleChanged(BundleEvent bundleEvent) {
            if (!this.closed) {
                Bundle bundle = bundleEvent.getBundle();
                if ((bundle.getState() & BundleTracker.this.mask) != 0) {
                    track(bundle, bundleEvent);
                } else {
                    untrack(bundle, bundleEvent);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public T customizerAdding(Bundle bundle, BundleEvent bundleEvent) {
            return BundleTracker.this.customizer.addingBundle(bundle, bundleEvent);
        }

        /* access modifiers changed from: package-private */
        public void customizerModified(Bundle bundle, BundleEvent bundleEvent, T t) {
            BundleTracker.this.customizer.modifiedBundle(bundle, bundleEvent, t);
        }

        /* access modifiers changed from: package-private */
        public void customizerRemoved(Bundle bundle, BundleEvent bundleEvent, T t) {
            BundleTracker.this.customizer.removedBundle(bundle, bundleEvent, t);
        }
    }
}
