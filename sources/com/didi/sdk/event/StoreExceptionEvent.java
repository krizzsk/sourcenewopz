package com.didi.sdk.event;

public final class StoreExceptionEvent implements Event {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventDispatcherImpl eventDispatcherImpl;
    public final Throwable throwable;

    public StoreExceptionEvent(EventDispatcherImpl eventDispatcherImpl2, Throwable th, Object obj, Object obj2) {
        this.eventDispatcherImpl = eventDispatcherImpl2;
        this.throwable = th;
        this.causingEvent = obj;
        this.causingSubscriber = obj2;
    }
}
