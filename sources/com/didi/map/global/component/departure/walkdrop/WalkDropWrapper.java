package com.didi.map.global.component.departure.walkdrop;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.apolllo.WalkDropApollo;
import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.component.line.pax.walkanddropoff.IWalkAndDropOffLine;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkAndDropOffLineImpl;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkDropOffParam;
import com.didi.map.global.component.line.pax.walkanddropoff.onWalkDropChangeListener;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import com.taxis99.R;

public class WalkDropWrapper implements IWalkDropWrapper {

    /* renamed from: a */
    private static final String f25383a = "WalkDropWrapper";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f25384b;

    /* renamed from: c */
    private Map f25385c;

    /* renamed from: d */
    private GuideLine f25386d;

    /* renamed from: e */
    private IWalkAndDropOffLine f25387e;

    /* renamed from: f */
    private boolean f25388f;

    /* renamed from: g */
    private boolean f25389g;

    /* renamed from: h */
    private int f25390h;

    /* renamed from: i */
    private Marker f25391i;

    /* renamed from: j */
    private Address f25392j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public DepartureAddress f25393k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IDepartureCompContract.IDepartureComponentCallback f25394l;

    public WalkDropWrapper(Context context, Map map) {
        this.f25384b = context;
        this.f25385c = map;
        DLog.m7384d(f25383a, "构造", new Object[0]);
    }

    /* renamed from: a */
    private boolean m18160a() {
        Map map;
        if (!WalkDropApollo.Companion.getHms_enable() && (map = this.f25385c) != null && map.getMapVendor() == MapVendor.HUAWEI) {
            DLog.m7384d(f25383a, "huawei not support", new Object[0]);
            return false;
        } else if (!this.f25388f || !WalkDropApollo.Companion.getEnable() || this.f25390h == 1) {
            DLog.m7384d(f25383a, "final not support", new Object[0]);
            return false;
        } else {
            DLog.m7384d(f25383a, "apollo is allow", new Object[0]);
            return true;
        }
    }

    /* renamed from: b */
    private void m18162b() {
        LatLng latLng;
        if (this.f25389g && !m18160a()) {
            this.f25386d = new GuideLine();
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f25384b);
            if (lastKnownLocation == null) {
                latLng = null;
            } else {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            }
            this.f25386d.setConfigParam(new GuideLineParam(-13386753, latLng, DepartureUtils.getMapCenterPoint(this.f25385c)));
            this.f25386d.create(this.f25384b, this.f25385c);
            this.f25386d.setVisible(!m18160a());
            DLog.m7384d(f25383a, "createGuideLine", new Object[0]);
        }
    }

    /* renamed from: c */
    private void m18164c() {
        if (m18160a()) {
            this.f25387e = new WalkAndDropOffLineImpl();
            WalkDropOffParam walkDropOffParam = new WalkDropOffParam();
            walkDropOffParam.setToken(PaxEnvironment.getInstance().getToken());
            walkDropOffParam.setProductId(PaxEnvironment.getInstance().getProductId());
            walkDropOffParam.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
            walkDropOffParam.setPassengerId(Long.parseLong(PaxEnvironment.getInstance().getUid()));
            walkDropOffParam.setCountryId(PaxEnvironment.getInstance().getCountryCode());
            walkDropOffParam.setAnimate(true);
            walkDropOffParam.setCallFrom(CallFrom.ORDERROUTEAPI_BUBBLE);
            walkDropOffParam.setDropOffLineColor(this.f25384b.getResources().getColor(R.color.map_departure_dropoff_line_color));
            walkDropOffParam.setDropOffLineWidth(6);
            walkDropOffParam.setWalkLineAWidth(6);
            walkDropOffParam.setWalkLineASpace(10.0f);
            walkDropOffParam.setWalkLineAColor(Color.parseColor("#999999"));
            walkDropOffParam.setWalkLineBSpace(20.0f);
            this.f25387e.setConfigParam(walkDropOffParam);
            this.f25387e.create(this.f25384b, this.f25385c);
            this.f25387e.setOnWalkDropChangeListener(new onWalkDropChangeListener() {
                public void onPickPointSnapRoute(LatLng latLng) {
                    if (WalkDropWrapper.this.f25393k != null && WalkDropWrapper.this.f25393k.getZoneType() != 0 && WalkDropWrapper.this.f25393k.getExtendInfo() != null && WalkDropWrapper.this.f25393k.isRecommendPoi() && WalkDropApollo.Companion.getSubtitle_adsorbed() && DDSphericalUtil.computeDistanceBetween(latLng, WalkDropWrapper.this.f25393k.getPosition()) > 11.0d) {
                        String string = WalkDropWrapper.this.f25384b.getResources().getString(R.string.GRider_reveal_Please_go_iCIQ);
                        AddressExtendInfo extendInfo = WalkDropWrapper.this.f25393k.getExtendInfo();
                        extendInfo.setSubNoticeTitle("{\"text\":\"" + string + "\",\"info\":[{\"start\":\"0\",\"length\":\"" + string.length() + "\",\"color\":\"#5DD1AF\",\"bold\":1,\"through\":0,\"link\":\"\"}]}");
                        DLog.m7384d(WalkDropWrapper.f25383a, "onPickPointSnapRoute  update title", new Object[0]);
                        if (WalkDropWrapper.this.f25394l != null) {
                            WalkDropWrapper.this.f25394l.onDepartureAddressChanged(WalkDropWrapper.this.f25393k);
                        }
                    }
                }
            });
            DLog.m7384d(f25383a, "createWalkDropLine", new Object[0]);
        }
    }

    /* renamed from: d */
    private void m18165d() {
        if (m18160a() && this.f25392j != null && this.f25385c != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(this.f25392j.getLatitude(), this.f25392j.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.f25384b.getResources(), R.drawable.departure_map_icon_destination))).zIndex(100).visible(true);
            this.f25391i = this.f25385c.addMarker(markerOptions);
            DLog.m7384d(f25383a, "addOrderDestMarker", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m18166e() {
        Map map;
        Marker marker = this.f25391i;
        if (marker != null && (map = this.f25385c) != null) {
            map.remove(marker);
            this.f25391i = null;
            DLog.m7384d(f25383a, "removeOrderDestMarker", new Object[0]);
        }
    }

    public void onCameraChange(LatLng latLng) {
        GuideLine guideLine = this.f25386d;
        if (guideLine != null && guideLine.isVisible()) {
            this.f25386d.updateEndPosition(latLng);
        }
    }

    public void onReceiveLocationUpdate(DIDILocation dIDILocation) {
        GuideLine guideLine = this.f25386d;
        if (guideLine != null && dIDILocation != null && guideLine.isVisible()) {
            this.f25386d.updateStartPosition(new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude()));
        }
    }

    public void onMapDragStart() {
        this.f25393k = null;
        DLog.m7384d(f25383a, "onMapDragStart", new Object[0]);
    }

    public void onMapDragEnd() {
        DLog.m7384d(f25383a, "onMapDragEnd", new Object[0]);
    }

    public void onRequestFail() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f25387e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        this.f25393k = null;
        DLog.m7384d(f25383a, "onRequestFail", new Object[0]);
    }

    public void onRspAirport() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f25387e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        DLog.m7384d(f25383a, "onRspAirport", new Object[0]);
    }

    public void onNormalReverseGeo() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f25387e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        DLog.m7384d(f25383a, "onNormalReverseGeo", new Object[0]);
    }

    public void onRequestStart() {
        this.f25393k = null;
        DLog.m7384d(f25383a, "onRequestStart：", new Object[0]);
    }

    public void onNormalAdsorbedOk(LatLng latLng, DepartureAddress departureAddress) {
        IWalkAndDropOffLine iWalkAndDropOffLine;
        if (latLng == null || (iWalkAndDropOffLine = this.f25387e) == null || this.f25392j == null) {
            IWalkAndDropOffLine iWalkAndDropOffLine2 = this.f25387e;
            if (iWalkAndDropOffLine2 != null) {
                iWalkAndDropOffLine2.removeAllLine();
            }
        } else {
            iWalkAndDropOffLine.updateLines(m18159a(latLng), m18159a(new LatLng(this.f25392j.getLatitude(), this.f25392j.getLongitude())));
        }
        DLog.m7384d(f25383a, "onNormalAdsorbedOk：", new Object[0]);
        this.f25393k = departureAddress;
    }

    public void onNormalAdsorbedFail(LatLng latLng) {
        if (latLng == null || this.f25387e == null || this.f25392j == null || !WalkDropApollo.Companion.getDropline_enable()) {
            IWalkAndDropOffLine iWalkAndDropOffLine = this.f25387e;
            if (iWalkAndDropOffLine != null) {
                iWalkAndDropOffLine.removeAllLine();
            }
        } else {
            this.f25387e.updateLines(m18159a(latLng), m18159a(new LatLng(this.f25392j.getLatitude(), this.f25392j.getLongitude())));
        }
        this.f25393k = null;
        DLog.m7384d(f25383a, "onNormalAdsorbedFail：", new Object[0]);
    }

    /* renamed from: a */
    private DoublePoint m18159a(LatLng latLng) {
        return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).dlat(Double.valueOf(latLng.latitude)).dlng(Double.valueOf(latLng.longitude)).build();
    }

    public void setDestPoint(Address address) {
        this.f25392j = address;
        DLog.m7384d(f25383a, "setDestPoint：", new Object[0]);
    }

    public void setGuideLineEnable(boolean z) {
        this.f25389g = z;
        DLog.m7384d(f25383a, "setGuideLineEnable：" + z, new Object[0]);
    }

    public void setWalkDropEnable(boolean z) {
        this.f25388f = z;
        DLog.m7384d(f25383a, "setWalkDropEnable：" + z, new Object[0]);
    }

    public void setSceneType(int i) {
        this.f25390h = i;
        DLog.m7384d(f25383a, "setSceneType：" + i, new Object[0]);
    }

    public void onCreate() {
        DLog.m7384d(f25383a, "onCreate：", new Object[0]);
        m18162b();
        m18164c();
        m18165d();
    }

    public void onDestroy() {
        GuideLine guideLine = this.f25386d;
        if (guideLine != null) {
            guideLine.destroy();
            this.f25386d = null;
        }
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f25387e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.destroy();
            this.f25387e = null;
        }
        m18166e();
        DLog.m7384d(f25383a, "onDestroy：", new Object[0]);
    }

    public boolean isRecMarkerVisible() {
        if (!m18160a()) {
            return true;
        }
        DLog.m7384d(f25383a, "isRecMarkerVisible : " + WalkDropApollo.Companion.getRecpoint_enable(), new Object[0]);
        return WalkDropApollo.Companion.getRecpoint_enable();
    }

    public void setDepartureCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f25394l = iDepartureComponentCallback;
    }
}
