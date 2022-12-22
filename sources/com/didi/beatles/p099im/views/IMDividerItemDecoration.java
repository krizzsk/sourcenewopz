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

/* renamed from: com.didi.beatles.im.views.IMDividerItemDecoration */
public class IMDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: e */
    private static final int[] f9867e = {16843284};

    /* renamed from: a */
    private Paint f9868a;

    /* renamed from: b */
    private Drawable f9869b;

    /* renamed from: c */
    private int f9870c;

    /* renamed from: d */
    private int f9871d;

    public IMDividerItemDecoration(Context context, int i) {
        this.f9870c = 2;
        if (i == 1 || i == 0) {
            this.f9871d = i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f9867e);
            this.f9869b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public IMDividerItemDecoration(Context context, int i, int i2) {
        this(context, i);
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        this.f9869b = drawable;
        this.f9870c = drawable.getIntrinsicHeight();
    }

    public IMDividerItemDecoration(Context context, int i, int i2, int i3) {
        this(context, i);
        this.f9870c = i2;
        Paint paint = new Paint(1);
        this.f9868a = paint;
        paint.setColor(i3);
        this.f9868a.setStyle(Paint.Style.FILL);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f9870c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f9871d == 1) {
            m6674b(canvas, recyclerView);
        } else {
            m6673a(canvas, recyclerView);
        }
    }

    /* renamed from: a */
    private void m6673a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.f9870c + bottom;
            Drawable drawable = this.f9869b;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.f9869b.draw(canvas);
            }
            Paint paint = this.f9868a;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    /* renamed from: b */
    private void m6674b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.f9870c + right;
            Drawable drawable = this.f9869b;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.f9869b.draw(canvas);
            }
            Paint paint = this.f9868a;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
