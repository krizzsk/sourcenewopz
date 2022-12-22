package com.didi.entrega.home.widget;

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
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C10448R;

public class CustomerShadowConstraintLayout extends ConstraintLayout {

    /* renamed from: a */
    private int f20748a;

    /* renamed from: b */
    private float f20749b;

    /* renamed from: c */
    private float f20750c;

    /* renamed from: d */
    private float f20751d;

    /* renamed from: e */
    private float f20752e;

    /* renamed from: f */
    private float f20753f;

    /* renamed from: g */
    private float f20754g;

    /* renamed from: h */
    private int f20755h;

    /* renamed from: i */
    private boolean f20756i;

    /* renamed from: j */
    private Paint f20757j;

    public boolean isOpaque() {
        return false;
    }

    public float getmInsetPaddingOffset() {
        return (float) this.f20755h;
    }

    public CustomerShadowConstraintLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20748a = Color.argb(90, 0, 0, 0);
        this.f20749b = 30.0f;
        this.f20750c = 0.0f;
        this.f20751d = 0.0f;
        this.f20752e = 1.0f;
        this.f20753f = 0.0f;
        this.f20754g = 0.0f;
        this.f20755h = 0;
        this.f20756i = true;
        this.f20757j = new Paint(1);
        m15175a(context, attributeSet);
        m15177b();
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void draw(Canvas canvas) {
        m15176a();
        canvas.drawRoundRect(getRectF(), this.f20751d, this.f20750c, this.f20757j);
        super.draw(canvas);
    }

    private void setViewFamilyClipChildren(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            for (ViewParent parent = viewGroup.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
            }
        }
    }

    /* renamed from: a */
    private boolean m15176a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, this.f20755h + getPaddingLeft(), this.f20755h + getPaddingTop(), this.f20755h + getPaddingRight(), this.f20755h + getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f20753f, ((float) getPaddingTop()) + this.f20754g, ((float) (getWidth() - getPaddingRight())) + this.f20753f, ((float) (getHeight() - getPaddingBottom())) + this.f20754g);
    }

    /* renamed from: a */
    private void m15175a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaShadowLayout);
        if (obtainStyledAttributes != null) {
            this.f20748a = obtainStyledAttributes.getColor(3, this.f20748a);
            this.f20750c = obtainStyledAttributes.getDimension(8, this.f20750c);
            this.f20751d = obtainStyledAttributes.getDimension(7, this.f20751d);
            this.f20749b = obtainStyledAttributes.getDimension(2, this.f20749b);
            this.f20753f = obtainStyledAttributes.getDimension(4, this.f20753f);
            this.f20754g = obtainStyledAttributes.getDimension(5, this.f20754g);
            this.f20756i = obtainStyledAttributes.getBoolean(0, true);
            this.f20752e = obtainStyledAttributes.getFraction(1, 1, 1, 1.0f);
            this.f20755h = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m15177b() {
        setLayerType(1, (Paint) null);
        this.f20757j.setAntiAlias(this.f20756i);
        this.f20757j.setColor(this.f20748a);
        this.f20757j.setAlpha((int) (this.f20752e * 255.0f));
        this.f20757j.setMaskFilter(new BlurMaskFilter(this.f20749b, BlurMaskFilter.Blur.NORMAL));
    }
}
