package com.didi.app.nova.skeleton.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import java.util.concurrent.ConcurrentHashMap;

public class MediatorLiveData<T> extends LiveData<T> {

    /* renamed from: b */
    private ConcurrentHashMap<LiveData<?>, MediatorLiveData<T>.Source<?>> f8508b = new ConcurrentHashMap<>();

    public <S> void addSource(LiveData<S> liveData, Action1<S> action1) {
        Source source = new Source(liveData, action1);
        if (!this.f8508b.containsKey(liveData)) {
            this.f8508b.put(liveData, source);
        }
    }

    public <S> void addSource(LiveData<S> liveData, ScopeContext scopeContext, Action1<S> action1) {
        Source source = new Source(liveData, action1, scopeContext);
        if (!this.f8508b.containsKey(liveData)) {
            this.f8508b.put(liveData, source);
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source remove = this.f8508b.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }

    private class Source<V> implements Action1<V> {
        final Action1<V> mAction;
        final LiveData<V> mLiveData;
        private Subscription mSubscription;
        int mVersion = -1;

        Source(LiveData<V> liveData, Action1<V> action1) {
            this.mLiveData = liveData;
            this.mAction = action1;
            this.mSubscription = liveData.subscribeForever(this);
        }

        Source(LiveData<V> liveData, Action1<V> action1, ScopeContext scopeContext) {
            this.mLiveData = liveData;
            this.mAction = action1;
            this.mSubscription = liveData.subscribe(scopeContext, this);
        }

        /* access modifiers changed from: package-private */
        public void unplug() {
            this.mSubscription.unsubscribe();
        }

        public void call(V v) {
            if (this.mVersion < this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mAction.call(v);
            }
        }
    }
}
