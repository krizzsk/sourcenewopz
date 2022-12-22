package com.p224kt.didichuxing.didi_network_entrega.net;

/* renamed from: com.kt.didichuxing.didi_network_entrega.net.ResponseListener */
public interface ResponseListener<T> {
    void onReceiveError(String str);

    void onReceiveResponse(T t);
}
