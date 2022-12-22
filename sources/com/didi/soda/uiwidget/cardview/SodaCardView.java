package com.didi.soda.uiwidget.cardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public class SodaCardView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f43817a = {16842801};

    /* renamed from: b */
    private static final C14228e f43818b;

    /* renamed from: c */
    private final C14227d f43819c = new C14227d() {
        private Drawable mCardBackground;

        public void setCardBackground(Drawable drawable) {
            this.mCardBackground = drawable;
            SodaCardView.this.setBackgroundDrawable(drawable);
        }

        public boolean getUseCompatPadding() {
            return SodaCardView.this.getUseCompatPadding();
        }

        public boolean getPreventCornerOverlap() {
            return SodaCardView.this.getPreventCornerOverlap();
        }

        public void setShadowPadding(int i, int i2, int i3, int i4) {
            SodaCardView.this.f43821e.set(i, i2, i3, i4);
            SodaCardView sodaCardView = SodaCardView.this;
            SodaCardView.super.setPadding(i + sodaCardView.f43820d.left, i2 + SodaCardView.this.f43820d.top, i3 + SodaCardView.this.f43820d.right, i4 + SodaCardView.this.f43820d.bottom);
        }

        public void setMinWidthHeightInternal(int i, int i2) {
            if (i > SodaCardView.this.f43824h) {
                SodaCardView.super.setMinimumWidth(i);
            }
            if (i2 > SodaCardView.this.f43825i) {
                SodaCardView.super.setMinimumHeight(i2);
            }
        }

        public Drawable getCardBackground() {
            return this.mCardBackground;
        }

        public View getCardView() {
            return SodaCardView.this;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Rect f43820d = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Rect f43821e = new Rect();

    /* renamed from: f */
    private boolean f43822f;

    /* renamed from: g */
    private boolean f43823g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f43824h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f43825i;

    /* renamed from: j */
    private int f43826j;

    /* renamed from: k */
    private int f43827k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Rect f43828l;

    /* renamed from: m */
    private int f43829m;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f43818b = new C14224a();
        } else {
            f43818b = new C14226c();
        }
        f43818b.mo109150a();
    }

    public SodaCardView(Context context) {
        super(context);
        m31122a(context, (AttributeSet) null, 0);
    }

    public SodaCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31122a(context, attributeSet, 0);
    }

    public SodaCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31122a(context, attributeSet, i);
    }

    public boolean getUseCompatPadding() {
        return this.f43822f;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f43822f != z) {
            this.f43822f = z;
            f43818b.mo109164f(this.f43819c);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f43820d.set(i, i2, i3, i4);
        f43818b.mo109170l(this.f43819c);
    }

    public void setMinimumWidth(int i) {
        this.f43824h = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f43825i = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f43818b.mo109153a(this.f43819c, i);
    }

    public int getCardBackgroundColor() {
        return f43818b.mo109166h(this.f43819c);
    }

    public void setShadowStartColor(int i) {
        f43818b.mo109157b(this.f43819c, i);
    }

    public int getShadowStartColor() {
        return f43818b.mo109168j(this.f43819c);
    }

    public void setShadowEndColor(int i) {
        f43818b.mo109160c(this.f43819c, i);
    }

    public int getShadowEndColor() {
        return f43818b.mo109169k(this.f43819c);
    }

    public void setYShadowOffset(float f) {
        f43818b.mo109152a(this.f43819c, f);
    }

    public float getYShadowOffset() {
        return f43818b.mo109167i(this.f43819c);
    }

    public int getContentPaddingLeft() {
        return this.f43820d.left;
    }

    public int getContentPaddingRight() {
        return this.f43820d.right;
    }

    public int getContentPaddingTop() {
        return this.f43820d.top;
    }

    public int getContentPaddingBottom() {
        return this.f43820d.bottom;
    }

    public void setRadius(float f) {
        f43818b.mo109162d(this.f43819c, f);
    }

    public float getRadius() {
        return f43818b.mo109163e(this.f43819c);
    }

    public void setCardElevation(float f) {
        f43818b.mo109156b(this.f43819c, f);
    }

    public float getCardElevation() {
        return f43818b.mo109151a(this.f43819c);
    }

    public void setMaxCardElevation(float f) {
        f43818b.mo109159c(this.f43819c, f);
    }

    public float getMaxCardElevation() {
        return f43818b.mo109155b(this.f43819c);
    }

    public boolean getPreventCornerOverlap() {
        return this.f43823g;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f43823g) {
            this.f43823g = z;
            f43818b.mo109165g(this.f43819c);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(f43818b instanceof C14225b)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f43818b.mo109161d(this.f43819c)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f43818b.mo109158c(this.f43819c)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m31125a(z);
    }

    /* renamed from: a */
    private void m31125a(boolean z) {
        View childAt;
        if (z && (childAt = getChildAt(0)) != null && (childAt instanceof ImageView) && Build.VERSION.SDK_INT >= 21) {
            childAt.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (SodaCardView.this.f43828l == null || Build.VERSION.SDK_INT < 21) {
                        Rect bounds = SodaCardView.this.getBackground().getBounds();
                        if (!(bounds.right == 0 && bounds.left == 0 && bounds.top == 0 && bounds.bottom == 0) && Build.VERSION.SDK_INT >= 21) {
                            Rect unused = SodaCardView.this.f43828l = bounds;
                            SodaCardView.this.f43828l.inset(SodaCardView.this.f43821e.left, SodaCardView.this.f43821e.top);
                            SodaCardView.this.f43828l.left += SodaCardView.this.f43820d.left;
                            SodaCardView.this.f43828l.right -= SodaCardView.this.f43820d.right;
                            SodaCardView.this.f43828l.top += SodaCardView.this.f43820d.top;
                            SodaCardView.this.f43828l.bottom -= SodaCardView.this.f43820d.bottom;
                            SodaCardView.this.f43828l.offsetTo(0, 0);
                            outline.setRoundRect(SodaCardView.this.f43828l, SodaCardView.this.getRadius());
                            return;
                        }
                        return;
                    }
                    outline.setRoundRect(SodaCardView.this.f43828l, SodaCardView.this.getRadius());
                }
            });
            childAt.setClipToOutline(true);
        }
    }

    /* renamed from: a */
    private void m31122a(Context context, AttributeSet attributeSet, int i) {
        int i2;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SodaCardView, i, R.style.SodaCardView);
        if (obtainStyledAttributes.hasValue(2)) {
            i2 = obtainStyledAttributes.getColor(2, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f43817a);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i2 = getResources().getColor(R.color.soda_cardview_light_background);
            } else {
                i2 = getResources().getColor(R.color.soda_cardview_dark_background);
            }
        }
        this.f43826j = obtainStyledAttributes.getColor(14, 0);
        this.f43827k = obtainStyledAttributes.getColor(13, 0);
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f43829m = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.f43822f = obtainStyledAttributes.getBoolean(7, false);
        this.f43823g = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f43820d.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.f43820d.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.f43820d.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.f43820d.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f43824h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f43825i = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        f43818b.mo109154a(this.f43819c, context, i2, dimension, dimension2, f, (float) this.f43829m, this.f43826j, this.f43827k);
    }
}
