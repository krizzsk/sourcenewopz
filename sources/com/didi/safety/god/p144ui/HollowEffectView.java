package com.didi.safety.god.p144ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.didi.safety.god.ui.HollowEffectView */
public class HollowEffectView extends View {

    /* renamed from: b */
    private static final int f34763b = -16777216;

    /* renamed from: a */
    private Paint f34764a;

    /* renamed from: c */
    private View f34765c;

    /* renamed from: d */
    private Rect f34766d;

    /* renamed from: e */
    private Rect f34767e;

    /* renamed from: f */
    private Rect f34768f;

    /* renamed from: g */
    private Rect f34769g;

    public HollowEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24550a();
    }

    /* renamed from: a */
    private void m24550a() {
        Paint paint = new Paint(1);
        this.f34764a = paint;
        paint.setColor(-16777216);
    }

    public void setTargetView(View view) {
        this.f34765c = view;
        setVisibility(0);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f34765c != null) {
            if (this.f34766d == null) {
                this.f34766d = new Rect(0, 0, this.f34765c.getLeft(), getHeight());
                this.f34767e = new Rect(this.f34765c.getLeft(), 0, this.f34765c.getRight(), this.f34765c.getTop());
                this.f34768f = new Rect(this.f34765c.getRight(), 0, getWidth(), getHeight());
                this.f34769g = new Rect(this.f34765c.getLeft(), this.f34765c.getBottom(), this.f34765c.getRight(), getHeight());
            }
            canvas.drawRect(this.f34766d, this.f34764a);
            canvas.drawRect(this.f34767e, this.f34764a);
            canvas.drawRect(this.f34768f, this.f34764a);
            canvas.drawRect(this.f34769g, this.f34764a);
        }
    }
}
