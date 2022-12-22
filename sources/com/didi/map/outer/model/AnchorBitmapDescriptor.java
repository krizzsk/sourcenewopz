package com.didi.map.outer.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.AnchorBitmapFormater;

public final class AnchorBitmapDescriptor {
    private AnchorBitmapFormater bmpFormater = null;

    AnchorBitmapDescriptor(AnchorBitmapFormater anchorBitmapFormater) {
        this.bmpFormater = anchorBitmapFormater;
    }

    public AnchorBitmapFormater getFormater() {
        return this.bmpFormater;
    }

    public Bitmap getBitmap(Context context) {
        AnchorBitmapFormater anchorBitmapFormater = this.bmpFormater;
        if (anchorBitmapFormater == null) {
            return null;
        }
        return anchorBitmapFormater.getBitmap(context);
    }

    public int getWidth() {
        AnchorBitmapFormater anchorBitmapFormater = this.bmpFormater;
        if (anchorBitmapFormater == null) {
            return 0;
        }
        return anchorBitmapFormater.getWidth();
    }

    public int getHeight() {
        AnchorBitmapFormater anchorBitmapFormater = this.bmpFormater;
        if (anchorBitmapFormater == null) {
            return 0;
        }
        return anchorBitmapFormater.getHeight();
    }

    public float getAnchorX() {
        AnchorBitmapFormater anchorBitmapFormater = this.bmpFormater;
        if (anchorBitmapFormater == null) {
            return 0.0f;
        }
        return anchorBitmapFormater.getAnchorX();
    }

    public float getAnchorY() {
        AnchorBitmapFormater anchorBitmapFormater = this.bmpFormater;
        if (anchorBitmapFormater == null) {
            return 0.0f;
        }
        return anchorBitmapFormater.getAnchorY();
    }
}
