package com.didi.map.global.component.line.pax.over;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.BaseLineRequest;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.line.utils.LineDataConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderTrajLineManager {

    /* renamed from: a */
    private static final String f25874a = "OrderTrajServiceManager";

    /* renamed from: b */
    private Context f25875b;

    /* renamed from: c */
    private Map f25876c;

    /* renamed from: d */
    private ICompLineContract f25877d;

    /* renamed from: e */
    private BaseLineRoute f25878e;

    /* renamed from: f */
    private BaseLineRequest f25879f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnLineDrawStatusListener f25880g;

    /* renamed from: h */
    private int f25881h;

    /* renamed from: i */
    private int f25882i;

    public void create(Context context, Map map, OrderTrajParam orderTrajParam) {
        this.f25875b = context;
        this.f25876c = map;
        if (orderTrajParam != null) {
            this.f25881h = orderTrajParam.getLineColor();
            this.f25882i = orderTrajParam.getLineWidth();
            this.f25879f = orderTrajParam.getRequest();
            this.f25880g = orderTrajParam.getLineDrawStatusListener();
            this.f25878e = LineDataFactory.createLineRoute(this.f25875b, LineDataFactory.LineDataType.ROUTE_TRAJ);
            start();
        }
    }

    public void start() {
        if (this.f25878e != null && this.f25879f != null) {
            OnLineDrawStatusListener onLineDrawStatusListener = this.f25880g;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawStart();
            }
            this.f25878e.start(this.f25879f, new IRouteSearchResultCallback() {
                public void onGetRouteResultError(String str) {
                }

                public void onGetRouteResult(LineDataResponse lineDataResponse) {
                    if (lineDataResponse != null && lineDataResponse.getOrderTrajResponse() != null && !CollectionUtil.isEmpty((Collection<?>) lineDataResponse.getOrderTrajResponse().trajs)) {
                        OrderTrajLineManager.this.m18397a(LineDataConverter.getLatLngListFromDiffGeoPoints(lineDataResponse.getOrderTrajResponse().trajs.get(0)));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18397a(List<LatLng> list) {
        LineParams lineParams = new LineParams(list, this.f25881h, this.f25882i);
        ICompLineContract iCompLineContract = this.f25877d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25877d = null;
        }
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f25876c, this.f25875b, lineParams);
        this.f25877d = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setListener(new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    if (OrderTrajLineManager.this.f25880g != null) {
                        OrderTrajLineManager.this.f25880g.onLineDrawFinished();
                    }
                }
            });
            this.f25877d.start();
        }
    }

    public void destroy() {
        ICompLineContract iCompLineContract = this.f25877d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25877d = null;
        }
        BaseLineRoute baseLineRoute = this.f25878e;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f25878e = null;
        }
        this.f25875b = null;
        this.f25876c = null;
    }

    public ICompLineContract getLine() {
        return this.f25877d;
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f25877d;
        if (iCompLineContract == null || CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
            return new ArrayList();
        }
        return this.f25877d.getBestViewElements();
    }
}
