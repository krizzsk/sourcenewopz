package com.didi.security.wireless;

public interface ISecurityConf {
    public static final String ALLOW = "allow";
    public static final String KEY_SENSOR = "sensor";

    void addConfig(String str, String str2);

    @Deprecated
    int cacheCapacity();

    @Deprecated
    long cacheExpire();

    String getConfig(String str);

    boolean isAllow(String str);

    @Deprecated
    boolean isCacheOn();

    boolean isPriorityOn();

    boolean isTouchOn();

    int touchCapacity();
}
