package com.didi.map.core.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapAnimation;
import com.didi.map.core.point.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class MapAnimationSet extends MapAnimation {
    protected boolean boShareInterpolator = true;
    protected List<MapAnimation> listAnimations = null;

    public MapAnimationSet(boolean z) {
        this.boShareInterpolator = z;
        if (0 == 0) {
            this.listAnimations = new ArrayList();
        }
    }

    public void addAnimation(MapAnimation mapAnimation) {
        if (mapAnimation != null) {
            this.listAnimations.add(mapAnimation);
        }
    }

    public void cleanAnimation() {
        List<MapAnimation> list = this.listAnimations;
        if (list != null) {
            list.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        int size;
        List<MapAnimation> list = this.listAnimations;
        if (list != null && (size = list.size()) != 0) {
            for (int i = 0; i < size; i++) {
                MapAnimation mapAnimation = this.listAnimations.get(i);
                if (mapAnimation != null) {
                    if (this.boShareInterpolator) {
                        mapAnimation.performAnimation(f, interpolator);
                    } else {
                        mapAnimation.performAnimation(f, mapAnimation.getInterpolator());
                    }
                }
            }
        }
    }

    public boolean startAnimation(GeoPoint geoPoint, GeoPoint geoPoint2) {
        List<MapAnimation> list;
        int size;
        boolean startAnimation = super.startAnimation(geoPoint, geoPoint2);
        if (!startAnimation || (list = this.listAnimations) == null || (size = list.size()) == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            MapAnimation mapAnimation = this.listAnimations.get(i);
            if (mapAnimation != null) {
                startAnimation = startAnimation && mapAnimation.startAnimation(geoPoint, geoPoint2);
            }
        }
        return startAnimation;
    }

    public void setAnimationProperty(MapAnimation.SetAnimatePropertyListener setAnimatePropertyListener) {
        int size;
        super.setAnimationProperty(setAnimatePropertyListener);
        List<MapAnimation> list = this.listAnimations;
        if (list != null && (size = list.size()) != 0) {
            for (int i = 0; i < size; i++) {
                MapAnimation mapAnimation = this.listAnimations.get(i);
                if (mapAnimation != null) {
                    mapAnimation.setAnimationProperty(setAnimatePropertyListener);
                }
            }
        }
    }
}
