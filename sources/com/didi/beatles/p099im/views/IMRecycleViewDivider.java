package com.didi.beatles.p099im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didi.beatles.im.views.IMRecycleViewDivider */
public class IMRecycleViewDivider extends RecyclerView.ItemDecoration {

    /* renamed from: e */
    private static final int[] f9934e = {16843284};

    /* renamed from: a */
    private Paint f9935a;

    /* renamed from: b */
    private Drawable f9936b;

    /* renamed from: c */
    private int f9937c;

    /* renamed from: d */
    private int f9938d;

    public IMRecycleViewDivider(Context context, int i) {
        this.f9937c = 2;
        if (i == 1 || i == 0) {
            this.f9938d = i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f9934e);
            this.f9936b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public IMRecycleViewDivider(Context context, int i, int i2) {
        this(context, i);
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        this.f9936b = drawable;
        this.f9937c = drawable.getIntrinsicHeight();
    }

    public IMRecycleViewDivider(Context context, int i, int i2, int i3) {
        this(context, i);
        this.f9937c = i2;
        Paint paint = new Paint(1);
        this.f9935a = paint;
        paint.setColor(i3);
        this.f9935a.setStyle(Paint.Style.FILL);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f9937c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f9938d == 1) {
            m6702b(canvas, recyclerView);
        } else {
            m6701a(canvas, recyclerView);
        }
    }

    /* renamed from: a */
    private void m6701a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.f9937c + bottom;
            Drawable drawable = this.f9936b;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.f9936b.draw(canvas);
            }
            Paint paint = this.f9935a;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    /* renamed from: b */
    private void m6702b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.f9937c + right;
            Drawable drawable = this.f9936b;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.f9936b.draw(canvas);
            }
            Paint paint = this.f9935a;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
