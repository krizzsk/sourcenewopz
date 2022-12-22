package com.didichuxing.routesearchsdk.multi;

import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

public class MultiRouteSearchParam {

    /* renamed from: a */
    private String f48549a;

    /* renamed from: b */
    private String f48550b;

    /* renamed from: c */
    private String f48551c;

    /* renamed from: d */
    private String f48552d;

    /* renamed from: e */
    private long f48553e;

    /* renamed from: f */
    private CallFrom f48554f;

    /* renamed from: g */
    private int f48555g;

    /* renamed from: h */
    private String f48556h;

    /* renamed from: i */
    private String f48557i;

    /* renamed from: j */
    private List<SingleRouteReqParam> f48558j;

    public long getPassengerId() {
        return this.f48553e;
    }

    public String getToken() {
        return this.f48549a;
    }

    public String getPhoneNum() {
        return this.f48550b;
    }

    public String getCountryId() {
        return this.f48551c;
    }

    public String getProductId() {
        return this.f48552d;
    }

    public CallFrom getCaller() {
        return this.f48554f;
    }

    public int getOrderStage() {
        return this.f48555g;
    }

    public String getDidiVersion() {
        return this.f48556h;
    }

    public String getOrderId() {
        return this.f48557i;
    }

    public List<SingleRouteReqParam> getRouteReq() {
        return this.f48558j;
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, List<SingleRouteReqParam> list) {
        this(str, str2, str3, str4, j, callFrom, 0, (String) null, (String) null, list);
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, String str5, List<SingleRouteReqParam> list) {
        this(str, str2, str3, str4, j, callFrom, 0, (String) null, str5, list);
    }

    public MultiRouteSearchParam(String str, String str2, String str3, String str4, long j, CallFrom callFrom, int i, String str5, String str6, List<SingleRouteReqParam> list) {
        this.f48549a = str;
        this.f48550b = str2;
        this.f48551c = str3;
        this.f48552d = str4;
        this.f48554f = callFrom;
        this.f48558j = list;
        this.f48553e = j;
        this.f48555g = i;
        this.f48556h = str5;
        this.f48557i = str6;
    }
}
