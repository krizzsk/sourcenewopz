package com.didi.soda.customer.widget.extra;

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
    private int f41791a;

    /* renamed from: b */
    private float f41792b;

    /* renamed from: c */
    private float f41793c;

    /* renamed from: d */
    private float f41794d;

    /* renamed from: e */
    private float f41795e;

    /* renamed from: f */
    private float f41796f;

    /* renamed from: g */
    private float f41797g;

    /* renamed from: h */
    private int f41798h;

    /* renamed from: i */
    private boolean f41799i;

    /* renamed from: j */
    private Paint f41800j;

    public boolean isOpaque() {
        return false;
    }

    public float getmInsetPaddingOffset() {
        return (float) this.f41798h;
    }

    public CustomerShadowConstraintLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerShadowConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41791a = Color.argb(90, 0, 0, 0);
        this.f41792b = 30.0f;
        this.f41793c = 0.0f;
        this.f41794d = 0.0f;
        this.f41795e = 1.0f;
        this.f41796f = 0.0f;
        this.f41797g = 0.0f;
        this.f41798h = 0;
        this.f41799i = true;
        this.f41800j = new Paint(1);
        m29497a(context, attributeSet);
        m29499b();
        setClipChildren(false);
        setClipToPadding(false);
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

    public void draw(Canvas canvas) {
        m29498a();
        canvas.drawRoundRect(getRectF(), this.f41794d, this.f41793c, this.f41800j);
        super.draw(canvas);
    }

    /* renamed from: a */
    private boolean m29498a() {
        Drawable background = getBackground();
        if (background == null || (background instanceof InsetDrawable)) {
            return false;
        }
        setBackground(new InsetDrawable(background, this.f41798h + getPaddingLeft(), this.f41798h + getPaddingTop(), this.f41798h + getPaddingRight(), this.f41798h + getPaddingBottom()));
        return true;
    }

    private RectF getRectF() {
        return new RectF(((float) getPaddingLeft()) + this.f41796f, ((float) getPaddingTop()) + this.f41797g, ((float) (getWidth() - getPaddingRight())) + this.f41796f, ((float) (getHeight() - getPaddingBottom())) + this.f41797g);
    }

    /* renamed from: a */
    private void m29497a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerShadowLayout);
        if (obtainStyledAttributes != null) {
            this.f41791a = obtainStyledAttributes.getColor(3, this.f41791a);
            this.f41793c = obtainStyledAttributes.getDimension(8, this.f41793c);
            this.f41794d = obtainStyledAttributes.getDimension(7, this.f41794d);
            this.f41792b = obtainStyledAttributes.getDimension(2, this.f41792b);
            this.f41796f = obtainStyledAttributes.getDimension(4, this.f41796f);
            this.f41797g = obtainStyledAttributes.getDimension(5, this.f41797g);
            this.f41799i = obtainStyledAttributes.getBoolean(0, true);
            this.f41795e = obtainStyledAttributes.getFraction(1, 1, 1, 1.0f);
            this.f41798h = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    private void m29499b() {
        setLayerType(1, (Paint) null);
        this.f41800j.setAntiAlias(this.f41799i);
        this.f41800j.setColor(this.f41791a);
        this.f41800j.setAlpha((int) (this.f41795e * 255.0f));
        this.f41800j.setMaskFilter(new BlurMaskFilter(this.f41792b, BlurMaskFilter.Blur.NORMAL));
    }
}
