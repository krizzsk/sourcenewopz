package com.didi.global.fintech.cashier.p117ui.widget.tickerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.GravityCompat;
import com.didi.passenger.C10448R;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView */
public class TickerView extends View {

    /* renamed from: a */
    private static final int f21995a = 12;

    /* renamed from: b */
    private static final int f21996b = -16777216;

    /* renamed from: c */
    private static final int f21997c = 350;

    /* renamed from: d */
    private static final Interpolator f21998d = new AccelerateDecelerateInterpolator();

    /* renamed from: e */
    private static final int f21999e = 8388611;

    /* renamed from: f */
    private final TickerDrawMetrics f22000f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final TickerColumnManager f22001g;

    /* renamed from: h */
    private final ValueAnimator f22002h = ValueAnimator.ofFloat(new float[]{1.0f});

    /* renamed from: i */
    private AnimationHolder f22003i;

    /* renamed from: j */
    private AnimationHolder f22004j;

    /* renamed from: k */
    private final Rect f22005k = new Rect();

    /* renamed from: l */
    private String f22006l;

    /* renamed from: m */
    private int f22007m;

    /* renamed from: n */
    private int f22008n;

    /* renamed from: o */
    private int f22009o;

    /* renamed from: p */
    private int f22010p;

    /* renamed from: q */
    private float f22011q;

    /* renamed from: r */
    private int f22012r;

    /* renamed from: s */
    private long f22013s;

    /* renamed from: t */
    private long f22014t;
    public final Paint textPaint;

    /* renamed from: u */
    private Interpolator f22015u;

    /* renamed from: v */
    private boolean f22016v;

    /* renamed from: w */
    private String f22017w;

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$ScrollingDirection */
    public enum ScrollingDirection {
        ANY,
        UP,
        DOWN
    }

    public TickerView(Context context) {
        super(context);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f22000f = tickerDrawMetrics;
        this.f22001g = new TickerColumnManager(tickerDrawMetrics);
        init(context, (AttributeSet) null, 0, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f22000f = tickerDrawMetrics;
        this.f22001g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, 0, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f22000f = tickerDrawMetrics;
        this.f22001g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, i, 0);
    }

    public TickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TextPaint textPaint2 = new TextPaint(1);
        this.textPaint = textPaint2;
        TickerDrawMetrics tickerDrawMetrics = new TickerDrawMetrics(textPaint2);
        this.f22000f = tickerDrawMetrics;
        this.f22001g = new TickerColumnManager(tickerDrawMetrics);
        init(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet, int i, int i2) {
        StyledAttributes styledAttributes = new StyledAttributes(context.getResources());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.TickerView, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C10448R.styleable.TickerView);
            styledAttributes.applyTypedArray(obtainStyledAttributes2);
            obtainStyledAttributes2.recycle();
        }
        styledAttributes.applyTypedArray(obtainStyledAttributes);
        this.f22015u = f21998d;
        this.f22014t = (long) obtainStyledAttributes.getInt(11, 350);
        this.f22016v = obtainStyledAttributes.getBoolean(10, false);
        this.f22009o = styledAttributes.gravity;
        if (styledAttributes.shadowColor != 0) {
            this.textPaint.setShadowLayer(styledAttributes.shadowRadius, styledAttributes.shadowDx, styledAttributes.shadowDy, styledAttributes.shadowColor);
        }
        if (styledAttributes.textStyle != 0) {
            this.f22012r = styledAttributes.textStyle;
            setTypeface(this.textPaint.getTypeface());
        }
        setTextColor(styledAttributes.textColor);
        setTextSize(styledAttributes.textSize);
        int i3 = obtainStyledAttributes.getInt(12, 0);
        if (i3 == 1) {
            setCharacterLists(TickerUtils.provideNumberList());
        } else if (i3 == 2) {
            setCharacterLists(TickerUtils.provideAlphabeticalList());
        } else if (isInEditMode()) {
            setCharacterLists(TickerUtils.provideNumberList());
        }
        int i4 = obtainStyledAttributes.getInt(13, 0);
        if (i4 == 0) {
            this.f22000f.mo66299a(ScrollingDirection.ANY);
        } else if (i4 == 1) {
            this.f22000f.mo66299a(ScrollingDirection.UP);
        } else if (i4 == 2) {
            this.f22000f.mo66299a(ScrollingDirection.DOWN);
        } else {
            throw new IllegalArgumentException("Unsupported ticker_defaultPreferredScrollingDirection: " + i4);
        }
        if (isCharacterListsSet()) {
            setText(styledAttributes.text, false);
        } else {
            this.f22017w = styledAttributes.text;
        }
        obtainStyledAttributes.recycle();
        this.f22002h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TickerView.this.m15949a(valueAnimator);
            }
        });
        final $$Lambda$TickerView$ZBuLU_DqXzreuHaa5LHOMdprqY r5 = new Runnable() {
            public final void run() {
                TickerView.this.m15956e();
            }
        };
        this.f22002h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TickerView.this.f22001g.mo66293b();
                TickerView.this.m15948a();
                TickerView.this.invalidate();
                if (Build.VERSION.SDK_INT >= 26) {
                    r5.run();
                } else {
                    TickerView.this.post(r5);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15949a(ValueAnimator valueAnimator) {
        this.f22001g.mo66288a(valueAnimator.getAnimatedFraction());
        m15948a();
        invalidate();
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$StyledAttributes */
    private static class StyledAttributes {
        int gravity;
        int shadowColor;
        float shadowDx;
        float shadowDy;
        float shadowRadius;
        String text;
        int textColor = -16777216;
        float textSize;
        int textStyle;

        StyledAttributes(Resources resources) {
            this.textSize = TypedValue.applyDimension(2, 12.0f, resources.getDisplayMetrics());
            this.gravity = 8388611;
        }

        /* access modifiers changed from: package-private */
        public void applyTypedArray(TypedArray typedArray) {
            this.gravity = typedArray.getInt(4, this.gravity);
            this.shadowColor = typedArray.getColor(6, this.shadowColor);
            this.shadowDx = typedArray.getFloat(7, this.shadowDx);
            this.shadowDy = typedArray.getFloat(8, this.shadowDy);
            this.shadowRadius = typedArray.getFloat(9, this.shadowRadius);
            this.text = typedArray.getString(5);
            this.textColor = typedArray.getColor(3, this.textColor);
            this.textSize = typedArray.getDimension(1, this.textSize);
            this.textStyle = typedArray.getInt(2, this.textStyle);
        }
    }

    public void setCharacterLists(String... strArr) {
        this.f22001g.mo66291a(strArr);
        String str = this.f22017w;
        if (str != null) {
            setText(str, false);
            this.f22017w = null;
        }
    }

    public boolean isCharacterListsSet() {
        return this.f22001g.mo66292a() != null;
    }

    public void setText(String str) {
        setText(str, !TextUtils.isEmpty(this.f22006l));
    }

    public void setText(String str, boolean z) {
        if (!TextUtils.equals(str, this.f22006l)) {
            if (!z && this.f22002h.isRunning()) {
                this.f22002h.cancel();
                this.f22004j = null;
                this.f22003i = null;
            }
            if (z) {
                this.f22004j = new AnimationHolder(str, this.f22013s, this.f22014t, this.f22015u);
                if (this.f22003i == null) {
                    m15956e();
                    return;
                }
                return;
            }
            setTextInternal(str);
            this.f22001g.mo66288a(1.0f);
            this.f22001g.mo66293b();
            m15948a();
            invalidate();
        }
    }

    public String getText() {
        return this.f22006l;
    }

    public int getTextColor() {
        return this.f22010p;
    }

    public void setTextColor(int i) {
        if (this.f22010p != i) {
            this.f22010p = i;
            this.textPaint.setColor(i);
            invalidate();
        }
    }

    public float getTextSize() {
        return this.f22011q;
    }

    public void setTextSize(float f) {
        if (this.f22011q != f) {
            this.f22011q = f;
            this.textPaint.setTextSize(f);
            m15955d();
        }
    }

    public Typeface getTypeface() {
        return this.textPaint.getTypeface();
    }

    public void setTypeface(Typeface typeface) {
        int i = this.f22012r;
        if (i == 3) {
            typeface = Typeface.create(typeface, 3);
        } else if (i == 1) {
            typeface = Typeface.create(typeface, 1);
        } else if (i == 2) {
            typeface = Typeface.create(typeface, 2);
        }
        this.textPaint.setTypeface(typeface);
        m15955d();
    }

    public long getAnimationDelay() {
        return this.f22013s;
    }

    public void setAnimationDelay(long j) {
        this.f22013s = j;
    }

    public long getAnimationDuration() {
        return this.f22014t;
    }

    public void setAnimationDuration(long j) {
        this.f22014t = j;
    }

    public Interpolator getAnimationInterpolator() {
        return this.f22015u;
    }

    public void setAnimationInterpolator(Interpolator interpolator) {
        this.f22015u = interpolator;
    }

    public void setPreferredScrollingDirection(ScrollingDirection scrollingDirection) {
        this.f22000f.mo66299a(scrollingDirection);
    }

    public int getGravity() {
        return this.f22009o;
    }

    public void setGravity(int i) {
        if (this.f22009o != i) {
            this.f22009o = i;
            invalidate();
        }
    }

    public void setAnimateMeasurementChange(boolean z) {
        this.f22016v = z;
    }

    public boolean getAnimateMeasurementChange() {
        return this.f22016v;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f22002h.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f22002h.removeListener(animatorListener);
    }

    public void setPaintFlags(int i) {
        this.textPaint.setFlags(i);
        m15955d();
    }

    public void setBlurMaskFilter(BlurMaskFilter.Blur blur, float f) {
        if (blur == null || f <= 0.0f) {
            setLayerType(1, (Paint) null);
            this.textPaint.setMaskFilter((MaskFilter) null);
            return;
        }
        this.textPaint.setMaskFilter(new BlurMaskFilter(f, blur));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15948a() {
        boolean z = true;
        boolean z2 = this.f22007m != m15952b();
        if (this.f22008n == m15954c()) {
            z = false;
        }
        if (z2 || z) {
            requestLayout();
        }
    }

    /* renamed from: b */
    private int m15952b() {
        return ((int) (this.f22016v ? this.f22001g.mo66295d() : this.f22001g.mo66294c())) + getPaddingLeft() + getPaddingRight();
    }

    /* renamed from: c */
    private int m15954c() {
        return ((int) this.f22000f.mo66300b()) + getPaddingTop() + getPaddingBottom();
    }

    /* renamed from: d */
    private void m15955d() {
        this.f22000f.mo66298a();
        m15948a();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f22007m = m15952b();
        this.f22008n = m15954c();
        setMeasuredDimension(resolveSize(this.f22007m, i), resolveSize(this.f22008n, i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f22005k.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        m15950a(canvas);
        canvas.translate(0.0f, this.f22000f.mo66301c());
        this.f22001g.mo66289a(canvas, this.textPaint);
        canvas.restore();
    }

    /* renamed from: a */
    private void m15950a(Canvas canvas) {
        m15951a(canvas, this.f22009o, this.f22005k, this.f22001g.mo66295d(), this.f22000f.mo66300b());
    }

    /* renamed from: a */
    static void m15951a(Canvas canvas, int i, Rect rect, float f, float f2) {
        int width = rect.width();
        int height = rect.height();
        float f3 = (i & 16) == 16 ? ((float) rect.top) + ((((float) height) - f2) / 2.0f) : 0.0f;
        float f4 = (i & 1) == 1 ? ((float) rect.left) + ((((float) width) - f) / 2.0f) : 0.0f;
        if ((i & 48) == 48) {
            f3 = 0.0f;
        }
        if ((i & 80) == 80) {
            f3 = ((float) rect.top) + (((float) height) - f2);
        }
        if ((i & 8388611) == 8388611) {
            f4 = 0.0f;
        }
        if ((i & GravityCompat.END) == 8388613) {
            f4 = ((float) rect.left) + (((float) width) - f);
        }
        canvas.translate(f4, f3);
        canvas.clipRect(0.0f, 0.0f, f, f2);
    }

    private void setTextInternal(String str) {
        char[] cArr;
        this.f22006l = str;
        if (str == null) {
            cArr = new char[0];
        } else {
            cArr = str.toCharArray();
        }
        this.f22001g.mo66290a(cArr);
        setContentDescription(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m15956e() {
        AnimationHolder animationHolder = this.f22004j;
        this.f22003i = animationHolder;
        this.f22004j = null;
        if (animationHolder != null) {
            setTextInternal(animationHolder.text);
            this.f22002h.setStartDelay(animationHolder.animationDelayInMillis);
            this.f22002h.setDuration(animationHolder.animationDurationInMillis);
            this.f22002h.setInterpolator(animationHolder.animationInterpolator);
            this.f22002h.start();
        }
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerView$AnimationHolder */
    private static final class AnimationHolder {
        public final long animationDelayInMillis;
        public final long animationDurationInMillis;
        public final Interpolator animationInterpolator;
        public final String text;

        private AnimationHolder(String str, long j, long j2, Interpolator interpolator) {
            this.text = str;
            this.animationDelayInMillis = j;
            this.animationDurationInMillis = j2;
            this.animationInterpolator = interpolator;
        }
    }
}
