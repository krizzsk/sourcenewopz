package com.didi.map.sdk.fencecomponent;

import android.graphics.Color;
import java.util.List;

public class FenceComponentParam {
    public List<FencePolygon> fences;
    public int fillColor;
    public double limitZoom;
    public int markerZIndex;
    public OnFenceChangeListener onFenceChangeListener;
    public int polygonZIndex;
    public int strokeColor;
    public float strokeWidth;

    private FenceComponentParam(Builder builder) {
        this.limitZoom = -1.0d;
        this.polygonZIndex = 0;
        this.markerZIndex = 0;
        this.fences = builder.fences;
        this.onFenceChangeListener = builder.onFenceChangeListener;
        this.fillColor = builder.fillColor;
        this.strokeColor = builder.strokeColor;
        this.strokeWidth = builder.strokeWidth;
        this.limitZoom = builder.limitZoom;
        this.polygonZIndex = builder.polygonZIndex;
        this.markerZIndex = builder.markerZIndex;
    }

    public static class Builder {
        public List<FencePolygon> fences = null;
        public int fillColor = Color.argb(100, 0, 133, 119);
        public double limitZoom = -1.0d;
        public int markerZIndex = 0;
        public OnFenceChangeListener onFenceChangeListener = null;
        public int polygonZIndex = 0;
        public int strokeColor = Color.argb(100, 0, 133, 119);
        public float strokeWidth = 0.0f;

        public Builder onFenceChangeListener(OnFenceChangeListener onFenceChangeListener2) {
            this.onFenceChangeListener = onFenceChangeListener2;
            return this;
        }

        public Builder fences(List<FencePolygon> list) {
            this.fences = list;
            return this;
        }

        public Builder fillColor(int i) {
            this.fillColor = i;
            return this;
        }

        public Builder strokeColor(int i) {
            this.strokeColor = i;
            return this;
        }

        public Builder strokeWidth(float f) {
            this.strokeWidth = f;
            return this;
        }

        public Builder limitZoom(double d) {
            this.limitZoom = d;
            return this;
        }

        public Builder polygonZIndex(int i) {
            this.polygonZIndex = i;
            return this;
        }

        public Builder markerZIndex(int i) {
            this.markerZIndex = i;
            return this;
        }

        public FenceComponentParam build() {
            return new FenceComponentParam(this);
        }
    }
}
