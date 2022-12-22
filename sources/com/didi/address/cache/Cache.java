package com.didi.address.cache;

import com.sdk.poibase.model.recsug.RpcRecSug;

public interface Cache<T> {
    CacheData<T> getRecSugCache(String str);

    void removeRecSugCache(String str);

    void storeRecSugCache(String str, RpcRecSug rpcRecSug);
}
