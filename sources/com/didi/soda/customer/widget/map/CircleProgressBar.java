package com.didi.soda.customer.widget.map;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.didi.passenger.C10448R;

public class CircleProgressBar extends View {
    public static final float DEFAULT_CURRENT_PROGRESS = 80.0f;
    public static final int DEFAULT_DOT_COLOR = -16776961;
    public static final int DEFAULT_DOT_RADIUS = 30;
    public static final int DEFAULT_FILL_COLOR = -1;
    public static final int DEFAULT_GONE_COLOR = 0;
    public static final int DEFAULT_MAX_PROGRESS = 100;
    public static final int DEFAULT_START_ANGLE = 0;
    public static final int DEFAULT_STROKE_COLOR = -16777216;
    public static final int DEFAULT_STROKE_WIDTH = 20;
    public static final int DEFAULT_TEXT_COLOR = -65536;
    public static final int DEFAULT_TEXT_SIZE = 20;

    /* renamed from: a */
    private int f42120a;

    /* renamed from: b */
    private float f42121b;

    /* renamed from: c */
    private CharSequence f42122c;

    /* renamed from: d */
    private int f42123d;

    /* renamed from: e */
    private int f42124e;

    /* renamed from: f */
    private int f42125f;

    /* renamed from: g */
    private int f42126g;

    /* renamed from: h */
    private int f42127h;

    /* renamed from: i */
    private int f42128i;

    /* renamed from: j */
    private int f42129j;

    /* renamed from: k */
    private int f42130k;

    /* renamed from: l */
    private int f42131l;

    /* renamed from: m */
    private Paint f42132m;

    /* renamed from: n */
    private RectF f42133n;

    public CircleProgressBar(Context context) {
        super(context);
        m29704a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29704a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29704a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m29704a(context, attributeSet);
    }

    public int getDotColor() {
        return this.f42129j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f42129j = i;
        return this;
    }

    public int getDotRadius() {
        return this.f42128i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f42128i = i;
        return this;
    }

    public int getFillColor() {
        return this.f42130k;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f42130k = i;
        return this;
    }

    public int getGoneColor() {
        return this.f42127h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f42127h = i;
        return this;
    }

    public int getMax() {
        return this.f42120a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f42120a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f42121b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f42121b = f;
        return this;
    }

    public int getStartAngle() {
        return this.f42131l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f42131l = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f42126g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f42126g = i;
        return this;
    }

    public int getStrokeWidth() {
        return this.f42125f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f42125f = i;
        return this;
    }

    public CharSequence getText() {
        return this.f42122c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f42122c = charSequence;
        return this;
    }

    public int getTextColor() {
        return this.f42124e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f42124e = i;
        return this;
    }

    public int getTextSize() {
        return this.f42123d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f42123d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f42132m.setAntiAlias(true);
        this.f42132m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f42132m.setStrokeWidth((float) this.f42125f);
        this.f42132m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f42128i, ((float) this.f42125f) / 2.0f);
        RectF rectF = this.f42133n;
        rectF.top = max;
        rectF.left = max;
        this.f42133n.right = width - max;
        this.f42133n.bottom = height - max;
        this.f42132m.setStyle(Paint.Style.FILL);
        this.f42132m.setColor(this.f42130k);
        canvas.drawArc(this.f42133n, 0.0f, 360.0f, false, this.f42132m);
        this.f42132m.setStyle(Paint.Style.STROKE);
        this.f42132m.setColor(this.f42127h);
        float f = (this.f42121b * 360.0f) / ((float) this.f42120a);
        canvas.drawArc(this.f42133n, (float) this.f42131l, f, false, this.f42132m);
        this.f42132m.setColor(this.f42126g);
        float f2 = ((float) this.f42131l) + f;
        canvas.drawArc(this.f42133n, f2, 360.0f - f, false, this.f42132m);
        this.f42132m.setColor(this.f42129j);
        this.f42132m.setStrokeWidth(0.0f);
        this.f42132m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f42128i, this.f42132m);
        if (!TextUtils.isEmpty(this.f42122c)) {
            this.f42132m.setTextSize((float) this.f42123d);
            this.f42132m.setColor(this.f42124e);
            this.f42132m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f42122c;
            canvas.drawText((String) charSequence, (width - this.f42132m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f42123d / 2))) - 2.0f, this.f42132m);
        }
    }

    /* renamed from: a */
    private void m29704a(Context context, AttributeSet attributeSet) {
        m29705b(context, attributeSet);
        this.f42132m = new Paint();
        this.f42133n = new RectF();
    }

    /* renamed from: b */
    private void m29705b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f42120a = 100;
            this.f42121b = 80.0f;
            this.f42123d = 20;
            this.f42124e = -65536;
            this.f42125f = 20;
            this.f42126g = -16777216;
            this.f42127h = 0;
            this.f42128i = 30;
            this.f42129j = -16776961;
            this.f42130k = -1;
            this.f42131l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CircleProgressBarAttr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f42120a = integer;
        if (integer > 0) {
            this.f42121b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f42122c = obtainStyledAttributes.getString(9);
            this.f42123d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f42124e = obtainStyledAttributes.getColor(10, -65536);
            this.f42125f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f42126g = obtainStyledAttributes.getColor(7, -16777216);
            this.f42127h = obtainStyledAttributes.getColor(3, 0);
            this.f42128i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f42129j = obtainStyledAttributes.getColor(0, -16776961);
            this.f42130k = obtainStyledAttributes.getColor(2, -1);
            this.f42131l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
