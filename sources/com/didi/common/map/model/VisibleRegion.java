package com.didi.common.map.model;

import com.didi.common.map.model.LatLngBounds;

public final class VisibleRegion {

    /* renamed from: a */
    private LatLngBounds f10904a;
    public LatLng bomLeft;
    public LatLng bomRight;
    public LatLng topLeft;
    public LatLng topRight;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        this.topLeft = latLng3;
        this.topRight = latLng;
        this.bomLeft = latLng4;
        this.bomRight = latLng2;
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng3);
        builder.include(latLng);
        builder.include(latLng4);
        builder.include(latLng2);
        this.f10904a = builder.build();
    }

    public LatLngBounds getLatLngBounds() {
        if (this.f10904a == null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(this.topLeft);
            builder.include(this.topRight);
            builder.include(this.bomLeft);
            builder.include(this.bomRight);
            this.f10904a = builder.build();
        }
        return this.f10904a;
    }
}
