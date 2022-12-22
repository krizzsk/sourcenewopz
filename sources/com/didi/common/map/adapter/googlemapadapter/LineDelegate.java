package com.didi.common.map.adapter.googlemapadapter;

import android.graphics.Bitmap;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.ILineDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.GeoPoint;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import java.util.List;

public class LineDelegate implements ILineDelegate {

    /* renamed from: a */
    private Polyline f10765a;

    /* renamed from: b */
    private LineOptions f10766b;

    public /* synthetic */ GeoPoint getTrueInsertPoint() {
        return ILineDelegate.CC.$default$getTrueInsertPoint(this);
    }

    public /* synthetic */ void insertPoint(int i, LatLng latLng) {
        ILineDelegate.CC.$default$insertPoint(this, i, latLng);
    }

    public /* synthetic */ void insertPoint(int i, LatLng latLng, int i2, int i3) {
        ILineDelegate.CC.$default$insertPoint(this, i, latLng, i2, i3);
    }

    public /* synthetic */ void modLineColor(int i) {
        ILineDelegate.CC.$default$modLineColor(this, i);
    }

    public /* synthetic */ void setNaviRouteLineErase(boolean z) {
        ILineDelegate.CC.$default$setNaviRouteLineErase(this, z);
    }

    public /* synthetic */ void setPulseBitmap(Bitmap bitmap) {
        ILineDelegate.CC.$default$setPulseBitmap(this, bitmap);
    }

    public /* synthetic */ void setPulsePercent(float f) {
        ILineDelegate.CC.$default$setPulsePercent(this, f);
    }

    public LineDelegate(Polyline polyline, LineOptions lineOptions) {
        this.f10765a = polyline;
        this.f10766b = lineOptions;
    }

    public void setPoints(List<LatLng> list) throws MapNotExistApiException {
        if (this.f10765a != null && list != null && !list.isEmpty()) {
            this.f10765a.setPoints(Converter.convertToGoogleLatLngs(list));
            LineOptions lineOptions = this.f10766b;
            if (lineOptions != null) {
                lineOptions.setPoints(list);
            }
        }
    }

    public List<LatLng> getPoints() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            return Converter.convertFromGoogleLatLngs(polyline.getPoints());
        }
        return null;
    }

    public void setWidth(double d) throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.setWidth((float) d);
            LineOptions lineOptions = this.f10766b;
            if (lineOptions != null) {
                lineOptions.width(d);
            }
        }
    }

    public void setColor(int i) throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.setColor(i);
            LineOptions lineOptions = this.f10766b;
            if (lineOptions != null) {
                lineOptions.color(i);
            }
        }
    }

    public void setBitmap(Bitmap bitmap) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            lineOptions.bitmap(bitmap);
        }
        throw new MapNotExistApiException("Not Support");
    }

    public void setStretchFactor(int i) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            lineOptions.stretchFactor(i);
        }
        throw new MapNotExistApiException("Not Support");
    }

    public void setLineJoinType(int i) throws MapNotExistApiException {
        if (this.f10765a != null) {
            if (i < 0 || i > 2) {
                i = 0;
            }
            LineOptions lineOptions = this.f10766b;
            if (lineOptions != null) {
                lineOptions.lineJoinType(i);
            }
            this.f10765a.setJointType(i);
        }
    }

    public void setMultiColorLineInfo(LineOptions.MultiColorLineInfo[] multiColorLineInfoArr) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            lineOptions.multiColorLineInfo(multiColorLineInfoArr);
        }
        throw new MapNotExistApiException("Not Support");
    }

    public void setLineEndType(int i) throws MapNotExistApiException {
        if (this.f10765a != null) {
            if (i < 0 || i > 2) {
                i = 0;
            }
            if (i == 0) {
                this.f10765a.setEndCap(new RoundCap());
            } else if (i == 1) {
                this.f10765a.setEndCap(new ButtCap());
            } else if (i == 2) {
                this.f10765a.setEndCap(new SquareCap());
            }
            LineOptions lineOptions = this.f10766b;
            if (lineOptions != null) {
                lineOptions.lineEndType(i);
            }
        }
    }

    public double getWidth() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            return (double) polyline.getWidth();
        }
        return 0.0d;
    }

    public int getColor() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            return polyline.getColor();
        }
        return 0;
    }

    public Bitmap getBitmap() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            return lineOptions.getBitmap();
        }
        return null;
    }

    public int getStretchFactor() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            return lineOptions.getStretchFactor();
        }
        return 0;
    }

    public int getLineJoinType() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            return lineOptions.getLineJoinType();
        }
        return 0;
    }

    public int getLineEndType() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            return lineOptions.getLineEndType();
        }
        return 0;
    }

    public LineOptions.MultiColorLineInfo[] getMultiColorLineInfo() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10766b;
        if (lineOptions != null) {
            return lineOptions.getMultiColorLineInfo();
        }
        return null;
    }

    public String getId() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline == null) {
            return null;
        }
        return polyline.getId();
    }

    public void remove() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.remove();
            this.f10765a = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.setZIndex((float) i);
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline == null) {
            return 0;
        }
        return (int) polyline.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.setVisible(z);
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline == null) {
            return false;
        }
        return polyline.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        Polyline polyline = this.f10765a;
        if (polyline == null) {
            return false;
        }
        return polyline.isClickable();
    }

    public void setClickable(boolean z) {
        Polyline polyline = this.f10765a;
        if (polyline != null) {
            polyline.setClickable(z);
        }
    }

    public Object getElement() {
        return this.f10765a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        if (iMapElementOptions != null && (iMapElementOptions instanceof LineOptions)) {
            LineOptions lineOptions = (LineOptions) iMapElementOptions;
            this.f10766b = lineOptions;
            this.f10765a.setClickable(lineOptions.isClickable());
            this.f10765a.setColor(this.f10766b.getColor());
            this.f10765a.setJointType(this.f10766b.getLineJoinType());
            this.f10765a.setPoints(Converter.convertToGoogleLatLngs(this.f10766b.getPoints()));
            this.f10765a.setVisible(this.f10766b.isVisible());
            this.f10765a.setWidth((float) this.f10766b.getWidth());
            this.f10765a.setZIndex((float) this.f10766b.getZIndex());
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10766b;
    }
}
