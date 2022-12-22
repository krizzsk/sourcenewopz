package com.didi.map.global.flow.scene.order.waiting.p123v2;

import android.graphics.Bitmap;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingStartEndParam;
import com.didi.map.global.flow.scene.order.waiting.p123v2.component.WaitingSceneCarComponent;
import com.didi.map.global.flow.scene.order.waiting.p123v2.component.WaitingStartEndComponent;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.toolkit.bestview.MapAutoBestViewLoop;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.routesearchsdk.CallFrom;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 1004)
/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplySceneV2 */
public class WaitingForReplySceneV2 extends PageScene<WaitingForReplyParamV2> implements IWaitingForReplyControllerV2 {

    /* renamed from: a */
    private static final int f26981a = 1;

    /* renamed from: b */
    private static final int f26982b = 2;

    /* renamed from: c */
    private static final int f26983c = 3;

    /* renamed from: d */
    private static final int f26984d = 3000;

    /* renamed from: i */
    private static final String f26985i = "WaitingSceneV2";

    /* renamed from: e */
    private WaitingStartEndComponent f26986e;

    /* renamed from: f */
    private WaitingSceneCarComponent f26987f;

    /* renamed from: g */
    private int f26988g = 0;

    /* renamed from: h */
    private MapAutoBestViewLoop f26989h;

    public WaitingForReplySceneV2(WaitingForReplyParamV2 waitingForReplyParamV2, MapViewHolder mapViewHolder) {
        super(waitingForReplyParamV2, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        m19041a();
        m19045b();
        if (getMap() != null) {
            MapAutoBestViewLoop mapAutoBestViewLoop = new MapAutoBestViewLoop(getMap(), 3000);
            this.f26989h = mapAutoBestViewLoop;
            mapAutoBestViewLoop.setOnBestViewCallback(new MapAutoBestViewLoop.IBestViewCallback() {
                public final void doBestView(boolean z) {
                    WaitingForReplySceneV2.this.m19044a(z);
                }
            });
        }
        OrderFloatWindowManager.Instance().setPageScene(PageSceneID.PAGE_CALLING);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19044a(boolean z) {
        int i = this.f26988g;
        if (i == 1 || i == 3) {
            onOrderReceiveBestView(this.mPadding);
        } else {
            m19043a(this.mPadding);
        }
        hideResetView();
    }

    public void leave() {
        super.leave();
        WaitingStartEndComponent waitingStartEndComponent = this.f26986e;
        if (waitingStartEndComponent != null) {
            waitingStartEndComponent.destroy();
            this.f26986e = null;
        }
        WaitingSceneCarComponent waitingSceneCarComponent = this.f26987f;
        if (waitingSceneCarComponent != null) {
            waitingSceneCarComponent.destroy();
            this.f26987f = null;
        }
        MapAutoBestViewLoop mapAutoBestViewLoop = this.f26989h;
        if (mapAutoBestViewLoop != null) {
            mapAutoBestViewLoop.destroy();
            this.f26989h = null;
        }
        this.mPadding = null;
        OrderFloatWindowManager.Instance().setPageScene(PageSceneID.PAGE_NONE);
    }

    public void onResume() {
        MapAutoBestViewLoop mapAutoBestViewLoop;
        if (this.isSceneValid && (mapAutoBestViewLoop = this.f26989h) != null) {
            mapAutoBestViewLoop.onMapVisible(true);
        }
    }

    public void onPause() {
        MapAutoBestViewLoop mapAutoBestViewLoop;
        if (this.isSceneValid && (mapAutoBestViewLoop = this.f26989h) != null) {
            mapAutoBestViewLoop.onMapVisible(false);
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages((Object) null);
            }
            MapAutoBestViewLoop mapAutoBestViewLoop = this.f26989h;
            if (mapAutoBestViewLoop != null) {
                mapAutoBestViewLoop.doBestViewImmediately(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didi.map.global.component.slideCars.api.CarNavigatorRequest m19040a(com.didi.map.global.flow.scene.CarSlidingParam r15) {
        /*
            r14 = this;
            com.didi.map.global.flow.scene.PageSceneParam r0 = r14.mParam
            r1 = 0
            if (r0 == 0) goto L_0x0036
            com.didi.map.global.flow.scene.PageSceneParam r0 = r14.mParam
            com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplyParamV2 r0 = (com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplyParamV2) r0
            java.util.List r0 = r0.getMarkerParams()
            if (r0 == 0) goto L_0x0036
            com.didi.map.global.flow.scene.PageSceneParam r0 = r14.mParam
            com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplyParamV2 r0 = (com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplyParamV2) r0
            java.util.List r0 = r0.getMarkerParams()
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r0.next()
            com.didi.map.global.flow.scene.param.CommonMarkerParam r2 = (com.didi.map.global.flow.scene.param.CommonMarkerParam) r2
            if (r2 == 0) goto L_0x001b
            com.didi.map.global.flow.scene.param.MapElementId r3 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
            com.didi.map.global.flow.scene.param.MapElementId r4 = r2.getId()
            if (r3 != r4) goto L_0x001b
            com.didi.common.map.model.LatLng r0 = r2.getPoint()
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            if (r0 != 0) goto L_0x0056
            android.content.Context r2 = r14.getContext()
            if (r2 == 0) goto L_0x0056
            android.content.Context r2 = r14.getContext()
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r2 = com.didi.map.global.model.location.LocationHelper.getLastKnownLocation(r2)
            if (r2 == 0) goto L_0x0056
            com.didi.common.map.model.LatLng r0 = new com.didi.common.map.model.LatLng
            double r3 = r2.getLatitude()
            double r5 = r2.getLongitude()
            r0.<init>((double) r3, (double) r5)
        L_0x0056:
            r11 = r0
            if (r15 == 0) goto L_0x00d8
            com.didi.common.map.Map r0 = r14.getMap()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            com.didi.common.map.Map r4 = r14.getMap()
            com.didi.common.map.MapVendor r4 = r4.getMapVendor()
            if (r4 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            r0 = r0 & r2
            if (r0 == 0) goto L_0x007f
            com.didi.common.map.Map r0 = r14.getMap()
            com.didi.common.map.MapVendor r0 = r0.getMapVendor()
            java.lang.String r1 = r0.toString()
        L_0x007f:
            com.didi.map.global.component.slideCars.api.CarNavigatorRequest r0 = new com.didi.map.global.component.slideCars.api.CarNavigatorRequest
            com.didi.map.sdk.env.PaxEnvironment r2 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            java.lang.String r8 = r2.getProductId()
            if (r1 != 0) goto L_0x008d
            java.lang.String r1 = "gmap"
        L_0x008d:
            r9 = r1
            com.didi.map.global.component.slideCars.api.ClientConfigParam r10 = new com.didi.map.global.component.slideCars.api.ClientConfigParam
            com.didi.sdk.map.language.LocaleCodeHolder r1 = com.didi.sdk.map.language.LocaleCodeHolder.getInstance()
            java.lang.String r2 = r1.getCurrentLang()
            java.lang.String r4 = r15.getIdfa()
            java.lang.String r5 = r15.getOriginId()
            int r6 = r15.getMixFlag()
            java.lang.String r7 = r15.getA3Token()
            java.lang.String r3 = "wgs84"
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            int r12 = r15.getType()
            int r13 = r15.getOrderState()
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            java.lang.String r1 = r15.getPid()
            r0.setPid(r1)
            int r1 = r15.getCarLevel()
            r0.setCarLevel(r1)
            int r1 = r15.getType()
            r0.setType(r1)
            int r15 = r15.getOrderState()
            r0.setOrderState(r15)
            return r0
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplySceneV2.m19040a(com.didi.map.global.flow.scene.CarSlidingParam):com.didi.map.global.component.slideCars.api.CarNavigatorRequest");
    }

    /* renamed from: a */
    private void m19041a() {
        if (this.mParam != null && getMap() != null && getContext() != null && !CollectionUtil.isEmpty((Collection<?>) ((WaitingForReplyParamV2) this.mParam).getMarkerParams())) {
            ArrayList arrayList = new ArrayList();
            LatLng latLng = null;
            LatLng latLng2 = null;
            MarkerModel markerModel = null;
            MarkerModel markerModel2 = null;
            for (CommonMarkerParam next : ((WaitingForReplyParamV2) this.mParam).getMarkerParams()) {
                if (next != null) {
                    int i = C97011.$SwitchMap$com$didi$map$global$flow$scene$param$MapElementId[next.getId().ordinal()];
                    if (i == 1) {
                        markerModel = m19039a(next);
                        latLng = next.getPoint();
                    } else if (i == 2) {
                        markerModel2 = m19039a(next);
                        latLng2 = next.getPoint();
                    } else if (i == 3 || i == 4 || i == 5) {
                        arrayList.add(m19039a(next));
                    }
                }
            }
            WaitingStartEndParam.WaitingStartEndLineParam waitingStartEndLineParam = new WaitingStartEndParam.WaitingStartEndLineParam();
            waitingStartEndLineParam.setStartPos(latLng);
            waitingStartEndLineParam.setEndPos(latLng2);
            waitingStartEndLineParam.setCaller(CallFrom.ORDERROUTEAPI_BUBBLE);
            waitingStartEndLineParam.setColor(getContext().getResources().getColor(R.color.global_map_waiting_scene_line_color));
            waitingStartEndLineParam.setLineWidth(6);
            WaitingStartEndParam waitingStartEndParam = new WaitingStartEndParam(markerModel, markerModel2, waitingStartEndLineParam, arrayList);
            if (this.f26986e == null) {
                WaitingStartEndComponent waitingStartEndComponent = new WaitingStartEndComponent();
                this.f26986e = waitingStartEndComponent;
                waitingStartEndComponent.setConfigParam(waitingStartEndParam);
                this.f26986e.create(getContext(), getMap());
                this.f26986e.start();
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingForReplySceneV2$1 */
    static /* synthetic */ class C97011 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.flow.scene.param.MapElementId[] r0 = com.didi.map.global.flow.scene.param.MapElementId.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId = r0
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_1     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_2     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_3     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplySceneV2.C97011.<clinit>():void");
        }
    }

    /* renamed from: a */
    private MarkerModel m19039a(CommonMarkerParam commonMarkerParam) {
        if (commonMarkerParam == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        int i = C97011.$SwitchMap$com$didi$map$global$flow$scene$param$MapElementId[commonMarkerParam.getId().ordinal()];
        if (i == 1) {
            markerModel.setZOrder(120);
        } else if (i == 2) {
            markerModel.setZOrder(119);
        } else if (i == 3 || i == 4 || i == 5) {
            markerModel.setZOrder(118);
        }
        markerModel.setId(commonMarkerParam.getId().name());
        markerModel.setPoint(commonMarkerParam.getPoint());
        markerModel.setAnchorU(commonMarkerParam.getAnchorU());
        markerModel.setAnchorV(commonMarkerParam.getAnchorV());
        markerModel.setMarkerIcon(commonMarkerParam.getMarkerIcon());
        markerModel.setAddressName(commonMarkerParam.getAddressName());
        return markerModel;
    }

    /* renamed from: b */
    private void m19045b() {
        if (this.mParam != null && getMap() != null && getContext() != null && this.f26987f == null) {
            this.f26987f = new WaitingSceneCarComponent();
            WaitingCarParam waitingCarParam = new WaitingCarParam(3000, m19040a(((WaitingForReplyParamV2) this.mParam).getSlidingParam()));
            waitingCarParam.setCarPositionFlushCallback(new ICarPositionFlushCallback() {
                public final void onCarPositionFlushed(LatLng latLng) {
                    WaitingForReplySceneV2.this.m19042a(latLng);
                }
            });
            this.f26987f.setConfigParam(waitingCarParam);
            this.f26987f.create(getContext(), getMap());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19042a(LatLng latLng) {
        doBestView(this.mPadding);
    }

    public void onOrderToOneDriver(Driver driver) {
        if (driver != null && this.f26987f != null && this.mParam != null) {
            this.f26987f.showCarMarker(driver, ((WaitingForReplyParamV2) this.mParam).getDefaultCarBitmap(), true);
            this.f26988g = 1;
            doBestView(this.mPadding);
        }
    }

    public void onDriverRefuseOrder(Driver driver) {
        WaitingSceneCarComponent waitingSceneCarComponent = this.f26987f;
        if (waitingSceneCarComponent != null) {
            waitingSceneCarComponent.hideCarMarker(true);
            this.f26988g = 2;
            doBestView(this.mPadding);
        }
    }

    public void onDriverReceivedOrder(Driver driver) {
        if (driver != null) {
            if (!(this.f26987f == null || this.mParam == null)) {
                this.f26987f.showCarMarker(driver, ((WaitingForReplyParamV2) this.mParam).getDefaultCarBitmap(), false);
                this.f26987f.stopLooper();
                this.f26988g = 3;
                doBestView(this.mPadding);
            }
            WaitingStartEndComponent waitingStartEndComponent = this.f26986e;
            if (waitingStartEndComponent != null) {
                waitingStartEndComponent.stopPulseAnim();
                this.f26986e.startPointAnimControl(false);
                this.f26986e.removeLine();
            }
        }
    }

    public void onCarBitmapNetWorkSuccess(Bitmap bitmap) {
        WaitingSceneCarComponent waitingSceneCarComponent;
        if (bitmap != null && (waitingSceneCarComponent = this.f26987f) != null) {
            waitingSceneCarComponent.updateCarIcon(bitmap);
        }
    }

    public void onOrderReceiveBestView(Padding padding) {
        if (this.mParam != null && getMap() != null && padding != null) {
            ArrayList arrayList = new ArrayList();
            WaitingStartEndComponent waitingStartEndComponent = this.f26986e;
            if (!(waitingStartEndComponent == null || waitingStartEndComponent.getStartMarkerElement() == null)) {
                arrayList.add(this.f26986e.getStartMarkerElement());
            }
            WaitingSceneCarComponent waitingSceneCarComponent = this.f26987f;
            if (!(waitingSceneCarComponent == null || waitingSceneCarComponent.getCarMarkerElements() == null)) {
                arrayList.addAll(this.f26987f.getCarMarkerElements());
            }
            int dp2px = DisplayUtils.dp2px(getContext(), 30.0f);
            int dp2px2 = DisplayUtils.dp2px(getContext(), 10.0f);
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, new Padding(dp2px, dp2px2, dp2px, dp2px2), (BestViewer.IBestViewListener) null);
        }
    }

    /* renamed from: a */
    private void m19043a(Padding padding) {
        if (padding != null && getMap() != null) {
            ArrayList arrayList = new ArrayList();
            if (!(this.f26986e == null || this.mParam == null || this.f26986e.getStartMarkerElement() == null)) {
                arrayList.add(this.f26986e.getStartMarkerElement());
            }
            int dp2px = DisplayUtils.dp2px(getContext(), 30.0f);
            int dp2px2 = DisplayUtils.dp2px(getContext(), 10.0f);
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, new Padding(dp2px, dp2px2, dp2px, dp2px2), (BestViewer.IBestViewListener) null);
        }
    }
}
