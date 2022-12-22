package com.didi.map.global.flow.scene.order.waiting.p123v2;

import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingCarParam */
public class WaitingCarParam {

    /* renamed from: a */
    private int f26975a;

    /* renamed from: b */
    private ICarPositionFlushCallback f26976b;

    /* renamed from: c */
    private CarNavigatorRequest f26977c;

    public WaitingCarParam(int i, CarNavigatorRequest carNavigatorRequest) {
        this.f26975a = i;
        this.f26977c = carNavigatorRequest;
    }

    public int getPullIntervalMs() {
        return this.f26975a;
    }

    public void setPullIntervalMs(int i) {
        this.f26975a = i;
    }

    public ICarPositionFlushCallback getCarPositionFlushCallback() {
        return this.f26976b;
    }

    public void setCarPositionFlushCallback(ICarPositionFlushCallback iCarPositionFlushCallback) {
        this.f26976b = iCarPositionFlushCallback;
    }

    public CarNavigatorRequest getCarNavigatorRequest() {
        return this.f26977c;
    }

    public void setCarNavigatorRequest(CarNavigatorRequest carNavigatorRequest) {
        this.f26977c = carNavigatorRequest;
    }
}
