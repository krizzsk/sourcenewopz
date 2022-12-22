package com.didi.rfusion.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;

public class RFSuperFrameLayout extends FrameLayout {

    /* renamed from: a */
    private int f33610a;

    /* renamed from: b */
    private int f33611b;

    public RFSuperFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSuperFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSuperFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33610a = 0;
        this.f33611b = 0;
        m23681a(attributeSet);
    }

    /* renamed from: a */
    private void m23681a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFSuperFrameLayout);
        this.f33610a = (int) obtainStyledAttributes.getDimension(0, (float) this.f33610a);
        this.f33611b = (int) obtainStyledAttributes.getDimension(1, (float) this.f33611b);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f33610a > 0) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.f33610a), Integer.MIN_VALUE);
            } else if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.f33610a, Integer.MIN_VALUE);
            } else if (mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.f33610a), 1073741824);
            }
        }
        if (this.f33611b > 0) {
            int size2 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i);
            if (mode2 == Integer.MIN_VALUE) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(size2, this.f33611b), Integer.MIN_VALUE);
            } else if (mode2 == 0) {
                i = View.MeasureSpec.makeMeasureSpec(this.f33611b, Integer.MIN_VALUE);
            } else if (mode2 == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(size2, this.f33611b), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        if (this.f33610a != i) {
            this.f33610a = i;
            postInvalidate();
        }
    }

    public void setMaxWidth(int i) {
        if (this.f33611b != i) {
            this.f33611b = i;
            postInvalidate();
        }
    }
}
