package com.didi.soda.customer.widget.goods;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class GravityCompoundDrawable extends Drawable {

    /* renamed from: a */
    private final Drawable f41870a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public GravityCompoundDrawable(Drawable drawable) {
        this.f41870a = drawable;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-(canvas.getHeight() / 2)) + (this.f41870a.getIntrinsicHeight() / 2)));
        this.f41870a.draw(canvas);
        canvas.restore();
    }

    public int getIntrinsicHeight() {
        return this.f41870a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f41870a.getIntrinsicWidth();
    }
}
