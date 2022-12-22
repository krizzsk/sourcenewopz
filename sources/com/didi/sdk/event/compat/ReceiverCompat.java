package com.didi.sdk.event.compat;

public interface ReceiverCompat<K, V> {
    void onReceive(K k, V v);
}
