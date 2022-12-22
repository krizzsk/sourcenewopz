package com.didi.payment.commonsdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.sdk.apm.SystemUtils;

public class RoundedImageView extends ImageView {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_RIGHT_CORNER = 3;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private int f30209a = 0;

    /* renamed from: b */
    private final RectF f30210b = new RectF();

    /* renamed from: c */
    private float f30211c;

    /* renamed from: d */
    private final Paint f30212d = new Paint();

    /* renamed from: e */
    private final Paint f30213e = new Paint();

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21139a();
    }

    public RoundedImageView(Context context) {
        super(context);
        m21139a();
    }

    /* renamed from: a */
    private void m21139a() {
        this.f30212d.setAntiAlias(true);
        this.f30212d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f30213e.setAntiAlias(true);
        this.f30213e.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f30209a = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f30211c = f;
        invalidate();
    }

    public void setRectRedius(float f) {
        this.f30211c = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f30210b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f30210b, this.f30213e, 31);
        RectF rectF = this.f30210b;
        float f = this.f30211c;
        canvas.drawRoundRect(rectF, f, f, this.f30213e);
        int i = this.f30209a;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f30211c, (float) getWidth(), (float) getHeight(), this.f30213e);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f30211c, this.f30213e);
        } else if (i == 3) {
            canvas.drawRect(0.0f, 0.0f, ((float) getWidth()) - this.f30211c, (float) getHeight(), this.f30213e);
        }
        SystemUtils.saveLayer(canvas, this.f30210b, this.f30212d, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
