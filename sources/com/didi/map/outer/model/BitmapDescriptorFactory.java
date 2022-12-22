package com.didi.map.outer.model;

import android.graphics.Bitmap;
import android.view.View;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.alpha.maps.internal.AnchorBitmapFormater;
import com.didi.map.alpha.maps.internal.BitmapFormater;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor fromResource(int i) {
        BitmapFormater bitmapFormater = new BitmapFormater(1);
        bitmapFormater.setResourceId(i);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static BitmapDescriptor fromAsset(String str) {
        BitmapFormater bitmapFormater = new BitmapFormater(2);
        bitmapFormater.setAssetsName(str);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static BitmapDescriptor fromFile(String str) {
        BitmapFormater bitmapFormater = new BitmapFormater(3);
        bitmapFormater.setFileName(str);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static BitmapDescriptor fromPath(String str) {
        BitmapFormater bitmapFormater = new BitmapFormater(4);
        bitmapFormater.setPathName(str);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static BitmapDescriptor defaultMarker() {
        return new BitmapDescriptor(new BitmapFormater(5));
    }

    public static BitmapDescriptor defaultMarker(float f) {
        BitmapFormater bitmapFormater = new BitmapFormater(6);
        bitmapFormater.setDefuatlColor(f);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static AnchorBitmapDescriptor fromResourceWithAnchor(int i, float f, float f2) {
        AnchorBitmapFormater anchorBitmapFormater = new AnchorBitmapFormater(1);
        anchorBitmapFormater.setResourceId(i);
        anchorBitmapFormater.setWidth(-1);
        anchorBitmapFormater.setHeight(-1);
        anchorBitmapFormater.setAnchorX(f);
        anchorBitmapFormater.setAnchorY(f2);
        return new AnchorBitmapDescriptor(anchorBitmapFormater);
    }

    public static AnchorBitmapDescriptor fromBitmapWithAnchor(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        return fromBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), f, f2, true);
    }

    public static AnchorBitmapDescriptor fromBitmapWithAnchor(Bitmap bitmap, int i, int i2, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        return fromBitmap(bitmap, i, i2, f, f2, true);
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return fromBitmap(bitmap, true);
    }

    public static AnchorBitmapDescriptor fromBitmap(Bitmap bitmap, int i, int i2, float f, float f2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (z) {
            bitmap = MapUtil.createBitmapFromBitmap(bitmap);
        }
        AnchorBitmapFormater anchorBitmapFormater = new AnchorBitmapFormater(7);
        anchorBitmapFormater.setBitmap(bitmap);
        anchorBitmapFormater.setWidth(i);
        anchorBitmapFormater.setHeight(i2);
        anchorBitmapFormater.setAnchorX(f);
        anchorBitmapFormater.setAnchorY(f2);
        return new AnchorBitmapDescriptor(anchorBitmapFormater);
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (z) {
            bitmap = MapUtil.createBitmapFromBitmap(bitmap);
        }
        BitmapFormater bitmapFormater = new BitmapFormater(7);
        bitmapFormater.setBitmap(bitmap);
        return new BitmapDescriptor(bitmapFormater);
    }

    public static BitmapDescriptor fromView(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmapFromView = MapUtil.createBitmapFromView(view);
        BitmapFormater bitmapFormater = new BitmapFormater(7);
        bitmapFormater.setBitmap(createBitmapFromView);
        return new BitmapDescriptor(bitmapFormater);
    }
}
