package com.didi.map.global.component.line.pax.commonline;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.RouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/commonline/CommonLineManager;", "", "context", "Landroid/content/Context;", "map", "Lcom/didi/common/map/Map;", "lineParam", "Lcom/didi/map/global/component/line/pax/commonline/CommonLineParam;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/component/line/pax/commonline/CommonLineParam;)V", "TAG", "", "lineRoute", "Lcom/didi/map/global/component/line/data/route/BaseLineRoute;", "mCallback", "Lcom/didi/map/global/component/line/component/OnLineDrawStatusListener;", "mContext", "mLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "mLineParam", "mListener", "Lcom/didi/map/global/component/line/component/OnLineClickListener;", "mMap", "create", "", "destroy", "getBestViewElements", "", "Lcom/didi/common/map/internal/IMapElement;", "getRoutePlanRequest", "Lcom/didi/map/global/component/line/data/param/RouteLineRequest;", "setLineClickListener", "onLineClickListener", "setLineVisible", "visible", "", "setListener", "callback", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonLineManager.kt */
public final class CommonLineManager {

    /* renamed from: a */
    private final String f25840a = "CommonLineManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f25841b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f25842c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CommonLineParam f25843d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnLineDrawStatusListener f25844e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnLineClickListener f25845f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ICompLineContract f25846g;

    /* renamed from: h */
    private BaseLineRoute<?> f25847h;

    public CommonLineManager(Context context, Map map, CommonLineParam commonLineParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(commonLineParam, "lineParam");
        this.f25841b = context;
        this.f25842c = map;
        this.f25843d = commonLineParam;
    }

    public final void create() {
        CommonLineParam commonLineParam;
        LineParams lineParams;
        if (this.f25841b == null || this.f25842c == null || (commonLineParam = this.f25843d) == null) {
            DLog.m7384d(this.f25840a, "基础参数为空", new Object[0]);
            return;
        }
        CallFrom callFrom = null;
        if (commonLineParam == null) {
            lineParams = null;
        } else {
            lineParams = commonLineParam.getLineParam();
        }
        if (lineParams != null) {
            CommonLineParam commonLineParam2 = this.f25843d;
            if ((commonLineParam2 == null ? null : commonLineParam2.getStartPos()) != null) {
                CommonLineParam commonLineParam3 = this.f25843d;
                if ((commonLineParam3 == null ? null : commonLineParam3.getEndPos()) != null) {
                    CommonLineParam commonLineParam4 = this.f25843d;
                    if (commonLineParam4 != null) {
                        callFrom = commonLineParam4.getCaller();
                    }
                    if (callFrom != null) {
                        BaseLineRoute<?> createLineRoute = LineDataFactory.createLineRoute(this.f25841b, LineDataFactory.LineDataType.ROUTE_PLAN);
                        this.f25847h = createLineRoute;
                        if (createLineRoute != null) {
                            createLineRoute.start(m18392a(), new CommonLineManager$create$1(this));
                            return;
                        }
                        return;
                    }
                }
            }
        }
        DLog.m7384d(this.f25840a, "其他划线参数为空", new Object[0]);
    }

    /* renamed from: a */
    private final RouteLineRequest m18392a() {
        CommonLineParam commonLineParam = this.f25843d;
        List<LatLng> list = null;
        if (commonLineParam != null) {
            if ((commonLineParam == null ? null : commonLineParam.getLineParam()) != null) {
                CommonLineParam commonLineParam2 = this.f25843d;
                if ((commonLineParam2 == null ? null : commonLineParam2.getStartPos()) != null) {
                    CommonLineParam commonLineParam3 = this.f25843d;
                    if ((commonLineParam3 == null ? null : commonLineParam3.getEndPos()) != null) {
                        CommonLineParam commonLineParam4 = this.f25843d;
                        if ((commonLineParam4 == null ? null : commonLineParam4.getCaller()) != null) {
                            CommonLineParam commonLineParam5 = this.f25843d;
                            CallFrom caller = commonLineParam5 == null ? null : commonLineParam5.getCaller();
                            String productId = PaxEnvironment.getInstance().getProductId();
                            CommonLineParam commonLineParam6 = this.f25843d;
                            LatLng startPos = commonLineParam6 == null ? null : commonLineParam6.getStartPos();
                            CommonLineParam commonLineParam7 = this.f25843d;
                            RouteLineRequest routeLineRequest = new RouteLineRequest(caller, productId, startPos, commonLineParam7 == null ? null : commonLineParam7.getEndPos(), TravelMode.DRIVING);
                            CommonLineParam commonLineParam8 = this.f25843d;
                            if ((commonLineParam8 == null ? null : commonLineParam8.getWayPoints()) != null) {
                                CommonLineParam commonLineParam9 = this.f25843d;
                                if (!CollectionUtil.isEmpty((Collection<?>) commonLineParam9 == null ? null : commonLineParam9.getWayPoints())) {
                                    CommonLineParam commonLineParam10 = this.f25843d;
                                    if (commonLineParam10 != null) {
                                        list = commonLineParam10.getWayPoints();
                                    }
                                    routeLineRequest.setWayPoint(list);
                                }
                            }
                            return routeLineRequest;
                        }
                    }
                }
            }
        }
        DLog.m7384d(this.f25840a, "请求路线需要的参数为空", new Object[0]);
        return null;
    }

    public final void destroy() {
        this.f25844e = null;
        this.f25845f = null;
        BaseLineRoute<?> baseLineRoute = this.f25847h;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
        }
        this.f25847h = null;
        ICompLineContract iCompLineContract = this.f25846g;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f25846g = null;
    }

    public final void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f25846g;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    public final List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f25846g;
        if (iCompLineContract == null) {
            return null;
        }
        return iCompLineContract.getBestViewElements();
    }

    public final void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25844e = onLineDrawStatusListener;
    }

    public final void setLineClickListener(OnLineClickListener onLineClickListener) {
        this.f25845f = onLineClickListener;
    }
}
