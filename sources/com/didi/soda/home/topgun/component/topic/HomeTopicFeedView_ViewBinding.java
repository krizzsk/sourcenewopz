package com.didi.soda.home.topgun.component.topic;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class HomeTopicFeedView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeTopicFeedView f42883a;

    public HomeTopicFeedView_ViewBinding(HomeTopicFeedView homeTopicFeedView, View view) {
        this.f42883a = homeTopicFeedView;
        homeTopicFeedView.mBackIv = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_topic_home_close, "field 'mBackIv'", IconTextView.class);
        homeTopicFeedView.mTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_topic_title_bar, "field 'mTitleTv'", TextView.class);
        homeTopicFeedView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_topic_feed, "field 'mRecyclerView'", NovaRecyclerView.class);
    }

    public void unbind() {
        HomeTopicFeedView homeTopicFeedView = this.f42883a;
        if (homeTopicFeedView != null) {
            this.f42883a = null;
            homeTopicFeedView.mBackIv = null;
            homeTopicFeedView.mTitleTv = null;
            homeTopicFeedView.mRecyclerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
