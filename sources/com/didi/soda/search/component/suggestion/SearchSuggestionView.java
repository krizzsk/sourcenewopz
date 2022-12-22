package com.didi.soda.search.component.suggestion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.blocks.view.BlocksItemLineDecoration;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.binder.HomeRecyclerBinder;
import com.didi.soda.search.binder.SearchSuggestionBinder;
import com.didi.soda.search.component.suggestion.Contract;
import com.taxis99.R;

public class SearchSuggestionView extends Contract.AbsSearchSuggestionView {
    @BindView(18042)
    NovaRecyclerView mList;
    @BindView(18689)
    ViewGroup mRoot;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_search_ab_suggestion, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mList;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new SearchSuggestionBinder(getScopeContext(), m31085a()));
        registerBinder(new HomeRecyclerBinder(((Contract.AbsSearchSuggestionPresenter) getPresenter()).getScope(), m31085a()));
    }

    /* access modifiers changed from: package-private */
    public void setSearchSuggestionLayoutVisibility(int i) {
        ViewGroup viewGroup = this.mRoot;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        this.mList.setItemDecorationEnable(true);
    }

    /* renamed from: a */
    private ItemDecorator m31085a() {
        return new BlocksItemLineDecoration(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5), DisplayUtils.dip2px(getContext(), 0.5f), DisplayUtils.dip2px(getContext(), 16.0f), DisplayUtils.dip2px(getContext(), 16.0f));
    }
}
