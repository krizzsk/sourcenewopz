package com.didi.map.outer.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BitmapFormater;

public final class BitmapDescriptor {

    /* renamed from: a */
    private BitmapFormater f27886a = null;

    BitmapDescriptor(BitmapFormater bitmapFormater) {
        this.f27886a = bitmapFormater;
    }

    public BitmapFormater getFormater() {
        return this.f27886a;
    }

    public Bitmap getBitmap(Context context) {
        BitmapFormater bitmapFormater = this.f27886a;
        if (bitmapFormater == null) {
            return null;
        }
        return bitmapFormater.getBitmap(context);
    }
}
