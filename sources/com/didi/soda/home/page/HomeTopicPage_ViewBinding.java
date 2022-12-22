package com.didi.soda.home.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class HomeTopicPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeTopicPage f42701a;

    public HomeTopicPage_ViewBinding(HomeTopicPage homeTopicPage, View view) {
        this.f42701a = homeTopicPage;
        homeTopicPage.mHomeTopicFeedContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_topic_feed_container, "field 'mHomeTopicFeedContainer'", FrameLayout.class);
    }

    public void unbind() {
        HomeTopicPage homeTopicPage = this.f42701a;
        if (homeTopicPage != null) {
            this.f42701a = null;
            homeTopicPage.mHomeTopicFeedContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
