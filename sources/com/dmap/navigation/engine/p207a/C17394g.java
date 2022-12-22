package com.dmap.navigation.engine.p207a;

import com.didi.map.base.RouteSectionWithName;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IMarkerSection;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.api.route.IRouteTag;
import com.dmap.navigation.api.route.ITunnelGeoPoint;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.location.IPassPoint;
import com.dmap.navigation.base.route.IToastInfo;
import com.dmap.navigation.jni.swig.IntList;
import com.dmap.navigation.jni.swig.MarkerSectionList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.NaviMJOLinkInfo;
import com.dmap.navigation.jni.swig.NaviMJOLinkInfoList;
import com.dmap.navigation.jni.swig.NaviPoi;
import com.dmap.navigation.jni.swig.NaviPoiList;
import com.dmap.navigation.jni.swig.NaviRoadName;
import com.dmap.navigation.jni.swig.NaviRoadNameList;
import com.dmap.navigation.jni.swig.NaviRoute;
import com.dmap.navigation.jni.swig.NaviRouteTag;
import com.dmap.navigation.jni.swig.NaviRouteTagList;
import com.dmap.navigation.jni.swig.PassPoint;
import com.dmap.navigation.jni.swig.PassPointList;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_void;
import com.dmap.navigation.jni.swig.TunnelGeoPointList;
import com.dmap.navigation.simple.SimpleLatlng;
import com.dmap.navigation.simple.SimplePassPoint;
import com.dmap.navigation.simple.SimplePoi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.g */
/* compiled from: SimpleRoute */
public final class C17394g implements IRouteEx {

    /* renamed from: A */
    private final List<DidiMapExt.MJOLinkInfo> f51776A;

    /* renamed from: B */
    private final int f51777B;

    /* renamed from: C */
    private final int f51778C;

    /* renamed from: D */
    private final int f51779D;

    /* renamed from: E */
    private final List<IMarkerSection> f51780E;

    /* renamed from: a */
    private final List<LatLng> f51781a;

    /* renamed from: b */
    private final List<INaviPoi> f51782b;

    /* renamed from: c */
    private final List<IPassPoint> f51783c;

    /* renamed from: d */
    private final ArrayList<Integer> f51784d;

    /* renamed from: e */
    private final ArrayList<LatLng> f51785e;

    /* renamed from: f */
    private final List<LatLng> f51786f;

    /* renamed from: g */
    private final List<RouteSectionWithName> f51787g;

    /* renamed from: h */
    private final Collection<RouteSectionWithName> f51788h;

    /* renamed from: i */
    private final HashMap<String, IRouteTag> f51789i;

    /* renamed from: j */
    private final INaviPoi f51790j;

    /* renamed from: k */
    private final INaviPoi f51791k;

    /* renamed from: l */
    private final double f51792l;

    /* renamed from: m */
    private final SWIGTYPE_p_void f51793m;

    /* renamed from: n */
    private final int f51794n;

    /* renamed from: o */
    private final BigInteger f51795o;

    /* renamed from: p */
    private final byte[] f51796p;

    /* renamed from: q */
    private final byte[] f51797q;

    /* renamed from: r */
    private final int f51798r;

    /* renamed from: s */
    private final int f51799s;

    /* renamed from: t */
    private final int f51800t;

    /* renamed from: u */
    private final boolean f51801u;

    /* renamed from: v */
    private final Object f51802v;

    /* renamed from: w */
    private final List<IToastInfo> f51803w;

    /* renamed from: x */
    private final LinkedList<Integer> f51804x;

    /* renamed from: y */
    private final LinkedList<Integer> f51805y;

    /* renamed from: z */
    private final List<ITunnelGeoPoint> f51806z;

    public C17394g(NaviRoute naviRoute) {
        this((Object) null, naviRoute, (byte[]) null, (byte[]) null, (List<IToastInfo>) null, -1);
    }

    public C17394g(Object obj, NaviRoute naviRoute, byte[] bArr, byte[] bArr2, List<IToastInfo> list, int i) {
        this.f51804x = new LinkedList<>();
        this.f51805y = new LinkedList<>();
        this.f51802v = obj;
        this.f51803w = list;
        this.f51777B = i;
        NaviPoi start = naviRoute.getStart();
        NaviPoi end = naviRoute.getEnd();
        this.f51790j = new SimplePoi(new SimpleLatlng(start.getLatLng().getLat(), start.getLatLng().getLng()), start.getName(), start.getUid());
        this.f51791k = new SimplePoi(new SimpleLatlng(end.getLatLng().getLat(), end.getLatLng().getLng()), end.getName(), end.getUid());
        this.f51792l = naviRoute.getConfidence();
        this.f51793m = naviRoute.getPbHandle();
        this.f51794n = naviRoute.getReqEventType();
        this.f51795o = naviRoute.getRouteId();
        this.f51796p = bArr;
        this.f51797q = bArr2;
        this.f51798r = naviRoute.getTotalDistance();
        this.f51799s = naviRoute.getTotalTime();
        this.f51800t = naviRoute.getLightCount();
        this.f51801u = naviRoute.getHasMjoEvent();
        this.f51778C = naviRoute.getSavingTime();
        this.f51779D = naviRoute.getJamCost();
        NaviLatLngList points = naviRoute.getPoints();
        this.f51781a = new ArrayList((int) points.size());
        for (int i2 = 0; ((long) i2) < points.size(); i2++) {
            NaviLatLng naviLatLng = points.get(i2);
            this.f51781a.add(new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng()));
        }
        NaviPoiList originalPassPoints = naviRoute.getOriginalPassPoints();
        this.f51782b = new ArrayList((int) originalPassPoints.size());
        for (int i3 = 0; ((long) i3) < originalPassPoints.size(); i3++) {
            NaviPoi naviPoi = originalPassPoints.get(i3);
            this.f51782b.add(new SimplePoi(new SimpleLatlng(naviPoi.getLatLng().getLat(), naviPoi.getLatLng().getLng()), naviPoi.getName(), naviPoi.getUid()));
        }
        PassPointList passPoints = naviRoute.getPassPoints();
        this.f51783c = new ArrayList((int) passPoints.size());
        for (int i4 = 0; ((long) i4) < passPoints.size(); i4++) {
            PassPoint passPoint = passPoints.get(i4);
            this.f51783c.add(new SimplePassPoint(passPoint.getPointIndex(), passPoint.getCoorIndex(), new SimpleLatlng(passPoint.getPassPoint().getLatLng().getLat(), passPoint.getPassPoint().getLatLng().getLng())));
        }
        IntList trafficIndexs = naviRoute.getTrafficIndexs();
        this.f51784d = new ArrayList<>((int) trafficIndexs.size());
        for (int i5 = 0; ((long) i5) < trafficIndexs.size(); i5++) {
            this.f51784d.add(Integer.valueOf(trafficIndexs.get(i5)));
        }
        NaviLatLngList trafficPoints = naviRoute.getTrafficPoints();
        this.f51785e = new ArrayList<>((int) trafficPoints.size());
        for (int i6 = 0; ((long) i6) < trafficPoints.size(); i6++) {
            NaviLatLng naviLatLng2 = trafficPoints.get(i6);
            this.f51785e.add(new SimpleLatlng(naviLatLng2.getLat(), naviLatLng2.getLng()));
        }
        NaviRouteTagList tagsList = naviRoute.getTagsList();
        this.f51789i = new HashMap<>((int) tagsList.size());
        for (int i7 = 0; ((long) i7) < tagsList.size(); i7++) {
            NaviRouteTag naviRouteTag = tagsList.get(i7);
            this.f51789i.put(naviRouteTag.getKey(), new C17395h(naviRouteTag));
        }
        NaviRoadNameList roadNames = naviRoute.getRoadNames();
        this.f51787g = new ArrayList((int) roadNames.size());
        for (int i8 = 0; ((long) i8) < roadNames.size(); i8++) {
            NaviRoadName naviRoadName = roadNames.get(i8);
            RouteSectionWithName routeSectionWithName = new RouteSectionWithName();
            routeSectionWithName.roadName = MapSerializeUtil.stringToBytesEndNull(naviRoadName.getName());
            routeSectionWithName.startNum = naviRoadName.getStartNum();
            routeSectionWithName.endNum = naviRoadName.getEndNum();
            this.f51787g.add(routeSectionWithName);
        }
        NaviRoadNameList fishboneRoadNames = naviRoute.getFishboneRoadNames();
        this.f51788h = new HashSet((int) fishboneRoadNames.size());
        for (int i9 = 0; ((long) i9) < fishboneRoadNames.size(); i9++) {
            NaviRoadName naviRoadName2 = fishboneRoadNames.get(i9);
            RouteSectionWithName routeSectionWithName2 = new RouteSectionWithName();
            routeSectionWithName2.roadName = MapSerializeUtil.stringToBytesEndNull(naviRoadName2.getName());
            this.f51788h.add(routeSectionWithName2);
        }
        NaviLatLngList lights = naviRoute.getLights();
        this.f51786f = new ArrayList((int) lights.size());
        for (int i10 = 0; ((long) i10) < lights.size(); i10++) {
            NaviLatLng naviLatLng3 = lights.get(i10);
            this.f51786f.add(new SimpleLatlng(naviLatLng3.getLat(), naviLatLng3.getLng()));
        }
        IntList passEtasList = naviRoute.getPassEtasList();
        for (int i11 = 0; ((long) i11) < passEtasList.size(); i11++) {
            this.f51804x.add(i11, Integer.valueOf(passEtasList.get(i11)));
        }
        IntList passEdasList = naviRoute.getPassEdasList();
        for (int i12 = 0; ((long) i12) < passEdasList.size(); i12++) {
            this.f51805y.add(i12, Integer.valueOf(passEdasList.get(i12)));
        }
        TunnelGeoPointList tunnelGeoPointList = naviRoute.getTunnelGeoPointList();
        this.f51806z = new ArrayList((int) tunnelGeoPointList.size());
        for (int i13 = 0; ((long) i13) < tunnelGeoPointList.size(); i13++) {
            this.f51806z.add(new C17398k(tunnelGeoPointList.get(i13)));
        }
        NaviMJOLinkInfoList mjoLinkList = naviRoute.getMjoLinkList();
        this.f51776A = new ArrayList((int) mjoLinkList.size());
        for (int i14 = 0; ((long) i14) < mjoLinkList.size(); i14++) {
            NaviMJOLinkInfo naviMJOLinkInfo = mjoLinkList.get(i14);
            this.f51776A.add(new DidiMapExt.MJOLinkInfo(naviMJOLinkInfo.getLinkId().longValue(), naviMJOLinkInfo.getDirection(), naviMJOLinkInfo.getLinkDistance()));
        }
        MarkerSectionList sections = naviRoute.getSections();
        this.f51780E = new ArrayList((int) sections.size());
        if (sections.size() > 0) {
            for (int i15 = 0; ((long) i15) < sections.size(); i15++) {
                this.f51780E.add(new C17392e(sections.get(i15)));
            }
        }
    }

    public final String toString() {
        return "SimpleRoute{points=" + this.f51781a + ", passPoints=" + this.f51782b + ", routePassPoints=" + this.f51783c + ", trafficIndex=" + this.f51784d + ", trafficInsertPoint=" + this.f51785e + ", lights=" + this.f51786f + ", tags=" + this.f51789i + ", start=" + this.f51790j + ", end=" + this.f51791k + ", confidence=" + this.f51792l + ", reqEventType=" + this.f51794n + ", routeId=" + this.f51795o + ", totalDistance=" + this.f51798r + ", totalTime=" + this.f51799s + ", lightCount=" + this.f51800t + ", hasMjoEvent=" + this.f51801u + ", passEtas=" + this.f51804x + ", passEdas=" + this.f51805y + ", mandatory=" + this.f51777B + ", savingTime=" + this.f51778C + ", jamCost=" + this.f51779D + '}';
    }

    public final double getConfidence() {
        return this.f51792l;
    }

    public final INaviPoi getStart() {
        return this.f51790j;
    }

    public final INaviPoi getEnd() {
        return this.f51791k;
    }

    public final List<INaviPoi> getOriginalPassPoints() {
        return this.f51782b;
    }

    public final List<IToastInfo> getToastInfos() {
        return this.f51803w;
    }

    public final List<IPassPoint> getRoutePassPoints() {
        return this.f51783c;
    }

    public final List<LatLng> getLights() {
        return this.f51786f;
    }

    public final int getRemainTime(int i) {
        if (i > 0 && i < this.f51804x.size()) {
            return this.f51804x.get(i).intValue();
        }
        if (this.f51804x.size() <= 0) {
            return 0;
        }
        LinkedList<Integer> linkedList = this.f51804x;
        return linkedList.get(linkedList.size() - 1).intValue();
    }

    public final int getRemainDistance(int i) {
        if (i > 0 && i < this.f51805y.size()) {
            return this.f51805y.get(i).intValue();
        }
        if (this.f51805y.size() <= 0) {
            return 0;
        }
        LinkedList<Integer> linkedList = this.f51805y;
        return linkedList.get(linkedList.size() - 1).intValue();
    }

    public final void updateEta(int i, int i2) {
        if (i >= 0 && i < this.f51804x.size()) {
            this.f51804x.set(i, Integer.valueOf(i2));
        }
    }

    public final void updateEda(int i, int i2) {
        if (i >= 0 && i < this.f51805y.size()) {
            this.f51805y.set(i, Integer.valueOf(i2));
        }
    }

    public final List<ITunnelGeoPoint> getTunnelGeoPoints() {
        return this.f51806z;
    }

    public final int getReqEventType() {
        return this.f51794n;
    }

    public final SWIGTYPE_p_void getPbHandle() {
        return this.f51793m;
    }

    public final HashMap<String, IRouteTag> getTags() {
        return this.f51789i;
    }

    public final List<RouteSectionWithName> getRoadnames() {
        return this.f51787g;
    }

    public final Collection<RouteSectionWithName> getFishboneRoadnames() {
        return this.f51788h;
    }

    public final boolean hasMjoEvent() {
        return this.f51801u;
    }

    public final BigInteger getRouteId() {
        return this.f51795o;
    }

    public final List<LatLng> getRoutePoints() {
        return this.f51781a;
    }

    public final int getLightCnt() {
        return this.f51800t;
    }

    public final byte[] getTrafficEvent() {
        return this.f51796p;
    }

    public final int getTime() {
        return this.f51799s;
    }

    public final int getDistance() {
        return this.f51798r;
    }

    public final ArrayList<Integer> getRouteTrafficIndex() {
        return this.f51784d;
    }

    public final ArrayList<LatLng> getTrafficInsertPoint() {
        return this.f51785e;
    }

    public final LatLng getTagForPosition(String str) {
        IRouteTag iRouteTag;
        if (!this.f51789i.containsKey(str) || (iRouteTag = this.f51789i.get(str)) == null) {
            return null;
        }
        return iRouteTag.getPosition();
    }

    public final String getTagForValue(String str) {
        IRouteTag iRouteTag;
        if (!this.f51789i.containsKey(str) || (iRouteTag = this.f51789i.get(str)) == null) {
            return null;
        }
        return iRouteTag.getValue();
    }

    public final List<DidiMapExt.MJOLinkInfo> getMjoLinkInfos() {
        return this.f51776A;
    }

    public final byte[] getExtendData() {
        return this.f51797q;
    }

    public final int getMandatory() {
        return this.f51777B;
    }

    public final int getSavingTime() {
        return this.f51778C;
    }

    public final int getJamCost() {
        return this.f51779D;
    }

    public final List<IMarkerSection> getMarkerSections() {
        return this.f51780E;
    }
}
