package com.didi.soda.address;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;

public class CustomerSimpleDecorator implements ItemDecorator {

    /* renamed from: a */
    private static final int f38649a = Color.rgb(100, 100, 100);

    /* renamed from: b */
    private static final int f38650b = 5;

    /* renamed from: c */
    private final Rect f38651c = new Rect();

    /* renamed from: d */
    private int f38652d = 5;

    /* renamed from: e */
    private Paint f38653e = new Paint();

    /* renamed from: f */
    private int f38654f = 0;

    /* renamed from: g */
    private int f38655g = 0;

    /* renamed from: h */
    private boolean f38656h = false;

    public CustomerSimpleDecorator() {
        setDecoratorColor(f38649a);
    }

    public CustomerSimpleDecorator(int i, int i2) {
        setDecoratorColor(i);
        setDecoratorHeight(i2);
    }

    public void enablePositionTopDecorator() {
        this.f38656h = true;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        if (!this.f38656h || (i2 & 2) == 0) {
            rect.set(0, 0, 0, this.f38652d);
            return;
        }
        int i3 = this.f38652d;
        rect.set(0, i3, 0, i3);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        if (recyclerView.getLayoutManager() != null) {
            m27364a(canvas, recyclerView, view, i2);
        }
    }

    public void setDecoratorColor(int i) {
        this.f38653e.setColor(i);
    }

    public void setDecoratorHeight(int i) {
        this.f38652d = i;
    }

    public void setDecoratorPadding(int i, int i2) {
        this.f38654f = i;
        this.f38655g = i2;
    }

    /* renamed from: a */
    private void m27364a(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft() + this.f38654f;
            i2 = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f38655g;
            Canvas canvas2 = canvas;
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            Canvas canvas3 = canvas;
            i3 = this.f38654f;
            i2 = recyclerView.getWidth() - this.f38655g;
        }
        RecyclerView recyclerView2 = recyclerView;
        recyclerView.getDecoratedBoundsWithMargins(view, this.f38651c);
        int round = this.f38651c.bottom + Math.round(ViewCompat.getTranslationY(view));
        int i4 = round - this.f38652d;
        if (this.f38656h && (i & 2) != 0) {
            int round2 = this.f38651c.top + Math.round(ViewCompat.getTranslationY(view));
            canvas.drawRect((float) i3, (float) round2, (float) i2, (float) (this.f38652d + round2), this.f38653e);
        }
        canvas.drawRect((float) i3, (float) i4, (float) i2, (float) round, this.f38653e);
        canvas.restore();
    }
}
