package com.didi.soda.search.component.panel;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.search.component.panel.Contract;

public class SearchEntrancePanelComponent extends MvpComponent<Contract.AbsSearchEntrancePanelView, Contract.AbsSearchEntrancePanelPresenter> {
    public SearchEntrancePanelComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchEntrancePanelView onCreateView() {
        return new SearchEntrancePanelView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchEntrancePanelPresenter onCreatePresenter() {
        return new SearchEntrancePanelPresenter();
    }

    public void setPanelLayoutVisibility(int i) {
        ((Contract.AbsSearchEntrancePanelView) getLogicView()).setPanelLayoutVisibility(i);
    }
}
