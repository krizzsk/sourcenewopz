package com.didichuxing.xpanel.agent.net;

import com.didichuxing.xpanel.agent.net.BaseObject;

public class ResponseListener<T extends BaseObject> {
    public void onError(T t) {
    }

    public void onFail(T t) {
    }

    public void onFinish(T t) {
    }

    public void onSuccess(T t) {
    }
}
