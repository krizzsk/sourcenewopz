package com.didi.soda.datasource.listener;

public interface PayloadProvider<Payload> {
    Payload providePayload();
}
