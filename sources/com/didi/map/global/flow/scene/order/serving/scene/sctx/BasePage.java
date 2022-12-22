package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.EventDescribe;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.IPassPointStatusCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.carpool.ISctxCarpoolMgr;
import com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgr;
import com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgrTwo;
import com.didi.map.global.flow.scene.order.serving.components.MarkerManager;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop;
import com.didi.map.global.flow.toolkit.sctx.PassengerSctx;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.utils.RoleExtractUtil;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.EtaEdaInfo;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteNotifyReq;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.NotifyType;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class BasePage {
    public static final int POINT_TYPE_MID = 2;
    private static final long SCTX_INTERVAL_MILLIS = 3000;
    private static final String TAG = "BasePage";
    protected boolean bIsDriverArrived;
    protected boolean isSceneValid;
    private IServingController mAgentServingController = new IServingController() {
        public void doBestView(Padding padding) {
            BasePage.this.doBestView(padding);
        }

        public void updateMarkerBubble(MapElementId mapElementId, View view) {
            updateMarkerBubble(mapElementId, view, (InfoWindow.Position) null);
        }

        public void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position) {
            if (!BasePage.this.mParam.isNewVersion() || !(BasePage.this.mParam instanceof ServingParam) || !BasePage.this.hasGuideEntrance()) {
                BasePage.this.mMarkerManager.updateMarkerBubble(mapElementId, view, position, false);
            } else {
                BasePage.this.mMarkerManager.updateMarkerBubble(mapElementId, view, position, true);
            }
        }

        public void destroyMarkerBubble(MapElementId mapElementId) {
            BasePage.this.mMarkerManager.destroyIconMarkerBubble(mapElementId);
        }

        public void hideMarkerBubble(MapElementId mapElementId) {
            BasePage.this.mMarkerManager.hideIconMarkerBubble(mapElementId);
        }

        public void setCarpoolInfo(IFetchCarpoolInfo iFetchCarpoolInfo) {
            IFetchCarpoolInfo unused = BasePage.this.mFetchCarpoolInfo = iFetchCarpoolInfo;
        }

        public void setCarpoolShowBubblesEnabled(boolean z) {
            DLog.m7384d(BasePage.TAG, "setCarpoolShowBubblesEnabled() enabled: " + z, new Object[0]);
            if (BasePage.this.mSctxCarpoolMgr == null) {
                if (BasePage.this.mEnableSerialOrderOptimized) {
                    BasePage basePage = BasePage.this;
                    basePage.mSctxCarpoolMgr = new SctxWayPointsMgrTwo(basePage.mContext, BasePage.this.mMarkerManager, BasePage.this.mMapView.getMapView().getMap());
                } else {
                    BasePage basePage2 = BasePage.this;
                    basePage2.mSctxCarpoolMgr = new SctxWayPointsMgr(basePage2.mContext, BasePage.this.mMarkerManager, BasePage.this.mMapView.getMapView().getMap());
                }
                BasePage.this.mSctxCarpoolMgr.setCarpoolInfoFetcher(BasePage.this.mFetchCarpoolInfo);
            }
            BasePage.this.mSctxCarpoolMgr.setCarpoolShowBubblesEnabled(z);
        }

        public EtaEda getLastEtaEda() {
            return new EtaEda(BasePage.this.getEtaEdaInternal());
        }

        public LatLng getLastDriverPosition() {
            if (BasePage.this.mPassengerSctx == null || BasePage.this.mPassengerSctx.getCarMarker() == null) {
                return null;
            }
            return BasePage.this.mPassengerSctx.getCarMarker().getPosition();
        }

        public void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
            BasePage.this.mMarkerManager.setInfoWindowClickListener(mapElementId, onInfoWindowClickListener);
        }

        public void onPushMsgReceived(byte[] bArr) {
            DLog.m7384d(BasePage.TAG, "onPushMsgReceived...", new Object[0]);
            if (!BasePage.this.mPaused && bArr != null) {
                try {
                    MapPassengeOrderRouteNotifyReq mapPassengeOrderRouteNotifyReq = (MapPassengeOrderRouteNotifyReq) new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, MapPassengeOrderRouteNotifyReq.class);
                    if (mapPassengeOrderRouteNotifyReq != null && mapPassengeOrderRouteNotifyReq.notifyType.intValue() == NotifyType.kRouteUpdate.getValue() && BasePage.this.mPassengerSctx.getRouteId() != mapPassengeOrderRouteNotifyReq.routeId.longValue()) {
                        DLog.m7384d(BasePage.TAG, "onPushMsgReceived newRouteId: ", mapPassengeOrderRouteNotifyReq.routeId);
                        BasePage.this.mPassengerSctx.leave();
                        BasePage.this.mPassengerSctx.enter();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void modifyDestination(LatLng latLng) {
            BasePage.this.mMarkerManager.setPoint(MapElementId.ID_MARKER_END, latLng);
            if (BasePage.this.mPassengerSctx != null) {
                BasePage.this.mPassengerSctx.updateDestination(latLng);
            }
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.modifyDestination(latLng);
            }
        }

        public double getLeftRouteDistance() {
            if (BasePage.this.mPassengerSctx == null) {
                return -1.0d;
            }
            return BasePage.this.mPassengerSctx.getRemainingRouteDistance();
        }

        public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
            if (bitmapDescriptor != null && BasePage.this.mPassengerSctx != null) {
                BasePage.this.mPassengerSctx.setCarIcon(bitmapDescriptor);
            }
        }

        public boolean refresh3DCarIcons(boolean z, List<String> list) {
            return BasePage.this.mPassengerSctx != null && BasePage.this.mPassengerSctx.set3DCarIcons(z, list);
        }

        public void setOdPoints(List<OdPoint> list, long j) {
            if (BasePage.this.showOdPoints() && BasePage.this.mPassengerSctx != null) {
                BasePage.this.mPassengerSctx.setWayPoints(list, j);
            }
        }

        public void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
            if (BasePage.this.getMap() != null) {
                BasePage.this.getMap().animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), i, cancelableCallback);
            }
        }

        public void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback) {
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.startModifyPickupLocation(address, address2, f, iLocationCallback);
            }
        }

        public void stopModifyPickupLocation(LatLng latLng) {
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.stopModifyPickupLocation(latLng);
            }
        }

        public void onStartChangedForSharer(GuideStartInfo guideStartInfo) {
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.onStartChangedForSharer(guideStartInfo);
            }
        }

        public void updatePickupPoint(LatLng latLng) {
            if (BasePage.this.mPassengerSctx != null) {
                BasePage.this.mPassengerSctx.updatePickupPoint(latLng);
            }
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.updatePickupPoint(latLng);
            }
        }

        public void cancelPickupPointRecommend() {
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.cancelPickupPointRecommend();
            }
        }

        public void onOrderStateChanged(int i, ServingParam servingParam) {
            if (BasePage.this.mServingController != null) {
                BasePage.this.mServingController.onOrderStateChanged(i, servingParam);
            }
        }
    };
    protected AppFluentOmega mAppFluentOmega;
    protected Context mContext;
    private List<Marker> mCurOdMarkers = new ArrayList();
    /* access modifiers changed from: private */
    public List<LatLng> mCurRoutePoints = new ArrayList();
    /* access modifiers changed from: private */
    public boolean mEnableSerialOrderOptimized;
    private EtaEda mEtaEda = new EtaEda(-1, -1);
    /* access modifiers changed from: private */
    public IFetchCarpoolInfo mFetchCarpoolInfo;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mHasCallFarDistance;
    /* access modifiers changed from: private */
    public boolean mHasCallFirstOrderClose;
    /* access modifiers changed from: private */
    public boolean mHasCallNearDistance;
    /* access modifiers changed from: private */
    public OdPoint mLastOrderEndPoint;
    protected MapViewHolder mMapView;
    protected MarkerManager mMarkerManager;
    private List<IconLabelMarker> mNewCurOdMarkers = new ArrayList();
    protected Padding mPadding;
    protected ServingParam mParam;
    protected PassengerSctx mPassengerSctx;
    protected boolean mPaused = false;
    protected PageScene mScene;
    protected SctxService.SctxCallback mSctxCallback;
    protected ISctxCarpoolMgr mSctxCarpoolMgr;
    /* access modifiers changed from: private */
    public IServingController mServingController;
    protected MapAutoBestViewLoop mapAutoBestViewLooper;

    /* access modifiers changed from: package-private */
    public abstract void doSceneBestView(Padding padding, boolean z);

    /* access modifiers changed from: protected */
    public boolean enableBgOraService() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean enableBluetoothNotify() {
        return false;
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        return 3000;
    }

    /* access modifiers changed from: package-private */
    public abstract int getOrderStage();

    /* access modifiers changed from: protected */
    public boolean hasGuideEntrance() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean needAddSerialOrderPassPointMarker() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean showOdPoints() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showRecommendPickupPoint() {
        return false;
    }

    public BasePage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
        this.mScene = pageScene;
        this.mParam = servingParam;
        this.mMapView = mapViewHolder;
        this.mAppFluentOmega = pageScene.getAppFluentOmega();
        this.mContext = this.mParam.getContext();
        if (getMap() != null) {
            this.mPadding = getMap().getPadding();
        }
        this.mParam.dump();
        AppFluentOmega appFluentOmega = this.mAppFluentOmega;
        if (appFluentOmega != null) {
            appFluentOmega.startCalculateTime(7);
        }
        this.mMarkerManager = new MarkerManager(servingParam.getMarkerParams(), mapViewHolder);
        initPassengerSctx();
        this.mMarkerManager.setPassengerSctx(this.mPassengerSctx);
        this.mEnableSerialOrderOptimized = MapFlowApolloUtils.enableSerialOrderOptimized();
        ServingParam servingParam2 = this.mParam;
        if (servingParam2 != null && servingParam2.getOrderParams() != null) {
            OrderFloatWindowManager.Instance().setOrderId(this.mParam.getOrderParams().orderId);
        }
    }

    public void enter(boolean z) {
        DLog.m7384d(TAG, "DrivingSctxScene enter: " + GoogleSyncTripLogUtil.getOrderStageLogInfo(getOrderStage(), this.bIsDriverArrived), new Object[0]);
        this.isSceneValid = true;
        if (getMap() != null) {
            MapAutoBestViewLoop mapAutoBestViewLoop = new MapAutoBestViewLoop(getMap());
            this.mapAutoBestViewLooper = mapAutoBestViewLoop;
            mapAutoBestViewLoop.setOnBestViewCallback(new MapAutoBestViewLoop.IBestViewCallback() {
                public final void doBestView(boolean z) {
                    BasePage.this.lambda$enter$0$BasePage(z);
                }
            });
        }
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null && z) {
            passengerSctx.enter();
        }
        if (this.mParam == null || this.mMarkerManager == null) {
            DLog.m7384d(TAG, "DrivingSctxScene enter: param = null", new Object[0]);
            return;
        }
        DLog.m7384d(TAG, "DrivingSctxScene enter: marker params = " + this.mMarkerManager.toString(), new Object[0]);
    }

    public /* synthetic */ void lambda$enter$0$BasePage(boolean z) {
        doSceneBestView(this.mPadding, z);
    }

    public void onResume() {
        this.mPaused = false;
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.resume();
        }
    }

    public void onPause() {
        this.mPaused = true;
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.pause();
        }
    }

    public void leave() {
        DLog.m7384d(TAG, "DrivingSctxScene leave: " + GoogleSyncTripLogUtil.getOrderStageLogInfo(getOrderStage(), this.bIsDriverArrived), new Object[0]);
        this.isSceneValid = false;
        this.mMarkerManager.destroy();
        removeOdMarkers();
        ISctxCarpoolMgr iSctxCarpoolMgr = this.mSctxCarpoolMgr;
        if (iSctxCarpoolMgr != null) {
            iSctxCarpoolMgr.destroy();
        }
        MapAutoBestViewLoop mapAutoBestViewLoop = this.mapAutoBestViewLooper;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.destroy();
            this.mapAutoBestViewLooper = null;
        }
        AppFluentOmega appFluentOmega = this.mAppFluentOmega;
        if (appFluentOmega != null) {
            appFluentOmega.removeOmega(7);
        }
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.leave();
            this.mPassengerSctx = null;
        }
    }

    public final IServingController getServingController() {
        return this.mAgentServingController;
    }

    public void setServingController(IServingController iServingController) {
        this.mServingController = iServingController;
    }

    /* access modifiers changed from: protected */
    public void setSctxCallback(SctxService.SctxCallback sctxCallback) {
        this.mSctxCallback = sctxCallback;
    }

    /* access modifiers changed from: protected */
    public boolean refreshStartPointMarker(LatLng latLng, boolean z) {
        Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START);
        if (iconMarker != null && !iconMarker.getPosition().equals(latLng)) {
            DLog.m7384d(TAG, "refreshStartPointMarker, new LatLng:%s, old LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng), GoogleSyncTripLogUtil.getLatLngLogInfo(iconMarker.getPosition()));
            this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_START);
            this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_RECOMMEND);
            this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, latLng, z);
            return true;
        } else if (iconMarker == null) {
            DLog.m7384d(TAG, "refreshStartPointMarker, new LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
            this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, latLng, z);
            return true;
        } else {
            DLog.m7384d(TAG, "refreshStartPointMarker, same LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void refreshEndPointMarker(LatLng latLng, boolean z) {
        Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_END);
        if (iconMarker == null || iconMarker.getPosition().equals(latLng)) {
            DLog.m7384d(TAG, "refreshEndPointMarker, same LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng));
            return;
        }
        DLog.m7384d(TAG, "refreshEndPointMarker, new LatLng:%s, old LatLng:%s", GoogleSyncTripLogUtil.getLatLngLogInfo(latLng), GoogleSyncTripLogUtil.getLatLngLogInfo(iconMarker.getPosition()));
        this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_END);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_END, latLng, z);
    }

    /* access modifiers changed from: protected */
    public void initPassengerSctx() {
        PassengerSctx passengerSctx = this.mPassengerSctx;
        if (passengerSctx != null) {
            passengerSctx.leave();
            this.mPassengerSctx = null;
        }
        SctxTripParam sctxTripParam = getSctxTripParam();
        PassengerSctx passengerSctx2 = new PassengerSctx();
        this.mPassengerSctx = passengerSctx2;
        passengerSctx2.update(sctxTripParam);
        this.mPassengerSctx.registerSctxCallback(getSctxCallback());
        this.mMarkerManager.setPassengerSctx(this.mPassengerSctx);
    }

    /* access modifiers changed from: protected */
    public Map getMap() {
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.mMapView.getMapView().getMap();
    }

    public Context getContext() {
        MapViewHolder mapViewHolder = this.mMapView;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.mMapView.getMapView().getContext();
    }

    private SctxService.SctxSearchGetter getSctxSearchGetter() {
        return new SctxService.SctxSearchGetter() {
            public String getUserId() {
                return PaxEnvironment.getInstance().getUid();
            }

            public String getUserRole() {
                return BasePage.this.getUserRoleName();
            }

            public String getPageReferrer() {
                return BasePage.this.getPageEntrance();
            }
        };
    }

    /* access modifiers changed from: private */
    public String getUserRoleName() {
        return RoleExtractUtil.getId(PaxEnvironment.getInstance().getRoleType());
    }

    /* access modifiers changed from: private */
    public String getPageEntrance() {
        Page page = PaxEnvironment.getInstance().getPage();
        return page != null ? page.toString() : "";
    }

    public SctxTripParam getSctxTripParam() {
        boolean z = true;
        boolean z2 = this.mParam.getOrderParams() != null;
        LatLng point = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
        LatLng point2 = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_END);
        this.bIsDriverArrived = z2 && this.mParam.getOrderParams().orderStage == 1;
        String str = "";
        List<OdPoint> list = null;
        SctxTripParam.Builder builder = new SctxTripParam.Builder().map(getMap()).context(getContext()).passengerPhone(z2 ? this.mParam.getOrderParams().phoneNumPassenger : str).carBitmapDescriptor(this.mParam.getCarBitmapDescriptor() == null ? null : this.mParam.getCarBitmapDescriptor().getBitmapDescriptor()).car3DEnabled(ApolloToggleUtils.is3DCarEnabled()).car3DIcons(this.mParam.getCar3DIcons()).zIndex(100).isArrivedPickupPoint(this.bIsDriverArrived).orderId(z2 ? this.mParam.getOrderParams().orderId : str).bizType(this.mParam.getOrderParams().productID != null ? Integer.valueOf(this.mParam.getOrderParams().productID).intValue() : 0).tripState(getOrderStage()).pickupPoint(point).endPoint(point2).token(PaxEnvironment.getInstance().getToken());
        long j = 0;
        SctxTripParam.Builder lastOrderId = builder.driverId(z2 ? this.mParam.getOrderParams().driverId : 0).tripId(z2 ? this.mParam.getOrderParams().travelId : str).lastOrderId(z2 ? this.mParam.getOrderParams().lastOrderId : str);
        if (!z2 || !this.mParam.getOrderParams().isShowExtendedAnimation) {
            z = false;
        }
        SctxTripParam.Builder countryId = lastOrderId.isShowExtendedAnimation(z).isReadOnly(this.mParam.bReadOnly()).clientVersion(this.mParam.getClientParams() == null ? str : this.mParam.getClientParams().clientVersion).countryId(this.mParam.getClientParams() == null ? str : this.mParam.getClientParams().countryId);
        if (this.mParam.getClientParams() != null) {
            str = this.mParam.getClientParams().imei;
        }
        SctxTripParam.Builder routeExtensionAnimationDuration = countryId.imei(str).oraRequestInterval(getOraRequestIntervalMillis()).routeExtensionAnimationDuration(z2 ? (long) this.mParam.getOrderParams().pickupExtendedAnimDurationInMs : 0);
        if (z2) {
            list = this.mParam.getOrderParams().odPoints;
        }
        SctxTripParam.Builder wayPoints = routeExtensionAnimationDuration.wayPoints(list);
        if (z2) {
            j = this.mParam.getOrderParams().odPointsTimestamp;
        }
        return wayPoints.wayPointsTimestamp(j).sctxSearchGetter(getSctxSearchGetter()).newVersion(this.mParam.isNewVersion()).showRecommendPickupPoint(showRecommendPickupPoint()).enableBluetoothNotify(enableBluetoothNotify()).build();
    }

    /* access modifiers changed from: private */
    public boolean isSerialOrder() {
        ServingParam servingParam = this.mParam;
        return (servingParam == null || servingParam.getOrderParams() == null || TextUtils.isEmpty(this.mParam.getOrderParams().lastOrderId)) ? false : true;
    }

    private SctxService.SctxCallback getSctxCallback() {
        return new SctxService.SctxCallbackAdapter() {
            public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
                if (BasePage.this.mParam != null && BasePage.this.mParam.getSctxStateCallback() != null) {
                    BasePage.this.mParam.getSctxStateCallback().onSctxStateUpdate(sctxStateInfo);
                }
            }

            public void onEtaEdaUpdate(EtaEdaInfo etaEdaInfo) {
                DLog.m7384d(BasePage.TAG, "onEtaEdaUpdate: %s", etaEdaInfo);
                if (etaEdaInfo != null) {
                    BasePage.this.onFinishFetchingEtaEda(etaEdaInfo.getEta(), etaEdaInfo.getEda());
                    if (BasePage.this.mEnableSerialOrderOptimized && BasePage.this.isSerialOrder() && BasePage.this.mLastOrderEndPoint != null) {
                        int tripStateActiveDistance = MapFlowApolloUtils.getTripStateActiveDistance();
                        DLog.m7384d(BasePage.TAG, "distance = " + tripStateActiveDistance, new Object[0]);
                        int lastOrderEda = etaEdaInfo.getLastOrderEda();
                        DLog.m7384d(BasePage.TAG, "last Order eda:" + lastOrderEda, new Object[0]);
                        if (lastOrderEda <= 0) {
                            return;
                        }
                        if (etaEdaInfo.getLastOrderEda() <= tripStateActiveDistance || BasePage.this.mHasCallFarDistance) {
                            if (etaEdaInfo.getLastOrderEda() <= tripStateActiveDistance && !BasePage.this.mHasCallNearDistance && BasePage.this.mParam != null && BasePage.this.mParam.getTripStateCallback() != null) {
                                boolean unused = BasePage.this.mHasCallNearDistance = true;
                                DLog.m7384d(BasePage.TAG, "near distance state call", new Object[0]);
                                BasePage.this.mParam.getTripStateCallback().onTripStateUpdate(2);
                                if (BasePage.this.mParam.getOrderParams() != null) {
                                    MapFlowOmegaUtil.trackTripStateUpdate(BasePage.this.mParam.getOrderParams().orderId, 2);
                                }
                            }
                        } else if (BasePage.this.mParam != null && BasePage.this.mParam.getTripStateCallback() != null) {
                            boolean unused2 = BasePage.this.mHasCallFarDistance = true;
                            DLog.m7384d(BasePage.TAG, "far distance state call", new Object[0]);
                            BasePage.this.mParam.getTripStateCallback().onTripStateUpdate(1);
                            if (BasePage.this.mParam.getOrderParams() != null) {
                                MapFlowOmegaUtil.trackTripStateUpdate(BasePage.this.mParam.getOrderParams().orderId, 1);
                            }
                        }
                    }
                }
            }

            public void onWayPointsStateUpdate(boolean z, List<OdPoint> list) {
                if (z) {
                    if (BasePage.this.mParam != null && BasePage.this.mParam.getOdPointsExpiredCallback() != null) {
                        BasePage.this.mParam.getOdPointsExpiredCallback().onOdPointsExpired();
                    }
                } else if (BasePage.this.showOdPoints() && BasePage.this.mSctxCallback != null) {
                    BasePage.this.mSctxCallback.onWayPointsStateUpdate(false, list);
                }
            }

            public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
                if (BasePage.this.mSctxCallback != null) {
                    BasePage.this.mSctxCallback.onStartDestinationUpdate(latLng, latLng2);
                }
            }

            public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (mapPassengeOrderRouteRes != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("order_id", (BasePage.this.mParam == null || BasePage.this.mParam.getOrderParams() == null) ? "" : BasePage.this.mParam.getOrderParams().orderId);
                    if (BasePage.this.mAppFluentOmega != null) {
                        BasePage.this.mAppFluentOmega.stopCalculateTime(BasePage.this.getContext(), BasePage.this.getMap(), 7, hashMap);
                    }
                    if (BasePage.this.mSctxCallback != null) {
                        BasePage.this.mSctxCallback.onSyncSuccess(mapPassengeOrderRouteRes);
                    }
                    List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(mapPassengeOrderRouteRes.routePoints);
                    if (latLngListFromDiffGeoPoints != null && !latLngListFromDiffGeoPoints.isEmpty()) {
                        BasePage.this.mCurRoutePoints.clear();
                        BasePage.this.mCurRoutePoints.addAll(latLngListFromDiffGeoPoints);
                    }
                    if (!BasePage.this.mPaused) {
                        boolean z = true;
                        if (BasePage.this.mParam.getOrderParams() != null && BasePage.this.mParam.getOrderParams().isCarpoolOrder()) {
                            BasePage.this.onFinishFetchingCarpoolPoint(mapPassengeOrderRouteRes.odPoints, BasePage.this.mParam.getOrderParams() != null && !TextUtils.isEmpty(BasePage.this.mParam.getOrderParams().lastOrderId));
                        } else if (BasePage.this.isSerialOrder()) {
                            BasePage.this.onFinishFetchingSerialOrderPassPoint(mapPassengeOrderRouteRes.odPoints);
                            if (BasePage.this.getOrderStage() == 3 && BasePage.this.mParam.getOrderParams().orderStage == 0) {
                                SctxOmegaHelper.INSTANCE.trackSerialOrderOraRelatedError(BasePage.this.mParam.getOrderParams().orderId, BasePage.this.mParam.getOrderParams().lastOrderId, mapPassengeOrderRouteRes, BasePage.this.mCurRoutePoints, BasePage.this.mMarkerManager, BasePage.this.needAddSerialOrderPassPointMarker());
                            }
                        }
                        if (BasePage.this.isSerialOrder() && mapPassengeOrderRouteRes != null) {
                            OdPoint access$1100 = BasePage.this.getLastOrderEndPoint(mapPassengeOrderRouteRes);
                            if (BasePage.this.mParam != null && BasePage.this.mParam.getTripStateCallback() != null && BasePage.this.mEnableSerialOrderOptimized && access$1100 == null && !BasePage.this.mHasCallFirstOrderClose) {
                                DLog.m7384d(BasePage.TAG, "last order end call", new Object[0]);
                                boolean unused = BasePage.this.mHasCallFirstOrderClose = true;
                                BasePage.this.mParam.getTripStateCallback().onTripStateUpdate(3);
                                if (BasePage.this.mParam.getOrderParams() != null) {
                                    MapFlowOmegaUtil.trackTripStateUpdate(BasePage.this.mParam.getOrderParams().orderId, 3);
                                }
                            }
                            OdPoint unused2 = BasePage.this.mLastOrderEndPoint = access$1100;
                            if (!(mapPassengeOrderRouteRes.odPoints == null || mapPassengeOrderRouteRes.odPoints.isEmpty() || BasePage.this.mParam.getPassPointStatusCallback() == null)) {
                                IPassPointStatusCallback passPointStatusCallback = BasePage.this.mParam.getPassPointStatusCallback();
                                if (access$1100 != null) {
                                    z = false;
                                }
                                passPointStatusCallback.onPassPointStatusCallback(z);
                            }
                        }
                    }
                    String str = mapPassengeOrderRouteRes.inheritFailedTips;
                    if (!TextUtils.isEmpty(str)) {
                        DLog.m7384d("BubblePage", "bubble page tips:" + str, new Object[0]);
                        if (!(BasePage.this.mParam == null || BasePage.this.mParam.getEventCallback() == null)) {
                            BasePage.this.mParam.getEventCallback().onEventCallback(EventDescribe.BubblePageTips, str);
                        }
                    }
                }
                if (BasePage.this.mPassengerSctx != null) {
                    BasePage.this.mPassengerSctx.setOraRequestInterval(BasePage.this.getOraRequestIntervalMillis());
                }
            }

            public void onAbnormalOrderStageCallback(int i) {
                if (BasePage.this.mParam.getOraOrderStageCallback() != null) {
                    BasePage.this.mParam.getOraOrderStageCallback().onAbnormal(i);
                }
            }

            public void showSecRouteInfoCallback(SecRouteInfoEx secRouteInfoEx, boolean z) {
                if (BasePage.this.mSctxCallback != null) {
                    BasePage.this.mSctxCallback.showSecRouteInfoCallback(secRouteInfoEx, z);
                }
            }

            public void selectedPickupPoint(LatLng latLng) {
                if (BasePage.this.mSctxCallback != null) {
                    BasePage.this.mSctxCallback.selectedPickupPoint(latLng);
                }
            }

            public void goingOffCourse() {
                DLog.m7384d(BasePage.TAG, "goingOffCourse", new Object[0]);
                if (BasePage.this.mParam != null && BasePage.this.mParam.getEventCallback() != null) {
                    BasePage.this.mParam.getEventCallback().onEventCallback(EventDescribe.GoingOffCourse, (String) null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public OdPoint getLastOrderEndPoint(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        if (!isSerialOrder() || mapPassengeOrderRouteRes == null || CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes.odPoints)) {
            return null;
        }
        for (OdPoint next : mapPassengeOrderRouteRes.odPoints) {
            if (next.odType.intValue() == 1 && next.pointType.intValue() == 2) {
                return next;
            }
        }
        return null;
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

    /* access modifiers changed from: protected */
    public List<IMapElement> getSctxWayPoints() {
        ISctxCarpoolMgr iSctxCarpoolMgr = this.mSctxCarpoolMgr;
        if (iSctxCarpoolMgr != null) {
            return iSctxCarpoolMgr.getSctxWayPoints();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void onFinishFetchingCarpoolPoint(List<OdPoint> list, boolean z) {
        DLog.m7384d(TAG, "onFinishFetchingCarpoolPoint", new Object[0]);
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            if (this.mSctxCarpoolMgr == null) {
                if (this.mEnableSerialOrderOptimized) {
                    this.mSctxCarpoolMgr = new SctxWayPointsMgrTwo(this.mContext, this.mMarkerManager, this.mMapView.getMapView().getMap());
                } else {
                    this.mSctxCarpoolMgr = new SctxWayPointsMgr(this.mContext, this.mMarkerManager, this.mMapView.getMapView().getMap());
                }
                this.mSctxCarpoolMgr.setCarpoolInfoFetcher(this.mFetchCarpoolInfo);
            }
            this.mSctxCarpoolMgr.onFinishFetchingCarpoolPoint(z, list, this.mPassengerSctx.getRemainingRoutePoints(), this.mPassengerSctx.getCarMarker() == null ? null : this.mPassengerSctx.getCarMarker().getMarker(), this.mParam.getOrderParams().carpoolStartIcon, this.mParam.getOrderParams().carpoolEndIcon);
        }
    }

    /* access modifiers changed from: private */
    public void onFinishFetchingSerialOrderPassPoint(List<OdPoint> list) {
        if (list == null || list.isEmpty()) {
            removeOdMarkers();
            this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
            return;
        }
        LatLng latLng = null;
        ArrayList arrayList = new ArrayList();
        for (OdPoint next : list) {
            if (!(next == null || next.point == null || next.pointType == null || next.pointType.intValue() != 2)) {
                if (next.odType != null && next.odType.intValue() == 1) {
                    latLng = new LatLng((double) next.point.lat.floatValue(), (double) next.point.lng.floatValue());
                } else if (next.odType != null && next.odType.intValue() == 2) {
                    arrayList.add(next);
                }
            }
        }
        drawSerialOrderEndPoint(latLng);
        if (latLng == null) {
            addOdPointMarker(arrayList, false);
        } else {
            addOdPointMarker(arrayList, true);
        }
    }

    private void drawSerialOrderEndPoint(LatLng latLng) {
        if (latLng == null || !needAddSerialOrderPassPointMarker()) {
            this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
            return;
        }
        this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
        this.mMarkerManager.addMarker(MapElementId.ID_MARKER_WAYPOINT, latLng, true);
    }

    /* access modifiers changed from: protected */
    public void addOdPointMarker(List<OdPoint> list, boolean z) {
        if (z) {
            addOdPointMarkerNew(list, true);
        } else {
            addOdPointMarkerOld(list);
        }
    }

    /* access modifiers changed from: protected */
    public void removeOdMarkers() {
        removeOdMarkersNew();
        removeOdMarkersOld();
    }

    /* access modifiers changed from: protected */
    public void addOdPointMarkerOld(List<OdPoint> list) {
        this.mMarkerManager.setOdPointMarkerIconStyle(false);
        removeOdMarkersOld();
        int markerIconResId = this.mMarkerManager.getMarkerIconResId(MapElementId.ID_MARKER_ODPOINT);
        if (list != null) {
            Iterator it = new ArrayList(list).iterator();
            while (it.hasNext()) {
                OdPoint odPoint = (OdPoint) it.next();
                if (!(odPoint.odType == null || odPoint.point == null)) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue())).anchor(0.5f, 0.5f).draggable(false).zIndex(102);
                    if (getContext() != null && markerIconResId > 0) {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(getContext(), markerIconResId));
                    }
                    if (getMap() != null) {
                        this.mCurOdMarkers.add(getMap().addMarker(markerOptions));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeOdMarkersOld() {
        for (Marker next : this.mCurOdMarkers) {
            if (getMap() != null) {
                getMap().remove(next);
            }
        }
        this.mCurOdMarkers.clear();
    }

    /* access modifiers changed from: protected */
    public void addOdPointMarkerNew(List<OdPoint> list, boolean z) {
        if (this.mEnableSerialOrderOptimized) {
            this.mMarkerManager.setOdPointMarkerIconStyle(true);
            removeOdMarkersNew();
            if (list != null) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    OdPoint odPoint = (OdPoint) it.next();
                    if (!(odPoint.odType == null || odPoint.point == null)) {
                        this.mNewCurOdMarkers.add(this.mMarkerManager.addMarker(MapElementId.ID_MARKER_ODPOINT, new LatLng((double) odPoint.point.lat.floatValue(), (double) odPoint.point.lng.floatValue()), z));
                    }
                }
                return;
            }
            return;
        }
        this.mMarkerManager.setOdPointMarkerIconStyle(false);
        addOdPointMarkerOld(list);
    }

    /* access modifiers changed from: protected */
    public void removeOdMarkersNew() {
        for (IconLabelMarker next : this.mNewCurOdMarkers) {
            if (next != null) {
                next.destory();
            }
        }
        this.mNewCurOdMarkers.clear();
    }

    /* access modifiers changed from: private */
    public void onFinishFetchingEtaEda(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            setEtaEdaInternal(new EtaEda(i, i2));
            notifyEtaEdaChanged();
            MapAutoBestViewLoop mapAutoBestViewLoop = this.mapAutoBestViewLooper;
            if (mapAutoBestViewLoop != null) {
                mapAutoBestViewLoop.doBestViewImmediately(false);
            }
        }
    }

    private void notifyEtaEdaChanged() {
        this.mHandler.post(new Runnable() {
            public final void run() {
                BasePage.this.lambda$notifyEtaEdaChanged$1$BasePage();
            }
        });
    }

    public /* synthetic */ void lambda$notifyEtaEdaChanged$1$BasePage() {
        ServingParam servingParam = this.mParam;
        if (servingParam != null && servingParam.getEtaEdaCallback() != null) {
            this.mParam.getEtaEdaCallback().onEtaEdaChanged(new EtaEda(getEtaEdaInternal()));
        }
    }

    /* access modifiers changed from: private */
    public synchronized EtaEda getEtaEdaInternal() {
        return this.mEtaEda;
    }

    private synchronized void setEtaEdaInternal(EtaEda etaEda) {
        this.mEtaEda = etaEda;
    }

    /* access modifiers changed from: protected */
    public void doBestView(Padding padding) {
        this.mPadding = padding;
        MapAutoBestViewLoop mapAutoBestViewLoop = this.mapAutoBestViewLooper;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.doBestViewImmediately(true);
        }
    }

    /* access modifiers changed from: protected */
    public Padding getMapInPadding() {
        int dp2px = DisplayUtils.dp2px(getContext(), 10.0f);
        return new Padding(dp2px, DisplayUtils.dp2px(getContext(), 20.0f), dp2px, dp2px);
    }
}
