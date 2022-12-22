package com.didi.beatles.p099im.views.imageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.imageView.IMRoundedImageView */
public class IMRoundedImageView extends ImageView {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private final RectF f10289a = new RectF();

    /* renamed from: b */
    private float f10290b;

    /* renamed from: c */
    private final Paint f10291c = new Paint();

    /* renamed from: d */
    private final Paint f10292d = new Paint();

    /* renamed from: e */
    private int f10293e;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.imageView.IMRoundedImageView$IMCornerType */
    public @interface IMCornerType {
    }

    public IMRoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.IMRoundedImageView);
        this.f10290b = obtainStyledAttributes.getDimension(0, 4.0f);
        obtainStyledAttributes.recycle();
        m7021a();
    }

    public IMRoundedImageView(Context context) {
        super(context);
        m7021a();
    }

    /* renamed from: a */
    private void m7021a() {
        this.f10291c.setAntiAlias(true);
        this.f10291c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f10292d.setAntiAlias(true);
        this.f10292d.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f10293e = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f10290b = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f10289a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f10289a, this.f10292d, 31);
        RectF rectF = this.f10289a;
        float f = this.f10290b;
        canvas.drawRoundRect(rectF, f, f, this.f10292d);
        int i = this.f10293e;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f10290b, (float) getWidth(), (float) getHeight(), this.f10292d);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f10290b, this.f10292d);
        }
        SystemUtils.saveLayer(canvas, this.f10289a, this.f10291c, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
