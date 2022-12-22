package com.didi.entrega.customer.component.feed.decorator;

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
    private static final int f19854a = Color.rgb(100, 100, 100);

    /* renamed from: b */
    private static final int f19855b = 5;

    /* renamed from: c */
    private final Rect f19856c = new Rect();

    /* renamed from: d */
    private Paint f19857d = new Paint();

    /* renamed from: e */
    private int f19858e = 0;

    /* renamed from: f */
    private int f19859f = 0;
    protected int mDecoratorHeight = 5;
    protected boolean mEnableTopDecorator = false;

    public CustomerSimpleDecorator() {
        setDecoratorColor(f19854a);
    }

    public CustomerSimpleDecorator(int i, int i2) {
        setDecoratorColor(i);
        setDecoratorHeight(i2);
    }

    public void enablePositionTopDecorator() {
        this.mEnableTopDecorator = true;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        if (!this.mEnableTopDecorator || (i2 & 16) == 0) {
            rect.set(0, 0, 0, this.mDecoratorHeight);
            return;
        }
        int i3 = this.mDecoratorHeight;
        rect.set(0, i3, 0, i3);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        if (recyclerView.getLayoutManager() != null) {
            m14710a(canvas, recyclerView, view, i2);
        }
    }

    public void setDecoratorColor(int i) {
        this.f19857d.setColor(i);
    }

    public void setDecoratorHeight(int i) {
        this.mDecoratorHeight = i;
    }

    public void setDecoratorPadding(int i, int i2) {
        this.f19858e = i;
        this.f19859f = i2;
    }

    /* renamed from: a */
    private void m14710a(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft() + this.f19858e;
            i2 = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f19859f;
            Canvas canvas2 = canvas;
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            Canvas canvas3 = canvas;
            i3 = this.f19858e;
            i2 = recyclerView.getWidth() - this.f19859f;
        }
        RecyclerView recyclerView2 = recyclerView;
        recyclerView.getDecoratedBoundsWithMargins(view, this.f19856c);
        int round = this.f19856c.bottom + Math.round(ViewCompat.getTranslationY(view));
        int i4 = round - this.mDecoratorHeight;
        if (this.mEnableTopDecorator && (i & 16) != 0) {
            int round2 = this.f19856c.top + Math.round(ViewCompat.getTranslationY(view));
            canvas.drawRect((float) i3, (float) round2, (float) i2, (float) (this.mDecoratorHeight + round2), this.f19857d);
        }
        canvas.drawRect((float) i3, (float) i4, (float) i2, (float) round, this.f19857d);
        canvas.restore();
    }
}
