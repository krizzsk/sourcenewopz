package com.didi.component.common.view.recyclerdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class Y_DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Paint f11916a;

    public abstract Y_Divider getDivider(int i, int i2);

    public Y_DividerItemDecoration() {
        Paint paint = new Paint(1);
        this.f11916a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            Y_Divider divider = getDivider(childCount, ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewLayoutPosition());
            if (divider.getLeftSideLine().isHave()) {
                int widthPx = divider.getLeftSideLine().getWidthPx();
                int startPaddingPx = divider.getLeftSideLine().getStartPaddingPx();
                int endPaddingPx = divider.getLeftSideLine().getEndPaddingPx();
                m8045c(childAt, canvas, recyclerView, divider.getLeftSideLine().getColor(), widthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getTopSideLine().isHave()) {
                int widthPx2 = divider.getTopSideLine().getWidthPx();
                int startPaddingPx2 = divider.getTopSideLine().getStartPaddingPx();
                int endPaddingPx2 = divider.getTopSideLine().getEndPaddingPx();
                m8044b(childAt, canvas, recyclerView, divider.topSideLine.getColor(), widthPx2, startPaddingPx2, endPaddingPx2);
            }
            if (divider.getRightSideLine().isHave()) {
                int widthPx3 = divider.getRightSideLine().getWidthPx();
                int startPaddingPx3 = divider.getRightSideLine().getStartPaddingPx();
                int endPaddingPx3 = divider.getRightSideLine().getEndPaddingPx();
                m8046d(childAt, canvas, recyclerView, divider.getRightSideLine().getColor(), widthPx3, startPaddingPx3, endPaddingPx3);
            }
            if (divider.getBottomSideLine().isHave()) {
                int widthPx4 = divider.getBottomSideLine().getWidthPx();
                int startPaddingPx4 = divider.getBottomSideLine().getStartPaddingPx();
                int endPaddingPx4 = divider.getBottomSideLine().getEndPaddingPx();
                m8043a(childAt, canvas, recyclerView, divider.getBottomSideLine().getColor(), widthPx4, startPaddingPx4, endPaddingPx4);
            }
        }
    }

    /* renamed from: a */
    private void m8043a(View view, Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        if (i3 <= 0) {
            i3 = -i2;
        }
        int i5 = i4 <= 0 ? i2 : -i4;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int left = (view.getLeft() - layoutParams.leftMargin) + i3;
        int right = view.getRight() + layoutParams.rightMargin + i5;
        int bottom = view.getBottom() + layoutParams.bottomMargin;
        this.f11916a.setColor(i);
        canvas.drawRect((float) left, (float) bottom, (float) right, (float) (i2 + bottom), this.f11916a);
    }

    /* renamed from: b */
    private void m8044b(View view, Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        if (i3 <= 0) {
            i3 = -i2;
        }
        int i5 = i4 <= 0 ? i2 : -i4;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int left = (view.getLeft() - layoutParams.leftMargin) + i3;
        int right = view.getRight() + layoutParams.rightMargin + i5;
        int top = view.getTop() - layoutParams.topMargin;
        this.f11916a.setColor(i);
        canvas.drawRect((float) left, (float) (top - i2), (float) right, (float) top, this.f11916a);
    }

    /* renamed from: c */
    private void m8045c(View view, Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        if (i3 <= 0) {
            i3 = -i2;
        }
        int i5 = i4 <= 0 ? i2 : -i4;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int top = (view.getTop() - layoutParams.topMargin) + i3;
        int bottom = view.getBottom() + layoutParams.bottomMargin + i5;
        int left = view.getLeft() - layoutParams.leftMargin;
        this.f11916a.setColor(i);
        canvas.drawRect((float) (left - i2), (float) top, (float) left, (float) bottom, this.f11916a);
    }

    /* renamed from: d */
    private void m8046d(View view, Canvas canvas, RecyclerView recyclerView, int i, int i2, int i3, int i4) {
        if (i3 <= 0) {
            i3 = -i2;
        }
        int i5 = i4 <= 0 ? i2 : -i4;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int top = (view.getTop() - layoutParams.topMargin) + i3;
        int bottom = view.getBottom() + layoutParams.bottomMargin + i5;
        int right = view.getRight() + layoutParams.rightMargin;
        this.f11916a.setColor(i);
        canvas.drawRect((float) right, (float) top, (float) (i2 + right), (float) bottom, this.f11916a);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Y_Divider divider = getDivider(recyclerView.getChildCount(), ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition());
        if (divider == null) {
            divider = new Y_DividerBuilder().create();
        }
        int i = 0;
        int widthPx = divider.getLeftSideLine().isHave() ? divider.getLeftSideLine().getWidthPx() : 0;
        int widthPx2 = divider.getTopSideLine().isHave() ? divider.getTopSideLine().getWidthPx() : 0;
        int widthPx3 = divider.getRightSideLine().isHave() ? divider.getRightSideLine().getWidthPx() : 0;
        if (divider.getBottomSideLine().isHave()) {
            i = divider.getBottomSideLine().getWidthPx();
        }
        rect.set(widthPx, widthPx2, widthPx3, i);
    }
}
