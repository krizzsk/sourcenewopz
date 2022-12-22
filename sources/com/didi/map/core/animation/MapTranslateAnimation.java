package com.didi.map.core.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.point.GeoPoint;

public class MapTranslateAnimation extends MapAnimation {

    /* renamed from: a */
    private GeoPoint f24723a = null;

    /* renamed from: b */
    private GeoPoint f24724b = null;

    /* renamed from: c */
    private boolean f24725c = false;

    public MapTranslateAnimation(GeoPoint geoPoint) {
        if (geoPoint != null) {
            this.f24724b = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.f24725c = true;
        }
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        GeoPoint geoPoint = this.f24724b;
        if (geoPoint != null && this.f24723a != null) {
            int latitudeE6 = geoPoint.getLatitudeE6() - this.f24723a.getLatitudeE6();
            float interpolation = interpolator.getInterpolation(f);
            int latitudeE62 = this.f24723a.getLatitudeE6() + ((int) (((float) latitudeE6) * interpolation));
            int longitudeE6 = this.f24723a.getLongitudeE6() + ((int) (((float) (this.f24724b.getLongitudeE6() - this.f24723a.getLongitudeE6())) * interpolation));
            if (this.animationProperty != null) {
                this.animationProperty.setPosition(latitudeE62, longitudeE6);
            }
        }
    }

    public boolean startAnimation(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (!super.startAnimation((GeoPoint) null, (GeoPoint) null)) {
            return false;
        }
        if (geoPoint != null) {
            this.f24723a = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        }
        if (this.f24725c || geoPoint2 == null) {
            return true;
        }
        this.f24724b = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
        return true;
    }
}
