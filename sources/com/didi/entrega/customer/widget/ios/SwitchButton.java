package com.didi.entrega.customer.widget.ios;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a */
    private static final int f20490a = DisplayUtils.dip2px(GlobalContext.getContext(), 58.0f);

    /* renamed from: b */
    private static final int f20491b = DisplayUtils.dip2px(GlobalContext.getContext(), 36.0f);

    /* renamed from: c */
    private static final int f20492c = 0;

    /* renamed from: d */
    private static final int f20493d = 1;

    /* renamed from: e */
    private static final int f20494e = 2;

    /* renamed from: f */
    private static final int f20495f = 3;

    /* renamed from: g */
    private static final int f20496g = 4;

    /* renamed from: h */
    private static final int f20497h = 5;

    /* renamed from: A */
    private RectF f20498A = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f20499B = 0;

    /* renamed from: C */
    private ValueAnimator f20500C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f20501D;

    /* renamed from: E */
    private boolean f20502E;

    /* renamed from: F */
    private boolean f20503F = false;

    /* renamed from: G */
    private boolean f20504G = false;

    /* renamed from: H */
    private boolean f20505H = false;

    /* renamed from: I */
    private boolean f20506I = false;

    /* renamed from: J */
    private OnCheckedChangeListener f20507J;

    /* renamed from: K */
    private long f20508K;

    /* renamed from: L */
    private Runnable f20509L = new Runnable() {
        public void run() {
            if (!SwitchButton.this.m15010b()) {
                SwitchButton.this.m15017e();
            }
        }
    };

    /* renamed from: M */
    private ValueAnimator.AnimatorUpdateListener f20510M = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c = SwitchButton.this.f20499B;
            if (c == 1 || c == 3 || c == 4) {
                if (SwitchButton.this.f20499B != 1) {
                    SwitchButton.this.f20527x.buttonX = SwitchButton.this.f20528y.buttonX + ((SwitchButton.this.f20529z.buttonX - SwitchButton.this.f20528y.buttonX) * floatValue);
                }
                SwitchButton.this.f20527x.checkStateColor = ((Integer) SwitchButton.this.f20512i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.f20528y.checkStateColor), Integer.valueOf(SwitchButton.this.f20529z.checkStateColor))).intValue();
            } else if (c == 5) {
                SwitchButton.this.f20527x.buttonX = SwitchButton.this.f20528y.buttonX + ((SwitchButton.this.f20529z.buttonX - SwitchButton.this.f20528y.buttonX) * floatValue);
                float h = (SwitchButton.this.f20527x.buttonX - SwitchButton.this.f20523t) / (SwitchButton.this.f20524u - SwitchButton.this.f20523t);
                SwitchButton.this.f20527x.checkStateColor = ((Integer) SwitchButton.this.f20512i.evaluate(h, Integer.valueOf(SwitchButton.this.f20518o), Integer.valueOf(SwitchButton.this.f20519p))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };

    /* renamed from: N */
    private Animator.AnimatorListener f20511N = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int c = SwitchButton.this.f20499B;
            if (c == 1) {
                int unused = SwitchButton.this.f20499B = 2;
                SwitchButton.this.postInvalidate();
            } else if (c == 3) {
                int unused2 = SwitchButton.this.f20499B = 0;
                SwitchButton.this.postInvalidate();
            } else if (c == 4) {
                int unused3 = SwitchButton.this.f20499B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m15000a();
            } else if (c == 5) {
                SwitchButton switchButton = SwitchButton.this;
                boolean unused4 = switchButton.f20501D = true ^ switchButton.f20501D;
                int unused5 = SwitchButton.this.f20499B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m15000a();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ArgbEvaluator f20512i = new ArgbEvaluator();

    /* renamed from: j */
    private float f20513j;

    /* renamed from: k */
    private float f20514k;

    /* renamed from: l */
    private float f20515l;

    /* renamed from: m */
    private float f20516m;

    /* renamed from: n */
    private float f20517n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f20518o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f20519p;

    /* renamed from: q */
    private int f20520q;

    /* renamed from: r */
    private int f20521r;

    /* renamed from: s */
    private int f20522s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f20523t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f20524u;

    /* renamed from: v */
    private Paint f20525v;

    /* renamed from: w */
    private Paint f20526w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewState f20527x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ViewState f20528y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ViewState f20529z;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        m15001a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15001a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15001a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m15001a(context, attributeSet);
    }

    /* renamed from: a */
    private static int m14998a(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    private static int m15008b(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: c */
    private static int m15011c(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    private static boolean m15005a(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setChecked(boolean z) {
        this.f20501D = z;
        if (z) {
            setCheckedViewState(this.f20527x);
        } else {
            setUncheckViewState(this.f20527x);
        }
        postInvalidate();
    }

    public boolean isChecked() {
        return this.f20501D;
    }

    public void setIsAutoToggle(boolean z) {
        this.f20506I = z;
    }

    public void setEnableEffect(boolean z) {
        this.f20502E = z;
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        m15004a(z, true);
    }

    public boolean performClick() {
        if (this.f20506I) {
            toggle();
        }
        return super.performClick();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f20507J = onCheckedChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        if (!this.f20506I) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f20503F = true;
            this.f20508K = System.currentTimeMillis();
            removeCallbacks(this.f20509L);
            postDelayed(this.f20509L, 100);
        } else if (actionMasked == 1) {
            this.f20503F = false;
            removeCallbacks(this.f20509L);
            if (System.currentTimeMillis() - this.f20508K <= 300) {
                performClick();
            } else if (m15015d()) {
                if (Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f) {
                    z = true;
                }
                if (z == isChecked()) {
                    m15019f();
                } else {
                    this.f20501D = z;
                    m15021g();
                }
            } else if (m15013c()) {
                m15019f();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m15013c()) {
                float max = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState = this.f20527x;
                float f = this.f20523t;
                viewState.buttonX = f + ((this.f20524u - f) * max);
            } else if (m15015d()) {
                float max2 = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState2 = this.f20527x;
                float f2 = this.f20523t;
                viewState2.buttonX = f2 + ((this.f20524u - f2) * max2);
                this.f20527x.checkStateColor = ((Integer) this.f20512i.evaluate(max2, Integer.valueOf(this.f20518o), Integer.valueOf(this.f20519p))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f20503F = false;
            removeCallbacks(this.f20509L);
            if (m15013c() || m15015d()) {
                m15019f();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f20490a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f20491b, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.f20515l = f;
        float f2 = (float) i;
        this.f20516m = f2;
        float f3 = f * 0.5f;
        this.f20513j = f3;
        this.f20514k = f3 - ((float) this.f20520q);
        this.f20517n = f * 0.5f;
        this.f20523t = f3;
        this.f20524u = f2 - f3;
        if (isChecked()) {
            setCheckedViewState(this.f20527x);
        } else {
            setUncheckViewState(this.f20527x);
        }
        this.f20504G = true;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f20526w.setColor(this.f20527x.checkStateColor);
        this.f20526w.setStyle(Paint.Style.FILL);
        m15003a(canvas, 0.0f, 0.0f, this.f20516m, this.f20515l, this.f20513j, this.f20526w);
        m15002a(canvas, this.f20527x.buttonX, this.f20517n);
    }

    /* renamed from: a */
    private void m15001a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaSwitchButton) : null;
        this.f20518o = m15011c(obtainStyledAttributes, 8, ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        this.f20519p = m15011c(obtainStyledAttributes, 4, ResourceHelper.getColor(R.color.rf_color_brands_1_100));
        this.f20520q = m15008b(obtainStyledAttributes, 0, DisplayUtils.dip2px(getContext(), 2.0f));
        int c = m15011c(obtainStyledAttributes, 1, -1);
        this.f20521r = m15011c(obtainStyledAttributes, 7, c);
        this.f20522s = m15011c(obtainStyledAttributes, 3, c);
        int a = m14998a(obtainStyledAttributes, 5, 200);
        this.f20501D = m15005a(obtainStyledAttributes, 2, false);
        this.f20502E = m15005a(obtainStyledAttributes, 6, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.f20526w = new Paint(1);
        Paint paint = new Paint(1);
        this.f20525v = paint;
        paint.setColor(c);
        this.f20527x = new ViewState();
        this.f20528y = new ViewState();
        this.f20529z = new ViewState();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f20500C = ofFloat;
        ofFloat.setDuration((long) a);
        this.f20500C.setRepeatCount(0);
        this.f20500C.addUpdateListener(this.f20510M);
        this.f20500C.addListener(this.f20511N);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m15003a(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
            return;
        }
        this.f20498A.set(f, f2, f3, f4);
        canvas.drawRoundRect(this.f20498A, f5, f5, paint);
    }

    /* renamed from: a */
    private void m15002a(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f20514k, this.f20525v);
    }

    private void setUncheckViewState(ViewState viewState) {
        viewState.checkStateColor = this.f20518o;
        viewState.buttonX = this.f20523t;
        this.f20525v.setColor(this.f20521r);
    }

    private void setCheckedViewState(ViewState viewState) {
        viewState.checkStateColor = this.f20519p;
        viewState.buttonX = this.f20524u;
        this.f20525v.setColor(this.f20522s);
    }

    /* renamed from: a */
    private void m15004a(boolean z, boolean z2) {
        if (isEnabled() && isClickable()) {
            if (this.f20505H) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.f20504G) {
                this.f20501D = !this.f20501D;
                if (z2) {
                    m15000a();
                }
            } else {
                if (this.f20500C.isRunning()) {
                    this.f20500C.cancel();
                }
                if (!this.f20502E || !z) {
                    this.f20501D = !this.f20501D;
                    if (isChecked()) {
                        setCheckedViewState(this.f20527x);
                    } else {
                        setUncheckViewState(this.f20527x);
                    }
                    postInvalidate();
                    if (z2) {
                        m15000a();
                        return;
                    }
                    return;
                }
                this.f20499B = 5;
                this.f20528y.copy(this.f20527x);
                if (isChecked()) {
                    setUncheckViewState(this.f20529z);
                } else {
                    setCheckedViewState(this.f20529z);
                }
                this.f20500C.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15000a() {
        OnCheckedChangeListener onCheckedChangeListener = this.f20507J;
        if (onCheckedChangeListener != null) {
            this.f20505H = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.f20505H = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m15010b() {
        return this.f20499B != 0;
    }

    /* renamed from: c */
    private boolean m15013c() {
        int i = this.f20499B;
        return i == 1 || i == 3;
    }

    /* renamed from: d */
    private boolean m15015d() {
        return this.f20499B == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15017e() {
        if (!m15010b() && this.f20503F) {
            if (this.f20500C.isRunning()) {
                this.f20500C.cancel();
            }
            this.f20499B = 1;
            this.f20528y.copy(this.f20527x);
            this.f20529z.copy(this.f20527x);
            if (isChecked()) {
                this.f20529z.checkStateColor = this.f20519p;
                this.f20529z.buttonX = this.f20524u;
            } else {
                this.f20529z.checkStateColor = this.f20518o;
                this.f20529z.buttonX = this.f20523t;
            }
            this.f20500C.start();
        }
    }

    /* renamed from: f */
    private void m15019f() {
        if (m15015d() || m15013c()) {
            if (this.f20500C.isRunning()) {
                this.f20500C.cancel();
            }
            this.f20499B = 3;
            this.f20528y.copy(this.f20527x);
            if (isChecked()) {
                setCheckedViewState(this.f20529z);
            } else {
                setUncheckViewState(this.f20529z);
            }
            this.f20500C.start();
        }
    }

    /* renamed from: g */
    private void m15021g() {
        if (this.f20500C.isRunning()) {
            this.f20500C.cancel();
        }
        this.f20499B = 4;
        this.f20528y.copy(this.f20527x);
        if (isChecked()) {
            setCheckedViewState(this.f20529z);
        } else {
            setUncheckViewState(this.f20529z);
        }
        this.f20500C.start();
    }

    private static class ViewState {
        float buttonX;
        int checkStateColor;

        ViewState() {
        }

        /* access modifiers changed from: private */
        public void copy(ViewState viewState) {
            this.buttonX = viewState.buttonX;
            this.checkStateColor = viewState.checkStateColor;
        }
    }
}
