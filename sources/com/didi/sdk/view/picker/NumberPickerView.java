package com.didi.sdk.view.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.widget.ScrollerCompat;
import com.didi.passenger.C10448R;

public class NumberPickerView extends View {

    /* renamed from: A */
    private static final boolean f38002A = false;

    /* renamed from: B */
    private static final boolean f38003B = true;

    /* renamed from: a */
    private static final int f38004a = -13421773;

    /* renamed from: b */
    private static final int f38005b = -695533;

    /* renamed from: c */
    private static final int f38006c = 14;

    /* renamed from: d */
    private static final int f38007d = 16;

    /* renamed from: e */
    private static final int f38008e = 14;

    /* renamed from: f */
    private static final int f38009f = 8;

    /* renamed from: g */
    private static final int f38010g = 8;

    /* renamed from: h */
    private static final int f38011h = -695533;

    /* renamed from: i */
    private static final int f38012i = 2;

    /* renamed from: j */
    private static final int f38013j = 0;

    /* renamed from: k */
    private static final int f38014k = 3;

    /* renamed from: l */
    private static final int f38015l = 5;

    /* renamed from: m */
    private static final int f38016m = 2;

    /* renamed from: n */
    private static final int f38017n = 1;

    /* renamed from: o */
    private static final int f38018o = 2;

    /* renamed from: p */
    private static final int f38019p = 3;

    /* renamed from: q */
    private static final int f38020q = 32;

    /* renamed from: r */
    private static final int f38021r = 300;

    /* renamed from: s */
    private static final int f38022s = 300;

    /* renamed from: t */
    private static final int f38023t = 600;

    /* renamed from: u */
    private static final String f38024u = "start";

    /* renamed from: v */
    private static final String f38025v = "middle";

    /* renamed from: w */
    private static final String f38026w = "end";

    /* renamed from: x */
    private static final boolean f38027x = true;

    /* renamed from: y */
    private static final boolean f38028y = true;

    /* renamed from: z */
    private static final boolean f38029z = false;

    /* renamed from: C */
    private int f38030C = f38004a;

    /* renamed from: D */
    private int f38031D = -695533;

    /* renamed from: E */
    private int f38032E = -695533;

    /* renamed from: F */
    private int f38033F = 0;

    /* renamed from: G */
    private int f38034G = 0;

    /* renamed from: H */
    private int f38035H = 0;

    /* renamed from: I */
    private int f38036I = 0;

    /* renamed from: J */
    private int f38037J = 0;

    /* renamed from: K */
    private int f38038K = 0;

    /* renamed from: L */
    private int f38039L = 0;

    /* renamed from: M */
    private int f38040M = 0;

    /* renamed from: N */
    private int f38041N = 0;

    /* renamed from: O */
    private int f38042O = -695533;

    /* renamed from: P */
    private int f38043P = 2;

    /* renamed from: Q */
    private int f38044Q = 0;

    /* renamed from: R */
    private int f38045R = 0;

    /* renamed from: S */
    private int f38046S = 3;

    /* renamed from: T */
    private int f38047T = 0;

    /* renamed from: U */
    private int f38048U = 0;

    /* renamed from: V */
    private int f38049V = -1;

    /* renamed from: W */
    private int f38050W = -1;

    /* renamed from: X */
    private int f38051X = 0;

    /* renamed from: Y */
    private int f38052Y = 0;

    /* renamed from: Z */
    private int f38053Z = 0;

    /* renamed from: aA */
    private Paint f38054aA = new Paint();

    /* renamed from: aB */
    private TextPaint f38055aB = new TextPaint();

    /* renamed from: aC */
    private Paint f38056aC = new Paint();

    /* renamed from: aD */
    private String[] f38057aD;

    /* renamed from: aE */
    private CharSequence[] f38058aE;

    /* renamed from: aF */
    private CharSequence[] f38059aF;

    /* renamed from: aG */
    private HandlerThread f38060aG;
    /* access modifiers changed from: private */

    /* renamed from: aH */
    public Handler f38061aH;
    /* access modifiers changed from: private */

    /* renamed from: aI */
    public Handler f38062aI;

    /* renamed from: aJ */
    private OnValueChangeListenerRelativeToRaw f38063aJ;

    /* renamed from: aK */
    private OnValueChangeListener f38064aK;

    /* renamed from: aL */
    private OnScrollListener f38065aL;

    /* renamed from: aM */
    private OnValueChangeListenerInScrolling f38066aM;
    /* access modifiers changed from: private */

    /* renamed from: aN */
    public int f38067aN = 0;

    /* renamed from: aO */
    private int f38068aO;

    /* renamed from: aP */
    private int f38069aP;

    /* renamed from: aQ */
    private int f38070aQ;

    /* renamed from: aR */
    private int f38071aR;

    /* renamed from: aS */
    private float f38072aS = 0.0f;

    /* renamed from: aT */
    private float f38073aT = 0.0f;

    /* renamed from: aU */
    private float f38074aU = 0.0f;

    /* renamed from: aV */
    private boolean f38075aV = false;

    /* renamed from: aW */
    private int f38076aW;

    /* renamed from: aX */
    private int f38077aX;
    /* access modifiers changed from: private */

    /* renamed from: aY */
    public int f38078aY;

    /* renamed from: aZ */
    private float f38079aZ;

    /* renamed from: aa */
    private int f38080aa = 0;

    /* renamed from: ab */
    private int f38081ab = 0;

    /* renamed from: ac */
    private int f38082ac = 0;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f38083ad = 0;

    /* renamed from: ae */
    private int f38084ae = 150;

    /* renamed from: af */
    private int f38085af = 8;

    /* renamed from: ag */
    private String f38086ag;

    /* renamed from: ah */
    private String f38087ah = "";

    /* renamed from: ai */
    private String f38088ai;

    /* renamed from: aj */
    private String f38089aj;

    /* renamed from: ak */
    private String f38090ak;

    /* renamed from: al */
    private String f38091al;

    /* renamed from: am */
    private float f38092am = 1.0f;

    /* renamed from: an */
    private float f38093an = 0.0f;

    /* renamed from: ao */
    private float f38094ao = 0.0f;

    /* renamed from: ap */
    private float f38095ap = 0.0f;

    /* renamed from: aq */
    private boolean f38096aq = true;

    /* renamed from: ar */
    private boolean f38097ar = true;

    /* renamed from: as */
    private boolean f38098as = false;

    /* renamed from: at */
    private boolean f38099at = false;

    /* renamed from: au */
    private boolean f38100au = true;

    /* renamed from: av */
    private boolean f38101av = false;

    /* renamed from: aw */
    private boolean f38102aw = false;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public boolean f38103ax = true;
    /* access modifiers changed from: private */

    /* renamed from: ay */
    public ScrollerCompat f38104ay;

    /* renamed from: az */
    private VelocityTracker f38105az;

    /* renamed from: ba */
    private float f38106ba;

    /* renamed from: bb */
    private float f38107bb;

    /* renamed from: bc */
    private int f38108bc = 0;
    /* access modifiers changed from: private */

    /* renamed from: bd */
    public int f38109bd = 0;
    /* access modifiers changed from: private */

    /* renamed from: be */
    public int f38110be = 0;

    /* renamed from: bf */
    private int f38111bf = 0;

    /* renamed from: bg */
    private int f38112bg = 0;

    /* renamed from: bh */
    private boolean f38113bh;

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScrollStateChange(NumberPickerView numberPickerView, int i);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPickerView numberPickerView, int i, int i2);
    }

    public interface OnValueChangeListenerInScrolling {
        void onValueChangeInScrolling(NumberPickerView numberPickerView, int i, int i2);
    }

    public interface OnValueChangeListenerRelativeToRaw {
        void onValueChangeRelativeToRaw(NumberPickerView numberPickerView, int i, int i2, String[] strArr);
    }

    /* renamed from: a */
    private float m26882a(float f, float f2, float f3) {
        return f2 + ((f3 - f2) * f);
    }

    /* renamed from: a */
    private int m26884a(float f, int i, int i2) {
        int i3 = (i & -16777216) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        int i6 = (i & 255) >>> 0;
        return ((int) (((float) i6) + (((float) (((i2 & 255) >>> 0) - i6)) * f))) | (((int) (((float) i3) + (((float) (((-16777216 & i2) >>> 24) - i3)) * f))) << 24) | (((int) (((float) i4) + (((float) (((16711680 & i2) >>> 16) - i4)) * f))) << 16) | (((int) (((float) i5) + (((float) (((65280 & i2) >>> 8) - i5)) * f))) << 8);
    }

    public NumberPickerView(Context context) {
        super(context);
        m26898a(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26899a(context, attributeSet);
        m26898a(context);
    }

    public NumberPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26899a(context, attributeSet);
        m26898a(context);
    }

    /* renamed from: a */
    private void m26899a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.NumberPickerView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 17) {
                    this.f38046S = obtainStyledAttributes.getInt(index, 3);
                } else if (index == 3) {
                    this.f38042O = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 4) {
                    this.f38043P = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == 5) {
                    this.f38044Q = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 6) {
                    this.f38045R = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 19) {
                    this.f38057aD = m26907a(obtainStyledAttributes.getTextArray(index));
                } else if (index == 21) {
                    this.f38030C = obtainStyledAttributes.getColor(index, f38004a);
                } else if (index == 22) {
                    this.f38031D = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 20) {
                    this.f38032E = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == 25) {
                    this.f38033F = obtainStyledAttributes.getDimensionPixelSize(index, m26887a(context, 14.0f));
                } else if (index == 26) {
                    this.f38034G = obtainStyledAttributes.getDimensionPixelSize(index, m26887a(context, 16.0f));
                } else if (index == 24) {
                    this.f38035H = obtainStyledAttributes.getDimensionPixelSize(index, m26887a(context, 14.0f));
                } else if (index == 14) {
                    this.f38049V = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 13) {
                    this.f38050W = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 27) {
                    this.f38097ar = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 18) {
                    this.f38096aq = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 8) {
                    this.f38086ag = obtainStyledAttributes.getString(index);
                } else if (index == 0) {
                    this.f38091al = obtainStyledAttributes.getString(index);
                } else if (index == 7) {
                    this.f38090ak = obtainStyledAttributes.getString(index);
                } else if (index == 12) {
                    this.f38038K = obtainStyledAttributes.getDimensionPixelSize(index, m26908b(context, 8.0f));
                } else if (index == 11) {
                    this.f38039L = obtainStyledAttributes.getDimensionPixelSize(index, m26908b(context, 8.0f));
                } else if (index == 10) {
                    this.f38040M = obtainStyledAttributes.getDimensionPixelSize(index, m26908b(context, 2.0f));
                } else if (index == 9) {
                    this.f38041N = obtainStyledAttributes.getDimensionPixelSize(index, m26908b(context, 5.0f));
                } else if (index == 1) {
                    this.f38058aE = obtainStyledAttributes.getTextArray(index);
                } else if (index == 2) {
                    this.f38059aF = obtainStyledAttributes.getTextArray(index);
                } else if (index == 16) {
                    this.f38102aw = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == 15) {
                    this.f38103ax = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 23) {
                    this.f38089aj = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m26898a(Context context) {
        this.f38104ay = ScrollerCompat.create(context);
        this.f38084ae = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.f38085af = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.f38033F == 0) {
            this.f38033F = m26887a(context, 14.0f);
        }
        if (this.f38034G == 0) {
            this.f38034G = m26887a(context, 16.0f);
        }
        if (this.f38035H == 0) {
            this.f38035H = m26887a(context, 14.0f);
        }
        if (this.f38038K == 0) {
            this.f38038K = m26908b(context, 8.0f);
        }
        if (this.f38039L == 0) {
            this.f38039L = m26908b(context, 8.0f);
        }
        this.f38054aA.setColor(this.f38042O);
        this.f38054aA.setAntiAlias(true);
        this.f38054aA.setStyle(Paint.Style.STROKE);
        this.f38054aA.setStrokeWidth((float) this.f38043P);
        this.f38055aB.setColor(this.f38030C);
        this.f38055aB.setAntiAlias(true);
        this.f38055aB.setTextAlign(Paint.Align.CENTER);
        this.f38056aC.setColor(this.f38032E);
        this.f38056aC.setAntiAlias(true);
        this.f38056aC.setTextAlign(Paint.Align.CENTER);
        this.f38056aC.setTextSize((float) this.f38035H);
        int i = this.f38046S;
        if (i % 2 == 0) {
            this.f38046S = i + 1;
        }
        if (this.f38049V == -1 || this.f38050W == -1) {
            m26938k();
        }
        m26893a();
    }

    /* renamed from: a */
    private void m26893a() {
        HandlerThread handlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.f38060aG = handlerThread;
        handlerThread.start();
        this.f38061aH = new Handler(this.f38060aG.getLooper()) {
            public void handleMessage(Message message) {
                int i;
                int i2;
                int i3 = message.what;
                if (i3 == 1) {
                    int i4 = 0;
                    if (!NumberPickerView.this.f38104ay.isFinished()) {
                        if (NumberPickerView.this.f38067aN == 0) {
                            NumberPickerView.this.m26912b(1);
                        }
                        NumberPickerView.this.f38061aH.sendMessageDelayed(NumberPickerView.this.m26890a(1, 0, 0, message.obj), 32);
                        return;
                    }
                    if (NumberPickerView.this.f38109bd != 0) {
                        if (NumberPickerView.this.f38067aN == 0) {
                            NumberPickerView.this.m26912b(1);
                        }
                        if (NumberPickerView.this.f38109bd < (-NumberPickerView.this.f38078aY) / 2) {
                            i2 = (int) ((((float) (NumberPickerView.this.f38078aY + NumberPickerView.this.f38109bd)) * 300.0f) / ((float) NumberPickerView.this.f38078aY));
                            NumberPickerView.this.f38104ay.startScroll(0, NumberPickerView.this.f38110be, 0, NumberPickerView.this.f38109bd + NumberPickerView.this.f38078aY, i2 * 3);
                            NumberPickerView numberPickerView = NumberPickerView.this;
                            i = numberPickerView.m26916c(numberPickerView.f38110be + NumberPickerView.this.f38078aY + NumberPickerView.this.f38109bd);
                        } else {
                            i2 = (int) ((((float) (-NumberPickerView.this.f38109bd)) * 300.0f) / ((float) NumberPickerView.this.f38078aY));
                            NumberPickerView.this.f38104ay.startScroll(0, NumberPickerView.this.f38110be, 0, NumberPickerView.this.f38109bd, i2 * 3);
                            NumberPickerView numberPickerView2 = NumberPickerView.this;
                            i = numberPickerView2.m26916c(numberPickerView2.f38110be + NumberPickerView.this.f38109bd);
                        }
                        i4 = i2;
                        NumberPickerView.this.postInvalidate();
                    } else {
                        NumberPickerView.this.m26912b(0);
                        NumberPickerView numberPickerView3 = NumberPickerView.this;
                        i = numberPickerView3.m26916c(numberPickerView3.f38110be);
                    }
                    NumberPickerView numberPickerView4 = NumberPickerView.this;
                    Message a = numberPickerView4.m26890a(2, numberPickerView4.f38083ad, i, message.obj);
                    if (NumberPickerView.this.f38103ax) {
                        NumberPickerView.this.f38062aI.sendMessageDelayed(a, (long) (i4 * 2));
                    } else {
                        NumberPickerView.this.f38061aH.sendMessageDelayed(a, (long) (i4 * 2));
                    }
                } else if (i3 == 2) {
                    NumberPickerView.this.m26896a(message.arg1, message.arg2, message.obj);
                }
            }
        };
        this.f38062aI = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 2) {
                    NumberPickerView.this.m26896a(message.arg1, message.arg2, message.obj);
                } else if (i == 3) {
                    NumberPickerView.this.requestLayout();
                }
            }
        };
    }

    /* renamed from: a */
    private void m26895a(int i, int i2) {
        this.f38066aM.onValueChangeInScrolling(this, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m26904a(false);
        setMeasuredDimension(m26926f(i), m26929g(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        this.f38076aW = i;
        this.f38077aX = i2;
        this.f38078aY = i2 / this.f38046S;
        this.f38107bb = ((float) ((i + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        boolean z = false;
        if (getOneRecycleSize() > 1) {
            if (this.f38099at) {
                i5 = getValue() - this.f38051X;
            } else if (this.f38098as) {
                i5 = this.f38108bc + ((this.f38046S - 1) / 2);
            }
            if (this.f38097ar && this.f38100au) {
                z = true;
            }
            m26913b(i5, z);
            m26922d();
            m26924e();
            m26918c();
            this.f38099at = true;
        }
        i5 = 0;
        z = true;
        m26913b(i5, z);
        m26922d();
        m26924e();
        m26918c();
        this.f38099at = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = this.f38060aG;
        if (handlerThread == null || !handlerThread.isAlive()) {
            m26893a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f38060aG.quit();
        if (this.f38078aY != 0) {
            if (!this.f38104ay.isFinished()) {
                this.f38104ay.abortAnimation();
                this.f38110be = this.f38104ay.getCurrY();
                m26928f();
                int i = this.f38109bd;
                if (i != 0) {
                    int i2 = this.f38078aY;
                    if (i < (-i2) / 2) {
                        this.f38110be = this.f38110be + i2 + i;
                    } else {
                        this.f38110be += i;
                    }
                    m26928f();
                }
                m26912b(0);
            }
            int c = m26916c(this.f38110be);
            int i3 = this.f38083ad;
            if (c != i3 && this.f38102aw) {
                try {
                    if (this.f38064aK != null) {
                        this.f38064aK.onValueChange(this, i3 + this.f38051X, this.f38051X + c);
                    }
                    if (this.f38063aJ != null) {
                        this.f38063aJ.onValueChangeRelativeToRaw(this, this.f38083ad, c, this.f38057aD);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f38083ad = c;
        }
    }

    public int getOneRecycleSize() {
        return (this.f38050W - this.f38049V) + 1;
    }

    public int getRawContentSize() {
        String[] strArr = this.f38057aD;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public void setDisplayedValuesAndPickedIndex(String[] strArr, int i, boolean z) {
        stopScrolling();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        } else if (i >= 0) {
            m26915b(strArr);
            m26904a(true);
            m26924e();
            m26937j();
            this.f38083ad = this.f38049V + i;
            m26913b(i, this.f38097ar && this.f38100au);
            if (z) {
                this.f38061aH.sendMessageDelayed(m26932h(1), 0);
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("pickedIndex should not be negative, now pickedIndex is " + i);
        }
    }

    public void setDisplayedValues(String[] strArr, boolean z) {
        setDisplayedValuesAndPickedIndex(strArr, 0, z);
    }

    public void setDisplayedValues(String[] strArr) {
        m26941n();
        stopScrolling();
        if (strArr != null) {
            boolean z = true;
            if ((this.f38052Y - this.f38051X) + 1 <= strArr.length) {
                m26915b(strArr);
                m26904a(true);
                this.f38083ad = this.f38049V + 0;
                if (!this.f38097ar || !this.f38100au) {
                    z = false;
                }
                m26913b(0, z);
                postInvalidate();
                this.f38062aI.sendEmptyMessage(3);
                return;
            }
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.f38052Y - this.f38051X) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        }
        throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }

    public String[] getDisplayedValues() {
        return this.f38057aD;
    }

    public void setWrapSelectorWheel(boolean z) {
        if (this.f38097ar == z) {
            return;
        }
        if (z) {
            this.f38097ar = z;
            m26940m();
            postInvalidate();
        } else if (this.f38067aN == 0) {
            m26911b();
        } else {
            this.f38101av = true;
        }
    }

    public void smoothScrollToValue(int i) {
        smoothScrollToValue(getValue(), i, true);
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(getValue(), i, z);
    }

    public void smoothScrollToValue(int i, int i2) {
        smoothScrollToValue(i, i2, true);
    }

    public void smoothScrollToValue(int i, int i2, boolean z) {
        int i3;
        boolean z2 = true;
        int a = m26885a(i, this.f38051X, this.f38052Y, this.f38097ar && this.f38100au);
        int i4 = this.f38051X;
        int i5 = this.f38052Y;
        if (!this.f38097ar || !this.f38100au) {
            z2 = false;
        }
        int a2 = m26885a(i2, i4, i5, z2);
        if (!this.f38097ar || !this.f38100au) {
            i3 = a2 - a;
        } else {
            i3 = a2 - a;
            int oneRecycleSize = getOneRecycleSize() / 2;
            if (i3 < (-oneRecycleSize) || oneRecycleSize < i3) {
                int oneRecycleSize2 = getOneRecycleSize();
                i3 = i3 > 0 ? i3 - oneRecycleSize2 : i3 + oneRecycleSize2;
            }
        }
        setValue(a);
        if (a != a2) {
            m26897a(i3, z);
        }
    }

    public void refreshByNewDisplayedValues(String[] strArr) {
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26896a(int i, int i2, Object obj) {
        m26912b(0);
        if (i != i2 && (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue())) {
            OnValueChangeListener onValueChangeListener = this.f38064aK;
            if (onValueChangeListener != null) {
                int i3 = this.f38051X;
                onValueChangeListener.onValueChange(this, i + i3, i3 + i2);
            }
            OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw = this.f38063aJ;
            if (onValueChangeListenerRelativeToRaw != null) {
                onValueChangeListenerRelativeToRaw.onValueChangeRelativeToRaw(this, i, i2, this.f38057aD);
            }
        }
        this.f38083ad = i2;
        if (this.f38101av) {
            this.f38101av = false;
            m26911b();
        }
    }

    /* renamed from: a */
    private void m26894a(int i) {
        m26897a(i, true);
    }

    /* renamed from: a */
    private void m26897a(int i, boolean z) {
        int i2;
        int pickedIndexRelativeToRaw;
        int i3;
        int i4;
        if ((!this.f38097ar || !this.f38100au) && ((i3 = pickedIndexRelativeToRaw + i) > (i4 = this.f38050W) || i3 < (i4 = this.f38049V))) {
            i = i4 - (pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw());
        }
        int i5 = this.f38109bd;
        int i6 = this.f38078aY;
        if (i5 < (-i6) / 2) {
            int i7 = i6 + i5;
            int i8 = (int) ((((float) (i5 + i6)) * 300.0f) / ((float) i6));
            i2 = i < 0 ? (-i8) - (i * 300) : i8 + (i * 300);
            i5 = i7;
        } else {
            int i9 = (int) ((((float) (-i5)) * 300.0f) / ((float) i6));
            i2 = i < 0 ? i9 - (i * 300) : i9 + (i * 300);
        }
        int i10 = i5 + (i * this.f38078aY);
        if (i2 < 300) {
            i2 = 300;
        }
        if (i2 > 600) {
            i2 = 600;
        }
        this.f38104ay.startScroll(0, this.f38110be, 0, i10, i2);
        if (z) {
            this.f38061aH.sendMessageDelayed(m26932h(1), (long) (i2 / 4));
        } else {
            this.f38061aH.sendMessageDelayed(m26890a(1, 0, 0, (Object) new Boolean(z)), (long) (i2 / 4));
        }
        postInvalidate();
    }

    public int getMinValue() {
        return this.f38051X;
    }

    public int getMaxValue() {
        return this.f38052Y;
    }

    public void setMinValue(int i) {
        this.f38051X = i;
        this.f38049V = 0;
        m26924e();
    }

    public void setMaxValue(int i) {
        String[] strArr = this.f38057aD;
        if (strArr != null) {
            int i2 = this.f38051X;
            if ((i - i2) + 1 <= strArr.length) {
                this.f38052Y = i;
                int i3 = this.f38049V;
                int i4 = (i - i2) + i3;
                this.f38050W = i4;
                setMinAndMaxShowIndex(i3, i4);
                m26924e();
                return;
            }
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.f38051X) + 1) + " and mDisplayedValues.length is " + this.f38057aD.length);
        }
        throw new NullPointerException("mDisplayedValues should not be null");
    }

    public void setValue(int i) {
        int i2 = this.f38051X;
        if (i < i2) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i <= this.f38052Y) {
            setPickedIndexRelativeToRaw(i - i2);
        } else {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        }
    }

    public int getValue() {
        return getPickedIndexRelativeToRaw() + this.f38051X;
    }

    public String getContentByCurrValue() {
        return this.f38057aD[getValue() - this.f38051X];
    }

    public boolean getWrapSelectorWheel() {
        return this.f38097ar;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.f38097ar && this.f38100au;
    }

    public void setHintText(String str) {
        if (!m26906a(this.f38086ag, str)) {
            this.f38086ag = str;
            this.f38095ap = m26883a(this.f38056aC.getFontMetrics());
            this.f38036I = m26888a((CharSequence) this.f38086ag, this.f38056aC);
            this.f38062aI.sendEmptyMessage(3);
        }
    }

    public void setSuffixText(String str) {
        if (!m26906a(this.f38087ah, str)) {
            this.f38087ah = str;
            this.f38062aI.sendEmptyMessage(3);
        }
    }

    public void setSuffixScope(String str) {
        if (!m26906a(this.f38088ai, str)) {
            this.f38088ai = str;
            this.f38062aI.sendEmptyMessage(3);
        }
    }

    public void setPickedIndexRelativeToMin(int i) {
        if (i >= 0 && i < getOneRecycleSize()) {
            this.f38083ad = this.f38049V + i;
            m26913b(i, this.f38097ar && this.f38100au);
            postInvalidate();
        }
    }

    public void setNormalTextColor(int i) {
        if (this.f38030C != i) {
            this.f38030C = i;
            postInvalidate();
        }
    }

    public void setSelectedTextColor(int i) {
        if (this.f38031D != i) {
            this.f38031D = i;
            postInvalidate();
        }
    }

    public void setHintTextColor(int i) {
        if (this.f38032E != i) {
            this.f38032E = i;
            this.f38056aC.setColor(i);
            postInvalidate();
        }
    }

    public void setDividerColor(int i) {
        if (this.f38042O != i) {
            this.f38042O = i;
            this.f38054aA.setColor(i);
            postInvalidate();
        }
    }

    public void setPickedIndexRelativeToRaw(int i) {
        int i2 = this.f38049V;
        if (i2 > -1 && i2 <= i && i <= this.f38050W) {
            this.f38083ad = i;
            m26913b(i - i2, this.f38097ar && this.f38100au);
            postInvalidate();
        }
    }

    public int getPickedIndexRelativeToRaw() {
        int i = this.f38109bd;
        if (i == 0) {
            return m26916c(this.f38110be);
        }
        int i2 = this.f38078aY;
        if (i < (-i2) / 2) {
            return m26916c(this.f38110be + i2 + i);
        }
        return m26916c(this.f38110be + i);
    }

    public void setMinAndMaxShowIndex(int i, int i2) {
        setMinAndMaxShowIndex(i, i2, true);
    }

    public void setMinAndMaxShowIndex(int i, int i2, boolean z) {
        if (i <= i2) {
            String[] strArr = this.f38057aD;
            if (strArr == null) {
                throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            } else if (i >= 0) {
                boolean z2 = true;
                if (i > strArr.length - 1) {
                    throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f38057aD.length - 1) + " minShowIndex is " + i);
                } else if (i2 < 0) {
                    throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
                } else if (i2 <= strArr.length - 1) {
                    this.f38049V = i;
                    this.f38050W = i2;
                    if (z) {
                        this.f38083ad = i + 0;
                        if (!this.f38097ar || !this.f38100au) {
                            z2 = false;
                        }
                        m26913b(0, z2);
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.f38057aD.length - 1) + " maxShowIndex is " + i2);
                }
            } else {
                throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
            }
        } else {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        }
    }

    public void setFriction(float f) {
        if (f > 0.0f) {
            ViewConfiguration.get(getContext());
            this.f38092am = ViewConfiguration.getScrollFriction() / f;
            return;
        }
        throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26912b(int i) {
        if (this.f38067aN != i) {
            this.f38067aN = i;
            OnScrollListener onScrollListener = this.f38065aL;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChange(this, i);
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f38065aL = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.f38064aK = onValueChangeListener;
    }

    public void setOnValueChangedListenerRelativeToRaw(OnValueChangeListenerRelativeToRaw onValueChangeListenerRelativeToRaw) {
        this.f38063aJ = onValueChangeListenerRelativeToRaw;
    }

    public void setOnValueChangeListenerInScrolling(OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.f38066aM = onValueChangeListenerInScrolling;
    }

    public void setContentTextTypeface(Typeface typeface) {
        this.f38055aB.setTypeface(typeface);
    }

    public void setHintTextTypeface(Typeface typeface) {
        this.f38056aC.setTypeface(typeface);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m26916c(int i) {
        int i2 = this.f38078aY;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i3 = (i / i2) + (this.f38046S / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.f38097ar && this.f38100au) {
            z = true;
        }
        int a = m26886a(i3, oneRecycleSize, z);
        if (a >= 0 && a < getOneRecycleSize()) {
            return a + this.f38049V;
        }
        if (a >= getOneRecycleSize()) {
            return getOneRecycleSize() - 1;
        }
        return this.f38049V;
    }

    /* renamed from: a */
    private int m26886a(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    /* renamed from: b */
    private void m26911b() {
        m26913b(getPickedIndexRelativeToRaw() - this.f38049V, false);
        this.f38097ar = false;
        postInvalidate();
    }

    /* renamed from: c */
    private void m26918c() {
        int i = this.f38046S;
        int i2 = i / 2;
        this.f38047T = i2;
        int i3 = i2 + 1;
        this.f38048U = i3;
        int i4 = this.f38077aX;
        this.f38079aZ = (float) ((i2 * i4) / i);
        this.f38106ba = (float) ((i3 * i4) / i);
        if (this.f38044Q < 0) {
            this.f38044Q = 0;
        }
        if (this.f38045R < 0) {
            this.f38045R = 0;
        }
        if (this.f38044Q + this.f38045R != 0 && getPaddingLeft() + this.f38044Q >= (this.f38076aW - getPaddingRight()) - this.f38045R) {
            int paddingLeft = getPaddingLeft() + this.f38044Q + getPaddingRight();
            int i5 = this.f38045R;
            int i6 = (paddingLeft + i5) - this.f38076aW;
            int i7 = this.f38044Q;
            float f = (float) i6;
            int i8 = (int) (((float) i7) - ((((float) i7) * f) / ((float) (i7 + i5))));
            this.f38044Q = i8;
            this.f38045R = (int) (((float) i5) - ((f * ((float) i5)) / ((float) (i8 + i5))));
        }
    }

    /* renamed from: d */
    private void m26922d() {
        int i = this.f38033F;
        int i2 = this.f38078aY;
        if (i > i2) {
            this.f38033F = i2;
        }
        int i3 = this.f38034G;
        int i4 = this.f38078aY;
        if (i3 > i4) {
            this.f38034G = i4;
        }
        Paint paint = this.f38056aC;
        if (paint != null) {
            paint.setTextSize((float) this.f38035H);
            this.f38095ap = m26883a(this.f38056aC.getFontMetrics());
            this.f38036I = m26888a((CharSequence) this.f38086ag, this.f38056aC);
            TextPaint textPaint = this.f38055aB;
            if (textPaint != null) {
                textPaint.setTextSize((float) this.f38034G);
                this.f38094ao = m26883a(this.f38055aB.getFontMetrics());
                this.f38055aB.setTextSize((float) this.f38033F);
                this.f38093an = m26883a(this.f38055aB.getFontMetrics());
                return;
            }
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
    }

    /* renamed from: e */
    private void m26924e() {
        this.f38070aQ = 0;
        this.f38071aR = (-this.f38046S) * this.f38078aY;
        if (this.f38057aD != null) {
            int oneRecycleSize = getOneRecycleSize();
            int i = this.f38046S;
            int i2 = this.f38078aY;
            this.f38070aQ = ((oneRecycleSize - (i / 2)) - 1) * i2;
            this.f38071aR = (-(i / 2)) * i2;
        }
    }

    /* renamed from: d */
    private int m26920d(int i) {
        if (this.f38097ar && this.f38100au) {
            return i;
        }
        int i2 = this.f38071aR;
        if (i >= i2 && i <= (i2 = this.f38070aQ)) {
            return i;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r1 < ((float) r3)) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f38078aY
            r2 = 1
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.view.VelocityTracker r1 = r0.f38105az
            if (r1 != 0) goto L_0x0012
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r0.f38105az = r1
        L_0x0012:
            android.view.VelocityTracker r1 = r0.f38105az
            r3 = r18
            r1.addMovement(r3)
            float r1 = r18.getY()
            r0.f38074aU = r1
            int r1 = r18.getAction()
            r4 = 0
            if (r1 == 0) goto L_0x00c1
            r5 = 0
            r7 = 2
            if (r1 == r2) goto L_0x0072
            if (r1 == r7) goto L_0x0045
            r3 = 3
            if (r1 == r3) goto L_0x0032
            goto L_0x00de
        L_0x0032:
            int r1 = r0.f38110be
            float r1 = (float) r1
            r0.f38072aS = r1
            r17.stopScrolling()
            android.os.Handler r1 = r0.f38061aH
            android.os.Message r3 = r0.m26932h((int) r2)
            r1.sendMessageDelayed(r3, r5)
            goto L_0x00de
        L_0x0045:
            float r1 = r0.f38073aT
            float r3 = r0.f38074aU
            float r1 = r1 - r3
            boolean r3 = r0.f38075aV
            if (r3 == 0) goto L_0x005c
            int r3 = r0.f38085af
            int r5 = -r3
            float r5 = (float) r5
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x005c
            float r3 = (float) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x005c
            goto L_0x006e
        L_0x005c:
            r0.f38075aV = r4
            float r3 = r0.f38072aS
            float r3 = r3 + r1
            int r1 = (int) r3
            int r1 = r0.m26920d((int) r1)
            r0.f38110be = r1
            r17.m26928f()
            r17.invalidate()
        L_0x006e:
            r0.m26912b((int) r2)
            goto L_0x00de
        L_0x0072:
            boolean r1 = r0.f38075aV
            if (r1 == 0) goto L_0x007a
            r17.m26901a((android.view.MotionEvent) r18)
            goto L_0x00de
        L_0x007a:
            android.view.VelocityTracker r1 = r0.f38105az
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            float r1 = r1.getYVelocity()
            float r3 = r0.f38092am
            float r1 = r1 * r3
            int r1 = (int) r1
            int r3 = java.lang.Math.abs(r1)
            int r4 = r0.f38084ae
            if (r3 <= r4) goto L_0x00b4
            androidx.core.widget.ScrollerCompat r8 = r0.f38104ay
            r9 = 0
            int r10 = r0.f38110be
            r11 = 0
            int r12 = -r1
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            r14 = 2147483647(0x7fffffff, float:NaN)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r15 = r0.m26920d((int) r1)
            r1 = 2147483647(0x7fffffff, float:NaN)
            int r16 = r0.m26920d((int) r1)
            r8.fling(r9, r10, r11, r12, r13, r14, r15, r16)
            r17.invalidate()
            r0.m26912b((int) r7)
        L_0x00b4:
            android.os.Handler r1 = r0.f38061aH
            android.os.Message r3 = r0.m26932h((int) r2)
            r1.sendMessageDelayed(r3, r5)
            r17.m26931g()
            goto L_0x00de
        L_0x00c1:
            r0.f38075aV = r2
            android.os.Handler r1 = r0.f38061aH
            r1.removeMessages(r2)
            r17.stopScrolling()
            float r1 = r0.f38074aU
            r0.f38073aT = r1
            int r1 = r0.f38110be
            float r1 = (float) r1
            r0.f38072aS = r1
            r0.m26912b((int) r4)
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
        L_0x00de:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.picker.NumberPickerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m26901a(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        int i = 0;
        while (i < this.f38046S) {
            int i2 = this.f38078aY;
            if (((float) (i2 * i)) > y || y >= ((float) (i2 * (i + 1)))) {
                i++;
            } else {
                m26925e(i);
                return;
            }
        }
    }

    /* renamed from: e */
    private void m26925e(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.f38046S)) {
            m26894a(i - (i2 / 2));
        }
    }

    /* renamed from: a */
    private float m26883a(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    /* renamed from: b */
    private void m26913b(int i, boolean z) {
        int i2 = i - ((this.f38046S - 1) / 2);
        this.f38108bc = i2;
        int a = m26886a(i2, getOneRecycleSize(), z);
        this.f38108bc = a;
        int i3 = this.f38078aY;
        if (i3 == 0) {
            this.f38098as = true;
            return;
        }
        this.f38110be = i3 * a;
        int i4 = a + (this.f38046S / 2);
        this.f38068aO = i4;
        int oneRecycleSize = i4 % getOneRecycleSize();
        this.f38068aO = oneRecycleSize;
        if (oneRecycleSize < 0) {
            this.f38068aO = oneRecycleSize + getOneRecycleSize();
        }
        this.f38069aP = this.f38068aO;
        m26928f();
    }

    public void computeScroll() {
        if (this.f38078aY != 0 && this.f38104ay.computeScrollOffset()) {
            this.f38110be = this.f38104ay.getCurrY();
            m26928f();
            postInvalidate();
        }
    }

    /* renamed from: f */
    private void m26928f() {
        int floor = (int) Math.floor((double) (((float) this.f38110be) / ((float) this.f38078aY)));
        this.f38108bc = floor;
        int i = this.f38110be;
        int i2 = this.f38078aY;
        int i3 = -(i - (floor * i2));
        this.f38109bd = i3;
        if (this.f38066aM != null) {
            if ((-i3) > i2 / 2) {
                this.f38069aP = floor + 1 + (this.f38046S / 2);
            } else {
                this.f38069aP = floor + (this.f38046S / 2);
            }
            int oneRecycleSize = this.f38069aP % getOneRecycleSize();
            this.f38069aP = oneRecycleSize;
            if (oneRecycleSize < 0) {
                this.f38069aP = oneRecycleSize + getOneRecycleSize();
            }
            int i4 = this.f38068aO;
            int i5 = this.f38069aP;
            if (i4 != i5) {
                m26895a(i4, i5);
            }
            this.f38068aO = this.f38069aP;
        }
    }

    /* renamed from: g */
    private void m26931g() {
        VelocityTracker velocityTracker = this.f38105az;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f38105az.recycle();
            this.f38105az = null;
        }
    }

    /* renamed from: a */
    private void m26904a(boolean z) {
        m26933h();
        m26936i();
        if (!z) {
            return;
        }
        if (this.f38111bf == Integer.MIN_VALUE || this.f38112bg == Integer.MIN_VALUE) {
            this.f38062aI.sendEmptyMessage(3);
        }
    }

    /* renamed from: f */
    private int m26926f(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.f38111bf = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = 0;
        int i3 = Math.max(this.f38036I, this.f38037J) == 0 ? 0 : this.f38039L;
        if (Math.max(this.f38036I, this.f38037J) != 0) {
            i2 = this.f38038K;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight() + Math.max(this.f38081ab, Math.max(this.f38053Z, this.f38082ac) + ((i2 + Math.max(this.f38036I, this.f38037J) + i3 + (this.f38041N * 2)) * 2));
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    /* renamed from: g */
    private int m26929g(int i) {
        int mode = View.MeasureSpec.getMode(i);
        this.f38112bg = mode;
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.f38046S * (this.f38080aa + (this.f38040M * 2)));
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f38113bh) {
            m26900a(canvas);
        }
        m26914b(canvas);
        m26919c(canvas);
    }

    public void hide() {
        this.f38113bh = true;
        invalidate();
    }

    public void show() {
        this.f38113bh = false;
        invalidate();
    }

    /* renamed from: a */
    private void m26900a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int i;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < this.f38046S + 1) {
            float f5 = (float) (this.f38109bd + (this.f38078aY * i2));
            int a = m26886a(this.f38108bc + i2, getOneRecycleSize(), this.f38097ar && this.f38100au);
            int i3 = this.f38046S;
            if (i2 == i3 / 2) {
                int i4 = this.f38078aY;
                f3 = ((float) (this.f38109bd + i4)) / ((float) i4);
                i = m26884a(f3, this.f38030C, this.f38031D);
                f2 = m26882a(f3, (float) this.f38033F, (float) this.f38034G);
                f = m26882a(f3, this.f38093an, this.f38094ao);
            } else if (i2 == (i3 / 2) + 1) {
                float f6 = 1.0f - f4;
                int a2 = m26884a(f6, this.f38030C, this.f38031D);
                float a3 = m26882a(f6, (float) this.f38033F, (float) this.f38034G);
                float a4 = m26882a(f6, this.f38093an, this.f38094ao);
                f3 = f4;
                i = a2;
                f2 = a3;
                f = a4;
            } else {
                int i5 = this.f38030C;
                f2 = (float) this.f38033F;
                f = this.f38093an;
                int i6 = i5;
                f3 = f4;
                i = i6;
            }
            this.f38055aB.setColor(i);
            this.f38055aB.setTextSize(f2);
            if (a >= 0 && a < getOneRecycleSize()) {
                String str = this.f38057aD[a + this.f38049V];
                if (TextUtils.isEmpty(this.f38088ai) || str.matches(this.f38088ai)) {
                    str = str + this.f38087ah;
                }
                if (this.f38089aj != null) {
                    str = TextUtils.ellipsize(str, this.f38055aB, (float) (getWidth() - (this.f38041N * 2)), getEllipsizeType()).toString();
                }
                canvas.drawText(str, this.f38107bb, f5 + ((float) (this.f38078aY / 2)) + f, this.f38055aB);
            } else if (!TextUtils.isEmpty(this.f38090ak)) {
                canvas.drawText(this.f38090ak, this.f38107bb, f5 + ((float) (this.f38078aY / 2)) + f, this.f38055aB);
            }
            i2++;
            f4 = f3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.text.TextUtils.TruncateAt getEllipsizeType() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f38089aj
            int r1 = r0.hashCode()
            r2 = -1074341483(0xffffffffbff6d995, float:-1.9285151)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002d
            r2 = 100571(0x188db, float:1.4093E-40)
            if (r1 == r2) goto L_0x0023
            r2 = 109757538(0x68ac462, float:5.219839E-35)
            if (r1 == r2) goto L_0x0018
            goto L_0x0037
        L_0x0018:
            java.lang.String r1 = "start"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0038
        L_0x0023:
            java.lang.String r1 = "end"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 2
            goto L_0x0038
        L_0x002d:
            java.lang.String r1 = "middle"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x0037:
            r0 = -1
        L_0x0038:
            if (r0 == 0) goto L_0x004c
            if (r0 == r4) goto L_0x0049
            if (r0 != r3) goto L_0x0041
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            return r0
        L_0x0041:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Illegal text ellipsize type."
            r0.<init>(r1)
            throw r0
        L_0x0049:
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.MIDDLE
            return r0
        L_0x004c:
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.START
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.picker.NumberPickerView.getEllipsizeType():android.text.TextUtils$TruncateAt");
    }

    /* renamed from: b */
    private void m26914b(Canvas canvas) {
        if (this.f38096aq) {
            canvas.drawLine((float) (getPaddingLeft() + this.f38044Q), this.f38079aZ, (float) ((this.f38076aW - getPaddingRight()) - this.f38045R), this.f38079aZ, this.f38054aA);
            canvas.drawLine((float) (getPaddingLeft() + this.f38044Q), this.f38106ba, (float) ((this.f38076aW - getPaddingRight()) - this.f38045R), this.f38106ba, this.f38054aA);
        }
    }

    /* renamed from: c */
    private void m26919c(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f38086ag)) {
            canvas.drawText(this.f38086ag, this.f38107bb + ((float) ((this.f38053Z + this.f38036I) / 2)) + ((float) this.f38038K), ((this.f38079aZ + this.f38106ba) / 2.0f) + this.f38095ap, this.f38056aC);
        }
    }

    /* renamed from: h */
    private void m26933h() {
        float textSize = this.f38055aB.getTextSize();
        this.f38055aB.setTextSize((float) this.f38034G);
        this.f38053Z = m26889a((CharSequence[]) this.f38057aD, (Paint) this.f38055aB);
        this.f38081ab = m26889a(this.f38058aE, (Paint) this.f38055aB);
        this.f38082ac = m26889a(this.f38059aF, (Paint) this.f38055aB);
        this.f38055aB.setTextSize((float) this.f38035H);
        this.f38037J = m26888a((CharSequence) this.f38091al, (Paint) this.f38055aB);
        this.f38055aB.setTextSize(textSize);
    }

    /* renamed from: a */
    private int m26889a(CharSequence[] charSequenceArr, Paint paint) {
        if (charSequenceArr == null) {
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(m26888a(charSequence, paint), i);
            }
        }
        return i;
    }

    /* renamed from: a */
    private int m26888a(CharSequence charSequence, Paint paint) {
        if (!TextUtils.isEmpty(charSequence)) {
            return (int) (paint.measureText(charSequence.toString()) + 0.5f);
        }
        return 0;
    }

    /* renamed from: i */
    private void m26936i() {
        float textSize = this.f38055aB.getTextSize();
        this.f38055aB.setTextSize((float) this.f38034G);
        this.f38080aa = (int) (((double) (this.f38055aB.getFontMetrics().bottom - this.f38055aB.getFontMetrics().top)) + 0.5d);
        this.f38055aB.setTextSize(textSize);
    }

    /* renamed from: a */
    private void m26905a(String[] strArr) {
        this.f38049V = 0;
        this.f38050W = strArr.length - 1;
        this.f38057aD = strArr;
        m26940m();
    }

    /* renamed from: b */
    private void m26915b(String[] strArr) {
        this.f38057aD = strArr;
        m26940m();
    }

    /* renamed from: j */
    private void m26937j() {
        m26939l();
        m26940m();
        this.f38049V = 0;
        this.f38050W = this.f38057aD.length - 1;
    }

    /* renamed from: k */
    private void m26938k() {
        m26939l();
        m26940m();
        if (this.f38049V == -1) {
            this.f38049V = 0;
        }
        if (this.f38050W == -1) {
            this.f38050W = this.f38057aD.length - 1;
        }
        setMinAndMaxShowIndex(this.f38049V, this.f38050W, false);
    }

    /* renamed from: l */
    private void m26939l() {
        if (this.f38057aD == null) {
            String[] strArr = new String[1];
            this.f38057aD = strArr;
            strArr[0] = "0";
        }
    }

    /* renamed from: m */
    private void m26940m() {
        this.f38100au = this.f38057aD.length > this.f38046S;
    }

    /* renamed from: a */
    private int m26885a(int i, int i2, int i3, boolean z) {
        if (z) {
            if (i > i3) {
                return (((i - i3) % getOneRecycleSize()) + i2) - 1;
            }
            return i < i2 ? ((i - i2) % getOneRecycleSize()) + i3 + 1 : i;
        } else if (i > i3) {
            return i3;
        } else {
            return i < i2 ? i2 : i;
        }
    }

    /* renamed from: n */
    private void m26941n() {
        Handler handler = this.f38061aH;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void stopScrolling() {
        ScrollerCompat scrollerCompat = this.f38104ay;
        if (scrollerCompat != null && !scrollerCompat.isFinished()) {
            ScrollerCompat scrollerCompat2 = this.f38104ay;
            scrollerCompat2.startScroll(0, scrollerCompat2.getCurrY(), 0, 0, 1);
            this.f38104ay.abortAnimation();
            postInvalidate();
        }
    }

    public void stopScrollingAndCorrectPosition() {
        stopScrolling();
        Handler handler = this.f38061aH;
        if (handler != null) {
            handler.sendMessageDelayed(m26932h(1), 0);
        }
    }

    /* renamed from: h */
    private Message m26932h(int i) {
        return m26890a(i, 0, 0, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Message m26890a(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    /* renamed from: a */
    private boolean m26906a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    private int m26887a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: b */
    private int m26908b(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private String[] m26907a(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }
}
