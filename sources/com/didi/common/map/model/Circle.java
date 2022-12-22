package com.didi.common.map.model;

import android.os.Bundle;
import com.didi.common.map.internal.ICircleDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import java.util.List;

public final class Circle implements IMapElement {

    /* renamed from: a */
    private ICircleDelegate f10803a;

    /* renamed from: b */
    private Bundle f10804b;

    /* renamed from: c */
    private Object f10805c;

    public Circle(ICircleDelegate iCircleDelegate) {
        this.f10803a = iCircleDelegate;
    }

    public LatLng getCenter() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.getCenter();
    }

    public int getFillColor() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return 0;
        }
        return iCircleDelegate.getFillColor();
    }

    public double getRadius() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return 0.0d;
        }
        return iCircleDelegate.getRadius();
    }

    public int getStrokeColor() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return 0;
        }
        return iCircleDelegate.getStrokeColor();
    }

    public float getStrokeWidth() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return 0.0f;
        }
        return iCircleDelegate.getStrokeWidth();
    }

    public void setCenter(LatLng latLng) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setCenter(latLng);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setFillColor(int i) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setFillColor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setRadius(double d) {
        if (this.f10803a != null) {
            try {
                if (Double.isNaN(d)) {
                    DLog.m7384d("map", "error radius is = " + d, new Object[0]);
                    return;
                }
                this.f10803a.setRadius(d);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setStrokeColor(int i) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setStrokeColor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setStrokeWidth(float f) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setStrokeWidth(f);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null && (iMapElementOptions instanceof CircleOptions)) {
            try {
                iCircleDelegate.setOptions(iMapElementOptions);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public IMapElementOptions getOptions() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.getOptions();
    }

    public String getId() {
        try {
            if (this.f10803a == null) {
                return null;
            }
            return this.f10803a.getId();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
            return null;
        }
    }

    public void setZIndex(int i) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setZIndex(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public int getZIndex() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        return (iCircleDelegate == null ? null : Integer.valueOf(iCircleDelegate.getZIndex())).intValue();
    }

    public void setVisible(boolean z) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            try {
                iCircleDelegate.setVisible(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isVisible() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        return iCircleDelegate != null && iCircleDelegate.isVisible();
    }

    public boolean isClickable() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        return iCircleDelegate != null && iCircleDelegate.isClickable();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String id = getId();
        if (id == null) {
            return false;
        }
        return id.equals(((Circle) obj).getId());
    }

    public int hashCode() {
        String id = getId();
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    public List<LatLng> getBounderPoints() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            return iCircleDelegate.getBounderPoints();
        }
        return null;
    }

    public Object getElement() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.getElement();
    }

    public void remove() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate != null) {
            iCircleDelegate.remove();
            this.f10803a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10804b = bundle;
    }

    public Bundle getBundle() {
        return this.f10804b;
    }

    public void setData(Object obj) {
        this.f10805c = obj;
    }

    public Object getData() {
        return this.f10805c;
    }

    public boolean contains(LatLng latLng) {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return false;
        }
        return iCircleDelegate.contains(latLng);
    }

    public LatLng getBottomTangencyPoint() {
        ICircleDelegate iCircleDelegate = this.f10803a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.getBottomTangencyPoint();
    }
}
