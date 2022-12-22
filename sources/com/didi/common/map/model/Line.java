package com.didi.common.map.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.didi.common.map.internal.ILineDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public final class Line implements IMapElement {

    /* renamed from: a */
    private ILineDelegate f10830a;

    /* renamed from: b */
    private Bundle f10831b;

    /* renamed from: c */
    private Object f10832c;

    public Line(ILineDelegate iLineDelegate) {
        this.f10830a = iLineDelegate;
    }

    public void setPoints(List<LatLng> list) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setPoints(list);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public double getWidth() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return 0.0d;
        }
        return iLineDelegate.getWidth();
    }

    public void setWidth(double d) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setWidth(d);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public int getColor() {
        ILineDelegate iLineDelegate = this.f10830a;
        return (iLineDelegate == null ? null : Integer.valueOf(iLineDelegate.getColor())).intValue();
    }

    public void setColor(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setColor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public Bitmap getBitmap() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getBitmap();
    }

    public void setBitmap(Bitmap bitmap) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setBitmap(bitmap);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public int getStretchFactor() {
        ILineDelegate iLineDelegate = this.f10830a;
        return (iLineDelegate == null ? null : Integer.valueOf(iLineDelegate.getStretchFactor())).intValue();
    }

    public void setStretchFactor(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setStretchFactor(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public int getLineJoinType() throws MapNotExistApiException {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return 0;
        }
        return iLineDelegate.getLineJoinType();
    }

    public void setLineJoinType(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setLineJoinType(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public int getLineEndType() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return 0;
        }
        return iLineDelegate.getLineEndType();
    }

    public void setLineEndType(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setLineEndType(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void setMultiColorLineInfo(LineOptions.MultiColorLineInfo[] multiColorLineInfoArr) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setMultiColorLineInfo(multiColorLineInfoArr);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void insertPoint(int i, LatLng latLng) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.insertPoint(i, latLng);
        }
    }

    public void insertPoint(int i, LatLng latLng, int i2, int i3) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.insertPoint(i, latLng, i2, i3);
        }
    }

    public GeoPoint getTrueInsertPoint() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getTrueInsertPoint();
    }

    public void setNaviRouteLineErase(boolean z) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.setNaviRouteLineErase(z);
        }
    }

    public void setPulsePercent(float f) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.setPulsePercent(f);
        }
    }

    public void setPulseBitmap(Bitmap bitmap) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.setPulseBitmap(bitmap);
        }
    }

    public void modLineColor(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.modLineColor(i);
        }
    }

    public LineOptions.MultiColorLineInfo[] getMultiColorLineInfo() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getMultiColorLineInfo();
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null && (iMapElementOptions instanceof LineOptions)) {
            try {
                iLineDelegate.setOptions(iMapElementOptions);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public IMapElementOptions getOptions() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getOptions();
    }

    public String getId() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        try {
            return iLineDelegate.getId();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public void setZIndex(int i) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setZIndex(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public int getZIndex() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return 0;
        }
        return iLineDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            try {
                iLineDelegate.setVisible(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public boolean isVisible() {
        ILineDelegate iLineDelegate = this.f10830a;
        return iLineDelegate != null && iLineDelegate.isVisible();
    }

    public boolean isClickable() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return false;
        }
        return iLineDelegate.isClickable();
    }

    public List<LatLng> getBounderPoints() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getPoints();
    }

    public Object getElement() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate == null) {
            return null;
        }
        return iLineDelegate.getElement();
    }

    public void remove() {
        ILineDelegate iLineDelegate = this.f10830a;
        if (iLineDelegate != null) {
            iLineDelegate.remove();
            this.f10830a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f10831b = bundle;
    }

    public Bundle getBundle() {
        return this.f10831b;
    }

    public void setData(Object obj) {
        this.f10832c = obj;
    }

    public Object getData() {
        return this.f10832c;
    }
}
