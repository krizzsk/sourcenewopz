package com.didi.sdk.messagecenter.interfaces;

import androidx.lifecycle.LifecycleOwner;
import com.didi.sdk.messagecenter.model.PushMessage;

public interface ISubscribe {

    public interface ISubscribeWrapper {
        void handler(IHandler iHandler);

        ISubscribeWrapper subscribe(Class<? extends PushMessage> cls);
    }

    ISubscribeWrapper autoBind(LifecycleOwner lifecycleOwner);

    ISubscribeWrapper bind(Object obj);

    void release(Object obj);

    void release(Object obj, Class<? extends PushMessage> cls);
}
