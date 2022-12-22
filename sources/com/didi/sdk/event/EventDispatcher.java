package com.didi.sdk.event;

public class EventDispatcher {

    /* renamed from: a */
    private EventDispatcherImpl f35840a = new EventDispatcherImpl();

    protected EventDispatcher() {
    }

    public void register(Object obj) {
        this.f35840a.mo91598a(obj);
    }

    public void register(Object obj, int i) {
        this.f35840a.mo91599a(obj, i);
    }

    public boolean isRegistered(Object obj) {
        return this.f35840a.mo91606c(obj);
    }

    public void unregister(Object obj) {
        this.f35840a.mo91607d(obj);
    }

    public void post(Event event) {
        this.f35840a.mo91595a(event);
    }
}
