package com.didi.map.global.component.myLocation.view;

import com.didi.common.map.Map;

public class MyLocationMarkerOptions {

    /* renamed from: a */
    private Map f26087a;

    /* renamed from: b */
    private int f26088b;

    /* renamed from: c */
    private int f26089c;

    /* renamed from: d */
    private int f26090d;

    /* renamed from: e */
    private LocationAccuracyCircleOptions f26091e;

    public Map getMap() {
        return this.f26087a;
    }

    public int getzIndex() {
        return this.f26088b;
    }

    public int getArrowIcon() {
        return this.f26089c;
    }

    public int getPositionIcon() {
        return this.f26090d;
    }

    public LocationAccuracyCircleOptions getAccuracyCircleOptions() {
        return this.f26091e;
    }

    private MyLocationMarkerOptions(Builder builder) {
        this.f26087a = builder.map;
        this.f26088b = builder.zIndex;
        this.f26091e = builder.accuracyCircleOptions;
        this.f26089c = builder.arrowIcon;
        this.f26090d = builder.positionIcon;
    }

    public static class Builder {
        LocationAccuracyCircleOptions accuracyCircleOptions;
        int arrowIcon;
        Map map;
        int positionIcon;
        int zIndex;

        public MyLocationMarkerOptions build() {
            return new MyLocationMarkerOptions(this);
        }

        public Builder map(Map map2) {
            this.map = map2;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder accuracyCircleOptions(LocationAccuracyCircleOptions locationAccuracyCircleOptions) {
            this.accuracyCircleOptions = locationAccuracyCircleOptions;
            return this;
        }

        public Builder arrowIcon(int i) {
            this.arrowIcon = i;
            return this;
        }

        public Builder positionIcon(int i) {
            this.positionIcon = i;
            return this;
        }
    }
}
