package com.didi.map.global.component.myLocation.view;

import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.myLocation.apollo.ApolloParamsAccuracyCircle;
import com.didi.map.global.component.myLocation.apollo.ApolloUtils;
import com.didi.map.global.component.myLocation.presenter.MyLocationPresenter;
import com.didi.map.global.component.myLocation.view.MyLocationMarkerOptions;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import java.util.List;

public class MyLocationView {

    /* renamed from: d */
    private static final String f26092d = "MyLocationComponent";

    /* renamed from: a */
    private MyLocationMarker f26093a;

    /* renamed from: b */
    private Map f26094b;

    /* renamed from: c */
    private MyLocationPresenter f26095c;

    public MyLocationView(Map map, int i, int i2, int i3) {
        this.f26094b = map;
        m18503a(i, i2, i3);
        this.f26095c = new MyLocationPresenter(map.getContext(), this);
    }

    /* renamed from: a */
    private void m18503a(int i, int i2, int i3) {
        MyLocationMarkerOptions b = m18504b(i, i2, i3);
        if (b != null && this.f26093a == null) {
            this.f26093a = new MyLocationMarker(b);
            m18505b();
        }
    }

    /* renamed from: b */
    private MyLocationMarkerOptions m18504b(int i, int i2, int i3) {
        return new MyLocationMarkerOptions.Builder().map(this.f26094b).accuracyCircleOptions(m18502a()).zIndex(i).arrowIcon(i2).positionIcon(i3).build();
    }

    /* renamed from: a */
    private LocationAccuracyCircleOptions m18502a() {
        ApolloParamsAccuracyCircle locationAccuracyCircleArgs = ApolloUtils.getLocationAccuracyCircleArgs();
        if (locationAccuracyCircleArgs == null || locationAccuracyCircleArgs.getEnable() <= 0) {
            return null;
        }
        LocationAccuracyCircleOptions locationAccuracyCircleOptions = new LocationAccuracyCircleOptions();
        locationAccuracyCircleOptions.setDefMinAccuracy((float) locationAccuracyCircleArgs.getMinRadius());
        locationAccuracyCircleOptions.setDefMaxAccuracy((float) locationAccuracyCircleArgs.getMaxRadius());
        DLog.m7384d(f26092d, "getAccuracyCircleOptions apolloParams=" + locationAccuracyCircleArgs, new Object[0]);
        return locationAccuracyCircleOptions;
    }

    /* renamed from: b */
    private void m18505b() {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.addSelf();
        }
    }

    public boolean isVisible() {
        MyLocationMarker myLocationMarker = this.f26093a;
        return myLocationMarker != null && myLocationMarker.isVisible();
    }

    public void show() {
        DIDILocation lastKnownLocation;
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.setVisible(true);
        }
        MyLocationPresenter myLocationPresenter = this.f26095c;
        if (myLocationPresenter != null) {
            myLocationPresenter.startLocation();
        }
        Map map = this.f26094b;
        if (map != null && (lastKnownLocation = DIDILocationManager.getInstance(map.getContext()).getLastKnownLocation()) != null && lastKnownLocation.isEffective()) {
            DLog.m7384d(f26092d, "onShow lastLoc=" + lastKnownLocation.getLatitude(), new Object[0]);
            refreshLocation(lastKnownLocation);
        }
    }

    public void updateArrowRotateAngle(float f) {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.updateArrowRotateAngle(f);
        }
    }

    public void hide() {
        MyLocationPresenter myLocationPresenter = this.f26095c;
        if (myLocationPresenter != null) {
            myLocationPresenter.stopLocation();
        }
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.setVisible(false);
        }
    }

    public void refreshLocation(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            MyLocationMarker myLocationMarker = this.f26093a;
            if (myLocationMarker != null) {
                myLocationMarker.updatePosition(latLng);
                this.f26093a.updateAccuracyView(latLng, dIDILocation.getAccuracy());
            }
        }
    }

    public void removeMyLocationMarker(boolean z, int i) {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.removeSelf(z, i);
        }
    }

    public void removeMyLocationMarker() {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.removeSelf(false, 0);
            this.f26093a = null;
        }
    }

    public void destroy() {
        MyLocationPresenter myLocationPresenter = this.f26095c;
        if (myLocationPresenter != null) {
            myLocationPresenter.stopLocation();
        }
        removeMyLocationMarker();
    }

    public List<IMapElement> getBestViewElements() {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            return myLocationMarker.getMarkers();
        }
        return null;
    }

    public void setZIndex(int i) {
        MyLocationMarker myLocationMarker = this.f26093a;
        if (myLocationMarker != null) {
            myLocationMarker.setZIndex(i);
        }
    }

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        MyLocationPresenter myLocationPresenter = this.f26095c;
        if (myLocationPresenter != null) {
            myLocationPresenter.setNeedNlpLocation(nLPRegisterParam);
        }
    }
}
