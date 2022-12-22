package com.didi.app.nova.skeleton.repo;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LiveData<T> {

    /* renamed from: a */
    static final int f8503a = -1;

    /* renamed from: b */
    private static final Object f8504b = new Object();

    /* renamed from: c */
    private Object f8505c = f8504b;

    /* renamed from: d */
    private int f8506d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ConcurrentHashMap<Action, LiveData<T>.LifecycleSubscriptionImpl> f8507e = new ConcurrentHashMap<>();

    public void setValue(T t) {
        this.f8506d++;
        this.f8505c = t;
        m5683a((LiveData<T>.LifecycleSubscriptionImpl) null);
    }

    public T getValue() {
        T t = this.f8505c;
        if (t != f8504b) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.f8506d;
    }

    public LiveData<T>.SubscribeFilter from() {
        return new SubscribeFilter();
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<T> action) {
        return m5680a(scopeContext, action, (Predicate) null, true, (Function) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Subscription m5680a(ScopeContext scopeContext, Action<T> action, Predicate predicate, boolean z, Function<T, C3757R> function) {
        LifecycleSubscriptionImpl lifecycleSubscriptionImpl;
        if (scopeContext.getLiveHandler().isDestroyed()) {
            return new SubscriptionEmpty();
        }
        if (this.f8507e.containsKey(action)) {
            return this.f8507e.get(action);
        }
        if (z) {
            lifecycleSubscriptionImpl = new LifecycleSubscriptionImpl(scopeContext, action, predicate, function);
        } else {
            lifecycleSubscriptionImpl = new LifecycleSubscriptionImpl(scopeContext, action, predicate, getVersion(), function);
        }
        this.f8507e.put(action, lifecycleSubscriptionImpl);
        lifecycleSubscriptionImpl.activeChange(scopeContext.getLiveHandler().isActive());
        return lifecycleSubscriptionImpl;
    }

    /* access modifiers changed from: protected */
    public Subscription subscribeForever(Action<T> action) {
        if (this.f8507e.containsKey(action)) {
            return this.f8507e.get(action);
        }
        LifecycleSubscriptionImpl lifecycleSubscriptionImpl = new LifecycleSubscriptionImpl(action);
        this.f8507e.put(action, lifecycleSubscriptionImpl);
        lifecycleSubscriptionImpl.activeChange(true);
        return lifecycleSubscriptionImpl;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5683a(LiveData<T>.LifecycleSubscriptionImpl lifecycleSubscriptionImpl) {
        if (lifecycleSubscriptionImpl == null) {
            for (Map.Entry<Action, LiveData<T>.LifecycleSubscriptionImpl> value : this.f8507e.entrySet()) {
                m5685b((LifecycleSubscriptionImpl) value.getValue());
            }
            return;
        }
        m5685b(lifecycleSubscriptionImpl);
    }

    /* renamed from: b */
    private void m5685b(LiveData<T>.LifecycleSubscriptionImpl lifecycleSubscriptionImpl) {
        int i;
        if (lifecycleSubscriptionImpl.active && lifecycleSubscriptionImpl.lastVersion < (i = this.f8506d)) {
            lifecycleSubscriptionImpl.lastVersion = i;
            if (!f8504b.equals(this.f8505c)) {
                Event event = new Event(lifecycleSubscriptionImpl.oldData, this.f8505c, lifecycleSubscriptionImpl);
                if (lifecycleSubscriptionImpl.predicate == null || lifecycleSubscriptionImpl.predicate.test(event)) {
                    Object obj = this.f8505c;
                    Object access$000 = lifecycleSubscriptionImpl.oldData;
                    if (lifecycleSubscriptionImpl.function != null) {
                        obj = lifecycleSubscriptionImpl.function.apply(event);
                    }
                    if (lifecycleSubscriptionImpl.action instanceof Action1) {
                        ((Action1) lifecycleSubscriptionImpl.action).call(obj);
                    } else if (lifecycleSubscriptionImpl.action instanceof Action2) {
                        ((Action2) lifecycleSubscriptionImpl.action).call(obj, lifecycleSubscriptionImpl);
                    } else if (lifecycleSubscriptionImpl.action instanceof Action3) {
                        ((Action3) lifecycleSubscriptionImpl.action).invoke(obj, lifecycleSubscriptionImpl);
                    } else if (!(lifecycleSubscriptionImpl.action instanceof Action4)) {
                        ((Action1) lifecycleSubscriptionImpl.action).call(obj);
                    } else if (obj instanceof Event) {
                        ((Action4) lifecycleSubscriptionImpl.action).call((Event) obj);
                    } else {
                        ((Action4) lifecycleSubscriptionImpl.action).call(new Event(access$000, obj, lifecycleSubscriptionImpl));
                    }
                    lifecycleSubscriptionImpl.setData(this.f8505c);
                }
            }
        }
    }

    class LifecycleSubscriptionImpl implements Subscription {
        final Action action;
        boolean active;
        Function<T, C3757R> function;
        public int lastVersion = -1;
        private IScopeLifecycle lifecycle = new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(true);
            }

            public void onStart(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(true);
            }

            public void onResume(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(true);
            }

            public void onPause(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(false);
            }

            public void onStop(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(false);
            }

            public void onDestroy(ILive iLive) {
                LifecycleSubscriptionImpl.this.activeChange(false);
                LifecycleSubscriptionImpl.this.unsubscribe();
            }
        };
        /* access modifiers changed from: private */
        public Object oldData = null;
        WeakReference<ScopeContext> owner;
        public Predicate predicate;

        LifecycleSubscriptionImpl(ScopeContext scopeContext, Action action2, Predicate predicate2, Function<T, C3757R> function2) {
            this.action = action2;
            WeakReference<ScopeContext> weakReference = new WeakReference<>(scopeContext);
            this.owner = weakReference;
            ((ScopeContext) weakReference.get()).addObserver(this.lifecycle);
            this.predicate = predicate2;
            this.function = function2;
        }

        LifecycleSubscriptionImpl(ScopeContext scopeContext, Action action2, Predicate predicate2, int i, Function<T, C3757R> function2) {
            this.action = action2;
            WeakReference<ScopeContext> weakReference = new WeakReference<>(scopeContext);
            this.owner = weakReference;
            ((ScopeContext) weakReference.get()).addObserver(this.lifecycle);
            this.predicate = predicate2;
            this.lastVersion = i;
            this.function = function2;
        }

        public void setData(Object obj) {
            this.oldData = obj;
        }

        LifecycleSubscriptionImpl(Action action2) {
            this.action = action2;
        }

        public ScopeContext getOwner() {
            return (ScopeContext) this.owner.get();
        }

        public boolean isUnsubscribed() {
            return LiveData.this.f8507e.get(this.action) == null;
        }

        public void unsubscribe() {
            if (!isUnsubscribed()) {
                LiveData.this.f8507e.remove(this.action);
            }
            if (this.owner.get() != null) {
                ((ScopeContext) this.owner.get()).removeObserver(this.lifecycle);
            }
            this.owner.clear();
        }

        public void activeChange(boolean z) {
            if (!isUnsubscribed() && z != this.active) {
                this.active = z;
                if (z) {
                    LiveData.this.m5683a((LiveData<T>.LifecycleSubscriptionImpl) this);
                }
            }
        }
    }

    class SubscriptionEmpty implements Subscription {
        public void activeChange(boolean z) {
        }

        public boolean isUnsubscribed() {
            return false;
        }

        public void unsubscribe() {
        }

        SubscriptionEmpty() {
        }
    }

    public class SubscribeFilter {
        Function function;
        Predicate<Event<T>> predicate;
        boolean viscous = true;

        public SubscribeFilter() {
        }

        public LiveData<T>.SubscribeFilter filter(Predicate<Event<T>> predicate2) {
            this.predicate = predicate2;
            return this;
        }

        public LiveData<T>.SubscribeFilter map(Function function2) {
            this.function = function2;
            return this;
        }

        public LiveData<T>.SubscribeFilter shutViscidityNotice() {
            this.viscous = false;
            return this;
        }

        public Subscription subscribe(ScopeContext scopeContext, Action<T> action) {
            return LiveData.this.m5680a(scopeContext, action, this.predicate, this.viscous, this.function);
        }
    }
}
