package com.didi.soda.business.component.home;

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
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.soda.business.binder.home.BusinessCategoryItemBinder;
import com.didi.soda.business.binder.home.BusinessExpandBinder;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.component.home.BusinessView;
import com.didi.soda.business.component.home.Contract;
import com.didi.soda.business.component.home.scroll.ScrollerFinishCallback;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessHomeHeaderView;
import com.didi.soda.business.widget.OnHeaderCollapseListener;
import com.didi.soda.business.widget.OnHeaderStateChangeListener;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.foundation.log.util.LogUtil;
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
import java.util.Map;

public class BusinessView extends Contract.AbsBusinessView {

    /* renamed from: d */
    private static final String f39577d = "BusinessView";

    /* renamed from: a */
    IconTextView f39578a;

    /* renamed from: b */
    IconTextView f39579b;

    /* renamed from: c */
    IconTextView f39580c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f39581e = -1;

    /* renamed from: f */
    private int f39582f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f39583g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BusinessScrollManager f39584h;

    /* renamed from: i */
    private boolean f39585i = false;

    /* renamed from: j */
    private boolean f39586j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnPlayAddToCartAnimation f39587k;
    @BindView(17908)
    TopGunAbnormalView mAbnormalView;
    @BindView(19192)
    BusinessHomeHeaderView mBusinessHeaderView;
    @BindView(17838)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(18005)
    NovaRecyclerView mRecyclerView;
    @BindView(17836)
    ConstraintLayout mShimmerTitleBar;
    @BindView(18044)
    ShimmerRecyclerView mShimmerView;

    /* renamed from: a */
    static /* synthetic */ int m28147a(BusinessView businessView, int i) {
        int i2 = businessView.f39581e + i;
        businessView.f39581e = i2;
        return i2;
    }

    public int getCategoryRvIndex(int i) {
        return ((Contract.AbsBusinessPresenter) getPresenter()).getCategoryRvIndex(i);
    }

    public void selectTab(int i) {
        this.f39585i = true;
        this.mBusinessHeaderView.selectTab(i);
    }

    public void showShimmerView() {
        m28154a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f39578a.setVisibility(0);
        this.mShimmerView.setVisibility(0);
        this.mShimmerView.startShimmerAnimator(ShimmerViewType.BUSINESS_START);
    }

    public void hideShimmerView() {
        this.mShimmerTitleBar.setVisibility(8);
        m28154a(true);
        this.mShimmerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BusinessView.this.mShimmerView.setVisibility(8);
            }
        });
    }

    public void hideAbnormalView() {
        m28154a(true);
        this.mShimmerTitleBar.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
        this.mAbnormalView.setVisibility(8);
    }

    public void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel) {
        m28154a(false);
        this.mShimmerTitleBar.setVisibility(0);
        this.f39578a.setVisibility(8);
        this.mRecyclerView.setVisibility(8);
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(topGunAbnormalViewModel);
    }

    public void updateCategoryAmount(Map<String, BusinessCategoryRvModel> map) {
        this.f39584h.updateCategoryMap(map);
    }

    public void updateHeaderView(BusinessHeaderRvModel businessHeaderRvModel) {
        this.mBusinessHeaderView.updateBusinessHeaderView(businessHeaderRvModel);
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
                            BusinessView.this.selectTab(i);
                        }
                    }, 50);
                }
                if (i2 > -1) {
                    BusinessView.this.f39584h.scrollToAnchorView(i, i2, new ScrollerFinishCallback(businessGoodsItemRvModel) {
                        public final /* synthetic */ BusinessGoodsItemRvModel f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onScrollFinished() {
                            BusinessView.C134642.this.lambda$run$0$BusinessView$2(this.f$1);
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
        this.f39584h = businessScrollManager;
        businessScrollManager.setBusinessViewBehaviorImpl(this);
        m28158b();
        m28149a();
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
        if (this.f39585i) {
            this.f39585i = false;
            return;
        }
        if (z2) {
            this.mBusinessHeaderView.getHeaderAnimator().expandHeader();
        } else {
            this.mBusinessHeaderView.getHeaderAnimator().collapseHeader();
        }
        this.f39584h.onTabSelected(i);
        ((Contract.AbsBusinessPresenter) getPresenter()).onTabItemSelected(i, businessCategoryRvModel, z, z2);
        if (z) {
            this.f39583g = true;
        }
    }

    public void onMoreTabExposure() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onMoreTabExposure();
    }

    public void onAttentionShow() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onAttentionShow();
    }

    public void onAttentionClick() {
        ((Contract.AbsBusinessPresenter) getPresenter()).onAttentionClick();
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39587k = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_business_home, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m28154a(this.f39586j);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m28154a(false);
        ShimmerRecyclerView shimmerRecyclerView = this.mShimmerView;
        if (shimmerRecyclerView != null) {
            shimmerRecyclerView.onDestory();
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
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
                if (BusinessView.this.f39587k != null) {
                    BusinessView.this.f39587k.playAddToCartAnimation(iArr, (String) null);
                }
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

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    /* renamed from: a */
    private void m28149a() {
        this.mBusinessHeaderView.bindScopeContext(getScopeContext());
        this.mBusinessHeaderView.setOnBackListener(this);
        this.mBusinessHeaderView.setOnHeaderClickListener(this);
        this.mBusinessHeaderView.setTabItemListener(this);
        this.mBusinessHeaderView.setCategoryClickListener(new OnMoreCategoryListener() {
            public final void onClickMoreCategoryListener(BusinessSelectedCallback businessSelectedCallback) {
                BusinessView.this.m28151a(businessSelectedCallback);
            }
        });
        this.mBusinessHeaderView.setOnAttentionListener(this);
        this.mBusinessHeaderView.getHeaderAnimator().setOnHeaderStateChangeListener(new OnHeaderStateChangeListener() {
            public final void onHeaderStateChanged(boolean z) {
                BusinessView.this.m28159b(z);
            }
        });
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (!BusinessView.this.f39583g) {
                    BusinessView.m28147a(BusinessView.this, i2);
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && !BusinessView.this.f39583g) {
                    ((Contract.AbsBusinessPresenter) BusinessView.this.getPresenter()).onRvScrolled(BusinessView.this.f39581e);
                    int unused = BusinessView.this.f39581e = 0;
                }
            }
        });
        this.mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BusinessView.this.m28160b(view, motionEvent);
            }
        });
        this.mBusinessHeaderView.setOnCategoryScrollListener(new CustomerTabLayout.OnScollChangedListener() {
            public final void onScrollChanged(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
                BusinessView.this.m28152a(customerTabLayout, i, i2, i3, i4);
            }
        });
        this.mBusinessHeaderView.setOnCategoryTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return BusinessView.this.m28155a(view, motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28151a(final BusinessSelectedCallback businessSelectedCallback) {
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
    public /* synthetic */ void m28159b(boolean z) {
        if (getScopeContext().getLiveHandler().isActive() && !((Contract.AbsBusinessPresenter) getPresenter()).hasDynamicNotice()) {
            m28154a(!z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m28160b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f39583g = false;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28152a(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4) {
        if (!this.f39583g) {
            this.f39582f += i - i3;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r2 != 3) goto L_0x0024;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean m28155a(android.view.View r2, android.view.MotionEvent r3) {
        /*
            r1 = this;
            int r2 = r3.getAction()
            r3 = 0
            if (r2 == 0) goto L_0x0022
            r0 = 1
            if (r2 == r0) goto L_0x0014
            r0 = 2
            if (r2 == r0) goto L_0x0011
            r0 = 3
            if (r2 == r0) goto L_0x0014
            goto L_0x0024
        L_0x0011:
            r1.f39583g = r3
            goto L_0x0024
        L_0x0014:
            com.didi.app.nova.skeleton.mvp.IPresenter r2 = r1.getPresenter()
            com.didi.soda.business.component.home.Contract$AbsBusinessPresenter r2 = (com.didi.soda.business.component.home.Contract.AbsBusinessPresenter) r2
            int r0 = r1.f39582f
            r2.onTabScrolled(r0)
            r1.f39582f = r3
            goto L_0x0024
        L_0x0022:
            r1.f39582f = r3
        L_0x0024:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.home.BusinessView.m28155a(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    private void m28158b() {
        ConstraintLayout constraintLayout = this.mShimmerTitleBar;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), this.mShimmerTitleBar.getPaddingRight(), this.mShimmerTitleBar.getPaddingBottom());
        IconTextView iconTextView = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_close);
        this.f39578a = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_search);
        iconTextView.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        this.f39578a.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessView.this.m28150a(view);
            }
        });
        IconTextView iconTextView2 = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_business_home_favor);
        this.f39579b = iconTextView2;
        iconTextView2.setTextColor(getColor(R.color.customer_selector_left_black_arrow_new));
        this.f39579b.setOnClickListener((View.OnClickListener) null);
        IconTextView iconTextView3 = (IconTextView) this.mShimmerTitleBar.findViewById(R.id.customer_iv_favor_delegate);
        this.f39580c = iconTextView3;
        iconTextView3.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28150a(View view) {
        ((Contract.AbsBusinessPresenter) getPresenter()).onBack(0);
    }

    /* renamed from: a */
    private void m28154a(boolean z) {
        this.f39586j = z;
        CustomerSystemUtil.setStatusBarBgLightning(z);
    }

    /* renamed from: a */
    private void m28153a(String str) {
        LogUtil.m29100d(f39577d, str);
    }
}
