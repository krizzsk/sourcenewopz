package com.didi.soda.business.component.dynamic.search;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.soda.business.component.search.AbBusinessSearchComponent;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public class BusinessDySearchComponent extends AbBusinessSearchComponent<BusinessDySearchView, BusinessDySearchPresent> implements RecommendWordListener {

    /* renamed from: a */
    private BusinessSearchChangeListener f39493a;

    /* renamed from: b */
    private BusinessDySearchPresent f39494b;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f39495c;

    public BusinessDySearchComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onRecommendWordSearch(String str, String str2) {
        this.f39494b.onRecommendWordSearch(str, str2);
    }

    public void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener) {
        this.f39493a = businessSearchChangeListener;
    }

    public void onPageResult(Bundle bundle) {
        BusinessDySearchPresent businessDySearchPresent = this.f39494b;
        if (businessDySearchPresent != null && bundle != null) {
            businessDySearchPresent.onPageResult(bundle);
        }
    }

    public void goBack() {
        this.f39494b.goBack(1);
    }

    public void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39495c = onPlayAddToCartAnimation;
    }

    /* access modifiers changed from: protected */
    public BusinessDySearchView onCreateView() {
        BusinessDySearchView businessDySearchView = new BusinessDySearchView();
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f39495c;
        if (onPlayAddToCartAnimation != null) {
            businessDySearchView.setOnPlayAddToCartAnimation(onPlayAddToCartAnimation);
        }
        return businessDySearchView;
    }

    /* access modifiers changed from: protected */
    public BusinessDySearchPresent onCreatePresenter() {
        BusinessDySearchPresent businessDySearchPresent = new BusinessDySearchPresent();
        this.f39494b = businessDySearchPresent;
        businessDySearchPresent.setBusinessSearchChangeListener(this.f39493a);
        return this.f39494b;
    }
}
