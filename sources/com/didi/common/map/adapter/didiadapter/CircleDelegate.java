package com.didi.common.map.adapter.didiadapter;

import android.graphics.Rect;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.ICircleDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.didi.map.outer.model.Circle;
import com.didi.util.HawaiiMapUtil;
import java.util.ArrayList;
import java.util.List;

public class CircleDelegate implements ICircleDelegate {

    /* renamed from: a */
    private Circle f10703a;

    /* renamed from: b */
    private CircleOptions f10704b;

    public CircleDelegate(Circle circle, CircleOptions circleOptions) {
        this.f10703a = circle;
        this.f10704b = circleOptions;
    }

    public LatLng getCenter() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            return Converter.convertFromDidiLatLng(circle.getCenter());
        }
        return null;
    }

    public int getFillColor() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            return circle.getFillColor();
        }
        return 0;
    }

    public double getRadius() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            return circle.getRadius();
        }
        return 0.0d;
    }

    public int getStrokeColor() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            return circle.getStrokeColor();
        }
        return 0;
    }

    public float getStrokeWidth() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            return circle.getStrokeWidth();
        }
        return 0.0f;
    }

    public void setCenter(LatLng latLng) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setCenter(Converter.convertToDidiLatLng(latLng));
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.center(latLng);
            }
        }
    }

    public void setFillColor(int i) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setFillColor(i);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.fillColor(i);
            }
        }
    }

    public void setRadius(double d) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setRadius(d);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.radius(d);
            }
        }
    }

    public void setStrokeColor(int i) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setStrokeColor(i);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.strokeColor(i);
            }
        }
    }

    public void setStrokeWidth(float f) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setStrokeWidth(f);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.strokeWidth(f);
            }
        }
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Circle circle = this.f10703a;
        if (circle != null && iMapElementOptions != null && (iMapElementOptions instanceof CircleOptions)) {
            CircleOptions circleOptions = (CircleOptions) iMapElementOptions;
            circle.setOptions(Converter.convertToDidiCircleOptions(circleOptions));
            this.f10704b = circleOptions;
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10704b;
    }

    public String getId() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle == null) {
            return null;
        }
        return String.valueOf(circle.hashCode());
    }

    public void remove() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.remove();
            this.f10703a = null;
            this.f10704b = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setZIndex((float) i);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle == null) {
            return 0;
        }
        return (int) circle.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle != null) {
            circle.setVisible(z);
            CircleOptions circleOptions = this.f10704b;
            if (circleOptions != null) {
                circleOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Circle circle = this.f10703a;
        if (circle == null) {
            return false;
        }
        return circle.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        DLog.m7384d("circle", "isClickable not support", new Object[0]);
        return false;
    }

    public void setClickable(boolean z) {
        DLog.m7384d("circle", "setClickable not support", new Object[0]);
    }

    public Object getElement() {
        return this.f10703a;
    }

    public List<LatLng> getBounderPoints() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f10703a;
        if (circle != null) {
            Rect bound = circle.getBound();
            LatLng latLng = new LatLng(((double) bound.bottom) / 1000000.0d, ((double) bound.left) / 1000000.0d);
            LatLng latLng2 = new LatLng(((double) bound.top) / 1000000.0d, ((double) bound.right) / 1000000.0d);
            arrayList.add(latLng);
            arrayList.add(latLng2);
        }
        return arrayList;
    }

    public boolean contains(LatLng latLng) {
        return HawaiiMapUtil.getDistance(Converter.convertToDidiLatLng(latLng), this.f10703a.getCenter()) / 10.0d < this.f10703a.getRadius();
    }

    public LatLng getBottomTangencyPoint() {
        Circle circle = this.f10703a;
        if (circle == null) {
            return null;
        }
        return new LatLng(((double) circle.getBound().bottom) / 1000000.0d, this.f10703a.getCenter().longitude);
    }
}
