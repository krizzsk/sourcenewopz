package com.didi.map.global.component.line.data.param;

import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.List;

public class MultiRouteLineRequest extends BaseLineRequest {

    /* renamed from: a */
    private List<SingleRouteReqParam> f25808a;

    /* renamed from: b */
    private int f25809b;

    /* renamed from: c */
    private String f25810c;

    /* renamed from: d */
    private String f25811d;

    public MultiRouteLineRequest(CallFrom callFrom, String str) {
        super(callFrom, str);
    }

    public String getOrderId() {
        return this.f25811d;
    }

    public void setOrderId(String str) {
        this.f25811d = str;
    }

    public int getOrderStage() {
        return this.f25809b;
    }

    public void setOrderStage(int i) {
        this.f25809b = i;
    }

    public String getDidiVersion() {
        return this.f25810c;
    }

    public void setDidiVersion(String str) {
        this.f25810c = str;
    }

    public List<SingleRouteReqParam> getLineParams() {
        return this.f25808a;
    }

    public void setLineParams(List<SingleRouteReqParam> list) {
        this.f25808a = list;
    }
}
