package com.didi.map.global.flow.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.ImageUtil;

public class AddressMarkerParam {
    public float anchorU;
    public float anchorV;
    public Bitmap icon;
    public String name;
    public LatLng position;

    public AddressMarkerParam(String str, LatLng latLng, Drawable drawable, float f, float f2) {
        this.name = str;
        this.position = latLng;
        this.icon = ImageUtil.Drawable2Bitmap(drawable);
        this.anchorU = f;
        this.anchorV = f2;
    }
}
