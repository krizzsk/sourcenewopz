package com.didi.soda.search.component.panel;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class SearchEntrancePanelView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SearchEntrancePanelView f43714a;

    public SearchEntrancePanelView_ViewBinding(SearchEntrancePanelView searchEntrancePanelView, View view) {
        this.f43714a = searchEntrancePanelView;
        searchEntrancePanelView.mSearchRecommendTagFl = (NovaFlowLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_recommend_tag, "field 'mSearchRecommendTagFl'", NovaFlowLayout.class);
        searchEntrancePanelView.mSearchHistoryTagFl = (NovaFlowLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_history_tag, "field 'mSearchHistoryTagFl'", NovaFlowLayout.class);
        searchEntrancePanelView.mDeleteHistoryIv = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_search_word_history_delete, "field 'mDeleteHistoryIv'", RFIconView.class);
        searchEntrancePanelView.mSearchRecommendParentLayout = Utils.findRequiredView(view, R.id.customer_fl_search_recommend_layout, "field 'mSearchRecommendParentLayout'");
        searchEntrancePanelView.mSearchHistoryParentLayout = Utils.findRequiredView(view, R.id.customer_fl_search_history_layout, "field 'mSearchHistoryParentLayout'");
        searchEntrancePanelView.mSearchShopTagFl = (NovaFlowLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_shops_tag, "field 'mSearchShopTagFl'", NovaFlowLayout.class);
        searchEntrancePanelView.mSearchShopsParentLayout = Utils.findRequiredView(view, R.id.customer_fl_search_shops_layout, "field 'mSearchShopsParentLayout'");
    }

    public void unbind() {
        SearchEntrancePanelView searchEntrancePanelView = this.f43714a;
        if (searchEntrancePanelView != null) {
            this.f43714a = null;
            searchEntrancePanelView.mSearchRecommendTagFl = null;
            searchEntrancePanelView.mSearchHistoryTagFl = null;
            searchEntrancePanelView.mDeleteHistoryIv = null;
            searchEntrancePanelView.mSearchRecommendParentLayout = null;
            searchEntrancePanelView.mSearchHistoryParentLayout = null;
            searchEntrancePanelView.mSearchShopTagFl = null;
            searchEntrancePanelView.mSearchShopsParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
