package com.didi.soda.home.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.home.topgun.component.topic.HomeTopicFeedComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route(interceptors = {HomeTopicPageInterceptor.class}, value = {"topicPage"})
public class HomeTopicPage extends CustomerPage {
    @BindView(18167)
    FrameLayout mHomeTopicFeedContainer;

    public HomeTopicPage() {
        DiRouter.registerHub(RoutePath.TOPIC_PAGE, this);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_topic, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        addComponent(new HomeTopicFeedComponent(this.mHomeTopicFeedContainer));
    }
}
