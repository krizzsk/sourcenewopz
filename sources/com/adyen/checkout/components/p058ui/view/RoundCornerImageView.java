package com.adyen.checkout.components.p058ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

/* renamed from: com.adyen.checkout.components.ui.view.RoundCornerImageView */
public class RoundCornerImageView extends AppCompatImageView {
    public static final float DEFAULT_RADIUS = 9.0f;
    public static final int DEFAULT_STROKE_COLOR = -16777216;
    public static final float DEFAULT_STROKE_WIDTH = 4.0f;

    /* renamed from: a */
    private float f900a;

    /* renamed from: b */
    private final Paint f901b;

    /* renamed from: c */
    private float f902c;

    /* renamed from: d */
    private int f903d;

    /* renamed from: e */
    private boolean f904e;

    public RoundCornerImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f901b = new Paint();
        this.f904e = true;
        m1057a(context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.RoundCornerImageView, 0, 0));
    }

    public void setRadius(float f) {
        this.f900a = f;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f903d = i;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f902c = f;
        invalidate();
    }

    public void setBorderEnabled(boolean z) {
        this.f904e = z;
        invalidate();
    }

    /* renamed from: a */
    private void m1057a(TypedArray typedArray) {
        try {
            this.f903d = typedArray.getColor(1, -16777216);
            this.f902c = typedArray.getDimension(2, 4.0f);
            this.f900a = typedArray.getDimension(0, 9.0f);
        } finally {
            typedArray.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f = this.f902c;
        super.onMeasure(i + (((int) f) * 2), i2 + (((int) f) * 2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.f904e) {
            super.onDraw(canvas);
            return;
        }
        float f = this.f902c;
        RectF rectF = new RectF(f / 2.0f, f / 2.0f, ((float) getWidth()) - (this.f902c / 2.0f), ((float) getHeight()) - (this.f902c / 2.0f));
        this.f901b.reset();
        if (this.f902c > 0.0f) {
            this.f901b.setStyle(Paint.Style.STROKE);
            this.f901b.setAntiAlias(true);
            this.f901b.setColor(this.f903d);
            this.f901b.setStrokeWidth(this.f902c);
            float f2 = this.f900a;
            canvas.drawRoundRect(rectF, f2, f2, this.f901b);
        }
        Path path = new Path();
        float f3 = this.f900a;
        path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
