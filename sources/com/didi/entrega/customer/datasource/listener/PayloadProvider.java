package com.didi.entrega.customer.datasource.listener;

public interface PayloadProvider<Payload> {
    Payload providePayload();
}
