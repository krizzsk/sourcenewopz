package com.didi.beatles.p099im.views.widget.longimage;

import android.graphics.PointF;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.views.widget.longimage.IMImageViewState */
public class IMImageViewState implements Serializable {
    private float centerX;
    private float centerY;
    private int orientation;
    private float scale;

    public IMImageViewState(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public float getScale() {
        return this.scale;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }
}
