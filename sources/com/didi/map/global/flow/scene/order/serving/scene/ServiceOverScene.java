package com.didi.map.global.flow.scene.order.serving.scene;

import android.graphics.Color;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.param.OrderTrajLineRequest;
import com.didi.map.global.component.line.pax.over.OrderTrajLineManager;
import com.didi.map.global.component.line.pax.over.OrderTrajParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.WayPointParam;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.ServiceOverParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@IScene.Scene(mo74615id = 1010)
public class ServiceOverScene extends PageScene<ServiceOverParam> implements ISceneController {
    public static final String ID_MARKER_END = "id_marker_end";
    public static final String ID_MARKER_START = "id_marker_start";
    public static final String ID_MARKER_WAYPOINT = "id_marker_waypoint";

    /* renamed from: a */
    private MarkersComponent f26926a;

    /* renamed from: b */
    private final int f26927b = 51;

    /* renamed from: c */
    private final int f26928c = 50;

    /* renamed from: d */
    private final int f26929d = 49;

    /* renamed from: e */
    private OrderTrajLineManager f26930e;

    public void onPause() {
    }

    public void onResume() {
    }

    public ServiceOverScene(ServiceOverParam serviceOverParam, MapViewHolder mapViewHolder) {
        super(serviceOverParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (getMap() != null) {
            getMap().setMaxZoomLevel(16.7f);
        }
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
        m18993a();
        m18994b();
        if (((ServiceOverParam) this.mParam).getOrderStatus() == 0) {
            PaxEnvironment.getInstance().setPage(Page.ENDS_PAGE);
        } else {
            PaxEnvironment.getInstance().setPage(Page.CANCEL_PAGE);
        }
        OrderFloatWindowManager.Instance().resetState();
    }

    /* renamed from: a */
    private void m18993a() {
        int i;
        int i2;
        OrderTrajLineRequest orderTrajLineRequest = new OrderTrajLineRequest(CallFrom.ORDERROUTEAPI_BUBBLE, PaxEnvironment.getInstance().getProductId());
        orderTrajLineRequest.biztype = ((ServiceOverParam) this.mParam).getBiztype();
        orderTrajLineRequest.driverId = ((ServiceOverParam) this.mParam).getDriverId();
        orderTrajLineRequest.startTime = ((ServiceOverParam) this.mParam).getStartTime();
        orderTrajLineRequest.endTime = ((ServiceOverParam) this.mParam).getEndTime();
        orderTrajLineRequest.clientVersion = ((ServiceOverParam) this.mParam).getClientVersion();
        orderTrajLineRequest.imei = ((ServiceOverParam) this.mParam).getImei();
        if (((ServiceOverParam) this.mParam).isNewVersion()) {
            i2 = Color.parseColor("#33BBFF");
            i = 6;
        } else {
            i2 = Color.parseColor("#262B2E");
            i = 3;
        }
        OrderTrajParam orderTrajParam = new OrderTrajParam(orderTrajLineRequest, i2, i, new OnLineDrawStatusListener() {
            public /* synthetic */ void onLineDrawStart() {
                OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
            }

            public void onLineDrawFinished() {
                ServiceOverScene serviceOverScene = ServiceOverScene.this;
                serviceOverScene.doBestView(serviceOverScene.mPadding);
            }
        });
        OrderTrajLineManager orderTrajLineManager = new OrderTrajLineManager();
        this.f26930e = orderTrajLineManager;
        orderTrajLineManager.create(getContext(), getMap(), orderTrajParam);
    }

    /* renamed from: b */
    private void m18994b() {
        if (this.mParam != null && getMap() != null) {
            ArrayList arrayList = new ArrayList();
            List<MarkerModel> startEndInfoConvertToModel = startEndInfoConvertToModel(((ServiceOverParam) this.mParam).getMarkerParams());
            if (!startEndInfoConvertToModel.isEmpty()) {
                arrayList.addAll(startEndInfoConvertToModel);
            }
            arrayList.addAll(wayPointInfoConvertToModel(((ServiceOverParam) this.mParam).getWayPointParam()));
            this.f26926a = new MarkersComponent();
            this.f26926a.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26926a.create(getContext(), getMap());
        }
    }

    public List<MarkerModel> startEndInfoConvertToModel(HashMap<MapElementId, CommonMarkerParam> hashMap) {
        if (hashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Collection<CommonMarkerParam> values = hashMap.values();
        if (!CollectionUtil.isEmpty((Collection<?>) values)) {
            for (CommonMarkerParam next : values) {
                MarkerModel markerModel = new MarkerModel();
                markerModel.setId("id_marker_start");
                markerModel.setPoint(next.getPoint());
                markerModel.setAnchorU(next.getAnchorU());
                markerModel.setAnchorV(next.getAnchorV());
                markerModel.setMarkerIcon(next.getMarkerIcon());
                markerModel.setZOrder(51);
                arrayList.add(markerModel);
            }
        }
        return arrayList;
    }

    public List<MarkerModel> wayPointInfoConvertToModel(WayPointParam wayPointParam) {
        ArrayList arrayList = new ArrayList();
        if (!(wayPointParam == null || wayPointParam.wayAddresses == null)) {
            for (int i = 0; i < wayPointParam.wayAddresses.size(); i++) {
                Address address = wayPointParam.wayAddresses.get(i);
                MarkerModel markerModel = new MarkerModel();
                markerModel.setId(ID_MARKER_WAYPOINT + i);
                markerModel.setPoint(new LatLng(address.latitude, address.longitude));
                markerModel.setAnchorU(wayPointParam.anchorU);
                markerModel.setAnchorV(wayPointParam.anchorV);
                markerModel.setZOrder(49);
                markerModel.setMarkerIcon(ImageUtil.Drawable2Bitmap(wayPointParam.wayPointIcon));
                arrayList.add(markerModel);
            }
        }
        return arrayList;
    }

    public void leave() {
        super.leave();
        if (getMap() != null) {
            getMap().setMaxZoomLevel((float) getMap().getMaxZoomLevel());
        }
        OrderTrajLineManager orderTrajLineManager = this.f26930e;
        if (orderTrajLineManager != null) {
            orderTrajLineManager.destroy();
            this.f26930e = null;
        }
        MarkersComponent markersComponent = this.f26926a;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f26926a = null;
        }
    }

    public void doBestView(Padding padding) {
        if (this.isSceneValid && getMap() != null) {
            SystemUtils.log(3, "sfs", "ServiceOverScene doBestView() padding: " + padding, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.scene.ServiceOverScene", 210);
            hideResetView();
            this.mPadding = padding;
            this.mHandler.removeCallbacksAndMessages((Object) null);
            ArrayList arrayList = new ArrayList();
            MarkersComponent markersComponent = this.f26926a;
            if (markersComponent != null) {
                arrayList.addAll(markersComponent.getMarkers());
            }
            OrderTrajLineManager orderTrajLineManager = this.f26930e;
            if (orderTrajLineManager != null && !CollectionUtil.isEmpty((Collection<?>) orderTrajLineManager.getBestViewElements())) {
                arrayList.addAll(this.f26930e.getBestViewElements());
            }
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, new Padding(DisplayUtils.dp2px(getContext(), 10.0f), 0, DisplayUtils.dp2px(getContext(), 10.0f), 0), (BestViewer.IBestViewListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void handleTrackDragMapEvent() {
        if (this.mParam != null && ((ServiceOverParam) this.mParam).getOrderId() != null) {
            ((ServiceOverParam) this.mParam).getOrderId();
        }
    }
}
