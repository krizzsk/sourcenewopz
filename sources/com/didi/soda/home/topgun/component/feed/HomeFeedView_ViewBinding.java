package com.didi.soda.home.topgun.component.feed;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.home.topgun.widget.FeedHeaderLayout;
import com.didi.soda.home.topgun.widget.HomeAddressTipView;
import com.didi.soda.home.topgun.widget.floatlayout.FloatLayout;
import com.taxis99.R;

public class HomeFeedView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeFeedView f42824a;

    public HomeFeedView_ViewBinding(HomeFeedView homeFeedView, View view) {
        this.f42824a = homeFeedView;
        homeFeedView.mHomeFeedContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_feed_container, "field 'mHomeFeedContainer'", FrameLayout.class);
        homeFeedView.mRefreshLayout = (NovaPullRefreshLayout) Utils.findRequiredViewAsType(view, R.id.customer_prl_pull_refresh, "field 'mRefreshLayout'", NovaPullRefreshLayout.class);
        homeFeedView.mRecycleView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_home_main, "field 'mRecycleView'", NovaRecyclerView.class);
        homeFeedView.mHomeAddressTipView = (HomeAddressTipView) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_tip_container, "field 'mHomeAddressTipView'", HomeAddressTipView.class);
        homeFeedView.mHomeShimmerContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_shimmer_container, "field 'mHomeShimmerContainer'", FrameLayout.class);
        homeFeedView.mHomeShimmerContainerParent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_shimmer, "field 'mHomeShimmerContainerParent'", LinearLayout.class);
        homeFeedView.mFloatLayout = (FloatLayout) Utils.findRequiredViewAsType(view, R.id.customer_home_recycle_float, "field 'mFloatLayout'", FloatLayout.class);
        homeFeedView.mFeedHeaderLayout = (FeedHeaderLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_header_bg_layout, "field 'mFeedHeaderLayout'", FeedHeaderLayout.class);
    }

    public void unbind() {
        HomeFeedView homeFeedView = this.f42824a;
        if (homeFeedView != null) {
            this.f42824a = null;
            homeFeedView.mHomeFeedContainer = null;
            homeFeedView.mRefreshLayout = null;
            homeFeedView.mRecycleView = null;
            homeFeedView.mHomeAddressTipView = null;
            homeFeedView.mHomeShimmerContainer = null;
            homeFeedView.mHomeShimmerContainerParent = null;
            homeFeedView.mFloatLayout = null;
            homeFeedView.mFeedHeaderLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
