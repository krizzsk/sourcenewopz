package com.didi.map.sdk.departure.internal.rec;

import android.graphics.Bitmap;
import com.didi.map.sdk.departure.internal.markers.RecPoint;

public class RecMarkerParam {
    public Bitmap icon;
    public boolean isClickEnable;
    public OnRecMarkClickListener listener;
    public RecPoint point;
    public Bitmap selectedIcon;
}
