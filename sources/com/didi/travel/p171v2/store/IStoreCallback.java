package com.didi.travel.p171v2.store;

/* renamed from: com.didi.travel.v2.store.IStoreCallback */
public interface IStoreCallback<T> {
    public static final String DEFAULT_API_DETAIL_KEY = "NONE";

    String getStoreApiDetailKey(Object[] objArr, T t);

    boolean isValid(Object[] objArr, T t);
}
