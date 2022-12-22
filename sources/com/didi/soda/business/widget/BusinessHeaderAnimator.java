package com.didi.soda.business.widget;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.business.widget.BusinessDyHeaderAnimator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.topgun.widget.HomeBusinessExceptionStatusView;
import com.taxis99.R;

public class BusinessHeaderAnimator implements IBusinessHeaderAnimator {

    /* renamed from: l */
    private static final String f39806l = "BusinessHeaderAnimator";

    /* renamed from: a */
    private float f39807a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Scroller f39808b;

    /* renamed from: c */
    private MeasurementRecordModel f39809c = new MeasurementRecordModel();

    /* renamed from: d */
    private boolean f39810d = false;

    /* renamed from: e */
    private IntEvaluator f39811e = new IntEvaluator();

    /* renamed from: f */
    private ArgbEvaluator f39812f = new ArgbEvaluator();

    /* renamed from: g */
    private FloatEvaluator f39813g = new FloatEvaluator();

    /* renamed from: h */
    private OnHeaderStateChangeListener f39814h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DependentViewChangedCallback f39815i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnHeaderCollapseListener f39816j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ScopeContext f39817k;

    /* renamed from: m */
    private Runnable f39818m = new Runnable() {
        public void run() {
            if (BusinessHeaderAnimator.this.f39817k == null || BusinessHeaderAnimator.this.f39817k.getLiveHandler() == null || BusinessHeaderAnimator.this.f39817k.getLiveHandler().isDestroyed()) {
                LogUtil.m29100d(BusinessHeaderAnimator.f39806l, "BusinessHeaderAnimator ScopeContext is null");
                return;
            }
            if (BusinessHeaderAnimator.this.f39808b.computeScrollOffset()) {
                BusinessHeaderAnimator businessHeaderAnimator = BusinessHeaderAnimator.this;
                businessHeaderAnimator.setAnimatedY((float) businessHeaderAnimator.f39808b.getCurrY());
                BusinessHeaderAnimator.this.m28390a((Runnable) this);
                if (BusinessHeaderAnimator.this.f39816j != null) {
                    BusinessHeaderAnimator.this.f39816j.onCollapseUpdated();
                }
            } else if (BusinessHeaderAnimator.this.f39816j != null) {
                BusinessHeaderAnimator.this.f39816j.onCollapseFinished();
                OnHeaderCollapseListener unused = BusinessHeaderAnimator.this.f39816j = null;
            }
            if (BusinessHeaderAnimator.this.f39815i != null) {
                BusinessHeaderAnimator.this.f39815i.onDependentViewChanged();
            }
        }
    };
    @BindView(17830)
    View mAttentionInfoContainer;
    @BindView(17933)
    HomeBusinessExceptionStatusView mBusinessExceptionStatusView;
    @BindView(17936)
    ImageView mBusinessLogo;
    @BindView(17937)
    TextView mBusinessNameTv;
    @BindView(18806)
    TextView mBusinessTabTipTv;
    @BindView(18506)
    RelativeLayout mClassifyTabContainer;
    @BindView(18350)
    IconTextView mCloseIcon;
    @BindView(18797)
    TextView mDeliveryTv;
    @BindView(19206)
    View mDividerLine;
    @BindView(18351)
    IconTextView mFavorImageIv;
    @BindView(17977)
    LottieLoadingView mFavorLoadingView;
    @BindView(18349)
    ImageView mHeaderBackgroundImg;
    @BindView(19191)
    View mHeaderBgMask;
    @BindView(18535)
    LinearLayout mHeaderCardContainer;
    @BindView(18551)
    View mMarketingContainer;
    @BindView(18352)
    IconTextView mSearchIcon;
    @BindView(17886)
    View mShadowView;
    @BindView(18805)
    TextView mStickyNameTv;
    @BindView(17835)
    ConstraintLayout mTitleContainer;

    public interface DependentViewChangedCallback {
        void onDependentViewChanged();
    }

    public void setDependentViewDyChangedCallback(BusinessDyHeaderAnimator.DependentViewChangedCallback dependentViewChangedCallback) {
    }

    BusinessHeaderAnimator(View view) {
        this.f39808b = new Scroller(view.getContext());
        ButterKnife.bind((Object) this, view);
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f39817k = scopeContext;
    }

    public void collapseHeader() {
        if (getAnimatedProgress() < 1.0f) {
            this.f39808b.startScroll(0, (int) this.f39807a, 0, (int) (getMaxAnimatedY() - this.f39807a));
            m28390a(this.f39818m);
        }
    }

    public void collapseHeader(OnHeaderCollapseListener onHeaderCollapseListener) {
        if (getAnimatedProgress() < 1.0f) {
            if (onHeaderCollapseListener != null) {
                this.f39816j = onHeaderCollapseListener;
            }
            this.f39808b.startScroll(0, (int) this.f39807a, 0, (int) (getMaxAnimatedY() - this.f39807a));
            m28390a(this.f39818m);
        }
    }

    public void expandHeader() {
        if (getAnimatedProgress() > 0.0f) {
            Scroller scroller = this.f39808b;
            float f = this.f39807a;
            scroller.startScroll(0, (int) f, 0, (int) (-f));
            m28390a(this.f39818m);
        }
    }

    public float getAnimatedProgress() {
        return Math.min(1.0f, Math.abs(this.f39807a / getMaxAnimatedY()));
    }

    public float getAnimatedY() {
        return this.f39807a;
    }

    public void setAnimatedY(float f) {
        this.f39807a = f;
        m28387a(getAnimatedProgress());
    }

    public float getMaxAnimatedY() {
        return (float) (-this.f39809c.totalOffset);
    }

    public void recordAnimationSpec() {
        if (!this.f39809c.recorded || this.f39810d) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.mBusinessNameTv.getLocationInWindow(iArr);
            this.mStickyNameTv.getLocationInWindow(iArr2);
            this.f39809c.nameYOffset = Math.abs(iArr2[1] - iArr[1]) + this.mBusinessNameTv.getPaddingTop();
            this.f39809c.nameHeight = this.mBusinessNameTv.getHeight();
            this.f39809c.totalOffset = (this.mHeaderCardContainer.getTop() + this.mHeaderCardContainer.getHeight()) - this.mTitleContainer.getBottom();
            this.f39809c.logoOffset = this.mBusinessLogo.getTop();
            this.f39809c.textScale = this.mStickyNameTv.getTextSize() / this.mBusinessNameTv.getTextSize();
            this.f39809c.maskOffset = this.mHeaderCardContainer.getHeight();
            this.f39809c.recorded = true;
            this.f39810d = false;
        }
    }

    public void updateRecordState(boolean z) {
        this.f39810d = z;
    }

    public boolean isExpanded() {
        return Math.abs(this.f39807a) < 8.0f;
    }

    public boolean isCollapsed() {
        return getAnimatedProgress() == 1.0f;
    }

    public void setOnHeaderStateChangeListener(OnHeaderStateChangeListener onHeaderStateChangeListener) {
        this.f39814h = onHeaderStateChangeListener;
    }

    public void setDependentViewChangedCallback(DependentViewChangedCallback dependentViewChangedCallback) {
        this.f39815i = dependentViewChangedCallback;
    }

    public int getShadowHeight() {
        return this.mShadowView.getHeight();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28390a(Runnable runnable) {
        this.mBusinessNameTv.postOnAnimation(runnable);
    }

    /* renamed from: a */
    private void m28387a(float f) {
        float max = (float) ((int) Math.max((float) ((int) this.f39807a), getMaxAnimatedY()));
        this.mBusinessExceptionStatusView.setTranslationY(max);
        this.mHeaderBgMask.setTranslationY(max);
        this.mBusinessLogo.setTranslationY(max);
        float f2 = 1.0f - f;
        this.mBusinessExceptionStatusView.setAlpha(f2);
        this.mBusinessLogo.setAlpha(1.0f - Math.abs(this.f39807a / ((float) this.f39809c.logoOffset)));
        this.mHeaderBackgroundImg.setAlpha(1.0f - (Math.abs(this.f39807a) / ((float) this.f39809c.maskOffset)));
        this.mHeaderCardContainer.setTranslationY(max);
        this.mClassifyTabContainer.setTranslationY(Math.max((float) ((int) this.f39807a), getMaxAnimatedY()));
        this.mBusinessTabTipTv.setTranslationY(Math.max((float) ((int) this.f39807a), getMaxAnimatedY()));
        this.mShadowView.setAlpha(0.4f * f);
        this.mShadowView.setTranslationY(Math.max((float) ((int) this.f39807a), getMaxAnimatedY()));
        this.mDividerLine.setAlpha(f2);
        float min = Math.min(Math.abs(this.f39807a) / ((float) this.f39809c.nameYOffset), 1.0f);
        if (min == 1.0f) {
            this.mStickyNameTv.setVisibility(0);
            this.mBusinessNameTv.setVisibility(4);
            this.mBusinessNameTv.setMaxLines(1);
        } else {
            this.mStickyNameTv.setVisibility(4);
            this.mBusinessNameTv.setVisibility(0);
            this.mBusinessNameTv.setMaxLines(2);
        }
        float floatValue = this.f39813g.evaluate(min, Float.valueOf(1.0f), Float.valueOf(this.f39809c.textScale)).floatValue();
        this.mBusinessNameTv.setScaleX(floatValue);
        this.mBusinessNameTv.setScaleY(floatValue);
        this.mBusinessNameTv.setMinHeight(this.f39809c.nameHeight);
        Integer num = (Integer) this.f39812f.evaluate(f, Integer.valueOf(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF)), Integer.valueOf(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000)));
        this.mCloseIcon.setTextColor(num.intValue());
        this.mSearchIcon.setTextColor(num.intValue());
        this.mFavorImageIv.setTextColor(num.intValue());
        m28388a(num.intValue());
        float f3 = 1.0f - min;
        this.mDeliveryTv.setAlpha(f3);
        this.mMarketingContainer.setAlpha(f3);
        this.mAttentionInfoContainer.setAlpha(f3);
        OnHeaderStateChangeListener onHeaderStateChangeListener = this.f39814h;
        if (onHeaderStateChangeListener == null) {
            return;
        }
        if (f >= 0.7f) {
            onHeaderStateChangeListener.onHeaderStateChanged(true);
        } else {
            onHeaderStateChangeListener.onHeaderStateChanged(false);
        }
    }

    /* renamed from: a */
    private void m28388a(int i) {
        SimpleColorFilter simpleColorFilter = new SimpleColorFilter(i);
        KeyPath keyPath = new KeyPath("**");
        LottieValueCallback lottieValueCallback = new LottieValueCallback(simpleColorFilter);
        LottieLoadingView lottieLoadingView = this.mFavorLoadingView;
        if (lottieLoadingView != null) {
            lottieLoadingView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, lottieValueCallback);
        }
    }

    private static class MeasurementRecordModel {
        int logoOffset;
        int maskOffset;
        int nameHeight;
        int nameYOffset;
        boolean recorded;
        float textScale;
        int totalOffset;

        private MeasurementRecordModel() {
            this.recorded = false;
            this.totalOffset = -1;
            this.logoOffset = -1;
            this.nameYOffset = -1;
            this.nameHeight = -1;
            this.textScale = -1.0f;
            this.maskOffset = -1;
        }
    }
}
