package com.didi.soda.business.component.search;

import android.view.ViewGroup;
import com.didi.soda.business.listener.RecommendWordListener;

public class BusinessHotWordComponent extends AbBusinessHotWordComponent<BusinessHotWordView, BusinessHotWordPresent> {

    /* renamed from: a */
    private RecommendWordListener f39626a;

    public BusinessHotWordComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void setRecommendWordListener(RecommendWordListener recommendWordListener) {
        this.f39626a = recommendWordListener;
    }

    /* access modifiers changed from: protected */
    public BusinessHotWordView onCreateView() {
        return new BusinessHotWordView();
    }

    /* access modifiers changed from: protected */
    public BusinessHotWordPresent onCreatePresenter() {
        BusinessHotWordPresent businessHotWordPresent = new BusinessHotWordPresent();
        businessHotWordPresent.setRecommendWordListener(this.f39626a);
        return businessHotWordPresent;
    }
}
