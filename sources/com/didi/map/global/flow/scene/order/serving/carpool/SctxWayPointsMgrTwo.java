package com.didi.map.global.flow.scene.order.serving.carpool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy2.IDMarkerContractV2;
import com.didi.map.global.component.collide.strategy2.RouteInfo;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.serving.components.MarkerManager;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SctxWayPointsMgrTwo implements ISctxCarpoolMgr {

    /* renamed from: a */
    private static final String f26738a = "SctxWayPointsMgr";

    /* renamed from: b */
    private IFetchCarpoolInfo f26739b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMarkersCompContract f26740c;

    /* renamed from: d */
    private CarpoolBubble f26741d;

    /* renamed from: e */
    private List<MarkerPassPoint> f26742e;

    /* renamed from: f */
    private ICollideStrategy f26743f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<LatLng> f26744g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Marker f26745h;

    /* renamed from: i */
    private boolean f26746i = true;

    /* renamed from: j */
    private Context f26747j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Map f26748k;

    /* renamed from: l */
    private MarkerManager f26749l;

    /* renamed from: m */
    private HashMap<String, IconLabelMarker> f26750m;

    public SctxWayPointsMgrTwo(Context context, MarkerManager markerManager, Map map) {
        this.f26749l = markerManager;
        this.f26748k = map;
        this.f26747j = context;
        this.f26750m = new HashMap<>();
    }

    public void destroy() {
        ICollideStrategy iCollideStrategy = this.f26743f;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f26743f = null;
        }
        IMarkersCompContract iMarkersCompContract = this.f26740c;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f26740c = null;
        }
        List<MarkerPassPoint> list = this.f26742e;
        if (list != null) {
            list.clear();
            this.f26742e = null;
        }
        this.f26741d = null;
    }

    public void setCarpoolInfoFetcher(IFetchCarpoolInfo iFetchCarpoolInfo) {
        this.f26739b = iFetchCarpoolInfo;
    }

    /* renamed from: a */
    private void m18901a() {
        if (this.f26743f == null) {
            this.f26743f = CollideStrategyFactory.getCollideStrategyV2(new IDMarkerContractV2() {
                public int getEnableLabelPosition(String str) {
                    return 170;
                }

                public int getHot(String str) {
                    return 0;
                }

                public boolean isCanWork() {
                    return true;
                }

                public boolean isLabelDirectClockwise() {
                    return true;
                }

                public Map getMap() {
                    return SctxWayPointsMgrTwo.this.f26748k;
                }

                public void setLabelDirect(String str, int i) {
                    SystemUtils.log(6, "ccc", str + ", setLabelDirect " + i, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgrTwo$1", 97);
                    if (SctxWayPointsMgrTwo.this.f26740c != null) {
                        SctxWayPointsMgrTwo.this.f26740c.updateMarkerLabelDirect(str, i);
                    }
                }

                public int getCurrentLabelPosition(String str) {
                    if (SctxWayPointsMgrTwo.this.f26740c != null) {
                        return SctxWayPointsMgrTwo.this.f26740c.getMarkerLabelDirect(str);
                    }
                    return 128;
                }

                public List<RouteInfo> getDisabledLines() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgrTwo.this.f26744g != null) {
                        arrayList.add(new RouteInfo(SctxWayPointsMgrTwo.this.f26744g));
                    }
                    return arrayList;
                }

                public List<Rect> getDisabledRect() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgrTwo.this.f26745h != null && SctxWayPointsMgrTwo.this.f26745h.isVisible()) {
                        arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f26748k, SctxWayPointsMgrTwo.this.f26745h, (Padding) null, true));
                    }
                    return arrayList;
                }
            });
        }
        if (this.f26740c == null) {
            MarkersComponent markersComponent = new MarkersComponent();
            this.f26740c = markersComponent;
            markersComponent.create(this.f26747j, this.f26748k);
        }
        if (this.f26741d == null) {
            this.f26741d = new CarpoolBubble();
        }
        if (this.f26742e == null) {
            this.f26742e = new ArrayList();
        }
    }

    /* renamed from: a */
    private void m18902a(List<MarkerPassPoint> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (MarkerPassPoint next : list) {
                if (!m18903a(this.f26742e, next)) {
                    if (next.lastOrderEndPoint) {
                        try {
                            this.f26749l.addMarker(MapElementId.ID_MARKER_WAYPOINT, new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue()), true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (next.isSerialOrder) {
                        try {
                            this.f26749l.setOdPointMarkerIconStyle(true);
                            this.f26750m.put(next.markerId, this.f26749l.addMarker(MapElementId.ID_MARKER_ODPOINT, new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue()), true));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        this.f26749l.setOdPointMarkerIconStyle(false);
                        MarkerModel markerModel = new MarkerModel();
                        markerModel.setMarkerIcon(next.bmp);
                        markerModel.setClickable(false);
                        markerModel.setId(next.markerId);
                        markerModel.setAnchorU(0.5f);
                        markerModel.setAnchorV(0.5f);
                        markerModel.setPoint(new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue()));
                        markerModel.setZOrder(102);
                        if (!TextUtils.isEmpty(next.label)) {
                            markerModel.setLabelDirection(128);
                            markerModel.setAddressName(next.label);
                            markerModel.setLabelZIndex(102);
                            markerModel.setLabelView(this.f26741d);
                        }
                        markerModel.setStrategy(this.f26743f);
                        this.f26740c.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
                    }
                    this.f26742e.add(next);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m18903a(List<MarkerPassPoint> list, MarkerPassPoint markerPassPoint) {
        if (!(CollectionUtil.isEmpty((Collection<?>) this.f26742e) || markerPassPoint == null || markerPassPoint.data == null)) {
            for (MarkerPassPoint next : list) {
                if (!(next == null || next.data == null)) {
                    if (!(next.data.odType == null || markerPassPoint.data.odType == null || !next.data.odType.equals(markerPassPoint.data.odType)) || (next.data.odType == null && markerPassPoint.data.odType == null)) {
                        if (!(((next.data.orderId == null || markerPassPoint.data.orderId == null || !next.data.orderId.equals(markerPassPoint.data.orderId)) && (next.data.orderId != null || markerPassPoint.data.orderId != null)) || next.data.point == null || markerPassPoint.data.point == null || next.data.point.lat == null || markerPassPoint.data.point.lat == null || !next.data.point.lat.equals(markerPassPoint.data.point.lat) || next.data.point.lng == null || markerPassPoint.data.point.lng == null || !next.data.point.lng.equals(markerPassPoint.data.point.lng))) {
                            if ((!(next.label == null || markerPassPoint.label == null || !next.label.equals(markerPassPoint.label)) || (next.label == null && markerPassPoint.label == null)) && next.lastOrderEndPoint == markerPassPoint.lastOrderEndPoint) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m18906b(List<MarkerPassPoint> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26742e)) {
            ArrayList arrayList = new ArrayList();
            for (MarkerPassPoint next : this.f26742e) {
                if (m18903a(list, next)) {
                    arrayList.add(next);
                } else if (next.lastOrderEndPoint) {
                    this.f26749l.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
                } else if (next.isSerialOrder) {
                    IconLabelMarker iconLabelMarker = this.f26750m.get(next.markerId);
                    if (iconLabelMarker != null) {
                        iconLabelMarker.destory();
                    }
                    this.f26750m.remove(next.markerId);
                } else {
                    this.f26740c.removeMarker(next.markerId);
                }
            }
            this.f26742e.clear();
            this.f26742e = arrayList;
        }
    }

    /* renamed from: b */
    private void m18905b() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26742e) && this.f26740c != null) {
            for (MarkerPassPoint next : this.f26742e) {
                if (next.isSerialOrder) {
                    IconLabelMarker iconLabelMarker = this.f26750m.get(next.markerId);
                    if (iconLabelMarker != null) {
                        iconLabelMarker.destory();
                    }
                    this.f26750m.remove(next.markerId);
                } else {
                    this.f26740c.removeMarker(next.markerId);
                }
            }
            this.f26742e.clear();
            this.f26742e = new ArrayList();
        }
    }

    public List<IMapElement> getSctxWayPoints() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f26742e) || this.f26740c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MarkerPassPoint markerPassPoint : this.f26742e) {
            List<Marker> markers = this.f26740c.getMarkers(markerPassPoint.markerId);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    public void onFinishFetchingCarpoolPoint(boolean z, List<OdPoint> list, List<LatLng> list2, Marker marker, Bitmap bitmap, Bitmap bitmap2) {
        boolean z2 = z;
        Bitmap bitmap3 = bitmap;
        Bitmap bitmap4 = bitmap2;
        if (this.f26746i) {
            m18901a();
            if (CollectionUtil.isEmpty((Collection<?>) list) && list.size() > 1) {
                DLog.m7384d(f26738a, "onFinishFetchingCarpoolPoint() odPoints: null", new Object[0]);
                m18905b();
            } else if (bitmap4 != null && bitmap3 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size() - 1; i++) {
                    OdPoint odPoint = list.get(i);
                    MarkerPassPoint markerPassPoint = new MarkerPassPoint();
                    markerPassPoint.markerId = odPoint.hashCode() + "id";
                    if (odPoint.odType != null && odPoint.odType.intValue() == 0) {
                        markerPassPoint.bmp = bitmap3;
                    } else if (odPoint.odType != null && odPoint.odType.intValue() == 1) {
                        markerPassPoint.bmp = bitmap4;
                        if (z2 && odPoint.pointType != null && odPoint.pointType.intValue() == 2) {
                            markerPassPoint.lastOrderEndPoint = true;
                        }
                    } else if (odPoint.odType != null && odPoint.odType.intValue() == 2) {
                        try {
                            markerPassPoint.bmp = BitmapFactory.decodeResource(this.f26747j.getResources(), this.f26749l.getMarkerIconResId(MapElementId.ID_MARKER_ODPOINT));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    markerPassPoint.data = odPoint;
                    markerPassPoint.isSerialOrder = z2;
                    arrayList.add(markerPassPoint);
                }
                IFetchCarpoolInfo iFetchCarpoolInfo = this.f26739b;
                if (iFetchCarpoolInfo != null) {
                    List<CarpoolInfo> onFetch = iFetchCarpoolInfo.onFetch();
                    if (CollectionUtil.isEmpty((Collection<?>) onFetch) || CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                        DLog.m7384d(f26738a, "onFinishFetchingCarpoolPoint() infoList: null", new Object[0]);
                    } else {
                        for (int i2 = 0; i2 < onFetch.size(); i2++) {
                            CarpoolInfo carpoolInfo = onFetch.get(i2);
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                MarkerPassPoint markerPassPoint2 = (MarkerPassPoint) arrayList.get(i3);
                                OdPoint odPoint2 = markerPassPoint2.data;
                                if (!(odPoint2 == null || odPoint2.point == null || carpoolInfo == null)) {
                                    LatLng latLng = new LatLng((double) odPoint2.point.lat.floatValue(), (double) odPoint2.point.lng.floatValue());
                                    DLog.m7384d(f26738a, "onFinishFetchingCarpoolPoint() odPoints loop: " + odPoint2, new Object[0]);
                                    DLog.m7384d(f26738a, "onFinishFetchingCarpoolPoint() infoList loop: " + carpoolInfo, new Object[0]);
                                    if (odPoint2.orderId != null && !TextUtils.isEmpty(carpoolInfo.orderId) && odPoint2.orderId.toString().equals(carpoolInfo.orderId) && ((odPoint2.odType == null || odPoint2.odType.intValue() == carpoolInfo.type) && LatLngUtils.locateCorrect(latLng))) {
                                        markerPassPoint2.label = carpoolInfo.msg;
                                    }
                                }
                            }
                        }
                    }
                }
                this.f26744g = list2;
                this.f26745h = marker;
                m18906b((List<MarkerPassPoint>) arrayList);
                m18902a((List<MarkerPassPoint>) arrayList);
            }
        }
    }

    public void setCarpoolShowBubblesEnabled(boolean z) {
        if (!z) {
            destroy();
        }
        this.f26746i = z;
    }

    class MarkerPassPoint {
        public Bitmap bmp;
        public OdPoint data;
        public boolean isSerialOrder;
        public String label;
        public boolean lastOrderEndPoint;
        public String markerId;

        MarkerPassPoint() {
        }
    }
}
