package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElement;
import java.util.List;

public final class CameraUpdate {

    /* renamed from: a */
    private CameraUpdateParams f10802a;

    private CameraUpdate() {
    }

    public CameraUpdate(CameraUpdateParams cameraUpdateParams) {
        if (cameraUpdateParams != null) {
            this.f10802a = cameraUpdateParams;
            return;
        }
        throw new NullPointerException("params is null");
    }

    public CameraUpdateParams getCameraUpdateParams() {
        return this.f10802a;
    }

    public static class CameraUpdateParams {
        public boolean alwaysAnimate = false;
        public float bearing = 0.0f;
        public List<IMapElement> elements;
        public LatLng latLng;
        public LatLngBounds latlngbounds;
        public double level = 0.0d;
        public int marginBom;
        public int marginLeft;
        public int marginRight;
        public int marginTop;
        private int padding;
        public float scrollbyX = 0.0f;
        public float scrollbyY = 0.0f;
        public float tilt = 0.0f;
        public CameraUpdateType type;

        public enum CameraUpdateType {
            ZOOM_IN,
            ZOOM_OUT,
            ZOOM_TO,
            ZOOM_BY,
            CENTER,
            CENTER_ZOOM,
            BOUNDS,
            BOUNDS_RECT,
            SCROLL_BY,
            ROTATE_TO,
            CAMERA_POSITION,
            ELEMENTS_BOUNDS_RECT
        }

        public CameraUpdateParams(CameraUpdateType cameraUpdateType) {
            this.type = cameraUpdateType;
        }

        public int getPadding() {
            return this.padding;
        }

        public void setPadding(int i) {
            if (i < 0) {
                i = 1;
            }
            this.padding = i;
        }
    }
}
