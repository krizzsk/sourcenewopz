package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

public class RoundedLinearLayout extends LinearLayout {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_RIGHT_CORNER = 3;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private int f32387a = 0;

    /* renamed from: b */
    private final RectF f32388b = new RectF();

    /* renamed from: c */
    private float f32389c;

    /* renamed from: d */
    private final Paint f32390d = new Paint();

    /* renamed from: e */
    private final Paint f32391e = new Paint();

    public RoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22993a();
    }

    public RoundedLinearLayout(Context context) {
        super(context);
        m22993a();
    }

    /* renamed from: a */
    private void m22993a() {
        this.f32390d.setAntiAlias(true);
        this.f32390d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f32391e.setAntiAlias(true);
        this.f32391e.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f32387a = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f32389c = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f32388b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f32388b, this.f32391e, 31);
        RectF rectF = this.f32388b;
        float f = this.f32389c;
        canvas.drawRoundRect(rectF, f, f, this.f32391e);
        int i = this.f32387a;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f32389c, (float) getWidth(), (float) getHeight(), this.f32391e);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f32389c, this.f32391e);
        } else if (i == 3) {
            canvas.drawRect(0.0f, 0.0f, ((float) getWidth()) - this.f32389c, (float) getHeight(), this.f32391e);
        }
        SystemUtils.saveLayer(canvas, this.f32388b, this.f32390d, 31);
        super.dispatchDraw(canvas);
        canvas.restore();
    }
}
