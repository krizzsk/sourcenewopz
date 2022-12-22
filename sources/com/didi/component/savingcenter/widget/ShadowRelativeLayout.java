package com.didi.component.savingcenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.passenger.C10448R;

public class ShadowRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private int f15487a;

    /* renamed from: b */
    private float f15488b;

    /* renamed from: c */
    private float f15489c;

    /* renamed from: d */
    private float f15490d;

    /* renamed from: e */
    private float f15491e;

    /* renamed from: f */
    private Paint f15492f;

    public boolean isOpaque() {
        return false;
    }

    public ShadowRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15487a = Color.argb(90, 0, 0, 0);
        this.f15488b = 30.0f;
        this.f15489c = 0.0f;
        this.f15490d = 0.0f;
        this.f15491e = 0.0f;
        this.f15492f = new Paint(1);
        m11152a(context, attributeSet);
        m11154b();
    }

    public void draw(Canvas canvas) {
        m11153a();
        RectF rectF = getRectF();
        float f = this.f15489c;
        canvas.drawRoundRect(rectF, f, f, this.f15492f);
        super.draw(canvas);
    }

    /* renamed from: a */
    private boolean m11153a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f15490d, ((float) getPaddingTop()) + this.f15491e, ((float) (getWidth() - getPaddingRight())) + this.f15490d, ((float) (getHeight() - getPaddingBottom())) + this.f15491e);
    }

    /* renamed from: a */
    private void m11152a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.ShadowRelativeLayout);
        if (obtainStyledAttributes != null) {
            this.f15487a = obtainStyledAttributes.getColor(1, this.f15487a);
            this.f15489c = obtainStyledAttributes.getDimension(4, this.f15489c);
            this.f15488b = obtainStyledAttributes.getDimension(0, this.f15488b);
            this.f15490d = obtainStyledAttributes.getDimension(2, this.f15490d);
            this.f15491e = obtainStyledAttributes.getDimension(3, this.f15491e);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m11154b() {
        setLayerType(1, (Paint) null);
        this.f15492f.setAntiAlias(true);
        this.f15492f.setColor(this.f15487a);
        this.f15492f.setMaskFilter(new BlurMaskFilter(this.f15488b, BlurMaskFilter.Blur.NORMAL));
    }
}
