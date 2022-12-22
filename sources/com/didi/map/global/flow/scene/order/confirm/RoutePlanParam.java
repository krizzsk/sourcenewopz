package com.didi.map.global.flow.scene.order.confirm;

import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;

public class RoutePlanParam {

    /* renamed from: a */
    private LineMode f26577a;

    /* renamed from: b */
    private EpfOrderType f26578b;

    /* renamed from: c */
    private String f26579c;

    /* renamed from: d */
    private CommonLineParam f26580d;

    public LineMode getLineMode() {
        return this.f26577a;
    }

    public void setLineMode(LineMode lineMode) {
        this.f26577a = lineMode;
    }

    public EpfOrderType getOrderType() {
        return this.f26578b;
    }

    public void setOrderType(EpfOrderType epfOrderType) {
        this.f26578b = epfOrderType;
    }

    public String getBubbleId() {
        return this.f26579c;
    }

    public void setBubbleId(String str) {
        this.f26579c = str;
    }

    public CommonLineParam getLineParam() {
        return this.f26580d;
    }

    public void setLineParam(CommonLineParam commonLineParam) {
        this.f26580d = commonLineParam;
    }

    public String toString() {
        return "RoutePlanParam{lineMode=" + this.f26577a + ", orderType=" + this.f26578b + ", bubbleId='" + this.f26579c + '\'' + ", lineParam=" + this.f26580d + '}';
    }
}
