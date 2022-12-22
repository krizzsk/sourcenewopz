package com.didi.soda.business.component.search;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public class BusinessSearchComponent extends AbBusinessSearchComponent<BusinessSearchView, BusinessSearchPresent> implements RecommendWordListener {

    /* renamed from: a */
    private BusinessSearchChangeListener f39633a;

    /* renamed from: b */
    private BusinessSearchPresent f39634b;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f39635c;

    public BusinessSearchComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onRecommendWordSearch(String str, String str2) {
        this.f39634b.onRecommendWordSearch(str, str2);
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f39633a = businessSearchChangeListener;
    }

    public void onPageResult(Bundle bundle) {
        BusinessSearchPresent businessSearchPresent = this.f39634b;
        if (businessSearchPresent != null && bundle != null) {
            businessSearchPresent.onPageResult(bundle);
        }
    }

    public void goBack() {
        this.f39634b.goBack(1);
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39635c = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public BusinessSearchView onCreateView() {
        BusinessSearchView businessSearchView = new BusinessSearchView();
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f39635c;
        if (onPlayAddToCartAnimation != null) {
            businessSearchView.setOnPlayAddToCartAnimation(onPlayAddToCartAnimation);
        }
        return businessSearchView;
    }

    /* access modifiers changed from: protected */
    public BusinessSearchPresent onCreatePresenter() {
        BusinessSearchPresent businessSearchPresent = new BusinessSearchPresent();
        this.f39634b = businessSearchPresent;
        businessSearchPresent.setBusinessSearchChangeListener(this.f39633a);
        return this.f39634b;
    }
}
