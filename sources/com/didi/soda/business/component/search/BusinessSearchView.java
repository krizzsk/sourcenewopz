package com.didi.soda.business.component.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.business.binder.home.BusinessGoodsItemBinder;
import com.didi.soda.business.component.home.BusinessGoodsItemDecorator;
import com.didi.soda.business.component.search.helper.MenuSearchView;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.binder.CustomerDividerLineBinder;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.didi.soda.customer.widget.titlebar.OnBackClickListener;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.taxis99.R;

public class BusinessSearchView extends CustomerRecyclerView<BusinessSearchPresent> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f39657a = false;

    /* renamed from: b */
    private boolean f39658b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnPlayAddToCartAnimation f39659c;
    @BindView(18685)
    SodaLoadingView mLoadingView;
    @BindView(18586)
    NovaRecyclerView mSearchResultRv;
    @BindView(18588)
    MenuSearchView mSearchView;
    @BindView(18249)
    View mShadowView;
    @BindView(18044)
    ShimmerRecyclerView mShimmerView;
    @BindView(18587)
    TitleBarView mTitleBarView;

    public void showSearchLoading() {
        this.mSearchView.showOrHideLoading(true);
    }

    public void hideSearchLoading() {
        this.mSearchView.showOrHideLoading(false);
    }

    public void showLoading() {
        this.mLoadingView.setVisibility(0);
        if (!this.mLoadingView.isRunning()) {
            this.mLoadingView.start();
        }
    }

    public void hideLoading() {
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.stop();
    }

    public void hideSearchFocus() {
        this.mSearchView.getEditView().clearFocus();
    }

    public void showShimmerView() {
        this.mShimmerView.setVisibility(0);
        this.mShimmerView.startShimmerAnimator(ShimmerViewType.BUSINESS_SEARCH);
    }

    public void hideShimmerView() {
        this.mShimmerView.stopShimmerAnimator(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BusinessSearchView.this.mShimmerView.setVisibility(8);
            }
        });
    }

    public int calculateAbnormalHeight() {
        return (CustomerSystemUtil.getScreenHeight(getContext()) - CustomerSystemUtil.getImmersiveStatusBarHeight(getContext())) - DisplayUtils.dip2px(getContext(), 190.0f);
    }

    public void showNetErrorToast() {
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.customer_net_error_tip));
    }

    public void setRecommendSearchText(String str) {
        this.f39657a = true;
        this.mSearchView.getEditView().setText(str);
        this.mSearchView.getEditView().setSelection(str.length());
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        hideSearchFocus();
    }

    public void scrollToTop() {
        this.mSearchResultRv.scrollToPosition(0);
    }

    public void onCreate() {
        super.onCreate();
        m28235a();
    }

    public void onResume() {
        super.onResume();
        if (!this.f39658b) {
            KeyboardUtils.showSoftInput(getContext(), this.mSearchView.getEditView());
            this.f39658b = true;
        }
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.NONE;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39659c = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mSearchResultRv;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new CustomerDividerLineBinder());
        registerBinder(new BusinessGoodsItemBinder(getScopeContext(), BusinessGoodsItemDecorator.newInstance()) {
            public void onGoodsItemShow(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onGoodsItemExposure(businessGoodsItemRvModel);
            }

            public void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onGoodsItemClick(businessGoodsItemRvModel);
            }

            public void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onGoodsImageClick(view, businessGoodsItemRvModel);
            }

            public void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
                ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onGoodsAddClick(businessGoodsItemRvModel);
            }

            public void playAddCartAnimation(int[] iArr) {
                if (BusinessSearchView.this.f39659c != null) {
                    BusinessSearchView.this.f39659c.playAddToCartAnimation(iArr, (String) null);
                }
            }
        });
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_business_search_layout, viewGroup, true);
    }

    /* renamed from: a */
    private void m28235a() {
        this.mTitleBarView.setBackgroundResource(R.color.rf_color_gery_7_97_F5F5F7);
        this.mTitleBarView.setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                BusinessSearchView.this.m28239b(view);
            }
        });
        this.mSearchResultRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                BusinessSearchView.this.mShadowView.setVisibility(recyclerView.canScrollVertically(-1) ? 0 : 8);
            }
        });
        m28238b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28239b(View view) {
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        ((BusinessSearchPresent) getPresenter()).goBack(0);
    }

    /* renamed from: b */
    private void m28238b() {
        this.mSearchView.getEditView().setHint(R.string.customer_name_business_search_hint);
        this.mSearchView.getEditView().addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() == 0) {
                    ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onSearchWordClear();
                    KeyboardUtils.showSoftInput(BusinessSearchView.this.getContext(), BusinessSearchView.this.mSearchView.getEditView());
                } else if (!BusinessSearchView.this.f39657a) {
                    ((BusinessSearchPresent) BusinessSearchView.this.getPresenter()).onSearchWordUpdate(charSequence.toString());
                } else {
                    boolean unused = BusinessSearchView.this.f39657a = false;
                }
            }
        });
        this.mSearchView.getSearchButton().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessSearchView.this.m28236a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28236a(View view) {
        if (!StringUtils.isEmpty(this.mSearchView.getEditView().getText().toString())) {
            ((BusinessSearchPresent) getPresenter()).onSearchWordRequest(1);
        }
    }
}
