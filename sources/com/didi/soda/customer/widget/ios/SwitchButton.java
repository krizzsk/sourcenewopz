package com.didi.soda.customer.widget.ios;

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
import com.didi.passenger.C10448R;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class SwitchButton extends View implements Checkable {

    /* renamed from: a */
    private static final int f42026a = DisplayUtils.dip2px(GlobalContext.getContext(), 58.0f);

    /* renamed from: b */
    private static final int f42027b = DisplayUtils.dip2px(GlobalContext.getContext(), 36.0f);

    /* renamed from: c */
    private static final int f42028c = 0;

    /* renamed from: d */
    private static final int f42029d = 1;

    /* renamed from: e */
    private static final int f42030e = 2;

    /* renamed from: f */
    private static final int f42031f = 3;

    /* renamed from: g */
    private static final int f42032g = 4;

    /* renamed from: h */
    private static final int f42033h = 5;

    /* renamed from: A */
    private RectF f42034A = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f42035B = 0;

    /* renamed from: C */
    private ValueAnimator f42036C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f42037D;

    /* renamed from: E */
    private boolean f42038E;

    /* renamed from: F */
    private boolean f42039F = false;

    /* renamed from: G */
    private boolean f42040G = false;

    /* renamed from: H */
    private boolean f42041H = false;

    /* renamed from: I */
    private boolean f42042I = false;

    /* renamed from: J */
    private OnCheckedChangeListener f42043J;

    /* renamed from: K */
    private long f42044K;

    /* renamed from: L */
    private Runnable f42045L = new Runnable() {
        public void run() {
            if (!SwitchButton.this.m29656b()) {
                SwitchButton.this.m29663e();
            }
        }
    };

    /* renamed from: M */
    private ValueAnimator.AnimatorUpdateListener f42046M = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int c = SwitchButton.this.f42035B;
            if (c == 1 || c == 3 || c == 4) {
                if (SwitchButton.this.f42035B != 1) {
                    SwitchButton.this.f42063x.buttonX = SwitchButton.this.f42064y.buttonX + ((SwitchButton.this.f42065z.buttonX - SwitchButton.this.f42064y.buttonX) * floatValue);
                }
                SwitchButton.this.f42063x.checkStateColor = ((Integer) SwitchButton.this.f42048i.evaluate(floatValue, Integer.valueOf(SwitchButton.this.f42064y.checkStateColor), Integer.valueOf(SwitchButton.this.f42065z.checkStateColor))).intValue();
            } else if (c == 5) {
                SwitchButton.this.f42063x.buttonX = SwitchButton.this.f42064y.buttonX + ((SwitchButton.this.f42065z.buttonX - SwitchButton.this.f42064y.buttonX) * floatValue);
                float h = (SwitchButton.this.f42063x.buttonX - SwitchButton.this.f42059t) / (SwitchButton.this.f42060u - SwitchButton.this.f42059t);
                SwitchButton.this.f42063x.checkStateColor = ((Integer) SwitchButton.this.f42048i.evaluate(h, Integer.valueOf(SwitchButton.this.f42054o), Integer.valueOf(SwitchButton.this.f42055p))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    };

    /* renamed from: N */
    private Animator.AnimatorListener f42047N = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int c = SwitchButton.this.f42035B;
            if (c == 1) {
                int unused = SwitchButton.this.f42035B = 2;
                SwitchButton.this.postInvalidate();
            } else if (c == 3) {
                int unused2 = SwitchButton.this.f42035B = 0;
                SwitchButton.this.postInvalidate();
            } else if (c == 4) {
                int unused3 = SwitchButton.this.f42035B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m29646a();
            } else if (c == 5) {
                SwitchButton switchButton = SwitchButton.this;
                boolean unused4 = switchButton.f42037D = true ^ switchButton.f42037D;
                int unused5 = SwitchButton.this.f42035B = 0;
                SwitchButton.this.postInvalidate();
                SwitchButton.this.m29646a();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ArgbEvaluator f42048i = new ArgbEvaluator();

    /* renamed from: j */
    private float f42049j;

    /* renamed from: k */
    private float f42050k;

    /* renamed from: l */
    private float f42051l;

    /* renamed from: m */
    private float f42052m;

    /* renamed from: n */
    private float f42053n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f42054o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f42055p;

    /* renamed from: q */
    private int f42056q;

    /* renamed from: r */
    private int f42057r;

    /* renamed from: s */
    private int f42058s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f42059t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f42060u;

    /* renamed from: v */
    private Paint f42061v;

    /* renamed from: w */
    private Paint f42062w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ViewState f42063x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ViewState f42064y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ViewState f42065z;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        m29647a(context, (AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29647a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29647a(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m29647a(context, attributeSet);
    }

    /* renamed from: a */
    private static int m29644a(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    private static int m29654b(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: c */
    private static int m29657c(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    private static boolean m29651a(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setChecked(boolean z) {
        this.f42037D = z;
        if (z) {
            setCheckedViewState(this.f42063x);
        } else {
            setUncheckViewState(this.f42063x);
        }
        postInvalidate();
    }

    public boolean isChecked() {
        return this.f42037D;
    }

    public void setIsAutoToggle(boolean z) {
        this.f42042I = z;
    }

    public void setEnableEffect(boolean z) {
        this.f42038E = z;
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        m29650a(z, true);
    }

    public boolean performClick() {
        if (this.f42042I) {
            toggle();
        }
        return super.performClick();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f42043J = onCheckedChangeListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled() || !isClickable()) {
            return false;
        }
        if (!this.f42042I) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f42039F = true;
            this.f42044K = System.currentTimeMillis();
            removeCallbacks(this.f42045L);
            postDelayed(this.f42045L, 100);
        } else if (actionMasked == 1) {
            this.f42039F = false;
            removeCallbacks(this.f42045L);
            if (System.currentTimeMillis() - this.f42044K <= 300) {
                performClick();
            } else if (m29661d()) {
                if (Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f) {
                    z = true;
                }
                if (z == isChecked()) {
                    m29665f();
                } else {
                    this.f42037D = z;
                    m29667g();
                }
            } else if (m29659c()) {
                m29665f();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (m29659c()) {
                float max = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState = this.f42063x;
                float f = this.f42059t;
                viewState.buttonX = f + ((this.f42060u - f) * max);
            } else if (m29661d()) {
                float max2 = Math.max(0.0f, Math.min(1.0f, x / ((float) getWidth())));
                ViewState viewState2 = this.f42063x;
                float f2 = this.f42059t;
                viewState2.buttonX = f2 + ((this.f42060u - f2) * max2);
                this.f42063x.checkStateColor = ((Integer) this.f42048i.evaluate(max2, Integer.valueOf(this.f42054o), Integer.valueOf(this.f42055p))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f42039F = false;
            removeCallbacks(this.f42045L);
            if (m29659c() || m29661d()) {
                m29665f();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(f42026a, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f42027b, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) i2;
        this.f42051l = f;
        float f2 = (float) i;
        this.f42052m = f2;
        float f3 = f * 0.5f;
        this.f42049j = f3;
        this.f42050k = f3 - ((float) this.f42056q);
        this.f42053n = f * 0.5f;
        this.f42059t = f3;
        this.f42060u = f2 - f3;
        if (isChecked()) {
            setCheckedViewState(this.f42063x);
        } else {
            setUncheckViewState(this.f42063x);
        }
        this.f42040G = true;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f42062w.setColor(this.f42063x.checkStateColor);
        this.f42062w.setStyle(Paint.Style.FILL);
        m29649a(canvas, 0.0f, 0.0f, this.f42052m, this.f42051l, this.f42049j, this.f42062w);
        m29648a(canvas, this.f42063x.buttonX, this.f42053n);
    }

    /* renamed from: a */
    private void m29647a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, C10448R.styleable.SwitchButton) : null;
        this.f42054o = m29657c(obtainStyledAttributes, 8, ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
        this.f42055p = m29657c(obtainStyledAttributes, 4, ResourceHelper.getColor(R.color.rf_color_brands_1_100));
        this.f42056q = m29654b(obtainStyledAttributes, 0, DisplayUtils.dip2px(getContext(), 2.0f));
        int c = m29657c(obtainStyledAttributes, 1, -1);
        this.f42057r = m29657c(obtainStyledAttributes, 7, c);
        this.f42058s = m29657c(obtainStyledAttributes, 3, c);
        int a = m29644a(obtainStyledAttributes, 5, 200);
        this.f42037D = m29651a(obtainStyledAttributes, 2, false);
        this.f42038E = m29651a(obtainStyledAttributes, 6, true);
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        this.f42062w = new Paint(1);
        Paint paint = new Paint(1);
        this.f42061v = paint;
        paint.setColor(c);
        this.f42063x = new ViewState();
        this.f42064y = new ViewState();
        this.f42065z = new ViewState();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f42036C = ofFloat;
        ofFloat.setDuration((long) a);
        this.f42036C.setRepeatCount(0);
        this.f42036C.addUpdateListener(this.f42046M);
        this.f42036C.addListener(this.f42047N);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* renamed from: a */
    private void m29649a(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
            return;
        }
        this.f42034A.set(f, f2, f3, f4);
        canvas.drawRoundRect(this.f42034A, f5, f5, paint);
    }

    /* renamed from: a */
    private void m29648a(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.f42050k, this.f42061v);
    }

    private void setUncheckViewState(ViewState viewState) {
        viewState.checkStateColor = this.f42054o;
        viewState.buttonX = this.f42059t;
        this.f42061v.setColor(this.f42057r);
    }

    private void setCheckedViewState(ViewState viewState) {
        viewState.checkStateColor = this.f42055p;
        viewState.buttonX = this.f42060u;
        this.f42061v.setColor(this.f42058s);
    }

    /* renamed from: a */
    private void m29650a(boolean z, boolean z2) {
        if (isEnabled() && isClickable()) {
            if (this.f42041H) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            } else if (!this.f42040G) {
                this.f42037D = !this.f42037D;
                if (z2) {
                    m29646a();
                }
            } else {
                if (this.f42036C.isRunning()) {
                    this.f42036C.cancel();
                }
                if (!this.f42038E || !z) {
                    this.f42037D = !this.f42037D;
                    if (isChecked()) {
                        setCheckedViewState(this.f42063x);
                    } else {
                        setUncheckViewState(this.f42063x);
                    }
                    postInvalidate();
                    if (z2) {
                        m29646a();
                        return;
                    }
                    return;
                }
                this.f42035B = 5;
                this.f42064y.copy(this.f42063x);
                if (isChecked()) {
                    setUncheckViewState(this.f42065z);
                } else {
                    setCheckedViewState(this.f42065z);
                }
                this.f42036C.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29646a() {
        OnCheckedChangeListener onCheckedChangeListener = this.f42043J;
        if (onCheckedChangeListener != null) {
            this.f42041H = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.f42041H = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m29656b() {
        return this.f42035B != 0;
    }

    /* renamed from: c */
    private boolean m29659c() {
        int i = this.f42035B;
        return i == 1 || i == 3;
    }

    /* renamed from: d */
    private boolean m29661d() {
        return this.f42035B == 2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29663e() {
        if (!m29656b() && this.f42039F) {
            if (this.f42036C.isRunning()) {
                this.f42036C.cancel();
            }
            this.f42035B = 1;
            this.f42064y.copy(this.f42063x);
            this.f42065z.copy(this.f42063x);
            if (isChecked()) {
                this.f42065z.checkStateColor = this.f42055p;
                this.f42065z.buttonX = this.f42060u;
            } else {
                this.f42065z.checkStateColor = this.f42054o;
                this.f42065z.buttonX = this.f42059t;
            }
            this.f42036C.start();
        }
    }

    /* renamed from: f */
    private void m29665f() {
        if (m29661d() || m29659c()) {
            if (this.f42036C.isRunning()) {
                this.f42036C.cancel();
            }
            this.f42035B = 3;
            this.f42064y.copy(this.f42063x);
            if (isChecked()) {
                setCheckedViewState(this.f42065z);
            } else {
                setUncheckViewState(this.f42065z);
            }
            this.f42036C.start();
        }
    }

    /* renamed from: g */
    private void m29667g() {
        if (this.f42036C.isRunning()) {
            this.f42036C.cancel();
        }
        this.f42035B = 4;
        this.f42064y.copy(this.f42063x);
        if (isChecked()) {
            setCheckedViewState(this.f42065z);
        } else {
            setUncheckViewState(this.f42065z);
        }
        this.f42036C.start();
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
