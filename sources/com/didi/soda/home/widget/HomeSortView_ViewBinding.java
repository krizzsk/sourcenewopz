package com.didi.soda.home.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class HomeSortView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeSortView f43298a;

    public HomeSortView_ViewBinding(HomeSortView homeSortView) {
        this(homeSortView, homeSortView);
    }

    public HomeSortView_ViewBinding(HomeSortView homeSortView, View view) {
        this.f43298a = homeSortView;
        homeSortView.mRecommendView = Utils.findRequiredView(view, R.id.rl_home_sort_recommend, "field 'mRecommendView'");
        homeSortView.mPriceView = Utils.findRequiredView(view, R.id.rl_home_sort_price, "field 'mPriceView'");
        homeSortView.mTimeView = Utils.findRequiredView(view, R.id.rl_home_sort_time, "field 'mTimeView'");
        homeSortView.mRecommendLine = Utils.findRequiredView(view, R.id.v_home_sort_recommend, "field 'mRecommendLine'");
        homeSortView.mPriceLine = Utils.findRequiredView(view, R.id.v_home_sort_price, "field 'mPriceLine'");
        homeSortView.mTimeLine = Utils.findRequiredView(view, R.id.v_home_sort_time, "field 'mTimeLine'");
        homeSortView.mRecommendTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_sort_recommend, "field 'mRecommendTv'", TextView.class);
        homeSortView.mPriceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_sort_price, "field 'mPriceTv'", TextView.class);
        homeSortView.mTimeTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_sort_time, "field 'mTimeTv'", TextView.class);
    }

    public void unbind() {
        HomeSortView homeSortView = this.f43298a;
        if (homeSortView != null) {
            this.f43298a = null;
            homeSortView.mRecommendView = null;
            homeSortView.mPriceView = null;
            homeSortView.mTimeView = null;
            homeSortView.mRecommendLine = null;
            homeSortView.mPriceLine = null;
            homeSortView.mTimeLine = null;
            homeSortView.mRecommendTv = null;
            homeSortView.mPriceTv = null;
            homeSortView.mTimeTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
