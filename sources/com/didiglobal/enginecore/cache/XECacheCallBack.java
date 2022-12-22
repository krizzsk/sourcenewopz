package com.didiglobal.enginecore.cache;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheCallBack;", "T", "", "onCacheFailure", "", "onCacheSuccess", "response", "(Ljava/lang/Object;)V", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XECacheCallBack.kt */
public interface XECacheCallBack<T> {
    void onCacheFailure();

    void onCacheSuccess(T t);
}
