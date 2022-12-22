package com.rider.rlab_im_map_plugin.marker;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.ImageUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.map.ImMapView;
import com.taxis99.R;

public class MyLocationMarker extends AbsBaseMarker {

    /* renamed from: a */
    private static final String f55920a = "map_location_im_marker";

    /* renamed from: b */
    private final Map f55921b;

    /* renamed from: c */
    private ImMapView f55922c;

    /* renamed from: d */
    private final Logger f55923d = LoggerFactory.getLogger("MyLocationMarker");

    /* renamed from: e */
    private MarkerOptions f55924e;

    /* renamed from: f */
    private LatLng f55925f;
    public Marker marker;

    public MyLocationMarker(ImMapView imMapView, Map map) {
        this.f55922c = imMapView;
        this.f55921b = map;
        Context context = imMapView.getContext();
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(context, R.drawable.rider_im_d_map_location);
        if (fromResource != null) {
            Bitmap scaledBitmap = ImageUtil.getScaledBitmap(context, fromResource.getBitmap());
            MarkerOptions markerOptions = new MarkerOptions();
            this.f55924e = markerOptions;
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(scaledBitmap));
            this.f55924e.anchor(0.5f, 0.5f);
            this.f55924e.title("location");
            this.f55924e.zIndex(10);
        }
    }

    public Map getMap() {
        return this.f55921b;
    }

    public void addMarker() {
        MarkerOptions markerOptions;
        Map map = this.f55921b;
        if (map != null && (markerOptions = this.f55924e) != null) {
            this.marker = map.addMarker(f55920a, markerOptions);
            setVisible(this.f55924e.getPosition() != null);
        }
    }

    public void removeMarker() {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            this.f55921b.remove(marker2);
            this.marker = null;
        }
    }

    public void updatePosition(LatLng latLng) {
        if (latLng != null && latLng.longitude != 0.0d && latLng.latitude != 0.0d) {
            this.f55925f = latLng;
            ImMapView imMapView = this.f55922c;
            if (imMapView != null) {
                imMapView.updatePosition(latLng);
            }
            Marker marker2 = this.marker;
            if (marker2 == null) {
                MarkerOptions markerOptions = this.f55924e;
                if (markerOptions != null) {
                    markerOptions.position(latLng);
                    this.marker = this.f55921b.addMarker(f55920a, this.f55924e);
                    setVisible(true);
                }
            } else if (!latLng.equals(marker2.getPosition())) {
                this.marker.setPosition(latLng);
            }
        }
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getLatLng() {
        LatLng latLng = this.f55925f;
        return latLng == null ? new LatLng(0.0d, 0.0d) : latLng;
    }

    public void setZIndex(int i) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setZIndex(i);
        }
    }

    public void updateArrowRotateAngle(float f) {
        Marker marker2 = this.marker;
        if (marker2 != null && this.f55924e != null && ((double) Math.abs(f - marker2.getRotation())) > 0.8d) {
            this.f55924e.rotation(f);
            this.marker.setRotation(this.f55924e.getRotation());
        }
    }
}
