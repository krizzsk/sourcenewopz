package com.didi.map.global.flow.scene.minibus.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusGuideComponentParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusStreetParam;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntranceParam;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntrancePriorityManager;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MiniBusGuideEntranceComponent implements EntrancePriorityManager.EntranceCallback {

    /* renamed from: a */
    private static final String f26333a = "MiniBusGuideEntranceMarker";

    /* renamed from: b */
    private EntrancePriorityManager f26334b;

    /* renamed from: c */
    private List<GuideEntranceResult.EntranceType> f26335c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public StreetViewEntranceManager f26336d;

    /* renamed from: e */
    private boolean f26337e;

    /* renamed from: f */
    private IconLabelMarker f26338f;

    /* renamed from: g */
    private Context f26339g;

    /* renamed from: h */
    private Map f26340h;

    /* renamed from: i */
    private MiniBusGuideComponentParam f26341i;

    /* renamed from: j */
    private boolean f26342j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f26343k = false;

    /* renamed from: l */
    private StreetViewEntranceManager.StreetLoadCallback f26344l = new StreetViewEntranceManager.StreetLoadCallback() {
        public void onStreetLoadSuccess() {
            DLog.m7384d(MiniBusGuideEntranceComponent.f26333a, "StreetLoadSuccess", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f26343k = true;
            MiniBusGuideEntranceComponent.this.m18672b();
            if (MiniBusGuideEntranceComponent.this.f26336d != null && MiniBusGuideEntranceComponent.this.f26336d.isStreetViewShow()) {
                MiniBusGuideEntranceComponent.this.m18666a(2);
            }
        }

        public void onStreetLoadFails() {
            DLog.m7384d(MiniBusGuideEntranceComponent.f26333a, "StreetLoadFails", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f26343k = false;
        }

        public void onStreetInvalid() {
            DLog.m7384d(MiniBusGuideEntranceComponent.f26333a, "StreetInvalid", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f26343k = false;
            MiniBusGuideEntranceComponent.this.destroy();
        }
    };

    public MiniBusGuideEntranceComponent(Map map, Context context, MiniBusGuideComponentParam miniBusGuideComponentParam) {
        this.f26340h = map;
        this.f26339g = context;
        this.f26341i = miniBusGuideComponentParam;
        m18665a();
    }

    /* renamed from: a */
    private void m18665a() {
        Map map;
        if (this.f26341i != null) {
            if (this.f26334b == null) {
                this.f26334b = EntrancePriorityManager.getInstance();
            }
            EntrancePriorityManager entrancePriorityManager = this.f26334b;
            if (entrancePriorityManager != null && (map = this.f26340h) != null) {
                this.f26342j = false;
                entrancePriorityManager.getEntrancePriorities(this.f26339g, map, m18676f(), this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18672b() {
        DLog.m7384d(f26333a, "showBubble-->hasPriority" + this.f26342j + "sceneValid-->" + this.f26337e, new Object[0]);
        if (this.f26342j && this.f26337e) {
            m18677g();
        }
    }

    /* renamed from: c */
    private boolean m18673c() {
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f26341i;
        if (miniBusGuideComponentParam == null || miniBusGuideComponentParam.getOrderParams() == null || this.f26341i.getOrderParams().srcTag == null) {
            return false;
        }
        return DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(this.f26341i.getOrderParams().srcTag);
    }

    public void onPrioritySuccess(GuideEntranceResult guideEntranceResult) {
        if (guideEntranceResult == null || guideEntranceResult.availDisplayTypes == null || guideEntranceResult.availDisplayTypes.size() <= 0) {
            destroy();
            return;
        }
        this.f26342j = true;
        ArrayList<GuideEntranceResult.EntranceType> arrayList = guideEntranceResult.availDisplayTypes;
        this.f26335c = arrayList;
        for (GuideEntranceResult.EntranceType next : arrayList) {
            if (next.type == 2) {
                if (!m18673c()) {
                    m18675e();
                    if (!(this.f26341i == null || next == null || next.extendInfo == null)) {
                        String str = "";
                        String addressName = this.f26341i.getStreetParam() != null ? this.f26341i.getStreetParam().getAddressName() : str;
                        if (this.f26341i.getOrderParams() != null) {
                            str = this.f26341i.getOrderParams().orderId;
                        }
                        this.f26336d = new StreetViewEntranceManager(this.f26339g, StreetVersion.STREET_V3, addressName, next.extendInfo.walkGuidePhoto, next.extendInfo.tripId, str, this.f26344l);
                    }
                } else {
                    DLog.m7384d(f26333a, "current position is in airport fence", new Object[0]);
                }
            }
        }
        m18672b();
    }

    public void onPriorityFail() {
        DLog.m7384d(f26333a, "walkGuideLine network error", new Object[0]);
        destroy();
    }

    public void destroy() {
        this.f26343k = false;
        m18675e();
        m18674d();
    }

    /* renamed from: d */
    private void m18674d() {
        IconLabelMarker iconLabelMarker = this.f26338f;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
            this.f26338f = null;
        }
    }

    /* renamed from: e */
    private void m18675e() {
        StreetViewEntranceManager streetViewEntranceManager = this.f26336d;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.destroy();
            this.f26336d = null;
        }
    }

    /* renamed from: f */
    private EntranceParam m18676f() {
        EntranceParam entranceParam = new EntranceParam();
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f26341i;
        if (miniBusGuideComponentParam != null) {
            OrderParams orderParams = miniBusGuideComponentParam.getOrderParams();
            MiniBusStreetParam streetParam = this.f26341i.getStreetParam();
            if (!(streetParam == null || orderParams == null)) {
                entranceParam.selectLat = streetParam.getAddressPosition();
                entranceParam.latLng = streetParam.getAddressPosition();
                entranceParam.displayName = streetParam.getAddressName();
                entranceParam.poiId = streetParam.getAddressPoiId();
                entranceParam.walkGuidePhoto = streetParam.getStreetViewUrl();
                entranceParam.orderId = orderParams.orderId;
                entranceParam.orderStatus = orderParams.orderStage;
                entranceParam.orderType = orderParams.orderType;
                entranceParam.isCarpool = false;
                entranceParam.srcTag = "mini_bus_src";
                entranceParam.walkGuideLink = streetParam.getStreetViewUrl();
                entranceParam.walkGuidePhoto = streetParam.getStreetViewUrl();
            }
        }
        return entranceParam;
    }

    /* renamed from: g */
    private void m18677g() {
        IconLabelMarker iconLabelMarker;
        View smallStreetView;
        StreetViewEntranceManager streetViewEntranceManager;
        View smallStreetView2;
        if (this.f26341i != null && this.f26340h != null) {
            if (this.f26338f == null) {
                DLog.m7384d(f26333a, "create streetView bubble marker", new Object[0]);
                MiniBusStreetParam streetParam = this.f26341i.getStreetParam();
                if (streetParam != null && (streetViewEntranceManager = this.f26336d) != null && (smallStreetView2 = streetViewEntranceManager.getSmallStreetView()) != null) {
                    this.f26338f = new IconLabelMarker(this.f26340h, MapElementId.ID_MARKER_START_NAV.name(), this.f26339g).create(new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(streetParam.getAddressPosition()).markerIcon(MapUtils.getViewBitmap(smallStreetView2)).markerIconAnchorU(-0.05f).markerIconAnchorV(1.1f).isClickable(true).markerIconZIndex(204).build());
                    m18666a(0);
                    this.f26340h.addOnMarkerClickListener(new OnMarkerClickListener() {
                        public final boolean onMarkerClick(Marker marker) {
                            return MiniBusGuideEntranceComponent.this.m18669a(marker);
                        }
                    });
                    return;
                }
                return;
            }
            DLog.m7384d(f26333a, "update streetView marker icon", new Object[0]);
            if (this.f26336d != null && (iconLabelMarker = this.f26338f) != null && iconLabelMarker.getIconMarker() != null && (smallStreetView = this.f26336d.getSmallStreetView()) != null) {
                this.f26338f.getIconMarker().setIcon(this.f26339g, BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(smallStreetView)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m18669a(Marker marker) {
        List<GuideEntranceResult.EntranceType> list;
        IconLabelMarker iconLabelMarker = this.f26338f;
        if (iconLabelMarker == null || marker == null || marker != iconLabelMarker.getIconMarker() || (list = this.f26335c) == null || list.get(0) == null || this.f26335c.get(0).extendInfo == null || TextUtils.isEmpty(this.f26335c.get(0).extendInfo.walkGuidePhoto)) {
            DLog.m7384d(f26333a, "streetViewURL is empty，click invalid", new Object[0]);
            return false;
        }
        m18678h();
        return true;
    }

    /* renamed from: h */
    private void m18678h() {
        StreetViewEntranceManager streetViewEntranceManager = this.f26336d;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.showBigStreet();
        }
        m18666a(1);
        if (this.f26343k) {
            m18666a(2);
        }
    }

    public void setSceneValid(boolean z) {
        this.f26337e = z;
    }

    public List<IMapElement> getMarker() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f26338f;
        if (iconLabelMarker != null && !CollectionUtil.isEmpty((Collection<?>) iconLabelMarker.getMarkers())) {
            arrayList.addAll(this.f26338f.getMarkers());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18666a(int i) {
        HashMap hashMap = new HashMap();
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f26341i;
        if (!(miniBusGuideComponentParam == null || miniBusGuideComponentParam.getOrderParams() == null)) {
            hashMap.put("order_id", this.f26341i.getOrderParams().orderId);
        }
        if (i == 0) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_sw", hashMap);
        } else if (i == 1) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_ck", hashMap);
        } else if (i == 2) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_pic_sw", hashMap);
        }
    }
}
