package com.didi.nova.assembly.p127ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.nova.assembly.p127ui.shimmer.Shimmer;
import com.didi.nova.assembly.p127ui.shimmer.ShimmerTextView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.AnimatorBuilder;
import com.didichuxing.sofa.animation.AnimatorListenerAdapter;
import com.didichuxing.sofa.animation.SofaAnimatorCompat;
import com.taxis99.R;

/* renamed from: com.didi.nova.assembly.ui.SlideButton */
public class SlideButton extends FrameLayout {

    /* renamed from: a */
    private static final String f29202a = "SodaSlideButton";

    /* renamed from: b */
    private static final float f29203b = 0.3f;

    /* renamed from: c */
    private ShimmerTextView f29204c;

    /* renamed from: d */
    private ImageView f29205d;

    /* renamed from: e */
    private View f29206e;

    /* renamed from: f */
    private View f29207f;

    /* renamed from: g */
    private LottieAnimationView f29208g;

    /* renamed from: h */
    private Shimmer f29209h;

    /* renamed from: i */
    private float f29210i;

    /* renamed from: j */
    private float f29211j;

    /* renamed from: k */
    private float f29212k;

    /* renamed from: l */
    private float f29213l;

    /* renamed from: m */
    private float f29214m;

    /* renamed from: n */
    private int f29215n;

    /* renamed from: o */
    private float f29216o;

    /* renamed from: p */
    private boolean f29217p;

    /* renamed from: q */
    private long f29218q;

    /* renamed from: r */
    private CustomStyle f29219r;

    /* renamed from: s */
    private OnSlideActionListener f29220s;

    /* renamed from: t */
    private boolean f29221t;

    /* renamed from: u */
    private boolean f29222u;

    /* renamed from: com.didi.nova.assembly.ui.SlideButton$OnSlideActionListener */
    public interface OnSlideActionListener {
        void onActionCancel(SlideButton slideButton);

        void onActionConfirmed(SlideButton slideButton);

        void onTouchActionDown(SlideButton slideButton);

        void onTouchActionMove(SlideButton slideButton);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public SlideButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlideButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29217p = false;
        this.f29218q = 0;
        this.f29219r = CustomStyle.DEFAULT_STYLE;
        this.f29221t = true;
        this.f29222u = false;
        m20595a();
    }

    /* renamed from: a */
    private void m20595a() {
        View inflate = inflate(getContext(), R.layout.slide_button, this);
        this.f29204c = (ShimmerTextView) findViewById(R.id.shimmer_text_view);
        this.f29205d = (ImageView) findViewById(R.id.icon_arrow);
        this.f29206e = findViewById(R.id.foreground_view);
        this.f29207f = inflate;
        this.f29208g = (LottieAnimationView) findViewById(R.id.loading_view);
        this.f29206e.setClickable(false);
        this.f29208g.setVisibility(8);
        setText((int) R.string.soda_assembly_online);
        setStyle(this.f29219r);
        m20599b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m20598a("onLayout() called with: changed = [" + z + "], left = [" + i + "], top = [" + i2 + "], right = [" + i3 + "], bottom = [" + i4 + Const.jaRight);
        if (z) {
            this.f29214m = 0.0f;
            this.f29215n = getWidth();
            m20598a("onLayout mViewInitialX: " + this.f29214m + " mViewWidth: " + this.f29215n);
        }
    }

    /* renamed from: b */
    private void m20599b() {
        Shimmer shimmer = new Shimmer();
        this.f29209h = shimmer;
        shimmer.setDuration(3000);
    }

    /* renamed from: c */
    private void m20602c() {
        m20598a("startShimmer ShimmerEnable: " + this.f29221t);
        if (this.f29221t) {
            this.f29209h.start(this.f29204c);
        }
    }

    /* renamed from: d */
    private void m20603d() {
        m20598a("stopShimmer");
        this.f29209h.cancel();
    }

    /* renamed from: a */
    private void m20598a(String str) {
        SystemUtils.log(3, f29202a, str, (Throwable) null, "com.didi.nova.assembly.ui.SlideButton", 145);
    }

    /* renamed from: b */
    private void m20601b(String str) {
        SystemUtils.log(3, f29202a, str, (Throwable) null, "com.didi.nova.assembly.ui.SlideButton", 149);
    }

    public void startLoading() {
        m20598a("startLoading mLoading: " + this.f29217p);
        if (!this.f29217p) {
            this.f29217p = true;
            this.f29208g.setVisibility(0);
            this.f29208g.playAnimation();
        }
    }

    public void stopLoading() {
        m20604e();
        m20609j();
        m20602c();
        setForegroundTextViewAlpha(1.0f);
    }

    /* renamed from: e */
    private void m20604e() {
        m20598a("stopLoading mLoading: " + this.f29217p);
        if (this.f29217p) {
            this.f29208g.cancelAnimation();
            this.f29208g.setVisibility(8);
            this.f29217p = false;
        }
    }

    public void setShimmerColor(int i) {
        this.f29204c.setReflectionColor(getContext().getResources().getColor(i));
    }

    public void setText(CharSequence charSequence) {
        this.f29204c.setText(charSequence);
    }

    public void setText(int i) {
        this.f29204c.setText(i);
    }

    public void setTextSize(float f) {
        this.f29204c.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.f29204c.setTextColor(getResources().getColor(i));
    }

    public void setStyle(CustomStyle customStyle) {
        this.f29219r = customStyle;
        m20605f();
    }

    public void setShimmerEnable(boolean z) {
        this.f29221t = z;
    }

    public void setForegroundTextFadeEnable(boolean z) {
        this.f29222u = z;
    }

    /* renamed from: f */
    private void m20605f() {
        m20596a(this.f29219r.getForegroundResId(), this.f29219r.getBackgroundResId());
        setShimmerColor(this.f29219r.getShimmerColorResId());
    }

    public void setOnSlideActionListener(OnSlideActionListener onSlideActionListener) {
        this.f29220s = onSlideActionListener;
    }

    public void setIconArrow(int i) {
        this.f29205d.setImageResource(i);
        this.f29205d.setVisibility(0);
    }

    public ImageView getIconArrowImageView() {
        return this.f29205d;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        m20601b("onTouchEvent event: " + motionEvent + " mLoading: " + this.f29217p);
        if (this.f29217p) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f29210i = motionEvent.getRawX();
            m20598a("ACTION_DOWN mRawXStart: " + this.f29210i);
            m20610k();
        } else if (actionMasked == 1) {
            requestDisallowInterceptTouchEvent(false);
            float rawX = motionEvent.getRawX();
            this.f29212k = rawX;
            this.f29213l = rawX - this.f29210i;
            m20598a("ACTION_UP mRawXEnd: " + this.f29212k + " mMoveDeltaX:" + this.f29213l + " mViewWidth: " + this.f29215n);
            if (this.f29213l <= ((float) this.f29215n) * 0.3f) {
                m20601b("action not confirmed");
                m20607h();
            } else {
                m20601b("action confirmed");
                m20606g();
            }
        } else if (actionMasked == 2) {
            float rawX2 = motionEvent.getRawX();
            this.f29211j = rawX2;
            this.f29213l = rawX2 - this.f29210i;
            m20598a("ACTION_MOVE mRawXMove: " + this.f29211j + " mRawXStart: " + this.f29210i + " mMoveDeltaX: " + this.f29213l);
            if (Math.abs(this.f29213l) > ((float) this.f29215n) * 0.02f) {
                requestDisallowInterceptTouchEvent(true);
                float max = Math.max(this.f29213l, this.f29214m);
                m20611l();
                setSlideX(max);
                m20608i();
            }
        } else if (actionMasked == 3) {
            m20612m();
        }
        return true;
    }

    /* renamed from: g */
    private void m20606g() {
        float f = this.f29216o;
        float f2 = this.f29214m + ((float) this.f29215n);
        int abs = (int) ((Math.abs(f2 - f) / ((float) this.f29215n)) * 1000.0f);
        AnimatorBuilder property = SofaAnimatorCompat.play(this).property("SlideX", f, f2);
        if (this.f29222u) {
            property.property("ForegroundTextViewAlpha", getForegroundTextViewAlpha(), 0.0f);
        }
        property.duration(abs).decelerate().withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                SlideButton.this.m20613n();
            }
        }).build().start();
    }

    /* renamed from: h */
    private void m20607h() {
        float f = this.f29216o;
        float f2 = this.f29214m;
        if (f == f2) {
            m20612m();
            return;
        }
        int abs = (int) ((Math.abs(f2 - f) / ((float) this.f29215n)) * 1000.0f);
        AnimatorBuilder property = SofaAnimatorCompat.play(this).property("SlideX", f, f2);
        if (this.f29222u) {
            property.property("ForegroundTextViewAlpha", getForegroundTextViewAlpha(), 1.0f);
        }
        property.duration(abs).withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                SlideButton.this.m20612m();
            }
        }).build().start();
    }

    /* renamed from: i */
    private void m20608i() {
        if (this.f29222u) {
            float x = (this.f29206e.getX() * 1.0f) / ((float) this.f29215n);
            m20598a("fadeForegroundTextViewOnActionMove mViewWidth: " + this.f29215n + " foregroundView.getX(): " + this.f29206e.getX() + " ratio: " + x);
            setForegroundTextViewAlpha(Math.max(1.0f - x, 0.2f));
        }
    }

    /* access modifiers changed from: protected */
    public void setSlideX(float f) {
        m20598a("setSlideX: " + f);
        this.f29216o = f;
        this.f29206e.setX(f);
    }

    /* access modifiers changed from: protected */
    public void setForegroundTextViewAlpha(float f) {
        m20598a("setForegroundTextViewAlpha: " + f);
        this.f29204c.setAlpha(f);
    }

    /* access modifiers changed from: protected */
    public float getForegroundTextViewAlpha() {
        return this.f29204c.getAlpha();
    }

    /* renamed from: a */
    private void m20596a(int i, int i2) {
        this.f29206e.setBackgroundResource(i);
        this.f29207f.setBackgroundResource(i2);
    }

    /* renamed from: j */
    private void m20609j() {
        m20598a("ensureForegroundViewPosition mSlideX: " + this.f29216o + ", mViewInitialX: " + this.f29214m);
        float f = this.f29216o;
        float f2 = this.f29214m;
        if (f != f2) {
            setSlideX(f2);
        }
    }

    /* renamed from: k */
    private void m20610k() {
        m20598a("actionDown");
        m20603d();
        OnSlideActionListener onSlideActionListener = this.f29220s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionDown(this);
        }
    }

    /* renamed from: l */
    private void m20611l() {
        m20598a("actionMove");
        OnSlideActionListener onSlideActionListener = this.f29220s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionMove(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m20612m() {
        m20598a("actionCancel");
        m20602c();
        OnSlideActionListener onSlideActionListener = this.f29220s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionCancel(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m20613n() {
        m20598a("actionConfirmed");
        long currentTimeMillis = System.currentTimeMillis() - this.f29218q;
        m20601b("actionConfirmed timeInterval: " + currentTimeMillis + " System.currentTimeMillis(): " + System.currentTimeMillis() + " mLastActionConfirmedTime: " + this.f29218q);
        if (currentTimeMillis <= 1000) {
            m20601b("Action is too frequent and return!");
            return;
        }
        this.f29218q = System.currentTimeMillis();
        OnSlideActionListener onSlideActionListener = this.f29220s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionConfirmed(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m20602c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m20601b("onDetachedFromWindow");
        super.onDetachedFromWindow();
        m20603d();
    }

    /* renamed from: com.didi.nova.assembly.ui.SlideButton$CustomStyle */
    public static class CustomStyle {
        public static final CustomStyle DEFAULT_STYLE = new CustomStyle(R.drawable.slide_button_foreground_transparent, R.drawable.slide_button_background_orange, R.color.slide_button_shimmer_color_orange, R.color.dot_loading_normal_color, R.color.dot_loading_highlight_color);
        private int backgroundResId;
        private int dotLoadingHighlightColorResId;
        private int dotLoadingNormalColorResId;
        private int foregroundResId;
        private int shimmerColorResId;

        public CustomStyle(int i, int i2, int i3) {
            this(i, i2, i3, R.color.dot_loading_normal_color, R.color.dot_loading_highlight_color);
        }

        public CustomStyle(int i, int i2, int i3, int i4, int i5) {
            this.foregroundResId = i;
            this.backgroundResId = i2;
            this.shimmerColorResId = i3;
            this.dotLoadingNormalColorResId = i4;
            this.dotLoadingHighlightColorResId = i5;
        }

        /* access modifiers changed from: package-private */
        public int getForegroundResId() {
            return this.foregroundResId;
        }

        /* access modifiers changed from: package-private */
        public int getBackgroundResId() {
            return this.backgroundResId;
        }

        /* access modifiers changed from: package-private */
        public int getShimmerColorResId() {
            return this.shimmerColorResId;
        }

        /* access modifiers changed from: package-private */
        public int getDotLoadingHighlightColorResId() {
            return this.dotLoadingHighlightColorResId;
        }

        /* access modifiers changed from: package-private */
        public int getDotLoadingNormalColorResId() {
            return this.dotLoadingNormalColorResId;
        }
    }
}
