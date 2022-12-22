package com.didichuxing.dfbasesdk.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didi.passenger.C10448R;
import java.lang.reflect.Field;

public class DFCaptureButton extends View {

    /* renamed from: a */
    private Paint f46881a;

    /* renamed from: b */
    private StaticLayout f46882b;

    /* renamed from: c */
    private StaticLayout f46883c;

    /* renamed from: d */
    private int f46884d;

    /* renamed from: e */
    private int f46885e;

    /* renamed from: f */
    private int f46886f;

    /* renamed from: g */
    private int f46887g;

    /* renamed from: h */
    private int f46888h;

    /* renamed from: i */
    private int f46889i;

    /* renamed from: j */
    private int f46890j;

    /* renamed from: k */
    private int f46891k;

    /* renamed from: l */
    private String f46892l;

    /* renamed from: m */
    private int f46893m;

    /* renamed from: n */
    private int f46894n;

    /* renamed from: o */
    private int f46895o;

    /* renamed from: p */
    private int f46896p;

    /* renamed from: q */
    private int f46897q;

    /* renamed from: r */
    private ValueAnimator f46898r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public float f46899s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ICaptureCallback f46900t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f46901u;

    /* renamed from: v */
    private RectF f46902v;

    public DFCaptureButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public DFCaptureButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DFCaptureButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f46884d = 872382003;
        this.f46885e = -33229;
        this.f46902v = new RectF();
        m33631a(attributeSet);
        m33634b();
    }

    /* renamed from: a */
    private void m33629a() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (declaredField.getFloat((Object) null) == 0.0f) {
                    declaredField.setFloat((Object) null, 1.0f);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private void m33634b() {
        Paint paint = new Paint();
        this.f46881a = paint;
        paint.setAntiAlias(true);
        this.f46881a.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.f46886f);
        textPaint.setTextSize((float) this.f46893m);
        this.f46882b = new StaticLayout(this.f46892l, textPaint, this.f46889i * 2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setAntiAlias(true);
        textPaint2.setColor(this.f46886f);
        textPaint2.setTextSize((float) this.f46894n);
        this.f46883c = new StaticLayout(this.f46892l, textPaint2, this.f46890j * 2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        m33629a();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, (float) this.f46895o}).setDuration((long) (this.f46895o * 1000));
        this.f46898r = duration;
        duration.setInterpolator(new LinearInterpolator());
        this.f46898r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = DFCaptureButton.this.f46899s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                DFCaptureButton.this.f46900t.onProgress((int) DFCaptureButton.this.f46899s);
                DFCaptureButton.this.invalidate();
            }
        });
        this.f46898r.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = DFCaptureButton.this.f46901u = false;
                DFCaptureButton.this.invalidate();
                if (DFCaptureButton.this.f46900t != null) {
                    DFCaptureButton.this.f46900t.onUp((int) DFCaptureButton.this.f46899s);
                }
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = DFCaptureButton.this.f46901u = true;
                if (DFCaptureButton.this.f46900t != null) {
                    DFCaptureButton.this.f46900t.onDown();
                }
            }
        });
    }

    /* renamed from: a */
    private void m33631a(AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.DFCaptureButton);
            this.f46884d = obtainStyledAttributes.getColor(0, 0);
            this.f46885e = obtainStyledAttributes.getColor(8, 0);
            this.f46889i = obtainStyledAttributes.getDimensionPixelSize(9, 0);
            this.f46890j = obtainStyledAttributes.getDimensionPixelSize(10, 0);
            this.f46892l = obtainStyledAttributes.getString(5);
            this.f46886f = obtainStyledAttributes.getColor(6, 0);
            this.f46893m = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.f46894n = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f46895o = obtainStyledAttributes.getInt(1, 0);
            this.f46887g = obtainStyledAttributes.getColor(2, 0);
            this.f46891k = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f46888h = (int) (((float) Math.min(measuredWidth, measuredHeight)) * 0.5f);
        float f = (float) measuredWidth;
        this.f46896p = (int) (f * 0.5f);
        float f2 = (float) measuredHeight;
        this.f46897q = (int) (f2 * 0.5f);
        float f3 = ((float) this.f46891k) * 0.5f;
        this.f46902v.set(f3, f3, f - f3, f2 - f3);
    }

    public void draw(Canvas canvas) {
        StaticLayout staticLayout;
        int i;
        int i2;
        super.draw(canvas);
        this.f46881a.setStyle(Paint.Style.FILL);
        this.f46881a.setColor(this.f46884d);
        canvas.drawCircle((float) this.f46896p, (float) this.f46897q, (float) this.f46888h, this.f46881a);
        this.f46881a.setColor(this.f46885e);
        if (this.f46901u) {
            i2 = this.f46890j;
            i = this.f46894n;
            staticLayout = this.f46883c;
            m33630a(canvas);
        } else {
            i2 = this.f46889i;
            i = this.f46893m;
            staticLayout = this.f46882b;
        }
        this.f46881a.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) this.f46896p, (float) this.f46897q, (float) i2, this.f46881a);
        this.f46881a.setColor(this.f46886f);
        this.f46881a.setTextSize((float) i);
        canvas.save();
        canvas.translate((float) (this.f46896p - i2), ((float) this.f46897q) - (((float) this.f46889i) * 0.5f));
        staticLayout.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m33630a(Canvas canvas) {
        this.f46881a.setStyle(Paint.Style.STROKE);
        this.f46881a.setStrokeWidth((float) this.f46891k);
        this.f46881a.setColor(this.f46887g);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f46902v, -90.0f, ((this.f46899s * 1.0f) / ((float) this.f46895o)) * 360.0f, false, this.f46881a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            m33636d();
        } else if (action == 1) {
            m33635c();
        }
        return true;
    }

    public void setCaptureCallback(ICaptureCallback iCaptureCallback) {
        this.f46900t = iCaptureCallback;
    }

    public void setMaxTime(int i) {
        if (i <= 0) {
            i = 20;
        }
        this.f46895o = i;
        this.f46898r.setFloatValues(new float[]{0.0f, (float) i});
        this.f46898r.setDuration((long) (i * 1000));
    }

    /* renamed from: c */
    private void m33635c() {
        this.f46898r.cancel();
    }

    /* renamed from: d */
    private void m33636d() {
        this.f46898r.start();
    }
}
