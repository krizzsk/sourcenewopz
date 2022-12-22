package com.didi.soda.business.component.search;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.business.listener.RecommendWordListener;

public abstract class AbBusinessHotWordComponent<V extends IView, P extends IPresenter> extends MvpComponent<V, P> {
    public abstract void setRecommendWordListener(RecommendWordListener recommendWordListener);

    public AbBusinessHotWordComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }
}
