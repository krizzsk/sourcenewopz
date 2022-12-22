package com.didi.map.global.component.line.pax.over;

import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.param.OrderTrajLineRequest;

public class OrderTrajParam {

    /* renamed from: a */
    private OrderTrajLineRequest f25883a;

    /* renamed from: b */
    private int f25884b;

    /* renamed from: c */
    private int f25885c;

    /* renamed from: d */
    private OnLineDrawStatusListener f25886d;

    public OrderTrajParam(OrderTrajLineRequest orderTrajLineRequest, int i, int i2, OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25883a = orderTrajLineRequest;
        this.f25884b = i;
        this.f25885c = i2;
        this.f25886d = onLineDrawStatusListener;
    }

    public OrderTrajLineRequest getRequest() {
        return this.f25883a;
    }

    public int getLineColor() {
        return this.f25884b;
    }

    public int getLineWidth() {
        return this.f25885c;
    }

    public OnLineDrawStatusListener getLineDrawStatusListener() {
        return this.f25886d;
    }
}
