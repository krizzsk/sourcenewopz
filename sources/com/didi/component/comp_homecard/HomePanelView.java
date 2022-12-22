package com.didi.component.comp_homecard;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.component.business.commonlist.AbsCommonListView;
import com.taxis99.R;

public class HomePanelView extends AbsCommonListView {
    public int getRootLayout() {
        return R.layout.home_panel_list_layout;
    }

    public HomePanelView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }
}
