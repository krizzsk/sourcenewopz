package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.ProjectionUtils;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.EventDescribe;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.carpool.IFetchCarpoolInfo;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.components.RecommendPointView;
import com.didi.map.global.flow.scene.order.serving.components.WalkingLineCompose;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.GuideEntranceMarker;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.toolkit.walkdrop.WalkComponentApolloUtils;
import com.didi.map.global.flow.toolkit.walkdrop.WalkParam;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.google.util.GoogleSyncTripLogUtil;
import com.didi.map.sdk.env.CacheKey;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.sdk.address.address.entity.Address;
import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WaitingForDrivingPage extends BasePage implements OnMarkerClickListener {

    /* renamed from: a */
    private static final String f26937a = "PickupPage";

    /* renamed from: b */
    private static final int f26938b = 5000;

    /* renamed from: c */
    private boolean f26939c = MapFlowApolloUtils.isQuickenOraRequestIntervalNearPickup();

    /* renamed from: d */
    private int f26940d = MapFlowApolloUtils.getOraRequestDistanceNearPickup();

    /* renamed from: e */
    private long f26941e = MapFlowApolloUtils.getOraRequestIntervalNearPickup();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RecommendPointView f26942f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SecRouteInfoEx f26943g;
    protected GuideEntranceMarker guideEntranceMarker;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f26944h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ModifyPickupPointPage f26945i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f26946j = false;

    /* renamed from: k */
    private OrientationListener f26947k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f26948l = false;

    /* renamed from: m */
    private SctxService.SctxCallback f26949m = new SctxService.SctxCallbackAdapter() {
        public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
            boolean z = false;
            if (!WaitingForDrivingPage.this.isSceneValid) {
                DLog.m7384d(WaitingForDrivingPage.f26937a, "onGetOraResult return", new Object[0]);
                return;
            }
            if (!(WaitingForDrivingPage.this.guideEntranceMarker == null || WaitingForDrivingPage.this.mContext == null)) {
                WaitingForDrivingPage.this.guideEntranceMarker.location(LocationHelper.getLastKnownLocation(WaitingForDrivingPage.this.mContext));
            }
            if (WaitingForDrivingPage.this.guideEntranceMarker != null) {
                Marker iconMarker = WaitingForDrivingPage.this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
                if (mapPassengeOrderRouteRes != null && mapPassengeOrderRouteRes.secRouteInfo == null && iconMarker == null) {
                    WaitingForDrivingPage.this.m19005a(mapPassengeOrderRouteRes.routePoints, true);
                } else {
                    WaitingForDrivingPage.this.m19005a(mapPassengeOrderRouteRes.routePoints, false);
                }
            }
            if (!WaitingForDrivingPage.this.f26944h && mapPassengeOrderRouteRes != null && mapPassengeOrderRouteRes.routePoints != null && !CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes.routePoints.dlngs)) {
                boolean unused = WaitingForDrivingPage.this.f26944h = true;
                LatLng point = WaitingForDrivingPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
                if (!(WaitingForDrivingPage.this.mParam == null || point == null || WaitingForDrivingPage.this.mWalkingLine == null)) {
                    WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(point);
                }
            }
            boolean z2 = WaitingForDrivingPage.this.getOrderStage() == 3 && WaitingForDrivingPage.this.bIsDriverArrived;
            if (!(mapPassengeOrderRouteRes == null || mapPassengeOrderRouteRes.driverBluetoothOpen == null || !mapPassengeOrderRouteRes.driverBluetoothOpen.booleanValue())) {
                z = true;
            }
            boolean isSupportStepCountSensor = isSupportStepCountSensor(WaitingForDrivingPage.this.getContext());
            if (MapFlowApolloUtils.enableBluetoothMeetingV2() && z2 && z && isSupportStepCountSensor && !WaitingForDrivingPage.this.f26946j && WaitingForDrivingPage.this.mParam != null && WaitingForDrivingPage.this.mParam.getPassBTMStatusCallback() != null) {
                boolean unused2 = WaitingForDrivingPage.this.f26946j = true;
                WaitingForDrivingPage.this.mParam.getPassBTMStatusCallback().showBTMEntry(true);
            }
        }

        public boolean isSupportStepCountSensor(Context context) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
            if (defaultSensor == null || defaultSensor2 == null) {
                return false;
            }
            return true;
        }

        public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
            WaitingForDrivingPage.this.mo75447a(latLng, latLng2);
        }

        public void showSecRouteInfoCallback(SecRouteInfoEx secRouteInfoEx, boolean z) {
            DLog.m7384d(WaitingForDrivingPage.f26937a, "showSecRouteInfoCallback, show: " + z, new Object[0]);
            WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_RECOMMEND);
            if (z && secRouteInfoEx != null) {
                SecRouteInfoEx unused = WaitingForDrivingPage.this.f26943g = secRouteInfoEx;
                PickupPoint pickupPoint = secRouteInfoEx.getPickupPoint();
                if (pickupPoint != null) {
                    WaitingForDrivingPage.this.mMarkerManager.addMarker(MapElementId.ID_MARKER_RECOMMEND, new LatLng(pickupPoint.lat.doubleValue(), pickupPoint.lng.doubleValue()), false);
                    WaitingForDrivingPage.this.f26942f.showMarkerView(MapElementId.ID_MARKER_RECOMMEND, secRouteInfoEx.getBubMsgV2());
                    if (!(WaitingForDrivingPage.this.mParam == null || WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback() == null)) {
                        DLog.m7384d(WaitingForDrivingPage.f26937a, "show sec route 1", new Object[0]);
                        WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback().showSecRouteInfoCallback(secRouteInfoEx, true);
                    }
                    if (WaitingForDrivingPage.this.mWalkingLine != null) {
                        WaitingForDrivingPage.this.mWalkingLine.setRecommendStyle(true);
                    }
                    Marker iconMarker = WaitingForDrivingPage.this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START);
                    if (iconMarker != null) {
                        LatLng position = iconMarker.getPosition();
                        if (LatLngUtils.locateCorrect(position)) {
                            WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(position);
                        }
                    }
                    WaitingForDrivingPage waitingForDrivingPage = WaitingForDrivingPage.this;
                    waitingForDrivingPage.doBestView(waitingForDrivingPage.mPadding);
                    double d = WaitingForDrivingPage.this.getMap().getCameraPosition().zoom;
                    MapFlowOmegaUtil.showRecommendPoint(secRouteInfoEx.getIncluded(), WaitingForDrivingPage.this.m18998a(secRouteInfoEx.getSepLatLng()), secRouteInfoEx.getBubType(), d);
                }
            }
            if (!z) {
                if (!(WaitingForDrivingPage.this.mParam == null || WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback() == null)) {
                    DLog.m7384d(WaitingForDrivingPage.f26937a, "dismiss sec route 2", new Object[0]);
                    WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback().showSecRouteInfoCallback(secRouteInfoEx, false);
                }
                if (WaitingForDrivingPage.this.mWalkingLine != null) {
                    WaitingForDrivingPage.this.mWalkingLine.setRecommendStyle(false);
                }
                WaitingForDrivingPage.this.f26950n.cancelPickupPointRecommend();
            }
        }

        public void selectedPickupPoint(LatLng latLng) {
            DLog.m7384d(WaitingForDrivingPage.f26937a, "selectedPickupPoint, point: %s" + GoogleSyncTripLogUtil.getLatLngLogInfo(latLng), new Object[0]);
            if (latLng != null && WaitingForDrivingPage.this.mMarkerManager != null) {
                Marker iconMarker = WaitingForDrivingPage.this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START);
                Marker iconMarker2 = WaitingForDrivingPage.this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
                if (iconMarker != null && iconMarker2 != null) {
                    LatLng position = iconMarker.getPosition();
                    LatLng position2 = iconMarker2.getPosition();
                    if (position2 != null && position2.equals(latLng)) {
                        WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(position2);
                        if (WaitingForDrivingPage.this.f26943g != null) {
                            int a = WaitingForDrivingPage.this.m18998a(WaitingForDrivingPage.this.f26943g.getSepLatLng());
                            double d = WaitingForDrivingPage.this.getMap().getCameraPosition().zoom;
                            int included = WaitingForDrivingPage.this.f26943g.getIncluded();
                            boolean isNewVersion = WaitingForDrivingPage.this.mParam.isNewVersion();
                            MapFlowOmegaUtil.onSctxLineChoose(included, isNewVersion ? 1 : 0, a, WaitingForDrivingPage.this.f26943g.getBubType(), d);
                            return;
                        }
                        DLog.m7384d(WaitingForDrivingPage.f26937a, "selectedPickupPoint, mSecRouteinfoEx is null", new Object[0]);
                    } else if (position != null && position.equals(latLng)) {
                        WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(position);
                    }
                }
            }
        }

        public void goingOffCourse() {
            DLog.m7384d(WaitingForDrivingPage.f26937a, "goingOffCourse", new Object[0]);
            if (WaitingForDrivingPage.this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START) != null) {
                if (!(WaitingForDrivingPage.this.mParam == null || WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback() == null)) {
                    DLog.m7384d(WaitingForDrivingPage.f26937a, "dismiss sec route 1", new Object[0]);
                    WaitingForDrivingPage.this.mParam.getSecRouteInfoCallback().showSecRouteInfoCallback((SecRouteInfoEx) null, false);
                }
                if (!(WaitingForDrivingPage.this.mParam == null || WaitingForDrivingPage.this.mParam.getEventCallback() == null)) {
                    WaitingForDrivingPage.this.mParam.getEventCallback().onEventCallback(EventDescribe.RecommendPickupDismissTips, (String) null);
                }
                WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_RECOMMEND);
                LatLng point = WaitingForDrivingPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
                if (!(WaitingForDrivingPage.this.mParam == null || point == null || WaitingForDrivingPage.this.mWalkingLine == null)) {
                    WaitingForDrivingPage.this.mWalkingLine.setRecommendStyle(false);
                    WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(point);
                }
                WaitingForDrivingPage waitingForDrivingPage = WaitingForDrivingPage.this;
                waitingForDrivingPage.doBestView(waitingForDrivingPage.mPadding);
            }
        }
    };
    protected WalkingLineCompose mWalkingLine;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public IServingController f26950n = new IServingController() {
        public /* synthetic */ void animateCamera(CameraPosition cameraPosition, int i, CancelableCallback cancelableCallback) {
            IServingController.CC.$default$animateCamera(this, cameraPosition, i, cancelableCallback);
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

        public /* synthetic */ void modifyDestination(LatLng latLng) {
            IServingController.CC.$default$modifyDestination(this, latLng);
        }

        public /* synthetic */ void onPushMsgReceived(byte[] bArr) {
            IServingController.CC.$default$onPushMsgReceived(this, bArr);
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

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view);
        }

        public /* synthetic */ void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position) {
            IServingController.CC.$default$updateMarkerBubble(this, mapElementId, view, position);
        }

        public void onOrderStateChanged(int i, ServingParam servingParam) {
            DLog.m7384d(WaitingForDrivingPage.f26937a, "order state changed = " + i, new Object[0]);
            if (servingParam != null) {
                WaitingForDrivingPage.this.mParam = servingParam;
            }
            WaitingForDrivingPage.this.f26942f.hideIconMarkerBubble();
            if (!(i == 2 || i == 3 || i == 4)) {
                if (WaitingForDrivingPage.this.mMarkerManager != null) {
                    WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
                }
                if (WaitingForDrivingPage.this.mSctxCarpoolMgr != null) {
                    WaitingForDrivingPage.this.mSctxCarpoolMgr.destroy();
                }
                WaitingForDrivingPage.this.initPassengerSctx();
                WaitingForDrivingPage.this.mPassengerSctx.enter();
            }
            if (WaitingForDrivingPage.this.guideEntranceMarker != null) {
                WaitingForDrivingPage.this.guideEntranceMarker.onOrderStateChanged(i);
            }
            if (i != 0 && i != 1 && WaitingForDrivingPage.this.mWalkingLine != null) {
                WaitingForDrivingPage.this.mWalkingLine.destroy();
                WaitingForDrivingPage.this.mWalkingLine = null;
            }
        }

        public void onStartChangedForSharer(GuideStartInfo guideStartInfo) {
            if (WaitingForDrivingPage.this.mParam != null && guideStartInfo != null) {
                ServingParam servingParam = WaitingForDrivingPage.this.mParam;
                boolean z = servingParam.bReadOnly() && !TextUtils.isEmpty(guideStartInfo.startPoiId) && !WaitingForDrivingPage.this.mMarkerManager.getPoiId(MapElementId.ID_MARKER_START).equals(guideStartInfo.startPoiId);
                if (guideStartInfo != null && z) {
                    WaitingForDrivingPage.this.mMarkerManager.setPoiId(MapElementId.ID_MARKER_START, guideStartInfo.startPoiId);
                    WaitingForDrivingPage.this.mMarkerManager.setPoint(MapElementId.ID_MARKER_START, guideStartInfo.startPosition);
                    WaitingForDrivingPage.this.mMarkerManager.setAddressName(MapElementId.ID_MARKER_START, guideStartInfo.startAddressName);
                    servingParam.getOrderParams().srcTag = guideStartInfo.srcTag;
                    servingParam.getOrderParams().stationWalkGuidePhoto = guideStartInfo.stationWalkGuidePhoto;
                    servingParam.getOrderParams().stationWalkGuideLink = guideStartInfo.stationWalkGuideLink;
                    if (WaitingForDrivingPage.this.guideEntranceMarker != null) {
                        CommonMarkerParam markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START);
                        LatLng latLng = null;
                        if (markerParam != null) {
                            latLng = markerParam.getPoint();
                        }
                        WaitingForDrivingPage.this.guideEntranceMarker.update(servingParam, latLng);
                    }
                }
                if (servingParam.bReadOnly() && WaitingForDrivingPage.this.mParam.isNewVersion() && guideStartInfo != null && guideStartInfo.startPosition != null) {
                    WaitingForDrivingPage.this.refreshStartPointMarker(guideStartInfo.startPosition, false);
                    if (WaitingForDrivingPage.this.mWalkingLine != null) {
                        WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(guideStartInfo.startPosition);
                    }
                }
            }
        }

        public void updatePickupPoint(LatLng latLng) {
            if (WaitingForDrivingPage.this.mMarkerManager != null) {
                WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_RECOMMEND);
                WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_START);
                WaitingForDrivingPage.this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, latLng, !WaitingForDrivingPage.this.mParam.isNewVersion());
            }
            if (WaitingForDrivingPage.this.mWalkingLine != null) {
                WaitingForDrivingPage.this.mWalkingLine.setRecommendStyle(false);
                WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(latLng);
            }
            if (WaitingForDrivingPage.this.f26943g != null) {
                WaitingForDrivingPage.this.f26942f.showMarkerView(MapElementId.ID_MARKER_START, WaitingForDrivingPage.this.f26943g.getBubNewPPMsg());
                MapFlowOmegaUtil.useRecommendPoint(WaitingForDrivingPage.this.f26943g.getBubType());
            }
            if (WaitingForDrivingPage.this.guideEntranceMarker != null) {
                WaitingForDrivingPage.this.guideEntranceMarker.updateDestinationPosition(latLng);
            }
            doBestView(WaitingForDrivingPage.this.mPadding);
            DLog.m7384d(WaitingForDrivingPage.f26937a, "updatePickupPoint, point: " + latLng.toString(), new Object[0]);
        }

        public void cancelPickupPointRecommend() {
            DLog.m7384d(WaitingForDrivingPage.f26937a, "cancelPickupPointRecommend", new Object[0]);
            if (WaitingForDrivingPage.this.mPassengerSctx != null) {
                WaitingForDrivingPage.this.mPassengerSctx.cancelPickupPointRecommend();
            }
            WaitingForDrivingPage.this.mMarkerManager.removeMarker(MapElementId.ID_MARKER_RECOMMEND);
            LatLng point = WaitingForDrivingPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
            if (!(WaitingForDrivingPage.this.mParam == null || point == null || WaitingForDrivingPage.this.mWalkingLine == null)) {
                WaitingForDrivingPage.this.mWalkingLine.setRecommendStyle(false);
                WaitingForDrivingPage.this.mWalkingLine.updateWalkingLine(point);
            }
            doBestView(WaitingForDrivingPage.this.mPadding);
        }

        public void startModifyPickupLocation(Address address, Address address2, float f, ILocationCallback iLocationCallback) {
            if (WaitingForDrivingPage.this.mWalkingLine != null) {
                DLog.m7384d(WaitingForDrivingPage.f26937a, "启动修改上车点，销毁路线", new Object[0]);
                WaitingForDrivingPage.this.mWalkingLine.destroy();
                WaitingForDrivingPage.this.mWalkingLine = null;
            }
            if (WaitingForDrivingPage.this.f26945i == null) {
                WaitingForDrivingPage waitingForDrivingPage = WaitingForDrivingPage.this;
                ModifyPickupPointPage unused = waitingForDrivingPage.f26945i = new ModifyPickupPointPage(waitingForDrivingPage);
                WaitingForDrivingPage.this.f26945i.startModifyPickupLocation(address, address2, f, iLocationCallback);
            }
        }

        public void stopModifyPickupLocation(LatLng latLng) {
            if (WaitingForDrivingPage.this.f26945i != null) {
                WaitingForDrivingPage.this.f26945i.stopModifyPickupLocation(latLng);
                ModifyPickupPointPage unused = WaitingForDrivingPage.this.f26945i = null;
            }
        }
    };
    protected long pickupSctxIntervalMillis = MapFlowApolloUtils.getPickupSctxIntervalMillis();

    /* access modifiers changed from: protected */
    public boolean enableBgOraService() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean enableBluetoothNotify() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getOrderStage() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public boolean needAddSerialOrderPassPointMarker() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showOdPoints() {
        return false;
    }

    public WaitingForDrivingPage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(pageScene, servingParam, mapViewHolder);
        this.f26942f = new RecommendPointView(getContext(), mapViewHolder.getMapView().getMap(), this.mMarkerManager);
    }

    public void enter(boolean z) {
        Marker iconMarker;
        LatLng latLng = null;
        PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, (Object) null);
        super.enter(true);
        setServingController(this.f26950n);
        setSctxCallback(this.f26949m);
        if (this.mParam != null) {
            this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, !this.mParam.isNewVersion());
        }
        if (!(this.mParam == null || !this.mParam.showGuideEntrance() || (iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START)) == null)) {
            latLng = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
            GuideEntranceMarker guideEntranceMarker2 = new GuideEntranceMarker(this.mMapView.getMapView(), iconMarker, latLng, this.mParam);
            this.guideEntranceMarker = guideEntranceMarker2;
            guideEntranceMarker2.sceneValid = true;
        }
        DLog.m7384d("GuideXXX", "enter: \n" + Log.getStackTraceString(new Throwable()), new Object[0]);
        if (!(this.mParam == null || this.mParam.getOrderParams() == null)) {
            WalkParam walkParam = new WalkParam();
            walkParam.setCallFromm(CallFrom.ORDERROUTEAPI);
            walkParam.setAnimate(true);
            walkParam.setProductId(this.mParam.getOrderParams().productID);
            walkParam.setSrcTag(this.mParam.getOrderParams().srcTag);
            walkParam.setOrderId(this.mParam.getOrderParams().orderId);
            walkParam.setDriverId(this.mParam.getOrderParams().driverId);
            walkParam.setEndPoint(latLng);
            this.mWalkingLine = new WalkingLineCompose(getContext(), getMap(), walkParam);
        }
        if (this.mMapView != null && WalkComponentApolloUtils.isUseNewComponent(this.mContext, latLng)) {
            this.mMapView.setLocationVisible(false);
        }
        m19002a();
        m19008b();
        OrderFloatWindowManager.Instance().setServingParam(this.mParam);
        OrderFloatWindowManager.Instance().setTripStage(getOrderStage());
        OrderFloatWindowManager.Instance().setMapSdkType(OrderFloatWindowManager.getMapSdkType(getMap()));
        OrderFloatWindowManager.Instance().setPageScene(PageSceneID.PAGE_PICKUP);
    }

    public void leave() {
        super.leave();
        if (this.mMarkerManager != null) {
            this.mMarkerManager.destroy();
        }
        m19015d();
        if (!(this.mMapView == null || this.mMapView.getMapView() == null || this.mMapView.getMapView().getMap() == null)) {
            this.mMapView.getMapView().getMap().removeOnMarkerClickListener(this);
        }
        DLog.m7384d("GuideXXX", "leave: \n" + Log.getStackTraceString(new Throwable()), new Object[0]);
        WalkingLineCompose walkingLineCompose = this.mWalkingLine;
        if (walkingLineCompose != null) {
            walkingLineCompose.destroy();
            this.mWalkingLine = null;
        }
        m19012c();
        OrderFloatWindowManager.Instance().setServingParam((ServingParam) null);
        OrderFloatWindowManager.Instance().setPageScene(PageSceneID.PAGE_NONE);
    }

    /* renamed from: a */
    private void m19002a() {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.mMapView.getMapView().getMap() != null) {
            this.mMapView.getMapView().getMap().addOnMarkerClickListener(this);
        }
    }

    /* renamed from: b */
    private void m19008b() {
        if (getContext() != null && getMap() != null && !this.f26948l) {
            this.f26947k = new OrientationListener() {
                public void onOrientationChanged(float f, float f2, float f3) {
                    String str;
                    String str2;
                    if (!WaitingForDrivingPage.this.f26948l) {
                        if (WaitingForDrivingPage.this.mMapView == null || WaitingForDrivingPage.this.mMapView.getMapView() == null || WaitingForDrivingPage.this.mMapView.getMapView().getMapVendor() == null) {
                            str = "";
                        } else {
                            str = WaitingForDrivingPage.this.mMapView.getMapView().getMapVendor().toString();
                        }
                        if (WaitingForDrivingPage.this.mParam == null || WaitingForDrivingPage.this.mParam.getOrderParams() == null) {
                            str2 = "";
                        } else {
                            str2 = WaitingForDrivingPage.this.mParam.getOrderParams().orderId;
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            MapFlowOmegaUtil.orientationEnableOmega(str2, "" + str);
                            boolean unused = WaitingForDrivingPage.this.f26948l = true;
                            WaitingForDrivingPage.this.m19012c();
                        }
                    }
                }
            };
            OrientationManager.getInstance(this.mContext).addOrientationListener(this.f26947k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19012c() {
        if (this.f26947k != null && getContext() != null) {
            OrientationManager.getInstance(getContext()).removeOrientationListener(this.f26947k);
            this.f26947k = null;
        }
    }

    public boolean onMarkerClick(Marker marker) {
        if (marker == null) {
            return false;
        }
        Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START);
        Marker iconMarker2 = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
        if (iconMarker == marker || !(iconMarker == null || iconMarker.getInfoWindow() == null || iconMarker.getInfoWindow().getInfoWindowMarker() != marker)) {
            this.mPassengerSctx.chooseLine(1);
        } else if (iconMarker2 == marker || !(iconMarker2 == null || iconMarker2.getInfoWindow() == null || iconMarker2.getInfoWindow().getInfoWindowMarker() != marker)) {
            this.mPassengerSctx.chooseLine(2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void doSceneBestView(Padding padding, boolean z) {
        ModifyPickupPointPage modifyPickupPointPage = this.f26945i;
        if (modifyPickupPointPage != null) {
            modifyPickupPointPage.doSceneBestView(padding, z);
        } else if (this.f26942f.getRecommendStartIconMarker() != null) {
            m19003a(padding, z);
        } else {
            m19009b(padding, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo75447a(LatLng latLng, LatLng latLng2) {
        boolean z;
        WalkingLineCompose walkingLineCompose;
        if (!this.mParam.bReadOnly() || !this.mParam.isNewVersion()) {
            if (this.mParam.isNewVersion()) {
                z = refreshStartPointMarker(latLng2, false);
            } else {
                z = refreshStartPointMarker(latLng2, true);
            }
            DLog.m7384d(f26937a, "refreshStartEndMarker start=" + latLng.toString() + ",end=" + latLng2.toString(), new Object[0]);
            if (z && (walkingLineCompose = this.mWalkingLine) != null) {
                walkingLineCompose.updateWalkingLine(latLng2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public long getOraRequestIntervalMillis() {
        String str;
        LatLng driverPoint;
        LatLng point;
        long j = this.pickupSctxIntervalMillis;
        if (!this.f26939c || this.mPassengerSctx == null || (driverPoint = this.mPassengerSctx.getDriverPoint()) == null || (point = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START)) == null || DDSphericalUtil.computeDistanceBetween(driverPoint, point) >= ((double) this.f26940d)) {
            str = "正常轮训间隔";
        } else {
            j = this.f26941e;
            str = "临近上车点轮训间隔";
        }
        DLog.m7384d(f26937a, "接驾段当前Ora轮训间隔:%dms(%s)", Long.valueOf(j), str);
        return j;
    }

    /* renamed from: a */
    private void m19003a(Padding padding, boolean z) {
        List<IMapElement> myLocationMarkers;
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            ArrayList arrayList = new ArrayList();
            if (!(this.mMapView == null || (myLocationMarkers = this.mMapView.getMyLocationMarkers()) == null)) {
                arrayList.addAll(myLocationMarkers);
            }
            List<IMapElement> makerMapElements = this.mMarkerManager.getMakerMapElements(MapElementId.ID_MARKER_START);
            if (!CollectionUtil.isEmpty((Collection<?>) makerMapElements)) {
                arrayList.addAll(makerMapElements);
            }
            List<IMapElement> recommendMakerElements = this.f26942f.getRecommendMakerElements();
            if (!CollectionUtil.isEmpty((Collection<?>) recommendMakerElements)) {
                arrayList.addAll(recommendMakerElements);
            }
            boolean z2 = false;
            if (this.mapAutoBestViewLooper != null) {
                z2 = this.mapAutoBestViewLooper.doBestViewExecute(arrayList, this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START), padding, mapInPadding, z);
            } else {
                DLog.m7384d(f26937a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                this.mScene.hideResetView();
            }
        }
    }

    /* renamed from: b */
    private void m19009b(Padding padding, boolean z) {
        List<IMapElement> myLocationMarkers;
        LatLng point;
        if (this.isSceneValid) {
            Padding mapInPadding = getMapInPadding();
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            if (!this.mParam.bReadOnly()) {
                boolean z3 = true;
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                if (!(lastKnownLocation == null || (point = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START)) == null || DDSphericalUtil.computeHeading(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), point) <= 5000.0d)) {
                    z3 = false;
                }
                if (!(!z3 || this.mMapView == null || (myLocationMarkers = this.mMapView.getMyLocationMarkers()) == null)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            GuideEntranceMarker guideEntranceMarker2 = this.guideEntranceMarker;
            if (!(guideEntranceMarker2 == null || guideEntranceMarker2.getMarker() == null)) {
                arrayList.add(this.guideEntranceMarker.getMarker());
            }
            List<IMapElement> makerMapElements = this.mMarkerManager.getMakerMapElements(MapElementId.ID_MARKER_START);
            if (!CollectionUtil.isEmpty((Collection<?>) makerMapElements)) {
                arrayList.addAll(makerMapElements);
            }
            WalkingLineCompose walkingLineCompose = this.mWalkingLine;
            if (walkingLineCompose != null && !CollectionUtil.isEmpty((Collection<?>) walkingLineCompose.getBestViewElements())) {
                arrayList.addAll(this.mWalkingLine.getBestViewElements());
            }
            if (this.mParam.getOrderParams() != null) {
                CarMarker carMarker = this.mPassengerSctx.getCarMarker();
                if (!(carMarker == null || carMarker.getMarker() == null)) {
                    arrayList.add(carMarker.getMarker());
                }
                Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_WAYPOINT);
                if (iconMarker != null) {
                    arrayList.add(iconMarker);
                }
                Marker labelMarker = this.mMarkerManager.getLabelMarker(MapElementId.ID_MARKER_WAYPOINT);
                if (labelMarker != null) {
                    arrayList.add(labelMarker);
                }
            }
            List<IMapElement> sctxWayPoints = getSctxWayPoints();
            if (!CollectionUtil.isEmpty((Collection<?>) sctxWayPoints)) {
                arrayList.addAll(sctxWayPoints);
            }
            List<IMapElement> routeElements = getRouteElements();
            if (routeElements != null) {
                arrayList.addAll(routeElements);
            }
            if (!(this.mPassengerSctx == null || this.mPassengerSctx.getLines() == null)) {
                arrayList.addAll(this.mPassengerSctx.getLines());
            }
            if (this.mapAutoBestViewLooper != null) {
                z2 = this.mapAutoBestViewLooper.doBestViewExecute(arrayList, padding, mapInPadding, z);
            } else {
                DLog.m7384d(f26937a, "doSceneBestView, mBestViewFilter is null", new Object[0]);
            }
            if (z2) {
                this.mScene.hideResetView();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19005a(DiffGeoPoints diffGeoPoints, boolean z) {
        GuideEntranceMarker guideEntranceMarker2;
        GuideEntranceMarker guideEntranceMarker3 = this.guideEntranceMarker;
        if (guideEntranceMarker3 != null) {
            guideEntranceMarker3.setVisible(z);
        }
        if (!(!z || (guideEntranceMarker2 = this.guideEntranceMarker) == null || guideEntranceMarker2.getMarker() == null)) {
            this.f26942f.hideIconMarkerBubble();
        }
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(diffGeoPoints);
        if (!latLngListFromDiffGeoPoints.isEmpty()) {
            boolean z2 = true;
            LatLngBounds build = new LatLngBounds.Builder().include(latLngListFromDiffGeoPoints).build();
            LatLng latLng = build.northeast;
            LatLng latLng2 = build.southwest;
            LatLng point = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
            Projection projection = getMap().getProjection();
            PointF screenLocation = projection.toScreenLocation(latLng);
            PointF screenLocation2 = projection.toScreenLocation(latLng2);
            PointF screenLocation3 = projection.toScreenLocation(point);
            if (screenLocation3.x - screenLocation2.x > screenLocation.x - screenLocation3.x) {
                z2 = false;
            }
            GuideEntranceMarker guideEntranceMarker4 = this.guideEntranceMarker;
            if (guideEntranceMarker4 != null) {
                guideEntranceMarker4.updateBubbleDirection(z2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasGuideEntrance() {
        GuideEntranceMarker guideEntranceMarker2 = this.guideEntranceMarker;
        if (guideEntranceMarker2 != null) {
            return guideEntranceMarker2.isShowed();
        }
        return false;
    }

    /* renamed from: d */
    private void m19015d() {
        GuideEntranceMarker guideEntranceMarker2 = this.guideEntranceMarker;
        if (guideEntranceMarker2 != null) {
            guideEntranceMarker2.sceneValid = false;
            this.guideEntranceMarker.destroy();
            this.guideEntranceMarker = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m18998a(LatLng latLng) {
        if (!(latLng == null || this.mPadding == null)) {
            try {
                return ProjectionUtils.isLatLngInRect(getMap().getProjection(), new Rect(this.mPadding.left, this.mPadding.top, getContext().getResources().getDisplayMetrics().widthPixels - this.mPadding.right, getContext().getResources().getDisplayMetrics().heightPixels - this.mPadding.bottom), latLng) ? 1 : 0;
            } catch (Exception e) {
                DLog.m7384d(f26937a, "isLatLngInScreen, exception:" + e.getLocalizedMessage(), new Object[0]);
                e.printStackTrace();
            }
        }
        return 0;
    }
}
