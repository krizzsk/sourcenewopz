package com.didi.payment.wallet.global.useraccount.balance.view.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Drawable f31838a;

    /* renamed from: b */
    private int f31839b;

    public DividerItemDecoration(Drawable drawable) {
        this.f31838a = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.f31839b;
        if (i == 0) {
            m22562a(canvas, recyclerView);
        } else if (i == 1) {
            m22563b(canvas, recyclerView);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            int orientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            this.f31839b = orientation;
            if (orientation == 0) {
                rect.left = this.f31838a.getIntrinsicWidth();
            } else if (orientation == 1) {
                rect.top = this.f31838a.getIntrinsicHeight();
            }
        }
    }

    /* renamed from: a */
    private void m22562a(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            this.f31838a.setBounds(right, paddingTop, this.f31838a.getIntrinsicWidth() + right, height);
            this.f31838a.draw(canvas);
        }
    }

    /* renamed from: b */
    private void m22563b(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f31838a.setBounds(paddingLeft, bottom, width, this.f31838a.getIntrinsicHeight() + bottom);
            this.f31838a.draw(canvas);
        }
    }
}
