package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.passenger.C10448R;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.AnimatorListenerAdapter;
import com.didichuxing.sofa.animation.SofaAnimatorCompat;
import com.taxis99.R;

public class RFSlideButton extends FrameLayout {

    /* renamed from: a */
    private static final String f33361a = "RFSlideButton";

    /* renamed from: b */
    private static final float f33362b = 0.3f;

    /* renamed from: c */
    private RFusionConfig.IRFusionLogger f33363c;

    /* renamed from: d */
    private ImageView f33364d;

    /* renamed from: e */
    private View f33365e;

    /* renamed from: f */
    private RFLottieLoadingView f33366f;

    /* renamed from: g */
    private LinearLayout f33367g;

    /* renamed from: h */
    private RFTextView f33368h;

    /* renamed from: i */
    private RFTextView f33369i;

    /* renamed from: j */
    private float f33370j;

    /* renamed from: k */
    private float f33371k;

    /* renamed from: l */
    private float f33372l;

    /* renamed from: m */
    private float f33373m;

    /* renamed from: n */
    private float f33374n;

    /* renamed from: o */
    private int f33375o;

    /* renamed from: p */
    private float f33376p;

    /* renamed from: q */
    private long f33377q;

    /* renamed from: r */
    private OnSlideActionListener f33378r;

    public interface OnSlideActionListener {
        void onActionCancel(RFSlideButton rFSlideButton);

        void onActionConfirmed(RFSlideButton rFSlideButton);

        void onTouchActionDown(RFSlideButton rFSlideButton);

        void onTouchActionMove(RFSlideButton rFSlideButton);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public RFSlideButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSlideButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSlideButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33363c = RFLogger.getLogger();
        this.f33377q = 0;
        m23453a();
        m23454a(attributeSet);
    }

    /* renamed from: a */
    private void m23454a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.RFSlideButton);
        String string = obtainStyledAttributes.getString(1);
        String string2 = obtainStyledAttributes.getString(2);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        setText(string);
        setTips(string2);
        setEnabled(z);
    }

    /* renamed from: a */
    private void m23453a() {
        inflate(getContext(), R.layout.rf_btn_slide, this);
        this.f33364d = (ImageView) findViewById(R.id.rf_icon_arrow);
        this.f33365e = findViewById(R.id.rf_rl_foreground);
        this.f33366f = (RFLottieLoadingView) findViewById(R.id.rf_llv_loading);
        this.f33367g = (LinearLayout) findViewById(R.id.rf_ll_content);
        this.f33368h = (RFTextView) findViewById(R.id.rf_tv_text);
        this.f33369i = (RFTextView) findViewById(R.id.rf_tv_tips);
        this.f33365e.setClickable(false);
        this.f33364d.setImageResource(R.drawable.rf_icon_btn_slide_arrow);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m23456a("onLayout() called with: changed = [" + z + "], left = [" + i + "], top = [" + i2 + "], right = [" + i3 + "], bottom = [" + i4 + Const.jaRight);
        if (z) {
            this.f33374n = 0.0f;
            this.f33375o = getWidth();
            m23456a("onLayout mViewInitialX: " + this.f33374n + " mViewWidth: " + this.f33375o);
        }
    }

    /* renamed from: a */
    private void m23456a(String str) {
        this.f33363c.info(f33361a, str);
    }

    /* renamed from: b */
    private void m23459b(String str) {
        this.f33363c.info(f33361a, str);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f33365e.setEnabled(z);
    }

    public void setText(String str) {
        this.f33368h.setText(str);
    }

    public void setTips(String str) {
        this.f33369i.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f33369i.setVisibility(8);
            this.f33367g.setPadding((int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_left), 0, (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_right), 0);
            return;
        }
        this.f33369i.setVisibility(0);
        this.f33367g.setPadding((int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_left_large), 0, (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_right), 0);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.f33366f.show();
            return;
        }
        m23462e();
        this.f33366f.hide();
    }

    public void setOnSlideActionListener(OnSlideActionListener onSlideActionListener) {
        this.f33378r = onSlideActionListener;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f33366f.isRunning()) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f33370j = motionEvent.getRawX();
            m23456a("ACTION_DOWN mRawXStart: " + this.f33370j);
            m23463f();
        } else if (actionMasked == 1) {
            requestDisallowInterceptTouchEvent(false);
            float rawX = motionEvent.getRawX();
            this.f33372l = rawX;
            this.f33373m = rawX - this.f33370j;
            m23456a("ACTION_UP mRawXEnd: " + this.f33372l + " mMoveDeltaX:" + this.f33373m + " mViewWidth: " + this.f33375o);
            if (this.f33373m <= ((float) this.f33375o) * 0.3f) {
                m23459b("action not confirmed");
                m23460c();
            } else {
                m23459b("action confirmed");
                m23457b();
            }
        } else if (actionMasked == 2) {
            float rawX2 = motionEvent.getRawX();
            this.f33371k = rawX2;
            this.f33373m = rawX2 - this.f33370j;
            m23456a("ACTION_MOVE mRawXMove: " + this.f33371k + " mRawXStart: " + this.f33370j + " mMoveDeltaX: " + this.f33373m);
            if (Math.abs(this.f33373m) > ((float) this.f33375o) * 0.02f) {
                requestDisallowInterceptTouchEvent(true);
                float max = Math.max(this.f33373m, this.f33374n);
                m23464g();
                setSlideX(max);
                m23461d();
            }
        } else if (actionMasked == 3) {
            m23465h();
        }
        return true;
    }

    /* renamed from: b */
    private void m23457b() {
        float f = this.f33376p;
        float f2 = this.f33374n + ((float) this.f33375o);
        SofaAnimatorCompat.play(this).property("SlideX", f, f2).property("TextAlpha", getTextAlpha(), 0.0f).duration((int) ((Math.abs(f2 - f) / ((float) this.f33375o)) * 1000.0f)).decelerate().withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                RFSlideButton.this.m23466i();
            }
        }).build().start();
    }

    /* renamed from: c */
    private void m23460c() {
        float f = this.f33376p;
        float f2 = this.f33374n;
        if (f == f2) {
            m23465h();
            return;
        }
        SofaAnimatorCompat.play(this).property("SlideX", f, f2).property("TextAlpha", getTextAlpha(), 1.0f).duration((int) ((Math.abs(f2 - f) / ((float) this.f33375o)) * 1000.0f)).withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                RFSlideButton.this.m23465h();
            }
        }).build().start();
    }

    /* renamed from: d */
    private void m23461d() {
        float x = (this.f33365e.getX() * 1.0f) / ((float) this.f33375o);
        m23456a("fadeForegroundTextViewOnActionMove mViewWidth: " + this.f33375o + " foregroundView.getX(): " + this.f33365e.getX() + " ratio: " + x);
        setTextAlpha(Math.max(1.0f - x, 0.2f));
    }

    /* access modifiers changed from: protected */
    public void setTextAlpha(float f) {
        this.f33368h.setAlpha(f);
    }

    /* access modifiers changed from: protected */
    public float getTextAlpha() {
        return this.f33368h.getAlpha();
    }

    /* access modifiers changed from: protected */
    public void setSlideX(float f) {
        m23456a("setSlideX: " + f);
        this.f33376p = f;
        this.f33365e.setX(f);
    }

    /* renamed from: e */
    private void m23462e() {
        m23456a("ensureForegroundViewPosition mSlideX: " + this.f33376p + ", mViewInitialX: " + this.f33374n);
        float f = this.f33376p;
        float f2 = this.f33374n;
        if (f != f2) {
            setSlideX(f2);
        }
    }

    /* renamed from: f */
    private void m23463f() {
        this.f33365e.setSelected(true);
        m23456a("actionDown");
        OnSlideActionListener onSlideActionListener = this.f33378r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionDown(this);
        }
    }

    /* renamed from: g */
    private void m23464g() {
        m23456a("actionMove");
        OnSlideActionListener onSlideActionListener = this.f33378r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionMove(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m23465h() {
        this.f33365e.setSelected(false);
        m23456a("actionCancel");
        OnSlideActionListener onSlideActionListener = this.f33378r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionCancel(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m23466i() {
        this.f33365e.setSelected(false);
        m23456a("actionConfirmed");
        long currentTimeMillis = System.currentTimeMillis() - this.f33377q;
        m23459b("actionConfirmed timeInterval: " + currentTimeMillis + " System.currentTimeMillis(): " + System.currentTimeMillis() + " mLastActionConfirmedTime: " + this.f33377q);
        if (currentTimeMillis <= 1000) {
            m23459b("Action is too frequent and return!");
            return;
        }
        this.f33377q = System.currentTimeMillis();
        OnSlideActionListener onSlideActionListener = this.f33378r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionConfirmed(this);
        }
    }
}
