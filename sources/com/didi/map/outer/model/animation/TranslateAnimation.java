package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.core.animation.MapTranslateAnimation;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;

public class TranslateAnimation extends Animation {
    private LatLng latLngFrom = null;
    private LatLng latLngTo = null;

    public TranslateAnimation(LatLng latLng) {
        this.latLngTo = latLng;
        GeoPoint geoPointFromLatLng = MapUtil.getGeoPointFromLatLng(latLng);
        if (this.animation == null) {
            this.animation = new MapTranslateAnimation(geoPointFromLatLng);
        }
    }

    public TranslateAnimation(LatLng latLng, LatLng latLng2) {
        this.latLngFrom = latLng;
        this.latLngTo = latLng2;
        GeoPoint geoPointFromLatLng = MapUtil.getGeoPointFromLatLng(latLng2);
        if (this.animation == null) {
            this.animation = new MapTranslateAnimation(geoPointFromLatLng);
        }
    }

    public LatLng getLatLngFrom() {
        return this.latLngFrom;
    }

    public LatLng getLatLngTo() {
        return this.latLngTo;
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }
}
