package com.didi.beatles.p099im.views.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.views.widget.IMDividerDecoration */
public class IMDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final String f10454a = "IMDividerDecoration";

    /* renamed from: b */
    private int f10455b;

    /* renamed from: c */
    private int f10456c = -65536;

    /* renamed from: d */
    private int f10457d = 2;

    /* renamed from: e */
    private boolean f10458e;

    public void setDividerWidth(int i) {
        if (i >= 0) {
            this.f10457d = i;
            return;
        }
        throw new IllegalArgumentException("divider width " + i + " is not valid!");
    }

    public void setDividerColor(int i) {
        this.f10456c = i;
    }

    public void isLastItemShowDivider(boolean z) {
        this.f10458e = z;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            this.f10455b = ((LinearLayoutManager) layoutManager).getOrientation();
            IMLog.m6631d(f10454a, "onDraw: direction " + this.f10455b);
            if (this.f10455b == 1) {
                m7108a(canvas, recyclerView);
            } else {
                m7109b(canvas, recyclerView);
            }
        } else {
            throw new IllegalArgumentException("recyclerview's manager is not LinearLayoutManager,can't use IMDividerDecoration");
        }
    }

    /* renamed from: a */
    private void m7108a(Canvas canvas, RecyclerView recyclerView) {
        if (recyclerView != null) {
            int childCount = recyclerView.getChildCount();
            if (!this.f10458e) {
                childCount--;
            }
            if (childCount >= 1) {
                Paint paint = new Paint();
                paint.setColor(this.f10456c);
                paint.setStrokeWidth((float) this.f10457d);
                paint.setAntiAlias(true);
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    canvas.drawLine(childAt.getX(), childAt.getY() + ((float) childAt.getHeight()), childAt.getX() + ((float) childAt.getWidth()), childAt.getY() + ((float) childAt.getHeight()), paint);
                }
            }
        }
    }

    /* renamed from: b */
    private void m7109b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (!this.f10458e) {
            childCount--;
        }
        if (childCount >= 1) {
            Paint paint = new Paint();
            paint.setColor(this.f10456c);
            paint.setStrokeWidth((float) this.f10457d);
            paint.setAntiAlias(true);
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                canvas.drawLine(childAt.getX() + ((float) childAt.getWidth()), childAt.getY(), childAt.getX() + ((float) childAt.getWidth()), childAt.getY() + ((float) childAt.getHeight()), paint);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f10455b == 1) {
            rect.set(0, 0, 0, this.f10457d);
        } else {
            rect.set(0, 0, this.f10457d, 0);
        }
    }
}
