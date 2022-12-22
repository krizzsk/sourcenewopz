package com.didi.soda.business.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.business.manager.BusinessHeaderViewTipHelper;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessHomeHeaderView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSideSpacingSpan;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.business.BusinessMarketingTipTagView;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.headerview.OnTabExposureListener;
import com.didi.soda.customer.widget.headerview.OnTabSelectedListener;
import com.didi.soda.customer.widget.headerview.TabAdapter;
import com.didi.soda.customer.widget.headerview.tabitem.BusinessClassifyTab;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.topgun.widget.HomeBusinessExceptionStatusView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rui.config.RConfigConstants;

public class BusinessHomeHeaderView extends ConstraintLayout {

    /* renamed from: a */
    private static final String f39820a = "BusinessHomeHeaderView";

    /* renamed from: b */
    private static final long f39821b = 1000;

    /* renamed from: c */
    private static final long f39822c = 51;

    /* renamed from: d */
    private static final long f39823d = 42;
    public BusinessHeaderViewTipHelper businessHeaderViewTipHelper;
    public BusinessCategoryRvModel currentCategoryRvModel;

    /* renamed from: e */
    private OnBusinessTabItemListener f39824e;

    /* renamed from: f */
    private OnMoreCategoryListener f39825f;

    /* renamed from: g */
    private OnBusinessAttentionListener f39826g;

    /* renamed from: h */
    private long f39827h;

    /* renamed from: i */
    private IBusinessHeaderAnimator f39828i;

    /* renamed from: j */
    private float f39829j;

    /* renamed from: k */
    private float f39830k;

    /* renamed from: l */
    private int f39831l;

    /* renamed from: m */
    private int[] f39832m = new int[2];
    @BindView(17830)
    View mAttentionInfoContainer;
    @BindView(18778)
    TextView mAttentionInfoContentTv;
    @BindView(18340)
    ImageView mAttentionInfoImageIv;
    @BindView(19224)
    View mAttentionMaskContainer;
    @BindView(17933)
    HomeBusinessExceptionStatusView mBusinessExceptionStatusView;
    @BindView(17936)
    ImageView mBusinessLogo;
    @BindView(18002)
    NovaFlowLayout mBusinessMarketingTips;
    @BindView(17937)
    TailIconTextView mBusinessNameTv;
    @BindView(18806)
    public CustomerAppCompatTextView mBusinessTabTipTv;
    @BindView(17931)
    CustomerTabLayout mClassifyTab;
    @BindView(18506)
    RelativeLayout mClassifyTabContainer;
    @BindView(18350)
    IconTextView mCloseIcon;
    @BindView(18797)
    TextView mDeliveryTv;
    @BindView(18132)
    FrameLayout mFavorContainerView;
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
    @BindView(17984)
    TextView mHeaderMoreTv;
    @BindView(18800)
    View mMoreClassifyBtn;
    @BindView(18352)
    IconTextView mSearchIcon;
    @BindView(18402)
    IconTextView mShimmerTitleFavorDelegate;
    @BindView(18805)
    TextView mStickyNameTv;
    @BindView(17835)
    ConstraintLayout mTitleContainer;

    /* renamed from: n */
    private int[] f39833n = new int[2];

    /* renamed from: o */
    private NestedScrollingChildHelper f39834o;

    public interface OnBusinessAttentionListener {
        void onAttentionClick();

        void onAttentionShow();
    }

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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m28398a(View view) {
    }

    public BusinessHomeHeaderView(Context context) {
        super(context);
        m28415c();
    }

    public BusinessHomeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28415c();
    }

    public BusinessHomeHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28415c();
    }

    public void setOnAttentionListener(OnBusinessAttentionListener onBusinessAttentionListener) {
        this.f39826g = onBusinessAttentionListener;
    }

    public void setCategoryClickListener(OnMoreCategoryListener onMoreCategoryListener) {
        this.f39825f = onMoreCategoryListener;
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnBackListener.this.onBack(0);
            }
        });
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        $$Lambda$BusinessHomeHeaderView$CGaaE7x46W5ZSWMzdkzjARXExko r0 = new View.OnClickListener(onHeaderClickListener) {
            public final /* synthetic */ BusinessHomeHeaderView.OnHeaderClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessHomeHeaderView.this.m28417c(this.f$1, view);
            }
        };
        $$Lambda$BusinessHomeHeaderView$qnhr62jLAjLMjjjRpWcQLaMjVZs r1 = new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessHomeHeaderView.OnHeaderClickListener.this.onSearchClicked();
            }
        };
        $$Lambda$BusinessHomeHeaderView$rM7_VM1oXH0OUBh550ihjncfkLc r2 = new View.OnClickListener(onHeaderClickListener) {
            public final /* synthetic */ BusinessHomeHeaderView.OnHeaderClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessHomeHeaderView.this.m28406a(this.f$1, view);
            }
        };
        this.mHeaderCardContainer.setOnClickListener(r0);
        this.mSearchIcon.setOnClickListener(r1);
        this.mFavorContainerView.setOnClickListener(r2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m28417c(OnHeaderClickListener onHeaderClickListener, View view) {
        if (getHeaderAnimator().isExpanded()) {
            onHeaderClickListener.onMoreClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28406a(OnHeaderClickListener onHeaderClickListener, View view) {
        if (!m28420d()) {
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
        this.f39824e = onBusinessTabItemListener;
    }

    public void setOnCategoryTouchListener(View.OnTouchListener onTouchListener) {
        this.mClassifyTab.setOnTouchListener(onTouchListener);
    }

    public void setOnCategoryScrollListener(CustomerTabLayout.OnScollChangedListener onScollChangedListener) {
        this.mClassifyTab.setCustomerOnScrollChanedListener(onScollChangedListener);
    }

    public void updateBusinessHeaderView(BusinessHeaderRvModel businessHeaderRvModel) {
        setVisibility(0);
        getHeaderAnimator().updateRecordState(true);
        m28401a(businessHeaderRvModel);
        this.mStickyNameTv.setText(businessHeaderRvModel.mBusinessName);
        boolean a = m28408a(businessHeaderRvModel.mBusinessName);
        m28416c(businessHeaderRvModel);
        handleFavor(businessHeaderRvModel.isFavor, false);
        m28421e(businessHeaderRvModel);
        m28425h(businessHeaderRvModel);
        m28405a(businessHeaderRvModel, a);
        m28423f(businessHeaderRvModel);
        m28424g(businessHeaderRvModel);
        m28419d(businessHeaderRvModel);
        m28412b(businessHeaderRvModel);
        setVisibility(0);
    }

    /* renamed from: a */
    private void m28401a(final BusinessHeaderRvModel businessHeaderRvModel) {
        if (!TextUtils.isEmpty(businessHeaderRvModel.mHonorIconUrl)) {
            this.mBusinessNameTv.setTextTail(businessHeaderRvModel.mBusinessName, new ColorDrawable(getContext().getResources().getColor(R.color.transparent)));
            FlyImageLoader.loadImageDownLoadOnly(getContext(), FitType.FIT_None, businessHeaderRvModel.mHonorIconUrl).downloadOnly(new ImageDownloadListener() {
                public void onSuccess(File file) {
                    UiHandlerUtil.post(new Runnable(businessHeaderRvModel, new BitmapDrawable(BitmapUtil.convertFileToBitmap(file))) {
                        public final /* synthetic */ BusinessHeaderRvModel f$1;
                        public final /* synthetic */ BitmapDrawable f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            BusinessHomeHeaderView.C135131.this.lambda$onSuccess$0$BusinessHomeHeaderView$1(this.f$1, this.f$2);
                        }
                    });
                }

                public /* synthetic */ void lambda$onSuccess$0$BusinessHomeHeaderView$1(BusinessHeaderRvModel businessHeaderRvModel, BitmapDrawable bitmapDrawable) {
                    BusinessHomeHeaderView.this.mBusinessNameTv.setTextTail(businessHeaderRvModel.mBusinessName, bitmapDrawable);
                }

                public void onFailure(Exception exc) {
                    UiHandlerUtil.post(new Runnable(businessHeaderRvModel) {
                        public final /* synthetic */ BusinessHeaderRvModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            BusinessHomeHeaderView.C135131.this.lambda$onFailure$1$BusinessHomeHeaderView$1(this.f$1);
                        }
                    });
                }

                public /* synthetic */ void lambda$onFailure$1$BusinessHomeHeaderView$1(BusinessHeaderRvModel businessHeaderRvModel) {
                    BusinessHomeHeaderView.this.mBusinessNameTv.setTextTail(businessHeaderRvModel.mBusinessName, BusinessHomeHeaderView.this.getContext().getResources().getDrawable(R.drawable.customer_skin_img_business_goods_item_x11));
                }
            });
        } else {
            this.mBusinessNameTv.setText(businessHeaderRvModel.mBusinessName);
        }
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mBusinessNameTv, IToolsService.FontType.MEDIUM);
    }

    public void selectTab(int i) {
        CustomerTabLayout customerTabLayout = this.mClassifyTab;
        if (customerTabLayout != null) {
            customerTabLayout.selectTab(i);
        }
    }

    public IBusinessHeaderAnimator getHeaderAnimator() {
        return this.f39828i;
    }

    public BusinessHeaderViewTipHelper getBusinessHeaderViewTipHelper() {
        if (this.businessHeaderViewTipHelper == null) {
            this.businessHeaderViewTipHelper = new BusinessHeaderViewTipHelper(this);
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
            float r1 = r3.f39830k
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r1 = r3.f39831l
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            float r0 = r4.getX()
            r3.f39829j = r0
            float r4 = r4.getY()
            r3.f39830k = r4
            goto L_0x0046
        L_0x0032:
            r3.stopNestedScroll()
            goto L_0x0045
        L_0x0036:
            float r0 = r4.getX()
            r3.f39829j = r0
            float r4 = r4.getY()
            r3.f39830k = r4
            r3.startNestedScroll(r1)
        L_0x0045:
            r2 = 0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.widget.BusinessHomeHeaderView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    dispatchNestedPreScroll((int) (this.f39829j - motionEvent.getX()), (int) (this.f39830k - motionEvent.getY()), this.f39833n, this.f39832m);
                    this.f39829j = motionEvent.getX();
                    this.f39830k = motionEvent.getY();
                    return false;
                } else if (action != 3) {
                    return false;
                }
            }
            this.f39829j = 0.0f;
            this.f39830k = 0.0f;
            return false;
        }
        this.f39829j = motionEvent.getX();
        this.f39830k = motionEvent.getY();
        startNestedScroll(2);
        return false;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f39834o.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f39834o.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f39834o.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f39834o.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f39834o.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f39834o.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f39834o.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f39834o.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f39834o.dispatchNestedPreFling(f, f2);
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
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.customer_common_icon_collection));
            this.mShimmerTitleFavorDelegate.setVisibility(4);
            this.mFavorLoadingView.hide();
            this.mFavorContainerView.setSelected(false);
        } else if (i == 1) {
            m28394a();
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
            this.mFavorImageIv.setText(ResourceHelper.getString(R.string.customer_common_icon_collected));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHeaderAnimator().recordAnimationSpec();
    }

    /* renamed from: a */
    private void m28394a() {
        if (getHeaderAnimator().isCollapsed()) {
            this.mFavorLoadingView.setAnimation((int) R.raw.customer_favor_black);
        } else {
            this.mFavorLoadingView.setAnimation((int) R.raw.customer_favor);
        }
    }

    /* renamed from: a */
    private boolean m28408a(String str) {
        return ((int) this.mBusinessNameTv.getPaint().measureText(str)) <= (DisplayUtils.getScreenWidth(getContext()) - this.mHeaderCardContainer.getPaddingLeft()) - this.mHeaderCardContainer.getPaddingRight();
    }

    /* renamed from: b */
    private void m28412b(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout constraintLayout = this.mTitleContainer;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), businessHeaderRvModel.mDynamicPadding, this.mTitleContainer.getPaddingRight(), this.mTitleContainer.getPaddingBottom());
    }

    /* renamed from: a */
    private void m28405a(BusinessHeaderRvModel businessHeaderRvModel, boolean z) {
        this.mDeliveryTv.setText(businessHeaderRvModel.mDeliveryInfo);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDeliveryTv.getLayoutParams();
        if (z) {
            marginLayoutParams.topMargin = DisplayUtils.dip2px(getContext(), 10.0f);
        } else {
            marginLayoutParams.topMargin = DisplayUtils.dip2px(getContext(), 6.0f);
        }
        this.mDeliveryTv.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: c */
    private void m28416c(BusinessHeaderRvModel businessHeaderRvModel) {
        if (!TextUtils.isEmpty(businessHeaderRvModel.mHeadImgUrl)) {
            FlyImageLoader.loadImage4x3(getContext(), businessHeaderRvModel.mHeadImgUrl).centerCrop().dontAnimate().into(this.mHeaderBackgroundImg);
            this.mHeaderBackgroundImg.setVisibility(0);
            return;
        }
        this.mHeaderBackgroundImg.setVisibility(8);
    }

    /* renamed from: a */
    private void m28396a(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        OnBusinessTabItemListener onBusinessTabItemListener = this.f39824e;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemExposure(i, businessCategoryRvModel);
        }
    }

    /* renamed from: a */
    private void m28397a(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        OnBusinessTabItemListener onBusinessTabItemListener = this.f39824e;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemSelected(i, businessCategoryRvModel, z, z2);
        }
    }

    /* renamed from: d */
    private void m28419d(final BusinessHeaderRvModel businessHeaderRvModel) {
        if (businessHeaderRvModel.mCategoryList == null || businessHeaderRvModel.mCategoryList.isEmpty()) {
            this.mClassifyTabContainer.setVisibility(8);
            return;
        }
        this.mClassifyTabContainer.setVisibility(0);
        this.mClassifyTab.setTabAdapter(new TabAdapter<BusinessCategoryRvModel>() {
            public ITab<BusinessCategoryRvModel> getItemView(int i) {
                return new BusinessClassifyTab(BusinessHomeHeaderView.this.getContext());
            }

            public int getItemCount() {
                if (businessHeaderRvModel.mCategoryList == null) {
                    return 0;
                }
                return businessHeaderRvModel.mCategoryList.size();
            }

            public List<BusinessCategoryRvModel> getData() {
                return businessHeaderRvModel.mCategoryList;
            }
        });
        this.mClassifyTab.setOnTabSelectedListener(new OnTabSelectedListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabSelected(int i, boolean z, boolean z2) {
                BusinessHomeHeaderView.this.m28403a(this.f$1, i, z, z2);
            }
        });
        this.mClassifyTab.setOnTabExposureListener(new OnTabExposureListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabItemExposure(int i) {
                BusinessHomeHeaderView.this.m28402a(this.f$1, i);
            }
        });
        if (businessHeaderRvModel.mCategoryList.size() >= 4) {
            this.mMoreClassifyBtn.setVisibility(0);
            this.mMoreClassifyBtn.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessHomeHeaderView.this.m28411b(view);
                }
            });
            m28410b();
            return;
        }
        this.mMoreClassifyBtn.setVisibility(8);
        this.mMoreClassifyBtn.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28403a(BusinessHeaderRvModel businessHeaderRvModel, int i, boolean z, boolean z2) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            this.currentCategoryRvModel = businessHeaderRvModel.mCategoryList.get(i);
            m28397a(i, businessHeaderRvModel.mCategoryList.get(i), z, z2);
            getBusinessHeaderViewTipHelper().setCurrentTipVisable(BusinessDataHelper.getBusinessCategoryTipString(businessHeaderRvModel.mCategoryList.get(i)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28402a(BusinessHeaderRvModel businessHeaderRvModel, int i) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            m28396a(i, businessHeaderRvModel.mCategoryList.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28411b(View view) {
        if (this.f39825f != null) {
            this.f39825f.onClickMoreCategoryListener(new BusinessSelectedCallback() {
                public final void onSelectedCategory(int i) {
                    BusinessHomeHeaderView.this.m28395a(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28395a(int i) {
        this.mClassifyTab.selectTab(i, false);
    }

    /* renamed from: b */
    private void m28410b() {
        OnBusinessTabItemListener onBusinessTabItemListener = this.f39824e;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onMoreTabExposure();
        }
    }

    /* renamed from: e */
    private void m28421e(BusinessHeaderRvModel businessHeaderRvModel) {
        if (BusinessDataHelper.checkBusinessStatusNormal(businessHeaderRvModel.mStatus)) {
            this.mBusinessExceptionStatusView.setVisibility(8);
            this.mHeaderBgMask.setBackgroundResource(R.drawable.customer_shape_bg_business_header_img_mask);
            this.mHeaderBgMask.setAlpha(0.85f);
            return;
        }
        this.mBusinessExceptionStatusView.updateExceptionStatus(businessHeaderRvModel.mStatus, businessHeaderRvModel.mBusinessNextOpenTime);
        this.mBusinessExceptionStatusView.setVisibility(0);
        this.mHeaderBgMask.setBackgroundResource(R.color.rf_color_gery_18_0_66000000);
        this.mHeaderBgMask.setAlpha(1.0f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBusinessExceptionStatusView.getLayoutParams();
        if (BusinessDataHelper.getBusinessExceptionShowStyle(businessHeaderRvModel.mStatus, businessHeaderRvModel.mBusinessNextOpenTime) == 1) {
            marginLayoutParams.bottomMargin = DisplayUtils.dip2px(getContext(), 28.0f);
        } else {
            marginLayoutParams.bottomMargin = DisplayUtils.dip2px(getContext(), 8.0f);
        }
        this.mBusinessExceptionStatusView.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: f */
    private void m28423f(BusinessHeaderRvModel businessHeaderRvModel) {
        TextView textView;
        float f;
        if (!CollectionsUtil.isEmpty(businessHeaderRvModel.mBusinessMarketingTips)) {
            int screenWidth = (((DisplayUtils.getScreenWidth(getContext()) - this.mHeaderCardContainer.getPaddingLeft()) - this.mHeaderCardContainer.getPaddingRight()) - getMoreWidth()) - DisplayUtils.dip2px(getContext(), 6.0f);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (PromptEntity next : businessHeaderRvModel.mBusinessMarketingTips) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                if (!TextUtils.isEmpty(next.tagImg)) {
                    ImageView b = m28409b(next.tagImg);
                    if (b == null) {
                        break;
                    }
                    relativeLayout.addView(b);
                    textView = m28414c(next.content);
                    relativeLayout.addView(textView);
                    m28399a(b, textView);
                    f = textView.getPaint().measureText(next.content) + ((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_51px));
                } else {
                    textView = m28418d(next.content);
                    relativeLayout.addView(textView);
                    f = textView.getPaint().measureText(next.content);
                }
                i = i + ((int) f) + textView.getPaddingLeft() + textView.getPaddingRight() + this.mBusinessMarketingTips.getChildSpacing();
                if (i > screenWidth) {
                    break;
                }
                arrayList.add(relativeLayout);
            }
            this.mBusinessMarketingTips.removeAllViews();
            this.mBusinessMarketingTips.addView(arrayList);
            this.mBusinessMarketingTips.setVisibility(0);
            return;
        }
        this.mBusinessMarketingTips.removeAllViews();
        this.mBusinessMarketingTips.setVisibility(8);
    }

    /* renamed from: b */
    private ImageView m28409b(String str) {
        int identifier = getResources().getIdentifier(str, RConfigConstants.TYPE_DRAWABLE, getContext().getPackageName());
        if (identifier <= 0) {
            return null;
        }
        Drawable drawable = getResources().getDrawable(identifier);
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(6, R.id.customer_shop_coupon_tv_tag);
        layoutParams.addRule(8, R.id.customer_shop_coupon_tv_tag);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(R.id.customer_shop_coupon_iv_tag);
        imageView.setBackground(drawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: a */
    private void m28399a(ImageView imageView, TextView textView) {
        post(new Runnable(textView, imageView) {
            public final /* synthetic */ TextView f$0;
            public final /* synthetic */ ImageView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                BusinessHomeHeaderView.m28400a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m28400a(TextView textView, ImageView imageView) {
        int height = textView.getHeight();
        int i = (int) ((((long) height) * f39822c) / f39823d);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = i;
        imageView.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private TextView m28414c(String str) {
        BusinessMarketingTipTagView businessMarketingTipTagView = new BusinessMarketingTipTagView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        businessMarketingTipTagView.setBackground(getResources().getDrawable(R.drawable.customer_img_shop_coupon_tv));
        businessMarketingTipTagView.setPadding(DisplayUtils.dip2px(getContext(), 4.0f), DisplayUtils.dip2px(getContext(), 4.5f), DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 4.5f));
        layoutParams.addRule(1, R.id.customer_shop_coupon_iv_tag);
        businessMarketingTipTagView.setLayoutParams(layoutParams);
        businessMarketingTipTagView.setId(R.id.customer_shop_coupon_tv_tag);
        businessMarketingTipTagView.setText(str);
        return businessMarketingTipTagView;
    }

    /* renamed from: d */
    private TextView m28418d(String str) {
        BusinessMarketingTipTagView businessMarketingTipTagView = new BusinessMarketingTipTagView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        businessMarketingTipTagView.setPadding(DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 4.5f), DisplayUtils.dip2px(getContext(), 8.0f), DisplayUtils.dip2px(getContext(), 4.5f));
        businessMarketingTipTagView.setLayoutParams(layoutParams);
        businessMarketingTipTagView.setText(str);
        return businessMarketingTipTagView;
    }

    /* renamed from: g */
    private void m28424g(BusinessHeaderRvModel businessHeaderRvModel) {
        if (!BusinessDataHelper.checkBusinessStatusNormal(businessHeaderRvModel.mStatus) || !BusinessDataHelper.hasAttentionContent(businessHeaderRvModel.mAttentionInfoEntity)) {
            this.mAttentionInfoContainer.setVisibility(8);
            this.mAttentionMaskContainer.setVisibility(8);
            return;
        }
        OnBusinessAttentionListener onBusinessAttentionListener = this.f39826g;
        if (onBusinessAttentionListener != null) {
            onBusinessAttentionListener.onAttentionShow();
        }
        this.mAttentionInfoContainer.setVisibility(0);
        this.mAttentionInfoContentTv.setText(businessHeaderRvModel.mAttentionInfoEntity.content);
        FlyImageLoader.loadImage1x1(getContext(), businessHeaderRvModel.mAttentionInfoEntity.imgUrl).dontAnimate().centerCrop().into(this.mAttentionInfoImageIv);
        if (TextUtils.isEmpty(businessHeaderRvModel.mAttentionInfoEntity.redirectUrl)) {
            this.mAttentionInfoContainer.setOnClickListener($$Lambda$BusinessHomeHeaderView$vXMeY5vH4z1aMLrdGC5v1dlEk.INSTANCE);
            this.mAttentionMaskContainer.setVisibility(8);
            return;
        }
        this.mAttentionMaskContainer.setOnClickListener(new View.OnClickListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessHomeHeaderView.this.m28404a(this.f$1, view);
            }
        });
        this.mAttentionMaskContainer.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28404a(BusinessHeaderRvModel businessHeaderRvModel, View view) {
        OnBusinessAttentionListener onBusinessAttentionListener = this.f39826g;
        if (onBusinessAttentionListener != null) {
            onBusinessAttentionListener.onAttentionClick();
        }
        DiRouter.request().path("webPage").putString("url", businessHeaderRvModel.mAttentionInfoEntity.redirectUrl).open();
    }

    /* renamed from: h */
    private void m28425h(BusinessHeaderRvModel businessHeaderRvModel) {
        if (!TextUtils.isEmpty(businessHeaderRvModel.mLogoUrl)) {
            FlyImageLoader.loadImage1x1(getContext(), businessHeaderRvModel.mLogoUrl).placeholder((int) R.drawable.customer_skin_icon_business_round_logo).transform(new RoundedCornersTransformation(getContext(), DisplayUtils.dip2px(getContext(), 6.0f), 0, RoundedCornersTransformation.CornerType.ALL, true)).dontAnimate().into(this.mBusinessLogo);
            this.mBusinessLogo.setVisibility(0);
            ViewCompat.setElevation(this.mBusinessLogo, (float) DisplayUtils.dip2px(getContext(), 2.0f));
            return;
        }
        this.mBusinessLogo.setVisibility(4);
    }

    /* renamed from: c */
    private void m28415c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_business_home_header, this, true);
        ButterKnife.bind((Object) this, inflate);
        this.mHeaderMoreTv.setText(getMoreSpannableString());
        this.f39828i = new BusinessHeaderAnimator(inflate);
        this.f39831l = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(inflate.getContext()));
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.f39834o = nestedScrollingChildHelper;
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.mHeaderBackgroundImg.setClickable(false);
        setClickable(false);
        this.businessHeaderViewTipHelper = new BusinessHeaderViewTipHelper(this);
    }

    public void bindScopeContext(ScopeContext scopeContext) {
        this.f39828i.bindScopeContext(scopeContext);
    }

    private SpannableStringBuilder getMoreSpannableString() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(new SpannableString(getContext().getResources().getString(R.string.customer_global_home_scroll_more)));
        SpannableString spannableString = new SpannableString(getContext().getResources().getString(R.string.customer_common_icon_arrow));
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 18);
        spannableString.setSpan(new CustomerSideSpacingSpan(10, getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999), DisplayUtils.dip2px(getContext(), 3.0f)), 0, spannableString.length(), 18);
        spannableStringBuilder.append(spannableString);
        return spannableStringBuilder;
    }

    private int getMoreWidth() {
        return (int) this.mHeaderMoreTv.getPaint().measureText(this.mHeaderMoreTv.getText().toString());
    }

    /* renamed from: e */
    private void m28422e(String str) {
        LogUtil.m29100d(f39820a, str);
    }

    /* renamed from: d */
    private boolean m28420d() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.f39827h < 1000;
        if (!z) {
            this.f39827h = currentTimeMillis;
        }
        return z;
    }
}
