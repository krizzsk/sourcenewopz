package com.didi.soda.search.component.result;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.CustomerSimpleTitleBinder;
import com.didi.soda.customer.component.feed.base.FooterViewIView;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.home.topgun.binder.HomeBusinessItemNewBinder;
import com.didi.soda.home.topgun.binder.HomeFilterNoResultBinder;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.HomeFilterLayout;
import com.didi.soda.search.component.header.SearchHeaderInterface;
import com.didi.soda.search.component.result.Contract;
import com.didi.soda.search.component.result.binder.HomeBusinessWithDishBinder;
import com.didi.soda.search.component.result.binder.SearchBusinessBrandHeaderItemBinder;
import com.didi.soda.search.component.result.binder.SearchBusinessBrandSubItemBinder;
import com.didi.soda.search.component.result.binder.SearchBusinessOmegaInterfaceImpl;
import com.didi.soda.search.component.result.binder.SearchNoResultBinderLogic;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\"\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\"H\u0014J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0014J\u0012\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010*\u001a\u00020\u0010H\u0014J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020\u0010H\u0014J\b\u0010/\u001a\u00020\u0010H\u0014J\b\u00100\u001a\u00020-H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultView;", "Lcom/didi/soda/search/component/result/Contract$AbsSearchResultView;", "()V", "mAbnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "mFilterLayout", "Lcom/didi/soda/home/topgun/widget/HomeFilterLayout;", "mSearchHeaderInterface", "Lcom/didi/soda/search/component/header/SearchHeaderInterface;", "mSearchResultRv", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "footerViewMode", "Lcom/didi/soda/customer/component/feed/base/FooterViewIView$Mode;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "hideAbnormalView", "", "hideFilter", "hideLoading", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "onCreate", "onDestroy", "scrollToTop", "setFilterClickListener", "setFilterData", "mainFilter", "Lcom/didi/soda/home/topgun/model/FilterModel;", "list", "", "setSearchHeaderInterface", "headerInterface", "setSearchResultLayoutVisibility", "visibility", "", "setupNovaRecyclerView", "novaRecyclerView", "showFilter", "showLoading", "withBox", "", "showNetErrorView", "showNoResultView", "useLinearLayout", "SearchNoresultBinder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultView.kt */
public final class SearchResultView extends Contract.AbsSearchResultView {

    /* renamed from: a */
    private NovaRecyclerView f43749a;

    /* renamed from: b */
    private TopGunAbnormalView f43750b;

    /* renamed from: c */
    private HomeFilterLayout f43751c;

    /* renamed from: d */
    private SearchHeaderInterface f43752d;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_search_result, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_custom_rv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_custom_rv)");
        this.f43749a = (NovaRecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_custom_search_abnormal_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…tom_search_abnormal_view)");
        this.f43750b = (TopGunAbnormalView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_fl_search_filter_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…_fl_search_filter_layout)");
        this.f43751c = (HomeFilterLayout) findViewById3;
        inflate.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…不然pannel点击事件不响应\n        }");
        return inflate;
    }

    public void onCreate() {
        super.onCreate();
        m31071a();
    }

    /* access modifiers changed from: protected */
    public void setFilterData(FilterModel filterModel, List<? extends FilterModel> list) {
        HomeFilterLayout homeFilterLayout = this.f43751c;
        if (homeFilterLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFilterLayout");
            homeFilterLayout = null;
        }
        homeFilterLayout.bindData(filterModel, list, 3);
    }

    /* access modifiers changed from: protected */
    public void showFilter() {
        HomeFilterLayout homeFilterLayout = this.f43751c;
        if (homeFilterLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFilterLayout");
            homeFilterLayout = null;
        }
        homeFilterLayout.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void hideFilter() {
        HomeFilterLayout homeFilterLayout = this.f43751c;
        if (homeFilterLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFilterLayout");
            homeFilterLayout = null;
        }
        homeFilterLayout.setVisibility(8);
    }

    /* renamed from: a */
    private final void m31071a() {
        HomeFilterLayout homeFilterLayout = this.f43751c;
        if (homeFilterLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFilterLayout");
            homeFilterLayout = null;
        }
        homeFilterLayout.setFilterClickListener(new SearchResultView$setFilterClickListener$1(this));
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f43749a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultRv");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }

    /* access modifiers changed from: protected */
    public void scrollToTop() {
        NovaRecyclerView novaRecyclerView = this.f43749a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultRv");
            novaRecyclerView = null;
        }
        novaRecyclerView.scrollToPosition(0);
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        registerBinder(new CustomerSimpleTitleBinder());
        registerBinder(new SearchResultView$initItemBinders$1(this));
        registerBinder(new SearchNoresultBinder(((Contract.AbsSearchResultPresenter) getPresenter()).provideComponentLogicUnit()));
        registerBinder(new HomeBusinessWithDishBinder());
        registerBinder(new SearchBusinessBrandHeaderItemBinder(new SearchBusinessOmegaInterfaceImpl()));
        registerBinder(new SearchBusinessBrandSubItemBinder(new SearchBusinessOmegaInterfaceImpl()));
        registerBinder(new HomeBusinessItemNewBinder(new SearchBusinessOmegaInterfaceImpl()));
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        NovaRecyclerView novaRecyclerView = this.f43749a;
        NovaRecyclerView novaRecyclerView2 = null;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultRv");
            novaRecyclerView = null;
        }
        novaRecyclerView.setItemDecorationEnable(true);
        NovaRecyclerView novaRecyclerView3 = this.f43749a;
        if (novaRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultRv");
            novaRecyclerView3 = null;
        }
        novaRecyclerView3.setFootLoadMoreEnable(true);
        NovaRecyclerView novaRecyclerView4 = this.f43749a;
        if (novaRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultRv");
        } else {
            novaRecyclerView2 = novaRecyclerView4;
        }
        novaRecyclerView2.setOnScrollListener(new SearchResultView$setupNovaRecyclerView$1(this));
    }

    public final void setSearchHeaderInterface(SearchHeaderInterface searchHeaderInterface) {
        Intrinsics.checkNotNullParameter(searchHeaderInterface, "headerInterface");
        this.f43752d = searchHeaderInterface;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void setSearchResultLayoutVisibility(int i) {
        getView().setVisibility(i);
        SearchHeaderInterface searchHeaderInterface = this.f43752d;
        if (searchHeaderInterface != null) {
            searchHeaderInterface.setResultViewVisible(i);
        }
    }

    /* access modifiers changed from: protected */
    public void showNoResultView() {
        TopGunAbnormalViewModel buildSearchResultNoData = TopGunAbnormalFactory.buildSearchResultNoData();
        TopGunAbnormalView topGunAbnormalView = this.f43750b;
        TopGunAbnormalView topGunAbnormalView2 = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAbnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(0);
        TopGunAbnormalView topGunAbnormalView3 = this.f43750b;
        if (topGunAbnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAbnormalView");
        } else {
            topGunAbnormalView2 = topGunAbnormalView3;
        }
        topGunAbnormalView2.show(buildSearchResultNoData);
    }

    /* access modifiers changed from: protected */
    public void showNetErrorView() {
        TopGunAbnormalViewModel buildNoNetwork = TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                SearchResultView.m31072a(SearchResultView.this, view);
            }
        });
        TopGunAbnormalView topGunAbnormalView = this.f43750b;
        TopGunAbnormalView topGunAbnormalView2 = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAbnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(0);
        TopGunAbnormalView topGunAbnormalView3 = this.f43750b;
        if (topGunAbnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAbnormalView");
        } else {
            topGunAbnormalView2 = topGunAbnormalView3;
        }
        topGunAbnormalView2.show(buildNoNetwork);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31072a(SearchResultView searchResultView, View view) {
        Intrinsics.checkNotNullParameter(searchResultView, "this$0");
        searchResultView.showLoading(true);
        searchResultView.hideAbnormalView();
        ((Contract.AbsSearchResultPresenter) searchResultView.getPresenter()).onRetryClick();
    }

    /* access modifiers changed from: protected */
    public void hideAbnormalView() {
        TopGunAbnormalView topGunAbnormalView = this.f43750b;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAbnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void showLoading(boolean z) {
        DialogUtil.showLoadingDialogForShopCateLanding(getScopeContext(), true);
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        DialogUtil.hideLoadingDialog();
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/search/component/result/SearchResultView$SearchNoresultBinder;", "Lcom/didi/soda/home/topgun/binder/HomeFilterNoResultBinder;", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "onCreateBinderLogic", "Lcom/didi/soda/home/topgun/binder/HomeFilterNoResultBinder$HomeFilterNoResultLogic;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SearchResultView.kt */
    public static final class SearchNoresultBinder extends HomeFilterNoResultBinder {
        public SearchNoresultBinder(ComponentLogicUnit componentLogicUnit) {
            super(componentLogicUnit);
        }

        public HomeFilterNoResultBinder.HomeFilterNoResultLogic onCreateBinderLogic() {
            return new SearchNoResultBinderLogic();
        }
    }
}
