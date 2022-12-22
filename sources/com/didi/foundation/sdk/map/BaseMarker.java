package com.didi.foundation.sdk.map;

import android.content.Context;
import android.view.View;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.sdk.apm.SystemUtils;

public abstract class BaseMarker {

    /* renamed from: a */
    private IMapView f21250a;

    /* renamed from: b */
    private boolean f21251b = true;

    /* renamed from: c */
    private MarkerOptions f21252c;

    /* renamed from: d */
    private Marker f21253d;

    public void onAdd() {
    }

    public abstract void onCreate();

    public BaseMarker(IMapView iMapView) {
        this.f21250a = iMapView;
        onCreate();
    }

    public void onDestroy() {
        IMapView iMapView;
        Marker marker = this.f21253d;
        if (marker != null && (iMapView = this.f21250a) != null) {
            iMapView.remove(marker);
            this.f21253d = null;
        }
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        IMapView iMapView = this.f21250a;
        if (iMapView == null) {
            return null;
        }
        this.f21252c = markerOptions;
        Marker marker = this.f21253d;
        if (marker != null) {
            iMapView.remove(marker);
        }
        Marker addMarker = this.f21250a.addMarker(getClass().getSimpleName(), markerOptions);
        this.f21253d = addMarker;
        if (addMarker != null) {
            SystemUtils.log(3, "MapFragment", "setVisible: " + this.f21251b, (Throwable) null, "com.didi.foundation.sdk.map.BaseMarker", 68);
            this.f21253d.setVisible(this.f21251b);
            onAdd();
        }
        return this.f21253d;
    }

    public Marker getDidiCommonMarker() {
        return this.f21253d;
    }

    public BaseMarker setPosition(LatLng latLng) {
        MarkerOptions markerOptions;
        if (latLng == null || this.f21250a == null || (markerOptions = this.f21252c) == null) {
            return null;
        }
        Marker marker = this.f21253d;
        if (marker != null) {
            marker.setVisible(this.f21251b);
            this.f21253d.setPosition(latLng);
        } else {
            markerOptions.position(latLng);
            addMarker(this.f21252c);
        }
        return this;
    }

    public BaseMarker setRotation(float f) {
        Marker marker;
        if (this.f21250a == null || (marker = this.f21253d) == null) {
            return null;
        }
        marker.setRotation(f);
        return this;
    }

    public BaseMarker setVisible(boolean z) {
        this.f21251b = z;
        Marker marker = this.f21253d;
        if (marker == null) {
            return null;
        }
        marker.setVisible(z);
        return this;
    }

    public boolean isVisible() {
        Marker marker = this.f21253d;
        if (marker == null) {
            return false;
        }
        return marker.isVisible();
    }

    public void remove() {
        IMapView iMapView;
        Marker marker = this.f21253d;
        if (marker != null && (iMapView = this.f21250a) != null) {
            iMapView.remove(marker);
            this.f21253d = null;
        }
    }

    public BaseMarker setInfoWindowAdapter(Context context, View view) {
        Marker marker = this.f21253d;
        if (marker != null) {
            marker.buildInfoWindow(this.f21250a.getDidiCommonMap(), context).showInfoWindow(view);
        }
        return this;
    }

    public BaseMarker setInfoWindowVisible(boolean z) {
        Marker marker = this.f21253d;
        if (marker != null) {
            marker.getInfoWindow().getInfoWindowMarker().setVisible(z);
        }
        return this;
    }
}
