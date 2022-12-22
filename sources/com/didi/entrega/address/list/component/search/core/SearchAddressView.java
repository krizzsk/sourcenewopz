package com.didi.entrega.address.list.component.search.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.address.list.component.search.SearchAddressComponent;
import com.didi.entrega.address.list.component.search.binder.AddressSearchBinder;
import com.didi.entrega.address.list.component.search.core.Contract;
import com.didi.entrega.address.list.component.search.model.AddressSearchRvModel;
import com.didi.entrega.address.list.component.search.widget.AddressSearchView;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.MaxLengthEditText;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.didi.entrega.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;

public class SearchAddressView extends Contract.AbsSearchAddressView implements AddressSearchBinder.OnSelectAddressListener {

    /* renamed from: a */
    private static final int f19450a = 50;

    /* renamed from: b */
    private MaxLengthEditText.TextLengthFilter f19451b;

    /* renamed from: c */
    private ObjectAnimator f19452c;

    /* renamed from: d */
    private SimpleAnimatorListener f19453d;
    @BindView(18255)
    AbnormalView mAddressAbnormalView;
    @BindView(19943)
    RelativeLayout mAddressContainer;
    @BindView(16288)
    LottieLoadingView mCheckLoadingView;
    @BindView(16418)
    View mLine;
    @BindView(16364)
    SodaLoadingView mLoadingView;
    @BindView(16371)
    TextView mNoResultDes;
    @BindView(16280)
    View mNoResultLayout;
    @BindView(16372)
    TextView mNoResultTitle;
    @BindView(20400)
    NovaRecyclerView mSearchAddressRv;
    @BindView(16307)
    AddressSearchView mSearchEntrace;

    public void onCreate() {
        super.onCreate();
        m14563b();
        this.mAddressAbnormalView.setVisibility(8);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNoResultTitle, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNoResultDes, IToolsService.FontType.LIGHT);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        iNovaRecyclerView.setItemDecorationEnable(true);
        iNovaRecyclerView.setItemTouchControlEnable(false);
    }

    public void showLoadError(String str) {
        this.mNoResultLayout.setVisibility(8);
        this.mSearchAddressRv.setVisibility(8);
        this.mLine.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(0);
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            this.mAddressAbnormalView.show(AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ((Contract.AbsSearchAddressPresenter) SearchAddressView.this.getPresenter()).onRetryAction();
                }
            }));
            return;
        }
        this.mAddressAbnormalView.show(AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((Contract.AbsSearchAddressPresenter) SearchAddressView.this.getPresenter()).onRetryAction();
            }
        }));
    }

    public void hideLoadError() {
        this.mAddressAbnormalView.setVisibility(8);
    }

    public void showOrHideLoading(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
            if (!this.mLoadingView.isRunning()) {
                this.mLoadingView.start();
                return;
            }
            return;
        }
        this.mLoadingView.setVisibility(8);
        this.mLoadingView.stop();
    }

    public void showOrHideSearchLoading(boolean z) {
        this.mSearchEntrace.showOrHideLoading(z);
    }

    public void showOrHideContent(boolean z, SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener) {
        if (z) {
            this.mAddressAbnormalView.setVisibility(8);
            if (this.f19452c == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAddressContainer, View.ALPHA, new float[]{0.0f, 1.0f});
                this.f19452c = ofFloat;
                ofFloat.setDuration(200);
                this.f19452c.setInterpolator(new DecelerateInterpolator());
                SimpleAnimatorListener simpleAnimatorListener = new SimpleAnimatorListener();
                this.f19453d = simpleAnimatorListener;
                this.f19452c.addListener(simpleAnimatorListener);
            }
            this.f19453d.mListener = onSearchAnimationListener;
            this.f19453d.mIsShow = true;
            this.f19452c.start();
            this.mSearchEntrace.focus();
            return;
        }
        if (this.f19452c != null) {
            this.f19453d.mListener = onSearchAnimationListener;
            this.f19453d.mIsShow = false;
            this.f19452c.reverse();
        } else {
            m14561a();
        }
        KeyboardUtils.hideSoftInput(getContext(), this.mSearchEntrace);
    }

    public void showLoadSuccess() {
        this.mNoResultLayout.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(8);
        this.mSearchAddressRv.setVisibility(0);
    }

    public void searchEmptyText() {
        this.mNoResultLayout.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(8);
        showOrHideLoading(false);
    }

    public void onAddressSelected(AddressSearchRvModel addressSearchRvModel) {
        ((Contract.AbsSearchAddressPresenter) getPresenter()).onAddressSelected(addressSearchRvModel);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_customer_component_search_address, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mSearchAddressRv;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new AddressSearchBinder(this));
    }

    /* access modifiers changed from: package-private */
    public void showLoadNoResult() {
        this.mLine.setVisibility(8);
        this.mSearchAddressRv.setVisibility(8);
        this.mNoResultLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14561a() {
        this.mSearchEntrace.clearText();
        this.mLine.setVisibility(8);
        this.mNoResultLayout.setVisibility(8);
    }

    /* renamed from: b */
    private void m14563b() {
        MaxLengthEditText.TextLengthFilter textLengthFilter = new MaxLengthEditText.TextLengthFilter();
        this.f19451b = textLengthFilter;
        textLengthFilter.setMaxLength(50);
        this.mSearchEntrace.setFilters(new InputFilter[]{this.f19451b});
        this.mSearchEntrace.addTextWatcher(new CommonTextWatcher() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ((Contract.AbsSearchAddressPresenter) SearchAddressView.this.getPresenter()).onSearchTextChange(charSequence.toString());
            }
        });
        this.mSearchAddressRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                SearchAddressView.this.mLine.setVisibility(recyclerView.canScrollVertically(-1) ? 0 : 8);
            }
        });
    }

    public void setSearchTextHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSearchEntrace.setTextHint(str);
        }
    }

    public void showCheckLoading() {
        this.mCheckLoadingView.setVisibility(0);
        if (!this.mCheckLoadingView.isAnimating()) {
            this.mCheckLoadingView.start();
        }
    }

    public void hideCheckLoading() {
        this.mCheckLoadingView.setVisibility(8);
        if (this.mCheckLoadingView.isAnimating()) {
            this.mCheckLoadingView.stop();
        }
    }

    private class SimpleAnimatorListener extends AnimatorListenerAdapter {
        boolean mIsShow;
        SearchAddressComponent.OnSearchAnimationListener mListener;

        private SimpleAnimatorListener() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.mIsShow) {
                SearchAddressView.this.m14561a();
            }
            SearchAddressComponent.OnSearchAnimationListener onSearchAnimationListener = this.mListener;
            if (onSearchAnimationListener != null) {
                onSearchAnimationListener.onAnimationCompleted();
            }
        }
    }

    abstract class CommonTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public abstract void onTextChanged(CharSequence charSequence, int i, int i2, int i3);

        CommonTextWatcher() {
        }
    }
}
