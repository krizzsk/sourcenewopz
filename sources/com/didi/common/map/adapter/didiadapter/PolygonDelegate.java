package com.didi.common.map.adapter.didiadapter;

import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IPolygonDelegate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.model.Polygon;
import java.util.List;

public class PolygonDelegate implements IPolygonDelegate {

    /* renamed from: a */
    private Polygon f10724a;

    /* renamed from: b */
    private PolygonOptions f10725b;

    public boolean isClickable() throws MapNotExistApiException {
        return true;
    }

    public void setClickable(boolean z) {
    }

    public PolygonDelegate(Polygon polygon, PolygonOptions polygonOptions) {
        if (polygon != null) {
            this.f10725b = polygonOptions;
            this.f10724a = polygon;
        }
    }

    public void setFillColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            polygon.setFillColor(i);
            PolygonOptions polygonOptions = this.f10725b;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i);
            }
        }
    }

    public void setStrokeColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            polygon.setStrokeColor(i);
            PolygonOptions polygonOptions = this.f10725b;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i);
            }
        }
    }

    public void setStrokeWidth(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            float f = (float) i;
            polygon.setStrokeWidth(f);
            PolygonOptions polygonOptions = this.f10725b;
            if (polygonOptions != null) {
                polygonOptions.strokeWidth(f);
            }
        }
    }

    public List<LatLng> getBounderPoints() throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            return Converter.convertFromDidiLatLngs(polygon.getPoints());
        }
        return null;
    }

    public int getFillColor() {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            return polygon.getFillColor();
        }
        return 0;
    }

    public int getStrokeColor() {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            return polygon.getStrokeColor();
        }
        return 0;
    }

    public int getStrokeWidth() {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            return (int) polygon.getStrokeWidth();
        }
        return 0;
    }

    public String getId() throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon == null) {
            return null;
        }
        return polygon.getId();
    }

    public void remove() throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            polygon.remove();
            this.f10724a = null;
            this.f10725b = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            polygon.setZIndex((float) i);
            PolygonOptions polygonOptions = this.f10725b;
            if (polygonOptions != null) {
                polygonOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon == null) {
            return 0;
        }
        return (int) polygon.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon != null) {
            polygon.setVisible(z);
            PolygonOptions polygonOptions = this.f10725b;
            if (polygonOptions != null) {
                polygonOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Polygon polygon = this.f10724a;
        if (polygon == null) {
            return false;
        }
        return polygon.isVisible();
    }

    public Object getElement() {
        return this.f10724a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Polygon polygon = this.f10724a;
        if (polygon != null && iMapElementOptions != null && (iMapElementOptions instanceof PolygonOptions)) {
            PolygonOptions polygonOptions = (PolygonOptions) iMapElementOptions;
            this.f10725b = polygonOptions;
            polygon.setOptions(Converter.convertToDidiPolygonOptions(polygonOptions));
        }
    }

    public IMapElementOptions getOptions() {
        return this.f10725b;
    }
}
