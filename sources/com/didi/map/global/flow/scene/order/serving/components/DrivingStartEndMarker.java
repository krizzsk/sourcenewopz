package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.MapView;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.map.global.flow.scene.order.serving.components.IconLabelMarker;
import com.didi.map.global.flow.scene.order.serving.components.LabelMarker;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.ArrayList;
import java.util.List;

public class DrivingStartEndMarker {

    /* renamed from: a */
    private IconLabelMarker f26751a;

    /* renamed from: b */
    private IconLabelMarker f26752b;

    /* renamed from: c */
    private IconLabelMarker f26753c;

    /* renamed from: d */
    private Context f26754d;

    public DrivingStartEndMarker(Context context) {
        this.f26754d = context;
    }

    public void addStartMarker(MapView mapView, IconLabelMarker.IconLabelMarkerInfo iconLabelMarkerInfo) {
        removeStartMarker();
        if (mapView != null && iconLabelMarkerInfo != null) {
            this.f26751a = new IconLabelMarker(mapView).create(iconLabelMarkerInfo);
        }
    }

    public void addRecommendStartMarker(MapView mapView, IconLabelMarker.IconLabelMarkerInfo iconLabelMarkerInfo) {
        removeRecommendStartMarker();
        if (mapView != null && iconLabelMarkerInfo != null) {
            this.f26752b = new IconLabelMarker(mapView).create(iconLabelMarkerInfo);
        }
    }

    public void addEndMarker(MapView mapView, IconLabelMarker.IconLabelMarkerInfo iconLabelMarkerInfo) {
        removeEndMarker();
        if (mapView != null && iconLabelMarkerInfo != null) {
            this.f26753c = new IconLabelMarker(mapView).create(iconLabelMarkerInfo);
        }
    }

    public void removeStartMarker() {
        IconLabelMarker iconLabelMarker = this.f26751a;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
            this.f26751a = null;
        }
    }

    public void removeRecommendStartMarker() {
        IconLabelMarker iconLabelMarker = this.f26752b;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
            this.f26752b = null;
        }
    }

    public void removeEndMarker() {
        IconLabelMarker iconLabelMarker = this.f26753c;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
            this.f26753c = null;
        }
    }

    public void removeMarkers() {
        removeStartMarker();
        removeRecommendStartMarker();
        removeEndMarker();
    }

    public List<IMapElement> getStartMapElements() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f26751a;
        if (!(iconLabelMarker == null || iconLabelMarker.getMarkers() == null)) {
            arrayList.addAll(this.f26751a.getMarkers());
        }
        return arrayList;
    }

    public List<IMapElement> getRecommendStartMapElements() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f26752b;
        if (!(iconLabelMarker == null || iconLabelMarker.getMarkers() == null)) {
            arrayList.addAll(this.f26752b.getMarkers());
        }
        return arrayList;
    }

    public List<IMapElement> getEndMapElements() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f26753c;
        if (!(iconLabelMarker == null || iconLabelMarker.getMarkers() == null)) {
            arrayList.addAll(this.f26753c.getMarkers());
        }
        return arrayList;
    }

    public List<IMapElement> getMapElements() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f26751a;
        if (!(iconLabelMarker == null || iconLabelMarker.getMarkers() == null)) {
            arrayList.addAll(this.f26751a.getMarkers());
        }
        IconLabelMarker iconLabelMarker2 = this.f26752b;
        if (!(iconLabelMarker2 == null || iconLabelMarker2.getMarkers() == null)) {
            arrayList.addAll(this.f26752b.getMarkers());
        }
        IconLabelMarker iconLabelMarker3 = this.f26753c;
        if (!(iconLabelMarker3 == null || iconLabelMarker3.getMarkers() == null)) {
            arrayList.addAll(this.f26753c.getMarkers());
        }
        return arrayList;
    }

    public Marker getStartIconMarker() {
        IconLabelMarker iconLabelMarker = this.f26751a;
        if (iconLabelMarker != null) {
            return iconLabelMarker.getIconMarker();
        }
        return null;
    }

    public LabelMarker getStartLabelMarker() {
        IconLabelMarker iconLabelMarker = this.f26751a;
        if (iconLabelMarker != null) {
            return iconLabelMarker.getLabelMarker();
        }
        return null;
    }

    public Marker getRecommendStartIconMarker() {
        IconLabelMarker iconLabelMarker = this.f26752b;
        if (iconLabelMarker != null) {
            return iconLabelMarker.getIconMarker();
        }
        return null;
    }

    public Marker getEndIconMarker() {
        IconLabelMarker iconLabelMarker = this.f26753c;
        if (iconLabelMarker != null) {
            return iconLabelMarker.getIconMarker();
        }
        return null;
    }

    public static class StartEndMarkerInfoBuilder {
        String label = null;
        BitmapDescriptor labelAnchorIcon = LabelMarker.DEFAULT_ANCHOR_ICON;
        int labelColorResid = LabelMarker.DEFAULT_COLOR;
        LabelMarker.ILabelRule labelRule = LabelMarker.DEFAULT_LABEL_RULE;
        int labelZIndex = 0;
        LatLng latLng = null;
        Bitmap markerIcon;
        float markerIconAnchorU = 0.5f;
        float markerIconAnchorV = 1.0f;
        int markerIconZIndex = 0;
        String maskColor;

        public StartEndMarkerInfoBuilder position(LatLng latLng2) {
            this.latLng = latLng2;
            return this;
        }

        public StartEndMarkerInfoBuilder markerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
            return this;
        }

        public StartEndMarkerInfoBuilder maskColor(String str) {
            this.maskColor = str;
            return this;
        }

        public StartEndMarkerInfoBuilder markerIconAnchorU(float f) {
            this.markerIconAnchorU = f;
            return this;
        }

        public StartEndMarkerInfoBuilder markerIconAnchorV(float f) {
            this.markerIconAnchorV = f;
            return this;
        }

        public StartEndMarkerInfoBuilder markerIconZIndex(int i) {
            this.markerIconZIndex = i;
            return this;
        }

        public StartEndMarkerInfoBuilder label(String str) {
            this.label = str;
            return this;
        }

        public StartEndMarkerInfoBuilder labelColor(int i) {
            this.labelColorResid = i;
            return this;
        }

        public StartEndMarkerInfoBuilder labelAnchorIcon(BitmapDescriptor bitmapDescriptor) {
            this.labelAnchorIcon = bitmapDescriptor;
            return this;
        }

        public StartEndMarkerInfoBuilder labelZIndex(int i) {
            this.labelZIndex = i;
            return this;
        }

        public StartEndMarkerInfoBuilder labelRule(LabelMarker.ILabelRule iLabelRule) {
            this.labelRule = iLabelRule;
            return this;
        }

        public IconLabelMarker.IconLabelMarkerInfo create() {
            return new IconLabelMarker.IconLabelMarkerInfo((MapElementId) null, this.latLng, this.markerIcon, this.maskColor, this.markerIconAnchorU, this.markerIconAnchorV, this.markerIconZIndex, this.label, this.labelColorResid, this.labelAnchorIcon, this.labelZIndex, this.labelRule);
        }
    }
}
