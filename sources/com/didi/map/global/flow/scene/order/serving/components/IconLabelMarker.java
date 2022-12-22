package com.didi.map.global.flow.scene.order.serving.components;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.didi.common.map.MapView;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.global.flow.scene.order.serving.components.LabelMarker;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.ArrayList;
import java.util.List;

public class IconLabelMarker {

    /* renamed from: a */
    private MapView f26755a;

    /* renamed from: b */
    private Marker f26756b;

    /* renamed from: c */
    private LabelMarker f26757c;

    /* renamed from: d */
    private IconLabelMarkerInfo f26758d;

    public IconLabelMarker(MapView mapView) {
        this.f26755a = mapView;
    }

    public IconLabelMarker create(IconLabelMarkerInfo iconLabelMarkerInfo) {
        this.f26758d = iconLabelMarkerInfo;
        MapView mapView = this.f26755a;
        if (!(mapView == null || mapView.getMap() == null || iconLabelMarkerInfo == null || iconLabelMarkerInfo.latLng == null)) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(iconLabelMarkerInfo.latLng).anchor(iconLabelMarkerInfo.markerIconAnchorU, iconLabelMarkerInfo.markerIconAnchorV).icon(m18909a(iconLabelMarkerInfo.markerIcon, 1.0f)).draggable(false).clickable(true).zIndex(iconLabelMarkerInfo.markerIconZIndex);
            this.f26756b = this.f26755a.getMap().addMarker(markerOptions);
        }
        if (!(iconLabelMarkerInfo == null || iconLabelMarkerInfo.latLng == null || TextUtils.isEmpty(iconLabelMarkerInfo.label))) {
            this.f26757c = new LabelMarker(this.f26755a).position(iconLabelMarkerInfo.latLng).label(iconLabelMarkerInfo.label).labelColor(iconLabelMarkerInfo.labelColorResId).anchorIcon(iconLabelMarkerInfo.labelAnchorIcon).labelRule(iconLabelMarkerInfo.labelRule).zIndex(iconLabelMarkerInfo.labelZIndex).create();
        }
        return this;
    }

    /* renamed from: a */
    private BitmapDescriptor m18909a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return BitmapDescriptorFactory.fromBitmap(m18910b(bitmap, f));
    }

    /* renamed from: b */
    private Bitmap m18910b(Bitmap bitmap, float f) {
        if (f == 1.0f) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public void destory() {
        for (Marker remove : getMarkers()) {
            this.f26755a.getMap().remove(remove);
        }
    }

    public List<Marker> getMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f26756b;
        if (marker != null) {
            arrayList.add(marker);
        }
        LabelMarker labelMarker = this.f26757c;
        if (labelMarker != null) {
            arrayList.add(labelMarker.getMarker());
        }
        return arrayList;
    }

    public Marker getIconMarker() {
        return this.f26756b;
    }

    public LabelMarker getLabelMarker() {
        return this.f26757c;
    }

    public static class IconLabelMarkerInfo {
        String label;
        BitmapDescriptor labelAnchorIcon;
        int labelColorResId;
        LabelMarker.ILabelRule labelRule;
        int labelZIndex;
        LatLng latLng;
        Bitmap markerIcon;
        float markerIconAnchorU;
        float markerIconAnchorV;
        int markerIconZIndex;
        MapElementId markerId;
        Bitmap maskMarkerIcon;

        public IconLabelMarkerInfo(MapElementId mapElementId, LatLng latLng2, Bitmap bitmap, float f, float f2, int i, String str, int i2, BitmapDescriptor bitmapDescriptor, int i3, LabelMarker.ILabelRule iLabelRule) {
            this(mapElementId, latLng2, bitmap, (String) null, f, f2, i, str, i2, bitmapDescriptor, i3, iLabelRule);
        }

        public IconLabelMarkerInfo(LatLng latLng2, Bitmap bitmap, float f, float f2, int i, String str, int i2, BitmapDescriptor bitmapDescriptor, int i3, LabelMarker.ILabelRule iLabelRule) {
            this((MapElementId) null, latLng2, bitmap, (String) null, f, f2, i, str, i2, bitmapDescriptor, i3, iLabelRule);
        }

        public IconLabelMarkerInfo(MapElementId mapElementId, LatLng latLng2, Bitmap bitmap, String str, float f, float f2, int i, String str2, int i2, BitmapDescriptor bitmapDescriptor, int i3, LabelMarker.ILabelRule iLabelRule) {
            this.markerId = mapElementId;
            this.latLng = latLng2;
            this.markerIcon = bitmap;
            this.markerIconAnchorU = f;
            this.markerIconAnchorV = f2;
            this.markerIconZIndex = i;
            this.label = str2;
            this.labelColorResId = i2;
            this.labelAnchorIcon = bitmapDescriptor;
            this.labelZIndex = i3;
            this.labelRule = iLabelRule;
            if (bitmap != null && str != null) {
                try {
                    Color.parseColor(str);
                    this.maskMarkerIcon = bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
