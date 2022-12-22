package com.didi.soda.address.component.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.address.AddressSearchView;
import com.didi.soda.address.component.search.Contract;
import com.didi.soda.address.component.search.SearchAddressComponent;
import com.didi.soda.address.component.search.binder.AddressSearchBinder;
import com.didi.soda.address.model.AddressSearchRvModel;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.MaxLengthEditText;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.loading.SodaLoadingView;
import com.taxis99.R;

public class SearchAddressView extends Contract.AbsSearchAddressView implements AddressSearchBinder.OnSelectAddressListener {

    /* renamed from: a */
    private static final int f38690a = 50;

    /* renamed from: b */
    private MaxLengthEditText.TextLengthFilter f38691b;

    /* renamed from: c */
    private ObjectAnimator f38692c;

    /* renamed from: d */
    private SimpleAnimatorListener f38693d;
    @BindView(20990)
    TopGunAbnormalView mAddressAbnormalView;
    @BindView(22722)
    RelativeLayout mAddressContainer;
    @BindView(19167)
    View mLine;
    @BindView(18685)
    SodaLoadingView mLoadingView;
    @BindView(18761)
    TextView mNoResultDes;
    @BindView(17827)
    View mNoResultLayout;
    @BindView(18763)
    TextView mNoResultTitle;
    @BindView(18630)
    LinearLayout mNoticeLayout;
    @BindView(23190)
    NovaRecyclerView mSearchAddressRv;
    @BindView(18034)
    AddressSearchView mSearchEntrace;

    public void onCreate() {
        super.onCreate();
        m27412b();
        this.mAddressAbnormalView.setVisibility(8);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNoResultTitle, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNoResultDes, IToolsService.FontType.LIGHT);
        m27411a(true);
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
        m27411a(false);
        this.mNoResultLayout.setVisibility(8);
        this.mSearchAddressRv.setVisibility(8);
        this.mLine.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(0);
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            this.mAddressAbnormalView.show(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                public void onClick(View view) {
                    ((Contract.AbsSearchAddressPresenter) SearchAddressView.this.getPresenter()).onRetryAction();
                }
            }));
            return;
        }
        this.mAddressAbnormalView.show(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
            public void onClick(View view) {
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
            if (this.f38692c == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAddressContainer, View.ALPHA, new float[]{0.0f, 1.0f});
                this.f38692c = ofFloat;
                ofFloat.setDuration(200);
                this.f38692c.setInterpolator(new DecelerateInterpolator());
                SimpleAnimatorListener simpleAnimatorListener = new SimpleAnimatorListener();
                this.f38693d = simpleAnimatorListener;
                this.f38692c.addListener(simpleAnimatorListener);
            }
            this.f38693d.mListener = onSearchAnimationListener;
            this.f38693d.mIsShow = true;
            this.f38692c.start();
            this.mSearchEntrace.focus();
            return;
        }
        if (this.f38692c != null) {
            this.f38693d.mListener = onSearchAnimationListener;
            this.f38693d.mIsShow = false;
            this.f38692c.reverse();
        } else {
            m27409a();
        }
        KeyboardUtils.hideSoftInput(getContext(), this.mSearchEntrace);
    }

    public void showLoadSuccess() {
        this.mNoResultLayout.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(8);
        this.mSearchAddressRv.setVisibility(0);
        m27411a(false);
    }

    public void searchEmptyText() {
        m27411a(true);
        this.mNoResultLayout.setVisibility(8);
        this.mAddressAbnormalView.setVisibility(8);
        showOrHideLoading(false);
    }

    public void onAddressSelected(AddressSearchRvModel addressSearchRvModel, int i) {
        ((Contract.AbsSearchAddressPresenter) getPresenter()).onAddressSelected(addressSearchRvModel, i);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_search_address, viewGroup, true);
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

    /* renamed from: a */
    private void m27411a(boolean z) {
        int i = 8;
        if ("ja-JP".startsWith(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag())) {
            LinearLayout linearLayout = this.mNoticeLayout;
            if (z) {
                i = 0;
            }
            linearLayout.setVisibility(i);
            return;
        }
        this.mNoticeLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27409a() {
        this.mSearchEntrace.clearText();
        this.mLine.setVisibility(8);
        this.mNoResultLayout.setVisibility(8);
    }

    /* renamed from: b */
    private void m27412b() {
        MaxLengthEditText.TextLengthFilter textLengthFilter = new MaxLengthEditText.TextLengthFilter();
        this.f38691b = textLengthFilter;
        textLengthFilter.setMaxLength(50);
        this.mSearchEntrace.setFilters(new InputFilter[]{this.f38691b});
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

    private class SimpleAnimatorListener extends AnimatorListenerAdapter {
        boolean mIsShow;
        SearchAddressComponent.OnSearchAnimationListener mListener;

        private SimpleAnimatorListener() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.mIsShow) {
                SearchAddressView.this.m27409a();
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
