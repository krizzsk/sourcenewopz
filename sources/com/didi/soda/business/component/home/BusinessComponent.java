package com.didi.soda.business.component.home;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.business.listener.BusinessCategoryListener;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public class BusinessComponent extends MvpComponent<BusinessView, BusinessPresenter> {

    /* renamed from: a */
    private BusinessCategoryListener f39532a;

    /* renamed from: b */
    private BusinessPresenter f39533b;

    /* renamed from: c */
    private OnPlayAddToCartAnimation f39534c;

    public BusinessComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        BusinessPresenter businessPresenter = this.f39533b;
        if (businessPresenter != null) {
            businessPresenter.onPageResult(bundle);
        }
    }

    public void setBusinessCategoryListener(BusinessCategoryListener businessCategoryListener) {
        this.f39532a = businessCategoryListener;
    }

    /* access modifiers changed from: protected */
    public BusinessView onCreateView() {
        BusinessView businessView = new BusinessView();
        OnPlayAddToCartAnimation onPlayAddToCartAnimation = this.f39534c;
        if (onPlayAddToCartAnimation != null) {
            businessView.setOnPlayAddToCartAnimation(onPlayAddToCartAnimation);
        }
        return businessView;
    }

    /* access modifiers changed from: protected */
    public BusinessPresenter onCreatePresenter() {
        BusinessPresenter businessPresenter = new BusinessPresenter();
        this.f39533b = businessPresenter;
        businessPresenter.setBusinessCategoryListener(this.f39532a);
        return businessPresenter;
    }

    public boolean onBack() {
        ((BusinessPresenter) getPresenter()).onBack(1);
        return true;
    }

    public void setOnPlayAnimationListener(OnPlayAddToCartAnimation onPlayAddToCartAnimation) {
        this.f39534c = onPlayAddToCartAnimation;
    }
}
