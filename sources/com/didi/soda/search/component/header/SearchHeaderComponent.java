package com.didi.soda.search.component.header;

import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.listener.LoadingViewSupporter;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.search.component.header.Contract;

public class SearchHeaderComponent extends MvpComponent<Contract.AbsSearchHeaderView, Contract.AbsSearchHeaderPresenter> implements LoadingViewSupporter, SearchHeaderInterface {

    /* renamed from: a */
    Contract.AbsSearchHeaderView f43680a;

    /* renamed from: b */
    SearchHeaderPresenter f43681b;

    /* renamed from: c */
    OnBackListener f43682c;

    public SearchHeaderComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public View getLoadingView() {
        return m30999c().getLoadingView();
    }

    public void setSortViewVisible(int i) {
        this.f43680a.setSortViewVisible(i);
    }

    public void setResultViewVisible(int i) {
        this.f43680a.setResultViewVisible(i);
    }

    public void setSearchHomeBackListener(OnBackListener onBackListener) {
        this.f43682c = onBackListener;
    }

    public void handleBack() {
        this.f43681b.handleBack();
    }

    public void resetIsFirstInputShow() {
        this.f43680a.resetIsFirstInputShow();
    }

    public void refreshSuggestion() {
        this.f43681b.refreshSuggestion();
        this.f43680a.showSoftInput();
    }

    public void showSoftInput() {
        this.f43680a.showSoftInput();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchHeaderView onCreateView() {
        return m30999c();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSearchHeaderPresenter onCreatePresenter() {
        SearchHeaderPresenter searchHeaderPresenter = new SearchHeaderPresenter();
        this.f43681b = searchHeaderPresenter;
        searchHeaderPresenter.setSearchHomeBackListener(this.f43682c);
        return this.f43681b;
    }

    /* renamed from: c */
    private Contract.AbsSearchHeaderView m30999c() {
        if (this.f43680a == null) {
            this.f43680a = new SearchHeaderView();
        }
        return this.f43680a;
    }
}
