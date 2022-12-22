package com.didi.component.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.passenger.C10448R;

public class RegisterProgressView extends View {
    public static final int DEFAULT_PROGRESS_COLOR = Color.parseColor("#FE803E");

    /* renamed from: a */
    private static final int f11837a = 3;

    /* renamed from: b */
    private static final int f11838b = 6;

    /* renamed from: c */
    private static final int f11839c = Color.parseColor("#EBEBEB");

    /* renamed from: d */
    private static final int f11840d = -1;

    /* renamed from: e */
    private static final int f11841e = 3;

    /* renamed from: f */
    private static final int f11842f = 6;

    /* renamed from: g */
    private static final int f11843g = 14;

    /* renamed from: h */
    private static final int f11844h = 10;

    /* renamed from: A */
    private ValueAnimator f11845A;

    /* renamed from: B */
    private int f11846B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public Rect f11847C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RectF f11848D;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Bitmap f11849i;

    /* renamed from: j */
    private Paint f11850j;

    /* renamed from: k */
    private Paint f11851k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f11852l;

    /* renamed from: m */
    private float f11853m;

    /* renamed from: n */
    private float f11854n;

    /* renamed from: o */
    private float f11855o;

    /* renamed from: p */
    private int f11856p;

    /* renamed from: q */
    private int f11857q;

    /* renamed from: r */
    private int f11858r;

    /* renamed from: s */
    private float f11859s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f11860t;

    /* renamed from: u */
    private int f11861u;

    /* renamed from: v */
    private int f11862v;

    /* renamed from: w */
    private int f11863w;

    /* renamed from: x */
    private float f11864x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f11865y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f11866z;

    public RegisterProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RegisterProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RegisterProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8023a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8023a(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RegisterProgressView);
            this.f11854n = obtainStyledAttributes.getDimension(10, (float) m8020a(3.0f));
            this.f11857q = obtainStyledAttributes.getColor(9, DEFAULT_PROGRESS_COLOR);
            this.f11855o = obtainStyledAttributes.getDimension(2, (float) m8020a(6.0f));
            this.f11856p = obtainStyledAttributes.getColor(1, f11839c);
            this.f11858r = obtainStyledAttributes.getColor(6, -1);
            this.f11859s = obtainStyledAttributes.getDimension(7, (float) m8020a(3.0f));
            this.f11860t = obtainStyledAttributes.getDimension(8, (float) m8020a(6.0f));
            this.f11862v = obtainStyledAttributes.getInteger(0, 1);
            this.f11863w = obtainStyledAttributes.getInteger(11, 0);
            this.f11861u = obtainStyledAttributes.getResourceId(4, -1);
            this.f11865y = obtainStyledAttributes.getInteger(5, m8020a(14.0f));
            this.f11866z = obtainStyledAttributes.getInteger(3, m8020a(10.0f));
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f11864x = (((float) this.f11863w) * 100.0f) / ((float) this.f11862v);
        this.f11849i = BitmapFactory.decodeResource(getResources(), this.f11861u);
        Paint paint = new Paint(1);
        this.f11850j = paint;
        paint.setFilterBitmap(true);
        this.f11850j.setDither(true);
        Paint paint2 = new Paint(1);
        this.f11851k = paint2;
        paint2.setPathEffect(new CornerPathEffect(this.f11854n));
        this.f11851k.setStrokeWidth(this.f11854n);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                RegisterProgressView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                RegisterProgressView registerProgressView = RegisterProgressView.this;
                float unused = registerProgressView.f11852l = ((float) registerProgressView.getHeight()) - RegisterProgressView.this.f11860t;
                Rect unused2 = RegisterProgressView.this.f11847C = new Rect(0, 0, RegisterProgressView.this.f11849i.getWidth(), RegisterProgressView.this.f11849i.getHeight());
                RectF unused3 = RegisterProgressView.this.f11848D = new RectF((float) (RegisterProgressView.this.getWidth() - RegisterProgressView.this.f11865y), RegisterProgressView.this.f11852l - (((float) RegisterProgressView.this.f11866z) / 2.0f), (float) RegisterProgressView.this.getWidth(), RegisterProgressView.this.f11852l + (((float) RegisterProgressView.this.f11866z) / 2.0f));
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11853m = ((float) getWidth()) - (this.f11849i == null ? this.f11860t : ((float) this.f11865y) / 2.0f);
        m8034f(canvas);
        m8033e(canvas);
        m8031d(canvas);
        m8029c(canvas);
        m8024a(canvas);
    }

    /* renamed from: a */
    private void m8024a(Canvas canvas) {
        Bitmap bitmap = this.f11849i;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f11847C, this.f11848D, this.f11850j);
        }
    }

    /* renamed from: b */
    private void m8026b(Canvas canvas) {
        if (this.f11864x >= 100.0f) {
            this.f11851k.setColor(this.f11857q);
            canvas.drawCircle(this.f11853m, this.f11852l, this.f11860t, this.f11851k);
        } else {
            this.f11851k.setColor(this.f11856p);
            canvas.drawCircle(this.f11853m, this.f11852l, this.f11860t, this.f11851k);
        }
        this.f11851k.setColor(this.f11858r);
        canvas.drawCircle(this.f11853m, this.f11852l, this.f11859s, this.f11851k);
    }

    /* renamed from: c */
    private void m8029c(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = this.f11862v;
            if (i < i2 - 1) {
                i++;
                float f = ((this.f11853m - this.f11860t) * ((float) i)) / ((float) i2);
                if (i <= this.f11863w) {
                    this.f11851k.setColor(this.f11857q);
                } else {
                    this.f11851k.setColor(this.f11856p);
                }
                canvas.drawCircle(f, this.f11852l, this.f11860t, this.f11851k);
                this.f11851k.setColor(this.f11858r);
                canvas.drawCircle(f, this.f11852l, this.f11859s, this.f11851k);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private void m8031d(Canvas canvas) {
        this.f11851k.setColor(this.f11857q);
        float f = this.f11860t;
        canvas.drawCircle(f, this.f11852l, f, this.f11851k);
        this.f11851k.setColor(this.f11858r);
        canvas.drawCircle(this.f11860t, this.f11852l, this.f11859s, this.f11851k);
    }

    /* renamed from: e */
    private void m8033e(Canvas canvas) {
        float f = ((this.f11853m - this.f11860t) * this.f11864x) / 100.0f;
        this.f11851k.setColor(this.f11857q);
        this.f11851k.setStrokeWidth(this.f11854n);
        float f2 = this.f11860t;
        float f3 = this.f11852l;
        canvas.drawLine(f2, f3, f, f3, this.f11851k);
    }

    /* renamed from: f */
    private void m8034f(Canvas canvas) {
        this.f11851k.setColor(this.f11856p);
        this.f11851k.setStrokeWidth(this.f11855o);
        float f = this.f11852l;
        canvas.drawLine(this.f11860t / 2.0f, f, this.f11853m, f, this.f11851k);
    }

    public void setEndBitmap(Bitmap bitmap) {
        this.f11849i = bitmap;
        invalidate();
    }

    public void setEndBitmap(int i) {
        setEndBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setProgressColor(int i) {
        this.f11857q = i;
        invalidate();
    }

    /* renamed from: a */
    private int m8020a(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: private */
    public void setProgress(float f) {
        this.f11864x = f;
        invalidate();
    }

    public void setStep(int i) {
        this.f11863w = i;
        setProgress((((float) i) * 100.0f) / ((float) this.f11862v));
    }

    public void setStepByAnimator(final int i) {
        if (this.f11846B != i) {
            this.f11846B = i;
            ValueAnimator valueAnimator = this.f11845A;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f11845A.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f11864x, (((float) i) * 100.0f) / ((float) this.f11862v)});
            this.f11845A = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RegisterProgressView.this.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.f11845A.setDuration(500);
            this.f11845A.start();
            if (i < this.f11863w) {
                setStep(i);
            } else {
                postDelayed(new Runnable() {
                    public void run() {
                        RegisterProgressView.this.setStep(i);
                    }
                }, 500);
            }
        }
    }
}
