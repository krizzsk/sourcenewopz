package com.didi.map.global.component.recmarker.model;

import android.graphics.Bitmap;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.recmarker.RecMarkerCallback;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;

public class RecMarkerParam {
    public Bitmap icon;
    public boolean isClickEnable;
    public boolean isShowLabel;
    public int labelDirection;
    public ILabelView labelView;
    public OnRecMarkClickListener listener;
    public RecMarkerCallback markerCallback;
    public RecPoint point;
    public Bitmap selectedIcon;
    public ICollideStrategy strategy;
}
