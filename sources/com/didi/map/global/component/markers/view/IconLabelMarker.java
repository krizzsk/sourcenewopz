package com.didi.map.global.component.markers.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.common.DMarker;
import java.util.ArrayList;
import java.util.List;

public class IconLabelMarker {

    /* renamed from: a */
    private Map f25984a;

    /* renamed from: b */
    private String f25985b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Marker f25986c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LabelMarker f25987d;

    /* renamed from: e */
    private Context f25988e;

    /* renamed from: f */
    private IconLabelMarkerInfo f25989f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IconLabelMarkerClickListener f25990g;

    /* renamed from: h */
    private OnMarkerClickListener f25991h = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (marker.equals(IconLabelMarker.this.f25986c)) {
                if (IconLabelMarker.this.f25990g == null) {
                    return false;
                }
                IconLabelMarker.this.f25990g.onClick(IconLabelMarker.this);
                return false;
            } else if (IconLabelMarker.this.f25987d == null || !marker.equals(IconLabelMarker.this.f25987d.getMarker()) || IconLabelMarker.this.f25990g == null) {
                return false;
            } else {
                IconLabelMarker.this.f25990g.onClick(IconLabelMarker.this);
                return false;
            }
        }
    };

    public interface IconLabelMarkerClickListener {
        boolean onClick(IconLabelMarker iconLabelMarker);
    }

    public IconLabelMarker(Map map, String str, Context context) {
        this.f25984a = map;
        this.f25985b = str;
        this.f25988e = context;
    }

    /* renamed from: a */
    private DMarker m18471a() {
        DMarker dMarker = new DMarker();
        dMarker.mRootMarker = this.f25986c;
        IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
        if (iconLabelMarkerInfo != null) {
            dMarker.mRootMarkerPadding = iconLabelMarkerInfo.markerIconPadding;
            dMarker.mLabelMarkerPadding = this.f25989f.labelAnchorPadding;
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            dMarker.mLabelMarker = labelMarker.getMarker();
        }
        dMarker.f24811id = this.f25985b;
        return dMarker;
    }

    public void setOnClickListener(IconLabelMarkerClickListener iconLabelMarkerClickListener) {
        this.f25990g = iconLabelMarkerClickListener;
    }

    public IconLabelMarker create(IconLabelMarkerInfo iconLabelMarkerInfo) {
        if (!(iconLabelMarkerInfo == null || iconLabelMarkerInfo.latLng == null || this.f25984a == null)) {
            this.f25989f = iconLabelMarkerInfo;
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(iconLabelMarkerInfo.latLng).anchor(iconLabelMarkerInfo.markerIconAnchorU, iconLabelMarkerInfo.markerIconAnchorV).icon(BitmapDescriptorFactory.fromBitmap(iconLabelMarkerInfo.markerIcon)).draggable(false).clickable(iconLabelMarkerInfo.isClickable).zIndex(iconLabelMarkerInfo.markerIconZIndex);
            this.f25986c = this.f25984a.addMarker(markerOptions);
            if (!TextUtils.isEmpty(iconLabelMarkerInfo.label)) {
                this.f25987d = new LabelMarker(this.f25984a).position(iconLabelMarkerInfo.latLng).label(iconLabelMarkerInfo.label).labelView(iconLabelMarkerInfo.labelView).zIndex(iconLabelMarkerInfo.labelZIndex).rootMarkerAnchor(BitmapDescriptorFactory.fromBitmap(iconLabelMarkerInfo.markerIcon), iconLabelMarkerInfo.markerIconAnchorU, iconLabelMarkerInfo.markerIconAnchorV, iconLabelMarkerInfo.markerIconPadding).labelAnchorPadding(iconLabelMarkerInfo.getLabelAnchorPadding()).clickable(iconLabelMarkerInfo.isClickable).labelDirection(iconLabelMarkerInfo.getLabelDirection()).isSelected(iconLabelMarkerInfo.isLabelSelected).create();
            }
            this.f25984a.addOnMarkerClickListener(this.f25991h);
            if (!(iconLabelMarkerInfo == null || iconLabelMarkerInfo.getStrategy() == null)) {
                iconLabelMarkerInfo.getStrategy().addMarker(m18471a());
            }
        }
        return this;
    }

    public void setPosition(LatLng latLng) {
        IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
        if (iconLabelMarkerInfo != null) {
            iconLabelMarkerInfo.setLatLng(latLng);
        }
        Marker marker = this.f25986c;
        if (marker != null) {
            marker.setPosition(latLng);
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            labelMarker.setPosition(latLng);
        }
    }

    public String getMarkId() {
        return this.f25985b;
    }

    public void setLabelVisible(boolean z) {
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            labelMarker.setVisible(z);
        }
    }

    public void show() {
        setVisible(true);
    }

    public void hide() {
        setVisible(false);
    }

    public void setVisible(boolean z) {
        Marker marker = this.f25986c;
        if (marker != null) {
            marker.setVisible(z);
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            labelMarker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.f25986c;
        return marker != null && marker.isVisible();
    }

    public void destory() {
        IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
        if (!(iconLabelMarkerInfo == null || iconLabelMarkerInfo.getStrategy() == null)) {
            this.f25989f.getStrategy().removeMarker(this.f25985b);
        }
        for (IMapElement next : getMarkers()) {
            Map map = this.f25984a;
            if (map != null) {
                map.remove(next);
            }
        }
        this.f25984a.removeOnMarkerClickListener(this.f25991h);
    }

    public void setMarkerIcon(Bitmap bitmap) {
        if (this.f25986c != null && this.f25988e != null) {
            IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
            if (iconLabelMarkerInfo != null) {
                iconLabelMarkerInfo.setMarkerIcon(bitmap);
            }
            this.f25986c.setIcon(this.f25988e, BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    public List<Marker> getMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f25986c;
        if (marker != null) {
            arrayList.add(marker);
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            arrayList.add(labelMarker.getMarker());
        }
        return arrayList;
    }

    public Marker getIconMarker() {
        return this.f25986c;
    }

    public LabelMarker getLabelMarker() {
        return this.f25987d;
    }

    public float getAlpha() {
        Marker marker = this.f25986c;
        if (marker != null) {
            return marker.getAlpha();
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            return labelMarker.getAlpha();
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        Marker marker = this.f25986c;
        if (marker != null) {
            marker.setAlpha(f);
        }
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            labelMarker.setAlpha(f);
        }
    }

    public void updateMarkerLabelDirect(int i) {
        LabelMarker labelMarker;
        if (this.f25989f != null && this.f25984a != null && (labelMarker = this.f25987d) != null && labelMarker.getLabelDirection() != i && !TextUtils.isEmpty(this.f25989f.label)) {
            this.f25987d.destroy();
            this.f25987d = new LabelMarker(this.f25984a).position(this.f25989f.latLng).label(this.f25989f.label).labelView(this.f25989f.labelView).zIndex(this.f25989f.labelZIndex).labelDirection(i).isSelected(this.f25989f.isLabelSelected).clickable(this.f25989f.isClickable).rootMarkerAnchor(BitmapDescriptorFactory.fromBitmap(this.f25989f.markerIcon), this.f25989f.markerIconAnchorU, this.f25989f.markerIconAnchorV, this.f25989f.markerIconPadding).labelAnchorPadding(this.f25989f.getLabelAnchorPadding()).create();
            this.f25989f.setLabelDirection(i);
            IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
            if (iconLabelMarkerInfo != null && iconLabelMarkerInfo.getStrategy() != null) {
                this.f25989f.getStrategy().updateMarker(m18471a());
            }
        }
    }

    public void addMarkerLabel(IconLabelMarkerInfo iconLabelMarkerInfo) {
        if (this.f25989f != null && this.f25984a != null && this.f25987d == null && iconLabelMarkerInfo != null && !TextUtils.isEmpty(iconLabelMarkerInfo.label)) {
            String unused = this.f25989f.label = iconLabelMarkerInfo.label;
            boolean unused2 = this.f25989f.isLabelSelected = iconLabelMarkerInfo.isLabelSelected;
            Padding unused3 = this.f25989f.labelAnchorPadding = iconLabelMarkerInfo.labelAnchorPadding;
            int unused4 = this.f25989f.labelDirection = iconLabelMarkerInfo.labelDirection;
            ILabelView unused5 = this.f25989f.labelView = iconLabelMarkerInfo.labelView;
            int unused6 = this.f25989f.labelZIndex = iconLabelMarkerInfo.labelZIndex;
            this.f25987d = new LabelMarker(this.f25984a).position(this.f25989f.latLng).label(this.f25989f.label).labelView(this.f25989f.labelView).zIndex(this.f25989f.labelZIndex).labelDirection(this.f25989f.labelDirection).isSelected(this.f25989f.isLabelSelected).clickable(this.f25989f.isClickable).rootMarkerAnchor(BitmapDescriptorFactory.fromBitmap(this.f25989f.markerIcon), this.f25989f.markerIconAnchorU, this.f25989f.markerIconAnchorV, this.f25989f.markerIconPadding).labelAnchorPadding(this.f25989f.getLabelAnchorPadding()).create();
            if (this.f25989f.getStrategy() != null) {
                this.f25989f.getStrategy().updateMarker(m18471a());
                return;
            }
            ICollideStrategy unused7 = this.f25989f.strategy = iconLabelMarkerInfo.strategy;
            if (this.f25989f.getStrategy() != null) {
                this.f25989f.getStrategy().addMarker(m18471a());
            }
        }
    }

    public void updateLabelView(ILabelView iLabelView) {
        LabelMarker labelMarker;
        if (this.f25989f != null && this.f25984a != null && (labelMarker = this.f25987d) != null && iLabelView != null) {
            labelMarker.updateLabelView(iLabelView);
            this.f25989f.setLabelView(iLabelView);
            IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
            if (iconLabelMarkerInfo != null && iconLabelMarkerInfo.getStrategy() != null) {
                this.f25989f.getStrategy().updateMarker(m18471a());
            }
        }
    }

    public void updateLabelSelected(boolean z) {
        LabelMarker labelMarker;
        if (this.f25989f != null && this.f25984a != null && (labelMarker = this.f25987d) != null && labelMarker.getLabelSelected() != z && !TextUtils.isEmpty(this.f25989f.label)) {
            this.f25987d.destroy();
            this.f25987d = new LabelMarker(this.f25984a).position(this.f25989f.latLng).label(this.f25989f.label).labelView(this.f25989f.labelView).zIndex(this.f25989f.labelZIndex).isSelected(z).labelDirection(this.f25989f.labelDirection).clickable(this.f25989f.isClickable).rootMarkerAnchor(BitmapDescriptorFactory.fromBitmap(this.f25989f.markerIcon), this.f25989f.markerIconAnchorU, this.f25989f.markerIconAnchorV, this.f25989f.markerIconPadding).labelAnchorPadding(this.f25989f.getLabelAnchorPadding()).create();
            IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
            if (!(iconLabelMarkerInfo == null || iconLabelMarkerInfo.getStrategy() == null)) {
                this.f25989f.getStrategy().updateMarker(m18471a());
            }
            boolean unused = this.f25989f.isLabelSelected = z;
        }
    }

    public void updateLabel(String str) {
        if (this.f25989f != null && this.f25984a != null && this.f25987d != null && !TextUtils.isEmpty(str)) {
            this.f25987d.destroy();
            this.f25987d = new LabelMarker(this.f25984a).position(this.f25989f.latLng).label(str).labelView(this.f25989f.labelView).zIndex(this.f25989f.labelZIndex).labelDirection(this.f25989f.labelDirection).isSelected(this.f25989f.isLabelSelected).clickable(this.f25989f.isClickable).rootMarkerAnchor(BitmapDescriptorFactory.fromBitmap(this.f25989f.markerIcon), this.f25989f.markerIconAnchorU, this.f25989f.markerIconAnchorV, this.f25989f.markerIconPadding).labelAnchorPadding(this.f25989f.getLabelAnchorPadding()).create();
            this.f25989f.setLabel(str);
            IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
            if (iconLabelMarkerInfo != null && iconLabelMarkerInfo.getStrategy() != null) {
                this.f25989f.getStrategy().updateMarker(m18471a());
            }
        }
    }

    public void updateLabelZindex(int i) {
        LabelMarker labelMarker;
        if (this.f25989f != null && this.f25984a != null && (labelMarker = this.f25987d) != null && labelMarker.getMarker() != null) {
            this.f25989f.setLabelZIndex(i);
            this.f25987d.getMarker().setZIndex(i);
        }
    }

    public void updateMarkerZindex(int i) {
        IconLabelMarkerInfo iconLabelMarkerInfo = this.f25989f;
        if (iconLabelMarkerInfo != null && this.f25984a != null && this.f25986c != null) {
            iconLabelMarkerInfo.setMarkerIconZIndex(i);
            this.f25986c.setZIndex(i);
        }
    }

    public int getMarkerLabelDirect() {
        LabelMarker labelMarker = this.f25987d;
        if (labelMarker != null) {
            return labelMarker.getLabelDirection();
        }
        return 0;
    }

    public static class IconLabelMarkerInfo {
        /* access modifiers changed from: private */
        public boolean isClickable;
        /* access modifiers changed from: private */
        public boolean isLabelSelected;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public Padding labelAnchorPadding;
        /* access modifiers changed from: private */
        public int labelDirection;
        /* access modifiers changed from: private */
        public ILabelView labelView;
        /* access modifiers changed from: private */
        public int labelZIndex;
        /* access modifiers changed from: private */
        public LatLng latLng;
        /* access modifiers changed from: private */
        public Bitmap markerIcon;
        /* access modifiers changed from: private */
        public float markerIconAnchorU;
        /* access modifiers changed from: private */
        public float markerIconAnchorV;
        /* access modifiers changed from: private */
        public Padding markerIconPadding;
        /* access modifiers changed from: private */
        public int markerIconZIndex;
        /* access modifiers changed from: private */
        public ICollideStrategy strategy;

        public ICollideStrategy getStrategy() {
            return this.strategy;
        }

        public LatLng getLatLng() {
            return this.latLng;
        }

        public void setLatLng(LatLng latLng2) {
            this.latLng = latLng2;
        }

        public Bitmap getMarkerIcon() {
            return this.markerIcon;
        }

        public void setMarkerIcon(Bitmap bitmap) {
            this.markerIcon = bitmap;
        }

        public float getMarkerIconAnchorU() {
            return this.markerIconAnchorU;
        }

        public void setMarkerIconAnchorU(float f) {
            this.markerIconAnchorU = f;
        }

        public float getMarkerIconAnchorV() {
            return this.markerIconAnchorV;
        }

        public void setMarkerIconAnchorV(float f) {
            this.markerIconAnchorV = f;
        }

        public Padding getMarkerIconPadding() {
            return this.markerIconPadding;
        }

        public void setMarkerIconPadding(Padding padding) {
            this.markerIconPadding = padding;
        }

        public int getMarkerIconZIndex() {
            return this.markerIconZIndex;
        }

        public void setMarkerIconZIndex(int i) {
            this.markerIconZIndex = i;
        }

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public int getLabelZIndex() {
            return this.labelZIndex;
        }

        public void setLabelZIndex(int i) {
            this.labelZIndex = i;
        }

        public ILabelView getLabelView() {
            return this.labelView;
        }

        public void setLabelView(ILabelView iLabelView) {
            this.labelView = iLabelView;
        }

        public int getLabelDirection() {
            return this.labelDirection;
        }

        public void setLabelDirection(int i) {
            this.labelDirection = i;
        }

        public boolean isClickable() {
            return this.isClickable;
        }

        public void setClickable(boolean z) {
            this.isClickable = z;
        }

        public Padding getLabelAnchorPadding() {
            return this.labelAnchorPadding;
        }

        public void setLabelAnchorPadding(Padding padding) {
            this.labelAnchorPadding = padding;
        }

        private IconLabelMarkerInfo(Builder builder) {
            this.latLng = builder.latLng;
            this.markerIcon = builder.markerIcon;
            this.markerIconAnchorU = builder.markerIconAnchorU;
            this.markerIconAnchorV = builder.markerIconAnchorV;
            this.markerIconPadding = builder.markerIconPadding;
            this.markerIconZIndex = builder.markerIconZIndex;
            this.label = builder.label;
            this.labelZIndex = builder.labelZIndex;
            this.labelView = builder.labelView;
            this.isClickable = builder.isClickable;
            this.labelDirection = builder.labelDirection;
            this.strategy = builder.strategy;
            this.isLabelSelected = builder.isLabelSelected;
            this.labelAnchorPadding = builder.labelAnchorPadding;
        }

        public static class Builder {
            boolean isClickable = false;
            boolean isLabelSelected = false;
            String label;
            Padding labelAnchorPadding;
            int labelDirection;
            ILabelView labelView;
            int labelZIndex;
            LatLng latLng;
            Bitmap markerIcon;
            float markerIconAnchorU;
            float markerIconAnchorV;
            Padding markerIconPadding;
            int markerIconZIndex;
            ICollideStrategy strategy;

            public IconLabelMarkerInfo build() {
                return new IconLabelMarkerInfo(this);
            }

            public Builder latlng(LatLng latLng2) {
                this.latLng = latLng2;
                return this;
            }

            public Builder markerIcon(Bitmap bitmap) {
                this.markerIcon = bitmap;
                return this;
            }

            public Builder isClickable(boolean z) {
                this.isClickable = z;
                return this;
            }

            public Builder markerIconAnchorU(float f) {
                this.markerIconAnchorU = f;
                return this;
            }

            public Builder markerIconAnchorV(float f) {
                this.markerIconAnchorV = f;
                return this;
            }

            public Builder markerIconPadding(Padding padding) {
                this.markerIconPadding = padding;
                return this;
            }

            public Builder markerIconZIndex(int i) {
                this.markerIconZIndex = i;
                return this;
            }

            public Builder label(String str) {
                this.label = str;
                return this;
            }

            public Builder labelZIndex(int i) {
                this.labelZIndex = i;
                return this;
            }

            public Builder isLabelSelected(boolean z) {
                this.isLabelSelected = z;
                return this;
            }

            public Builder labelView(ILabelView iLabelView) {
                this.labelView = iLabelView;
                return this;
            }

            public Builder labelDirection(int i) {
                this.labelDirection = i;
                return this;
            }

            public Builder labelAnchorPadding(Padding padding) {
                this.labelAnchorPadding = padding;
                return this;
            }

            public Builder strategy(ICollideStrategy iCollideStrategy) {
                this.strategy = iCollideStrategy;
                return this;
            }
        }
    }
}
