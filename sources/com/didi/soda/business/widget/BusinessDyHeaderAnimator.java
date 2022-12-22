package com.didi.soda.business.widget;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.RFIconView;
import com.didi.sdk.util.SidConverter;
import com.didi.soda.business.widget.BusinessHeaderAnimator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class BusinessDyHeaderAnimator implements IBusinessHeaderAnimator {

    /* renamed from: k */
    private static final float f39776k = 0.98f;

    /* renamed from: l */
    private static final String f39777l = "BusinessDyHeaderAnimator";

    /* renamed from: a */
    private float f39778a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Scroller f39779b;

    /* renamed from: c */
    private MeasurementRecordModel f39780c = new MeasurementRecordModel();

    /* renamed from: d */
    private boolean f39781d = false;

    /* renamed from: e */
    private IntEvaluator f39782e = new IntEvaluator();

    /* renamed from: f */
    private ArgbEvaluator f39783f = new ArgbEvaluator();

    /* renamed from: g */
    private FloatEvaluator f39784g = new FloatEvaluator();

    /* renamed from: h */
    private OnHeaderStateChangeListener f39785h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DependentViewChangedCallback f39786i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public OnHeaderCollapseListener f39787j;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ScopeContext f39788m;
    @BindView(17936)
    ImageView mBusinessLogo;
    @BindView(17743)
    BusinessDyClassifyALayout mClassifyALayout;
    @BindView(17744)
    BusinessDyClassifyBLayout mClassifyBLayout;
    @BindView(18506)
    ConstraintLayout mClassifyTabContainer;
    @BindView(18350)
    RFIconView mCloseIcon;
    @BindView(18351)
    RFIconView mFavorImageIv;
    @BindView(17977)
    LottieLoadingView mFavorLoadingView;
    @BindView(17256)
    ConstraintLayout mHeadeRoot;
    @BindView(18349)
    ImageView mHeaderBackgroundImg;
    @BindView(18634)
    FrameLayout mHeaderCardContainer;
    @BindView(18231)
    View mHeaderCardShadowView;
    @BindView(18155)
    FrameLayout mLogoContainer;
    @BindView(18352)
    RFIconView mSearchIcon;
    @BindView(18805)
    TextView mStickyNameTv;
    @BindView(18103)
    BusinessDyStickyNavigationView mStickyNavigationView;
    @BindView(17835)
    ConstraintLayout mTitleContainer;

    /* renamed from: n */
    private Runnable f39789n = new Runnable() {
        public void run() {
            if (BusinessDyHeaderAnimator.this.f39788m == null || BusinessDyHeaderAnimator.this.f39788m.getLiveHandler() == null || BusinessDyHeaderAnimator.this.f39788m.getLiveHandler().isDestroyed()) {
                LogUtil.m29100d(BusinessDyHeaderAnimator.f39777l, "BusinessDyHeaderAnimator ScopeContext is null");
                return;
            }
            if (BusinessDyHeaderAnimator.this.f39779b.computeScrollOffset()) {
                BusinessDyHeaderAnimator businessDyHeaderAnimator = BusinessDyHeaderAnimator.this;
                businessDyHeaderAnimator.setAnimatedY((float) businessDyHeaderAnimator.f39779b.getCurrY());
                BusinessDyHeaderAnimator.this.m28364a((Runnable) this);
                if (BusinessDyHeaderAnimator.this.f39787j != null) {
                    BusinessDyHeaderAnimator.this.f39787j.onCollapseUpdated();
                }
            } else if (BusinessDyHeaderAnimator.this.f39787j != null) {
                BusinessDyHeaderAnimator.this.f39787j.onCollapseFinished();
                OnHeaderCollapseListener unused = BusinessDyHeaderAnimator.this.f39787j = null;
            }
            if (BusinessDyHeaderAnimator.this.f39786i != null) {
                BusinessDyHeaderAnimator.this.f39786i.onDependentViewChanged();
            }
        }
    };

    public interface DependentViewChangedCallback {
        void onDependentViewChanged();
    }

    public int getShadowHeight() {
        return 0;
    }

    public void setDependentViewChangedCallback(BusinessHeaderAnimator.DependentViewChangedCallback dependentViewChangedCallback) {
    }

    BusinessDyHeaderAnimator(View view) {
        this.f39779b = new Scroller(view.getContext());
        ButterKnife.bind((Object) this, view);
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f39788m = scopeContext;
    }

    public void collapseHeader() {
        if (getAnimatedProgress() < 1.0f) {
            this.f39779b.startScroll(0, (int) this.f39778a, 0, (int) (getMaxAnimatedY() - this.f39778a));
            m28364a(this.f39789n);
        }
    }

    public void collapseHeader(OnHeaderCollapseListener onHeaderCollapseListener) {
        if (getAnimatedProgress() < 1.0f) {
            if (onHeaderCollapseListener != null) {
                this.f39787j = onHeaderCollapseListener;
            }
            this.f39779b.startScroll(0, (int) this.f39778a, 0, (int) (getMaxAnimatedY() - this.f39778a));
            m28364a(this.f39789n);
        }
    }

    public void expandHeader() {
        if (getAnimatedProgress() > 0.0f) {
            Scroller scroller = this.f39779b;
            float f = this.f39778a;
            scroller.startScroll(0, (int) f, 0, (int) (-f));
            m28364a(this.f39789n);
        }
    }

    public float getAnimatedProgress() {
        return Math.min(1.0f, Math.abs(this.f39778a / getMaxAnimatedY()));
    }

    public float getAnimatedY() {
        return this.f39778a;
    }

    public void setAnimatedY(float f) {
        this.f39778a = f;
        m28362a(getAnimatedProgress());
    }

    public float getMaxAnimatedY() {
        return (float) (-this.f39780c.totalOffset);
    }

    public void recordAnimationSpec() {
        if (!this.f39780c.recorded || this.f39781d) {
            this.mStickyNameTv.getLocationInWindow(new int[2]);
            this.f39780c.totalOffset = (this.mHeaderCardContainer.getTop() + this.mHeaderCardContainer.getHeight()) - this.mStickyNavigationView.getNavigationTitleHeight();
            this.f39780c.logoOffset = this.mBusinessLogo.getTop();
            this.f39780c.maskOffset = this.mHeaderCardContainer.getHeight();
            this.f39780c.navigationStartOffset = (this.mHeaderCardContainer.getTop() - this.mCloseIcon.getTop()) - this.mCloseIcon.getHeight();
            this.f39780c.recorded = true;
            this.f39781d = false;
        }
    }

    public void updateRecordState(boolean z) {
        this.f39781d = z;
    }

    public boolean isExpanded() {
        return Math.abs(this.f39778a) < 8.0f;
    }

    public boolean isCollapsed() {
        return getAnimatedProgress() == 1.0f;
    }

    public void setOnHeaderStateChangeListener(OnHeaderStateChangeListener onHeaderStateChangeListener) {
        this.f39785h = onHeaderStateChangeListener;
    }

    public void setDependentViewDyChangedCallback(DependentViewChangedCallback dependentViewChangedCallback) {
        this.f39786i = dependentViewChangedCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28364a(Runnable runnable) {
        this.mHeaderCardContainer.postOnAnimation(runnable);
    }

    /* renamed from: a */
    private void m28362a(float f) {
        LogUtil.m29100d(SidConverter.BUSINESS_STR, "fraction: " + f);
        float max = (float) ((int) Math.max((float) ((int) this.f39778a), getMaxAnimatedY()));
        this.mLogoContainer.setTranslationY(max);
        this.mHeaderBackgroundImg.setAlpha(1.0f - (Math.abs(this.f39778a) / ((float) this.f39780c.maskOffset)));
        this.mHeaderCardContainer.setTranslationY(max);
        this.mHeaderCardShadowView.setTranslationY(max);
        this.mClassifyTabContainer.setTranslationY(max);
        this.mClassifyBLayout.setBackgroundResource(f >= f39776k ? R.color.rf_color_v2_grey2_10_a100 : R.color.rf_color_v2_grey4_1_a100);
        m28366b(f);
        OnHeaderStateChangeListener onHeaderStateChangeListener = this.f39785h;
        if (onHeaderStateChangeListener != null) {
            if (f >= 0.7f) {
                onHeaderStateChangeListener.onHeaderStateChanged(true);
            } else {
                onHeaderStateChangeListener.onHeaderStateChanged(false);
            }
        }
        DependentViewChangedCallback dependentViewChangedCallback = this.f39786i;
        if (dependentViewChangedCallback != null) {
            dependentViewChangedCallback.onDependentViewChanged();
        }
    }

    /* renamed from: b */
    private void m28366b(float f) {
        float abs = (Math.abs(this.f39778a) - ((float) this.f39780c.navigationStartOffset)) / ((float) Math.abs(this.f39780c.totalOffset - this.f39780c.navigationStartOffset));
        LogUtil.m29100d(SidConverter.BUSINESS_STR, "naviFraction: " + abs + "mAnimatedY:" + this.f39778a + "naviStartOffset:" + this.f39780c.navigationStartOffset + "naviTotalOffset:" + this.f39780c.totalOffset);
        if (Math.abs(this.f39778a) >= ((float) this.f39780c.navigationStartOffset)) {
            this.mStickyNavigationView.setAlpha(abs);
            this.mStickyNavigationView.setVisibility(0);
            this.mTitleContainer.setAlpha(1.0f - abs);
        } else {
            this.mStickyNavigationView.setAlpha(0.0f);
            this.mStickyNavigationView.setVisibility(4);
            this.mTitleContainer.setAlpha(1.0f);
        }
        if (abs >= f39776k) {
            this.mStickyNavigationView.setAlpha(1.0f);
            this.mTitleContainer.setAlpha(0.0f);
            this.mTitleContainer.setVisibility(4);
            if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
                this.mClassifyALayout.setAlpha(1.0f - f);
                this.mClassifyALayout.setVisibility(4);
                this.mClassifyBLayout.setAlpha(f);
                this.mClassifyBLayout.setVisibility(0);
            }
            this.mClassifyBLayout.showClassifyTabSelectedColor(true);
            return;
        }
        this.mTitleContainer.setVisibility(0);
        if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
            this.mClassifyALayout.setAlpha(1.0f);
            this.mClassifyALayout.setVisibility(0);
            this.mClassifyBLayout.setAlpha(0.0f);
            this.mClassifyBLayout.setVisibility(4);
        }
        this.mClassifyBLayout.showClassifyTabSelectedColor(false);
    }

    private static class MeasurementRecordModel {
        int logoOffset;
        int maskOffset;
        int navigationStartOffset;
        boolean recorded;
        int totalOffset;

        private MeasurementRecordModel() {
            this.recorded = false;
            this.totalOffset = -1;
            this.navigationStartOffset = -1;
            this.logoOffset = -1;
            this.maskOffset = -1;
        }
    }
}
