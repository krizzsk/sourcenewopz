package org.osgi.util.tracker;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import org.osgi.framework.AllServiceListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class ServiceTracker<S, T> implements ServiceTrackerCustomizer<S, T> {
    static final boolean DEBUG = false;
    private volatile ServiceReference<S> cachedReference;
    private volatile T cachedService;
    protected final BundleContext context;
    final ServiceTrackerCustomizer<S, T> customizer;
    protected final Filter filter;
    final String listenerFilter;
    private final String trackClass;
    private final ServiceReference<S> trackReference;
    private volatile ServiceTracker<S, T>.Tracked tracked;

    public void modifiedService(ServiceReference<S> serviceReference, T t) {
    }

    private ServiceTracker<S, T>.Tracked tracked() {
        return this.tracked;
    }

    public ServiceTracker(BundleContext bundleContext, ServiceReference<S> serviceReference, ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {
        this.context = bundleContext;
        this.trackReference = serviceReference;
        this.trackClass = null;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        String str = "(service.id=" + serviceReference.getProperty(Constants.SERVICE_ID).toString() + ")";
        this.listenerFilter = str;
        try {
            this.filter = bundleContext.createFilter(str);
        } catch (InvalidSyntaxException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unexpected InvalidSyntaxException: " + e.getMessage());
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    public ServiceTracker(BundleContext bundleContext, String str, ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {
        this.context = bundleContext;
        this.trackReference = null;
        this.trackClass = str;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        String str2 = "(objectClass=" + str.toString() + ")";
        this.listenerFilter = str2;
        try {
            this.filter = bundleContext.createFilter(str2);
        } catch (InvalidSyntaxException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unexpected InvalidSyntaxException: " + e.getMessage());
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    public ServiceTracker(BundleContext bundleContext, Filter filter2, ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {
        this.context = bundleContext;
        this.trackReference = null;
        this.trackClass = null;
        this.listenerFilter = filter2.toString();
        this.filter = filter2;
        this.customizer = serviceTrackerCustomizer == null ? this : serviceTrackerCustomizer;
        if (bundleContext == null || filter2 == null) {
            throw null;
        }
    }

    public ServiceTracker(BundleContext bundleContext, Class<S> cls, ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {
        this(bundleContext, cls.getName(), serviceTrackerCustomizer);
    }

    public void open() {
        open(false);
    }

    public void open(boolean z) {
        synchronized (this) {
            if (this.tracked == null) {
                ServiceTracker<S, T>.Tracked allTracked = z ? new AllTracked() : new Tracked();
                synchronized (allTracked) {
                    try {
                        this.context.addServiceListener(allTracked, this.listenerFilter);
                        ServiceReference[] serviceReferenceArr = null;
                        if (this.trackClass != null) {
                            serviceReferenceArr = getInitialReferences(z, this.trackClass, (String) null);
                        } else if (this.trackReference == null) {
                            serviceReferenceArr = getInitialReferences(z, (String) null, this.listenerFilter);
                        } else if (this.trackReference.getBundle() != null) {
                            serviceReferenceArr = new ServiceReference[]{this.trackReference};
                        }
                        allTracked.setInitial(serviceReferenceArr);
                    } catch (InvalidSyntaxException e) {
                        throw new RuntimeException("unexpected InvalidSyntaxException: " + e.getMessage(), e);
                    }
                }
                this.tracked = allTracked;
                allTracked.trackInitial();
            }
        }
    }

    private ServiceReference<S>[] getInitialReferences(boolean z, String str, String str2) throws InvalidSyntaxException {
        return (ServiceReference[]) (z ? this.context.getAllServiceReferences(str, str2) : this.context.getServiceReferences(str, str2));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        modified();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        if (r1 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        if (r3 < r1.length) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0025, code lost:
        r0.untrack(r1[r3], null);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r5 = this;
            monitor-enter(r5)
            org.osgi.util.tracker.ServiceTracker<S, T>$Tracked r0 = r5.tracked     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0031 }
            return
        L_0x0007:
            r0.close()     // Catch:{ all -> 0x0031 }
            org.osgi.framework.ServiceReference[] r1 = r5.getServiceReferences()     // Catch:{ all -> 0x0031 }
            r2 = 0
            r5.tracked = r2     // Catch:{ all -> 0x0031 }
            org.osgi.framework.BundleContext r3 = r5.context     // Catch:{ IllegalStateException -> 0x0016 }
            r3.removeServiceListener(r0)     // Catch:{ IllegalStateException -> 0x0016 }
        L_0x0016:
            monitor-exit(r5)     // Catch:{ all -> 0x0031 }
            r5.modified()
            monitor-enter(r0)
            r0.notifyAll()     // Catch:{ all -> 0x002e }
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x002d
            r3 = 0
        L_0x0022:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x002d
            r4 = r1[r3]
            r0.untrack(r4, r2)
            int r3 = r3 + 1
            goto L_0x0022
        L_0x002d:
            return
        L_0x002e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r1
        L_0x0031:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0031 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.ServiceTracker.close():void");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [org.osgi.framework.ServiceReference<S>, org.osgi.framework.ServiceReference] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T addingService(org.osgi.framework.ServiceReference<S> r2) {
        /*
            r1 = this;
            org.osgi.framework.BundleContext r0 = r1.context
            java.lang.Object r2 = r0.getService(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.ServiceTracker.addingService(org.osgi.framework.ServiceReference):java.lang.Object");
    }

    public void removedService(ServiceReference<S> serviceReference, T t) {
        this.context.ungetService(serviceReference);
    }

    public T waitForService(long j) throws InterruptedException {
        long j2;
        T service;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            T service2 = getService();
            if (service2 != null) {
                return service2;
            }
            if (i == 0) {
                j2 = 0;
            } else {
                j2 = System.currentTimeMillis() + j;
            }
            do {
                ServiceTracker<S, T>.Tracked tracked2 = tracked();
                if (tracked2 == null) {
                    return null;
                }
                synchronized (tracked2) {
                    if (tracked2.size() == 0) {
                        tracked2.wait(j);
                    }
                }
                service = getService();
                if (j2 > 0) {
                    j = j2 - System.currentTimeMillis();
                    if (j <= 0) {
                        break;
                    }
                }
            } while (service == null);
            return service;
        }
        throw new IllegalArgumentException("timeout value is negative");
    }

    public ServiceReference<S>[] getServiceReferences() {
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return null;
        }
        synchronized (tracked2) {
            int size = tracked2.size();
            if (size == 0) {
                return null;
            }
            ServiceReference<S>[] serviceReferenceArr = (ServiceReference[]) tracked2.copyKeys(new ServiceReference[size]);
            return serviceReferenceArr;
        }
    }

    public ServiceReference<S> getServiceReference() {
        int i;
        ServiceReference<S> serviceReference = this.cachedReference;
        if (serviceReference != null) {
            return serviceReference;
        }
        ServiceReference<S>[] serviceReferences = getServiceReferences();
        int i2 = 0;
        if (serviceReferences == null) {
            i = 0;
        } else {
            i = serviceReferences.length;
        }
        if (i == 0) {
            return null;
        }
        if (i > 1) {
            int[] iArr = new int[i];
            int i3 = Integer.MIN_VALUE;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                Object property = serviceReferences[i6].getProperty(Constants.SERVICE_RANKING);
                int intValue = property instanceof Integer ? ((Integer) property).intValue() : 0;
                iArr[i6] = intValue;
                if (intValue > i3) {
                    i5 = i6;
                    i3 = intValue;
                    i4 = 1;
                } else if (intValue == i3) {
                    i4++;
                }
            }
            if (i4 > 1) {
                long j = Long.MAX_VALUE;
                while (i2 < i) {
                    if (iArr[i2] == i3) {
                        long longValue = ((Long) serviceReferences[i2].getProperty(Constants.SERVICE_ID)).longValue();
                        if (longValue < j) {
                            i5 = i2;
                            j = longValue;
                        }
                    }
                    i2++;
                }
            }
            i2 = i5;
        }
        ServiceReference<S> serviceReference2 = serviceReferences[i2];
        this.cachedReference = serviceReference2;
        return serviceReference2;
    }

    public T getService(ServiceReference<S> serviceReference) {
        T customizedObject;
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return null;
        }
        synchronized (tracked2) {
            customizedObject = tracked2.getCustomizedObject(serviceReference);
        }
        return customizedObject;
    }

    public Object[] getServices() {
        int i;
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return null;
        }
        synchronized (tracked2) {
            ServiceReference[] serviceReferences = getServiceReferences();
            if (serviceReferences == null) {
                i = 0;
            } else {
                i = serviceReferences.length;
            }
            if (i == 0) {
                return null;
            }
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = getService(serviceReferences[i2]);
            }
            return objArr;
        }
    }

    public T getService() {
        T t = this.cachedService;
        if (t != null) {
            return t;
        }
        ServiceReference serviceReference = getServiceReference();
        if (serviceReference == null) {
            return null;
        }
        T service = getService(serviceReference);
        this.cachedService = service;
        return service;
    }

    public void remove(ServiceReference<S> serviceReference) {
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 != null) {
            tracked2.untrack(serviceReference, null);
        }
    }

    public int size() {
        int size;
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
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
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return -1;
        }
        synchronized (tracked2) {
            trackingCount = tracked2.getTrackingCount();
        }
        return trackingCount;
    }

    /* access modifiers changed from: package-private */
    public void modified() {
        this.cachedReference = null;
        this.cachedService = null;
    }

    public SortedMap<ServiceReference<S>, T> getTracked() {
        SortedMap<ServiceReference<S>, T> sortedMap;
        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return treeMap;
        }
        synchronized (tracked2) {
            sortedMap = (SortedMap) tracked2.copyEntries(treeMap);
        }
        return sortedMap;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        ServiceTracker<S, T>.Tracked tracked2 = tracked();
        if (tracked2 == null) {
            return true;
        }
        synchronized (tracked2) {
            isEmpty = tracked2.isEmpty();
        }
        return isEmpty;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T[] getServices(T[] r7) {
        /*
            r6 = this;
            org.osgi.util.tracker.ServiceTracker$Tracked r0 = r6.tracked()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x000e
            int r0 = r7.length
            if (r0 <= 0) goto L_0x000d
            r7[r2] = r1
        L_0x000d:
            return r7
        L_0x000e:
            monitor-enter(r0)
            org.osgi.framework.ServiceReference[] r3 = r6.getServiceReferences()     // Catch:{ all -> 0x0048 }
            if (r3 != 0) goto L_0x0017
            r4 = 0
            goto L_0x0018
        L_0x0017:
            int r4 = r3.length     // Catch:{ all -> 0x0048 }
        L_0x0018:
            if (r4 != 0) goto L_0x0021
            int r3 = r7.length     // Catch:{ all -> 0x0048 }
            if (r3 <= 0) goto L_0x001f
            r7[r2] = r1     // Catch:{ all -> 0x0048 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return r7
        L_0x0021:
            int r5 = r7.length     // Catch:{ all -> 0x0048 }
            if (r4 <= r5) goto L_0x0034
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0048 }
            java.lang.Class r7 = r7.getComponentType()     // Catch:{ all -> 0x0048 }
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r4)     // Catch:{ all -> 0x0048 }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ all -> 0x0048 }
            java.lang.Object[] r7 = (java.lang.Object[]) r7     // Catch:{ all -> 0x0048 }
        L_0x0034:
            if (r2 >= r4) goto L_0x0041
            r5 = r3[r2]     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = r6.getService(r5)     // Catch:{ all -> 0x0048 }
            r7[r2] = r5     // Catch:{ all -> 0x0048 }
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0041:
            int r2 = r7.length     // Catch:{ all -> 0x0048 }
            if (r2 <= r4) goto L_0x0046
            r7[r4] = r1     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return r7
        L_0x0048:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.osgi.util.tracker.ServiceTracker.getServices(java.lang.Object[]):java.lang.Object[]");
    }

    private class Tracked extends AbstractTracked<ServiceReference<S>, T, ServiceEvent> implements ServiceListener {
        Tracked() {
        }

        public final void serviceChanged(ServiceEvent serviceEvent) {
            if (!this.closed) {
                ServiceReference<?> serviceReference = serviceEvent.getServiceReference();
                int type = serviceEvent.getType();
                if (type == 1 || type == 2) {
                    track(serviceReference, serviceEvent);
                } else if (type == 4 || type == 8) {
                    untrack(serviceReference, serviceEvent);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void modified() {
            super.modified();
            ServiceTracker.this.modified();
        }

        /* access modifiers changed from: package-private */
        public final T customizerAdding(ServiceReference<S> serviceReference, ServiceEvent serviceEvent) {
            return ServiceTracker.this.customizer.addingService(serviceReference);
        }

        /* access modifiers changed from: package-private */
        public final void customizerModified(ServiceReference<S> serviceReference, ServiceEvent serviceEvent, T t) {
            ServiceTracker.this.customizer.modifiedService(serviceReference, t);
        }

        /* access modifiers changed from: package-private */
        public final void customizerRemoved(ServiceReference<S> serviceReference, ServiceEvent serviceEvent, T t) {
            ServiceTracker.this.customizer.removedService(serviceReference, t);
        }
    }

    private class AllTracked extends Tracked implements AllServiceListener {
        AllTracked() {
            super();
        }
    }
}
