package com.didi.map.sdk.departure.internal.markers;

import android.graphics.Bitmap;
import com.didi.map.sdk.departure.internal.rec.OnRecMarkClickListener;
import java.util.List;

public class RecMarkerControllerParam {
    public Bitmap icon;
    public boolean isClickable;
    public List<RecPoint> list;
    public OnRecMarkClickListener markerClickListener;
    public Bitmap selectedIcon;
}
