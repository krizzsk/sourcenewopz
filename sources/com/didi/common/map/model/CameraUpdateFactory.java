package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.LatLngBounds;
import java.util.List;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomTo(float f) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_TO);
        cameraUpdateParams.level = (double) f;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_IN));
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_OUT));
    }

    public static CameraUpdate zoomBy(float f) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.ZOOM_BY);
        cameraUpdateParams.level = (double) f;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
        cameraUpdateParams.latLng = cameraPosition.target;
        cameraUpdateParams.level = cameraPosition.zoom;
        cameraUpdateParams.bearing = cameraPosition.bearing;
        cameraUpdateParams.tilt = cameraPosition.tilt;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CENTER);
        cameraUpdateParams.latLng = latLng;
        cameraUpdateParams.level = -1.0d;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CENTER_ZOOM);
        cameraUpdateParams.latLng = latLng;
        cameraUpdateParams.level = (double) f;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLngBoundsRect(List<LatLng> list, int i, int i2, int i3, int i4) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (LatLng next : list) {
            if (next != null) {
                builder.include(next);
            }
        }
        return newLatLngBoundsRect(builder.build(), i, i2, i3, i4);
    }

    public static CameraUpdate newLatLngBoundRect(List<IMapElement> list, int i, int i2, int i3, int i4) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.ELEMENTS_BOUNDS_RECT);
        cameraUpdateParams.elements = list;
        cameraUpdateParams.marginLeft = i;
        cameraUpdateParams.marginRight = i2;
        cameraUpdateParams.marginTop = i3;
        cameraUpdateParams.marginBom = i4;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLngBoundsRect(List<LatLng> list, LatLng latLng, int i, int i2, int i3, int i4) {
        if (list == null || list.isEmpty()) {
            return newLatLng(latLng);
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (LatLng next : list) {
            if (next != null) {
                builder.include(next);
            }
        }
        LatLngBounds build = builder.build();
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS_RECT);
        cameraUpdateParams.latlngbounds = build;
        cameraUpdateParams.marginLeft = i;
        cameraUpdateParams.marginRight = i2;
        cameraUpdateParams.marginTop = i3;
        cameraUpdateParams.marginBom = i4;
        cameraUpdateParams.latLng = latLng;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLngBoundsRect(List<LatLng> list, LatLng latLng, int i, int i2, int i3, int i4, float f) {
        if (list != null && !list.isEmpty()) {
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (LatLng next : list) {
                if (next != null) {
                    builder.include(next);
                }
            }
            LatLngBounds build = builder.build();
            CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS_RECT);
            cameraUpdateParams.latlngbounds = build;
            cameraUpdateParams.marginLeft = i;
            cameraUpdateParams.marginRight = i2;
            cameraUpdateParams.marginTop = i3;
            cameraUpdateParams.marginBom = i4;
            cameraUpdateParams.latLng = latLng;
            cameraUpdateParams.level = (double) f;
            return new CameraUpdate(cameraUpdateParams);
        } else if (f > 0.0f) {
            return newLatLngZoom(latLng, f);
        } else {
            return newLatLng(latLng);
        }
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS_RECT);
        cameraUpdateParams.latlngbounds = latLngBounds;
        cameraUpdateParams.marginLeft = i;
        cameraUpdateParams.marginRight = i2;
        cameraUpdateParams.marginTop = i3;
        cameraUpdateParams.marginBom = i4;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.SCROLL_BY);
        cameraUpdateParams.type = CameraUpdate.CameraUpdateParams.CameraUpdateType.SCROLL_BY;
        cameraUpdateParams.scrollbyX = f;
        cameraUpdateParams.scrollbyY = f2;
        return new CameraUpdate(cameraUpdateParams);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.BOUNDS);
        cameraUpdateParams.latlngbounds = latLngBounds;
        cameraUpdateParams.setPadding(i);
        return new CameraUpdate(cameraUpdateParams);
    }
}
