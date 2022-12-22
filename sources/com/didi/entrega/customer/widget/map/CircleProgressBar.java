package com.didi.entrega.customer.widget.map;

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
    private int f20583a;

    /* renamed from: b */
    private float f20584b;

    /* renamed from: c */
    private CharSequence f20585c;

    /* renamed from: d */
    private int f20586d;

    /* renamed from: e */
    private int f20587e;

    /* renamed from: f */
    private int f20588f;

    /* renamed from: g */
    private int f20589g;

    /* renamed from: h */
    private int f20590h;

    /* renamed from: i */
    private int f20591i;

    /* renamed from: j */
    private int f20592j;

    /* renamed from: k */
    private int f20593k;

    /* renamed from: l */
    private int f20594l;

    /* renamed from: m */
    private Paint f20595m;

    /* renamed from: n */
    private RectF f20596n;

    public CircleProgressBar(Context context) {
        super(context);
        m15057a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15057a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15057a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m15057a(context, attributeSet);
    }

    public int getDotColor() {
        return this.f20592j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f20592j = i;
        return this;
    }

    public int getDotRadius() {
        return this.f20591i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f20591i = i;
        return this;
    }

    public int getFillColor() {
        return this.f20593k;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f20593k = i;
        return this;
    }

    public int getGoneColor() {
        return this.f20590h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f20590h = i;
        return this;
    }

    public int getMax() {
        return this.f20583a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f20583a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f20584b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f20584b = f;
        return this;
    }

    public int getStartAngle() {
        return this.f20594l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f20594l = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f20589g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f20589g = i;
        return this;
    }

    public int getStrokeWidth() {
        return this.f20588f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f20588f = i;
        return this;
    }

    public CharSequence getText() {
        return this.f20585c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f20585c = charSequence;
        return this;
    }

    public int getTextColor() {
        return this.f20587e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f20587e = i;
        return this;
    }

    public int getTextSize() {
        return this.f20586d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f20586d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f20595m.setAntiAlias(true);
        this.f20595m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f20595m.setStrokeWidth((float) this.f20588f);
        this.f20595m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f20591i, ((float) this.f20588f) / 2.0f);
        RectF rectF = this.f20596n;
        rectF.top = max;
        rectF.left = max;
        this.f20596n.right = width - max;
        this.f20596n.bottom = height - max;
        this.f20595m.setStyle(Paint.Style.FILL);
        this.f20595m.setColor(this.f20593k);
        canvas.drawArc(this.f20596n, 0.0f, 360.0f, false, this.f20595m);
        this.f20595m.setStyle(Paint.Style.STROKE);
        this.f20595m.setColor(this.f20590h);
        float f = (this.f20584b * 360.0f) / ((float) this.f20583a);
        canvas.drawArc(this.f20596n, (float) this.f20594l, f, false, this.f20595m);
        this.f20595m.setColor(this.f20589g);
        float f2 = ((float) this.f20594l) + f;
        canvas.drawArc(this.f20596n, f2, 360.0f - f, false, this.f20595m);
        this.f20595m.setColor(this.f20592j);
        this.f20595m.setStrokeWidth(0.0f);
        this.f20595m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f20591i, this.f20595m);
        if (!TextUtils.isEmpty(this.f20585c)) {
            this.f20595m.setTextSize((float) this.f20586d);
            this.f20595m.setColor(this.f20587e);
            this.f20595m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f20585c;
            canvas.drawText((String) charSequence, (width - this.f20595m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f20586d / 2))) - 2.0f, this.f20595m);
        }
    }

    /* renamed from: a */
    private void m15057a(Context context, AttributeSet attributeSet) {
        m15058b(context, attributeSet);
        this.f20595m = new Paint();
        this.f20596n = new RectF();
    }

    /* renamed from: b */
    private void m15058b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f20583a = 100;
            this.f20584b = 80.0f;
            this.f20586d = 20;
            this.f20587e = -65536;
            this.f20588f = 20;
            this.f20589g = -16777216;
            this.f20590h = 0;
            this.f20591i = 30;
            this.f20592j = -16776961;
            this.f20593k = -1;
            this.f20594l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaCircleProgressBarAttr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f20583a = integer;
        if (integer > 0) {
            this.f20584b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f20585c = obtainStyledAttributes.getString(9);
            this.f20586d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f20587e = obtainStyledAttributes.getColor(10, -65536);
            this.f20588f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f20589g = obtainStyledAttributes.getColor(7, -16777216);
            this.f20590h = obtainStyledAttributes.getColor(3, 0);
            this.f20591i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f20592j = obtainStyledAttributes.getColor(0, -16776961);
            this.f20593k = obtainStyledAttributes.getColor(2, -1);
            this.f20594l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
