package com.p224kt.didichuxing.didi_network.net;

/* renamed from: com.kt.didichuxing.didi_network.net.ResponseListener */
public interface ResponseListener<T> {
    void onReceiveError(String str);

    void onReceiveResponse(T t);
}
