package com.didi.travel.p171v2.store;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.travel.p171v2.IKey;
import com.didi.travel.p171v2.util.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.travel.v2.store.Store */
public final class Store<T> implements LifecycleOwner, IKey {
    public static final Object[] S_NONE_INVOKE_ARGS = new Object[0];
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f44345a = Store.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Map<String, Store> f44346b = new HashMap();

    /* renamed from: c */
    private final String f44347c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Object[] f44348d = S_NONE_INVOKE_ARGS;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f44349e;

    /* renamed from: f */
    private IStoreCallback<T> f44350f;

    /* renamed from: g */
    private final LifecycleRegistry f44351g = LifecycleRegistry.createUnsafe(this);

    /* renamed from: h */
    private Lifecycle f44352h;

    /* renamed from: i */
    private final LifecycleEventObserver f44353i = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                Store.this.destroy();
            }
        }
    };

    public static Map<String, Store> getStoreMap() {
        return new HashMap(f44346b);
    }

    public static synchronized <T> Store<T> getStore(String str) {
        synchronized (Store.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Store<T> store = f44346b.get(str);
            return store;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T> com.didi.travel.p171v2.store.Store<T> getOrCreateStore(java.lang.String r5) {
        /*
            java.lang.Class<com.didi.travel.v2.store.Store> r0 = com.didi.travel.p171v2.store.Store.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x000c
            r5 = 0
            monitor-exit(r0)
            return r5
        L_0x000c:
            java.util.Map<java.lang.String, com.didi.travel.v2.store.Store> r1 = f44346b     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x003b }
            com.didi.travel.v2.store.Store r1 = (com.didi.travel.p171v2.store.Store) r1     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0039
            com.didi.travel.v2.store.Store r1 = new com.didi.travel.v2.store.Store     // Catch:{ all -> 0x003b }
            r1.<init>(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r2 = f44345a     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r3.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "new, storeKey = "
            r3.append(r4)     // Catch:{ all -> 0x003b }
            r3.append(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r5 = ", store = "
            r3.append(r5)     // Catch:{ all -> 0x003b }
            r3.append(r1)     // Catch:{ all -> 0x003b }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x003b }
            com.didi.travel.p171v2.util.LogUtils.m31495w(r2, r5)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)
            return r1
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.p171v2.store.Store.getOrCreateStore(java.lang.String):com.didi.travel.v2.store.Store");
    }

    private Store(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f44345a + ".new:storeKey is empty");
        } else if (f44346b.get(str) == null) {
            this.f44347c = str;
            this.f44351g.addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    String a = Store.f44345a;
                    LogUtils.m31492e(a, "onStateChanged:event = " + event + ", key = " + Store.this.getKey());
                    if (Lifecycle.Event.ON_CREATE.equals(event)) {
                        Object unused = Store.this.f44349e = null;
                        Object[] unused2 = Store.this.f44348d = null;
                        Store.f44346b.put(Store.this.getKey(), Store.this);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        Store.f44346b.remove(Store.this.getKey());
                    }
                }
            });
            this.f44351g.setCurrentState(Lifecycle.State.CREATED);
        } else {
            throw new IllegalArgumentException(f44345a + ".new:storeKey conflict, storeKey = " + str + ", origin store = " + f44346b.get(str));
        }
    }

    public String getKey() {
        return this.f44347c;
    }

    public synchronized Object[] getInvokeArgs() {
        if (!isValid()) {
            return null;
        }
        return this.f44348d;
    }

    public synchronized T getData() {
        if (!isValid()) {
            return null;
        }
        return this.f44349e;
    }

    public synchronized void setCallback(IStoreCallback<T> iStoreCallback) {
        this.f44350f = iStoreCallback;
        checkState();
    }

    public synchronized void setStore(Object[] objArr, T t) {
        if (!Lifecycle.State.DESTROYED.equals(getLifecycle().getCurrentState())) {
            this.f44348d = objArr;
            this.f44349e = t;
            checkState();
        }
    }

    public synchronized Lifecycle getOuterLifecycle() {
        return this.f44352h;
    }

    public synchronized void setOuterLifecycle(Lifecycle lifecycle) {
        if (lifecycle != this.f44352h) {
            if (this.f44352h != null) {
                this.f44352h.removeObserver(this.f44353i);
            }
            this.f44352h = lifecycle;
            lifecycle.addObserver(this.f44353i);
        }
    }

    public synchronized void reset() {
        this.f44348d = S_NONE_INVOKE_ARGS;
        this.f44349e = null;
        this.f44351g.setCurrentState(Lifecycle.State.CREATED);
    }

    public synchronized void destroy() {
        this.f44348d = S_NONE_INVOKE_ARGS;
        this.f44349e = null;
        this.f44351g.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public void checkState() {
        if (!Lifecycle.State.DESTROYED.equals(this.f44351g.getCurrentState())) {
            IStoreCallback<T> iStoreCallback = this.f44350f;
            if (iStoreCallback == null || iStoreCallback.isValid(this.f44348d, this.f44349e)) {
                this.f44351g.setCurrentState(Lifecycle.State.RESUMED);
            } else {
                this.f44351g.setCurrentState(Lifecycle.State.STARTED);
            }
        }
    }

    public synchronized boolean isValid() {
        checkState();
        return this.f44351g.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public LifecycleRegistry getLifecycle() {
        return this.f44351g;
    }
}
