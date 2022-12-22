package com.didi.soda.customer.component.feed.decorator;

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
    private static final int f40777a = Color.rgb(100, 100, 100);

    /* renamed from: b */
    private static final int f40778b = 5;

    /* renamed from: c */
    private final Rect f40779c = new Rect();

    /* renamed from: d */
    private Paint f40780d = new Paint();

    /* renamed from: e */
    private int f40781e = 0;

    /* renamed from: f */
    private int f40782f = 0;
    protected int mDecoratorHeight = 5;
    protected boolean mEnableTopDecorator = false;

    public CustomerSimpleDecorator() {
        setDecoratorColor(f40777a);
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
            m28955a(canvas, recyclerView, view, i2);
        }
    }

    public void setDecoratorColor(int i) {
        this.f40780d.setColor(i);
    }

    public void setDecoratorHeight(int i) {
        this.mDecoratorHeight = i;
    }

    public void setDecoratorPadding(int i, int i2) {
        this.f40781e = i;
        this.f40782f = i2;
    }

    /* renamed from: a */
    private void m28955a(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft() + this.f40781e;
            i2 = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f40782f;
            Canvas canvas2 = canvas;
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            Canvas canvas3 = canvas;
            i3 = this.f40781e;
            i2 = recyclerView.getWidth() - this.f40782f;
        }
        RecyclerView recyclerView2 = recyclerView;
        recyclerView.getDecoratedBoundsWithMargins(view, this.f40779c);
        int round = this.f40779c.bottom + Math.round(ViewCompat.getTranslationY(view));
        int i4 = round - this.mDecoratorHeight;
        if (this.mEnableTopDecorator && (i & 16) != 0) {
            int round2 = this.f40779c.top + Math.round(ViewCompat.getTranslationY(view));
            canvas.drawRect((float) i3, (float) round2, (float) i2, (float) (this.mDecoratorHeight + round2), this.f40780d);
        }
        canvas.drawRect((float) i3, (float) i4, (float) i2, (float) round, this.f40780d);
        canvas.restore();
    }
}
