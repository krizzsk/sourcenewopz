package com.didi.payment.base.net;

public interface HttpCallback {
    void onFailure(HttpError httpError);

    void onSuccess(Object obj);
}
