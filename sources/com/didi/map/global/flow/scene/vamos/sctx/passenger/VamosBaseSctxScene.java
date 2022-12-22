package com.didi.map.global.flow.scene.vamos.sctx.passenger;

import android.view.View;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.serving.components.DrivingStartEndMarker;
import com.didi.map.global.flow.scene.order.serving.components.StartEndMarkerLabelRule;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.model.SctxSceneCachedValue;
import com.didi.map.global.flow.scene.vamos.sctx.passenger.param.VamosSctxSceneParam;
import com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop;
import com.didi.map.global.flow.toolkit.sctx.PassengerSctx;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.utils.MarkerUtil;
import com.didi.map.global.flow.utils.RoleExtractUtil;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.model.VamosExpansionParam;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteNotifyReq;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.NotifyType;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;

public abstract class VamosBaseSctxScene extends BaseVamosPageScene<VamosSctxSceneParam> implements IVamosPssengerSctxSceneController {
    protected static final int MAX_DISTANCE_BETWEEN_LOCATION_AND_DEPARTURE = 5000;
    protected static final int ZINDEX_CAR = 96;
    protected static final int ZINDEX_PSG_END = 98;
    protected static final int ZINDEX_PSG_START = 100;

    /* renamed from: a */
    private static final String f27163a = VamosBaseSctxScene.class.getSimpleName();

    /* renamed from: b */
    private static final long f27164b = 3000;

    /* renamed from: c */
    private static final int f27165c = 94;
    protected boolean bIsDriverArrived;
    protected final SctxSceneCachedValue mCachedValue = new SctxSceneCachedValue(getContext());
    protected PassengerSctx mPassengerSctx;
    protected MapAutoBestViewLoop mapAutoBestViewLoop;

    /* access modifiers changed from: protected */
    public abstract void doSceneBestView(Padding padding, boolean z);

    /* access modifiers changed from: protected */
    public abstract int getOrderStage();

    /* access modifiers changed from: protected */
    public long getSyncInterval() {
        return 3000;
    }

    public boolean isUserLocationVisible() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onGetOraResult(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
    }

    public VamosBaseSctxScene(VamosSctxSceneParam vamosSctxSceneParam, MapViewHolder mapViewHolder) {
        super(vamosSctxSceneParam, mapViewHolder);
        m19195a();
    }

    /* access modifiers changed from: protected */
    public Padding getMapInPadding() {
        int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
        int dp2px2 = DisplayUtils.dp2px(getContext(), 3.0f);
        return new Padding(dp2px, dp2px2, dp2px, dp2px2);
    }

    /* renamed from: a */
    private void m19195a() {
        if (this.mParam != null && getMap() != null && getContext() != null) {
            boolean z = false;
            boolean z2 = ((VamosSctxSceneParam) this.mParam).getOrderParams() != null;
            boolean z3 = ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() != null;
            this.bIsDriverArrived = z2 && ((VamosSctxSceneParam) this.mParam).getOrderParams().orderStage == 1;
            String str = "";
            LatLng latLng = null;
            SctxTripParam.Builder pickupPoint = new SctxTripParam.Builder().map(getMap()).context(getContext()).passengerPhone(z2 ? ((VamosSctxSceneParam) this.mParam).getOrderParams().phoneNumPassenger : str).carBitmapDescriptor(((VamosSctxSceneParam) this.mParam).getCarMarkerBitmap() == null ? null : ((VamosSctxSceneParam) this.mParam).getCarMarkerBitmap().getBitmapDescriptor()).car3DEnabled(ApolloToggleUtils.is3DCarEnabled()).car3DIcons(((VamosSctxSceneParam) this.mParam).getCarIcons()).zIndex(96).isArrivedPickupPoint(z2 && ((VamosSctxSceneParam) this.mParam).getOrderParams().orderStage == 1).orderId(z2 ? ((VamosSctxSceneParam) this.mParam).getOrderParams().orderId : str).bizType(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue()).tripState(getOrderStage()).pickupPoint(z3 ? ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().start : null);
            if (z3) {
                latLng = ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().end;
            }
            long j = 0;
            SctxTripParam.Builder lastOrderId = pickupPoint.endPoint(latLng).vamosExpansionParam(m19200b()).token(PaxEnvironment.getInstance().getToken()).driverId(z2 ? ((VamosSctxSceneParam) this.mParam).getOrderParams().driverId : 0).tripId(z2 ? ((VamosSctxSceneParam) this.mParam).getOrderParams().travelId : str).lastOrderId(str);
            if (z2 && ((VamosSctxSceneParam) this.mParam).getOrderParams().isShowExtendedAnimation) {
                z = true;
            }
            SctxTripParam.Builder countryId = lastOrderId.isShowExtendedAnimation(z).clientVersion(((VamosSctxSceneParam) this.mParam).getClientParams() == null ? str : ((VamosSctxSceneParam) this.mParam).getClientParams().clientVersion).countryId(((VamosSctxSceneParam) this.mParam).getClientParams() == null ? str : ((VamosSctxSceneParam) this.mParam).getClientParams().countryId);
            if (((VamosSctxSceneParam) this.mParam).getClientParams() != null) {
                str = ((VamosSctxSceneParam) this.mParam).getClientParams().imei;
            }
            SctxTripParam.Builder oraRequestInterval = countryId.imei(str).oraRequestInterval(getSyncInterval());
            if (z2) {
                j = (long) ((VamosSctxSceneParam) this.mParam).getOrderParams().pickupExtendedAnimDurationInMs;
            }
            SctxTripParam build = oraRequestInterval.routeExtensionAnimationDuration(j).sctxSearchGetter(m19205c()).build();
            if (this.mPassengerSctx == null) {
                this.mPassengerSctx = new PassengerSctx();
            }
            this.mPassengerSctx.update(build);
            this.mPassengerSctx.registerSctxCallback(m19207d());
        }
    }

    /* renamed from: b */
    private VamosExpansionParam m19200b() {
        VamosExpansionParam vamosExpansionParam = new VamosExpansionParam();
        vamosExpansionParam.driverTripDestPoint = ((VamosSctxSceneParam) this.mParam).getVamosDriverDestPoint();
        return vamosExpansionParam;
    }

    /* renamed from: c */
    private SctxService.SctxSearchGetter m19205c() {
        return new SctxService.SctxSearchGetter() {
            public String getUserId() {
                return PaxEnvironment.getInstance().getUid();
            }

            public String getUserRole() {
                return VamosBaseSctxScene.this.m19209e();
            }

            public String getPageReferrer() {
                return VamosBaseSctxScene.this.m19210f();
            }
        };
    }

    /* renamed from: d */
    private SctxService.SctxCallback m19207d() {
        return new SctxService.SctxCallbackAdapter() {
            public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
            }

            public void onSyncStart() {
            }

            public void onWayPointsStateUpdate(boolean z, List<OdPoint> list) {
            }

            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (VamosBaseSctxScene.this.mParam != null && ((VamosSctxSceneParam) VamosBaseSctxScene.this.mParam).getSctxStateCallback() != null) {
                    ((VamosSctxSceneParam) VamosBaseSctxScene.this.mParam).getSctxStateCallback().onSctxStateUpdate(sctxStateInfo);
                }
            }

            public void onEtaEdaUpdate(EtaEdaInfo etaEdaInfo) {
                if (etaEdaInfo != null && VamosBaseSctxScene.this.isSceneValid && etaEdaInfo.getEta() >= 0 && etaEdaInfo.getEda() >= 0) {
                    VamosBaseSctxScene.this.m19196a(etaEdaInfo.getEta(), etaEdaInfo.getEda());
                    VamosBaseSctxScene.this.m19212g();
                    if (VamosBaseSctxScene.this.mapAutoBestViewLoop != null) {
                        VamosBaseSctxScene.this.mapAutoBestViewLoop.doBestViewImmediately(false);
                    }
                }
            }

            public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                VamosBaseSctxScene.this.onGetOraResult(mapPassengeOrderRouteRes);
                if (VamosBaseSctxScene.this.mPassengerSctx != null) {
                    VamosBaseSctxScene.this.mPassengerSctx.setOraRequestInterval(VamosBaseSctxScene.this.getSyncInterval());
                }
            }

            public void onRouteAnimationStart() {
                VamosBaseSctxScene.this.mCachedValue.isRouteExtAnimating = true;
            }

            public void onRouteAnimationEnd() {
                VamosBaseSctxScene.this.mCachedValue.isRouteExtAnimating = false;
            }
        };
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        DLog.m7384d(f27163a, "enter...", new Object[0]);
        if (this.mapAutoBestViewLoop == null && getMap() != null) {
            MapAutoBestViewLoop mapAutoBestViewLoop2 = new MapAutoBestViewLoop(getMap());
            this.mapAutoBestViewLoop = mapAutoBestViewLoop2;
            mapAutoBestViewLoop2.setOnBestViewCallback(new MapAutoBestViewLoop.IBestViewCallback() {
                public final void doBestView(boolean z) {
                    VamosBaseSctxScene.this.m19203b(z);
                }
            });
        }
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.enter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m19203b(boolean z) {
        doSceneBestView(this.mPadding, z);
    }

    public void leave() {
        super.leave();
        DLog.m7384d(f27163a, "leave...", new Object[0]);
        removeStartEndMarker();
        MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
        if (mapAutoBestViewLoop2 != null) {
            mapAutoBestViewLoop2.destroy();
            this.mapAutoBestViewLoop = null;
        }
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.leave();
        }
    }

    public void onResume() {
        super.onResume();
        DLog.m7384d(f27163a, "onResume...", new Object[0]);
        m19199a(true);
        if (this.isSceneValid) {
            PassengerSctx passengerSctx = this.mPassengerSctx;
            if (passengerSctx != null) {
                passengerSctx.resume();
            }
            MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
            if (mapAutoBestViewLoop2 != null) {
                mapAutoBestViewLoop2.onMapVisible(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
        DLog.m7384d(f27163a, "onPause...", new Object[0]);
        m19199a(false);
        if (this.isSceneValid) {
            PassengerSctx passengerSctx = this.mPassengerSctx;
            if (passengerSctx != null) {
                passengerSctx.pause();
            }
            MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
            if (mapAutoBestViewLoop2 != null) {
                mapAutoBestViewLoop2.onMapVisible(false);
            }
        }
    }

    /* renamed from: a */
    private void m19199a(boolean z) {
        String str = "";
        String str2 = (this.mParam == null || ((VamosSctxSceneParam) this.mParam).getOrderParams() == null) ? str : ((VamosSctxSceneParam) this.mParam).getOrderParams().orderId;
        int orderStage = getOrderStage();
        boolean z2 = this.bIsDriverArrived;
        long routeId = this.mPassengerSctx.getRouteId();
        String str3 = (this.mParam == null || ((VamosSctxSceneParam) this.mParam).getClientParams() == null) ? str : ((VamosSctxSceneParam) this.mParam).getClientParams().countryId;
        if (!(this.mParam == null || ((VamosSctxSceneParam) this.mParam).getOrderParams() == null)) {
            str = ((VamosSctxSceneParam) this.mParam).getOrderParams().travelId;
        }
        MapFlowOmegaUtil.trackSwitchBackAndFront(z, str2, orderStage, z2, routeId, str3, str, Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue(), PaxEnvironment.getInstance().getUid(), m19209e(), m19210f());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m19209e() {
        return RoleExtractUtil.getId(PaxEnvironment.getInstance().getRoleType());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m19210f() {
        Page page = PaxEnvironment.getInstance().getPage();
        return page != null ? page.toString() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19196a(int i, int i2) {
        this.mCachedValue.etaEda = new EtaEda(i, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m19212g() {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (VamosBaseSctxScene.this.mParam != null && ((VamosSctxSceneParam) VamosBaseSctxScene.this.mParam).getEtaEdaCallback() != null) {
                    ((VamosSctxSceneParam) VamosBaseSctxScene.this.mParam).getEtaEdaCallback().onEtaEdaChanged(VamosBaseSctxScene.this.mCachedValue.etaEda);
                }
            }
        });
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        MapAutoBestViewLoop mapAutoBestViewLoop2 = this.mapAutoBestViewLoop;
        if (mapAutoBestViewLoop2 != null) {
            mapAutoBestViewLoop2.doBestViewImmediately(true);
        }
    }

    public void showStartMarkerInfoWindow(View view) {
        if (this.mCachedValue.startEndMarker != null && this.mCachedValue.startEndMarker.getStartIconMarker() != null) {
            showMarkerInfoWindow(this.mCachedValue.startEndMarker.getStartIconMarker(), view, 101);
        }
    }

    public void showEndMarkerInfoWindow(View view) {
        if (this.mCachedValue.startEndMarker != null && this.mCachedValue.startEndMarker.getEndIconMarker() != null) {
            showMarkerInfoWindow(this.mCachedValue.startEndMarker.getEndIconMarker(), view, this.mCachedValue.startEndMarker.getEndIconMarker().getZIndex());
        }
    }

    public void showCarMarkerInfoWindow(View view) {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null && passengerSctx.getCarMarker() != null) {
            showMarkerInfoWindow(this.mPassengerSctx.getCarMarker().getMarker(), view, 97);
        }
    }

    /* access modifiers changed from: protected */
    public void showMarkerInfoWindow(Marker marker, View view, int i) {
        if (this.isSceneValid) {
            MarkerUtil.showInfoWindow(this.mMapView.getMapView(), marker, view, i, (InfoWindow.Position) null);
        }
    }

    public void destroyStartMarkerInfoWindow() {
        if (this.mCachedValue.startEndMarker != null) {
            m19197a(this.mCachedValue.startEndMarker.getStartIconMarker());
        }
    }

    public void destroyEndMarkerInfoWindow() {
        if (this.mCachedValue.startEndMarker != null) {
            m19197a(this.mCachedValue.startEndMarker.getEndIconMarker());
        }
    }

    public void destroyCarMarkerInfoWindow() {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null && passengerSctx.getCarMarker() != null) {
            m19197a(this.mPassengerSctx.getCarMarker().getMarker());
        }
    }

    /* renamed from: a */
    private void m19197a(Marker marker) {
        if (marker != null && marker.getInfoWindow() != null) {
            marker.getInfoWindow().destroy();
            marker.destroyInfoWindow();
        }
    }

    public void hideStartMarkerInfoWindow() {
        if (this.mCachedValue.startEndMarker != null) {
            m19202b(this.mCachedValue.startEndMarker.getStartIconMarker());
        }
    }

    public void hideEndMarkerInfoWindow() {
        if (this.mCachedValue.startEndMarker != null) {
            m19202b(this.mCachedValue.startEndMarker.getEndIconMarker());
        }
    }

    public void hideCarMarkerInfoWindow() {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null && passengerSctx.getCarMarker() != null) {
            m19202b(this.mPassengerSctx.getCarMarker().getMarker());
        }
    }

    /* renamed from: b */
    private void m19202b(Marker marker) {
        if (this.isSceneValid) {
            MarkerUtil.hideInfoWindow(marker);
        }
    }

    /* access modifiers changed from: protected */
    public void addStartPointMarker(LatLng latLng, boolean z) {
        if (this.isSceneValid && this.mParam != null && ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() != null && latLng != null) {
            this.mCachedValue.startEndMarker.addStartMarker(this.mMapView.getMapView(), new DrivingStartEndMarker.StartEndMarkerInfoBuilder().position(latLng).markerIcon(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().startIcon).markerIconAnchorU(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().eAnchorU).markerIconAnchorV(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().eAnchorV).markerIconZIndex(100).label(z ? ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().startAddressName : null).labelColor(((VamosSctxSceneParam) this.mParam).getStartAddressNameColorResId()).labelAnchorIcon((BitmapDescriptor) null).labelZIndex(100).labelRule(new StartEndMarkerLabelRule(getContext())).create());
        }
    }

    /* access modifiers changed from: protected */
    public void refreshStartPointMarker(LatLng latLng, boolean z) {
        Marker startIconMarker;
        if (this.mCachedValue.startEndMarker != null && (startIconMarker = this.mCachedValue.startEndMarker.getStartIconMarker()) != null && startIconMarker.getPosition() != null && !startIconMarker.getPosition().equals(latLng)) {
            this.mCachedValue.startEndMarker.removeStartMarker();
            addStartPointMarker(latLng, z);
        }
    }

    /* access modifiers changed from: protected */
    public void addEndPointMarker(LatLng latLng, boolean z) {
        if (this.isSceneValid && this.mParam != null && ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() != null && latLng != null) {
            this.mCachedValue.startEndMarker.addEndMarker(this.mMapView.getMapView(), new DrivingStartEndMarker.StartEndMarkerInfoBuilder().position(latLng).markerIcon(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().endIcon).markerIconAnchorU(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().eAnchorU).markerIconAnchorV(((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().eAnchorV).markerIconZIndex(98).label(z ? ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().endAddressName : null).labelColor(((VamosSctxSceneParam) this.mParam).getEndAddressNameColorResId()).labelAnchorIcon((BitmapDescriptor) null).labelZIndex(98).labelRule(new StartEndMarkerLabelRule(getContext())).create());
        }
    }

    /* access modifiers changed from: protected */
    public void refreshEndPointMarker(LatLng latLng, boolean z) {
        Marker endIconMarker;
        if (this.mCachedValue.startEndMarker != null && (endIconMarker = this.mCachedValue.startEndMarker.getEndIconMarker()) != null && endIconMarker.getPosition() != null && !endIconMarker.getPosition().equals(latLng)) {
            this.mCachedValue.startEndMarker.removeEndMarker();
            addEndPointMarker(latLng, z);
        }
    }

    /* access modifiers changed from: protected */
    public void removeStartEndMarker() {
        if (this.mCachedValue.startEndMarker != null) {
            this.mCachedValue.startEndMarker.removeMarkers();
        }
    }

    /* access modifiers changed from: protected */
    public List<IMapElement> getRouteElements() {
        ArrayList<IMapElement> elementGroup;
        ArrayList arrayList = new ArrayList();
        if (!(getMap() == null || (elementGroup = getMap().getElementGroup(SctxService.SctxMapElementTags.ROUTE_PLAN)) == null || elementGroup.size() <= 0)) {
            arrayList.addAll(elementGroup);
        }
        return arrayList;
    }

    public EtaEda getEtaEda() {
        return this.mCachedValue.etaEda;
    }

    public LatLng getDriverPoint() {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx == null || passengerSctx.getCarMarker() == null) {
            return null;
        }
        return this.mPassengerSctx.getCarMarker().getPosition();
    }

    public void setStartMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.mCachedValue.startEndMarker != null && this.mCachedValue.startEndMarker.getStartIconMarker() != null && this.mCachedValue.startEndMarker.getStartIconMarker().getInfoWindow() != null) {
            this.mCachedValue.startEndMarker.getStartIconMarker().getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void setEndMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.mCachedValue.startEndMarker != null && this.mCachedValue.startEndMarker.getEndIconMarker() != null && this.mCachedValue.startEndMarker.getEndIconMarker().getInfoWindow() != null) {
            this.mCachedValue.startEndMarker.getEndIconMarker().getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void setCarMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        Marker marker;
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null && passengerSctx.getCarMarker() != null && (marker = this.mPassengerSctx.getCarMarker().getMarker()) != null && marker.getInfoWindow() != null) {
            marker.getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void onPushMsgReceived(byte[] bArr) {
        if (this.isSceneValid && m19215h() && bArr != null) {
            try {
                MapPassengeOrderRouteNotifyReq mapPassengeOrderRouteNotifyReq = (MapPassengeOrderRouteNotifyReq) new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, MapPassengeOrderRouteNotifyReq.class);
                if (mapPassengeOrderRouteNotifyReq != null && mapPassengeOrderRouteNotifyReq.notifyType.intValue() == NotifyType.kRouteUpdate.getValue() && this.mPassengerSctx.getRouteId() != mapPassengeOrderRouteNotifyReq.routeId.longValue()) {
                    this.mPassengerSctx.leave();
                    this.mPassengerSctx.enter();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDestination(LatLng latLng) {
        if (!(this.mParam == null || ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel() == null)) {
            ((VamosSctxSceneParam) this.mParam).getStartEndMarkerModel().end = latLng;
        }
        this.mPassengerSctx.updateDestination(latLng);
    }

    public double getRemainingRouteDistance() {
        return this.mPassengerSctx.getRemainingRouteDistance();
    }

    public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.mPassengerSctx.setCarIcon(bitmapDescriptor);
        }
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        return this.mPassengerSctx.set3DCarIcons(z, list);
    }

    public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
        if (getMap() != null) {
            getMap().animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), i, cancelableCallback);
        }
    }

    /* renamed from: h */
    private boolean m19215h() {
        return !this.isScenePaused;
    }

    /* access modifiers changed from: protected */
    public void handleTrackDragMapEvent() {
        if (this.mParam != null && ((VamosSctxSceneParam) this.mParam).getOrderParams() != null) {
            String str = ((VamosSctxSceneParam) this.mParam).getOrderParams().orderId;
        }
    }
}
