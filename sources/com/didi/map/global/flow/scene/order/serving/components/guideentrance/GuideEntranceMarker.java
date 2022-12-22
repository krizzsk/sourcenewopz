package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntrancePriorityManager;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.widget.RoundImageView;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GuideEntranceMarker implements OnMarkerClickListener, EntrancePriorityManager.EntranceCallback {

    /* renamed from: a */
    private static final String f26847a = "GuideEntranceMarker";

    /* renamed from: A */
    private boolean f26848A = true;

    /* renamed from: B */
    private StreetViewEntranceManager.StreetLoadCallback f26849B = new StreetViewEntranceManager.StreetLoadCallback() {
        public void onStreetLoadSuccess() {
            boolean unused = GuideEntranceMarker.this.f26871w = true;
            DLog.m7384d(GuideEntranceMarker.f26847a, "StreetLoadSuccess", new Object[0]);
            if (GuideEntranceMarker.this.f26862n == 3) {
                GuideEntranceMarker.this.m18975e();
            }
        }

        public void onStreetLoadFails() {
            boolean unused = GuideEntranceMarker.this.f26871w = false;
            DLog.m7384d(GuideEntranceMarker.f26847a, "StreetLoadFails", new Object[0]);
        }

        public void onStreetInvalid() {
            boolean unused = GuideEntranceMarker.this.f26871w = false;
            GuideEntranceMarker.this.m18980j();
        }
    };

    /* renamed from: b */
    private MapView f26850b;

    /* renamed from: c */
    private Marker f26851c;

    /* renamed from: d */
    private int f26852d = 131;

    /* renamed from: e */
    private View f26853e;

    /* renamed from: f */
    private FrameLayout f26854f;

    /* renamed from: g */
    private View f26855g;

    /* renamed from: h */
    private RoundImageView f26856h;

    /* renamed from: i */
    private TextView f26857i;

    /* renamed from: j */
    private RoundImageView f26858j;

    /* renamed from: k */
    private ServingParam f26859k;

    /* renamed from: l */
    private Marker f26860l;

    /* renamed from: m */
    private LatLng f26861m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f26862n = 0;

    /* renamed from: o */
    private EntrancePriorityManager f26863o;

    /* renamed from: p */
    private AREntranceManager f26864p;

    /* renamed from: q */
    private RealSceneEntranceManager f26865q;

    /* renamed from: r */
    private StreetViewEntranceManager f26866r;

    /* renamed from: s */
    private boolean f26867s = true;
    public boolean sceneValid;

    /* renamed from: t */
    private GuideEntranceResult.EntranceType f26868t;

    /* renamed from: u */
    private List<GuideEntranceResult.EntranceType> f26869u;

    /* renamed from: v */
    private Context f26870v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f26871w = false;

    /* renamed from: x */
    private boolean f26872x = false;

    /* renamed from: y */
    private boolean f26873y;

    /* renamed from: z */
    private boolean f26874z;

    public GuideEntranceMarker(MapView mapView, Marker marker, LatLng latLng, ServingParam servingParam) {
        if (servingParam != null && mapView != null) {
            this.f26850b = mapView;
            this.f26860l = marker;
            this.f26861m = latLng;
            this.f26859k = servingParam;
            Context context = servingParam.getContext();
            this.f26870v = context;
            if (context != null) {
                m18967a();
                EntrancePriorityManager instance = EntrancePriorityManager.getInstance();
                this.f26863o = instance;
                if (instance != null) {
                    this.f26874z = false;
                    this.f26872x = false;
                    instance.getEntrancePriorities(this.f26870v, this.f26850b.getMap(), m18970b(), this);
                }
            }
        }
    }

    /* renamed from: a */
    private void m18967a() {
        View inflate = LayoutInflater.from(this.f26870v).inflate(R.layout.guide_entrance_marker, (ViewGroup) null, false);
        this.f26853e = inflate;
        Drawable drawable = this.f26853e.getResources().getDrawable(R.drawable.arrow_right);
        drawable.setAutoMirrored(true);
        ((ImageView) inflate.findViewById(R.id.arrow)).setImageDrawable(drawable);
        this.f26854f = (FrameLayout) this.f26853e.findViewById(R.id.content_container);
        this.f26858j = (RoundImageView) this.f26853e.findViewById(R.id.street_view_icon);
        this.f26855g = this.f26853e.findViewById(R.id.entrance_container);
        this.f26856h = (RoundImageView) this.f26853e.findViewById(R.id.entrance_icon);
        this.f26857i = (TextView) this.f26853e.findViewById(R.id.entrance_text);
    }

    /* renamed from: b */
    private EntranceParam m18970b() {
        CommonMarkerParam markerParam;
        EntranceParam entranceParam = new EntranceParam();
        ServingParam servingParam = this.f26859k;
        if (!(servingParam == null || (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START)) == null || this.f26859k.getOrderParams() == null)) {
            entranceParam.selectLat = markerParam.getPoint();
            entranceParam.latLng = markerParam.getPoint();
            entranceParam.displayName = markerParam.getAddressName();
            entranceParam.poiId = markerParam.getPoiId();
            entranceParam.orderId = this.f26859k.getOrderParams().orderId;
            entranceParam.orderStatus = this.f26859k.getOrderParams().orderStage;
            entranceParam.orderType = this.f26859k.getOrderParams().orderType;
            entranceParam.isCarpool = this.f26859k.getOrderParams().isCarpoolOrder();
            entranceParam.srcTag = this.f26859k.getOrderParams().srcTag;
            entranceParam.walkGuideLink = this.f26859k.getOrderParams().stationWalkGuideLink;
            entranceParam.walkGuidePhoto = this.f26859k.getOrderParams().stationWalkGuidePhoto;
        }
        return entranceParam;
    }

    public void location(DIDILocation dIDILocation) {
        AREntranceManager aREntranceManager = this.f26864p;
        if (aREntranceManager != null) {
            aREntranceManager.setCurrentLocation(dIDILocation);
        }
    }

    public void update(ServingParam servingParam, LatLng latLng) {
        MapView mapView;
        Context context;
        if (latLng != null) {
            this.f26861m = latLng;
        }
        if (servingParam != null) {
            this.f26859k = servingParam;
        }
        EntrancePriorityManager entrancePriorityManager = this.f26863o;
        if (entrancePriorityManager != null && (mapView = this.f26850b) != null && (context = this.f26870v) != null) {
            this.f26874z = false;
            this.f26872x = false;
            entrancePriorityManager.getEntrancePriorities(context, mapView.getMap(), m18970b(), this);
        }
    }

    public void updateDestinationPosition(LatLng latLng) {
        AREntranceManager aREntranceManager = this.f26864p;
        if (aREntranceManager != null) {
            aREntranceManager.updateStartPosition(latLng);
        }
    }

    public Marker getMarker() {
        return this.f26851c;
    }

    public void onOrderStateChanged(int i) {
        AREntranceManager aREntranceManager = this.f26864p;
        if (aREntranceManager != null) {
            aREntranceManager.onOrderStateChanged(i);
        }
    }

    /* renamed from: c */
    private void m18972c() {
        int dp2px = DisplayUtils.dp2px(this.f26870v, 13.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f26870v, 6.0f);
        int dp2px3 = DisplayUtils.dp2px(this.f26870v, 7.0f);
        int dp2px4 = DisplayUtils.dp2px(this.f26870v, 2.0f);
        if (this.f26867s) {
            this.f26858j.setCornersRadius(dp2px, dp2px, dp2px2, dp2px);
            this.f26856h.setCornersRadius(dp2px, dp2px, dp2px2, dp2px);
            this.f26854f.setBackground(this.f26870v.getResources().getDrawable(R.drawable.guide_entrance_bg_shape));
            ((FrameLayout.LayoutParams) this.f26854f.getLayoutParams()).setMargins(dp2px3, 0, 0, dp2px4);
        } else {
            this.f26858j.setCornersRadius(dp2px, dp2px, dp2px, dp2px2);
            this.f26856h.setCornersRadius(dp2px, dp2px, dp2px, dp2px2);
            this.f26854f.setBackground(this.f26870v.getResources().getDrawable(R.drawable.guide_entrance_bg_shape_left));
            ((FrameLayout.LayoutParams) this.f26854f.getLayoutParams()).setMargins(0, 0, dp2px3, dp2px4);
        }
        this.f26858j.invalidate();
        this.f26856h.invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r0 != 5) goto L_0x00ca;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m18974d() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f26870v
            r1 = 0
            if (r0 == 0) goto L_0x00ca
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            if (r0 == 0) goto L_0x00ca
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26856h
            if (r0 == 0) goto L_0x00ca
            android.widget.FrameLayout r0 = r5.f26854f
            if (r0 == 0) goto L_0x00ca
            android.widget.TextView r0 = r5.f26857i
            if (r0 != 0) goto L_0x0017
            goto L_0x00ca
        L_0x0017:
            r5.m18972c()
            int r0 = r5.f26862n
            r2 = 8
            if (r0 == 0) goto L_0x00c0
            r3 = 1
            if (r0 == r3) goto L_0x009b
            r4 = 2
            if (r0 == r4) goto L_0x0076
            r4 = 3
            if (r0 == r4) goto L_0x0056
            r4 = 4
            if (r0 == r4) goto L_0x0031
            r4 = 5
            if (r0 == r4) goto L_0x0056
            goto L_0x00ca
        L_0x0031:
            android.view.View r0 = r5.f26855g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            r0.setVisibility(r2)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26856h
            r1 = 2131233625(0x7f080b59, float:1.8083393E38)
            r0.setImageResource(r1)
            android.widget.TextView r0 = r5.f26857i
            android.view.View r1 = r5.f26853e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952670(0x7f13041e, float:1.954179E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            return r3
        L_0x0056:
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            r0.setVisibility(r1)
            android.view.View r0 = r5.f26855g
            r0.setVisibility(r2)
            com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager r0 = r5.f26866r
            if (r0 == 0) goto L_0x0075
            android.view.View r0 = r0.getSmallStreetView()
            if (r0 == 0) goto L_0x0075
            android.graphics.Bitmap r0 = com.didi.common.map.util.MapUtils.getViewBitmap(r0)
            if (r0 == 0) goto L_0x0075
            com.didi.map.global.flow.widget.RoundImageView r1 = r5.f26858j
            r1.setImageBitmap(r0)
        L_0x0075:
            return r3
        L_0x0076:
            android.view.View r0 = r5.f26855g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            r0.setVisibility(r2)
            android.widget.TextView r0 = r5.f26857i
            android.view.View r1 = r5.f26853e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952780(0x7f13048c, float:1.9542012E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26856h
            r1 = 2131233626(0x7f080b5a, float:1.8083395E38)
            r0.setImageResource(r1)
            return r3
        L_0x009b:
            android.view.View r0 = r5.f26855g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            r0.setVisibility(r2)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26856h
            r1 = 2131233622(0x7f080b56, float:1.8083387E38)
            r0.setImageResource(r1)
            android.widget.TextView r0 = r5.f26857i
            android.view.View r1 = r5.f26853e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952776(0x7f130488, float:1.9542004E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            return r3
        L_0x00c0:
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f26858j
            r0.setVisibility(r2)
            android.view.View r0 = r5.f26855g
            r0.setVisibility(r2)
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.guideentrance.GuideEntranceMarker.m18974d():boolean");
    }

    public boolean isShowed() {
        return this.f26872x;
    }

    public void updateBubbleDirection(boolean z) {
        if (!this.f26872x || this.f26867s != z) {
            this.f26867s = z;
            this.f26873y = true;
            m18975e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18975e() {
        if (m18979i()) {
            m18968a(false);
            m18978h();
            if (m18974d() && this.sceneValid) {
                this.f26872x = true;
                m18976f();
            }
        }
    }

    public void setVisible(boolean z) {
        this.f26848A = z;
        Marker marker = this.f26851c;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    /* renamed from: f */
    private void m18976f() {
        MapView mapView = this.f26850b;
        if (mapView != null && mapView.getMap() != null && LatLngUtils.locateCorrect(this.f26861m)) {
            m18980j();
            Bitmap viewBitmap = MapUtils.getViewBitmap(this.f26853e);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(this.f26861m).icon(BitmapDescriptorFactory.fromBitmap(viewBitmap)).zIndex(this.f26852d);
            markerOptions.clickable(true).visible(true);
            if (this.f26867s) {
                markerOptions.anchor(0.0f, 1.0f);
            } else {
                markerOptions.anchor(1.0f, 1.0f);
            }
            Marker addMarker = this.f26850b.getMap().addMarker(markerOptions);
            this.f26851c = addMarker;
            addMarker.setVisible(this.f26848A);
            this.f26850b.getMap().addOnMarkerClickListener(this);
            Marker marker = this.f26851c;
            if (marker != null) {
                marker.hideInfoWindow();
            }
        }
    }

    /* renamed from: g */
    private boolean m18977g() {
        ServingParam servingParam = this.f26859k;
        if (servingParam == null || servingParam.getOrderParams() == null || this.f26859k.getOrderParams().srcTag == null) {
            return false;
        }
        return DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(this.f26859k.getOrderParams().srcTag);
    }

    public void onPrioritySuccess(GuideEntranceResult guideEntranceResult) {
        ServingParam servingParam;
        ServingParam servingParam2;
        if (guideEntranceResult == null || guideEntranceResult.availDisplayTypes == null || guideEntranceResult.availDisplayTypes.size() <= 0) {
            destroy();
            return;
        }
        this.f26874z = true;
        ArrayList<GuideEntranceResult.EntranceType> arrayList = guideEntranceResult.availDisplayTypes;
        this.f26869u = arrayList;
        GuideEntranceResult.EntranceType entranceType = arrayList.get(0);
        if (entranceType != null) {
            this.f26862n = entranceType.type;
        }
        ServingParam servingParam3 = this.f26859k;
        String str = (servingParam3 == null || servingParam3.getOrderParams() == null) ? "" : this.f26859k.getOrderParams().orderId;
        for (GuideEntranceResult.EntranceType next : this.f26869u) {
            int i = next.type;
            if (i != 1) {
                if (i == 2) {
                    this.f26868t = next;
                    if (this.f26865q == null && m18977g()) {
                        m18983m();
                        this.f26865q = RealSceneEntranceManager.getInstance(this.f26859k);
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        m18982l();
                        if (!(this.f26850b == null || (servingParam2 = this.f26859k) == null)) {
                            AREntranceManager aREntranceManager = new AREntranceManager(this.f26870v, servingParam2, true);
                            this.f26864p = aREntranceManager;
                            aREntranceManager.setOutdoor(true);
                        }
                    } else if (i == 5 && !m18977g()) {
                        m18981k();
                        if (!(this.f26859k == null || next == null || next.extendInfo == null)) {
                            this.f26868t = next;
                            this.f26866r = new StreetViewEntranceManager(this.f26870v, StreetVersion.STREET_V2, "", next.extendInfo.streetViewUrl, next.extendInfo.tripId, str, this.f26849B);
                        }
                    }
                } else if (!m18977g()) {
                    m18981k();
                    if (!(this.f26859k == null || next == null || next.extendInfo == null)) {
                        this.f26868t = next;
                        this.f26866r = new StreetViewEntranceManager(this.f26870v, StreetVersion.STREET_V1, "", next.extendInfo.streetViewUrl, next.extendInfo.tripId, str, this.f26849B);
                    }
                }
            } else if (m18977g()) {
                m18982l();
                if (!(this.f26850b == null || (servingParam = this.f26859k) == null)) {
                    AREntranceManager aREntranceManager2 = new AREntranceManager(this.f26870v, servingParam, false);
                    this.f26864p = aREntranceManager2;
                    aREntranceManager2.setOutdoor(false);
                }
            }
        }
        m18975e();
    }

    /* renamed from: h */
    private void m18978h() {
        InfoWindow infoWindow;
        Marker marker = this.f26860l;
        if (marker != null && marker != null && marker.isInfoWindowShown() && (infoWindow = this.f26860l.getInfoWindow()) != null) {
            infoWindow.setPosition(InfoWindow.Position.LEFT_BOTTOM);
        }
    }

    /* renamed from: i */
    private boolean m18979i() {
        GuideEntranceResult.EntranceType entranceType;
        if (!this.f26873y || !this.f26874z) {
            return false;
        }
        int i = this.f26862n;
        if (i == 3) {
            return this.f26871w;
        }
        if (i == 5) {
            GuideEntranceResult.EntranceType entranceType2 = this.f26868t;
            if (entranceType2 == null || entranceType2.extendInfo == null || TextUtils.isEmpty(this.f26868t.extendInfo.streetViewUrl)) {
                return false;
            }
            return true;
        } else if (i != 2 || (entranceType = this.f26868t) == null || entranceType.extendInfo == null || (!TextUtils.isEmpty(this.f26868t.extendInfo.walkGuidePhoto) && !TextUtils.isEmpty(this.f26868t.extendInfo.walkGuideLink))) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private void m18968a(boolean z) {
        String str;
        String str2;
        long j;
        AREntranceManager aREntranceManager;
        String str3;
        String str4 = "";
        if (this.f26862n != 1 || (aREntranceManager = this.f26864p) == null) {
            j = -1;
            str2 = str4;
            str = str2;
        } else {
            if (aREntranceManager.arParams != null) {
                str4 = this.f26864p.arParams.get("model");
                str3 = this.f26864p.arParams.get("session");
            } else {
                str3 = str4;
            }
            j = this.f26864p.getLoadTime();
            str = str3;
            str2 = str4;
        }
        long j2 = j;
        ServingParam servingParam = this.f26859k;
        String str5 = (servingParam == null || servingParam.getOrderParams() == null) ? "-1" : this.f26859k.getOrderParams().orderStage == 0 ? "1" : "2";
        if (this.f26850b != null) {
            MapFlowOmegaUtil.trackGuideEntranceShowOrClick(this.f26862n, this.f26859k.getOrderParams().orderId, System.currentTimeMillis(), str2, str, j2, str5, z, this.f26850b.getMapVendor());
        }
    }

    public void onPriorityFail() {
        destroy();
    }

    public void destroy() {
        this.f26871w = false;
        m18983m();
        m18982l();
        m18981k();
        m18980j();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m18980j() {
        MapView mapView = this.f26850b;
        if (mapView != null && mapView.getMap() != null) {
            this.f26850b.getMap().remove(this.f26851c);
            this.f26850b.getMap().removeOnMarkerClickListener(this);
            this.f26851c = null;
        }
    }

    /* renamed from: k */
    private void m18981k() {
        StreetViewEntranceManager streetViewEntranceManager = this.f26866r;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.destroy();
            this.f26866r = null;
        }
    }

    /* renamed from: l */
    private void m18982l() {
        AREntranceManager aREntranceManager = this.f26864p;
        if (aREntranceManager != null) {
            aREntranceManager.destroy();
            this.f26864p = null;
        }
    }

    /* renamed from: m */
    private void m18983m() {
        RealSceneEntranceManager realSceneEntranceManager = this.f26865q;
        if (realSceneEntranceManager != null) {
            realSceneEntranceManager.destroy();
            this.f26865q = null;
        }
    }

    public boolean onMarkerClick(Marker marker) {
        if (FastClickUtil.isFastClick()) {
            return false;
        }
        boolean z = (marker == null || this.f26851c == null || TextUtils.isEmpty(marker.getId())) ? false : true;
        Marker marker2 = this.f26860l;
        if (!z || (!marker.getId().equals(this.f26851c.getId()) && (marker2 == null || !marker.getId().equals(marker2.getId())))) {
            return false;
        }
        m18984n();
        m18968a(true);
        return true;
    }

    /* renamed from: n */
    private void m18984n() {
        StreetViewEntranceManager streetViewEntranceManager;
        if (this.f26848A) {
            int i = this.f26862n;
            if (i != 1) {
                if (i == 2) {
                    RealSceneEntranceManager realSceneEntranceManager = this.f26865q;
                    if (realSceneEntranceManager != null) {
                        realSceneEntranceManager.showReal();
                        return;
                    }
                    return;
                } else if (i == 3) {
                    StreetViewEntranceManager streetViewEntranceManager2 = this.f26866r;
                    if (streetViewEntranceManager2 != null) {
                        streetViewEntranceManager2.showBigStreet();
                        return;
                    }
                    return;
                } else if (i != 4) {
                    if (i == 5 && (streetViewEntranceManager = this.f26866r) != null) {
                        streetViewEntranceManager.loadAndShowStreetView();
                        return;
                    }
                    return;
                }
            }
            AREntranceManager aREntranceManager = this.f26864p;
            if (aREntranceManager != null) {
                aREntranceManager.showAR();
            }
        }
    }
}
