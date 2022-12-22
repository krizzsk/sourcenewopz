package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.content.Context;
import android.graphics.PointF;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.SystemUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.toolkit.walkdrop.WalkComponentApolloUtils;
import com.didi.map.global.flow.toolkit.walkdrop.WalkParam;
import com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 1009)
public class LockScreenSctxScene extends BaseScene {
    public LockScreenSctxScene(ServingParam servingParam, MapViewHolder mapViewHolder) {
        super(servingParam, mapViewHolder);
        this.mPage = new LockScreenSctxPage(this, servingParam, mapViewHolder);
    }

    private static class LockScreenSctxPage extends BasePage {
        private static final int MAX_DISTANCE_BETWEEN_LOCATION_AND_DEPARTURE = 5000;
        private static final String TAG = "LockScreenSctxScene";
        private static boolean isUseGesture = false;
        private static boolean isUseNewInterval = true;
        private static long lockscreenRequestInterval = 1000;
        private boolean bIsQuickenOraRequestIntervalNearPickup = MapFlowApolloUtils.isQuickenOraRequestIntervalNearPickup();
        private List<IMapElement> latLngs = new ArrayList();
        /* access modifiers changed from: private */
        public boolean mHasLine;
        private List<Marker> mMarkerList = new ArrayList();
        private int mOraRequestDistanceNearPickup = MapFlowApolloUtils.getOraRequestDistanceNearPickup();
        private long mOraRequestIntervalNearPickup = MapFlowApolloUtils.getOraRequestIntervalNearPickup();
        private SctxService.SctxCallback mSctxCallback = new SctxService.SctxCallbackAdapter() {
            public void onSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (!LockScreenSctxPage.this.mHasLine && mapPassengeOrderRouteRes != null && mapPassengeOrderRouteRes.routePoints != null && !CollectionUtil.isEmpty((Collection<?>) mapPassengeOrderRouteRes.routePoints.dlngs)) {
                    boolean unused = LockScreenSctxPage.this.mHasLine = true;
                    LatLng point = LockScreenSctxPage.this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
                    if (LockScreenSctxPage.this.mParam != null && point != null && LockScreenSctxPage.this.mWalkingLine != null) {
                        LockScreenSctxPage.this.mWalkingLine.updateWalkingLine(point);
                    }
                }
            }

            public void onStartDestinationUpdate(LatLng latLng, LatLng latLng2) {
                LockScreenSctxPage.this.refreshStartPointMarker(latLng, true);
                LockScreenSctxPage.this.refreshEndPointMarker(latLng2, true);
            }
        };
        /* access modifiers changed from: private */
        public WalkingLineManager mWalkingLine;
        protected long pickupSctxIntervalMillis = MapFlowApolloUtils.getPickupSctxIntervalMillis();

        /* access modifiers changed from: protected */
        public boolean enableBgOraService() {
            return true;
        }

        /* access modifiers changed from: protected */
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

        public LockScreenSctxPage(PageScene pageScene, ServingParam servingParam, MapViewHolder mapViewHolder) {
            super(pageScene, servingParam, mapViewHolder);
        }

        public void enter(boolean z) {
            CommonMarkerParam commonMarkerParam;
            super.enter(true);
            setSctxCallback(this.mSctxCallback);
            this.mMarkerManager.addMarker(MapElementId.ID_MARKER_START, false);
            this.mPadding = new Padding(20, 20, 20, 0);
            if (!(isUseGesture || getMap() == null || getMap().getUiSettings() == null)) {
                getMap().getUiSettings().setAllGesturesEnabled(false);
                getMap().getUiSettings().setZoomEnabled(false);
            }
            DLog.m7384d(TAG, "is Use Map Gesture: " + isUseGesture, new Object[0]);
            LatLng latLng = null;
            if (!(this.mParam == null || this.mParam.getMarkerParams() == null || (commonMarkerParam = this.mParam.getMarkerParams().get(MapElementId.ID_MARKER_START)) == null)) {
                latLng = commonMarkerParam.getPoint();
            }
            if (!(this.mParam == null || this.mParam.getOrderParams() == null)) {
                WalkParam walkParam = new WalkParam();
                walkParam.setCallFromm(CallFrom.ORDERROUTEAPI);
                walkParam.setAnimate(true);
                walkParam.setProductId(this.mParam.getOrderParams().productID);
                walkParam.setSrcTag(this.mParam.getOrderParams().srcTag);
                walkParam.setOrderId(this.mParam.getOrderParams().orderId);
                walkParam.setDriverId(this.mParam.getOrderParams().driverId);
                walkParam.setEndPoint(latLng);
                this.mWalkingLine = new WalkingLineManager(getContext(), getMap(), walkParam);
            }
            if (this.mMapView != null && WalkComponentApolloUtils.isUseNewComponent(this.mContext, latLng)) {
                this.mMapView.setLocationVisible(false);
            }
        }

        public void leave() {
            this.mMarkerManager.destroy();
            WalkingLineManager walkingLineManager = this.mWalkingLine;
            if (walkingLineManager != null) {
                walkingLineManager.destroy();
                this.mWalkingLine = null;
            }
            super.leave();
        }

        /* access modifiers changed from: protected */
        public long getOraRequestIntervalMillis() {
            long j = this.pickupSctxIntervalMillis;
            String str = "正常轮训间隔";
            if (isUseNewInterval) {
                j = lockscreenRequestInterval;
            } else if (this.bIsQuickenOraRequestIntervalNearPickup && this.mPassengerSctx != null) {
                LatLng driverPoint = this.mPassengerSctx.getDriverPoint();
                LatLng point = this.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
                if (!(driverPoint == null || point == null || DDSphericalUtil.computeDistanceBetween(driverPoint, point) >= ((double) this.mOraRequestDistanceNearPickup))) {
                    j = this.mOraRequestIntervalNearPickup;
                    str = "临近上车点轮训间隔";
                }
            }
            DLog.m7384d(TAG, "接驾段当前Ora轮训间隔:%dms(%s)", Long.valueOf(j), str);
            return j;
        }

        /* access modifiers changed from: protected */
        public List<IMapElement> getRouteElements() {
            return super.getRouteElements();
        }

        private void checkAndSetPadding() {
            this.latLngs.clear();
            this.mMarkerList.clear();
            Marker iconMarker = this.mMarkerManager.getIconMarker(MapElementId.ID_MARKER_START);
            if (iconMarker != null) {
                this.latLngs.add(iconMarker);
                this.mMarkerList.add(iconMarker);
            }
            CarMarker carMarker = this.mPassengerSctx.getCarMarker();
            if (!(carMarker == null || carMarker.getMarker() == null)) {
                this.latLngs.add(carMarker.getMarker());
                this.mMarkerList.add(carMarker.getMarker());
            }
            if (!(getMap() == null || getMap().getUiSettings() == null)) {
                getMap().getUiSettings().setLogoVisibility(4);
            }
            this.mPadding.bottom = DisplayUtils.dp2px(getContext(), 10.0f);
            this.mPadding.right = DisplayUtils.dp2px(getContext(), 10.0f);
            this.mPadding.left = DisplayUtils.dp2px(getContext(), 10.0f);
            this.mPadding.top = DisplayUtils.dp2px(getContext(), 10.0f);
            if (getMap() != null && getMap().getMapVendor() != MapVendor.DIDI) {
                LatLngBounds.Builder builder = LatLngBounds.builder();
                if (iconMarker != null) {
                    builder.include(iconMarker.getPosition());
                }
                if (!(carMarker == null || carMarker.getMarker() == null)) {
                    builder.include(carMarker.getMarker().getPosition());
                }
                LatLngBounds build = builder.build();
                Padding markerBounders = getMarkerBounders(getContext(), build, this.mMarkerList, getMap().calculateZoomToSpanLevel(build.northeast, build.southwest));
                this.mPadding.top = markerBounders.top;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
            r6 = r12.mMarkerManager.getPoint(com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doSceneBestView(com.didi.common.map.model.Padding r13, boolean r14) {
            /*
                r12 = this;
                boolean r0 = r12.isSceneValid
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                r12.checkAndSetPadding()
                com.didi.common.map.model.Padding r0 = r12.getMapInPadding()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                com.didi.map.global.flow.scene.order.serving.param.ServingParam r2 = r12.mParam
                boolean r2 = r2.bReadOnly()
                java.lang.String r3 = "LockScreenSctxScene"
                r4 = 0
                if (r2 != 0) goto L_0x006c
                android.content.Context r2 = r12.getContext()
                com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = com.didi.map.global.model.location.LocationHelper.getLastKnownLocation(r2)
                r5 = 1
                if (r2 == 0) goto L_0x004d
                com.didi.map.global.flow.scene.order.serving.components.MarkerManager r6 = r12.mMarkerManager
                com.didi.map.global.flow.scene.param.MapElementId r7 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
                com.didi.common.map.model.LatLng r6 = r6.getPoint(r7)
                if (r6 == 0) goto L_0x004d
                com.didi.common.map.model.LatLng r7 = new com.didi.common.map.model.LatLng
                double r8 = r2.getLatitude()
                double r10 = r2.getLongitude()
                r7.<init>((double) r8, (double) r10)
                double r6 = com.didi.common.map.util.DDSphericalUtil.computeHeading(r7, r6)
                r8 = 4662219572839972864(0x40b3880000000000, double:5000.0)
                int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r2 <= 0) goto L_0x004d
                r2 = 0
                goto L_0x004e
            L_0x004d:
                r2 = 1
            L_0x004e:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
                r5[r4] = r6
                java.lang.String r6 = "BestView：本次是否需要包含定位点:%s"
                com.didi.common.map.util.DLog.m7384d(r3, r6, r5)
                if (r2 == 0) goto L_0x006c
                com.didi.map.global.component.mapviewholder.MapViewHolder r2 = r12.mMapView
                if (r2 == 0) goto L_0x006c
                com.didi.map.global.component.mapviewholder.MapViewHolder r2 = r12.mMapView
                java.util.List r2 = r2.getMyLocationMarkers()
                if (r2 == 0) goto L_0x006c
                r1.addAll(r2)
            L_0x006c:
                com.didi.map.global.flow.scene.order.serving.components.MarkerManager r2 = r12.mMarkerManager
                com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
                java.util.List r2 = r2.getMakerMapElements(r5)
                boolean r5 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r2)
                if (r5 != 0) goto L_0x007d
                r1.addAll(r2)
            L_0x007d:
                com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager r2 = r12.mWalkingLine
                if (r2 == 0) goto L_0x0094
                java.util.List r2 = r2.getWalkLine()
                boolean r2 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r2)
                if (r2 != 0) goto L_0x0094
                com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager r2 = r12.mWalkingLine
                java.util.List r2 = r2.getWalkLine()
                r1.addAll(r2)
            L_0x0094:
                com.didi.map.global.flow.scene.order.serving.param.ServingParam r2 = r12.mParam
                com.didi.map.global.flow.scene.order.serving.param.OrderParams r2 = r2.getOrderParams()
                if (r2 == 0) goto L_0x00cb
                com.didi.map.global.flow.toolkit.sctx.PassengerSctx r2 = r12.mPassengerSctx
                com.didi.map.sdk.nav.car.CarMarker r2 = r2.getCarMarker()
                if (r2 == 0) goto L_0x00b1
                com.didi.common.map.model.Marker r5 = r2.getMarker()
                if (r5 == 0) goto L_0x00b1
                com.didi.common.map.model.Marker r2 = r2.getMarker()
                r1.add(r2)
            L_0x00b1:
                com.didi.map.global.flow.scene.order.serving.components.MarkerManager r2 = r12.mMarkerManager
                com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
                com.didi.common.map.model.Marker r2 = r2.getIconMarker(r5)
                if (r2 == 0) goto L_0x00be
                r1.add(r2)
            L_0x00be:
                com.didi.map.global.flow.scene.order.serving.components.MarkerManager r2 = r12.mMarkerManager
                com.didi.map.global.flow.scene.param.MapElementId r5 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
                com.didi.common.map.model.Marker r2 = r2.getLabelMarker(r5)
                if (r2 == 0) goto L_0x00cb
                r1.add(r2)
            L_0x00cb:
                java.util.List r2 = r12.getRouteElements()
                if (r2 == 0) goto L_0x00d4
                r1.addAll(r2)
            L_0x00d4:
                com.didi.map.global.flow.toolkit.sctx.PassengerSctx r2 = r12.mPassengerSctx
                if (r2 == 0) goto L_0x00e9
                com.didi.map.global.flow.toolkit.sctx.PassengerSctx r2 = r12.mPassengerSctx
                java.util.List r2 = r2.getLines()
                if (r2 == 0) goto L_0x00e9
                com.didi.map.global.flow.toolkit.sctx.PassengerSctx r2 = r12.mPassengerSctx
                java.util.List r2 = r2.getLines()
                r1.addAll(r2)
            L_0x00e9:
                com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop r2 = r12.mapAutoBestViewLooper
                if (r2 == 0) goto L_0x00f4
                com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop r2 = r12.mapAutoBestViewLooper
                boolean r4 = r2.doBestViewExecute(r1, r13, r0, r14)
                goto L_0x00fb
            L_0x00f4:
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.String r14 = "doSceneBestView, mBestViewFilter is null"
                com.didi.common.map.util.DLog.m7384d(r3, r14, r13)
            L_0x00fb:
                if (r4 == 0) goto L_0x0102
                com.didi.map.global.flow.scene.PageScene r13 = r12.mScene
                r13.hideResetView()
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.scene.sctx.LockScreenSctxScene.LockScreenSctxPage.doSceneBestView(com.didi.common.map.model.Padding, boolean):void");
        }

        private static Padding getMarkerBounders(Context context, LatLngBounds latLngBounds, List<Marker> list, float f) {
            Context context2 = context;
            LatLngBounds latLngBounds2 = latLngBounds;
            float f2 = f;
            Padding padding = new Padding();
            if (!(list == null || list.isEmpty() || latLngBounds2 == null)) {
                PointF pointF = new PointF(SystemUtil.lng2Pixel(context2, latLngBounds2.northeast.longitude, f2), SystemUtil.lat2Pixel(context2, latLngBounds2.northeast.latitude, f2));
                PointF pointF2 = new PointF(SystemUtil.lng2Pixel(context2, latLngBounds2.southwest.longitude, f2), SystemUtil.lat2Pixel(context2, latLngBounds2.southwest.latitude, f2));
                PointF pointF3 = new PointF();
                for (Marker next : list) {
                    if (next.getPosition() != null) {
                        PointF pointF4 = new PointF();
                        pointF4.x = SystemUtil.lng2Pixel(context2, next.getPosition().longitude, f2);
                        pointF4.y = SystemUtil.lat2Pixel(context2, next.getPosition().latitude, f2);
                        float anchorU = next.getOptions().getAnchorU();
                        float anchorV = next.getOptions().getAnchorV();
                        Marker.MarkerSize markerSize = next.getMarkerSize();
                        float f3 = ((float) markerSize.width) * anchorU;
                        float f4 = ((float) markerSize.width) - f3;
                        float f5 = ((float) markerSize.height) * anchorV;
                        float f6 = ((float) markerSize.height) - f5;
                        pointF3.x = pointF4.x - f3;
                        pointF3.y = pointF4.y - f5;
                        if (pointF2.x > pointF3.x && pointF2.x - pointF3.x > ((float) padding.left)) {
                            padding.left = (int) (pointF2.x - pointF3.x);
                        }
                        if (pointF3.y < pointF.y && pointF.y - pointF3.y > ((float) padding.top)) {
                            padding.top = (int) (pointF.y - pointF3.y);
                        }
                        pointF3.x = pointF4.x + f4;
                        pointF3.y = pointF4.y - f5;
                        if (pointF3.x > pointF.x && pointF3.x - pointF.x > ((float) padding.right)) {
                            padding.right = (int) (pointF3.x - pointF.x);
                        }
                        pointF3.x = pointF4.x - f3;
                        pointF3.y = pointF4.y + f6;
                        if (pointF3.y > pointF2.y && pointF3.y - pointF2.y > ((float) padding.bottom)) {
                            padding.bottom = (int) (pointF3.y - pointF2.y);
                        }
                        if (!(next.getInfoWindow() == null || next.getInfoWindow().getInfoWindowMarker() == null)) {
                            float f7 = ((float) markerSize.height) * anchorV;
                            Marker.MarkerSize markerSize2 = next.getInfoWindow().getInfoWindowMarker().getMarkerSize();
                            float anchorU2 = next.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorU();
                            float anchorV2 = next.getInfoWindow().getInfoWindowMarker().getOptions().getAnchorV();
                            float f8 = ((float) markerSize2.width) * anchorU2;
                            float f9 = ((float) markerSize2.width) - f8;
                            float f10 = ((float) markerSize2.height) * anchorV2;
                            int i = markerSize2.height;
                            pointF3.x = pointF4.x - f8;
                            pointF3.y = (pointF4.y - f10) - f7;
                            if (pointF2.x > pointF3.x && pointF2.x - pointF3.x > ((float) padding.left)) {
                                padding.left = (int) (pointF2.x - pointF3.x);
                            }
                            if (pointF3.y < pointF.y && pointF.y - pointF3.y > ((float) padding.top)) {
                                padding.top = (int) (pointF.y - pointF3.y);
                            }
                            pointF3.x = pointF4.x + f9;
                            pointF3.y = (pointF4.y - f10) - f7;
                            if (pointF3.x > pointF.x && pointF3.x - pointF.x > ((float) padding.right)) {
                                padding.right = (int) (pointF3.x - pointF.x);
                            }
                            pointF3.x = pointF4.x - f8;
                            pointF3.y = pointF4.y - f7;
                            if (pointF3.y > pointF2.y && pointF3.y - pointF2.y > ((float) padding.bottom)) {
                                padding.bottom = (int) (pointF3.y - pointF2.y);
                            }
                        }
                        context2 = context;
                    }
                }
            }
            return padding;
        }
    }
}
