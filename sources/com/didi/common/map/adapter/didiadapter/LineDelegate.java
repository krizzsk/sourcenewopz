package com.didi.common.map.adapter.didiadapter;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.ILineDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.GeoPoint;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.SystemUtil;
import com.didi.map.outer.model.Polyline;
import java.util.ArrayList;
import java.util.List;

public class LineDelegate implements ILineDelegate {

    /* renamed from: a */
    private Polyline f10707a;

    /* renamed from: b */
    private LineOptions f10708b;

    /* renamed from: c */
    private Context f10709c;

    public void setClickable(boolean z) {
    }

    public LineDelegate(Polyline polyline, LineOptions lineOptions, Context context) {
        this.f10707a = polyline;
        this.f10709c = context;
        this.f10708b = lineOptions;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Polyline polyline = this.f10707a;
        if (polyline != null && iMapElementOptions != null && (iMapElementOptions instanceof LineOptions)) {
            LineOptions lineOptions = (LineOptions) iMapElementOptions;
            this.f10708b = lineOptions;
            polyline.setPolylineOptions(Converter.convertToDidiPolyLineOption(lineOptions, this.f10709c));
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10708b;
    }

    public void setPoints(List<LatLng> list) throws MapNotExistApiException {
        if (this.f10707a != null && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (LatLng convertToDidiLatLng : list) {
                arrayList.add(Converter.convertToDidiLatLng(convertToDidiLatLng));
            }
            this.f10707a.setPoints(arrayList);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.setPoints(list);
            }
        }
    }

    public List<LatLng> getPoints() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getPoints();
        }
        return null;
    }

    public void setWidth(double d) throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setWidth((float) SystemUtil.px2dip(this.f10709c, (float) d));
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.width(d);
            }
        }
    }

    public void setColor(int i) throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setColor(i);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.color(i);
            }
        }
    }

    public void setBitmap(Bitmap bitmap) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            lineOptions.bitmap(bitmap);
        }
    }

    public void setStretchFactor(int i) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            lineOptions.stretchFactor(i);
        }
    }

    public void setLineJoinType(int i) throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            lineOptions.lineJoinType(i);
        }
    }

    public void setMultiColorLineInfo(LineOptions.MultiColorLineInfo[] multiColorLineInfoArr) throws MapNotExistApiException {
        if (multiColorLineInfoArr != null && this.f10707a != null) {
            int[] iArr = new int[multiColorLineInfoArr.length];
            int[] iArr2 = new int[multiColorLineInfoArr.length];
            for (int i = 0; i < multiColorLineInfoArr.length; i++) {
                iArr[i] = multiColorLineInfoArr[i].colorIndex;
                iArr2[i] = multiColorLineInfoArr[i].pointIndex;
            }
            this.f10707a.setColors(iArr, iArr2);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.multiColorLineInfo(multiColorLineInfoArr);
            }
        }
    }

    public void setLineEndType(int i) throws MapNotExistApiException {
        if (this.f10707a != null) {
            boolean z = true;
            if (i == 0 || i != 1) {
                z = false;
            }
            this.f10707a.setLineCap(z);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.lineEndType(i);
            }
        }
    }

    public double getWidth() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            return (double) polyline.getWidth();
        }
        return 0.0d;
    }

    public int getColor() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            return polyline.getColor();
        }
        return 0;
    }

    public Bitmap getBitmap() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getBitmap();
        }
        return null;
    }

    public int getStretchFactor() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getStretchFactor();
        }
        return 0;
    }

    public int getLineJoinType() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getLineJoinType();
        }
        return 0;
    }

    public int getLineEndType() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getLineEndType();
        }
        return 0;
    }

    public LineOptions.MultiColorLineInfo[] getMultiColorLineInfo() throws MapNotExistApiException {
        LineOptions lineOptions = this.f10708b;
        if (lineOptions != null) {
            return lineOptions.getMultiColorLineInfo();
        }
        return null;
    }

    public String getId() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline == null) {
            return null;
        }
        return polyline.getId();
    }

    public void remove() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.remove();
            this.f10707a = null;
        }
        this.f10708b = null;
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setZIndex((float) i);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline == null) {
            return 0;
        }
        return (int) polyline.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setVisible(z);
            LineOptions lineOptions = this.f10708b;
            if (lineOptions != null) {
                lineOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Polyline polyline = this.f10707a;
        if (polyline == null) {
            return false;
        }
        return polyline.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        return this.f10707a != null;
    }

    public Object getElement() {
        return this.f10707a;
    }

    public void setPulsePercent(float f) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setPulsePercent(f);
        }
    }

    public void setPulseBitmap(Bitmap bitmap) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setPulseBitmap(bitmap);
        }
    }

    public void modLineColor(int i) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.getPolylineOptions().setLineType(5);
            this.f10707a.setColor(i);
        }
    }

    public void insertPoint(int i, LatLng latLng) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.insertPoint(i, Converter.convertToDidiLatLng(latLng));
        }
    }

    public void insertPoint(int i, LatLng latLng, int i2, int i3) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.insertPoint(i, Converter.convertToDidiLatLng(latLng), i2, i3);
        }
    }

    public GeoPoint getTrueInsertPoint() {
        com.didi.map.core.point.GeoPoint trueInsertPoint;
        Polyline polyline = this.f10707a;
        if (polyline == null || (trueInsertPoint = polyline.getTrueInsertPoint()) == null) {
            return null;
        }
        return Converter.convertToDidiGeoPoint(trueInsertPoint);
    }

    public void setNaviRouteLineErase(boolean z) {
        Polyline polyline = this.f10707a;
        if (polyline != null) {
            polyline.setNaviRouteLineErase(z);
        }
    }
}
