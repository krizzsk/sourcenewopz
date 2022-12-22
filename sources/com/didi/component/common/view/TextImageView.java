package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C10448R;

public class TextImageView extends AppCompatTextView {

    /* renamed from: a */
    private int f11887a;

    /* renamed from: b */
    private int f11888b;

    /* renamed from: c */
    private int f11889c;

    /* renamed from: d */
    private int f11890d;

    /* renamed from: e */
    private int f11891e;

    /* renamed from: f */
    private int f11892f;

    /* renamed from: g */
    private int f11893g;

    /* renamed from: h */
    private int f11894h;

    public TextImageView(Context context) {
        super(context);
    }

    public TextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public TextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TextImageView);
        this.f11887a = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.f11888b = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f11889c = obtainStyledAttributes.getDimensionPixelOffset(7, 0);
        this.f11890d = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
        this.f11891e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
        this.f11892f = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
        this.f11893g = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f11894h = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        obtainStyledAttributes.recycle();
        setDrawablesSize();
    }

    public void setDrawablesSize() {
        Drawable[] compoundDrawables = getCompoundDrawables();
        for (int i = 0; i < compoundDrawables.length; i++) {
            if (i == 0) {
                m8036a(compoundDrawables[0], this.f11887a, this.f11888b);
            } else if (i == 1) {
                m8036a(compoundDrawables[1], this.f11889c, this.f11890d);
            } else if (i == 2) {
                m8036a(compoundDrawables[2], this.f11891e, this.f11892f);
            } else if (i == 3) {
                m8036a(compoundDrawables[3], this.f11893g, this.f11894h);
            }
        }
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    /* renamed from: a */
    private void m8036a(Drawable drawable, int i, int i2) {
        if (drawable != null) {
            double intrinsicHeight = ((double) drawable.getIntrinsicHeight()) / ((double) drawable.getIntrinsicWidth());
            drawable.setBounds(0, 0, i, i2);
            Rect bounds = drawable.getBounds();
            if (bounds.right != 0 || bounds.bottom != 0) {
                if (bounds.right == 0) {
                    bounds.right = (int) (((double) bounds.bottom) / intrinsicHeight);
                    drawable.setBounds(bounds);
                }
                if (bounds.bottom == 0) {
                    bounds.bottom = (int) (((double) bounds.right) * intrinsicHeight);
                    drawable.setBounds(bounds);
                }
            }
        }
    }
}
