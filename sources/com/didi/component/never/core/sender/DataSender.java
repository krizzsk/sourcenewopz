package com.didi.component.never.core.sender;

public interface DataSender<R, S> {
    R getData(S s);

    void setData(R r);
}
