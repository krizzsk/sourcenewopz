package com.didi.map.global.component.recmarker;

import android.graphics.Bitmap;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;
import java.util.List;

public class RecMarkerControllerParam {
    public Bitmap icon;
    public boolean isClickable;
    public boolean isShowLabel;
    public int labelDirection;
    public ILabelView labelView;
    public List<RecPoint> list;
    public RecMarkerCallback markerCallback;
    public OnRecMarkClickListener markerClickListener;
    public RecPoint pinedPoint;
    public Bitmap selectedIcon;
    public ICollideStrategy strategy;
}
