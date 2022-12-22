package com.didi.component.mapflow.infowindow.widget;

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
    private int f14256a;

    /* renamed from: b */
    private float f14257b;

    /* renamed from: c */
    private CharSequence f14258c;

    /* renamed from: d */
    private int f14259d;

    /* renamed from: e */
    private int f14260e;

    /* renamed from: f */
    private int f14261f;

    /* renamed from: g */
    private int f14262g;

    /* renamed from: h */
    private int f14263h;

    /* renamed from: i */
    private int f14264i;

    /* renamed from: j */
    private int f14265j;

    /* renamed from: k */
    private int f14266k;

    /* renamed from: l */
    private int f14267l;

    /* renamed from: m */
    private Paint f14268m;

    /* renamed from: n */
    private RectF f14269n;

    public CircleProgressBar(Context context) {
        super(context);
        m9932a(context, (AttributeSet) null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9932a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9932a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9932a(context, attributeSet);
    }

    /* renamed from: a */
    private void m9932a(Context context, AttributeSet attributeSet) {
        m9933b(context, attributeSet);
        this.f14268m = new Paint();
        this.f14269n = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f14268m.setAntiAlias(true);
        this.f14268m.setColor(InputDeviceCompat.SOURCE_ANY);
        this.f14268m.setStrokeWidth((float) this.f14261f);
        this.f14268m.setStyle(Paint.Style.STROKE);
        canvas.drawColor(0);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float max = Math.max((float) this.f14264i, ((float) this.f14261f) / 2.0f);
        RectF rectF = this.f14269n;
        rectF.top = max;
        rectF.left = max;
        this.f14269n.right = width - max;
        this.f14269n.bottom = height - max;
        this.f14268m.setStyle(Paint.Style.FILL);
        this.f14268m.setColor(this.f14266k);
        canvas.drawArc(this.f14269n, 0.0f, 360.0f, false, this.f14268m);
        this.f14268m.setStyle(Paint.Style.STROKE);
        this.f14268m.setColor(this.f14263h);
        float f = (this.f14257b * 360.0f) / ((float) this.f14256a);
        canvas.drawArc(this.f14269n, (float) this.f14267l, f, false, this.f14268m);
        this.f14268m.setColor(this.f14262g);
        float f2 = ((float) this.f14267l) + f;
        canvas.drawArc(this.f14269n, f2, 360.0f - f, false, this.f14268m);
        this.f14268m.setColor(this.f14265j);
        this.f14268m.setStrokeWidth(0.0f);
        this.f14268m.setStyle(Paint.Style.FILL);
        double d = (double) f2;
        float f3 = width / 2.0f;
        float f4 = height / 2.0f;
        canvas.drawCircle((((float) Math.cos(Math.toRadians(d))) * (f3 - max)) + f3, (((float) Math.sin(Math.toRadians(d))) * (f4 - max)) + f4, (float) this.f14264i, this.f14268m);
        if (!TextUtils.isEmpty(this.f14258c)) {
            this.f14268m.setTextSize((float) this.f14259d);
            this.f14268m.setColor(this.f14260e);
            this.f14268m.setStyle(Paint.Style.FILL);
            CharSequence charSequence = this.f14258c;
            canvas.drawText((String) charSequence, (width - this.f14268m.measureText(charSequence, 0, charSequence.length())) / 2.0f, (f4 + ((float) (this.f14259d / 2))) - 2.0f, this.f14268m);
        }
    }

    public int getMax() {
        return this.f14256a;
    }

    public CircleProgressBar setMax(int i) {
        if (i > 0) {
            this.f14256a = i;
            return this;
        }
        throw new RuntimeException("Max must bigger than 0");
    }

    public float getProgress() {
        return this.f14257b;
    }

    public CircleProgressBar setProgress(float f) {
        this.f14257b = f;
        return this;
    }

    public CharSequence getText() {
        return this.f14258c;
    }

    public CircleProgressBar setText(CharSequence charSequence) {
        this.f14258c = charSequence;
        return this;
    }

    public int getTextSize() {
        return this.f14259d;
    }

    public CircleProgressBar setTextSize(int i) {
        this.f14259d = i;
        return this;
    }

    public int getTextColor() {
        return this.f14260e;
    }

    public CircleProgressBar setTextColor(int i) {
        this.f14260e = i;
        return this;
    }

    public CircleProgressBar setFillColor(int i) {
        this.f14266k = i;
        return this;
    }

    public int getFillColor() {
        return this.f14266k;
    }

    public int getStrokeWidth() {
        return this.f14261f;
    }

    public CircleProgressBar setStrokeWidth(int i) {
        this.f14261f = i;
        return this;
    }

    public int getStrokeColor() {
        return this.f14262g;
    }

    public CircleProgressBar setStrokeColor(int i) {
        this.f14262g = i;
        return this;
    }

    public int getGoneColor() {
        return this.f14263h;
    }

    public CircleProgressBar setGoneColor(int i) {
        this.f14263h = i;
        return this;
    }

    public int getDotRadius() {
        return this.f14264i;
    }

    public CircleProgressBar setDotRadius(int i) {
        this.f14264i = i;
        return this;
    }

    public int getDotColor() {
        return this.f14265j;
    }

    public CircleProgressBar setDotColor(int i) {
        this.f14265j = i;
        return this;
    }

    public int getStartAngle() {
        return this.f14267l;
    }

    public CircleProgressBar setStartAngle(int i) {
        this.f14267l = i;
        return this;
    }

    /* renamed from: b */
    private void m9933b(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f14256a = 100;
            this.f14257b = 80.0f;
            this.f14259d = 20;
            this.f14260e = -65536;
            this.f14261f = 20;
            this.f14262g = -16777216;
            this.f14263h = 0;
            this.f14264i = 30;
            this.f14265j = -16776961;
            this.f14266k = -1;
            this.f14267l = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.circle_progress_bar_attr);
        int integer = obtainStyledAttributes.getInteger(4, 100);
        this.f14256a = integer;
        if (integer > 0) {
            this.f14257b = obtainStyledAttributes.getFloat(5, 80.0f);
            this.f14258c = obtainStyledAttributes.getString(9);
            this.f14259d = obtainStyledAttributes.getDimensionPixelSize(11, 20);
            this.f14260e = obtainStyledAttributes.getColor(10, -65536);
            this.f14261f = obtainStyledAttributes.getDimensionPixelSize(8, 20);
            this.f14262g = obtainStyledAttributes.getColor(7, -16777216);
            this.f14263h = obtainStyledAttributes.getColor(3, 0);
            this.f14264i = obtainStyledAttributes.getDimensionPixelSize(1, 30);
            this.f14265j = obtainStyledAttributes.getColor(0, -16776961);
            this.f14266k = obtainStyledAttributes.getColor(2, -1);
            this.f14267l = obtainStyledAttributes.getInteger(6, 0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new RuntimeException("Max must bigger than 0");
    }
}
