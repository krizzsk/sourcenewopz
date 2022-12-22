package com.didi.map.outer.model;

import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BitmapTileOverlayControl;

public class BitmapTileOverlay {

    /* renamed from: a */
    private String f27887a;

    /* renamed from: b */
    private final BitmapTileOverlayControl f27888b;

    /* renamed from: c */
    private BitmapTileOverlayOption f27889c;

    public BitmapTileOverlay(BitmapTileOverlayControl bitmapTileOverlayControl, String str, BitmapTileOverlayOption bitmapTileOverlayOption) {
        this.f27888b = bitmapTileOverlayControl;
        this.f27887a = str;
        this.f27889c = bitmapTileOverlayOption;
    }

    public void updateData(Bitmap bitmap, LatLngBounds latLngBounds) {
        this.f27888b.updateData(bitmap, latLngBounds);
    }

    public void remove() {
        this.f27888b.remove(this.f27887a);
    }

    public String getId() {
        return this.f27887a;
    }
}
