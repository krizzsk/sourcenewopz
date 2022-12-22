package com.didi.component.comp_travel_detail_new;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.component.business.util.UiUtils;
import com.didi.component.comp_travel_detail_new.view.widget.RouteCardView;
import com.didi.travel.psnger.model.response.StationModel;
import java.util.List;

public abstract class AbsTravelDetailNewView implements ITravelDetailNewView {
    protected Context mContext;
    protected LinearLayout mRootView;
    protected AbsTravelDetailNewPresenter mXPanelPresenter;

    public AbsTravelDetailNewView(Context context) {
        this.mContext = context;
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.mRootView = linearLayout;
        linearLayout.setPadding(UiUtils.dip2px(this.mContext, 18.0f), UiUtils.dip2px(this.mContext, 20.0f), UiUtils.dip2px(this.mContext, 20.0f), UiUtils.dip2px(this.mContext, 20.0f));
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsTravelDetailNewPresenter absTravelDetailNewPresenter) {
        this.mXPanelPresenter = absTravelDetailNewPresenter;
    }

    public void bindData(List<StationModel> list) {
        if (list != null && list.size() != 0) {
            this.mRootView.removeAllViews();
            RouteCardView routeCardView = new RouteCardView(this.mContext);
            routeCardView.bindData(list);
            this.mRootView.addView(routeCardView);
        }
    }
}
