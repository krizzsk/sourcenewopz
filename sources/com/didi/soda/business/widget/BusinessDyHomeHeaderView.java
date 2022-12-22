package com.didi.soda.business.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewConfigurationCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessHeaderDyViewTipHelper;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;
import java.util.HashMap;

public class BusinessDyHomeHeaderView extends ConstraintLayout {

    /* renamed from: a */
    private static final String f39791a = "BusinessHomeHeaderView";

    /* renamed from: b */
    private static final long f39792b = 1000;

    /* renamed from: c */
    private static final long f39793c = 51;

    /* renamed from: d */
    private static final long f39794d = 42;
    public BusinessHeaderDyViewTipHelper businessHeaderViewTipHelper;
    public BusinessCategoryRvModel currentCategoryRvModel;

    /* renamed from: e */
    private long f39795e;

    /* renamed from: f */
    private IBusinessHeaderAnimator f39796f;

    /* renamed from: g */
    private float f39797g;

    /* renamed from: h */
    private float f39798h;

    /* renamed from: i */
    private int f39799i;

    /* renamed from: j */
    private int[] f39800j = new int[2];

    /* renamed from: k */
    private int[] f39801k = new int[2];

    /* renamed from: l */
    private NestedScrollingChildHelper f39802l;
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
    @BindView(18132)
    FrameLayout mFavorContainerView;
    @BindView(18351)
    RFIconView mFavorImageIv;
    @BindView(17977)
    LottieLoadingView mFavorLoadingView;
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
    @BindView(18402)
    IconTextView mShimmerTitleFavorDelegate;
    @BindView(18805)
    TextView mStickyNameTv;
    @BindView(18103)
    BusinessDyStickyNavigationView mStickyNavigationView;
    @BindView(17835)
    ConstraintLayout mTitleContainer;

    public interface OnBusinessTabItemListener {
        void onMoreTabExposure();

        void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel);

        void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2);
    }

    public interface OnHeaderClickListener {
        void onFavorClicked(boolean z);

        void onFavorLogin();

        void onMoreClicked();

        void onSearchClicked();
    }

    public BusinessDyHomeHeaderView(Context context) {
        super(context);
        m28369a();
    }

    public BusinessDyHomeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28369a();
    }

    public BusinessDyHomeHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28369a();
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f39796f.bindScopeContext(scopeContext);
    }

    public void setCategoryClickListener(final OnMoreCategoryListener onMoreCategoryListener) {
        this.mClassifyBLayout.setCategoryClickListener(onMoreCategoryListener);
        this.mClassifyALayout.setMenuClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnMoreCategoryListener onMoreCategoryListener = onMoreCategoryListener;
                if (onMoreCategoryListener != null) {
                    onMoreCategoryListener.onClickMoreCategoryListener(new BusinessSelectedCallback() {
                        public void onSelectedCategory(int i) {
                            BusinessDyHomeHeaderView.this.mClassifyBLayout.selectTab(i, false);
                        }
                    });
                }
            }
        });
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnBackListener.this.onBack(0);
            }
        });
        this.mStickyNavigationView.setOnBackListener(onBackListener);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        $$Lambda$BusinessDyHomeHeaderView$v4_h5pi4t1_CxxRwUnqaZz_TA0 r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDyHomeHeaderView.OnHeaderClickListener.this.onSearchClicked();
            }
        };
        $$Lambda$BusinessDyHomeHeaderView$r2eYGHUTgV43CNfiTO6FPaw9is r1 = new View.OnClickListener(onHeaderClickListener) {
            public final /* synthetic */ BusinessDyHomeHeaderView.OnHeaderClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessDyHomeHeaderView.this.m28376b(this.f$1, view);
            }
        };
        $$Lambda$BusinessDyHomeHeaderView$FuOieHg5oO0j_CE4kz0dQNE6rU r2 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDyHomeHeaderView.OnHeaderClickListener.this.onMoreClicked();
            }
        };
        this.mSearchIcon.setOnClickListener(r0);
        this.mFavorContainerView.setOnClickListener(r1);
        this.mBusinessLogo.setOnClickListener(r2);
        this.mStickyNavigationView.setOnSearchClickListener(r0);
        this.mClassifyALayout.setOnSearchClickListener(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28376b(OnHeaderClickListener onHeaderClickListener, View view) {
        if (!m28377b()) {
            if (!LoginUtil.isLogin()) {
                onHeaderClickListener.onFavorLogin();
                return;
            }
            boolean z = !view.isSelected();
            handleFavor(z ? 1 : 0, true);
            onHeaderClickListener.onFavorClicked(z);
        }
    }

    public void setTabItemListener(OnBusinessTabItemListener onBusinessTabItemListener) {
        this.mClassifyBLayout.setTabItemListener(onBusinessTabItemListener);
    }

    public void setOnCategoryTouchListener(View.OnTouchListener onTouchListener) {
        this.mClassifyBLayout.setOnCategoryTouchListener(onTouchListener);
    }

    public void setOnCategoryScrollListener(CustomerTabLayout.OnScollChangedListener onScollChangedListener) {
        this.mClassifyBLayout.setOnCategoryScrollListener(onScollChangedListener);
    }

    public void updateBusinessHeaderView(BusinessHeaderRvModel businessHeaderRvModel, IBlockScope iBlockScope) {
        String str;
        setVisibility(0);
        getHeaderAnimator().updateRecordState(true);
        this.mStickyNameTv.setText(businessHeaderRvModel.mBusinessName);
        m28375b(businessHeaderRvModel);
        handleFavor(businessHeaderRvModel.isFavor, false);
        m28378c(businessHeaderRvModel);
        m28371a(businessHeaderRvModel);
        setVisibility(0);
        if (businessHeaderRvModel.componentModel == null || businessHeaderRvModel.componentModel.getWidgetNodeModel() == null) {
            this.mHeaderCardContainer.setVisibility(4);
            LogUtil.m29100d(f39791a, "配置化数据解析失败");
            if (businessHeaderRvModel.componentModel == null) {
                str = "componentModel = null";
            } else {
                str = businessHeaderRvModel.componentModel.getWidgetNodeModel() == null ? "getWidgetNodeModel = null" : "";
            }
            ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_M_SHOP_HEADER_DY_ERROR).addModuleName("shop").addErrorType(str);
            addErrorType.addErrorType("updateBusinessHeaderView" + str).addErrorMsg("updateBusinessHeaderView 配置化数据解析失败").build().trackError();
        } else {
            View view = BlocksEngine.Companion.getInstance().renderViewWithData(getContext(), iBlockScope, businessHeaderRvModel.componentModel.getWidgetNodeModel(), (BinderRootConfig<?>) null).getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.mHeaderCardContainer.setVisibility(0);
            this.mHeaderCardContainer.removeAllViews();
            this.mHeaderCardContainer.addView(view);
        }
        m28380d(businessHeaderRvModel);
        m28381e(businessHeaderRvModel);
    }

    public void selectTab(int i) {
        this.mClassifyBLayout.selectTab(i);
    }

    public IBusinessHeaderAnimator getHeaderAnimator() {
        return this.f39796f;
    }

    public BusinessHeaderDyViewTipHelper getBusinessHeaderViewTipHelper() {
        if (this.businessHeaderViewTipHelper == null) {
            this.businessHeaderViewTipHelper = new BusinessHeaderDyViewTipHelper(this);
        }
        return this.businessHeaderViewTipHelper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0 != 3) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 == r2) goto L_0x0032
            if (r0 == r1) goto L_0x0010
            r4 = 3
            if (r0 == r4) goto L_0x0032
            goto L_0x0045
        L_0x0010:
            r4.getX()
            float r0 = r4.getY()
            float r1 = r3.f39798h
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r3.f39799i
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            float r0 = r4.getX()
            r3.f39797g = r0
            float r4 = r4.getY()
            r3.f39798h = r4
            goto L_0x0046
        L_0x0032:
            r3.stopNestedScroll()
            goto L_0x0045
        L_0x0036:
            float r0 = r4.getX()
            r3.f39797g = r0
            float r4 = r4.getY()
            r3.f39798h = r4
            r3.startNestedScroll(r1)
        L_0x0045:
            r2 = 0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.widget.BusinessDyHomeHeaderView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    dispatchNestedPreScroll((int) (this.f39797g - motionEvent.getX()), (int) (this.f39798h - motionEvent.getY()), this.f39801k, this.f39800j);
                    this.f39797g = motionEvent.getX();
                    this.f39798h = motionEvent.getY();
                    return false;
                } else if (action != 3) {
                    return false;
                }
            }
            this.f39797g = 0.0f;
            this.f39798h = 0.0f;
            return false;
        }
        this.f39797g = motionEvent.getX();
        this.f39798h = motionEvent.getY();
        startNestedScroll(2);
        return false;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f39802l.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f39802l.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f39802l.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f39802l.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f39802l.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f39802l.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f39802l.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f39802l.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f39802l.dispatchNestedPreFling(f, f2);
    }

    public void handleFavor(int i, boolean z) {
        if (i == -1) {
            this.mFavorContainerView.setVisibility(8);
            this.mFavorImageIv.setVisibility(8);
            this.mShimmerTitleFavorDelegate.setVisibility(8);
            this.mFavorLoadingView.setVisibility(8);
            this.mFavorContainerView.setSelected(false);
        } else if (i == 0) {
            this.mFavorContainerView.setVisibility(0);
            this.mFavorImageIv.setVisibility(0);
            this.mFavorImageIv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_collection));
            this.mShimmerTitleFavorDelegate.setVisibility(4);
            this.mFavorLoadingView.hide();
            this.mFavorContainerView.setSelected(false);
        } else if (i == 1) {
            this.mFavorContainerView.setVisibility(0);
            this.mFavorContainerView.setSelected(true);
            this.mShimmerTitleFavorDelegate.setVisibility(4);
            if (z) {
                this.mFavorImageIv.setVisibility(8);
                this.mFavorLoadingView.setVisibility(0);
                this.mFavorLoadingView.show();
                ToastUtil.showCustomerSuccessToast((ScopeContext) null, ResourceHelper.getString(R.string.FoodC_collection_Collection_you_Ybgv));
                return;
            }
            this.mFavorLoadingView.setVisibility(8);
            this.mFavorImageIv.setVisibility(0);
            this.mFavorImageIv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_collection));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHeaderAnimator().recordAnimationSpec();
    }

    /* renamed from: a */
    private void m28371a(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout constraintLayout = this.mTitleContainer;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), businessHeaderRvModel.mDynamicPadding + DisplayUtils.dip2px(getContext(), 12.0f), this.mTitleContainer.getPaddingRight(), this.mTitleContainer.getPaddingBottom());
    }

    /* renamed from: b */
    private void m28375b(BusinessHeaderRvModel businessHeaderRvModel) {
        if (!TextUtils.isEmpty(businessHeaderRvModel.mDyHeadImgUrl)) {
            FlyImageLoader.loadImageUnspecified(getContext(), businessHeaderRvModel.mDyHeadImgUrl).placeholder((int) R.drawable.customer_img_dy_business_header).error((int) R.drawable.customer_img_dy_business_header).dontAnimate().into(this.mHeaderBackgroundImg);
            this.mHeaderBackgroundImg.setVisibility(0);
            return;
        }
        this.mHeaderBackgroundImg.setVisibility(8);
    }

    /* renamed from: c */
    private void m28378c(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mLogoContainer.getLayoutParams();
        layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 10.0f) + businessHeaderRvModel.mDynamicPadding;
        this.mLogoContainer.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(businessHeaderRvModel.mDyLogoUrl)) {
            FlyImageLoader.loadImage1x1(getContext(), businessHeaderRvModel.mDyLogoUrl).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).error((int) R.drawable.customer_skin_img_business_goods_item_x11).dontAnimate().into(this.mBusinessLogo);
            this.mBusinessLogo.setVisibility(0);
            this.mLogoContainer.setVisibility(0);
            return;
        }
        this.mBusinessLogo.setVisibility(4);
        this.mLogoContainer.setVisibility(4);
    }

    /* renamed from: a */
    private void m28369a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_home_header, this, true);
        ButterKnife.bind((Object) this, inflate);
        this.f39796f = new BusinessDyHeaderAnimator(inflate);
        this.f39799i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(inflate.getContext()));
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.f39802l = nestedScrollingChildHelper;
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.mHeaderBackgroundImg.setClickable(false);
        setClickable(false);
        this.businessHeaderViewTipHelper = new BusinessHeaderDyViewTipHelper(this);
    }

    /* renamed from: a */
    private void m28374a(String str) {
        LogUtil.m29100d(f39791a, str);
    }

    /* renamed from: b */
    private boolean m28377b() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.f39795e < 1000;
        if (!z) {
            this.f39795e = currentTimeMillis;
        }
        return z;
    }

    /* renamed from: d */
    private void m28380d(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mHeaderCardContainer.getLayoutParams();
        layoutParams.height = -2;
        this.mHeaderCardContainer.setLayoutParams(layoutParams);
    }

    public void showDeliveryFeeDescRule(HashMap<String, Object> hashMap, View view) {
        BusinessDeliveryFeeTipsManager.Companion.getInstance().showDeliveryFeeTips(hashMap, this.mHeaderCardContainer, view, getContext());
    }

    /* renamed from: e */
    private void m28381e(BusinessHeaderRvModel businessHeaderRvModel) {
        if (businessHeaderRvModel != null) {
            this.mStickyNavigationView.updateBusinessHeaderView(businessHeaderRvModel);
            this.mStickyNavigationView.setVisibility(4);
            this.mClassifyBLayout.updateBusinessCategoryData(businessHeaderRvModel);
            this.mHeaderCardShadowView.setVisibility(0);
            int dip2px = DisplayUtils.dip2px(getContext(), 17.0f);
            if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
                this.mClassifyALayout.setVisibility(0);
                this.mClassifyBLayout.setVisibility(4);
                this.mSearchIcon.setVisibility(8);
                this.mHeaderCardShadowView.setBackgroundResource(R.color.rf_color_white_100);
            } else {
                this.mClassifyALayout.setVisibility(8);
                this.mClassifyBLayout.setVisibility(0);
                this.mSearchIcon.setVisibility(0);
                this.mHeaderCardShadowView.setBackgroundResource(R.drawable.customer_shape_header_card_shadow);
            }
            this.mClassifyTabContainer.setVisibility(0);
            m28370a(dip2px);
        }
    }

    /* renamed from: a */
    private void m28370a(int i) {
        FrameLayout frameLayout = this.mHeaderCardContainer;
        frameLayout.setPadding(frameLayout.getPaddingLeft(), this.mHeaderCardContainer.getPaddingTop(), this.mHeaderCardContainer.getPaddingRight(), this.mHeaderCardContainer.getPaddingBottom() + i);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mHeaderCardShadowView.getLayoutParams();
        layoutParams.bottomMargin += i;
        this.mHeaderCardShadowView.setLayoutParams(layoutParams);
    }
}
