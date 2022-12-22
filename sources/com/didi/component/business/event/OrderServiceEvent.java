package com.didi.component.business.event;

public class OrderServiceEvent {
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_FAIL = 1;
    public static final int RESULT_SUCCESS = 0;

    /* renamed from: a */
    private int f11304a;

    /* renamed from: b */
    private Object f11305b;

    public OrderServiceEvent() {
    }

    public OrderServiceEvent(int i, Object obj) {
        this.f11304a = i;
        this.f11305b = obj;
    }

    public int getEventFlag() {
        return this.f11304a;
    }

    public void setEventFlag(int i) {
        this.f11304a = i;
    }

    public Object getEventResult() {
        return this.f11305b;
    }

    public void setEventResult(Object obj) {
        this.f11305b = obj;
    }
}
