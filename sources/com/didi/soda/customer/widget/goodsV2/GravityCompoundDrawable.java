package com.didi.soda.customer.widget.goodsV2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class GravityCompoundDrawable extends Drawable {

    /* renamed from: a */
    private final Drawable f41947a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public GravityCompoundDrawable(Drawable drawable) {
        this.f41947a = drawable;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-(canvas.getHeight() / 2)) + (this.f41947a.getIntrinsicHeight() / 2)));
        this.f41947a.draw(canvas);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f41947a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f41947a.getIntrinsicWidth();
    }
}
