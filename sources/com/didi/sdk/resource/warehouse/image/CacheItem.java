package com.didi.sdk.resource.warehouse.image;

import java.lang.ref.WeakReference;

public final class CacheItem {

    /* renamed from: a */
    private final long f37101a;

    /* renamed from: b */
    private final String f37102b;

    /* renamed from: c */
    private final PriorityType f37103c;

    /* renamed from: d */
    private final WeakReference<ICacheProvider> f37104d;

    /* renamed from: e */
    private final WeakReference<IRetryStrategy> f37105e;

    public CacheItem(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        this.f37101a = j;
        this.f37102b = str;
        this.f37103c = priorityType;
        this.f37104d = new WeakReference<>(iCacheProvider);
        this.f37105e = new WeakReference<>(iRetryStrategy);
    }

    public long getResId() {
        return this.f37101a;
    }

    public String getUrl() {
        return this.f37102b;
    }

    public PriorityType getPriorityType() {
        return this.f37103c;
    }

    public ICacheProvider getCacheProvider() {
        return (ICacheProvider) this.f37104d.get();
    }

    public IRetryStrategy getRetryStrategy() {
        return (IRetryStrategy) this.f37105e.get();
    }
}
