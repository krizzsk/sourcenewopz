package com.didi.safetoolkit.business.areaCode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AreaCodeDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f34221a;

    /* renamed from: b */
    private Paint f34222b;

    public AreaCodeDividerDecoration(Context context) {
        Paint paint = new Paint();
        this.f34222b = paint;
        paint.setColor(Color.parseColor("#0B000000"));
        this.f34221a = (int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f34221a;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < childCount; i++) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(i));
            if (i != 0 || childLayoutPosition != 0) {
                View childAt = recyclerView.getChildAt(i);
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) paddingLeft, (float) childAt.getBottom(), (float) width, (float) (childAt.getBottom() + this.f34221a), this.f34222b);
            }
        }
    }
}
