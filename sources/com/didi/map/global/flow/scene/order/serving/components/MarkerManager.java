package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.serving.components.SensingCirclesV1;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.toolkit.sctx.PassengerSctx;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MarkerUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MarkerManager {

    /* renamed from: a */
    private final IMarkersCompContract f26779a;

    /* renamed from: b */
    private final MapViewHolder f26780b;

    /* renamed from: c */
    private final HashMap<MapElementId, CommonMarkerParam> f26781c;

    /* renamed from: d */
    private SensingCirclesV1 f26782d;

    /* renamed from: e */
    private PassengerSctx f26783e;

    public MarkerManager(HashMap<MapElementId, CommonMarkerParam> hashMap, MapViewHolder mapViewHolder) {
        this.f26780b = mapViewHolder;
        this.f26781c = hashMap;
        m18921c();
        MarkersComponent markersComponent = new MarkersComponent();
        this.f26779a = markersComponent;
        markersComponent.create(getContext(), getMap());
        if (MapFlowApolloUtils.enableSerialOrderOptimized()) {
            m18920b();
        } else {
            m18918a();
        }
    }

    /* renamed from: a */
    private void m18918a() {
        this.f26781c.put(MapElementId.ID_MARKER_WAYPOINT, new CommonMarkerParam(new CommonMarkerParam.Builder().markerIconResId(R.drawable.waypoint_map_icon_stop_point).addressName(getContext().getString(R.string.map_flow_finishing_last_trip_tips)).addressNameColorResId(R.color.black)));
        this.f26781c.put(MapElementId.ID_MARKER_ODPOINT, new CommonMarkerParam(new CommonMarkerParam.Builder().markerIconResId(R.drawable.waypoint_map_icon_stop_point)));
    }

    /* renamed from: b */
    private void m18920b() {
        this.f26781c.put(MapElementId.ID_MARKER_WAYPOINT, new CommonMarkerParam(new CommonMarkerParam.Builder().markerIconResId(R.drawable.serial_order_icon).addressName(getContext().getString(R.string.GRider_pax__iMhU)).addressNameColorResId(R.color.black)));
        this.f26781c.put(MapElementId.ID_MARKER_ODPOINT, new CommonMarkerParam(new CommonMarkerParam.Builder().markerIconResId(R.drawable.serial_order_icon).addressName(getContext().getString(R.string.GRider_pax__tpeC)).addressNameColorResId(R.color.black)));
    }

    public void setOdPointMarkerIconStyle(boolean z) {
        CommonMarkerParam commonMarkerParam = this.f26781c.get(MapElementId.ID_MARKER_ODPOINT);
        if (commonMarkerParam == null) {
            return;
        }
        if (z) {
            commonMarkerParam.setMarkerIconResId(R.drawable.serial_order_icon);
        } else {
            commonMarkerParam.setMarkerIconResId(R.drawable.waypoint_map_icon_stop_point);
        }
    }

    /* renamed from: c */
    private void m18921c() {
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new CommonMarkerParam.Builder().mo75597id(MapElementId.ID_MARKER_RECOMMEND).markerIconResId(R.drawable.recommend_pickup_pointer).anchorU(0.5f).anchorV(0.5f).zIndex(106));
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap != null) {
            hashMap.put(MapElementId.ID_MARKER_RECOMMEND, commonMarkerParam);
        }
    }

    public void setPassengerSctx(PassengerSctx passengerSctx) {
        this.f26783e = passengerSctx;
    }

    public void addMarker(MapElementId mapElementId, boolean z) {
        CommonMarkerParam commonMarkerParam = this.f26781c.get(mapElementId);
        if (commonMarkerParam != null && commonMarkerParam.getPoint() != null) {
            addMarker(mapElementId, commonMarkerParam.getPoint(), z);
        }
    }

    public IconLabelMarker addMarker(MapElementId mapElementId, LatLng latLng, boolean z) {
        CommonMarkerParam commonMarkerParam;
        SensingCirclesV1.SensingCircleParam sensingCircleParam;
        if (getContext() == null || getMap() == null || (commonMarkerParam = this.f26781c.get(mapElementId)) == null || latLng == null) {
            return null;
        }
        int zIndex = commonMarkerParam.getZIndex();
        int addressNameColorResId = commonMarkerParam.getAddressNameColorResId();
        float anchorU = commonMarkerParam.getAnchorU();
        float anchorV = commonMarkerParam.getAnchorV();
        if (zIndex == 0) {
            if (mapElementId == MapElementId.ID_MARKER_START) {
                zIndex = 106;
            } else if (mapElementId == MapElementId.ID_MARKER_END) {
                zIndex = 104;
            } else if (mapElementId == MapElementId.ID_MARKER_WAYPOINT || mapElementId == MapElementId.ID_MARKER_ODPOINT) {
                zIndex = 102;
            }
        }
        if (mapElementId == MapElementId.ID_MARKER_WAYPOINT || mapElementId == MapElementId.ID_MARKER_ODPOINT) {
            anchorU = 0.5f;
            anchorV = 0.5f;
        }
        Bitmap markerIcon = commonMarkerParam.getMarkerIcon();
        if (commonMarkerParam.getMarkerIconResId() > 0 && markerIcon == null) {
            try {
                markerIcon = BitmapFactory.decodeResource(getContext().getResources(), commonMarkerParam.getMarkerIconResId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String addressName = z ? commonMarkerParam.getAddressName() : null;
        MarkerBubbleView markerBubbleView = new MarkerBubbleView(getContext());
        markerBubbleView.setLabel(addressName);
        markerBubbleView.setLabelColorResId(addressNameColorResId);
        markerBubbleView.setLabelRule(new StartEndMarkerLabelRule(getContext()));
        markerBubbleView.setLabelAnchorIcon((BitmapDescriptor) null);
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(mapElementId.name());
        markerModel.setPoint(latLng);
        markerModel.setMarkerIcon(markerIcon);
        markerModel.setAnchorU(anchorU);
        markerModel.setAnchorV(anchorV);
        markerModel.setZOrder(zIndex);
        markerModel.setLabelZIndex(commonMarkerParam.getZIndex());
        markerModel.setAddressName(addressName);
        markerModel.setLabelView(markerBubbleView);
        IconLabelMarker addNewMarkerToComponent = this.f26779a.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
        if (commonMarkerParam.showSensingCircle()) {
            if (commonMarkerParam.getSensingCircleColorRes() > 0) {
                sensingCircleParam = new SensingCirclesV1.SensingCircleParam().color(getContext().getResources().getColor(commonMarkerParam.getSensingCircleColorRes()));
            } else {
                sensingCircleParam = new SensingCirclesV1.SensingCircleParam();
            }
            SensingCirclesV1 sensingCirclesV1 = new SensingCirclesV1(getContext(), getMap(), sensingCircleParam);
            this.f26782d = sensingCirclesV1;
            sensingCirclesV1.showAt(latLng);
        }
        return addNewMarkerToComponent;
    }

    public int getMarkerIconResId(MapElementId mapElementId) {
        CommonMarkerParam commonMarkerParam;
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return 0;
        }
        return commonMarkerParam.getMarkerIconResId();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMarkerAddressName(com.didi.map.global.flow.scene.param.MapElementId r2) {
        /*
            r1 = this;
            java.util.HashMap<com.didi.map.global.flow.scene.param.MapElementId, com.didi.map.global.flow.scene.param.CommonMarkerParam> r0 = r1.f26781c
            if (r0 == 0) goto L_0x0011
            java.lang.Object r2 = r0.get(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r2 = (com.didi.map.global.flow.scene.param.CommonMarkerParam) r2
            if (r2 == 0) goto L_0x0011
            java.lang.String r2 = r2.getAddressName()
            return r2
        L_0x0011:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.MarkerManager.getMarkerAddressName(com.didi.map.global.flow.scene.param.MapElementId):java.lang.String");
    }

    public static LatLng getPoint(MapElementId mapElementId, HashMap<MapElementId, CommonMarkerParam> hashMap) {
        CommonMarkerParam commonMarkerParam;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return null;
        }
        return commonMarkerParam.getPoint();
    }

    public LatLng getPoint(MapElementId mapElementId) {
        CommonMarkerParam commonMarkerParam;
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return null;
        }
        return commonMarkerParam.getPoint();
    }

    public static Bitmap getMarkerIcon(MapElementId mapElementId, HashMap<MapElementId, CommonMarkerParam> hashMap) {
        CommonMarkerParam commonMarkerParam;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return null;
        }
        return commonMarkerParam.getMarkerIcon();
    }

    public static float getAnchorU(MapElementId mapElementId, HashMap<MapElementId, CommonMarkerParam> hashMap) {
        CommonMarkerParam commonMarkerParam;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return 0.0f;
        }
        return commonMarkerParam.getAnchorU();
    }

    public static float getAnchorV(MapElementId mapElementId, HashMap<MapElementId, CommonMarkerParam> hashMap) {
        CommonMarkerParam commonMarkerParam;
        if (hashMap == null || (commonMarkerParam = hashMap.get(mapElementId)) == null) {
            return 0.0f;
        }
        return commonMarkerParam.getAnchorV();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getPoiId(com.didi.map.global.flow.scene.param.MapElementId r2) {
        /*
            r1 = this;
            java.util.HashMap<com.didi.map.global.flow.scene.param.MapElementId, com.didi.map.global.flow.scene.param.CommonMarkerParam> r0 = r1.f26781c
            if (r0 == 0) goto L_0x0011
            java.lang.Object r2 = r0.get(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r2 = (com.didi.map.global.flow.scene.param.CommonMarkerParam) r2
            if (r2 == 0) goto L_0x0011
            java.lang.String r2 = r2.getPoiId()
            return r2
        L_0x0011:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.MarkerManager.getPoiId(com.didi.map.global.flow.scene.param.MapElementId):java.lang.String");
    }

    public void setPoiId(MapElementId mapElementId, String str) {
        CommonMarkerParam commonMarkerParam;
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap != null && (commonMarkerParam = hashMap.get(mapElementId)) != null) {
            commonMarkerParam.setPoiId(str);
        }
    }

    public void setPoint(MapElementId mapElementId, LatLng latLng) {
        CommonMarkerParam commonMarkerParam;
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap != null && (commonMarkerParam = hashMap.get(mapElementId)) != null) {
            commonMarkerParam.setPoint(latLng);
        }
    }

    public void setAddressName(MapElementId mapElementId, String str) {
        CommonMarkerParam commonMarkerParam;
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap != null && (commonMarkerParam = hashMap.get(mapElementId)) != null) {
            commonMarkerParam.setAddressName(str);
        }
    }

    public Marker getIconMarker(MapElementId mapElementId) {
        if (mapElementId == null) {
            return null;
        }
        if (mapElementId != MapElementId.ID_MARKER_CAR) {
            return this.f26779a.getIconMarkerById(mapElementId.name());
        }
        PassengerSctx passengerSctx = this.f26783e;
        if (passengerSctx == null || passengerSctx.getCarMarker() == null) {
            return null;
        }
        return this.f26783e.getCarMarker().getMarker();
    }

    public Marker getLabelMarker(MapElementId mapElementId) {
        if (mapElementId == null) {
            return null;
        }
        return this.f26779a.getLabelMarkerById(mapElementId.name());
    }

    public void destroyIconMarkerBubble(MapElementId mapElementId) {
        Marker iconMarker;
        if (mapElementId != null && (iconMarker = getIconMarker(mapElementId)) != null && iconMarker.getInfoWindow() != null) {
            iconMarker.getInfoWindow().destroy();
            iconMarker.destroyInfoWindow();
        }
    }

    public void hideIconMarkerBubble(Marker marker) {
        MarkerUtil.hideInfoWindow(marker);
    }

    public void hideIconMarkerBubble(MapElementId mapElementId) {
        Marker iconMarker;
        if (mapElementId != null && (iconMarker = getIconMarker(mapElementId)) != null) {
            hideIconMarkerBubble(iconMarker);
        }
    }

    public void destroy() {
        this.f26783e = null;
        this.f26779a.destroy();
    }

    public void setInfoWindowClickListener(MapElementId mapElementId, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (mapElementId != null) {
            this.f26779a.setInfoWindowClickListener(mapElementId.name(), onInfoWindowClickListener);
        }
    }

    public void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position, boolean z) {
        updateMarkerBubble(mapElementId, view, position, z, false);
    }

    public void updateMarkerBubble(MapElementId mapElementId, View view, InfoWindow.Position position, boolean z, boolean z2) {
        Marker iconMarker = getIconMarker(mapElementId);
        if (iconMarker != null) {
            int i = C96741.$SwitchMap$com$didi$map$global$flow$scene$param$MapElementId[mapElementId.ordinal()];
            if (i == 1) {
                updateMarkerBubble(iconMarker, view, 110, (InfoWindow.Position) null);
                if (position != null) {
                    m18919a(mapElementId, position, view);
                }
            } else if (i != 2) {
                if (i != 3) {
                    updateMarkerBubble(iconMarker, view, 108, (InfoWindow.Position) null);
                } else {
                    updateMarkerBubble(iconMarker, view, iconMarker.getZIndex(), (InfoWindow.Position) null);
                }
            } else if (z2) {
                updateMarkerBubble(iconMarker, view, 110, (InfoWindow.Position) null);
                if (position != null) {
                    m18919a(mapElementId, position, view);
                }
            } else {
                updateMarkerBubble(iconMarker, view, 109, (InfoWindow.Position) null);
                if (z) {
                    m18922d();
                }
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.order.serving.components.MarkerManager$1 */
    static /* synthetic */ class C96741 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.global.flow.scene.param.MapElementId[] r0 = com.didi.map.global.flow.scene.param.MapElementId.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId = r0
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_RECOMMEND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_CAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.MarkerManager.C96741.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m18919a(MapElementId mapElementId, InfoWindow.Position position, View view) {
        Marker iconMarker = getIconMarker(mapElementId);
        if (position == null || iconMarker == null) {
        }
    }

    /* renamed from: d */
    private void m18922d() {
        InfoWindow infoWindow;
        Marker iconMarker = getIconMarker(MapElementId.ID_MARKER_START);
        if (iconMarker != null && iconMarker != null && iconMarker.isInfoWindowShown() && (infoWindow = iconMarker.getInfoWindow()) != null && getMap() != null) {
            Marker infoWindowMarker = infoWindow.getInfoWindowMarker();
            if (getMap().getMapVendor() == MapVendor.DIDI) {
                infoWindowMarker.setAnchor(1.1f, -0.3f);
            } else {
                infoWindowMarker.setAnchor(1.1f, -0.6f);
            }
        }
    }

    public void updateMarkerBubble(Marker marker, View view, int i, InfoWindow.Position position) {
        MarkerUtil.showInfoWindow(this.f26780b.getMapView(), marker, view, i, position);
    }

    public void removeMarker(MapElementId mapElementId) {
        SensingCirclesV1 sensingCirclesV1;
        if (mapElementId != null) {
            this.f26779a.removeMarker(mapElementId.name());
            if (mapElementId == MapElementId.ID_MARKER_WAYPOINT && (sensingCirclesV1 = this.f26782d) != null) {
                sensingCirclesV1.hide();
            }
        }
    }

    public List<IMapElement> getMakerMapElements(MapElementId mapElementId) {
        ArrayList arrayList = new ArrayList();
        List<Marker> markers = this.f26779a.getMarkers(mapElementId.name());
        if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
            arrayList.addAll(markers);
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m18917a(float f) {
        try {
            return (int) TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return (int) (f * 1.5f);
        }
    }

    public Context getContext() {
        MapViewHolder mapViewHolder = this.f26780b;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.f26780b.getMapView().getContext();
    }

    public Map getMap() {
        MapViewHolder mapViewHolder = this.f26780b;
        if (mapViewHolder == null || mapViewHolder.getMapView() == null) {
            return null;
        }
        return this.f26780b.getMapView().getMap();
    }

    public String toString() {
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26781c;
        if (hashMap == null || CollectionUtil.isEmpty((Collection<?>) hashMap.values())) {
            return "MarkerManager {params is null}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MarkerManager[");
        for (CommonMarkerParam next : this.f26781c.values()) {
            sb.append(Const.joLeft);
            sb.append("id=");
            sb.append(next.getId());
            sb.append("start=");
            sb.append(next.getPoint());
            sb.append(", poiId=");
            sb.append(next.getPoiId());
            sb.append(", addressName=");
            sb.append(next.getAddressName());
            sb.append(", addressNameColorResId=");
            sb.append(next.getAddressNameColorResId());
            sb.append(", startIcon=");
            sb.append(next.getMarkerIcon());
            sb.append(", sAnchorU=");
            sb.append(next.getAnchorU());
            sb.append(", sAnchorV=");
            sb.append(next.getAnchorV());
            sb.append(", showSensingCircle=");
            sb.append(next.showSensingCircle());
            sb.append(", sensingCircleColorRes=");
            sb.append(next.getSensingCircleColorRes());
            sb.append("}");
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
