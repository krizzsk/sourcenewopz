package com.didi.soda.home.topgun.component.topic;

import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;

interface Contract {

    public static abstract class AbsHomeTopicFeedPresenter extends CustomerRecyclerPresenter<AbsHomeTopicFeedView> implements INovaRecyclerView.LoadMoreListener {
        /* access modifiers changed from: package-private */
        public abstract void onClickBack();
    }

    public static abstract class AbsHomeTopicFeedView extends CustomerRecyclerView<AbsHomeTopicFeedPresenter> {
        public abstract int calculateAbnormalHeight();

        public abstract void dismissLoadingDialog();

        public abstract void scrollToTop();

        public abstract void showLoadingView();

        public abstract void showNetErrorToast();

        public abstract void updateTitle(String str);
    }
}
