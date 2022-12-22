package com.didi.common.map.model;

import android.os.Bundle;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IPolygonDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.model.throwable.MapRuntimeException;
import java.util.List;

public final class Polygon implements IMapElement {

    /* renamed from: a */
    private IPolygonDelegate f10887a;

    /* renamed from: b */
    private Bundle f10888b;

    /* renamed from: c */
    private Object f10889c;

    public Polygon(IPolygonDelegate iPolygonDelegate) {
        this.f10887a = iPolygonDelegate;
    }

    public void setFillColor(int i) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setFillColor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public int getFillColor() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return 0;
        }
        return iPolygonDelegate.getFillColor();
    }

    public void setStrokeColor(int i) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setStrokeColor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public int getStrokeColor() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return 0;
        }
        return iPolygonDelegate.getStrokeColor();
    }

    public void setStrokeWidth(int i) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setStrokeWidth(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public int getStrokeWidth() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return 0;
        }
        return iPolygonDelegate.getStrokeWidth();
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setOptions(iMapElementOptions);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public PolygonOptions getOptions() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return null;
        }
        return (PolygonOptions) iPolygonDelegate.getOptions();
    }

    public String getId() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return "";
        }
        try {
            return iPolygonDelegate.getId();
        } catch (MapNotExistApiException e) {
            throw new MapRuntimeException((Exception) e);
        }
    }

    public void setZIndex(int i) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setZIndex(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public int getZIndex() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return 0;
        }
        return iPolygonDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            try {
                iPolygonDelegate.setVisible(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public boolean isVisible() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        return iPolygonDelegate != null && iPolygonDelegate.isVisible();
    }

    public boolean isClickable() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        return iPolygonDelegate != null && iPolygonDelegate.isClickable();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String id = getId();
        if (id == null) {
            return false;
        }
        return id.equals(((Polygon) obj).getId());
    }

    public int hashCode() {
        String id = getId();
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    public List<LatLng> getBounderPoints() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            return iPolygonDelegate.getBounderPoints();
        }
        return null;
    }

    public Object getElement() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate == null) {
            return null;
        }
        return iPolygonDelegate.getElement();
    }

    public void remove() {
        IPolygonDelegate iPolygonDelegate = this.f10887a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.remove();
            this.f10887a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10888b = bundle;
    }

    public Bundle getBundle() {
        return this.f10888b;
    }

    public void setData(Object obj) {
        this.f10889c = obj;
    }

    public Object getData() {
        return this.f10889c;
    }
}
