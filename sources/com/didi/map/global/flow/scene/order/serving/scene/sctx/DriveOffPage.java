package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.view.View;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DriveOffPage extends BasePage {

    /* renamed from: a */
    private static final String f26931a = "DriveOffPage";

    /* renamed from: b */
    private SctxService.SctxCallback f26932b = new SctxService.SctxCallbackAdapter() {
        public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
            DriveOffPage.this.mo75440a(latLng2);
        }

        public void onWayPointsStateUpdate(boolean z, List<OdPoint> list) {
            DriveOffPage.this.addOdPointMarker(list, false);
        }
    };

    /* renamed from: c */
    private IServingController f26933c = new IServingController() {
        public /* synthetic */ void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
            IServingController.CC.$default$animateCamera(this, cameraPosition, i, cancelableCallback);
        }

        public /* synthetic */ void cancelPickupPointRecommend() {
            IServingController.CC.$default$cancelPickupPointRecommend(this);
        }

        public /* synthetic */ void destroyMarkerBubble(MapElementId mapElementId) {
            IServingController.CC.$default$destroyMarkerBubble(this, mapElementId);
        }

        public /* synthetic */ void doBestView(Padding padding) {
            ISceneController.CC.$default$doBestView(this, padding);
        }

        public /* synthetic */ LatLng getLastDriverPosition() {
            return IServingController.CC.$default$getLastDriverPosition(this);
        }

        public /* synthetic */ EtaEda getLastEtaEda() {
            return IServingController.CC.$default$getLastEtaEda(this);
        }

        public /* synthetic */ double getLeftRouteDistance() {
            return IServingController.CC.$default$getLeftRouteDistance(this);
        }

        public /* synthetic */ void hideMarkerBubble(MapElementId mapElementId) {
            IServingController.CC.$default$hideMarkerBubble(this, mapElementId);
        }

        public /* synthetic */ void onOrderStateChanged(int i, ServingParam servingParam) {
            IServingController.CC.$default$onOrderStateChanged(this, i, servingParam);
        }

        public /* synthetic */ void onPushMsgReceived(byte[] bArr) {
            IServingController.CC.$default$onPushMsgReceived(this, bArr);
        }

        public /* synthetic */ void onStartChangedForSharer(GuideStartInfo guideStartInfo) {
            IServingController.CC.$default$onStartChangedForSharer(this, guideStartInfo);
        }

        public /* synthetic */ boolean refresh3DCarIcons(boolean z, List<String> list) {
            return IServingController.CC.$default$refresh3DCarIcons(this, z, list);
        }

        public /* synthetic */ void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
            IServingController.CC.$default$refreshCarBitmapDescriptor(this, bitmapDescriptor);
        }

        public /* synthetic */ void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo) {
            IServingController.CC.$default$setCarpoolInfo(this, iFetchCarpoolInfo);
        }

        public /* synthetic */ void setCarpoolShowBubblesEnabled(boolean z) {
            IServingController.CC.$default$setCarpoolShowBubblesEnabled(this, z);
        }

        public /* synthetic */ void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
            IServingController.CC.$default$setInfoWindowClickListener(this, mapElementId, onInfoWindowClickListener);
        }

        public /* synthetic */ void setOdPoints(List<OdPoint> list, long j) {
            IServingController.CC.$default$setOdPoints(this, list, j);
        }

        public /* synthetic */ void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback) {
            IServingController.CC.$default$startModifyPickupLocation(this, address, address2, f, iLocationCallback);
        }

        public /* synthetic */ void stopModifyPickupLocation(LatLng latLng) {
            IServingController.CC.$default$stopModifyPickupLocation(this, latLng);
        }

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view);
        }

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view, position);
        }

        public /* synthetic */ void updatePickupPoint(LatLng latLng) {
            IServingController.CC.$default$updatePickupPoint(this, latLng);
        }

        public void modifyDestination(LatLng latLng) {
            DriveOffPage.this.mo75440a(DriveOffPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_END));
        }
    };
    protected long onTripSctxIntervalMillis = MapFlowApolloUtils.getOnTripSxtxIntervalMillis();

    /* access modifiers changed from: package-private */
    public int getOrderStage() {
        return 4;
    }

    public DriveOffPage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(pageScene, servingParam, mapViewHolder);
    }

    public void enter(boolean z) {
        super.enter(true);
        setServingController(this.f26933c);
        setSctxCallback(this.f26932b);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_END, false);
        if (this.mMapView != null) {
            this.mMapView.setLocationVisible(false);
        }
        OrderFloatWindowManager.Instance().setServingParam((ServingParam) null);
        OrderFloatWindowManager.Instance().setTripStage(getOrderStage());
        OrderFloatWindowManager.Instance().setMapSdkType(OrderFloatWindowManager.getMapSdkType(getMap()));
    }

    public void leave() {
        super.leave();
        this.mMarkerManager.destroy();
        removeOdMarkers();
    }

    /* access modifiers changed from: package-private */
    public void doSceneBestView(Padding padding, boolean z) {
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            ArrayList arrayList = new ArrayList();
            List<IMapElement> makerMapElements = this.mMarkerManager.getMakerMapElements(MapElementId.ID_MARKER_END);
            if (!CollectionUtil.isEmpty((Collection<?>) makerMapElements)) {
                arrayList.addAll(makerMapElements);
            }
            CarMarker carMarker = this.mPassengerSctx.getCarMarker();
            if (!(carMarker == null || carMarker.getMarker() == null)) {
                arrayList.add(carMarker.getMarker());
            }
            Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_WAYPOINT);
            if (iconMarker != null) {
                arrayList.add(iconMarker);
                Marker labelMarker = this.mMarkerManager.getLabelMarker(MapElementId.ID_MARKER_WAYPOINT);
                if (labelMarker != null) {
                    arrayList.add(labelMarker);
                }
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                arrayList.addAll(routeElements);
            }
            if (!(this.mPassengerSctx == null || this.mPassengerSctx.getLines() == null)) {
                arrayList.addAll(this.mPassengerSctx.getLines());
            }
            boolean z2 = false;
            if (this.mapAutoBestViewLooper != null) {
                z2 = this.mapAutoBestViewLooper.doBestViewExecute(arrayList, padding, mapInPadding, z);
            } else {
                DLog.m7384d("InServiceSctxScene", "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                this.mScene.hideResetView();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo75440a(LatLng latLng) {
        Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_END);
        if (iconMarker == null || iconMarker.getPosition().equals(latLng)) {
            DLog.m7384d(f26931a, "refreshEndPointMarker, same LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
            return;
        }
        DLog.m7384d(f26931a, "refreshEndPointMarker, new LatLng:%s, old LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng), GoogleSyncTripLogUtil.getLatLngLogInfo(iconMarker.getPosition()));
        this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_END);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_END, latLng, false);
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        return this.onTripSctxIntervalMillis;
    }
}
