package com.didi.entrega.customer.foundation.map.location;

public interface LocationCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t);
}
