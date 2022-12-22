package com.didi.dcrypto.multicoin.recyclerview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DcryptoDividerItemDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Drawable f16488a;

    public DcryptoDividerItemDecorator(Drawable drawable) {
        this.f16488a = drawable;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i <= childCount - 2; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f16488a.setBounds(paddingLeft, bottom, width, this.f16488a.getIntrinsicHeight() + bottom);
            this.f16488a.draw(canvas);
        }
    }
}
