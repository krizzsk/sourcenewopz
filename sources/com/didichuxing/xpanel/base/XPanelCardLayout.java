package com.didichuxing.xpanel.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class XPanelCardLayout extends FrameLayout {

    /* renamed from: a */
    private Drawable f49331a;

    /* renamed from: b */
    private int f49332b;

    /* renamed from: c */
    private int f49333c;

    /* renamed from: d */
    private int f49334d;

    /* renamed from: e */
    private int f49335e;

    public XPanelCardLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBgDrawable(Drawable drawable, int i, int i2, int i3, int i4) {
        this.f49331a = drawable;
        this.f49332b = i2;
        this.f49335e = i4;
        this.f49333c = i;
        this.f49334d = i3;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        if (!(this.f49331a == null || (childAt = getChildAt(0)) == null)) {
            int save = canvas.save();
            canvas.translate((float) (childAt.getLeft() - this.f49333c), (float) (childAt.getTop() - this.f49332b));
            this.f49331a.setBounds(0, 0, childAt.getWidth() + this.f49334d + this.f49333c, childAt.getHeight() + this.f49335e + this.f49332b);
            this.f49331a.draw(canvas);
            canvas.restoreToCount(save);
        }
        super.dispatchDraw(canvas);
    }
}
