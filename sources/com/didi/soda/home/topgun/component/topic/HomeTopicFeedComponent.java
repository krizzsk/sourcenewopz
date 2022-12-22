package com.didi.soda.home.topgun.component.topic;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.home.topgun.component.topic.Contract;

public class HomeTopicFeedComponent extends MvpComponent<Contract.AbsHomeTopicFeedView, Contract.AbsHomeTopicFeedPresenter> {
    public HomeTopicFeedComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsHomeTopicFeedView onCreateView() {
        return new HomeTopicFeedView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsHomeTopicFeedPresenter onCreatePresenter() {
        return new HomeTopicFeedPresenter();
    }
}
