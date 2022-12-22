package com.didi.sdk.resource.warehouse.image;

public interface ICacheProvider {
    public static final String PROVIDER_KEY_FRESCO = "Fresco";
    public static final String PROVIDER_KEY_GLIDE = "Glide";

    void cache(String str, PriorityType priorityType, IRetryStrategy iRetryStrategy);

    String getProviderKey();

    boolean hasCache(String str);
}
