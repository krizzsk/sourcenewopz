package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.dcrypto.util.ColorUtils;

public class CarPoolTriangleView extends View {

    /* renamed from: a */
    private Paint f25306a;

    /* renamed from: b */
    private Path f25307b;

    public CarPoolTriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarPoolTriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18114a();
    }

    /* renamed from: a */
    private void m18114a() {
        Paint paint = new Paint(1);
        this.f25306a = paint;
        paint.setColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
        this.f25306a.setStrokeJoin(Paint.Join.ROUND);
        this.f25307b = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.f25307b.reset();
        this.f25307b.moveTo((float) (getWidth() / 2), 0.0f);
        this.f25307b.lineTo((float) getWidth(), (float) getHeight());
        this.f25307b.lineTo(0.0f, (float) getHeight());
        this.f25307b.close();
        canvas.drawPath(this.f25307b, this.f25306a);
    }
}
