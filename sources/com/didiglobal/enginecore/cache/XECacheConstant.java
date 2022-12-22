package com.didiglobal.enginecore.cache;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheConstant;", "", "()V", "CACHE_STORAGE_MODE_DISK", "", "CACHE_STORAGE_MODE_MEMORY", "CACHE_STRATEGY_CACHE_NETWORK", "CACHE_STRATEGY_NULL", "CACHE_STRATEGY_ONLY_CACHE", "CACHE_STRATEGY_ONLY_NETWORK", "CACHE_STRATEGY_REMOVE_CACHE", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XECacheConstant.kt */
public final class XECacheConstant {
    public static final int CACHE_STORAGE_MODE_DISK = 1;
    public static final int CACHE_STORAGE_MODE_MEMORY = 2;
    public static final int CACHE_STRATEGY_CACHE_NETWORK = 10000;
    public static final int CACHE_STRATEGY_NULL = 0;
    public static final int CACHE_STRATEGY_ONLY_CACHE = 10002;
    public static final int CACHE_STRATEGY_ONLY_NETWORK = 10001;
    public static final int CACHE_STRATEGY_REMOVE_CACHE = 10003;
    public static final XECacheConstant INSTANCE = new XECacheConstant();

    private XECacheConstant() {
    }
}
