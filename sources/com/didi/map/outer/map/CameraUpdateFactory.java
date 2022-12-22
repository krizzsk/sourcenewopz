package com.didi.map.outer.map;

import android.graphics.Point;
import com.didi.map.alpha.maps.internal.CamerParameter;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import java.util.List;

public final class CameraUpdateFactory {
    private CameraUpdateFactory() {
    }

    public static CameraUpdate zoomIn() {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 0;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomOut() {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 1;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 2;
        camerParameter.scrollBy_xPixel = f;
        camerParameter.scrollBy_yPixel = f2;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomTo(float f) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 3;
        camerParameter.zoomTo_zoom = f;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomBy(float f) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 4;
        camerParameter.zoomBy_amount = f;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 5;
        camerParameter.zoomBy_Point_amount = f;
        camerParameter.zoomBy_Point_focus = point;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 6;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPositionV2(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = ApolloHawaii.useNewCameraPosition ? 17 : 6;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 7;
        camerParameter.newLatLng_latLng = latLng;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 8;
        camerParameter.newLatLngZoom_latLng = latLng;
        camerParameter.newLatLngZoom_zoom = f;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 9;
        camerParameter.newLatLngBounds_bounds = latLngBounds;
        camerParameter.newLatLngBounds_padding = i;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 11;
        camerParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        camerParameter.newLatLngBoundsRects_padLeft = i;
        camerParameter.newLatLngBoundsRects_padRight = i2;
        camerParameter.newLatLngBoundsRects_padTop = i3;
        camerParameter.newLatLngBoundsRects_padBom = i4;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newLatLngBoundsRect4MoveMapCenter(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 19;
        camerParameter.newLatLngBounds_dimension_bounds = latLngBounds;
        camerParameter.newLatLngBoundsRects_padLeft = i;
        camerParameter.newLatLngBoundsRects_padRight = i2;
        camerParameter.newLatLngBoundsRects_padTop = i3;
        camerParameter.newLatLngBoundsRects_padBom = i4;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newElementBoundsRect(List<IMapElement> list, int i, int i2, int i3, int i4) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 13;
        camerParameter.elements = list;
        camerParameter.newLatLngBoundsRects_padLeft = i;
        camerParameter.newLatLngBoundsRects_padRight = i2;
        camerParameter.newLatLngBoundsRects_padTop = i3;
        camerParameter.newLatLngBoundsRects_padBom = i4;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate rotateTo(float f, float f2) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 12;
        camerParameter.rotateto_rotate = f;
        camerParameter.rotateto_skew = f2;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPosition4NavigateMap(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 14;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPosition4Overview(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 15;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPosition4Fullview(CameraPosition cameraPosition, float f, float f2) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 16;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        camerParameter.centerOffsetX = f;
        camerParameter.centerOffsetY = f2;
        return new CameraUpdate(camerParameter);
    }

    public static CameraUpdate newCameraPosition4FullView(CameraPosition cameraPosition) {
        CamerParameter camerParameter = new CamerParameter();
        camerParameter.iCamerType = 18;
        camerParameter.newCameraPosition_cameraPosition = cameraPosition;
        return new CameraUpdate(camerParameter);
    }
}
