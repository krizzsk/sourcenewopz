package com.didi.sdk.messagecenter.interfaces;

import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;

public interface IStore {
    void add(Object obj, Subscription subscription);

    @Deprecated
    boolean isSubscribed(Object obj);

    boolean remove(Object obj);

    boolean removeMessage(Object obj, Class<? extends PushMessage> cls);
}
