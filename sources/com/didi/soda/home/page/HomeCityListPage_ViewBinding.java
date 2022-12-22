package com.didi.soda.home.page;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class HomeCityListPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeCityListPage f42699a;

    public HomeCityListPage_ViewBinding(HomeCityListPage homeCityListPage, View view) {
        this.f42699a = homeCityListPage;
        homeCityListPage.mHomeFeedContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_city_list_container, "field 'mHomeFeedContainer'", FrameLayout.class);
    }

    public void unbind() {
        HomeCityListPage homeCityListPage = this.f42699a;
        if (homeCityListPage != null) {
            this.f42699a = null;
            homeCityListPage.mHomeFeedContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
