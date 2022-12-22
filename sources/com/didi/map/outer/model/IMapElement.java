package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;

public interface IMapElement {
    Rect getBound();

    RectF getPixel20Bound(float f);
}
