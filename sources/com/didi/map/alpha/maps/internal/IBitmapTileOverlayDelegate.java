package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import com.didi.map.outer.model.BitmapTileOverlay;
import com.didi.map.outer.model.BitmapTileOverlayOption;
import com.didi.map.outer.model.LatLngBounds;

public interface IBitmapTileOverlayDelegate {
    BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption, BitmapTileOverlayControl bitmapTileOverlayControl);

    void remove(String str);

    void updateData(Bitmap bitmap, LatLngBounds latLngBounds);
}
