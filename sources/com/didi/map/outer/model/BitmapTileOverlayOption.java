package com.didi.map.outer.model;

import android.graphics.Bitmap;

public class BitmapTileOverlayOption {

    /* renamed from: a */
    private LatLngBounds f27890a;

    /* renamed from: b */
    private Bitmap f27891b;

    public LatLngBounds getBounds() {
        return this.f27890a;
    }

    public BitmapTileOverlayOption latlngBounds(LatLngBounds latLngBounds) {
        this.f27890a = latLngBounds;
        return this;
    }

    public Bitmap getBitmap() {
        return this.f27891b;
    }

    public BitmapTileOverlayOption bitmap(Bitmap bitmap) {
        this.f27891b = bitmap;
        return this;
    }
}
