package com.didi.soda.home.topgun.widget;

import android.content.Context;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.BaseBusinessItemView;

public class HomeBusinessItemView extends BaseBusinessItemView {
    public HomeBusinessItemView(Context context) {
        super(context);
    }

    public void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinder.HomeBusinessItemBinderLogic homeBusinessItemBinderLogic) {
        super.bindData(homeBusinessInfoRvModel, new BaseBusinessItemView.BusinessItemViewInterface() {
            public final void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
                HomeBusinessItemBinder.HomeBusinessItemBinderLogic.this.onItemClick(homeBusinessInfoRvModel);
            }
        });
    }
}
