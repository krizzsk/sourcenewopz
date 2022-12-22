package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.map.global.flow.scene.order.serving.param.OrderParams;

public class MiniBusGuideComponentParam {

    /* renamed from: a */
    private OrderParams f26406a;

    /* renamed from: b */
    private MiniBusStreetParam f26407b;

    public OrderParams getOrderParams() {
        return this.f26406a;
    }

    public void setOrderParams(OrderParams orderParams) {
        this.f26406a = orderParams;
    }

    public void setStreetParam(MiniBusStreetParam miniBusStreetParam) {
        this.f26407b = miniBusStreetParam;
    }

    public MiniBusStreetParam getStreetParam() {
        return this.f26407b;
    }
}
