package com.didi.map.global.flow.scene.vamos.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.vamos.model.VamosMarkerModel;
import java.util.ArrayList;
import java.util.List;

public class VamosMarkers {

    /* renamed from: a */
    private Marker f27053a;

    /* renamed from: b */
    private Marker f27054b;

    /* renamed from: c */
    private Marker f27055c;

    /* renamed from: d */
    private Marker f27056d;

    /* renamed from: e */
    private Marker f27057e;

    /* renamed from: f */
    private Map f27058f;

    /* renamed from: g */
    private Context f27059g;

    public VamosMarkers(Map map) {
        if (map != null) {
            this.f27058f = map;
            this.f27059g = map.getContext();
        }
    }

    public void updateAllMarkers(VamosMarkerModel vamosMarkerModel) {
        if (vamosMarkerModel != null) {
            if (!(vamosMarkerModel.mPaxStartPosition == null || vamosMarkerModel.mPaxStartMarkerBitmap == null)) {
                addOrUpdatePaxStartMarker(vamosMarkerModel.mPaxStartPosition, vamosMarkerModel.mPaxStartMarkerBitmap);
            }
            if (!(vamosMarkerModel.mDriverStartPosition == null || vamosMarkerModel.mDriverStartMarkerBitmap == null)) {
                addOrUpdateDriverStartMarker(vamosMarkerModel.mDriverStartPosition, vamosMarkerModel.mDriverStartMarkerBitmap);
            }
            if (!(vamosMarkerModel.mDriverEndPosition == null || vamosMarkerModel.mDriverEndMarkerBitmap == null)) {
                addOrUpdateDriverEndMarker(vamosMarkerModel.mDriverEndPosition, vamosMarkerModel.mDriverEndMarkerBitmap);
            }
            if (vamosMarkerModel.mPaxEndPosition != null && vamosMarkerModel.mPaxEndMarkerBitmap != null) {
                addOrUpdatePaxEndMarker(vamosMarkerModel.mPaxEndPosition, vamosMarkerModel.mPaxEndMarkerBitmap);
            }
        }
    }

    public void addOrUpdatePaxStartMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f27053a;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(133);
            Map map = this.f27058f;
            if (map != null) {
                this.f27053a = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f27053a.setIcon(this.f27059g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdatePaxStartMarkerBubble(View view) {
        Marker marker;
        Map map;
        if (view != null && (marker = this.f27053a) != null && (map = this.f27058f) != null) {
            InfoWindow buildInfoWindow = marker.buildInfoWindow(map, map.getContext().getApplicationContext());
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                DLog.m7384d("VamosMarkers", "Pax start bubble", new Object[0]);
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(133);
            }
        }
    }

    public void addOrUpdatePaxEndMarkerBubble(View view) {
        Marker marker;
        Map map;
        if (view != null && (marker = this.f27054b) != null && (map = this.f27058f) != null) {
            InfoWindow buildInfoWindow = marker.buildInfoWindow(map, map.getContext().getApplicationContext());
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                DLog.m7384d("VamosMarkers", "Pax end bubble", new Object[0]);
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(132);
            }
        }
    }

    public void addOrUpdatePaxEndMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f27054b;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(132);
            Map map = this.f27058f;
            if (map != null) {
                this.f27054b = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f27054b.setIcon(this.f27059g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdateDriverStartMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f27055c;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(131);
            Map map = this.f27058f;
            if (map != null) {
                this.f27055c = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f27055c.setIcon(this.f27059g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public void addOrUpdateDriverEndMarker(LatLng latLng, Bitmap bitmap) {
        Marker marker = this.f27056d;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f).position(latLng).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).zIndex(130);
            Map map = this.f27058f;
            if (map != null) {
                this.f27056d = map.addMarker(markerOptions);
                return;
            }
            return;
        }
        marker.setPosition(latLng);
        this.f27056d.setIcon(this.f27059g, BitmapDescriptorFactory.fromBitmap(bitmap));
    }

    public List<IMapElement> getAllMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f27053a;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.f27054b;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        Marker marker3 = this.f27055c;
        if (marker3 != null) {
            arrayList.add(marker3);
        }
        Marker marker4 = this.f27056d;
        if (marker4 != null) {
            arrayList.add(marker4);
        }
        Marker marker5 = this.f27057e;
        if (marker5 != null) {
            arrayList.add(marker5);
        }
        return arrayList;
    }

    public void removeAllMarkers() {
        Map map = this.f27058f;
        if (map != null) {
            Marker marker = this.f27053a;
            if (marker != null) {
                map.remove(marker);
                this.f27053a = null;
            }
            Marker marker2 = this.f27054b;
            if (marker2 != null) {
                this.f27058f.remove(marker2);
                this.f27054b = null;
            }
            Marker marker3 = this.f27055c;
            if (marker3 != null) {
                this.f27058f.remove(marker3);
                this.f27055c = null;
            }
            Marker marker4 = this.f27056d;
            if (marker4 != null) {
                this.f27058f.remove(marker4);
                this.f27056d = null;
            }
            Marker marker5 = this.f27057e;
            if (marker5 != null) {
                this.f27058f.remove(marker5);
                this.f27057e = null;
            }
        }
    }
}
