package com.didi.common.map.adapter.googlemapadapter;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IPolygonDelegate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;

public class PolygonDelegate implements IPolygonDelegate {

    /* renamed from: a */
    private Polygon f10772a;

    /* renamed from: b */
    private PolygonOptions f10773b;

    public PolygonDelegate(Polygon polygon, PolygonOptions polygonOptions) {
        if (polygon != null) {
            this.f10772a = polygon;
            this.f10773b = polygonOptions;
        }
    }

    public void setFillColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.setFillColor(i);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i);
            }
        }
    }

    public void setStrokeColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.setStrokeColor(i);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i);
            }
        }
    }

    public void setStrokeWidth(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            float f = (float) i;
            polygon.setStrokeWidth(f);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.strokeWidth(f);
            }
        }
    }

    public List<LatLng> getBounderPoints() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            return Converter.convertFromGoogleLatLngs(polygon.getPoints());
        }
        return null;
    }

    public String getId() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon == null) {
            return null;
        }
        return polygon.getId();
    }

    public void remove() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.remove();
            this.f10772a = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.setZIndex((float) i);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon == null) {
            return 0;
        }
        return (int) polygon.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.setVisible(z);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon == null) {
            return false;
        }
        return polygon.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        Polygon polygon = this.f10772a;
        if (polygon == null) {
            return false;
        }
        return polygon.isClickable();
    }

    public void setClickable(boolean z) {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            polygon.setClickable(z);
            PolygonOptions polygonOptions = this.f10773b;
            if (polygonOptions != null) {
                polygonOptions.clickable(z);
            }
        }
    }

    public Object getElement() {
        return this.f10772a;
    }

    public int getFillColor() {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            return polygon.getFillColor();
        }
        return 0;
    }

    public int getStrokeColor() {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            return polygon.getStrokeColor();
        }
        return 0;
    }

    public int getStrokeWidth() {
        Polygon polygon = this.f10772a;
        if (polygon != null) {
            return (int) polygon.getStrokeWidth();
        }
        return 0;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        if (iMapElementOptions != null && (iMapElementOptions instanceof PolygonOptions)) {
            PolygonOptions polygonOptions = (PolygonOptions) iMapElementOptions;
            this.f10773b = polygonOptions;
            com.google.android.gms.maps.model.PolygonOptions convertToGooglePolygonOptions = Converter.convertToGooglePolygonOptions(polygonOptions);
            this.f10772a.setFillColor(convertToGooglePolygonOptions.getFillColor());
            this.f10772a.setClickable(convertToGooglePolygonOptions.isClickable());
            this.f10772a.setHoles(convertToGooglePolygonOptions.getHoles());
            this.f10772a.setGeodesic(convertToGooglePolygonOptions.isGeodesic());
            this.f10772a.setStrokeWidth(convertToGooglePolygonOptions.getStrokeWidth());
            this.f10772a.setStrokeColor(convertToGooglePolygonOptions.getStrokeColor());
            this.f10772a.setPoints(convertToGooglePolygonOptions.getPoints());
            this.f10772a.setStrokeJointType(convertToGooglePolygonOptions.getStrokeJointType());
            this.f10772a.setStrokePattern(convertToGooglePolygonOptions.getStrokePattern());
            this.f10772a.setVisible(convertToGooglePolygonOptions.isVisible());
            this.f10772a.setZIndex(convertToGooglePolygonOptions.getZIndex());
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10773b;
    }
}
