package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import com.didi.map.outer.model.BitmapTileOverlay;
import com.didi.map.outer.model.BitmapTileOverlayOption;
import com.didi.map.outer.model.LatLngBounds;

public class BitmapTileOverlayControl {

    /* renamed from: a */
    private final IBitmapTileOverlayDelegate f24467a;

    public BitmapTileOverlayControl(IBitmapTileOverlayDelegate iBitmapTileOverlayDelegate) {
        this.f24467a = iBitmapTileOverlayDelegate;
    }

    public BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption) {
        return this.f24467a.addBitmapTileOverlay(bitmapTileOverlayOption, this);
    }

    public void updateData(Bitmap bitmap, LatLngBounds latLngBounds) {
        this.f24467a.updateData(bitmap, latLngBounds);
    }

    public void remove(String str) {
        this.f24467a.remove(str);
    }
}
