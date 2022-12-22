package com.didi.soda.customer.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public class ShimmerLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f41563a = 1600;

    /* renamed from: b */
    private static final byte f41564b = 0;

    /* renamed from: c */
    private static final byte f41565c = -45;

    /* renamed from: d */
    private static final byte f41566d = 45;

    /* renamed from: e */
    private static final byte f41567e = 0;

    /* renamed from: f */
    private static final byte f41568f = 1;

    /* renamed from: g */
    private static final byte f41569g = 0;

    /* renamed from: h */
    private static final byte f41570h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f41571i;

    /* renamed from: j */
    private Rect f41572j;

    /* renamed from: k */
    private Paint f41573k;

    /* renamed from: l */
    private ValueAnimator f41574l;

    /* renamed from: m */
    private Bitmap f41575m;

    /* renamed from: n */
    private Bitmap f41576n;

    /* renamed from: o */
    private Canvas f41577o;

    /* renamed from: p */
    private boolean f41578p;

    /* renamed from: q */
    private boolean f41579q;

    /* renamed from: r */
    private boolean f41580r;

    /* renamed from: s */
    private int f41581s;

    /* renamed from: t */
    private int f41582t;

    /* renamed from: u */
    private int f41583u;

    /* renamed from: v */
    private float f41584v;

    /* renamed from: w */
    private float f41585w;

    /* renamed from: x */
    private ViewTreeObserver.OnPreDrawListener f41586x;

    public ShimmerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10448R.styleable.ShimmerLayout, 0, 0);
        try {
            this.f41583u = obtainStyledAttributes.getInteger(0, 0);
            this.f41581s = obtainStyledAttributes.getInteger(1, 1600);
            this.f41582t = obtainStyledAttributes.getColor(3, m29387a((int) R.color.shimmer_color));
            this.f41580r = obtainStyledAttributes.getBoolean(2, false);
            this.f41584v = obtainStyledAttributes.getFloat(5, 0.8f);
            this.f41585w = obtainStyledAttributes.getFloat(4, 0.1f);
            this.f41578p = obtainStyledAttributes.getBoolean(6, false);
            obtainStyledAttributes.recycle();
            setMaskWidth(this.f41584v);
            setGradientCenterColorWidth(this.f41585w);
            setShimmerAngle(this.f41583u);
            m29400g();
            if (this.f41580r && getVisibility() == 0) {
                startShimmerAnimation();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setAnimationReversed(boolean z) {
        this.f41578p = z;
        m29391a();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("mGradientCenterColorWidth value must be higher than %d and less than %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f41585w = f;
        m29391a();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("mMaskWidth value must be higher than %d and less or equal to %d", new Object[]{(byte) 0, (byte) 1}));
        }
        this.f41584v = f;
        m29391a();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("mShimmerAngle value must be between %d and %d", new Object[]{Byte.valueOf(f41565c), Byte.valueOf(f41566d)}));
        }
        this.f41583u = i;
        m29391a();
    }

    public void setShimmerAnimationDuration(int i) {
        this.f41581s = i;
        m29391a();
    }

    public void setShimmerColor(int i) {
        this.f41582t = i;
        m29391a();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            stopShimmerAnimation();
        } else if (this.f41580r) {
            startShimmerAnimation();
        }
    }

    public void startShimmerAnimation() {
        if (!this.f41579q) {
            if (getWidth() == 0) {
                this.f41586x = new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        ShimmerLayout.this.startShimmerAnimation();
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(this.f41586x);
                return;
            }
            getShimmerAnimation().start();
            this.f41579q = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.f41586x != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f41586x);
        }
        m29394b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m29394b();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f41579q || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            m29392a(canvas);
        }
    }

    /* renamed from: a */
    private void m29391a() {
        if (this.f41579q) {
            m29394b();
            startShimmerAnimation();
        }
    }

    /* renamed from: a */
    private void m29392a(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.f41575m = maskBitmap;
        if (maskBitmap != null) {
            if (this.f41577o == null) {
                this.f41577o = new Canvas(this.f41575m);
            }
            this.f41577o.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f41577o.save();
            this.f41577o.translate((float) (-this.f41571i), 0.0f);
            super.dispatchDraw(this.f41577o);
            this.f41577o.restore();
            m29395b(canvas);
            this.f41575m = null;
        }
    }

    /* renamed from: b */
    private void m29395b(Canvas canvas) {
        m29397d();
        canvas.save();
        canvas.translate((float) this.f41571i, 0.0f);
        canvas.drawRect((float) this.f41572j.left, 0.0f, (float) this.f41572j.width(), (float) this.f41572j.height(), this.f41573k);
        canvas.restore();
    }

    /* renamed from: b */
    private void m29394b() {
        ValueAnimator valueAnimator = this.f41574l;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f41574l.removeAllUpdateListeners();
        }
        this.f41574l = null;
        this.f41573k = null;
        this.f41579q = false;
        m29396c();
    }

    /* renamed from: c */
    private void m29396c() {
        this.f41577o = null;
        Bitmap bitmap = this.f41576n;
        if (bitmap != null) {
            bitmap.recycle();
            this.f41576n = null;
        }
    }

    private Bitmap getMaskBitmap() {
        if (this.f41576n == null) {
            this.f41576n = m29390a(this.f41572j.width(), getHeight());
        }
        return this.f41576n;
    }

    /* renamed from: d */
    private void m29397d() {
        if (this.f41573k == null) {
            int b = m29393b(this.f41582t);
            float width = ((float) (getWidth() / 2)) * this.f41584v;
            float height = this.f41583u >= 0 ? (float) getHeight() : 0.0f;
            int i = this.f41582t;
            ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, ((float) Math.cos(Math.toRadians((double) this.f41583u))) * width, height + (((float) Math.sin(Math.toRadians((double) this.f41583u))) * width), new int[]{b, i, i, b}, getGradientColorDistribution(), Shader.TileMode.CLAMP), new BitmapShader(this.f41575m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.f41573k = paint;
            paint.setAntiAlias(true);
            this.f41573k.setDither(true);
            this.f41573k.setFilterBitmap(true);
            this.f41573k.setShader(composeShader);
        }
    }

    private Animator getShimmerAnimation() {
        final int i;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f41574l;
        if (valueAnimator2 != null) {
            return valueAnimator2;
        }
        if (this.f41572j == null) {
            this.f41572j = m29398e();
        }
        int width = getWidth();
        if (getWidth() > this.f41572j.width()) {
            i = (-width) / 2;
        } else {
            i = (-this.f41572j.width()) / 2;
        }
        final int width2 = this.f41572j.width();
        int i2 = width - i;
        if (this.f41578p) {
            valueAnimator = ValueAnimator.ofInt(new int[]{i2, 0});
        } else {
            valueAnimator = ValueAnimator.ofInt(new int[]{0, i2});
        }
        this.f41574l = valueAnimator;
        valueAnimator.setDuration((long) this.f41581s);
        this.f41574l.setRepeatCount(-1);
        this.f41574l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = ShimmerLayout.this.f41571i = i + ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (ShimmerLayout.this.f41571i + width2 >= 0) {
                    ShimmerLayout.this.invalidate();
                }
            }
        });
        return this.f41574l;
    }

    /* renamed from: a */
    private Bitmap m29390a(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    /* renamed from: a */
    private int m29387a(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getContext().getColor(i);
        }
        return getResources().getColor(i);
    }

    /* renamed from: b */
    private int m29393b(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: e */
    private Rect m29398e() {
        return new Rect(0, 0, m29399f(), getHeight());
    }

    /* renamed from: f */
    private int m29399f() {
        return (int) ((((double) (((float) (getWidth() / 2)) * this.f41584v)) / Math.cos(Math.toRadians((double) Math.abs(this.f41583u)))) + (((double) getHeight()) * Math.tan(Math.toRadians((double) Math.abs(this.f41583u)))));
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 1.0f;
        float f = this.f41585w;
        fArr[1] = 0.5f - (f / 2.0f);
        fArr[2] = (f / 2.0f) + 0.5f;
        return fArr;
    }

    /* renamed from: g */
    private void m29400g() {
        if (Build.VERSION.SDK_INT <= 16) {
            setLayerType(1, (Paint) null);
        }
    }
}
