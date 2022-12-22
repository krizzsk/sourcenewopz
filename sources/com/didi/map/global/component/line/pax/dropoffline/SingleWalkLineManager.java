package com.didi.map.global.component.line.pax.dropoffline;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0015J \u0010\u001c\u001a\u00020\u00152\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLineManager;", "", "context", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "lineParam", "Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLineParam;", "callback", "Lcom/didi/map/global/component/line/pax/dropoffline/WalkLineCallback;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLineParam;Lcom/didi/map/global/component/line/pax/dropoffline/WalkLineCallback;)V", "TAG", "", "destroyed", "", "mContext", "mLineRouteRequest", "Lcom/didi/map/global/component/line/data/route/BaseLineRoute;", "mWalkingLine", "Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLine;", "destroy", "", "getMapElements", "", "Lcom/didi/common/map/internal/IMapElement;", "getMultiRouteLineRequest", "Lcom/didi/map/global/component/line/data/param/MultiRouteLineRequest;", "requestLine", "showWalkingLine", "list", "", "Lcom/didi/common/map/model/LatLng;", "style", "", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleWalkLineManager.kt */
public final class SingleWalkLineManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f25859a = "WalkLineManager";

    /* renamed from: b */
    private Map f25860b;

    /* renamed from: c */
    private Context f25861c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalkLineCallback f25862d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SingleWalkLineParam f25863e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f25864f;

    /* renamed from: g */
    private SingleWalkLine f25865g;

    /* renamed from: h */
    private BaseLineRoute<?> f25866h;

    public SingleWalkLineManager(Context context, Map map, SingleWalkLineParam singleWalkLineParam, WalkLineCallback walkLineCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "mMap");
        Intrinsics.checkNotNullParameter(singleWalkLineParam, "lineParam");
        Intrinsics.checkNotNullParameter(walkLineCallback, "callback");
        this.f25860b = map;
        this.f25861c = context;
        this.f25862d = walkLineCallback;
        this.f25863e = singleWalkLineParam;
    }

    public final void requestLine() {
        SingleWalkLineParam singleWalkLineParam = this.f25863e;
        if (singleWalkLineParam == null) {
            DLog.m7384d(this.f25859a, Intrinsics.stringPlus("lineParam = ", singleWalkLineParam), new Object[0]);
        }
        BaseLineRoute<?> createLineRoute = LineDataFactory.createLineRoute(this.f25861c, LineDataFactory.LineDataType.ROUTE_MULTI_PLAN);
        this.f25866h = createLineRoute;
        if (createLineRoute != null) {
            createLineRoute.start(m18393a(), new SingleWalkLineManager$requestLine$1(this));
        }
    }

    /* renamed from: a */
    private final MultiRouteLineRequest m18393a() {
        MultiRouteLineRequest multiRouteLineRequest = new MultiRouteLineRequest(this.f25863e.getCaller(), PaxEnvironment.getInstance().getProductId());
        ArrayList arrayList = new ArrayList();
        if (!(this.f25863e.getStartPos() == null || this.f25863e.getEndPos() == null)) {
            DoublePoint.Builder builder = new DoublePoint.Builder();
            LatLng startPos = this.f25863e.getStartPos();
            Intrinsics.checkNotNull(startPos);
            DoublePoint.Builder lat = builder.lat(Float.valueOf((float) startPos.latitude));
            LatLng startPos2 = this.f25863e.getStartPos();
            Intrinsics.checkNotNull(startPos2);
            DoublePoint.Builder lng = lat.lng(Float.valueOf((float) startPos2.longitude));
            LatLng startPos3 = this.f25863e.getStartPos();
            Intrinsics.checkNotNull(startPos3);
            DoublePoint.Builder dlat = lng.dlat(Double.valueOf(startPos3.latitude));
            LatLng startPos4 = this.f25863e.getStartPos();
            Intrinsics.checkNotNull(startPos4);
            DoublePoint build = dlat.dlng(Double.valueOf(startPos4.longitude)).build();
            DoublePoint.Builder builder2 = new DoublePoint.Builder();
            LatLng endPos = this.f25863e.getEndPos();
            Intrinsics.checkNotNull(endPos);
            DoublePoint.Builder lat2 = builder2.lat(Float.valueOf((float) endPos.latitude));
            LatLng endPos2 = this.f25863e.getEndPos();
            Intrinsics.checkNotNull(endPos2);
            DoublePoint.Builder lng2 = lat2.lng(Float.valueOf((float) endPos2.longitude));
            LatLng endPos3 = this.f25863e.getEndPos();
            Intrinsics.checkNotNull(endPos3);
            DoublePoint.Builder dlat2 = lng2.dlat(Double.valueOf(endPos3.latitude));
            LatLng endPos4 = this.f25863e.getEndPos();
            Intrinsics.checkNotNull(endPos4);
            arrayList.add(new SingleRouteReqParam(build, dlat2.dlng(Double.valueOf(endPos4.longitude)).build(), (List<OdPoint>) null, TravelMode.WALKING, 1));
        }
        multiRouteLineRequest.setLineParams(arrayList);
        return multiRouteLineRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18394a(List<LatLng> list, int i) {
        DLog.m7384d(this.f25859a, Intrinsics.stringPlus("showWalkingLine  style=", Integer.valueOf(i)), new Object[0]);
        SingleWalkLine singleWalkLine = this.f25865g;
        if (singleWalkLine != null) {
            singleWalkLine.destroy();
        }
        if (this.f25861c == null || this.f25860b == null) {
            DLog.m7384d(this.f25859a, "context || map == null", new Object[0]);
        } else if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m7384d(this.f25859a, "showWalkingLine error list isEmpty ", new Object[0]);
        } else if (i != 0) {
            if (i == 2 && list != null) {
                Context context = this.f25861c;
                Intrinsics.checkNotNull(context);
                Map map = this.f25860b;
                Intrinsics.checkNotNull(map);
                SingleWalkLine singleWalkLine2 = new SingleWalkLine(context, map);
                this.f25865g = singleWalkLine2;
                if (singleWalkLine2 != null) {
                    singleWalkLine2.createA(list, this.f25863e.getLineAWidth(), this.f25863e.getLineASpace(), this.f25863e.getLineAColor());
                }
            }
        } else if (list != null) {
            Context context2 = this.f25861c;
            Intrinsics.checkNotNull(context2);
            Map map2 = this.f25860b;
            Intrinsics.checkNotNull(map2);
            SingleWalkLine singleWalkLine3 = new SingleWalkLine(context2, map2);
            this.f25865g = singleWalkLine3;
            if (singleWalkLine3 != null) {
                singleWalkLine3.createB(list, this.f25863e.getLineBSpace());
            }
        }
    }

    public final List<IMapElement> getMapElements() {
        SingleWalkLine singleWalkLine = this.f25865g;
        if (singleWalkLine == null) {
            return null;
        }
        return singleWalkLine.getWalkLineElemets();
    }

    public final void destroy() {
        this.f25864f = true;
        this.f25862d = null;
        SingleWalkLine singleWalkLine = this.f25865g;
        if (singleWalkLine != null) {
            singleWalkLine.destroy();
        }
        this.f25865g = null;
        BaseLineRoute<?> baseLineRoute = this.f25866h;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
        }
        this.f25866h = null;
        this.f25861c = null;
        this.f25860b = null;
    }
}
