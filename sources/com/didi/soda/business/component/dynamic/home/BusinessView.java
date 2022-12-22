package com.didi.soda.business.component.dynamic.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.binder.home.BusinessCategoryItemBinder;
import com.didi.soda.business.binder.home.BusinessExpandBinder;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.component.dynamic.home.BusinessView;
import com.didi.soda.business.component.dynamic.home.Contract;
import com.didi.soda.business.component.home.BusinessGoodsItemDecorator;
import com.didi.soda.business.component.home.BusinessScrollManager;
import com.didi.soda.business.component.home.scroll.ScrollerFinishCallback;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.manager.BusinessDeliveryFeeTipsManager;
import com.didi.soda.business.manager.BusinessGuideManager;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.business.widget.OnHeaderCollapseListener;
import com.didi.soda.business.widget.OnHeaderStateChangeListener;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.component.floatingcarprovider.IFloatingCartProvider;
import com.didi.soda.customer.coordshop.CoordShopManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class BusinessView extends Contract.AbsBusinessView {

    /* renamed from: e */
    private static final String f39471e = "BusinessView";

    /* renamed from: a */
    RFIconView f39472a;

    /* renamed from: b */
    RFIconView f39473b;

    /* renamed from: c */
    View f39474c;

    /* renamed from: d */
    IconTextView f39475d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f39476f = -1;

    /* renamed from: g */
    private int f39477g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BusinessScrollManager f39478h;

    /* renamed from: i */
    private boolean f39479i = false;

    /* renamed from: j */
    private boolean f39480j = false;

    /* renamed from: k */
    private OnPlayAddToCartAnimation f39481k;

    /* renamed from: l */
    private View f39482l;

    /* renamed from: m */
    private int[] f39483m = new int[2];
    @BindView(17908)
    TopGunAbnormalView mAbnormalView;
    @BindView(19192)
    BusinessDyHomeHeaderView mBusinessHeaderView;
    @BindView(17838)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(18005)
    NovaRecyclerView mRecyclerView;
    @BindView(17836)
    ConstraintLayout mShimmerTitleBar;
    @BindView(18044)
    ShimmerRecyclerView mShimmerView;

    /* renamed from: n */
    private String f39484n;

    /* renamed from: a */
    static /* synthetic */ int m27997a(BusinessView businessView, int i) {
        int i2 = businessView.f39476f + i;
        businessView.f39476f = i2;
        return i2;
    }

    /* renamed from: a */
    private void m28001a(ViewGroup viewGroup, View view) {
        ViewGroup viewGroup2;
        if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
            if (viewGroup == null || viewGroup.getParent() == null || !(viewGroup.getParent() instanceof ViewGroup)) {
                viewGroup2 = (ViewGroup) view.findViewById(R.id.customer_cl_root_view);
            } else {
                viewGroup2 = (ViewGroup) viewGroup.getParent();
            }
            BusinessGuideManager.Companion.getInstance().showBusinessGuideView(viewGroup2, getContext());
        }
    }

    public int getCategoryRvIndex(int i) {
        return ((Contract.AbsBusinessPresenter) getPresenter()).getCategoryRvIndex(i);
    }

    public void selectTab(int i) {
        this.f39479i = true;
        this.mBusinessHeaderView.selectTab(i);
    }

    public void showShimmerView() {
        m28005a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f39472a.setVisibility(8);
        this.f39473b.setVisibility(8);
        this.f39474c.setVisibility(8);
        this.mShimmerView.setVisibility(0);
        this.mShimmerView.startShimmerAnimator(ShimmerViewType.BUSINESS_START);
    }

    public void hideShimmerView() {
        this.mShimmerTitleBar.setVisibility(8);
        m28005a(true);
        this.mShimmerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BusinessView.this.mShimmerView.setVisibility(8);
            }
        });
    }

    public void hideAbnormalView() {
        m28005a(true);
        this.mShimmerTitleBar.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mAbnormalView.setVisibility(8);
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        m28005a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f39472a.setVisibility(8);
        this.f39473b.setVisibility(8);
        this.f39474c.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(topGunAbnormalViewModel);
    }

    public void updateCategoryAmount(Map<String, BusinessCategoryRvModel> map) {
        this.f39478h.updateCategoryMap(map);
    }

    public void updateHeaderView(BusinessHeaderRvModel businessHeaderRvModel, IBlockScope iBlockScope) {
        this.mBusinessHeaderView.updateBusinessHeaderView(businessHeaderRvModel, iBlockScope);
    }

    public void showBusinessHeader(boolean z) {
        this.mBusinessHeaderView.setVisibility(z ? 0 : 8);
    }

    public void anchorView(final int i, final int i2, final BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        this.mRecyclerView.postDelayed(new Runnable() {
            public void run() {
                if (i > 0) {
                    UiHandlerUtil.postDelayed(new Runnable() {
                        public void run() {
                            BusinessView.this.mBusinessHeaderView.selectTab(i);
                        }
                    }, 50);
                }
                if (i2 > -1) {
                    BusinessView.this.mBusinessHeaderView.getHeaderAnimator().collapseHeader();
                    BusinessView.this.f39478h.scrollToAnchorView(i, i2, new ScrollerFinishCallback(businessGoodsItemRvModel) {
                        public final /* synthetic */ BusinessGoodsItemRvModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onScrollFinished() {
                            BusinessView.C134402.this.lambda$run$0$BusinessView$2(this.f$1);
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$run$0$BusinessView$2(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).updateAnchorData(businessGoodsItemRvModel);
            }
        }, 50);
    }

    public void favorBusiness() {
        this.mBusinessHeaderView.handleFavor(1, true);
    }

    public void onBack(int i) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBack(i);
    }

    public void onCreate() {
        super.onCreate();
        BusinessScrollManager businessScrollManager = new BusinessScrollManager(this.mRecyclerView);
        this.f39478h = businessScrollManager;
        businessScrollManager.setBusinessViewBehaviorImpl(this);
        m28009b();
        m27999a();
        CoordShopManager.Companion.get().findCoordShopPredicate(this.mRecyclerView);
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
    }

    public void onMoreClicked() {
        ((Contract.AbsBusinessPresenter) getPresenter()).goBusinessDetail();
    }

    public void onSearchClicked() {
        ((Contract.AbsBusinessPresenter) getPresenter()).goBusinessSearch();
    }

    public void onFavorClicked(boolean z) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBusinessFavor(z);
    }

    public void onFavorLogin() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onFavorLogin();
    }

    public void onTabItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onTabItemExposure(i, businessCategoryRvModel);
    }

    public void onTabItemSelected(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        if (this.f39479i) {
            this.f39479i = false;
            return;
        }
        if (z2) {
            this.mBusinessHeaderView.getHeaderAnimator().expandHeader();
        } else {
            this.mBusinessHeaderView.getHeaderAnimator().collapseHeader();
        }
        this.f39478h.onTabSelected(i);
        ((Contract.AbsBusinessPresenter) getPresenter()).onTabItemSelected(i, businessCategoryRvModel, z, z2);
    }

    public void onMoreTabExposure() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onMoreTabExposure();
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39481k = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_dy_business_home, viewGroup, true);
        m28001a(viewGroup, inflate);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m28005a(this.f39480j);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m28005a(false);
        ShimmerRecyclerView shimmerRecyclerView = this.mShimmerView;
        if (shimmerRecyclerView != null) {
            shimmerRecyclerView.onDestory();
        }
        BusinessGuideManager.Companion.getInstance().release();
        BusinessDeliveryFeeTipsManager.Companion.getInstance().release();
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new CustomerDividerLineBinder());
        registerBinder(new BusinessGoodsItemBinder(getScopeContext(), BusinessGoodsItemDecorator.newInstance()) {
            public void onGoodsItemShow(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsItemExposure(businessGoodsItemRvModel);
            }

            public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsItemClick(businessGoodsItemRvModel);
            }

            public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsImageClick(view, businessGoodsItemRvModel);
            }

            public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onGoodsAddClick(businessGoodsItemRvModel);
            }

            public void playAddCartAnimation(int[] iArr) {
                BusinessView.this.realPlayAddCartAnimation(iArr, (String) null);
            }
        });
        registerBinder(new BusinessCategoryItemBinder());
        registerBinder(new BusinessExpandBinder() {
            public void clickExpandAction(BusinessExpandRvModel businessExpandRvModel, int i) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandOrFoldAction(businessExpandRvModel, i);
            }

            /* access modifiers changed from: protected */
            public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandShow(businessExpandRvModel);
            }

            /* access modifiers changed from: protected */
            public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
                ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onExpandClickEvent(businessExpandRvModel);
            }
        });
    }

    public void realPlayAddCartAnimation(int[] iArr, String str) {
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f39481k;
        if (onPlayAddToCartAnimation != null && iArr.length >= 2 && iArr[0] > 0 && iArr[1] > 0) {
            onPlayAddToCartAnimation.playAddToCartAnimation(iArr, str);
        }
    }

    public void setCurrentVirView(View view, String str) {
        if (view != this.f39482l) {
            this.f39482l = view;
        }
        this.f39484n = str;
        View view2 = this.f39482l;
        if (view2 != null) {
            view2.getLocationOnScreen(this.f39483m);
        }
    }

    public void playAdd2CartAnim() {
        IFloatingCartProvider iFloatingCartProvider;
        if (this.f39482l != null && getScopeContext() != null && getScopeContext().getObject("service_floating_cart_key") != null && (iFloatingCartProvider = (IFloatingCartProvider) getScopeContext().getObject("service_floating_cart_key")) != null) {
            iFloatingCartProvider.playAddToCartAnimation(true);
            realPlayAddCartAnimation(this.f39483m, this.f39484n);
        }
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    public void showDeliveryFeeDescRule(HashMap<String, Object> hashMap, View view) {
        BusinessDyHomeHeaderView businessDyHomeHeaderView = this.mBusinessHeaderView;
        if (businessDyHomeHeaderView != null) {
            businessDyHomeHeaderView.showDeliveryFeeDescRule(hashMap, view);
        }
    }

    /* renamed from: a */
    private void m27999a() {
        this.mBusinessHeaderView.bindScopeContext(getScopeContext());
        this.mBusinessHeaderView.setOnBackListener(this);
        this.mBusinessHeaderView.setOnHeaderClickListener(this);
        this.mBusinessHeaderView.setTabItemListener(this);
        this.mBusinessHeaderView.setCategoryClickListener(new OnMoreCategoryListener() {
            public final void onClickMoreCategoryListener(BusinessSelectedCallback businessSelectedCallback) {
                BusinessView.this.m28002a(businessSelectedCallback);
            }
        });
        this.mBusinessHeaderView.getHeaderAnimator().setOnHeaderStateChangeListener(new OnHeaderStateChangeListener() {
            public final void onHeaderStateChanged(boolean z) {
                BusinessView.this.m28010b(z);
            }
        });
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BusinessView.m27997a(BusinessView.this, i2);
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onRvScrolled(BusinessView.this.f39476f);
                    int unused = BusinessView.this.f39476f = 0;
                }
            }
        });
        this.mBusinessHeaderView.setOnCategoryScrollListener(new CustomerTabLayout.OnScollChangedListener() {
            public final void onScrollChanged(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
                BusinessView.this.m28003a(customerTabLayout, i, i2, i3, i4);
            }
        });
        this.mBusinessHeaderView.setOnCategoryTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BusinessView.this.m28006a(view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28002a(final BusinessSelectedCallback businessSelectedCallback) {
        if (this.mBusinessHeaderView.getHeaderAnimator().isCollapsed()) {
            ((Contract.AbsBusinessPresenter) getPresenter()).showMoreCategory(businessSelectedCallback);
        } else {
            this.mBusinessHeaderView.getHeaderAnimator().collapseHeader(new OnHeaderCollapseListener() {
                public void onCollapseUpdated() {
                }

                public void onCollapseFinished() {
                    ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).showMoreCategory(businessSelectedCallback);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28010b(boolean z) {
        if (getScopeContext().getLiveHandler().isActive() && !((Contract.AbsBusinessPresenter) getPresenter()).hasDynamicNotice()) {
            m28005a(!z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28003a(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
        this.f39477g += i - i3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m28006a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39477g = 0;
        } else if (action == 1 || action == 3) {
            ((Contract.AbsBusinessPresenter) getPresenter()).onTabScrolled(this.f39477g);
            this.f39477g = 0;
        }
        return false;
    }

    /* renamed from: b */
    private void m28009b() {
        ConstraintLayout constraintLayout = this.mShimmerTitleBar;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + DisplayUtils.dip2px(getContext(), 12.0f), this.mShimmerTitleBar.getPaddingRight(), this.mShimmerTitleBar.getPaddingBottom());
        RFIconView rFIconView = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_close);
        this.f39472a = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_search);
        rFIconView.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        this.f39472a.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        rFIconView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessView.this.m28000a(view);
            }
        });
        RFIconView rFIconView2 = (RFIconView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_favor);
        this.f39473b = rFIconView2;
        rFIconView2.setTextColor(getColor(R.color.rf_color_gery_1_0_000000));
        this.f39473b.setOnClickListener((View.OnClickListener) null);
        IconTextView iconTextView = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_favor_delegate);
        this.f39475d = iconTextView;
        iconTextView.setVisibility(4);
        this.f39474c = this.mShimmerTitleBar.findViewById(R.id.customer_fl_business_favor_container);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28000a(View view) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBack(0);
    }

    /* renamed from: a */
    private void m28005a(boolean z) {
        this.f39480j = z;
        CustomerSystemUtil.setStatusBarBgLightning(z);
    }

    /* renamed from: a */
    private void m28004a(String str) {
        LogUtil.m29100d(f39471e, str);
    }
}
