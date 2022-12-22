package com.didi.app.nova.support.view.recyclerview.decorator;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemDecorator implements ItemDecorator {

    /* renamed from: a */
    private final int f8609a = Color.rgb(100, 100, 100);

    /* renamed from: b */
    private final int f8610b = 5;

    /* renamed from: c */
    private int f8611c = 5;

    /* renamed from: d */
    private final Rect f8612d = new Rect();

    /* renamed from: e */
    private Paint f8613e = new Paint();

    public SimpleItemDecorator() {
        setDecoratorColor(this.f8609a);
    }

    public SimpleItemDecorator(int i, int i2) {
        setDecoratorColor(i);
        setDecoratorHeight(i2);
    }

    public void setDecoratorColor(int i) {
        this.f8613e.setColor(i);
    }

    public void setDecoratorHeight(int i) {
        this.f8611c = i;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        rect.set(0, 0, 0, this.f8611c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        if (recyclerView.getLayoutManager() != null) {
            m5734a(canvas, recyclerView, view);
        }
    }

    /* renamed from: a */
    private void m5734a(Canvas canvas, RecyclerView recyclerView, View view) {
        int i;
        int i2;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingLeft();
            i = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i2, recyclerView.getPaddingTop(), i, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = 0;
            i = recyclerView.getWidth();
        }
        recyclerView.getDecoratedBoundsWithMargins(view, this.f8612d);
        int round = this.f8612d.bottom + Math.round(ViewCompat.getTranslationY(view));
        canvas.drawRect((float) i2, (float) (round - this.f8611c), (float) i, (float) round, this.f8613e);
        canvas.restore();
    }
}
