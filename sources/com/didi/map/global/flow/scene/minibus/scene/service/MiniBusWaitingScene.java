package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.minibus.component.MiniBusGuideEntranceComponent;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavConfirmDialog;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavErrorHintDialog;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 3003)
public class MiniBusWaitingScene extends BaseMiniBusSctxScene {

    /* renamed from: a */
    private static final String f26416a = "MiniBusWaitingScene";

    /* renamed from: b */
    private boolean f26417b = MapFlowApolloUtils.isQuickenOraRequestIntervalNearPickup();

    /* renamed from: c */
    private int f26418c = MapFlowApolloUtils.getOraRequestDistanceNearPickup();

    /* renamed from: d */
    private long f26419d = MapFlowApolloUtils.getOraRequestIntervalNearPickup();

    /* renamed from: e */
    private JumpNavConfirmDialog f26420e;

    /* renamed from: f */
    private JumpNavErrorHintDialog f26421f;

    /* renamed from: g */
    private MiniBusGuideEntranceComponent f26422g;
    protected long pickupSctxIntervalMillis = MapFlowApolloUtils.getPickupSctxIntervalMillis();

    /* access modifiers changed from: protected */
    public int getOrderStage() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public boolean showWayPoints() {
        return true;
    }

    public MiniBusWaitingScene(MiniBusSctxSceneParam miniBusSctxSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusSctxSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        enterSctxService();
        if (this.mParam != null && ((MiniBusSctxSceneParam) this.mParam).getParamInterface() != null) {
            MiniBusGuideComponentParam miniBusGuideComponentParam = new MiniBusGuideComponentParam();
            miniBusGuideComponentParam.setOrderParams(((MiniBusSctxSceneParam) this.mParam).getParamInterface().getOrderParams());
            miniBusGuideComponentParam.setStreetParam(((MiniBusSctxSceneParam) this.mParam).getParamInterface().getStreetParam());
            MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = new MiniBusGuideEntranceComponent(getMap(), ((MiniBusSctxSceneParam) this.mParam).getContext(), miniBusGuideComponentParam);
            this.f26422g = miniBusGuideEntranceComponent;
            miniBusGuideEntranceComponent.setSceneValid(true);
            DLog.m7384d(f26416a, "小巴街景已经创建，创建参数如下：", new Object[0]);
            DLog.m7384d(f26416a, ((MiniBusSctxSceneParam) this.mParam).getParamInterface().getStreetParam().toString(), new Object[0]);
        }
    }

    public void leave() {
        super.leave();
        MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = this.f26422g;
        if (miniBusGuideEntranceComponent != null) {
            miniBusGuideEntranceComponent.setSceneValid(false);
            this.f26422g.destroy();
            this.f26422g = null;
        }
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f26420e;
        if (jumpNavConfirmDialog != null) {
            if (jumpNavConfirmDialog.isShowing()) {
                this.f26420e.dismiss();
            }
            this.f26420e = null;
        }
        JumpNavErrorHintDialog jumpNavErrorHintDialog = this.f26421f;
        if (jumpNavErrorHintDialog != null) {
            if (jumpNavErrorHintDialog.isShowing()) {
                this.f26421f.dismiss();
            }
            this.f26421f = null;
        }
    }

    /* access modifiers changed from: protected */
    public List<CommonLineParam> getDashLineParams() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) this.lineParams)) {
            for (CommonLineParam commonLineParam : this.lineParams) {
                if (commonLineParam != null && MapElementId.ID_LINE_START_PICKUP == commonLineParam.getId()) {
                    LatLng a = m18748a();
                    if (a != null) {
                        commonLineParam.setStartPoint(a);
                    }
                    commonLineParam.setAnimate(true);
                    arrayList.add(commonLineParam);
                    if (!(commonLineParam.getStartPoint() == null || commonLineParam.getEndPoint() == null)) {
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(commonLineParam.getStartPoint(), commonLineParam.getEndPoint());
                        DLog.m7384d(f26416a, "乘客位置和上车点之间的距离：" + computeDistanceBetween, new Object[0]);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<CommonMarkerParam> getShowMarkerParams() {
        ArrayList arrayList = new ArrayList();
        if (this.markerParams != null && !CollectionUtil.isEmpty((Collection<?>) this.markerParams)) {
            for (CommonMarkerParam commonMarkerParam : this.markerParams) {
                if (commonMarkerParam != null && MapElementId.ID_MARKER_PICK_UP == commonMarkerParam.getId()) {
                    arrayList.add(commonMarkerParam);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        String str;
        LatLng driverPoint;
        long j = this.pickupSctxIntervalMillis;
        if (!this.f26417b || this.mPassengerSctx == null || (driverPoint = this.mPassengerSctx.getDriverPoint()) == null || DDSphericalUtil.computeDistanceBetween(driverPoint, getMarkerPointWithId(MapElementId.ID_MARKER_START)) >= ((double) this.f26418c)) {
            str = "正常轮训间隔";
        } else {
            j = this.f26419d;
            str = "临近上车点轮训间隔";
        }
        DLog.m7384d(f26416a, "接驾段当前Ora轮训间隔:%dms(%s)", Long.valueOf(j), str);
        return j;
    }

    public void onOrderStateChanged(int i, OrderParams orderParams) {
        this.orderParam = orderParams;
        if (i != 2 && i != 3 && i != 4) {
            updateScene();
        }
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        boolean z2 = false;
        DLog.m7384d(f26416a, "doSceneBestView, start", new Object[0]);
        if (this.isSceneValid && getContext() != null && getMap() != null) {
            Padding defaultPadding = getDefaultPadding();
            ArrayList arrayList = new ArrayList();
            if (this.mMapView != null) {
                List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
                if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            List<IMapElement> markerElementWithId = getMarkerElementWithId(MapElementId.ID_MARKER_PICK_UP.name());
            if (!CollectionUtil.isEmpty((Collection<?>) markerElementWithId)) {
                arrayList.addAll(markerElementWithId);
            }
            MiniBusGuideEntranceComponent miniBusGuideEntranceComponent = this.f26422g;
            if (miniBusGuideEntranceComponent != null && !CollectionUtil.isEmpty((Collection<?>) miniBusGuideEntranceComponent.getMarker())) {
                arrayList.addAll(this.f26422g.getMarker());
            }
            if (this.dashLineComponent != null && !CollectionUtil.isEmpty((Collection<?>) this.dashLineComponent.getBestViewElements())) {
                arrayList.addAll(this.dashLineComponent.getBestViewElements());
            }
            if (this.mapAutoBestViewLoop != null) {
                if (padding != null) {
                    if (padding.right <= 0) {
                        padding.right = getDefaultPadding().right;
                    }
                    if (padding.left <= 0) {
                        padding.left = getDefaultPadding().left;
                    }
                }
                z2 = this.mapAutoBestViewLoop.doBestViewExecute(arrayList, padding, defaultPadding, z);
            } else {
                DLog.m7384d(f26416a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                hideResetView();
            }
        }
    }

    /* renamed from: a */
    private LatLng m18748a() {
        try {
            if (this.mParam == null || ((MiniBusSctxSceneParam) this.mParam).getContext() == null) {
                return null;
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(((MiniBusSctxSceneParam) this.mParam).getContext());
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            DLog.m7384d(f26416a, "getPassengerLatLng is null", new Object[0]);
            return null;
        }
    }
}
