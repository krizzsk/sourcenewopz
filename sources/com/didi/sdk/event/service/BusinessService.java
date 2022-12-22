package com.didi.sdk.event.service;

public interface BusinessService<Input, Output> {
    <I extends Input> Output businessDo(I i) throws Exception;
}
