package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class XPanelHeardBarTopView extends View {

    /* renamed from: a */
    private Rect f49431a = new Rect();

    /* renamed from: b */
    private Paint f49432b = new Paint();

    public XPanelHeardBarTopView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f49432b = paint;
        paint.setAntiAlias(true);
        this.f49432b.setStyle(Paint.Style.FILL);
        this.f49432b.setColor(0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f49431a.left = getPaddingLeft();
        this.f49431a.top = getPaddingTop();
        Rect rect = this.f49431a;
        rect.right = (rect.left + getMeasuredWidth()) - getPaddingRight();
        Rect rect2 = this.f49431a;
        rect2.bottom = (rect2.top + getMeasuredHeight()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f49431a, this.f49432b);
    }

    public void setDrawColor(int i) {
        this.f49432b.setColor(i);
        invalidate();
    }
}
