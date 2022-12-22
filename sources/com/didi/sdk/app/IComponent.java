package com.didi.sdk.app;

import com.didi.sdk.app.BaseBusinessContext;

public interface IComponent<T extends BaseBusinessContext> {
    T getBusinessContext();

    void setBusinessContext(T t);
}
