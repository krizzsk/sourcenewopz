package com.didi.soda.customer.foundation.map.location;

public interface LocationCallback<T> {
    void onFail(Exception exc);

    void onSuccess(T t);
}
