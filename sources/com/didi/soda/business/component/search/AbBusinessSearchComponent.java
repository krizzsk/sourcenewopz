package com.didi.soda.business.component.search;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.business.listener.BusinessSearchChangeListener;
import com.didi.soda.business.listener.RecommendWordListener;
import com.didi.soda.customer.listener.OnPlayAddToCartAnimation;

public abstract class AbBusinessSearchComponent<V extends IView, P extends IPresenter> extends MvpComponent<V, P> implements RecommendWordListener {
    public abstract void goBack();

    public abstract void onPageResult(Bundle bundle);

    public abstract void setBusinessSearchChangeListener(BusinessSearchChangeListener businessSearchChangeListener);

    public abstract void setOnPlayAddToCartAnimation(OnPlayAddToCartAnimation onPlayAddToCartAnimation);

    public AbBusinessSearchComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }
}
