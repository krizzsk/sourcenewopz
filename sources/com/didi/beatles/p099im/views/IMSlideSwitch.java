package com.didi.beatles.p099im.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.view.MotionEventCompat;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.beatles.im.views.IMSlideSwitch */
public class IMSlideSwitch extends View {
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_RECT = 1;

    /* renamed from: a */
    private static final String f9939a = "IMSlideSwitch";

    /* renamed from: b */
    private static final long f9940b = 80;

    /* renamed from: c */
    private static final int f9941c = 3;

    /* renamed from: d */
    private static final int f9942d = Color.parseColor("#ffff7e33");

    /* renamed from: e */
    private int f9943e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f9944f;

    /* renamed from: g */
    private int f9945g;

    /* renamed from: h */
    private Paint f9946h;

    /* renamed from: i */
    private Rect f9947i;

    /* renamed from: j */
    private Rect f9948j;

    /* renamed from: k */
    private RectF f9949k;

    /* renamed from: l */
    private RectF f9950l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f9951m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f9952n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f9953o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f9954p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f9955q;

    /* renamed from: r */
    private int f9956r;

    /* renamed from: s */
    private int f9957s;

    /* renamed from: t */
    private int f9958t;

    /* renamed from: u */
    private boolean f9959u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public SlideListener f9960v;

    /* renamed from: com.didi.beatles.im.views.IMSlideSwitch$SlideListener */
    public interface SlideListener {
        void close(boolean z);

        void open(boolean z);
    }

    public IMSlideSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9943e = Color.parseColor("#ffff7e33");
        this.f9945g = 2;
        this.f9955q = 3;
        this.f9958t = 0;
        this.f9959u = true;
        this.f9960v = null;
        Paint paint = new Paint();
        this.f9946h = paint;
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.IMSlideSwitch);
        this.f9943e = obtainStyledAttributes.getColor(2, f9942d);
        this.f9944f = obtainStyledAttributes.getBoolean(0, false);
        this.f9945g = obtainStyledAttributes.getInt(1, 2);
        obtainStyledAttributes.recycle();
    }

    public IMSlideSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMSlideSwitch(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i4 = 0;
        if (layoutParams != null) {
            i4 = layoutParams.width;
            i3 = layoutParams.height;
        } else {
            i3 = 0;
        }
        int a = m6703a(i4, i);
        int a2 = m6703a(i3, i2);
        if (a2 > a) {
            a = a2 * 2;
        }
        setMeasuredDimension(a, a2);
        initDrawingVal();
    }

    public void initDrawingVal() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f9950l = new RectF();
        this.f9949k = new RectF();
        this.f9948j = new Rect();
        this.f9947i = new Rect(0, 0, measuredWidth, measuredHeight);
        this.f9953o = 3;
        if (this.f9945g == 1) {
            this.f9952n = measuredWidth / 2;
        } else {
            this.f9952n = (measuredWidth - (measuredHeight - 6)) - 3;
        }
        if (this.f9944f) {
            this.f9954p = this.f9952n;
            this.f9951m = 255;
        } else {
            this.f9954p = 3;
            this.f9951m = 0;
        }
        this.f9955q = this.f9954p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r3 > 0) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r3 > 0) goto L_0x001b;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m6703a(int r3, int r4) {
        /*
            r2 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x0017
            if (r0 == 0) goto L_0x0014
            r3 = 1073741824(0x40000000, float:2.0)
            if (r0 == r3) goto L_0x001c
            r4 = 0
            goto L_0x001c
        L_0x0014:
            if (r3 <= 0) goto L_0x001a
            goto L_0x001b
        L_0x0017:
            if (r3 <= 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r4
        L_0x001b:
            r4 = r3
        L_0x001c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.IMSlideSwitch.m6703a(int, int):int");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f9945g == 1) {
            this.f9946h.setColor(-7829368);
            canvas.drawRect(this.f9947i, this.f9946h);
            this.f9946h.setColor(this.f9943e);
            this.f9946h.setAlpha(this.f9951m);
            canvas.drawRect(this.f9947i, this.f9946h);
            Rect rect = this.f9948j;
            int i = this.f9954p;
            rect.set(i, 3, ((getMeasuredWidth() / 2) + i) - 3, getMeasuredHeight() - 3);
            this.f9946h.setColor(-1);
            canvas.drawRect(this.f9948j, this.f9946h);
            return;
        }
        this.f9946h.setColor(-7829368);
        this.f9950l.set(this.f9947i);
        float height = (float) (this.f9947i.height() / 2);
        canvas.drawRoundRect(this.f9950l, height, height, this.f9946h);
        this.f9946h.setColor(this.f9943e);
        this.f9946h.setAlpha(this.f9951m);
        canvas.drawRoundRect(this.f9950l, height, height, this.f9946h);
        Rect rect2 = this.f9948j;
        int i2 = this.f9954p;
        rect2.set(i2, 3, (this.f9947i.height() + i2) - 6, this.f9947i.height() - 3);
        this.f9949k.set(this.f9948j);
        this.f9946h.setColor(-1);
        canvas.drawRoundRect(this.f9949k, height, height, this.f9946h);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.f9959u) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f9956r = (int) motionEvent.getRawX();
        } else if (actionMasked == 1) {
            int rawX = (int) (motionEvent.getRawX() - ((float) this.f9956r));
            int i2 = this.f9954p;
            this.f9955q = i2;
            boolean z = i2 > this.f9952n / 2;
            if (Math.abs(rawX) < 3) {
                z = !z;
            }
            moveToDest(z);
        } else if (actionMasked == 2) {
            int rawX2 = (int) motionEvent.getRawX();
            this.f9957s = rawX2;
            int i3 = rawX2 - this.f9956r;
            this.f9958t = i3;
            int i4 = i3 + this.f9955q;
            int i5 = this.f9952n;
            if (i4 > i5) {
                i4 = i5;
            }
            int i6 = this.f9953o;
            if (i4 < i6) {
                i4 = i6;
            }
            if (i4 >= this.f9953o && i4 <= (i = this.f9952n)) {
                this.f9954p = i4;
                this.f9951m = (int) ((((float) i4) * 255.0f) / ((float) i));
                m6706a();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6706a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    public void setSlideListener(SlideListener slideListener) {
        this.f9960v = slideListener;
    }

    public void moveToDest(final boolean z) {
        int[] iArr = new int[2];
        iArr[0] = this.f9954p;
        iArr[1] = z ? this.f9952n : this.f9953o;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.setDuration(f9940b);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = IMSlideSwitch.this.f9954p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                IMSlideSwitch iMSlideSwitch = IMSlideSwitch.this;
                int unused2 = iMSlideSwitch.f9951m = (int) ((((float) iMSlideSwitch.f9954p) * 255.0f) / ((float) IMSlideSwitch.this.f9952n));
                IMSlideSwitch.this.m6706a();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    boolean unused = IMSlideSwitch.this.f9944f = true;
                    if (IMSlideSwitch.this.f9960v != null) {
                        IMSlideSwitch.this.f9960v.open(true);
                    }
                    IMSlideSwitch iMSlideSwitch = IMSlideSwitch.this;
                    int unused2 = iMSlideSwitch.f9955q = iMSlideSwitch.f9952n;
                    return;
                }
                boolean unused3 = IMSlideSwitch.this.f9944f = false;
                if (IMSlideSwitch.this.f9960v != null) {
                    IMSlideSwitch.this.f9960v.close(true);
                }
                IMSlideSwitch iMSlideSwitch2 = IMSlideSwitch.this;
                int unused4 = iMSlideSwitch2.f9955q = iMSlideSwitch2.f9953o;
            }
        });
    }

    public void setState(boolean z) {
        this.f9944f = z;
        initDrawingVal();
        m6706a();
        SlideListener slideListener = this.f9960v;
        if (slideListener == null) {
            return;
        }
        if (z) {
            slideListener.open(false);
        } else {
            slideListener.close(false);
        }
    }

    public void setShapeType(int i) {
        this.f9945g = i;
    }

    public void setSlideable(boolean z) {
        this.f9959u = z;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f9944f = bundle.getBoolean("isOpen");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
        SystemUtils.log(3, f9939a, "onRestoreInstanceState: ", (Throwable) null, "com.didi.beatles.im.views.IMSlideSwitch", 300);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putBoolean("isOpen", this.f9944f);
        SystemUtils.log(3, f9939a, "onRestoreInstanceState: ", (Throwable) null, "com.didi.beatles.im.views.IMSlideSwitch", 308);
        return bundle;
    }
}
