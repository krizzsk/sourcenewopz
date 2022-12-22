package com.didi.map.global.component.line.data.param;

import com.didichuxing.routesearchsdk.CallFrom;

public class BaseLineRequest {

    /* renamed from: a */
    private String f25794a;

    /* renamed from: b */
    private CallFrom f25795b;

    public BaseLineRequest(CallFrom callFrom, String str) {
        this.f25795b = callFrom;
        this.f25794a = str;
    }

    public String getProductId() {
        return this.f25794a;
    }

    public void setProductId(String str) {
        this.f25794a = str;
    }

    public CallFrom getCallFrom() {
        return this.f25795b;
    }

    public void setCallFrom(CallFrom callFrom) {
        this.f25795b = callFrom;
    }
}
