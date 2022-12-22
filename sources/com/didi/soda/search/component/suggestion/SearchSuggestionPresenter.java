package com.didi.soda.search.component.suggestion;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.search.component.suggestion.Contract;
import com.didi.soda.search.helper.SearchNewOmegaHelper;

public class SearchSuggestionPresenter extends Contract.AbsSearchSuggestionPresenter {

    /* renamed from: a */
    ChildDataListManager<RecyclerModel> f43756a;

    /* renamed from: b */
    private IBlockScope f43757b = null;

    /* access modifiers changed from: package-private */
    public void onRetryClick() {
    }

    /* access modifiers changed from: protected */
    public void setState(SearchSuggestionState searchSuggestionState) {
        int size;
        if (searchSuggestionState != null) {
            int i = 0;
            if (searchSuggestionState.sugList != null && searchSuggestionState.sugList.size() > 0) {
                size = searchSuggestionState.sugList.size();
                ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(0);
                m31082a(searchSuggestionState);
            } else if (searchSuggestionState.suggestions == null || searchSuggestionState.suggestions.size() <= 0) {
                if (this.searchSugListener != null) {
                    this.searchSugListener.onNoSug();
                } else {
                    ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(8);
                }
                SearchNewOmegaHelper.getInstance().trackSugWordResultShow(searchSuggestionState, i);
            } else {
                size = searchSuggestionState.suggestions.size();
                ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(0);
                m31082a(searchSuggestionState);
            }
            i = size;
            SearchNewOmegaHelper.getInstance().trackSugWordResultShow(searchSuggestionState, i);
        }
    }

    /* renamed from: a */
    private void m31082a(SearchSuggestionState searchSuggestionState) {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f43756a;
        if (childDataListManager == null) {
            clearDataManagers();
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager(SearchSuggestionViewModel.convertToViewModel(searchSuggestionState));
            this.f43756a = createChildDataListManager;
            addDataManager(createChildDataListManager);
            return;
        }
        childDataListManager.clear();
        this.f43756a.set(SearchSuggestionViewModel.convertToViewModel(searchSuggestionState));
    }

    public IBlockScope getScope() {
        if (this.f43757b == null) {
            BlockScopeBase createBlockScope = BlocksEngine.Companion.getInstance().createBlockScope();
            this.f43757b = createBlockScope;
            createBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, getScopeContext());
        }
        return this.f43757b;
    }
}
