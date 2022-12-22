package com.didi.map.global.component.line.data.param;

import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.OrderTrajResponse;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;

public class LineDataResponse {

    /* renamed from: a */
    private RoutePlanRes f25804a;

    /* renamed from: b */
    private MultiRoutePlanRes f25805b;

    /* renamed from: c */
    private OrderTrajResponse f25806c;

    /* renamed from: d */
    private BubblePageRes f25807d;

    public BubblePageRes getBubblePageRes() {
        return this.f25807d;
    }

    public void setBubblePageRes(BubblePageRes bubblePageRes) {
        this.f25807d = bubblePageRes;
    }

    public RoutePlanRes getRoutePlanRes() {
        return this.f25804a;
    }

    public void setRoutePlanRes(RoutePlanRes routePlanRes) {
        this.f25804a = routePlanRes;
    }

    public MultiRoutePlanRes getMultiRoutePlanRes() {
        return this.f25805b;
    }

    public void setMultiRoutePlanRes(MultiRoutePlanRes multiRoutePlanRes) {
        this.f25805b = multiRoutePlanRes;
    }

    public OrderTrajResponse getOrderTrajResponse() {
        return this.f25806c;
    }

    public void setOrderTrajResponse(OrderTrajResponse orderTrajResponse) {
        this.f25806c = orderTrajResponse;
    }
}
