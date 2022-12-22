package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Drawable f31991a;

    /* renamed from: b */
    private int f31992b;

    public DividerItemDecoration(Drawable drawable) {
        this.f31991a = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.f31992b;
        if (i == 0) {
            m22646a(canvas, recyclerView);
        } else if (i == 1) {
            m22647b(canvas, recyclerView);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            int orientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            this.f31992b = orientation;
            if (orientation == 0) {
                rect.left = this.f31991a.getIntrinsicWidth();
            } else if (orientation == 1) {
                rect.top = this.f31991a.getIntrinsicHeight();
            }
        }
    }

    /* renamed from: a */
    private void m22646a(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            this.f31991a.setBounds(right, paddingTop, this.f31991a.getIntrinsicWidth() + right, height);
            this.f31991a.draw(canvas);
        }
    }

    /* renamed from: b */
    private void m22647b(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f31991a.setBounds(paddingLeft, bottom, width, this.f31991a.getIntrinsicHeight() + bottom);
            this.f31991a.draw(canvas);
        }
    }
}
