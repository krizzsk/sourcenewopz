package com.didi.map.sdk.sharetrack.delegate;

public interface IEventHandler<T> {
    boolean dispatchEvent(T t);

    boolean onInterceptEvent(T t);
}
