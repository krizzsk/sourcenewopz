package com.didi.sdk.messagecenter.interfaces;

import com.didi.sdk.messagecenter.model.PushMessage;

public interface IHandler<T extends PushMessage> {
    void handle(T t);
}
