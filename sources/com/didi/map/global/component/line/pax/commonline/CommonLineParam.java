package com.didi.map.global.component.line.pax.commonline;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.line.component.LineParams;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/commonline/CommonLineParam;", "", "()V", "caller", "Lcom/didichuxing/routesearchsdk/CallFrom;", "getCaller", "()Lcom/didichuxing/routesearchsdk/CallFrom;", "setCaller", "(Lcom/didichuxing/routesearchsdk/CallFrom;)V", "endPos", "Lcom/didi/common/map/model/LatLng;", "getEndPos", "()Lcom/didi/common/map/model/LatLng;", "setEndPos", "(Lcom/didi/common/map/model/LatLng;)V", "lineParam", "Lcom/didi/map/global/component/line/component/LineParams;", "getLineParam", "()Lcom/didi/map/global/component/line/component/LineParams;", "setLineParam", "(Lcom/didi/map/global/component/line/component/LineParams;)V", "startPos", "getStartPos", "setStartPos", "wayPoints", "", "getWayPoints", "()Ljava/util/List;", "setWayPoints", "(Ljava/util/List;)V", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonLineParam.kt */
public final class CommonLineParam {

    /* renamed from: a */
    private LineParams f25848a;

    /* renamed from: b */
    private LatLng f25849b;

    /* renamed from: c */
    private LatLng f25850c;

    /* renamed from: d */
    private List<LatLng> f25851d;

    /* renamed from: e */
    private CallFrom f25852e;

    public final LineParams getLineParam() {
        return this.f25848a;
    }

    public final void setLineParam(LineParams lineParams) {
        this.f25848a = lineParams;
    }

    public final LatLng getStartPos() {
        return this.f25849b;
    }

    public final void setStartPos(LatLng latLng) {
        this.f25849b = latLng;
    }

    public final LatLng getEndPos() {
        return this.f25850c;
    }

    public final void setEndPos(LatLng latLng) {
        this.f25850c = latLng;
    }

    public final List<LatLng> getWayPoints() {
        return this.f25851d;
    }

    public final void setWayPoints(List<LatLng> list) {
        this.f25851d = list;
    }

    public final CallFrom getCaller() {
        return this.f25852e;
    }

    public final void setCaller(CallFrom callFrom) {
        this.f25852e = callFrom;
    }
}
