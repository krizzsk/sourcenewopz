package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

public class RoundLinearLayout extends LinearLayout {

    /* renamed from: a */
    private final Path f41555a;

    /* renamed from: b */
    private final Paint f41556b;

    /* renamed from: c */
    private final RectF f41557c;

    /* renamed from: d */
    private float f41558d;

    /* renamed from: e */
    private float f41559e;

    /* renamed from: f */
    private float f41560f;

    /* renamed from: g */
    private float f41561g;

    public RoundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41555a = new Path();
        this.f41556b = new Paint(1);
        this.f41557c = new RectF();
        this.f41556b.setAntiAlias(true);
        this.f41556b.setDither(true);
        this.f41556b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void setRadius(float f) {
        this.f41561g = f;
        this.f41560f = f;
        this.f41559e = f;
        this.f41558d = f;
        postInvalidate();
    }

    public void setTopLeftRadius(float f) {
        this.f41558d = f;
        postInvalidate();
    }

    public void setTopRightRadius(float f) {
        this.f41559e = f;
        postInvalidate();
    }

    public void setBottomLeftRadius(float f) {
        this.f41560f = f;
        postInvalidate();
    }

    public void setBottomRightRadius(float f) {
        this.f41561g = f;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f41557c.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m29382b(canvas);
        } else {
            m29381a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            m29384d(canvas);
        } else {
            m29383c(canvas);
        }
    }

    /* renamed from: a */
    private void m29381a(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f41557c, (Paint) null, 31);
        super.draw(canvas);
        canvas.drawPath(m29380a(), this.f41556b);
        canvas.restore();
    }

    /* renamed from: b */
    private void m29382b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m29380a());
        super.draw(canvas);
        canvas.restore();
    }

    /* renamed from: c */
    private void m29383c(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f41557c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(m29380a(), this.f41556b);
        canvas.restore();
    }

    /* renamed from: d */
    private void m29384d(Canvas canvas) {
        canvas.save();
        canvas.clipPath(m29380a());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m29380a() {
        this.f41555a.reset();
        Path path = this.f41555a;
        RectF rectF = this.f41557c;
        float f = this.f41558d;
        float f2 = this.f41559e;
        float f3 = this.f41560f;
        float f4 = this.f41561g;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
        return this.f41555a;
    }
}
